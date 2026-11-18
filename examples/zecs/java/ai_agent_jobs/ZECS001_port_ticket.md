# PORT-ZECS001: port ZECS001 (cobol, `Source/ZECS001.cbl`, 2165 lines)

**Port order 3 of 5** -- 1 program(s) and job(s) call it, blast radius 31.965 ([port_order.md](port_order.md)).

Fill `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (Zecs001Service); return it as `port/service/Zecs001Service.java`.

## Methods to port

- `public void runTask(CicsTask task)`

The proof runs the port through `public void runTask(CicsTask task)` only.

Leave as generated (no proof runs them; port nothing into them):

- `public void commitPointL1444()`

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
| 484 | IF | `WEB-PATH(1:10) = RESOURCES` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-PATH(1:10), RESOURCES)` |
| 486 | IF | `AUTHENTICATE = 'Y'` | alphanumeric / alphanumeric | `CobolCompare.eq(AUTHENTICATE, 'Y')` |
| 518 | IF | `WEB-HTTPMETHOD = WEB-HTTP-POST` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-POST)` |
| 519 | IF | `WEB-HTTPMETHOD = WEB-HTTP-PUT` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-PUT)` |
| 540 | IF | `WEB-MEDIA-TYPE(1:04) = TEXT-ANYTHING` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-MEDIA-TYPE(1:04), TEXT-ANYTHING)` |
| 541 | IF | `WEB-MEDIA-TYPE(1:15) = APPLICATION-XML` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-MEDIA-TYPE(1:15), APPLICATION-XML)` |
| 552 | IF | `WEBRESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 577 | IF | `WEB-PATH(URI-PATH-POINTER:1) = SLASH` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-PATH(URI-PATH-POINTER:1), SLASH)` |
| 628 | IF | `WEB-SCHEME = DFHVALUE(HTTP)` | numeric / unknown | operand class unresolved: check by hand |
| 631 | IF | `WEB-SCHEME = DFHVALUE(HTTPS)` | numeric / unknown | operand class unresolved: check by hand |
| 651 | IF | `SD-RESP = DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 660 | IF | `SD-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 678 | IF | `WEB-HTTPMETHOD = WEB-HTTP-POST` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-POST)` |
| 679 | IF | `WEB-HTTPMETHOD = WEB-HTTP-PUT` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-PUT)` |
| 682 | IF | `WEB-HTTPMETHOD = WEB-HTTP-DELETE` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-DELETE)` |
| 713 | IF | `ETTL-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 714 | IF | `ETTL-STATUS = DFHVALUE(DISABLED)` | numeric / unknown | operand class unresolved: check by hand |
| 718 | IF | `ETTL-RESP = DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 719 | IF | `ETTL-STATUS = DFHVALUE(ENABLED)` | numeric / unknown | operand class unresolved: check by hand |
| 752 | IF | `CLEAR-TEXT = '*'` | alphanumeric / alphanumeric | `CobolCompare.eq(CLEAR-TEXT, '*')` |
| 789 | IF | `EIBRESP <> DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 800 | IF | `CA-RETURN-CODE <> '00'` | alphanumeric / alphanumeric | `!CobolCompare.eq(CA-RETURN-CODE, '00')` |
| 823 | PERFORM UNTIL | `USER-ACCESS = 'Y'` | alphanumeric / alphanumeric | `CobolCompare.eq(USER-ACCESS, 'Y')` |
| 826 | IF | `USER-ACCESS = 'N'` | alphanumeric / alphanumeric | `CobolCompare.eq(USER-ACCESS, 'N')` |
| 837 | IF | `SD-USER-ID(SD-INDEX) = CA-USERID` | alphanumeric / alphanumeric | `CobolCompare.eq(SD-USER-ID(SD-INDEX), CA-USERID)` |
| 838 | IF | `SD-ACCESS(SD-INDEX) = SD-SELECT` | alphanumeric / alphanumeric | `CobolCompare.eq(SD-ACCESS(SD-INDEX), SD-SELECT)` |
| 839 | IF | `WEB-HTTPMETHOD = WEB-HTTP-GET` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-GET)` |
| 842 | IF | `SD-USER-ID(SD-INDEX) = CA-USERID` | alphanumeric / alphanumeric | `CobolCompare.eq(SD-USER-ID(SD-INDEX), CA-USERID)` |
| 843 | IF | `SD-ACCESS(SD-INDEX) = SD-UPDATE` | alphanumeric / alphanumeric | `CobolCompare.eq(SD-ACCESS(SD-INDEX), SD-UPDATE)` |
| 844 | IF | `WEB-HTTPMETHOD = WEB-HTTP-PUT` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-PUT)` |
| 847 | IF | `SD-USER-ID(SD-INDEX) = CA-USERID` | alphanumeric / alphanumeric | `CobolCompare.eq(SD-USER-ID(SD-INDEX), CA-USERID)` |
| 848 | IF | `SD-ACCESS(SD-INDEX) = SD-UPDATE` | alphanumeric / alphanumeric | `CobolCompare.eq(SD-ACCESS(SD-INDEX), SD-UPDATE)` |
| 849 | IF | `WEB-HTTPMETHOD = WEB-HTTP-POST` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-POST)` |
| 852 | IF | `SD-USER-ID(SD-INDEX) = CA-USERID` | alphanumeric / alphanumeric | `CobolCompare.eq(SD-USER-ID(SD-INDEX), CA-USERID)` |
| 853 | IF | `SD-ACCESS(SD-INDEX) = SD-DELETE` | alphanumeric / alphanumeric | `CobolCompare.eq(SD-ACCESS(SD-INDEX), SD-DELETE)` |
| 854 | IF | `WEB-HTTPMETHOD = WEB-HTTP-DELETE` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-DELETE)` |
| 866 | IF | `WEB-HTTPMETHOD = WEB-HTTP-GET` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-GET)` |
| 870 | IF | `WEB-HTTPMETHOD = WEB-HTTP-POST` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-POST)` |
| 871 | IF | `WEB-HTTPMETHOD = WEB-HTTP-PUT` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-PUT)` |
| 877 | IF | `WEB-HTTPMETHOD = WEB-HTTP-DELETE` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-HTTPMETHOD, WEB-HTTP-DELETE)` |
| 883 | PERFORM UNTIL | `EIBRESP <> DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 896 | PERFORM UNTIL | `PROCESS-COMPLETE = 'Y'` | alphanumeric / alphanumeric | `CobolCompare.eq(PROCESS-COMPLETE, 'Y')` |
| 913 | IF | `ZF-SUCCESSFUL = 'Y'` | alphanumeric / alphanumeric | `CobolCompare.eq(ZF-SUCCESSFUL, 'Y')` |
| 934 | IF | `EIBRESP = DFHRESP(NOTFND)` | unknown / unknown | operand class unresolved: check by hand |
| 940 | IF | `EIBRESP <> DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 972 | IF | `ZK-ZF-KEY = INTERNAL-KEY` | group / alphanumeric | `CobolCompare.eq(ZK-ZF-KEY, INTERNAL-KEY)` |
| 999 | IF | `ZK-SEGMENTS = 'Y'` | alphanumeric / alphanumeric | `CobolCompare.eq(ZK-SEGMENTS, 'Y')` |
| 1002 | IF | `TTL-TYPE = LAST-ACCESS-TIME` | alphanumeric / alphanumeric | `CobolCompare.eq(TTL-TYPE, LAST-ACCESS-TIME)` |
| 1007 | IF | `EIBRESP <> DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1010 | IF | `TTL-TYPE = LAST-ACCESS-TIME` | alphanumeric / alphanumeric | `CobolCompare.eq(TTL-TYPE, LAST-ACCESS-TIME)` |
| 1037 | IF | `EIBRESP = DFHRESP(NOTFND)` | unknown / unknown | operand class unresolved: check by hand |
| 1042 | IF | `EIBRESP = DFHRESP(NOTFND)` | unknown / unknown | operand class unresolved: check by hand |
| 1043 | IF | `EIBRESP = DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1055 | IF | `EIBRESP = DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1080 | PERFORM UNTIL | `EIBRESP <> DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1124 | PERFORM UNTIL | `ZF-SUCCESSFUL = 'N'` | alphanumeric / alphanumeric | `CobolCompare.eq(ZF-SUCCESSFUL, 'N')` |
| 1144 | IF | `EIBRESP = DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1151 | IF | `EIBRESP = DFHRESP(NOTFND)` | unknown / unknown | operand class unresolved: check by hand |
| 1158 | IF | `EIBRESP = DFHRESP(NOTFND)` | unknown / unknown | operand class unresolved: check by hand |
| 1159 | IF | `EIBRESP = DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1202 | IF | `WEB-MEDIA-TYPE = SPACES` | alphanumeric / figurative | `CobolCompare.eq(WEB-MEDIA-TYPE, SPACES)` |
| 1212 | IF | `WEB-MEDIA-TYPE(1:04) = TEXT-ANYTHING` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-MEDIA-TYPE(1:04), TEXT-ANYTHING)` |
| 1213 | IF | `WEB-MEDIA-TYPE(1:15) = APPLICATION-XML` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-MEDIA-TYPE(1:15), APPLICATION-XML)` |
| 1275 | IF | `READ-RESP = DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 1278 | IF | `READ-RESP = DFHRESP(NOTFND)` | numeric / unknown | operand class unresolved: check by hand |
| 1281 | IF | `READ-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 1282 | IF | `READ-RESP <> DFHRESP(NOTFND)` | numeric / unknown | operand class unresolved: check by hand |
| 1338 | IF | `WRITE-RESP = DFHRESP(DUPREC)` | numeric / unknown | operand class unresolved: check by hand |
| 1341 | IF | `WRITE-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 1342 | IF | `WRITE-RESP <> DFHRESP(DUPREC)` | numeric / unknown | operand class unresolved: check by hand |
| 1375 | IF | `READ-RESP = DFHRESP(NOTFND)` | numeric / unknown | operand class unresolved: check by hand |
| 1380 | IF | `READ-RESP <> DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 1425 | IF | `READ-RESP = DFHRESP(NORMAL)` | numeric / unknown | operand class unresolved: check by hand |
| 1449 | IF | `DC-TYPE = ACTIVE-ACTIVE` | alphanumeric / alphanumeric | `CobolCompare.eq(DC-TYPE, ACTIVE-ACTIVE)` |
| 1450 | IF | `WEB-PATH(1:10) = RESOURCES` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-PATH(1:10), RESOURCES)` |
| 1468 | IF | `DC-TYPE = ACTIVE-STANDBY` | alphanumeric / alphanumeric | `CobolCompare.eq(DC-TYPE, ACTIVE-STANDBY)` |
| 1469 | IF | `WEB-PATH(1:10) = RESOURCES` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-PATH(1:10), RESOURCES)` |
| 1472 | IF | `DUPLICATE-POST = 'Y'` | alphanumeric / alphanumeric | `CobolCompare.eq(DUPLICATE-POST, 'Y')` |
| 1476 | PERFORM UNTIL | `EIBRESP <> DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1506 | IF | `EIBRESP <> DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1535 | IF | `EIBRESP <> DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1596 | IF | `EIBRESP <> DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1602 | IF | `WEB-PATH(1:10) = DEPLICATE` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-PATH(1:10), DEPLICATE)` |
| 1651 | IF | `DC-TYPE = ACTIVE-ACTIVE` | alphanumeric / alphanumeric | `CobolCompare.eq(DC-TYPE, ACTIVE-ACTIVE)` |
| 1652 | IF | `WEB-PATH(1:10) = RESOURCES` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-PATH(1:10), RESOURCES)` |
| 1670 | IF | `DC-TYPE = ACTIVE-STANDBY` | alphanumeric / alphanumeric | `CobolCompare.eq(DC-TYPE, ACTIVE-STANDBY)` |
| 1671 | IF | `WEB-PATH(1:10) = RESOURCES` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-PATH(1:10), RESOURCES)` |
| 1709 | IF | `ZK-SEGMENTS = 'Y'` | alphanumeric / alphanumeric | `CobolCompare.eq(ZK-SEGMENTS, 'Y')` |
| 1719 | IF | `EIBRESP = DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1788 | IF | `EIBRESP = DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1797 | IF | `EIBRESP = DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1812 | IF | `EIBRESP <> DFHRESP(NORMAL)` | unknown / unknown | operand class unresolved: check by hand |
| 1825 | IF | `URL-SCHEME-NAME = 'HTTPS'` | alphanumeric / alphanumeric | `CobolCompare.eq(URL-SCHEME-NAME, 'HTTPS')` |
| 1852 | IF | `WEB-MEDIA-TYPE(1:04) = TEXT-ANYTHING` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-MEDIA-TYPE(1:04), TEXT-ANYTHING)` |
| 1853 | IF | `WEB-MEDIA-TYPE(1:15) = APPLICATION-XML` | alphanumeric / alphanumeric | `CobolCompare.eq(WEB-MEDIA-TYPE(1:15), APPLICATION-XML)` |
| 1858 | IF | `WEB-METHOD = DFHVALUE(POST)` | numeric / unknown | operand class unresolved: check by hand |
| 1859 | IF | `WEB-METHOD = DFHVALUE(PUT)` | numeric / unknown | operand class unresolved: check by hand |
| 1879 | IF | `WEB-METHOD = DFHVALUE(POST)` | numeric / unknown | operand class unresolved: check by hand |
| 1880 | IF | `WEB-METHOD = DFHVALUE(PUT)` | numeric / unknown | operand class unresolved: check by hand |
| 1902 | IF | `WEB-METHOD = DFHVALUE(` | numeric / unknown | operand class unresolved: check by hand |
| 1968 | IF | `EIBRESP = DFHRESP(NOSPACE)` | unknown / unknown | operand class unresolved: check by hand |
| 1984 | IF | `EIBRESP = DFHRESP(NOSPACE)` | unknown / unknown | operand class unresolved: check by hand |

## Compiler options (CBL / PROCESS cards)

| line | option | as written |
|---:|---|---|
| 1 | CICS(SP) | `CICS(SP)` |

## Worklist items for this program

- **WL-0080** (transaction-split) `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:204`: split the transaction here
- **WL-0081** (interface-call) `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:75`: Implement or mock interface call to: ZuidstckService
- **WL-0087** (business-logic) `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:107`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- **WL-0088** (business-logic) `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:113`: port the PROCEDURE DIVISION into this task

## Generated code it builds on

- `com.gitgalaxy.modernized.cics.CicsTask`
- `com.gitgalaxy.modernized.dto.contract.Zecs001Dfhcommarea`
- `com.gitgalaxy.modernized.entity.vsam.ZfRecord`
- `com.gitgalaxy.modernized.entity.vsam.ZfRecordKey`
- `com.gitgalaxy.modernized.entity.vsam.ZkRecord`
- `com.gitgalaxy.modernized.messaging.TransientData`
- `com.gitgalaxy.modernized.repository.vsam.ZfRecordRepository`
- `com.gitgalaxy.modernized.repository.vsam.ZkRecordRepository`

## Verified facts

- **call_contracts** (open): 1 facts
- **calls** (open): 3 facts
- **cics_file_lineage** (open): 2 facts
- **cics_resources** (open): 35 facts
- **commarea_contracts** (open): 2 facts
- **dynamic_call_targets** (open): 3 facts
- **entry_points** (open): 1 facts
- **entry_transactions** (open): 3 facts
- **interface** (open): 6 facts
- **navigation** (open): 2 facts
- **tdqueue_lineage** (open): 1 facts
- **unchecked_responses** (field-tested): 36 facts
- **units_of_work** (field-tested): 2 facts
- **unresolved_calls** (open): 1 facts
- **uow_handlers** (field-tested): 57 facts

## Paragraphs

| paragraph | line | lines |
|---|---:|---:|
| 1000-ACCESS-PARMS | 465 | 98 |
| 1000-EXIT | 564 | 2 |
| 1100-PARSE-URI | 575 | 4 |
| 1100-EXIT | 580 | 2 |
| 1150-CHECK-URI | 588 | 5 |
| 1150-EXIT | 594 | 2 |
| 1160-MOVE-URI | 602 | 13 |
| 1160-EXIT | 616 | 2 |
| 1200-VALIDATION | 625 | 8 |
| 1200-EXIT | 634 | 2 |
| 1210-ZCXXSD | 640 | 22 |
| 1210-EXIT | 663 | 2 |
| 1300-QUERY-STRING | 677 | 12 |
| 1300-EXIT | 690 | 2 |
| 1310-TTL | 696 | 25 |
| 1310-EXIT | 722 | 2 |
| 1312-CHECK-ETTL | 729 | 8 |
| 1312-EXIT | 738 | 2 |
| 1320-CLEAR | 745 | 12 |
| 1320-EXIT | 758 | 2 |
| 1325-CLEAR-TYPE | 764 | 7 |
| 1325-EXIT | 772 | 2 |
| 1500-AUTHENTICATE | 778 | 30 |
| 1500-EXIT | 809 | 2 |
| 1600-USER-ACCESS | 816 | 13 |
| 1600-EXIT | 830 | 2 |
| 1610-SCAN-ZCXXSD | 836 | 22 |
| 1610-EXIT | 859 | 2 |
| 2000-PROCESS-REQUEST | 865 | 20 |
| 2000-EXIT | 886 | 2 |
| 3000-READ-CACHE | 893 | 4 |
| 3000-EXIT | 897 | 2 |
| 3100-READ-PROCESS | 909 | 6 |
| 3100-EXIT | 915 | 2 |
| 3200-READ-KEY | 922 | 55 |
| 3200-EXIT | 978 | 2 |
| 3300-READ-FILE | 987 | 70 |
| 3300-EXIT | 1058 | 2 |
| 3310-CHECK-TTL | 1064 | 18 |
| 3310-EXIT | 1083 | 2 |
| 3400-STAGE | 1092 | 33 |
| 3400-EXIT | 1126 | 2 |
| 3500-READ-SEGMENTS | 1133 | 37 |
| 3500-EXIT | 1171 | 2 |
| 3510-FREEMAIN | 1179 | 5 |
| 3510-EXIT | 1185 | 2 |
| 3600-SEND-RESPONSE | 1192 | 43 |
| 3600-EXIT | 1236 | 2 |
| 4000-GET-COUNTER | 1243 | 9 |
| 4000-EXIT | 1253 | 2 |
| 4100-READ-KEY | 1261 | 30 |
| 4100-EXIT | 1292 | 2 |
| 4110-PRIME-KEY | 1299 | 9 |
| 4110-EXIT | 1309 | 2 |
| 4120-WRITE-KEY | 1320 | 31 |
| 4120-EXIT | 1352 | 2 |
| 4130-READ-KEY | 1361 | 30 |
| 4130-EXIT | 1392 | 2 |
| 4200-PROCESS-FILE | 1399 | 28 |
| 4200-EXIT | 1428 | 2 |
| 4300-SEND-RESPONSE | 1443 | 34 |
| 4300-EXIT | 1478 | 2 |
| 4400-WRITE-FILE | 1486 | 34 |
| 4400-EXIT | 1521 | 2 |
| 4500-UPDATE-KEY | 1528 | 18 |
| 4500-EXIT | 1547 | 2 |
| 4600-REPLICATE | 1554 | 8 |
| 4600-EXIT | 1563 | 2 |
| 4700-DELETE | 1570 | 6 |
| 4700-EXIT | 1577 | 2 |
| 5000-READ-KEY | 1584 | 20 |
| 5000-EXIT | 1605 | 2 |
| 5100-DELETE-KEY | 1612 | 6 |
| 5100-EXIT | 1619 | 2 |
| 5200-DELETE-FILE | 1626 | 9 |
| 5200-EXIT | 1636 | 2 |
| 5300-SEND-RESPONSE | 1648 | 25 |
| 5300-EXIT | 1674 | 2 |
| 5400-REPLICATE | 1681 | 8 |
| 5400-EXIT | 1691 | 2 |
| 5500-DEPLICATE-DELETE | 1704 | 17 |
| 5500-EXIT | 1722 | 2 |
| 5600-CHECK-TTL | 1729 | 12 |
| 5600-EXIT | 1742 | 2 |
| 5700-SEND-ABS | 1752 | 18 |
| 5700-EXIT | 1771 | 2 |
| 8000-GET-URL | 1779 | 37 |
| 8000-EXIT | 1817 | 2 |
| 8100-WEB-OPEN | 1824 | 14 |
| 8100-EXIT | 1839 | 2 |
| 8200-WEB-CONVERSE | 1847 | 71 |
| 8200-EXIT | 1919 | 2 |
| 8300-WEB-CLOSE | 1925 | 6 |
| 8300-EXIT | 1932 | 2 |
| 9000-RETURN | 1938 | 4 |
| 9000-EXIT | 1943 | 2 |
| 9001-ACAO | 1950 | 8 |
| 9001-EXIT | 1959 | 2 |
| 9100-FILE-ERROR | 1965 | 11 |
| 9100-EXIT | 1977 | 2 |
| 9200-KEY-ERROR | 1983 | 9 |
| 9200-EXIT | 1993 | 2 |
| 9300-WEB-ERROR | 1999 | 5 |
| 9300-EXIT | 2005 | 2 |
| 9400-STATUS-400 | 2011 | 17 |
| 9400-EXIT | 2028 | 2 |
| 9500-STATUS-409 | 2034 | 17 |
| 9500-EXIT | 2052 | 2 |
| 9600-AUTH-ERROR | 2058 | 13 |
| 9600-EXIT | 2072 | 2 |
| 9700-STATUS-204 | 2078 | 19 |
| 9700-EXIT | 2099 | 2 |
| 9800-STATUS-507 | 2105 | 13 |
| 9800-EXIT | 2119 | 2 |
| 9900-WRITE-CSSL | 2125 | 17 |
| 9900-EXIT | 2143 | 2 |
| 9950-ABS | 2149 | 3 |
| 9950-EXIT | 2153 | 2 |
| 9999-ROLLBACK | 2159 | 3 |
| 9999-EXIT | 2163 | 2 |

## Deliverable

One complete Java file for src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java: the same package, class name and public method signatures, with runTask ported -- what the proof runs -- and helper methods it calls added; every other generated method left as generated (#4255).

The port is laid over the generated project as an overlay and proven by the equivalence harness (tests/tools/equivalence.py in GitGalaxy): the original runs under GnuCOBOL, the port on the same inputs, and every output record is compared field by field; a person approves the port with that report in hand.

## Source listings (numbered, columns 1-72)

- `Source/ZECS001.cbl`: [sources/Source/ZECS001.cbl.lst](sources/Source/ZECS001.cbl.lst)
- `Source/ZECSZFC.cpy`: [sources/Source/ZECSZFC.cpy.lst](sources/Source/ZECSZFC.cpy.lst)
- `Source/ZECSZKC.cpy`: [sources/Source/ZECSZKC.cpy.lst](sources/Source/ZECSZKC.cpy.lst)
