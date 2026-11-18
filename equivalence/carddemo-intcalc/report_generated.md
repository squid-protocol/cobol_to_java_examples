# CBACT04C -- COBOL vs Java (generated)

Case `carddemo-intcalc`: aws-mainframe-modernization-carddemo `app/cbl/CBACT04C.cbl`, job INTCALC step STEP15, PARM `2022071800`, clock `2022/07/18 10:30:15.00`.

RETURN-CODE: COBOL `0`, Java `0`.

Key order covered: ASCII / ISO-8859-1 byte order on both sides (GnuCOBOL BDB, H2), not the mainframe's EBCDIC order.

| output | records equal | total | FILLER differs (not compared) |
|---|---|---|---|
| ACCTFILE | 5 | 52 | 0 |
| TRANSACT | 0 | 53 | 0 |

| JVM environment | locale | time zone | equal to COBOL |
|---|---|---|---|
| default | en-US | UTC | **no** |

## Fault runs

Each run injects file statuses on both sides at the same statement (tests/equivalence/faults/ggfault.c for GnuCOBOL, the generated CobolFiles for Java) and is proven like the normal run: the same abend, or the same RETURN-CODE and outputs, and the same faults fired.

| fault | plan (DD OP NTH STATUS) | why | outcome | equal |
|---|---|---|---|---|
| open-tcatbalf | `TCATBALF OPEN 1 35` | 35: OPEN of a file that is not present (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 0000..0300 OPEN error -> ABEND U0999 | faults fired differ: COBOL ['TCATBALF OPEN 1 35'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/4 lines equal | **no** |
| open-xreffile | `XREFFILE OPEN 1 35` | 35: OPEN of a file that is not present (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 0000..0300 OPEN error -> ABEND U0999 | faults fired differ: COBOL ['XREFFILE OPEN 1 35'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/4 lines equal | **no** |
| open-discgrp | `DISCGRP OPEN 1 35` | 35: OPEN of a file that is not present (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 0000..0300 OPEN error -> ABEND U0999 | faults fired differ: COBOL ['DISCGRP OPEN 1 35'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/4 lines equal | **no** |
| open-acctfile | `ACCTFILE OPEN 1 35` | 35: OPEN of a file that is not present (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 0000..0300 OPEN error -> ABEND U0999 | faults fired differ: COBOL ['ACCTFILE OPEN 1 35'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/4 lines equal | **no** |
| open-transact | `TRANSACT OPEN 1 37` | 37: OPEN mode not permitted for the file (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 0400-TRANFILE-OPEN -> ABEND U0999 | faults fired differ: COBOL ['TRANSACT OPEN 1 37'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/4 lines equal | **no** |
| tcatbalf-read-error | `TCATBALF READ 3 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) on the third category balance: 1000-TCATBALF-GET-NEXT -> ABEND U0999 | faults fired differ: COBOL ['TCATBALF READ 3 30'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/8 lines equal | **no** |
| tcatbalf-early-end | `TCATBALF READ 3 10` | 10: end of file (IBM Enterprise COBOL for z/OS Language Reference, File status key values) after two balances: the step ends normally with what it has posted | faults fired differ: COBOL ['TCATBALF READ 3 10'], Java []; TRANSACT: 0/2 records equal; SYSOUT: 0/6 lines equal | **no** |
| tcatbalf-status-9 | `TCATBALF READ 1 9A` | 9x: implementor-defined condition (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 9910-DISPLAY-IO-STATUS's non-numeric / 9 arm, then ABEND U0999 | faults fired differ: COBOL ['TCATBALF READ 1 9A'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/4 lines equal | **no** |
| tcatbalf-status-92 | `TCATBALF READ 1 92` | 92: logic error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): numeric status with IO-STAT1 = '9', exercising the second arm of 9910-DISPLAY-IO-STATUS when first arm is false; kills mutant 784410e034 | faults fired differ: COBOL ['TCATBALF READ 1 92'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/4 lines equal | **no** |
| account-not-found | `ACCTFILE READ 2 23` | 23: no record with the key (IBM Enterprise COBOL for z/OS Language Reference, File status key values) for the second account: INVALID KEY in 1100-GET-ACCT-DATA -> ABEND U0999 | faults fired differ: COBOL ['ACCTFILE READ 2 23'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/10 lines equal | **no** |
| xref-not-found | `XREFFILE READ 1 23` | 23: no cross reference for the first account (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 1110-GET-XREF-DATA -> ABEND U0999 | faults fired differ: COBOL ['XREFFILE READ 1 23'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/6 lines equal | **no** |
| default-group-missing | `DISCGRP READ 1 23`; `DISCGRP READ 2 23` | 23 on the group (as every account's group already is in this data) AND on its DEFAULT fallback (IBM Enterprise COBOL for z/OS Language Reference, File status key values): 1200-A-GET-DEFAULT-INT-RATE -> ABEND U0999 | faults fired differ: COBOL ['DISCGRP READ 1 23', 'DISCGRP READ 2 23'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/7 lines equal | **no** |
| disclosure-read-error | `DISCGRP READ 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) on a disclosure-group READ: 1200-GET-INTEREST-RATE -> ABEND U0999 | faults fired differ: COBOL ['DISCGRP READ 1 30'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/5 lines equal | **no** |
| account-rewrite-error | `ACCTFILE REWRITE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) rewriting the first account: 1050-UPDATE-ACCOUNT -> ABEND U0999 | faults fired differ: COBOL ['ACCTFILE REWRITE 1 30'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/9 lines equal | **no** |
| transaction-write-error | `TRANSACT WRITE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) writing the first interest transaction: 1300-B-WRITE-TX -> ABEND U0999 | faults fired differ: COBOL ['TRANSACT WRITE 1 30'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/7 lines equal | **no** |
| close-tcatbalf | `TCATBALF CLOSE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) closing TCATBALF: its 9x00 CLOSE paragraph -> ABEND U0999 | faults fired differ: COBOL ['TCATBALF CLOSE 1 30'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/158 lines equal | **no** |
| close-xreffile | `XREFFILE CLOSE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) closing XREFFILE: its 9x00 CLOSE paragraph -> ABEND U0999 | faults fired differ: COBOL ['XREFFILE CLOSE 1 30'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/158 lines equal | **no** |
| close-discgrp | `DISCGRP CLOSE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) closing DISCGRP: its 9x00 CLOSE paragraph -> ABEND U0999 | faults fired differ: COBOL ['DISCGRP CLOSE 1 30'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/158 lines equal | **no** |
| close-acctfile | `ACCTFILE CLOSE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) closing ACCTFILE: its 9x00 CLOSE paragraph -> ABEND U0999 | faults fired differ: COBOL ['ACCTFILE CLOSE 1 30'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/158 lines equal | **no** |
| close-transact | `TRANSACT CLOSE 1 30` | 30: permanent I/O error (IBM Enterprise COBOL for z/OS Language Reference, File status key values) closing TRANSACT: its 9x00 CLOSE paragraph -> ABEND U0999 | faults fired differ: COBOL ['TRANSACT CLOSE 1 30'], Java []; ABEND: COBOL U0999, Java None; SYSOUT: 0/158 lines equal | **no** |

## COBOL coverage (#4023)

CBACT04C: not proven; 21 runs cover 22/22 paragraphs and 85/86 branches.

Live code no run reached:

- IF at line 189: never false

## ACCTFILE: differences

| record | field | COBOL | Java |
|---|---|---|---|
| 1 | ACCT-CURR-BAL | `25000193.98` | `194.00` |
| 2 | ACCT-CURR-BAL | `-12499841.99` | `158.00` |
| 6 | ACCT-CURR-BAL | `218.14` | `218.00` |
| 7 | ACCT-CURR-BAL | `193.15` | `193.00` |
| 8 | ACCT-CURR-BAL | `604.85` | `605.00` |
| 9 | ACCT-CURR-BAL | `1158.95` | `560.00` |
| 10 | ACCT-CURR-BAL | `1301.56` | `159.00` |
| 11 | ACCT-CURR-BAL | `1898.18` | `212.00` |
| 12 | ACCT-CURR-BAL | `2405.80` | `176.00` |
| 13 | ACCT-CURR-BAL | `-310.57` | `41.00` |
| 14 | ACCT-CURR-BAL | `207.04` | `15.00` |
| 15 | ACCT-CURR-BAL | `1224.66` | `489.00` |
| 16 | ACCT-CURR-BAL | `2012.28` | `733.00` |
| 17 | ACCT-CURR-BAL | `1855.90` | `33.00` |
| 18 | ACCT-CURR-BAL | `2510.52` | `144.00` |
| 19 | ACCT-CURR-BAL | `265.14` | `480.00` |
| 20 | ACCT-CURR-BAL | `697.75` | `369.00` |
| 21 | ACCT-CURR-BAL | `984.37` | `112.00` |
| 22 | ACCT-CURR-BAL | `1470.99` | `55.00` |
| 23 | ACCT-CURR-BAL | `2063.61` | `104.00` |
| 24 | ACCT-CURR-BAL | `-221.76` | `400.00` |
| 25 | ACCT-CURR-BAL | `-17.14` | `61.00` |
| 26 | ACCT-CURR-BAL | `511.47` | `46.00` |
| 27 | ACCT-CURR-BAL | `1293.09` | `284.00` |
| 28 | ACCT-CURR-BAL | `1620.70` | `68.00` |
| 29 | ACCT-CURR-BAL | `2435.32` | `339.00` |
| 30 | ACCT-CURR-BAL | `-483.05` | `2.00` |
| 31 | ACCT-CURR-BAL | `89.56` | `31.00` |
| 32 | ACCT-CURR-BAL | `632.18` | `30.00` |
| 33 | ACCT-CURR-BAL | `1555.80` | `410.00` |
| 34 | ACCT-CURR-BAL | `1942.42` | `253.00` |
| 35 | ACCT-CURR-BAL | `2399.04` | `166.00` |
| 36 | ACCT-CURR-BAL | `-238.33` | `110.00` |
| 37 | ACCT-CURR-BAL | `202.27` | `7.00` |
| 38 | ACCT-CURR-BAL | `1350.89` | `612.00` |
| 39 | ACCT-CURR-BAL | `2125.51` | `843.00` |
| 40 | ACCT-CURR-BAL | `1869.13` | `43.00` |
| 41 | ACCT-CURR-BAL | `2744.75` | `375.00` |
| 42 | ACCT-CURR-BAL | `90.38` | `302.00` |
| 43 | ACCT-CURR-BAL | `941.99` | `610.00` |
| 44 | ACCT-CURR-BAL | `1138.61` | `263.00` |
| 45 | ACCT-CURR-BAL | `1605.23` | `186.00` |
| 46 | ACCT-CURR-BAL | `2358.84` | `396.00` |
| 47 | ACCT-CURR-BAL | `-586.53` | `32.00` |
| 48 | ACCT-CURR-BAL | `151.09` | `226.00` |
| 49 | ACCT-CURR-BAL | `568.70` | `100.00` |
| 50 | ACCT-CURR-BAL | `1504.32` | `492.00` |

## TRANSACT: differences

| record | field | COBOL | Java |
|---|---|---|---|
| 1 | (record) | present | - |
| 2 | (record) | present | - |
| 3 | (record) | present | - |
| 4 | (record) | present | - |
| 5 | (record) | present | - |
| 6 | (record) | present | - |
| 7 | (record) | present | - |
| 8 | (record) | present | - |
| 9 | (record) | present | - |
| 10 | (record) | present | - |
| 11 | (record) | present | - |
| 12 | (record) | present | - |
| 13 | (record) | present | - |
| 14 | (record) | present | - |
| 15 | (record) | present | - |
| 16 | (record) | present | - |
| 17 | (record) | present | - |
| 18 | (record) | present | - |
| 19 | (record) | present | - |
| 20 | (record) | present | - |
| 21 | (record) | present | - |
| 22 | (record) | present | - |
| 23 | (record) | present | - |
| 24 | (record) | present | - |
| 25 | (record) | present | - |
| 26 | (record) | present | - |
| 27 | (record) | present | - |
| 28 | (record) | present | - |
| 29 | (record) | present | - |
| 30 | (record) | present | - |
| 31 | (record) | present | - |
| 32 | (record) | present | - |
| 33 | (record) | present | - |
| 34 | (record) | present | - |
| 35 | (record) | present | - |
| 36 | (record) | present | - |
| 37 | (record) | present | - |
| 38 | (record) | present | - |
| 39 | (record) | present | - |
| 40 | (record) | present | - |
| 41 | (record) | present | - |
| 42 | (record) | present | - |
| 43 | (record) | present | - |
| 44 | (record) | present | - |
| 45 | (record) | present | - |
| 46 | (record) | present | - |
| 47 | (record) | present | - |
| 48 | (record) | present | - |
| 49 | (record) | present | - |
| 50 | (record) | present | - |
| 51 | (record) | present | - |
| 52 | (record) | present | - |
| 53 | (record) | present | - |
