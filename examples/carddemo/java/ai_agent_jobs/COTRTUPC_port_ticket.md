# PORT-COTRTUPC: port COTRTUPC (cobol, `app/app-transaction-type-db2/cbl/COTRTUPC.cbl`, 1703 lines)

**Port order 4 of 44** -- 2 program(s) and job(s) call it, blast radius 4.863 ([port_order.md](port_order.md)).

Fill `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java` (CotrtupcService); return it as `port/service/CotrtupcService.java`.

## Methods to port

- `public void runTask(CicsTask task)`

The proof runs the port through `public void runTask(CicsTask task)` only.

Leave as generated (no proof runs them; port nothing into them):

- `public void commitPointL453()`
- `public void commitPointL1557()`
- `public void commitPointL1606()`
- `public void commitPointL1637()`
- `public void onAbendL348(CicsAbendException e)`

## Target configuration

```json
{
  "culture": {
    "currency": "auto",
    "db2_date_format": "iso",
    "decimal_point": "auto",
    "display_locale": "ROOT",
    "format_locale": "ROOT",
    "key_collation": "ebcdic",
    "overflow": "cobol",
    "rounding": "cobol",
    "zone": "UTC"
  },
  "data": {
    "bidi_layout": "auto",
    "code_page": "cp037",
    "dbcs_code_page": null,
    "record_charset": "latin-1"
  },
  "database": "postgresql",
  "integration": {
    "messaging": "in-memory",
    "remote_calls": "http"
  },
  "java": {
    "build_tool": "maven",
    "data_classes": "lombok",
    "dto_style": "class",
    "version": 17
  },
  "package": "com.gitgalaxy.modernized",
  "spring_boot": {
    "version": "3.2.4"
  },
  "ui": {
    "flavour": "none"
  }
}
```

## Porting rules

1. Deliver the whole port: every paragraph the ported method reaches, every screen field it sets, every file it reads. A partial port or a sketch is not proven: the equivalence harness compares every output.
2. Port the PROCEDURE DIVISION into the service's methods, paragraph by paragraph; name the paragraph each block ports in a comment, so the port can be reviewed against the source.
3. Keep COBOL's storage semantics: COMPUTE / ADD / SUBTRACT / MULTIPLY / DIVIDE without ROUNDED truncate decimals; a result too long for its PICTURE loses its high-order digits (ON SIZE ERROR aside); MOVE to a numeric field aligns on the decimal point and truncates both ends; MOVE to alphanumeric pads with spaces or truncates on the right. Use BigDecimal with RoundingMode.DOWN, never double, for PIC 9 / COMP-3 data.
4. ROUNDED (#3825) rounds half AWAY from zero: setScale(scale, RoundingMode.HALF_UP) -- 2.5 -> 3, -2.5 -> -3. Never HALF_EVEN (banker's rounding) and never Math.round (-2.5 -> -2). ROUNDED MODE maps one to one: NEAREST-EVEN HALF_EVEN, AWAY-FROM-ZERO UP, NEAREST-TOWARD-ZERO HALF_DOWN, TOWARD-GREATER CEILING, TOWARD-LESSER FLOOR, TRUNCATION DOWN. The ticket's `rounding` list names every rounding or SIZE ERROR statement with the RoundingMode of each target. Round the final result only: compute intermediates exactly (IBM's ARITH intermediates carry 18 or 31 digits; the equivalence harness is the oracle when a result differs).
5. Keep the program's behaviour, including what looks like a defect (an unreachable branch, a field never reset): the port is proven by comparing its outputs with the original's. Document each such spot with a comment naming the defect and the one-line fix; fixing it is a business decision, not a translation.
6. Use the generated code as it is: entities and their fromRecord / toRecord codecs, repositories, DTOs, the batch runtime (DatasetResolver, Dd), the other services. Do not edit generated files other than this service; do not invent calls, files, queues or tables the facts do not name.
7. An abend is `throw CobolAbend.user(abcode, why)` (the generated batch runtime; CALL 'CEE3ABD' USING ABCODE: the step ends ABEND Unnnn) -- never another exception; the step's RETURN-CODE is runBatch's return value.
8. A DISPLAY is `Sysout.display(...)` (DISPLAY ... WITH NO ADVANCING: `Sysout.displayNoAdvancing`), never a log line: SYSOUT is compared line by line with the COBOL's. Its text is exactly what IBM COBOL writes, the operands concatenated: a literal as written; an alphanumeric or group item as all its bytes, trailing spaces included (a group's numeric fields as stored: zoned digits, the sign overpunched); a numeric item -- DISPLAY, COMP or COMP-3, not edited, no SIGN SEPARATE -- as `Sysout.number(value, digits, scale, signed)`: its PICTURE digits zero-padded, no decimal point, the sign overpunched in the last digit when signed (PIC S9(3) holding -12 is `01K`); an edited item as its edited text.
9. Every file I/O statement of a batch program (OPEN, CLOSE, READ, READ NEXT, WRITE, REWRITE, DELETE, START) is ONE call to the generated CobolFiles, per file (its DD name), in the order the program runs them. open(dd) / open(dd, path, input) / close(dd[, action]) / write / rewrite / delete(dd, action) / start(dd, found) return the status String; read(dd, supplier) ("00" or "23") and readNext(dd, iterator) ("00" or "10") return a CobolFiles.Read<T> -- status() and record(), null unless found. Take the program's FILE STATUS logic -- IF <status> = '00', AT END, INVALID KEY, its error paragraphs -- from the status returned, exactly as the program does; never skip a statement the program runs (a read-ahead, a CLOSE) or add one it does not. The equivalence harness injects file faults through CobolFiles and through GnuCOBOL at the same statement, and proves the error paths too. A keyed (VSAM KSDS) file keeps its mainframe semantics: WRITE is writeKeyed(dd, () -> repo.existsById(key), () -> repo.save(r)) -- "22" when the key is on file, never save() over it -- and REWRITE is rewriteKeyed(dd, exists, save) ("23" when it is not). A record the program READs INTO its working storage is the program's own copy: keep Entity.fromRecord(read.toRecord(cs), cs), never the repository's managed entity, so a change that is not REWRITten is never saved; and a READ that fails without INVALID KEY / AT END leaves the previous record in place, as the program's storage does.
10. A sequential dataset is fixed-length records (RECFM=FB): write each record's toRecord(...) bytes back to back, with no line separators, to the file DatasetResolver.path(dd) names; read it the same way.
11. Decode and encode a numeric field held in record bytes or a text column (zoned with an overpunched sign, COMP-3, COMP) only through the generated CobolRecords (zoned / packed / binary and their put methods) or the entity codecs, never a hand-written decoder.
12. Record bytes -- every dataset, file and COMMAREA the program reads or writes -- are in the code page CobolRecords.charset() returns: the migration's declared data.record_charset, a deployment fact. Pass it wherever a record codec, CobolRecords method or String takes a Charset; never Charset.forName, StandardCharsets or a guessed EBCDIC page for record data (#4060).
13. Read a number from text (a screen field, FUNCTION NUMVAL, a PARM) only through CobolRecords.numval(text, decimalPoint), with ',' when the program codes DECIMAL-POINT IS COMMA; never Integer.parseInt or new BigDecimal(String), which accept Arabic-Indic, Devanagari and full-width digits that COBOL rejects (#3831).
14. Format a numeric-edited field (a display string mapped from a number, often for a screen or print line) only through CobolEdit.format(pic, value, decimalComma, currency), which honours the COBOL picture (Z, 9, ., ,, -, +, CR/DB, $/currency, B, 0, /, and floating $ / + / - strings) as the mainframe does; pass the CURRENCY SIGN string (e.g. 'INR ') as currency, and it replaces the PICTURE SYMBOL (#3933).
15. Format and case-map with Locale.ROOT (String.format(Locale.ROOT, ...), toUpperCase(Locale.ROOT)): the default locale prints other digits (Arabic, Devanagari) and maps case differently (Turkish).
16. Order and compare VSAM / DB2 keys by the source code page's bytes, as the mainframe does (lower case before upper, letters before digits): browse through the generated sort-key finders, and sort in Java with CobolRecords.sortKey(key, codePage), never by String.compareTo or the database's default collation (#3822).
17. Compare alphanumeric operands (PIC X / A items, group items, alphanumeric literals and figurative constants) in IF, EVALUATE, PERFORM UNTIL and SEARCH WHEN only through the generated CobolCompare (compare, eq, gt, ge, lt, le), never String.compareTo or equals: it compares the code page's bytes as the mainframe does -- lower case before upper, letters before digits, so IF CUST-ID > 'A' is true for '1001' -- and pads the shorter operand with spaces ('AB' = 'AB  '). HIGH-VALUES / LOW-VALUES are CobolCompare.highValues(n) / lowValues(n). A numeric comparison stays BigDecimal.compareTo. A program that declares PROGRAM COLLATING SEQUENCE compares by that alphabet instead: flag it in a TODO (#3986).
18. A CICS program is ported into runTask(CicsTask task), one task per call (#3754): EIBCALEN = 0 is !task.hasCommarea(), EIBCALEN is task.eibcalen() (#4009: null = the whole record), DFHCOMMAREA is task.commarea(<its DTO>.class), EIBAID is task.aid() (ENTER, CLEAR, PF1-PF24, PA1-PA3), EIBTRMID is task.termid(), EIBTIME / EIBDATE / ASKTIME are task.now() (the task's dispatch time on the region's virtual clock, #3989), RECEIVE MAP is task.receive(map, mapset, <its screen>.class) (empty = MAPFAIL), SEND MAP is task.sendMap(map, mapset, screen, subfields, options...) (#4001: the screen holds each <f>O; CicsTask.MapSubfields each <f>A / <f>C / <f>H as its EBCDIC byte and <f>L = -1 for the cursor), SEND TEXT / SEND is task.sendText(from, length, options...), RETURN TRANSID COMMAREA LENGTH is task.returnTransid(transid, commarea, length), XCTL is task.xctl, LINK is task.link, ABEND is task.abend -- in the order the program does them, and the task ends at RETURN / XCTL / ABEND. A file READ is task.read(file, () -> <the service's generated read method>): its resp() is NORMAL (0), NOTFND (13) when the read finds nothing, or a condition the equivalence harness injects (NOTOPEN, IOERR, DISABLED, ...), and its resp2(); port every arm of the program's RESP handling (EVALUATE WS-RESP-CD ... WHEN OTHER) from it (#4023 follow-up). READ ... UPDATE is task.readForUpdate(file, lookup) (it holds the record for a REWRITE); WRITE FILE RIDFLD FROM is task.write(file, <whether the key is already in the file>, () -> <save the new record>): DUPREC (14) when it is; REWRITE FILE FROM is task.rewrite(file, () -> <save the changed record>): INVREQ (16) without a held record; each returns the RESP, and the injected conditions apply as for a READ. SYNCPOINT is task.syncpoint() and SYNCPOINT ROLLBACK task.rollback(), which undoes the task's file changes: save every change through these calls only -- what each file holds after the task is compared with the COBOL's. DELETE FILE RIDFLD is task.delete(file, <whether the key is there>, () -> <delete it>) (NOTFND 13 when not); DELETE FILE without RIDFLD is task.deleteHeld(file, () -> <delete the held record>). A browse: STARTBR is task.startbr(file, <RIDFLD as text>, <EQUAL given>, () -> <the file's keys, in key order, as a NavigableSet<String>>) (NOTFND 13 when no key qualifies); READNEXT / READPREV are task.readnext(file, <RIDFLD as text>) / task.readprev(file, ...), whose Browsed holds the RESP (ENDFILE 20 past either end) and the key read -- set RIDFLD to it and look the record up by it; ENDBR is task.endbr(file). The task keeps the browse's position and CICS's repositioning rules (a READPREV right after a READNEXT reads the same record again): pass RIDFLD exactly as the program holds it. ASKTIME ABSTIME is task.asktime(); FORMATTIME is CicsTask.formatDate(abstime, "YYYYMMDD" (or the form given), <DATESEP>) and CicsTask.formatTime(abstime, <TIMESEP>). ASSIGN APPLID / SYSID are task.assignApplid() / task.assignSysid() (the region's identity: never a literal). WRITEQ TD QUEUE FROM is task.writeqTd(queue, <the record as text, its full LENGTH>), which returns the RESP (QIDERR 44 for a queue the CSD does not define). INQUIRE PROGRAM(p) is task.inquireProgram(p): its RESP (NORMAL 0, PGMIDERR 27). A screen field shows what the symbolic map's O field would hold: text as moved, an edited PICTURE formatted as COBOL formats it. A COMMAREA is the generated DTO of its record; an area no generated DTO describes (a plain PIC X(n) item) is passed as a String of its n characters, or a byte[] of its EBCDIC bytes (#3989).
19. CICS condition and abend handling (#3989): HANDLE CONDITION, IGNORE CONDITION, HANDLE AID and RESP are the program's own control flow -- port each transfer to its label as Java control flow. HANDLE ABEND LABEL is task.handleAbend(label) (CANCEL, RESET: handleAbendCancel / handleAbendReset), and PUSH / POP HANDLE are task.pushHandle() / popHandle() besides saving and restoring the program's own handler state. EXEC CICS ABEND is task.abend(abcode) and a condition that takes CICS's default action is task.abendOnCondition(condition): CicsTask searches the active abend exits from this program's level upward, as CICS does, records the ABEND, and returns the label to continue at when this program's own exit took it -- or null, and the program must then return from runTask at once. After task.link(...) returns, task.abendExit() is the label of this program's exit when an abend in a program below reached it (continue there), and task.ended() is true when the task was terminated (stop). Never throw an exception to model a CICS transfer: the services are @Transactional, so an exception out of one marks the whole task rollback-only.
20. Dates and times only through java.time -- LocalDate, LocalDateTime, LocalTime and DateTimeFormatter with Locale.ROOT, in the ISO chronology -- never Calendar.getInstance(), new GregorianCalendar(), SimpleDateFormat or WeekFields.of(Locale.getDefault()): a th_TH default locale gives Buddhist-era years (2569), ja_JP_JP the Japanese imperial calendar, and US week fields start on Sunday. FUNCTION DAY-OF-WEEK and ACCEPT ... FROM DAY-OF-WEEK are Monday = 1 ... Sunday = 7, which is DayOfWeek.getValue() (#3833).
21. Read the time only from the generated batch runtime's MainframeClock (now() for local, currentDate() for FUNCTION CURRENT-DATE) -- in a CICS task, from task.now() -- never from the system clock directly or ZoneId.systemDefault(): it is how a run is pinned to be compared with the original.
22. A DB2 DATE / TIME / TIMESTAMP fetched into, or bound from, a character host variable (a DCLGEN DATE is PIC X(10)) is in the DB2 subsystem's format, the target config's culture.db2_date_format -- eur 26.09.2026 and 14.30.05, usa 09/26/2026 and 02:30 PM, iso 2026-09-26 and 14.30.05, jis 2026-09-26 and 14:30:05 -- and a TIMESTAMP is 2026-09-26-14.30.05.000000: convert only through the generated Db2Dates (date / time / timestamp, parseDate / parseTime / parseTimestamp), never LocalDate.toString() or LocalDate.parse (#3828).
23. FUNCTION INTEGER-OF-DATE / INTEGER-OF-DAY count days from day 1 = 1601-01-01 under INTDATE(ANSI), the default, but from day 1 = 1582-10-15 under INTDATE(LILIAN) (the same date is 6653 higher); DATE-OF-INTEGER / DAY-OF-INTEGER invert the same count. Port as ChronoUnit.DAYS.between(dayZero, date) with dayZero 1600-12-31 (ANSI) or 1582-10-14 (LILIAN). The ticket's compiler_options are the program's CBL / PROCESS cards; options given by the compile step's PARM or the installation defaults are not seen there (#3828).
24. A fact whose field testing is not 'field-tested' is verified on reference estates but still being field-tested: where the source contradicts it, follow the source and say so in the port's notes.
25. The proof calls one method per program: runTask(CicsTask) for a CICS program, handleCall(...) for a CALLed one, runBatch(dds, parm) for a batch one -- the ticket's methods to port. Port all of the program's behaviour into that method and the private helpers it calls. Port nothing into the other generated methods -- execute<Program>, handleTransaction, handleLink, handleChannel, onAbendL<n>, onCondition<C>L<n>, dispatch<X>L<n>, submit<Map> / render<Map>, xctl<P> / link<P>, the generated readqTs / writeqTs / read / browse helpers -- even where their TODO asks: leave each body as generated and keep no second entry point. Code the proof never runs is not proven, and the porting loop lists every method the proof cannot reach that the port changed (#4255).

## Alphanumeric relation conditions

| line | context | condition | operands | call |
|---:|---|---|---|---|
| 366 | IF | `EIBCALEN = 0 OR(CDEMO-FROM-PROGRAM=LIT-ADMINPGMANDNOTCDEMO-PGM-REENTER) OR(CDEMO-FROM-PROGRAM=LIT-LISTTPGMANDNOTCDEMO-PGM-REENTER)` | unknown / numeric | operand class unresolved: check by hand |
| 413 | EVALUATE WHEN | `TTUP-OLD-DETAILS = LOW-VALUES` | group / figurative | `CobolCompare.eq(TTUP-OLD-DETAILS, LOW-VALUES)` |
| 414 | EVALUATE WHEN | `TTUP-OLD-DETAILS = SPACES` | group / figurative | `CobolCompare.eq(TTUP-OLD-DETAILS, SPACES)` |
| 431 | IF | `CDEMO-FROM-TRANID = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-TRANID, LOW-VALUES)` |
| 432 | IF | `CDEMO-FROM-TRANID = SPACES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-TRANID, SPACES)` |
| 438 | IF | `CDEMO-FROM-PROGRAM = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-PROGRAM, LOW-VALUES)` |
| 439 | IF | `CDEMO-FROM-PROGRAM = SPACES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-PROGRAM, SPACES)` |
| 466 | EVALUATE WHEN | `CDEMO-FROM-PROGRAM = LIT-ADMINPGM` | alphanumeric / alphanumeric | `CobolCompare.eq(CDEMO-FROM-PROGRAM, LIT-ADMINPGM)` |
| 468 | EVALUATE WHEN | `CDEMO-FROM-PROGRAM = LIT-LISTTPGM` | alphanumeric / alphanumeric | `CobolCompare.eq(CDEMO-FROM-PROGRAM, LIT-LISTTPGM)` |
| 656 | IF | `FUNCTION TRIM(TRTYPCDIOFCTRTUPAI) = TTUP-NEW-TTYP-TYPE` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION TRIM(TRTYPCDIOFCTRTUPAI), TTUP-NEW-TTYP-TYPE)` |
| 667 | IF | `TRTYPCDI OF CTRTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(TRTYPCDI OF CTRTUPAI, '*')` |
| 668 | IF | `TRTYPCDI OF CTRTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(TRTYPCDI OF CTRTUPAI, SPACES)` |
| 678 | IF | `TRTYDSCI OF CTRTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(TRTYDSCI OF CTRTUPAI, '*')` |
| 679 | IF | `TRTYDSCI OF CTRTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(TRTYDSCI OF CTRTUPAI, SPACES)` |
| 699 | IF | `FUNCTION TRIM(TRTYPCDIOFCTRTUPAI) = TTUP-NEW-TTYP-TYPE` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION TRIM(TRTYPCDIOFCTRTUPAI), TTUP-NEW-TTYP-TYPE)` |
| 786 | IF | `FUNCTION UPPER-CASE(TTUP-NEW-TTYP-TYPE) = FUNCTION UPPER-CASE(TTUP-OLD-TTYP-TYPE)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(TTUP-NEW-TTYP-TYPE), FUNCTION UPPER-CASE(TTUP-OLD-TTYP-TYPE))` |
| 790 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(TTUP-NEW-TTYP-TYPE-DESC)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(TTUP-OLD-TTYP-TYPE-DESC))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(TTUP-NEW-TTYP-TYPE-DESC)), FUNCTION UPPER-CASE(FUNCTIONTRIM(TTUP-OLD-TTYP-TYPE-DESC)))` |
| 854 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), LOW-VALUES)` |
| 856 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), SPACES)` |
| 912 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), LOW-VALUES)` |
| 914 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), SPACES)` |
| 934 | IF | `FUNCTION TEST-NUMVAL(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH)) = 0` | function / numeric | operand class unresolved: check by hand |
| 1067 | IF | `CDEMO-FROM-TRANID = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-TRANID, LOW-VALUES)` |
| 1068 | IF | `CDEMO-FROM-TRANID = SPACES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-TRANID, SPACES)` |
| 1487 | EVALUATE WHEN | `SQLCODE = ZERO` | unknown / zero | operand class unresolved: check by hand |
| 1489 | EVALUATE WHEN | `SQLCODE = +100` | unknown / numeric | operand class unresolved: check by hand |
| 1495 | EVALUATE WHEN | `SQLCODE < 0` | unknown / numeric | operand class unresolved: check by hand |
| 1556 | EVALUATE WHEN | `SQLCODE = ZERO` | unknown / zero | operand class unresolved: check by hand |
| 1558 | EVALUATE WHEN | `SQLCODE = +100` | unknown / numeric | operand class unresolved: check by hand |
| 1561 | EVALUATE WHEN | `SQLCODE = -911` | unknown / numeric | operand class unresolved: check by hand |
| 1567 | EVALUATE WHEN | `SQLCODE < 0` | unknown / numeric | operand class unresolved: check by hand |
| 1605 | EVALUATE WHEN | `SQLCODE = ZERO` | unknown / zero | operand class unresolved: check by hand |
| 1635 | EVALUATE WHEN | `SQLCODE = ZERO` | unknown / zero | operand class unresolved: check by hand |
| 1638 | EVALUATE WHEN | `SQLCODE = -532` | unknown / numeric | operand class unresolved: check by hand |
| 1677 | IF | `ABEND-MSG = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(ABEND-MSG, LOW-VALUES)` |

## Worklist items for this program

- **WL-0111** (transaction-split) `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:151`: split the transaction here
- **WL-0112** (transaction-split) `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:161`: split the transaction here
- **WL-0113** (transaction-split) `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:171`: split the transaction here
- **WL-0114** (transaction-split) `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:181`: split the transaction here
- **WL-0136** (business-logic) `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:94`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- **WL-0137** (business-logic) `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:100`: port the PROCEDURE DIVISION into this task
- **WL-0138** (business-logic) `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:190`: port paragraph ABEND-ROUTINE's logic

## Generated code it builds on

- `com.gitgalaxy.modernized.cics.CicsTask`
- `com.gitgalaxy.modernized.dto.contract.CotrtupcCommarea`
- `com.gitgalaxy.modernized.dto.screen.CtrtupaScreen`
- `com.gitgalaxy.modernized.repository.db2.TransactionTypeRepository`

## Verified facts

- **calls** (open): 2 facts
- **cics_resources** (open): 2 facts
- **commarea_contracts** (open): 3 facts
- **dynamic_call_targets** (open): 1 facts
- **entry_points** (open): 1 facts
- **entry_transactions** (open): 1 facts
- **error_handlers** (field-tested): 2 facts
- **interface** (open): 6 facts
- **navigation** (open): 5 facts
- **screen_bindings** (open): 2 facts
- **sql_statements** (open): 4 facts
- **sql_table_access** (open): 1 facts
- **unchecked_responses** (field-tested): 3 facts
- **units_of_work** (field-tested): 4 facts
- **unresolved_calls** (open): 1 facts
- **uow_handlers** (field-tested): 10 facts

## Paragraphs

| paragraph | line | lines |
|---|---:|---:|
| 0000-MAIN | 345 | 213 |
| COMMON-RETURN | 559 | 14 |
| 0000-MAIN-EXIT | 573 | 3 |
| 0001-CHECK-PFKEYS | 577 | 42 |
| 0001-CHECK-PFKEYS-EXIT | 621 | 3 |
| 1000-PROCESS-INPUTS | 625 | 12 |
| 1000-PROCESS-INPUTS-EXIT | 638 | 3 |
| 1100-RECEIVE-MAP | 641 | 8 |
| 1100-RECEIVE-MAP-EXIT | 649 | 2 |
| 1150-STORE-MAP-IN-NEW | 652 | 34 |
| 1150-STORE-MAP-IN-NEW-EXIT | 686 | 3 |
| 1200-EDIT-MAP-INPUTS | 689 | 89 |
| 1200-EDIT-MAP-INPUTS-EXIT | 779 | 3 |
| 1205-COMPARE-OLD-NEW | 783 | 30 |
| 1205-COMPARE-OLD-NEW-EXIT | 814 | 3 |
| 1210-EDIT-TRANTYPE | 820 | 24 |
| 1210-EDIT-TRANTYPE-EXIT | 845 | 3 |
| 1230-EDIT-ALPHANUM-REQD | 849 | 54 |
| 1230-EDIT-ALPHANUM-REQD-EXIT | 903 | 3 |
| 1245-EDIT-NUM-REQD | 907 | 67 |
| 1245-EDIT-NUM-REQD-EXIT | 974 | 3 |
| 2000-DECIDE-ACTION | 978 | 105 |
| 2000-DECIDE-ACTION-EXIT | 1083 | 3 |
| 3000-SEND-MAP | 1089 | 16 |
| 3000-SEND-MAP-EXIT | 1106 | 3 |
| 3100-SCREEN-INIT | 1110 | 25 |
| 3100-SCREEN-INIT-EXIT | 1136 | 3 |
| 3200-SETUP-SCREEN-VARS | 1140 | 32 |
| 3200-SETUP-SCREEN-VARS-EXIT | 1172 | 3 |
| 3201-SHOW-INITIAL-VALUES | 1176 | 4 |
| 3201-SHOW-INITIAL-VALUES-EXIT | 1181 | 3 |
| 3202-SHOW-ORIGINAL-VALUES | 1185 | 8 |
| 3202-SHOW-ORIGINAL-VALUES-EXIT | 1194 | 3 |
| 3203-SHOW-UPDATED-VALUES | 1197 | 5 |
| 3203-SHOW-UPDATED-VALUES-EXIT | 1203 | 3 |
| 3250-SETUP-INFOMSG | 1210 | 56 |
| 3250-SETUP-INFOMSG-EXIT | 1266 | 3 |
| 3300-SETUP-SCREEN-ATTRS | 1269 | 95 |
| 3300-SETUP-SCREEN-ATTRS-EXIT | 1364 | 3 |
| 3310-PROTECT-ALL-ATTRS | 1368 | 5 |
| 3310-PROTECT-ALL-ATTRS-EXIT | 1373 | 3 |
| 3320-UNPROTECT-FEW-ATTRS | 1377 | 5 |
| 3320-UNPROTECT-FEW-ATTRS-EXIT | 1382 | 3 |
| 3390-SETUP-INFOMSG-ATTRS | 1386 | 7 |
| 3390-SETUP-INFOMSG-ATTRS-EXIT | 1393 | 3 |
| 3391-SETUP-PFKEY-ATTRS | 1397 | 27 |
| 3391-SETUP-PFKEY-ATTRS-EXIT | 1424 | 3 |
| 3400-SEND-SCREEN | 1428 | 14 |
| 3400-SEND-SCREEN-EXIT | 1442 | 3 |
| 9000-READ-TRANTYPE | 1447 | 17 |
| 9000-READ-TRANTYPE-EXIT | 1466 | 3 |
| 9100-GET-TRANSACTION-TYPE | 1469 | 43 |
| 9100-GET-TRANSACTION-TYPE-EXIT | 1512 | 3 |
| 9500-STORE-FETCHED-DATA | 1517 | 11 |
| 9500-STORE-FETCHED-DATA-EXIT | 1528 | 3 |
| 9600-WRITE-PROCESSING | 1531 | 62 |
| 9600-WRITE-PROCESSING-EXIT | 1593 | 3 |
| 9700-INSERT-RECORD | 1596 | 25 |
| 9700-INSERT-RECORD-EXIT | 1621 | 3 |
| 9800-DELETE-PROCESSING | 1624 | 40 |
| 9800-DELETE-PROCESSING-EXIT | 1664 | 9 |
| ABEND-ROUTINE | 1675 | 24 |
| ABEND-ROUTINE-EXIT | 1699 | 3 |

## Deliverable

One complete Java file for src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java: the same package, class name and public method signatures, with runTask ported -- what the proof runs -- and helper methods it calls added; every other generated method left as generated (#4255).

The port is laid over the generated project as an overlay and proven by the equivalence harness (tests/tools/equivalence.py in GitGalaxy): the original runs under GnuCOBOL, the port on the same inputs, and every output record is compared field by field; a person approves the port with that report in hand.

## Source listings (numbered, columns 1-72)

- `app/app-transaction-type-db2/cbl/COTRTUPC.cbl`: [sources/app/app-transaction-type-db2/cbl/COTRTUPC.cbl.lst](sources/app/app-transaction-type-db2/cbl/COTRTUPC.cbl.lst)
- `app/app-transaction-type-db2/cpy-bms/COTRTUP.cpy`: [sources/app/app-transaction-type-db2/cpy-bms/COTRTUP.cpy.lst](sources/app/app-transaction-type-db2/cpy-bms/COTRTUP.cpy.lst)
- `app/app-transaction-type-db2/dcl/DCLTRCAT.dcl`: [sources/app/app-transaction-type-db2/dcl/DCLTRCAT.dcl.lst](sources/app/app-transaction-type-db2/dcl/DCLTRCAT.dcl.lst)
- `app/app-transaction-type-db2/dcl/DCLTRTYP.dcl`: [sources/app/app-transaction-type-db2/dcl/DCLTRTYP.dcl.lst](sources/app/app-transaction-type-db2/dcl/DCLTRTYP.dcl.lst)
- `app/cpy/COCOM01Y.cpy`: [sources/app/cpy/COCOM01Y.cpy.lst](sources/app/cpy/COCOM01Y.cpy.lst)
- `app/cpy/COTTL01Y.cpy`: [sources/app/cpy/COTTL01Y.cpy.lst](sources/app/cpy/COTTL01Y.cpy.lst)
- `app/cpy/CSDAT01Y.cpy`: [sources/app/cpy/CSDAT01Y.cpy.lst](sources/app/cpy/CSDAT01Y.cpy.lst)
- `app/cpy/CSMSG01Y.cpy`: [sources/app/cpy/CSMSG01Y.cpy.lst](sources/app/cpy/CSMSG01Y.cpy.lst)
- `app/cpy/CSMSG02Y.cpy`: [sources/app/cpy/CSMSG02Y.cpy.lst](sources/app/cpy/CSMSG02Y.cpy.lst)
- `app/cpy/CSSETATY.cpy`: [sources/app/cpy/CSSETATY.cpy.lst](sources/app/cpy/CSSETATY.cpy.lst)
- `app/cpy/CSSTRPFY.cpy`: [sources/app/cpy/CSSTRPFY.cpy.lst](sources/app/cpy/CSSTRPFY.cpy.lst)
- `app/cpy/CSUSR01Y.cpy`: [sources/app/cpy/CSUSR01Y.cpy.lst](sources/app/cpy/CSUSR01Y.cpy.lst)
- `app/cpy/CSUTLDWY.cpy`: [sources/app/cpy/CSUTLDWY.cpy.lst](sources/app/cpy/CSUTLDWY.cpy.lst)
- `app/cpy/CVCRD01Y.cpy`: [sources/app/cpy/CVCRD01Y.cpy.lst](sources/app/cpy/CVCRD01Y.cpy.lst)
