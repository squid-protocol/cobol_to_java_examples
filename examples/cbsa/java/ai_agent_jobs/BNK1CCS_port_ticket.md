# PORT-BNK1CCS: port BNK1CCS (cobol, `src/base/cobol_src/BNK1CCS.cbl`, 1660 lines)

**Port order 19 of 31** -- 0 program(s) and job(s) call it, blast radius 1.532 ([port_order.md](port_order.md)).

Fill `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java` (Bnk1ccsService); return it as `port/service/Bnk1ccsService.java`.

## Methods to port

- `public void runTask(CicsTask task)`

The proof runs the port through `public void runTask(CicsTask task)` only.

Leave as generated (no proof runs them; port nothing into them):

- `public void onAbendL161(CicsAbendException e)`

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
| 170 | EVALUATE WHEN | `EIBCALEN = ZERO` | unknown / zero | operand class unresolved: check by hand |
| 194 | EVALUATE WHEN | `EIBAID = DFHPA1` | unknown / unknown | operand class unresolved: check by hand |
| 200 | EVALUATE WHEN | `EIBAID = DFHPF3` | unknown / unknown | operand class unresolved: check by hand |
| 219 | EVALUATE WHEN | `EIBAID = DFHPF12` | unknown / unknown | operand class unresolved: check by hand |
| 235 | EVALUATE WHEN | `EIBAID = DFHCLEAR` | unknown / unknown | operand class unresolved: check by hand |
| 256 | EVALUATE WHEN | `EIBAID = DFHENTER` | unknown / unknown | operand class unresolved: check by hand |
| 284 | IF | `WS-CICS-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 404 | IF | `WS-UCTRANS = DFHVALUE(UCTRAN)` | numeric / unknown | operand class unresolved: check by hand |
| 405 | IF | `WS-UCTRANS = DFHVALUE(TRANIDONLY)` | numeric / unknown | operand class unresolved: check by hand |
| 415 | IF | `WS-CICS-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 510 | IF | `WS-CICS-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 581 | IF | `CUSTNO2L > 0` | unknown / numeric | operand class unresolved: check by hand |
| 589 | IF | `CUSTTITL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 589 | IF | `CUSTTITI = SPACES` | unknown / figurative | operand class unresolved: check by hand |
| 590 | IF | `CUSTTITI = LOW-VALUES` | unknown / figurative | operand class unresolved: check by hand |
| 604 | IF | `CUSTTITL > 0` | unknown / numeric | operand class unresolved: check by hand |
| 607 | EVALUATE WHEN | `CUSTTITI = 'MR________'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 610 | EVALUATE WHEN | `CUSTTITI = 'Mr________'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 613 | EVALUATE WHEN | `CUSTTITI = 'MR        '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 616 | EVALUATE WHEN | `CUSTTITI = 'Mr         '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 618 | EVALUATE WHEN | `CUSTTITI = 'mr________'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 621 | EVALUATE WHEN | `CUSTTITI = 'MRS_______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 624 | EVALUATE WHEN | `CUSTTITI = 'Mrs_______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 627 | EVALUATE WHEN | `CUSTTITI = 'MRS       '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 630 | EVALUATE WHEN | `CUSTTITI = 'Mrs       '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 632 | EVALUATE WHEN | `CUSTTITI = 'mrs_______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 635 | EVALUATE WHEN | `CUSTTITI = 'MISS______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 638 | EVALUATE WHEN | `CUSTTITI = 'Miss______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 641 | EVALUATE WHEN | `CUSTTITI = 'MISS      '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 644 | EVALUATE WHEN | `CUSTTITI = 'Miss      '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 647 | EVALUATE WHEN | `CUSTTITI = 'miss______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 650 | EVALUATE WHEN | `CUSTTITI = 'MS________'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 653 | EVALUATE WHEN | `CUSTTITI = 'Ms________'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 656 | EVALUATE WHEN | `CUSTTITI = 'ms________'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 659 | EVALUATE WHEN | `CUSTTITI = 'MS        '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 662 | EVALUATE WHEN | `CUSTTITI = 'Ms        '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 665 | EVALUATE WHEN | `CUSTTITI = 'ms        '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 668 | EVALUATE WHEN | `CUSTTITI = 'DR________'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 671 | EVALUATE WHEN | `CUSTTITI = 'Dr________'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 674 | EVALUATE WHEN | `CUSTTITI = 'DR        '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 677 | EVALUATE WHEN | `CUSTTITI = 'Dr        '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 680 | EVALUATE WHEN | `CUSTTITI = 'dr        '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 683 | EVALUATE WHEN | `CUSTTITI = 'dr________'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 686 | EVALUATE WHEN | `CUSTTITI = 'DRS_______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 689 | EVALUATE WHEN | `CUSTTITI = 'Drs_______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 692 | EVALUATE WHEN | `CUSTTITI = 'DRS       '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 695 | EVALUATE WHEN | `CUSTTITI = 'Drs       '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 698 | EVALUATE WHEN | `CUSTTITI = 'drs       '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 701 | EVALUATE WHEN | `CUSTTITI = 'drs_______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 704 | EVALUATE WHEN | `CUSTTITI = 'PROFESSOR_'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 707 | EVALUATE WHEN | `CUSTTITI = 'Professor_'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 710 | EVALUATE WHEN | `CUSTTITI = 'PROFESSOR '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 713 | EVALUATE WHEN | `CUSTTITI = 'Professor '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 716 | EVALUATE WHEN | `CUSTTITI = 'LORD______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 719 | EVALUATE WHEN | `CUSTTITI = 'Lord______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 722 | EVALUATE WHEN | `CUSTTITI = 'LORD      '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 725 | EVALUATE WHEN | `CUSTTITI = 'Lord      '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 728 | EVALUATE WHEN | `CUSTTITI = 'lord      '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 731 | EVALUATE WHEN | `CUSTTITI = 'lord______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 734 | EVALUATE WHEN | `CUSTTITI = 'LADY______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 737 | EVALUATE WHEN | `CUSTTITI = 'Lady______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 740 | EVALUATE WHEN | `CUSTTITI = 'LADY      '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 743 | EVALUATE WHEN | `CUSTTITI = 'Lady      '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 746 | EVALUATE WHEN | `CUSTTITI = 'lady      '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 749 | EVALUATE WHEN | `CUSTTITI = 'lady______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 752 | EVALUATE WHEN | `CUSTTITI = 'SIR_______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 755 | EVALUATE WHEN | `CUSTTITI = 'Sir_______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 758 | EVALUATE WHEN | `CUSTTITI = 'SIR       '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 761 | EVALUATE WHEN | `CUSTTITI = 'Sir       '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 764 | EVALUATE WHEN | `CUSTTITI = 'sir       '` | unknown / alphanumeric | operand class unresolved: check by hand |
| 767 | EVALUATE WHEN | `CUSTTITI = 'sir_______'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 783 | IF | `CHRISTNL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 783 | IF | `CHRISTNI = '____________________'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 784 | IF | `CHRISTNI = SPACES` | unknown / figurative | operand class unresolved: check by hand |
| 794 | IF | `CUSTSNL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 794 | IF | `CUSTSNI = '____________________'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 795 | IF | `CUSTSNI = SPACES` | unknown / figurative | operand class unresolved: check by hand |
| 805 | IF | `CUSTAD1I(1:1) = '_'` | alphanumeric / alphanumeric | `CobolCompare.eq(CUSTAD1I(1:1), '_')` |
| 805 | IF | `CUSTAD1L < 1` | unknown / numeric | operand class unresolved: check by hand |
| 806 | IF | `CUSTAD1I = SPACES` | unknown / figurative | operand class unresolved: check by hand |
| 816 | IF | `DOBDDL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 816 | IF | `DOBDDI = '__'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 826 | IF | `DOBMML < 1` | unknown / numeric | operand class unresolved: check by hand |
| 826 | IF | `DOBMMI = '__'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 836 | IF | `DOBYYL < 4` | unknown / numeric | operand class unresolved: check by hand |
| 836 | IF | `DOBYYI = '____'` | unknown / alphanumeric | operand class unresolved: check by hand |
| 899 | IF | `CUSTTITL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 899 | IF | `CHRISTNL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 899 | IF | `CUSTSNL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 900 | IF | `CUSTAD1L < 1` | unknown / numeric | operand class unresolved: check by hand |
| 900 | IF | `DOBDDL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 900 | IF | `DOBMML < 1` | unknown / numeric | operand class unresolved: check by hand |
| 901 | IF | `DOBYYL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 906 | EVALUATE WHEN | `CUSTTITL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 909 | EVALUATE WHEN | `CHRISTNL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 912 | EVALUATE WHEN | `CUSTSNL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 915 | EVALUATE WHEN | `CUSTAD1L < 1` | unknown / numeric | operand class unresolved: check by hand |
| 918 | EVALUATE WHEN | `DOBDDL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 921 | EVALUATE WHEN | `DOBMML < 1` | unknown / numeric | operand class unresolved: check by hand |
| 924 | EVALUATE WHEN | `DOBYYL < 1` | unknown / numeric | operand class unresolved: check by hand |
| 984 | IF | `WS-CICS-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 1048 | IF | `SUBPGM-SUCCESS = 'N'` | alphanumeric / alphanumeric | `CobolCompare.eq(SUBPGM-SUCCESS, 'N')` |
| 1052 | IF | `SUBPGM-FAIL-CODE = 'O'` | alphanumeric / alphanumeric | `CobolCompare.eq(SUBPGM-FAIL-CODE, 'O')` |
| 1056 | IF | `SUBPGM-FAIL-CODE = 'Y'` | alphanumeric / alphanumeric | `CobolCompare.eq(SUBPGM-FAIL-CODE, 'Y')` |
| 1060 | IF | `SUBPGM-FAIL-CODE = 'Z'` | alphanumeric / alphanumeric | `CobolCompare.eq(SUBPGM-FAIL-CODE, 'Z')` |
| 1067 | IF | `SUBPGM-SUCCESS = 'Y'` | alphanumeric / alphanumeric | `CobolCompare.eq(SUBPGM-SUCCESS, 'Y')` |
| 1122 | IF | `WS-UCTRANS = DFHVALUE(UCTRAN)` | numeric / unknown | operand class unresolved: check by hand |
| 1123 | IF | `WS-UCTRANS = DFHVALUE(TRANIDONLY)` | numeric / unknown | operand class unresolved: check by hand |
| 1134 | IF | `WS-CICS-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 1217 | IF | `WS-CICS-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 1295 | IF | `WS-CICS-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 1373 | IF | `WS-CICS-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 1451 | IF | `WS-CICS-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 1531 | IF | `WS-CICS-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |

## Compiler options (CBL / PROCESS cards)

| line | option | as written |
|---:|---|---|
| 1 | CICS | `CICS` |
| 1 | NODYNAM | `NODYNAM` |
| 1 | NSYMBOL(NATIONAL) | `NSYMBOL(NATIONAL)` |
| 1 | TRUNC(STD) | `TRUNC(STD)` |
| 2 | CICS('SP,EDF') | `CICS('SP,EDF')` |

## Worklist items for this program

- **WL-0104** (business-logic) `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:80`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- **WL-0105** (business-logic) `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:86`: port the PROCEDURE DIVISION into this task
- **WL-0106** (business-logic) `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:191`: port paragraph HANDLE-ABEND's logic

## Generated code it builds on

- `com.gitgalaxy.modernized.cics.CicsTask`
- `com.gitgalaxy.modernized.dto.contract.Bnk1ccsWsCommArea`
- `com.gitgalaxy.modernized.dto.contract.CrecustDfhcommarea`
- `com.gitgalaxy.modernized.dto.screen.Bnk1ccScreen`

## Verified facts

- **calls** (open): 14 facts
- **cics_resources** (open): 5 facts
- **commarea_contracts** (open): 13 facts
- **dynamic_call_targets** (open): 10 facts
- **entry_points** (open): 1 facts
- **entry_transactions** (open): 1 facts
- **error_handlers** (field-tested): 2 facts
- **interface** (open): 6 facts
- **navigation** (open): 15 facts
- **screen_bindings** (open): 5 facts
- **unchecked_responses** (field-tested): 4 facts
- **uow_handlers** (field-tested): 18 facts

## Paragraphs

| paragraph | line | lines |
|---|---:|---:|
| PREMIERE | 158 | 1 |
| A010 | 159 | 185 |
| A999 | 345 | 2 |
| PROCESS-MAP | 349 | 1 |
| PM010 | 350 | 25 |
| PM999 | 376 | 2 |
| RECEIVE-MAP | 380 | 1 |
| RM010 | 381 | 190 |
| RM999 | 572 | 2 |
| EDIT-DATA | 576 | 1 |
| ED010 | 577 | 355 |
| ED999 | 933 | 2 |
| CRE-CUST-DATA | 937 | 1 |
| CCD010 | 938 | 156 |
| CCD999 | 1095 | 2 |
| STORE-TERM-DEF | 1099 | 1 |
| STD010 | 1100 | 96 |
| STD999 | 1197 | 2 |
| RESTORE-TERM-DEF | 1201 | 1 |
| RTD010 | 1202 | 73 |
| RTD999 | 1276 | 2 |
| SEND-MAP | 1280 | 1 |
| SM010 | 1281 | 232 |
| SM999 | 1514 | 2 |
| SEND-TERMINATION-MSG | 1518 | 1 |
| STM010 | 1519 | 72 |
| STM999 | 1592 | 2 |
| ABEND-THIS-TASK | 1596 | 1 |
| ATT010 | 1597 | 21 |
| ATT999 | 1619 | 2 |
| POPULATE-TIME-DATE | 1623 | 1 |
| PTD10 | 1624 | 12 |
| PTD999 | 1637 | 2 |
| HANDLE-ABEND | 1641 | 1 |
| HA010 | 1642 | 13 |
| HA999 | 1656 | 2 |

## Deliverable

One complete Java file for src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java: the same package, class name and public method signatures, with runTask ported -- what the proof runs -- and helper methods it calls added; every other generated method left as generated (#4255).

The port is laid over the generated project as an overlay and proven by the equivalence harness (tests/tools/equivalence.py in GitGalaxy): the original runs under GnuCOBOL, the port on the same inputs, and every output record is compared field by field; a person approves the port with that report in hand.

## Source listings (numbered, columns 1-72)

- `src/base/cobol_src/BNK1CCS.cbl`: [sources/src/base/cobol_src/BNK1CCS.cbl.lst](sources/src/base/cobol_src/BNK1CCS.cbl.lst)
- `src/base/cobol_copy/ABNDINFO.cpy`: [sources/src/base/cobol_copy/ABNDINFO.cpy.lst](sources/src/base/cobol_copy/ABNDINFO.cpy.lst)
