# PORT-COACTUPC: port COACTUPC (cobol, `app/cbl/COACTUPC.cbl`, 4237 lines)

**Port order 29 of 44** -- 1 program(s) and job(s) call it, blast radius 3.363 ([port_order.md](port_order.md)).

Fill `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java` (CoactupcService); return it as `port/service/CoactupcService.java`.

## Methods to port

- `public void runTask(CicsTask task)`

The proof runs the port through `public void runTask(CicsTask task)` only.

Leave as generated (no proof runs them; port nothing into them):

- `public void commitPointL952()`
- `public void onAbendL862(CicsAbendException e)`

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
| 880 | IF | `EIBCALEN = 0 OR(CDEMO-FROM-PROGRAM=LIT-MENUPGMANDNOTCDEMO-PGM-REENTER)` | unknown / numeric | operand class unresolved: check by hand |
| 930 | IF | `CDEMO-FROM-TRANID = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-TRANID, LOW-VALUES)` |
| 931 | IF | `CDEMO-FROM-TRANID = SPACES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-TRANID, SPACES)` |
| 937 | IF | `CDEMO-FROM-PROGRAM = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-PROGRAM, LOW-VALUES)` |
| 938 | IF | `CDEMO-FROM-PROGRAM = SPACES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-PROGRAM, SPACES)` |
| 966 | EVALUATE WHEN | `CDEMO-FROM-PROGRAM = LIT-MENUPGM` | alphanumeric / alphanumeric | `CobolCompare.eq(CDEMO-FROM-PROGRAM, LIT-MENUPGM)` |
| 1051 | IF | `ACCTSIDI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACCTSIDI OF CACTUPAI, '*')` |
| 1052 | IF | `ACCTSIDI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACCTSIDI OF CACTUPAI, SPACES)` |
| 1065 | IF | `ACSTTUSI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSTTUSI OF CACTUPAI, '*')` |
| 1066 | IF | `ACSTTUSI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSTTUSI OF CACTUPAI, SPACES)` |
| 1073 | IF | `ACRDLIMI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACRDLIMI OF CACTUPAI, '*')` |
| 1074 | IF | `ACRDLIMI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACRDLIMI OF CACTUPAI, SPACES)` |
| 1078 | IF | `FUNCTION TEST-NUMVAL-C(ACUP-NEW-CREDIT-LIMIT-X) = 0` | function / numeric | operand class unresolved: check by hand |
| 1087 | IF | `ACSHLIMI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSHLIMI OF CACTUPAI, '*')` |
| 1088 | IF | `ACSHLIMI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSHLIMI OF CACTUPAI, SPACES)` |
| 1092 | IF | `FUNCTION TEST-NUMVAL-C(ACUP-NEW-CASH-CREDIT-LIMIT-X) = 0` | function / numeric | operand class unresolved: check by hand |
| 1101 | IF | `ACURBALI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACURBALI OF CACTUPAI, '*')` |
| 1102 | IF | `ACURBALI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACURBALI OF CACTUPAI, SPACES)` |
| 1106 | IF | `FUNCTION TEST-NUMVAL-C(ACUP-NEW-CURR-BAL-X) = 0` | function / numeric | operand class unresolved: check by hand |
| 1115 | IF | `ACRCYCRI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACRCYCRI OF CACTUPAI, '*')` |
| 1116 | IF | `ACRCYCRI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACRCYCRI OF CACTUPAI, SPACES)` |
| 1120 | IF | `FUNCTION TEST-NUMVAL-C(ACUP-NEW-CURR-CYC-CREDIT-X) = 0` | function / numeric | operand class unresolved: check by hand |
| 1129 | IF | `ACRCYDBI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACRCYDBI OF CACTUPAI, '*')` |
| 1130 | IF | `ACRCYDBI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACRCYDBI OF CACTUPAI, SPACES)` |
| 1134 | IF | `FUNCTION TEST-NUMVAL-C(ACUP-NEW-CURR-CYC-DEBIT-X) = 0` | function / numeric | operand class unresolved: check by hand |
| 1144 | IF | `OPNYEARI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(OPNYEARI OF CACTUPAI, '*')` |
| 1145 | IF | `OPNYEARI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(OPNYEARI OF CACTUPAI, SPACES)` |
| 1151 | IF | `OPNMONI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(OPNMONI OF CACTUPAI, '*')` |
| 1152 | IF | `OPNMONI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(OPNMONI OF CACTUPAI, SPACES)` |
| 1158 | IF | `OPNDAYI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(OPNDAYI OF CACTUPAI, '*')` |
| 1159 | IF | `OPNDAYI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(OPNDAYI OF CACTUPAI, SPACES)` |
| 1167 | IF | `EXPYEARI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(EXPYEARI OF CACTUPAI, '*')` |
| 1168 | IF | `EXPYEARI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(EXPYEARI OF CACTUPAI, SPACES)` |
| 1174 | IF | `EXPMONI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(EXPMONI OF CACTUPAI, '*')` |
| 1175 | IF | `EXPMONI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(EXPMONI OF CACTUPAI, SPACES)` |
| 1181 | IF | `EXPDAYI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(EXPDAYI OF CACTUPAI, '*')` |
| 1182 | IF | `EXPDAYI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(EXPDAYI OF CACTUPAI, SPACES)` |
| 1190 | IF | `RISYEARI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(RISYEARI OF CACTUPAI, '*')` |
| 1191 | IF | `RISYEARI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(RISYEARI OF CACTUPAI, SPACES)` |
| 1197 | IF | `RISMONI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(RISMONI OF CACTUPAI, '*')` |
| 1198 | IF | `RISMONI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(RISMONI OF CACTUPAI, SPACES)` |
| 1204 | IF | `RISDAYI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(RISDAYI OF CACTUPAI, '*')` |
| 1205 | IF | `RISDAYI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(RISDAYI OF CACTUPAI, SPACES)` |
| 1213 | IF | `AADDGRPI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(AADDGRPI OF CACTUPAI, '*')` |
| 1214 | IF | `AADDGRPI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(AADDGRPI OF CACTUPAI, SPACES)` |
| 1224 | IF | `ACSTNUMI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSTNUMI OF CACTUPAI, '*')` |
| 1225 | IF | `ACSTNUMI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSTNUMI OF CACTUPAI, SPACES)` |
| 1233 | IF | `ACTSSN1I OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACTSSN1I OF CACTUPAI, '*')` |
| 1234 | IF | `ACTSSN1I OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACTSSN1I OF CACTUPAI, SPACES)` |
| 1240 | IF | `ACTSSN2I OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACTSSN2I OF CACTUPAI, '*')` |
| 1241 | IF | `ACTSSN2I OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACTSSN2I OF CACTUPAI, SPACES)` |
| 1247 | IF | `ACTSSN3I OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACTSSN3I OF CACTUPAI, '*')` |
| 1248 | IF | `ACTSSN3I OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACTSSN3I OF CACTUPAI, SPACES)` |
| 1256 | IF | `DOBYEARI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(DOBYEARI OF CACTUPAI, '*')` |
| 1257 | IF | `DOBYEARI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(DOBYEARI OF CACTUPAI, SPACES)` |
| 1263 | IF | `DOBMONI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(DOBMONI OF CACTUPAI, '*')` |
| 1264 | IF | `DOBMONI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(DOBMONI OF CACTUPAI, SPACES)` |
| 1270 | IF | `DOBDAYI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(DOBDAYI OF CACTUPAI, '*')` |
| 1271 | IF | `DOBDAYI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(DOBDAYI OF CACTUPAI, SPACES)` |
| 1279 | IF | `ACSTFCOI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSTFCOI OF CACTUPAI, '*')` |
| 1280 | IF | `ACSTFCOI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSTFCOI OF CACTUPAI, SPACES)` |
| 1288 | IF | `ACSFNAMI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSFNAMI OF CACTUPAI, '*')` |
| 1289 | IF | `ACSFNAMI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSFNAMI OF CACTUPAI, SPACES)` |
| 1297 | IF | `ACSMNAMI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSMNAMI OF CACTUPAI, '*')` |
| 1298 | IF | `ACSMNAMI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSMNAMI OF CACTUPAI, SPACES)` |
| 1306 | IF | `ACSLNAMI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSLNAMI OF CACTUPAI, '*')` |
| 1307 | IF | `ACSLNAMI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSLNAMI OF CACTUPAI, SPACES)` |
| 1315 | IF | `ACSADL1I OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSADL1I OF CACTUPAI, '*')` |
| 1316 | IF | `ACSADL1I OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSADL1I OF CACTUPAI, SPACES)` |
| 1322 | IF | `ACSADL2I OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSADL2I OF CACTUPAI, '*')` |
| 1323 | IF | `ACSADL2I OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSADL2I OF CACTUPAI, SPACES)` |
| 1329 | IF | `ACSCITYI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSCITYI OF CACTUPAI, '*')` |
| 1330 | IF | `ACSCITYI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSCITYI OF CACTUPAI, SPACES)` |
| 1336 | IF | `ACSSTTEI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSSTTEI OF CACTUPAI, '*')` |
| 1337 | IF | `ACSSTTEI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSSTTEI OF CACTUPAI, SPACES)` |
| 1343 | IF | `ACSCTRYI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSCTRYI OF CACTUPAI, '*')` |
| 1344 | IF | `ACSCTRYI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSCTRYI OF CACTUPAI, SPACES)` |
| 1350 | IF | `ACSZIPCI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSZIPCI OF CACTUPAI, '*')` |
| 1351 | IF | `ACSZIPCI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSZIPCI OF CACTUPAI, SPACES)` |
| 1357 | IF | `ACSPH1AI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSPH1AI OF CACTUPAI, '*')` |
| 1358 | IF | `ACSPH1AI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSPH1AI OF CACTUPAI, SPACES)` |
| 1364 | IF | `ACSPH1BI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSPH1BI OF CACTUPAI, '*')` |
| 1365 | IF | `ACSPH1BI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSPH1BI OF CACTUPAI, SPACES)` |
| 1371 | IF | `ACSPH1CI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSPH1CI OF CACTUPAI, '*')` |
| 1372 | IF | `ACSPH1CI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSPH1CI OF CACTUPAI, SPACES)` |
| 1378 | IF | `ACSPH2AI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSPH2AI OF CACTUPAI, '*')` |
| 1379 | IF | `ACSPH2AI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSPH2AI OF CACTUPAI, SPACES)` |
| 1385 | IF | `ACSPH2BI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSPH2BI OF CACTUPAI, '*')` |
| 1386 | IF | `ACSPH2BI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSPH2BI OF CACTUPAI, SPACES)` |
| 1392 | IF | `ACSPH2CI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSPH2CI OF CACTUPAI, '*')` |
| 1393 | IF | `ACSPH2CI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSPH2CI OF CACTUPAI, SPACES)` |
| 1401 | IF | `ACSGOVTI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSGOVTI OF CACTUPAI, '*')` |
| 1402 | IF | `ACSGOVTI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSGOVTI OF CACTUPAI, SPACES)` |
| 1410 | IF | `ACSEFTCI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSEFTCI OF CACTUPAI, '*')` |
| 1411 | IF | `ACSEFTCI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSEFTCI OF CACTUPAI, SPACES)` |
| 1419 | IF | `ACSPFLGI OF CACTUPAI = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(ACSPFLGI OF CACTUPAI, '*')` |
| 1420 | IF | `ACSPFLGI OF CACTUPAI = SPACES` | alphanumeric / figurative | `CobolCompare.eq(ACSPFLGI OF CACTUPAI, SPACES)` |
| 1684 | IF | `ACUP-NEW-ACCT-ID-X = ACUP-OLD-ACCT-ID-X` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-ACCT-ID-X, ACUP-OLD-ACCT-ID-X)` |
| 1685 | IF | `FUNCTION UPPER-CASE(ACUP-NEW-ACTIVE-STATUS) = FUNCTION UPPER-CASE(ACUP-OLD-ACTIVE-STATUS)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(ACUP-NEW-ACTIVE-STATUS), FUNCTION UPPER-CASE(ACUP-OLD-ACTIVE-STATUS))` |
| 1689 | IF | `ACUP-NEW-CURR-BAL = ACUP-OLD-CURR-BAL` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CURR-BAL, ACUP-OLD-CURR-BAL)` |
| 1690 | IF | `ACUP-NEW-CREDIT-LIMIT = ACUP-OLD-CREDIT-LIMIT` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CREDIT-LIMIT, ACUP-OLD-CREDIT-LIMIT)` |
| 1691 | IF | `ACUP-NEW-CASH-CREDIT-LIMIT = ACUP-OLD-CASH-CREDIT-LIMIT` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CASH-CREDIT-LIMIT, ACUP-OLD-CASH-CREDIT-LIMIT)` |
| 1692 | IF | `ACUP-NEW-OPEN-DATE = ACUP-OLD-OPEN-DATE` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-OPEN-DATE, ACUP-OLD-OPEN-DATE)` |
| 1693 | IF | `ACUP-NEW-EXPIRAION-DATE = ACUP-OLD-EXPIRAION-DATE` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-EXPIRAION-DATE, ACUP-OLD-EXPIRAION-DATE)` |
| 1694 | IF | `ACUP-NEW-REISSUE-DATE = ACUP-OLD-REISSUE-DATE` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-REISSUE-DATE, ACUP-OLD-REISSUE-DATE)` |
| 1695 | IF | `ACUP-NEW-CURR-CYC-CREDIT = ACUP-OLD-CURR-CYC-CREDIT` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CURR-CYC-CREDIT, ACUP-OLD-CURR-CYC-CREDIT)` |
| 1696 | IF | `ACUP-NEW-CURR-CYC-DEBIT = ACUP-OLD-CURR-CYC-DEBIT` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CURR-CYC-DEBIT, ACUP-OLD-CURR-CYC-DEBIT)` |
| 1697 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-GROUP-ID)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-GROUP-ID))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-GROUP-ID)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-GROUP-ID)))` |
| 1708 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ID-X)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ID-X))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ID-X)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ID-X)))` |
| 1712 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-FIRST-NAME)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-FIRST-NAME))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-FIRST-NAME)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-FIRST-NAME)))` |
| 1716 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-MIDDLE-NAME)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-MIDDLE-NAME))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-MIDDLE-NAME)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-MIDDLE-NAME)))` |
| 1720 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-LAST-NAME)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-LAST-NAME))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-LAST-NAME)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-LAST-NAME)))` |
| 1724 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-LINE-1)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-LINE-1))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-LINE-1)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-LINE-1)))` |
| 1728 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-LINE-2)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-LINE-2))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-LINE-2)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-LINE-2)))` |
| 1732 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-LINE-3)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-LINE-3))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-LINE-3)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-LINE-3)))` |
| 1736 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-STATE-CD)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-STATE-CD))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-STATE-CD)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-STATE-CD)))` |
| 1740 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-COUNTRY-CD)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-COUNTRY-CD))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-COUNTRY-CD)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-COUNTRY-CD)))` |
| 1744 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-ZIP)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-ZIP))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-ADDR-ZIP)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-ADDR-ZIP)))` |
| 1748 | IF | `ACUP-NEW-CUST-PHONE-NUM-1A = ACUP-OLD-CUST-PHONE-NUM-1A` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CUST-PHONE-NUM-1A, ACUP-OLD-CUST-PHONE-NUM-1A)` |
| 1749 | IF | `ACUP-NEW-CUST-PHONE-NUM-1B = ACUP-OLD-CUST-PHONE-NUM-1B` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CUST-PHONE-NUM-1B, ACUP-OLD-CUST-PHONE-NUM-1B)` |
| 1750 | IF | `ACUP-NEW-CUST-PHONE-NUM-1C = ACUP-OLD-CUST-PHONE-NUM-1C` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CUST-PHONE-NUM-1C, ACUP-OLD-CUST-PHONE-NUM-1C)` |
| 1751 | IF | `ACUP-NEW-CUST-PHONE-NUM-2A = ACUP-OLD-CUST-PHONE-NUM-2A` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CUST-PHONE-NUM-2A, ACUP-OLD-CUST-PHONE-NUM-2A)` |
| 1752 | IF | `ACUP-NEW-CUST-PHONE-NUM-2B = ACUP-OLD-CUST-PHONE-NUM-2B` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CUST-PHONE-NUM-2B, ACUP-OLD-CUST-PHONE-NUM-2B)` |
| 1753 | IF | `ACUP-NEW-CUST-PHONE-NUM-2C = ACUP-OLD-CUST-PHONE-NUM-2C` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CUST-PHONE-NUM-2C, ACUP-OLD-CUST-PHONE-NUM-2C)` |
| 1754 | IF | `ACUP-NEW-CUST-SSN-X = ACUP-OLD-CUST-SSN-X` | group / alphanumeric | `CobolCompare.eq(ACUP-NEW-CUST-SSN-X, ACUP-OLD-CUST-SSN-X)` |
| 1755 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-GOVT-ISSUED-ID)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-GOVT-ISSUED-ID))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-GOVT-ISSUED-ID)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-GOVT-ISSUED-ID)))` |
| 1759 | IF | `ACUP-NEW-CUST-DOB-YYYY-MM-DD = ACUP-OLD-CUST-DOB-YYYY-MM-DD` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CUST-DOB-YYYY-MM-DD, ACUP-OLD-CUST-DOB-YYYY-MM-DD)` |
| 1761 | IF | `ACUP-NEW-CUST-EFT-ACCOUNT-ID = ACUP-OLD-CUST-EFT-ACCOUNT-ID` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CUST-EFT-ACCOUNT-ID, ACUP-OLD-CUST-EFT-ACCOUNT-ID)` |
| 1763 | IF | `FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-PRI-HOLDER-IND)) = FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-PRI-HOLDER-IND))` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-NEW-CUST-PRI-HOLDER-IND)), FUNCTION UPPER-CASE(FUNCTIONTRIM(ACUP-OLD-CUST-PRI-HOLDER-IND)))` |
| 1767 | IF | `ACUP-NEW-CUST-FICO-SCORE-X = ACUP-OLD-CUST-FICO-SCORE-X` | alphanumeric / alphanumeric | `CobolCompare.eq(ACUP-NEW-CUST-FICO-SCORE-X, ACUP-OLD-CUST-FICO-SCORE-X)` |
| 1787 | IF | `CC-ACCT-ID = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(CC-ACCT-ID, LOW-VALUES)` |
| 1788 | IF | `CC-ACCT-ID = SPACES` | alphanumeric / figurative | `CobolCompare.eq(CC-ACCT-ID, SPACES)` |
| 1829 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), LOW-VALUES)` |
| 1831 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), SPACES)` |
| 1861 | IF | `WS-EDIT-YES-NO = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-YES-NO, LOW-VALUES)` |
| 1862 | IF | `WS-EDIT-YES-NO = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-YES-NO, SPACES)` |
| 1863 | IF | `WS-EDIT-YES-NO = ZEROS` | alphanumeric / zero | `CobolCompare.eq(WS-EDIT-YES-NO, ZEROS)` |
| 1903 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), LOW-VALUES)` |
| 1905 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), SPACES)` |
| 1960 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), LOW-VALUES)` |
| 1962 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), SPACES)` |
| 2017 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), LOW-VALUES)` |
| 2019 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), SPACES)` |
| 2066 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), LOW-VALUES)` |
| 2068 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), SPACES)` |
| 2114 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), LOW-VALUES)` |
| 2116 | IF | `WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH) = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-ALPHANUM-ONLY(1:WS-EDIT-ALPHANUM-LENGTH), SPACES)` |
| 2184 | IF | `WS-EDIT-SIGNED-NUMBER-9V2-X = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-SIGNED-NUMBER-9V2-X, LOW-VALUES)` |
| 2185 | IF | `WS-EDIT-SIGNED-NUMBER-9V2-X = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-SIGNED-NUMBER-9V2-X, SPACES)` |
| 2201 | IF | `FUNCTION TEST-NUMVAL-C(WS-EDIT-SIGNED-NUMBER-9V2-X) = 0` | function / numeric | operand class unresolved: check by hand |
| 2234 | IF | `WS-EDIT-US-PHONE-NUMA = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-US-PHONE-NUMA, SPACES)` |
| 2235 | IF | `WS-EDIT-US-PHONE-NUMA = LOW-VALUES ) AND(WS-EDIT-US-PHONE-NUMBEQUALSPACESORWS-EDIT-US-PHONE-NUMBEQUALLOW-VALUES) AND(WS-EDIT-US-PHONE-NUMAEQUALSPACESORWS-EDIT-US-PHONE-NUMCEQUALLOW-VALUES)` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-US-PHONE-NUMA, LOW-VALUES ) AND(WS-EDIT-US-PHONE-NUMBEQUALSPACESORWS-EDIT-US-PHONE-NUMBEQUALLOW-VALUES) AND(WS-EDIT-US-PHONE-NUMAEQUALSPACESORWS-EDIT-US-PHONE-NUMCEQUALLOW-VALUES))` |
| 2247 | IF | `WS-EDIT-US-PHONE-NUMA = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-US-PHONE-NUMA, SPACES)` |
| 2248 | IF | `WS-EDIT-US-PHONE-NUMA = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-US-PHONE-NUMA, LOW-VALUES)` |
| 2318 | IF | `WS-EDIT-US-PHONE-NUMB = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-US-PHONE-NUMB, SPACES)` |
| 2319 | IF | `WS-EDIT-US-PHONE-NUMB = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-US-PHONE-NUMB, LOW-VALUES)` |
| 2371 | IF | `WS-EDIT-US-PHONE-NUMC = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-US-PHONE-NUMC, SPACES)` |
| 2372 | IF | `WS-EDIT-US-PHONE-NUMC = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(WS-EDIT-US-PHONE-NUMC, LOW-VALUES)` |
| 2627 | IF | `CDEMO-FROM-TRANID = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-TRANID, LOW-VALUES)` |
| 2628 | IF | `CDEMO-FROM-TRANID = SPACES` | alphanumeric / figurative | `CobolCompare.eq(CDEMO-FROM-TRANID, SPACES)` |
| 3171 | IF | `CDEMO-LAST-MAPSET = LIT-CCLISTMAPSET` | alphanumeric / alphanumeric | `CobolCompare.eq(CDEMO-LAST-MAPSET, LIT-CCLISTMAPSET)` |
| 3665 | EVALUATE WHEN | `WS-RESP-CD = DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 3668 | EVALUATE WHEN | `WS-RESP-CD = DFHRESP(NOTFND)` | numeric / unknown | operand class unresolved: check by hand |
| 3714 | EVALUATE WHEN | `WS-RESP-CD = DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 3716 | EVALUATE WHEN | `WS-RESP-CD = DFHRESP(NOTFND)` | numeric / unknown | operand class unresolved: check by hand |
| 3764 | EVALUATE WHEN | `WS-RESP-CD = DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 3766 | EVALUATE WHEN | `WS-RESP-CD = DFHRESP(NOTFND)` | numeric / unknown | operand class unresolved: check by hand |
| 3907 | IF | `WS-RESP-CD = DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 3934 | IF | `WS-RESP-CD = DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 4076 | IF | `WS-RESP-CD = DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 4095 | IF | `WS-RESP-CD = DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 4115 | IF | `ACCT-ACTIVE-STATUS = ACUP-OLD-ACTIVE-STATUS` | alphanumeric / alphanumeric | `CobolCompare.eq(ACCT-ACTIVE-STATUS, ACUP-OLD-ACTIVE-STATUS)` |
| 4127 | IF | `ACCT-OPEN-DATE(1:4) = ACUP-OLD-OPEN-YEAR` | alphanumeric / alphanumeric | `CobolCompare.eq(ACCT-OPEN-DATE(1:4), ACUP-OLD-OPEN-YEAR)` |
| 4128 | IF | `ACCT-OPEN-DATE(6:2) = ACUP-OLD-OPEN-MON` | alphanumeric / alphanumeric | `CobolCompare.eq(ACCT-OPEN-DATE(6:2), ACUP-OLD-OPEN-MON)` |
| 4129 | IF | `ACCT-OPEN-DATE(9:2) = ACUP-OLD-OPEN-DAY` | alphanumeric / alphanumeric | `CobolCompare.eq(ACCT-OPEN-DATE(9:2), ACUP-OLD-OPEN-DAY)` |
| 4131 | IF | `ACCT-EXPIRAION-DATE(1:4) = ACUP-OLD-EXP-YEAR` | alphanumeric / alphanumeric | `CobolCompare.eq(ACCT-EXPIRAION-DATE(1:4), ACUP-OLD-EXP-YEAR)` |
| 4132 | IF | `ACCT-EXPIRAION-DATE(6:2) = ACUP-OLD-EXP-MON` | alphanumeric / alphanumeric | `CobolCompare.eq(ACCT-EXPIRAION-DATE(6:2), ACUP-OLD-EXP-MON)` |
| 4133 | IF | `ACCT-EXPIRAION-DATE(9:2) = ACUP-OLD-EXP-DAY` | alphanumeric / alphanumeric | `CobolCompare.eq(ACCT-EXPIRAION-DATE(9:2), ACUP-OLD-EXP-DAY)` |
| 4135 | IF | `ACCT-REISSUE-DATE(1:4) = ACUP-OLD-REISSUE-YEAR` | alphanumeric / alphanumeric | `CobolCompare.eq(ACCT-REISSUE-DATE(1:4), ACUP-OLD-REISSUE-YEAR)` |
| 4136 | IF | `ACCT-REISSUE-DATE(6:2) = ACUP-OLD-REISSUE-MON` | alphanumeric / alphanumeric | `CobolCompare.eq(ACCT-REISSUE-DATE(6:2), ACUP-OLD-REISSUE-MON)` |
| 4137 | IF | `ACCT-REISSUE-DATE(9:2) = ACUP-OLD-REISSUE-DAY` | alphanumeric / alphanumeric | `CobolCompare.eq(ACCT-REISSUE-DATE(9:2), ACUP-OLD-REISSUE-DAY)` |
| 4139 | IF | `FUNCTION LOWER-CASE(ACCT-GROUP-ID) = FUNCTION LOWER-CASE(ACUP-OLD-GROUP-ID)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION LOWER-CASE(ACCT-GROUP-ID), FUNCTION LOWER-CASE(ACUP-OLD-GROUP-ID))` |
| 4152 | IF | `FUNCTION UPPER-CASE(CUST-FIRST-NAME) = FUNCTION UPPER-CASE(ACUP-OLD-CUST-FIRST-NAME)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(CUST-FIRST-NAME), FUNCTION UPPER-CASE(ACUP-OLD-CUST-FIRST-NAME))` |
| 4154 | IF | `FUNCTION UPPER-CASE(CUST-MIDDLE-NAME) = FUNCTION UPPER-CASE(ACUP-OLD-CUST-MIDDLE-NAME)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(CUST-MIDDLE-NAME), FUNCTION UPPER-CASE(ACUP-OLD-CUST-MIDDLE-NAME))` |
| 4156 | IF | `FUNCTION UPPER-CASE(CUST-LAST-NAME) = FUNCTION UPPER-CASE(ACUP-OLD-CUST-LAST-NAME)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(CUST-LAST-NAME), FUNCTION UPPER-CASE(ACUP-OLD-CUST-LAST-NAME))` |
| 4158 | IF | `FUNCTION UPPER-CASE(CUST-ADDR-LINE-1) = FUNCTION UPPER-CASE(ACUP-OLD-CUST-ADDR-LINE-1)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(CUST-ADDR-LINE-1), FUNCTION UPPER-CASE(ACUP-OLD-CUST-ADDR-LINE-1))` |
| 4160 | IF | `FUNCTION UPPER-CASE(CUST-ADDR-LINE-2) = FUNCTION UPPER-CASE(ACUP-OLD-CUST-ADDR-LINE-2)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(CUST-ADDR-LINE-2), FUNCTION UPPER-CASE(ACUP-OLD-CUST-ADDR-LINE-2))` |
| 4162 | IF | `FUNCTION UPPER-CASE(CUST-ADDR-LINE-3) = FUNCTION UPPER-CASE(ACUP-OLD-CUST-ADDR-LINE-3)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(CUST-ADDR-LINE-3), FUNCTION UPPER-CASE(ACUP-OLD-CUST-ADDR-LINE-3))` |
| 4164 | IF | `FUNCTION UPPER-CASE(CUST-ADDR-STATE-CD) = FUNCTION UPPER-CASE(ACUP-OLD-CUST-ADDR-STATE-CD)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(CUST-ADDR-STATE-CD), FUNCTION UPPER-CASE(ACUP-OLD-CUST-ADDR-STATE-CD))` |
| 4166 | IF | `FUNCTION UPPER-CASE(CUST-ADDR-COUNTRY-CD) = FUNCTION UPPER-CASE(ACUP-OLD-CUST-ADDR-COUNTRY-CD)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(CUST-ADDR-COUNTRY-CD), FUNCTION UPPER-CASE(ACUP-OLD-CUST-ADDR-COUNTRY-CD))` |
| 4168 | IF | `CUST-ADDR-ZIP = ACUP-OLD-CUST-ADDR-ZIP` | alphanumeric / alphanumeric | `CobolCompare.eq(CUST-ADDR-ZIP, ACUP-OLD-CUST-ADDR-ZIP)` |
| 4169 | IF | `CUST-PHONE-NUM-1 = ACUP-OLD-CUST-PHONE-NUM-1` | alphanumeric / alphanumeric | `CobolCompare.eq(CUST-PHONE-NUM-1, ACUP-OLD-CUST-PHONE-NUM-1)` |
| 4170 | IF | `CUST-PHONE-NUM-2 = ACUP-OLD-CUST-PHONE-NUM-2` | alphanumeric / alphanumeric | `CobolCompare.eq(CUST-PHONE-NUM-2, ACUP-OLD-CUST-PHONE-NUM-2)` |
| 4172 | IF | `FUNCTION UPPER-CASE(CUST-GOVT-ISSUED-ID) = FUNCTION UPPER-CASE(ACUP-OLD-CUST-GOVT-ISSUED-ID)` | alphanumeric / alphanumeric | `CobolCompare.eq(FUNCTION UPPER-CASE(CUST-GOVT-ISSUED-ID), FUNCTION UPPER-CASE(ACUP-OLD-CUST-GOVT-ISSUED-ID))` |
| 4174 | IF | `CUST-DOB-YYYY-MM-DD(1:4) = ACUP-OLD-CUST-DOB-YYYY-MM-DD(1:4)` | alphanumeric / alphanumeric | `CobolCompare.eq(CUST-DOB-YYYY-MM-DD(1:4), ACUP-OLD-CUST-DOB-YYYY-MM-DD(1:4))` |
| 4176 | IF | `CUST-DOB-YYYY-MM-DD(6:2) = ACUP-OLD-CUST-DOB-YYYY-MM-DD(5:2)` | alphanumeric / alphanumeric | `CobolCompare.eq(CUST-DOB-YYYY-MM-DD(6:2), ACUP-OLD-CUST-DOB-YYYY-MM-DD(5:2))` |
| 4178 | IF | `CUST-DOB-YYYY-MM-DD(9:2) = ACUP-OLD-CUST-DOB-YYYY-MM-DD(7:2)` | alphanumeric / alphanumeric | `CobolCompare.eq(CUST-DOB-YYYY-MM-DD(9:2), ACUP-OLD-CUST-DOB-YYYY-MM-DD(7:2))` |
| 4181 | IF | `CUST-EFT-ACCOUNT-ID = ACUP-OLD-CUST-EFT-ACCOUNT-ID` | alphanumeric / alphanumeric | `CobolCompare.eq(CUST-EFT-ACCOUNT-ID, ACUP-OLD-CUST-EFT-ACCOUNT-ID)` |
| 4183 | IF | `CUST-PRI-CARD-HOLDER-IND = ACUP-OLD-CUST-PRI-HOLDER-IND` | alphanumeric / alphanumeric | `CobolCompare.eq(CUST-PRI-CARD-HOLDER-IND, ACUP-OLD-CUST-PRI-HOLDER-IND)` |
| 4205 | IF | `ABEND-MSG = LOW-VALUES` | alphanumeric / figurative | `CobolCompare.eq(ABEND-MSG, LOW-VALUES)` |

## Worklist items for this program

- **WL-0117** (transaction-split) `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:191`: split the transaction here
- **WL-0157** (business-logic) `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:111`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- **WL-0158** (business-logic) `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:117`: port the PROCEDURE DIVISION into this task
- **WL-0159** (business-logic) `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:208`: port paragraph ABEND-ROUTINE's logic

## Generated code it builds on

- `com.gitgalaxy.modernized.cics.CicsTask`
- `com.gitgalaxy.modernized.dto.contract.CoactupcCommarea`
- `com.gitgalaxy.modernized.dto.screen.CactupaScreen`
- `com.gitgalaxy.modernized.entity.vsam.AccountRecord`
- `com.gitgalaxy.modernized.entity.vsam.CardXrefRecord`
- `com.gitgalaxy.modernized.entity.vsam.CustomerRecord`
- `com.gitgalaxy.modernized.repository.vsam.AccountRecordRepository`
- `com.gitgalaxy.modernized.repository.vsam.CardXrefRecordRepository`
- `com.gitgalaxy.modernized.repository.vsam.CustomerRecordRepository`

## Verified facts

- **calls** (open): 2 facts
- **cics_file_lineage** (open): 3 facts
- **cics_resources** (open): 9 facts
- **commarea_contracts** (open): 2 facts
- **dynamic_call_targets** (open): 1 facts
- **entry_points** (open): 1 facts
- **entry_transactions** (open): 1 facts
- **error_handlers** (field-tested): 2 facts
- **interface** (open): 6 facts
- **navigation** (open): 4 facts
- **screen_bindings** (open): 2 facts
- **unchecked_responses** (field-tested): 3 facts
- **units_of_work** (field-tested): 2 facts
- **unresolved_calls** (open): 1 facts
- **uow_handlers** (field-tested): 15 facts

## Paragraphs

| paragraph | line | lines |
|---|---:|---:|
| 0000-MAIN | 859 | 147 |
| COMMON-RETURN | 1007 | 14 |
| 0000-MAIN-EXIT | 1021 | 3 |
| 1000-PROCESS-INPUTS | 1025 | 10 |
| 1000-PROCESS-INPUTS-EXIT | 1036 | 3 |
| 1100-RECEIVE-MAP | 1039 | 387 |
| 1100-RECEIVE-MAP-EXIT | 1426 | 3 |
| 1200-EDIT-MAP-INPUTS | 1429 | 248 |
| 1200-EDIT-MAP-INPUTS-EXIT | 1678 | 3 |
| 1205-COMPARE-OLD-NEW | 1681 | 95 |
| 1205-COMPARE-OLD-NEW-EXIT | 1777 | 3 |
| 1210-EDIT-ACCOUNT | 1783 | 36 |
| 1210-EDIT-ACCOUNT-EXIT | 1820 | 3 |
| 1215-EDIT-MANDATORY | 1824 | 28 |
| 1215-EDIT-MANDATORY-EXIT | 1852 | 3 |
| 1220-EDIT-YESNO | 1856 | 38 |
| 1220-EDIT-YESNO-EXIT | 1894 | 3 |
| 1225-EDIT-ALPHA-REQD | 1898 | 53 |
| 1225-EDIT-ALPHA-REQD-EXIT | 1951 | 3 |
| 1230-EDIT-ALPHANUM-REQD | 1955 | 54 |
| 1230-EDIT-ALPHANUM-REQD-EXIT | 2009 | 3 |
| 1235-EDIT-ALPHA-OPT | 2012 | 45 |
| 1235-EDIT-ALPHA-OPT-EXIT | 2057 | 3 |
| 1240-EDIT-ALPHANUM-OPT | 2061 | 44 |
| 1240-EDIT-ALPHANUM-OPT-EXIT | 2105 | 3 |
| 1245-EDIT-NUM-REQD | 2109 | 67 |
| 1245-EDIT-NUM-REQD-EXIT | 2176 | 3 |
| 1250-EDIT-SIGNED-9V2 | 2180 | 40 |
| 1250-EDIT-SIGNED-9V2-EXIT | 2221 | 3 |
| 1260-EDIT-US-PHONE-NUM | 2225 | 21 |
| EDIT-AREA-CODE | 2246 | 70 |
| EDIT-US-PHONE-PREFIX | 2316 | 53 |
| EDIT-US-PHONE-LINENUM | 2370 | 53 |
| EDIT-US-PHONE-EXIT | 2424 | 3 |
| 1260-EDIT-US-PHONE-NUM-EXIT | 2427 | 3 |
| 1265-EDIT-US-SSN | 2431 | 58 |
| 1265-EDIT-US-SSN-EXIT | 2489 | 3 |
| 1270-EDIT-US-STATE-CD | 2493 | 18 |
| 1270-EDIT-US-STATE-CD-EXIT | 2511 | 3 |
| 1275-EDIT-FICO-SCORE | 2514 | 17 |
| 1275-EDIT-FICO-SCORE-EXIT | 2531 | 3 |
| 1280-EDIT-US-STATE-ZIP-CD | 2536 | 22 |
| 1280-EDIT-US-STATE-ZIP-CD-EXIT | 2558 | 3 |
| 2000-DECIDE-ACTION | 2562 | 81 |
| 2000-DECIDE-ACTION-EXIT | 2643 | 3 |
| 3000-SEND-MAP | 2649 | 14 |
| 3000-SEND-MAP-EXIT | 2664 | 3 |
| 3100-SCREEN-INIT | 2668 | 25 |
| 3100-SCREEN-INIT-EXIT | 2694 | 3 |
| 3200-SETUP-SCREEN-VARS | 2698 | 29 |
| 3200-SETUP-SCREEN-VARS-EXIT | 2727 | 3 |
| 3201-SHOW-INITIAL-VALUES | 2731 | 51 |
| 3201-SHOW-INITIAL-VALUES-EXIT | 2783 | 3 |
| 3202-SHOW-ORIGINAL-VALUES | 2787 | 79 |
| 3202-SHOW-ORIGINAL-VALUES-EXIT | 2867 | 3 |
| 3203-SHOW-UPDATED-VALUES | 2870 | 80 |
| 3203-SHOW-UPDATED-VALUES-EXIT | 2951 | 3 |
| 3250-SETUP-INFOMSG | 2955 | 28 |
| 3250-SETUP-INFOMSG-EXIT | 2983 | 3 |
| 3300-SETUP-SCREEN-ATTRS | 2986 | 451 |
| 3300-SETUP-SCREEN-ATTRS-EXIT | 3437 | 3 |
| 3310-PROTECT-ALL-ATTRS | 3441 | 55 |
| 3310-PROTECT-ALL-ATTRS-EXIT | 3496 | 3 |
| 3320-UNPROTECT-FEW-ATTRS | 3500 | 62 |
| 3320-UNPROTECT-FEW-ATTRS-EXIT | 3562 | 3 |
| 3390-SETUP-INFOMSG-ATTRS | 3566 | 18 |
| 3390-SETUP-INFOMSG-ATTRS-EXIT | 3584 | 3 |
| 3400-SEND-SCREEN | 3589 | 14 |
| 3400-SEND-SCREEN-EXIT | 3603 | 3 |
| 9000-READ-ACCT | 3608 | 37 |
| 9000-READ-ACCT-EXIT | 3647 | 3 |
| 9200-GETCARDXREF-BYACCT | 3650 | 48 |
| 9200-GETCARDXREF-BYACCT-EXIT | 3698 | 3 |
| 9300-GETACCTDATA-BYACCT | 3701 | 47 |
| 9300-GETACCTDATA-BYACCT-EXIT | 3748 | 3 |
| 9400-GETCUSTDATA-BYCUST | 3752 | 45 |
| 9400-GETCUSTDATA-BYCUST-EXIT | 3797 | 3 |
| 9500-STORE-FETCHED-DATA | 3801 | 84 |
| 9500-STORE-FETCHED-DATA-EXIT | 3885 | 3 |
| 9600-WRITE-PROCESSING | 3888 | 217 |
| 9600-WRITE-PROCESSING-EXIT | 4105 | 3 |
| 9700-CHECK-CHANGE-IN-REC | 4109 | 84 |
| 9700-CHECK-CHANGE-IN-REC-EXIT | 4193 | 8 |
| ABEND-ROUTINE | 4203 | 23 |
| ABEND-ROUTINE-EXIT | 4226 | 8 |

## Deliverable

One complete Java file for src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java: the same package, class name and public method signatures, with runTask ported -- what the proof runs -- and helper methods it calls added; every other generated method left as generated (#4255).

The port is laid over the generated project as an overlay and proven by the equivalence harness (tests/tools/equivalence.py in GitGalaxy): the original runs under GnuCOBOL, the port on the same inputs, and every output record is compared field by field; a person approves the port with that report in hand.

## Source listings (numbered, columns 1-72)

- `app/cbl/COACTUPC.cbl`: [sources/app/cbl/COACTUPC.cbl.lst](sources/app/cbl/COACTUPC.cbl.lst)
- `app/cpy-bms/COACTUP.CPY`: [sources/app/cpy-bms/COACTUP.CPY.lst](sources/app/cpy-bms/COACTUP.CPY.lst)
- `app/cpy/COCOM01Y.cpy`: [sources/app/cpy/COCOM01Y.cpy.lst](sources/app/cpy/COCOM01Y.cpy.lst)
- `app/cpy/COTTL01Y.cpy`: [sources/app/cpy/COTTL01Y.cpy.lst](sources/app/cpy/COTTL01Y.cpy.lst)
- `app/cpy/CSDAT01Y.cpy`: [sources/app/cpy/CSDAT01Y.cpy.lst](sources/app/cpy/CSDAT01Y.cpy.lst)
- `app/cpy/CSLKPCDY.cpy`: [sources/app/cpy/CSLKPCDY.cpy.lst](sources/app/cpy/CSLKPCDY.cpy.lst)
- `app/cpy/CSMSG01Y.cpy`: [sources/app/cpy/CSMSG01Y.cpy.lst](sources/app/cpy/CSMSG01Y.cpy.lst)
- `app/cpy/CSMSG02Y.cpy`: [sources/app/cpy/CSMSG02Y.cpy.lst](sources/app/cpy/CSMSG02Y.cpy.lst)
- `app/cpy/CSSETATY.cpy`: [sources/app/cpy/CSSETATY.cpy.lst](sources/app/cpy/CSSETATY.cpy.lst)
- `app/cpy/CSSTRPFY.cpy`: [sources/app/cpy/CSSTRPFY.cpy.lst](sources/app/cpy/CSSTRPFY.cpy.lst)
- `app/cpy/CSUSR01Y.cpy`: [sources/app/cpy/CSUSR01Y.cpy.lst](sources/app/cpy/CSUSR01Y.cpy.lst)
- `app/cpy/CSUTLDPY.cpy`: [sources/app/cpy/CSUTLDPY.cpy.lst](sources/app/cpy/CSUTLDPY.cpy.lst)
- `app/cpy/CSUTLDWY.cpy`: [sources/app/cpy/CSUTLDWY.cpy.lst](sources/app/cpy/CSUTLDWY.cpy.lst)
- `app/cpy/CVACT01Y.cpy`: [sources/app/cpy/CVACT01Y.cpy.lst](sources/app/cpy/CVACT01Y.cpy.lst)
- `app/cpy/CVACT03Y.cpy`: [sources/app/cpy/CVACT03Y.cpy.lst](sources/app/cpy/CVACT03Y.cpy.lst)
- `app/cpy/CVCRD01Y.cpy`: [sources/app/cpy/CVCRD01Y.cpy.lst](sources/app/cpy/CVCRD01Y.cpy.lst)
- `app/cpy/CVCUS01Y.cpy`: [sources/app/cpy/CVCUS01Y.cpy.lst](sources/app/cpy/CVCUS01Y.cpy.lst)
