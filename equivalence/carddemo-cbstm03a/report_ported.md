# CBSTM03A -- COBOL vs Java (ported)

Case `carddemo-cbstm03a`: aws-mainframe-modernization-carddemo `app/cbl/CBSTM03A.CBL`, job CREASTMT step STEP040, PARM `None`, clock `2022/07/18 10:30:15.00`.

RETURN-CODE: COBOL `0`, Java `0`.

Key order covered: ASCII / ISO-8859-1 byte order on both sides (GnuCOBOL BDB, H2), not the mainframe's EBCDIC order.

| output | records equal | total | FILLER differs (not compared) |
|---|---|---|---|
| STMTFILE | 953 | 953 | 0 |
| HTMLFILE | 3233 | 3233 | 0 |

| JVM environment | locale | time zone | equal to COBOL |
|---|---|---|---|
| default | en-US | UTC | yes |

## Fault runs

Each run injects file statuses on both sides at the same statement (tests/equivalence/faults/ggfault.c for GnuCOBOL, the generated CobolFiles for Java) and is proven like the normal run: the same abend, or the same RETURN-CODE and outputs, and the same faults fired.

| fault | plan (DD OP NTH STATUS) | why | outcome | equal |
|---|---|---|---|---|
| trnxfile-open | `TRNXFILE OPEN 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's OPEN INPUT TRNXFILE fails and answers RC 30, so 8100-TRNXFILE-OPEN DISPLAYs 'ERROR OPENING TRNXFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| xreffile-open | `XREFFILE OPEN 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's OPEN INPUT XREFFILE fails and answers RC 30, so 8200-XREFFILE-OPEN DISPLAYs 'ERROR OPENING XREFFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| custfile-open | `CUSTFILE OPEN 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's OPEN INPUT CUSTFILE fails and answers RC 30, so 8300-CUSTFILE-OPEN DISPLAYs 'ERROR OPENING CUSTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| acctfile-open | `ACCTFILE OPEN 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's OPEN INPUT ACCTFILE fails and answers RC 30, so 8400-ACCTFILE-OPEN DISPLAYs 'ERROR OPENING ACCTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| trnxfile-first-read | `TRNXFILE READ 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's first READ of TRNXFILE fails and answers RC 30, so 8100-TRNXFILE-OPEN (the read after the open) DISPLAYs 'ERROR READING TRNXFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| trnxfile-read | `TRNXFILE READ 2 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's next READ of TRNXFILE fails and answers RC 30, so 8500-READTRNX-READ DISPLAYs 'ERROR READING TRNXFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| xreffile-read | `XREFFILE READ 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's READ of XREFFILE fails and answers RC 30, so 1000-XREFFILE-GET-NEXT DISPLAYs 'ERROR READING XREFFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| custfile-read | `CUSTFILE READ 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's READ of CUSTFILE fails and answers RC 30, so 2000-CUSTFILE-GET DISPLAYs 'ERROR READING CUSTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| acctfile-read | `ACCTFILE READ 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's READ of ACCTFILE fails and answers RC 30, so 3000-ACCTFILE-GET DISPLAYs 'ERROR READING ACCTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| trnxfile-close | `TRNXFILE CLOSE 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's CLOSE of TRNXFILE fails and answers RC 30, so 9100-TRNXFILE-CLOSE DISPLAYs 'ERROR CLOSING TRNXFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| xreffile-close | `XREFFILE CLOSE 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's CLOSE of XREFFILE fails and answers RC 30, so 9200-XREFFILE-CLOSE DISPLAYs 'ERROR CLOSING XREFFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| custfile-close | `CUSTFILE CLOSE 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's CLOSE of CUSTFILE fails and answers RC 30, so 9300-CUSTFILE-CLOSE DISPLAYs 'ERROR CLOSING CUSTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |
| acctfile-close | `ACCTFILE CLOSE 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's CLOSE of ACCTFILE fails and answers RC 30, so 9400-ACCTFILE-CLOSE DISPLAYs 'ERROR CLOSING ACCTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | both ABEND U0000 | yes |

## COBOL coverage (#4023)

CBSTM03A: proven on 14 runs, covering 25/25 paragraphs and 43/46 branches.

Live code no run reached:

- IF at line 287: never false
- EVALUATE at line 298 in `0000-START`: `OTHER` never taken
- IF at line 318 in `1000-MAINLINE`: never false
