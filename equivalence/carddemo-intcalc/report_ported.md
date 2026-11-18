# CBACT04C -- COBOL vs Java (ported)

Case `carddemo-intcalc`: aws-mainframe-modernization-carddemo `app/cbl/CBACT04C.cbl`, job INTCALC step STEP15, PARM `2022071800`, clock `2022/07/18 10:30:15.00`.

RETURN-CODE: COBOL `0`, Java `0`.

Key order covered: ASCII / ISO-8859-1 byte order on both sides (GnuCOBOL BDB, H2), not the mainframe's EBCDIC order.

| output | records equal | total | FILLER differs (not compared) |
|---|---|---|---|
| ACCTFILE | 52 | 52 | 0 |
| TRANSACT | 53 | 53 | 0 |

| JVM environment | locale | time zone | equal to COBOL |
|---|---|---|---|
| default | en-US | UTC | yes |

## Fault runs

Each run injects file statuses on both sides at the same statement (tests/equivalence/faults/ggfault.c for GnuCOBOL, the generated CobolFiles for Java) and is proven like the normal run: the same abend, or the same RETURN-CODE and outputs, and the same faults fired.

| fault | plan (DD OP NTH STATUS) | why | outcome | equal |
|---|---|---|---|---|
| open-tcatbalf | `TCATBALF OPEN 1 35` | 35: OPEN of a file that is not present (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 0000..0300 OPEN error -> ABEND U0999 | both ABEND U0999 | yes |
| open-xreffile | `XREFFILE OPEN 1 35` | 35: OPEN of a file that is not present (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 0000..0300 OPEN error -> ABEND U0999 | both ABEND U0999 | yes |
| open-discgrp | `DISCGRP OPEN 1 35` | 35: OPEN of a file that is not present (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 0000..0300 OPEN error -> ABEND U0999 | both ABEND U0999 | yes |
| open-acctfile | `ACCTFILE OPEN 1 35` | 35: OPEN of a file that is not present (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 0000..0300 OPEN error -> ABEND U0999 | both ABEND U0999 | yes |
| open-transact | `TRANSACT OPEN 1 37` | 37: OPEN mode not permitted for the file (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 0400-TRANFILE-OPEN -> ABEND U0999 | both ABEND U0999 | yes |
| tcatbalf-read-error | `TCATBALF READ 3 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) on the third category balance: 1000-TCATBALF-GET-NEXT -> ABEND U0999 | both ABEND U0999 | yes |
| tcatbalf-early-end | `TCATBALF READ 3 10` | 10: end of file (IBM Enterprise COBOL for z/OS Language Reference, File status key values) after two balances: the step ends normally with what it has posted | both end RETURN-CODE 0 | yes |
| tcatbalf-status-9 | `TCATBALF READ 1 9A` | 9x: implementor-defined condition (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 9910-DISPLAY-IO-STATUS's non-numeric / 9 arm, then ABEND U0999 | both ABEND U0999 | yes |
| tcatbalf-status-92 | `TCATBALF READ 1 92` | 92: logic error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): numeric status with IO-STAT1 = '9', exercising the second arm of 9910-DISPLAY-IO-STATUS when first arm is false; kills mutant 784410e034 | both ABEND U0999 | yes |
| account-not-found | `ACCTFILE READ 2 23` | 23: no record with the key (IBM Enterprise COBOL for z/OS Language Reference, File status key values) for the second account: INVALID KEY in 1100-GET-ACCT-DATA -> ABEND U0999 | both ABEND U0999 | yes |
| xref-not-found | `XREFFILE READ 1 23` | 23: no cross reference for the first account (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 1110-GET-XREF-DATA -> ABEND U0999 | both ABEND U0999 | yes |
| default-group-missing | `DISCGRP READ 1 23`; `DISCGRP READ 2 23` | 23 on the group (as every account's group already is in this data) AND on its DEFAULT fallback (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 1200-A-GET-DEFAULT-INT-RATE -> ABEND U0999 | both ABEND U0999 | yes |
| disclosure-read-error | `DISCGRP READ 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) on a disclosure-group READ: 1200-GET-INTEREST-RATE -> ABEND U0999 | both ABEND U0999 | yes |
| account-rewrite-error | `ACCTFILE REWRITE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) rewriting the first account: 1050-UPDATE-ACCOUNT -> ABEND U0999 | both ABEND U0999 | yes |
| transaction-write-error | `TRANSACT WRITE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) writing the first interest transaction: 1300-B-WRITE-TX -> ABEND U0999 | both ABEND U0999 | yes |
| close-tcatbalf | `TCATBALF CLOSE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) closing TCATBALF: its 9x00 CLOSE paragraph -> ABEND U0999 | both ABEND U0999 | yes |
| close-xreffile | `XREFFILE CLOSE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) closing XREFFILE: its 9x00 CLOSE paragraph -> ABEND U0999 | both ABEND U0999 | yes |
| close-discgrp | `DISCGRP CLOSE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) closing DISCGRP: its 9x00 CLOSE paragraph -> ABEND U0999 | both ABEND U0999 | yes |
| close-acctfile | `ACCTFILE CLOSE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) closing ACCTFILE: its 9x00 CLOSE paragraph -> ABEND U0999 | both ABEND U0999 | yes |
| close-transact | `TRANSACT CLOSE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) closing TRANSACT: its 9x00 CLOSE paragraph -> ABEND U0999 | both ABEND U0999 | yes |

## COBOL coverage (#4023)

CBACT04C: proven on 21 runs, covering 22/22 paragraphs and 85/86 branches.

Live code no run reached:

- IF at line 189: never false
