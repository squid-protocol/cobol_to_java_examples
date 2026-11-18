# CBSTM03A -- COBOL vs Java (generated)

Case `carddemo-cbstm03a`: aws-mainframe-modernization-carddemo `app/cbl/CBSTM03A.CBL`, job CREASTMT step STEP040, PARM `None`, clock `2022/07/18 10:30:15.00`.

RETURN-CODE: COBOL `0`, Java `0`.

Key order covered: ASCII / ISO-8859-1 byte order on both sides (GnuCOBOL BDB, H2), not the mainframe's EBCDIC order.

| output | records equal | total | FILLER differs (not compared) |
|---|---|---|---|
| STMTFILE | 0 | 953 | 0 |
| HTMLFILE | 0 | 3233 | 0 |

| JVM environment | locale | time zone | equal to COBOL |
|---|---|---|---|
| default | en-US | UTC | **no** |

## Fault runs

Each run injects file statuses on both sides at the same statement (tests/equivalence/faults/ggfault.c for GnuCOBOL, the generated CobolFiles for Java) and is proven like the normal run: the same abend, or the same RETURN-CODE and outputs, and the same faults fired.

| fault | plan (DD OP NTH STATUS) | why | outcome | equal |
|---|---|---|---|---|
| trnxfile-open | `TRNXFILE OPEN 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's OPEN INPUT TRNXFILE fails and answers RC 30, so 8100-TRNXFILE-OPEN DISPLAYs 'ERROR OPENING TRNXFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['TRNXFILE OPEN 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| xreffile-open | `XREFFILE OPEN 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's OPEN INPUT XREFFILE fails and answers RC 30, so 8200-XREFFILE-OPEN DISPLAYs 'ERROR OPENING XREFFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['XREFFILE OPEN 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| custfile-open | `CUSTFILE OPEN 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's OPEN INPUT CUSTFILE fails and answers RC 30, so 8300-CUSTFILE-OPEN DISPLAYs 'ERROR OPENING CUSTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['CUSTFILE OPEN 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| acctfile-open | `ACCTFILE OPEN 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's OPEN INPUT ACCTFILE fails and answers RC 30, so 8400-ACCTFILE-OPEN DISPLAYs 'ERROR OPENING ACCTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['ACCTFILE OPEN 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| trnxfile-first-read | `TRNXFILE READ 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's first READ of TRNXFILE fails and answers RC 30, so 8100-TRNXFILE-OPEN (the read after the open) DISPLAYs 'ERROR READING TRNXFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['TRNXFILE READ 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| trnxfile-read | `TRNXFILE READ 2 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's next READ of TRNXFILE fails and answers RC 30, so 8500-READTRNX-READ DISPLAYs 'ERROR READING TRNXFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['TRNXFILE READ 2 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| xreffile-read | `XREFFILE READ 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's READ of XREFFILE fails and answers RC 30, so 1000-XREFFILE-GET-NEXT DISPLAYs 'ERROR READING XREFFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['XREFFILE READ 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| custfile-read | `CUSTFILE READ 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's READ of CUSTFILE fails and answers RC 30, so 2000-CUSTFILE-GET DISPLAYs 'ERROR READING CUSTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['CUSTFILE READ 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| acctfile-read | `ACCTFILE READ 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's READ of ACCTFILE fails and answers RC 30, so 3000-ACCTFILE-GET DISPLAYs 'ERROR READING ACCTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['ACCTFILE READ 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| trnxfile-close | `TRNXFILE CLOSE 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's CLOSE of TRNXFILE fails and answers RC 30, so 9100-TRNXFILE-CLOSE DISPLAYs 'ERROR CLOSING TRNXFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['TRNXFILE CLOSE 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| xreffile-close | `XREFFILE CLOSE 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's CLOSE of XREFFILE fails and answers RC 30, so 9200-XREFFILE-CLOSE DISPLAYs 'ERROR CLOSING XREFFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['XREFFILE CLOSE 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| custfile-close | `CUSTFILE CLOSE 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's CLOSE of CUSTFILE fails and answers RC 30, so 9300-CUSTFILE-CLOSE DISPLAYs 'ERROR CLOSING CUSTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['CUSTFILE CLOSE 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |
| acctfile-close | `ACCTFILE CLOSE 1 30` | #6072: 30, a permanent error (IBM Enterprise COBOL for z/OS Language Reference, File status key values): CBSTM03B's CLOSE of ACCTFILE fails and answers RC 30, so 9400-ACCTFILE-CLOSE DISPLAYs 'ERROR CLOSING ACCTFILE' and PERFORMs 9999-ABEND-PROGRAM (CALL 'CEE3ABD'): both sides end on the same abend | faults fired differ: COBOL ['ACCTFILE CLOSE 1 30'], Java []; ABEND: COBOL U0000, Java None; SYSOUT: 0/14 lines equal | **no** |

## COBOL coverage (#4023)

CBSTM03A: not proven; 14 runs cover 25/25 paragraphs and 43/46 branches.

Live code no run reached:

- IF at line 287: never false
- EVALUATE at line 298 in `0000-START`: `OTHER` never taken
- IF at line 318 in `1000-MAINLINE`: never false

## STMTFILE: differences

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
| 54 | (record) | present | - |
| 55 | (record) | present | - |
| 56 | (record) | present | - |
| 57 | (record) | present | - |
| 58 | (record) | present | - |
| 59 | (record) | present | - |
| 60 | (record) | present | - |
| 61 | (record) | present | - |
| 62 | (record) | present | - |
| 63 | (record) | present | - |
| 64 | (record) | present | - |
| 65 | (record) | present | - |
| 66 | (record) | present | - |
| 67 | (record) | present | - |
| 68 | (record) | present | - |
| 69 | (record) | present | - |
| 70 | (record) | present | - |
| 71 | (record) | present | - |
| 72 | (record) | present | - |
| 73 | (record) | present | - |
| 74 | (record) | present | - |
| 75 | (record) | present | - |
| 76 | (record) | present | - |
| 77 | (record) | present | - |
| 78 | (record) | present | - |
| 79 | (record) | present | - |
| 80 | (record) | present | - |
| 81 | (record) | present | - |
| 82 | (record) | present | - |
| 83 | (record) | present | - |
| 84 | (record) | present | - |
| 85 | (record) | present | - |
| 86 | (record) | present | - |
| 87 | (record) | present | - |
| 88 | (record) | present | - |
| 89 | (record) | present | - |
| 90 | (record) | present | - |
| 91 | (record) | present | - |
| 92 | (record) | present | - |
| 93 | (record) | present | - |
| 94 | (record) | present | - |
| 95 | (record) | present | - |
| 96 | (record) | present | - |
| 97 | (record) | present | - |
| 98 | (record) | present | - |
| 99 | (record) | present | - |
| 100 | (record) | present | - |
| 101 | (record) | present | - |
| 102 | (record) | present | - |
| 103 | (record) | present | - |
| 104 | (record) | present | - |
| 105 | (record) | present | - |
| 106 | (record) | present | - |
| 107 | (record) | present | - |
| 108 | (record) | present | - |
| 109 | (record) | present | - |
| 110 | (record) | present | - |
| 111 | (record) | present | - |
| 112 | (record) | present | - |
| 113 | (record) | present | - |
| 114 | (record) | present | - |
| 115 | (record) | present | - |
| 116 | (record) | present | - |
| 117 | (record) | present | - |
| 118 | (record) | present | - |
| 119 | (record) | present | - |
| 120 | (record) | present | - |
| 121 | (record) | present | - |
| 122 | (record) | present | - |
| 123 | (record) | present | - |
| 124 | (record) | present | - |
| 125 | (record) | present | - |
| 126 | (record) | present | - |
| 127 | (record) | present | - |
| 128 | (record) | present | - |
| 129 | (record) | present | - |
| 130 | (record) | present | - |
| 131 | (record) | present | - |
| 132 | (record) | present | - |
| 133 | (record) | present | - |
| 134 | (record) | present | - |
| 135 | (record) | present | - |
| 136 | (record) | present | - |
| 137 | (record) | present | - |
| 138 | (record) | present | - |
| 139 | (record) | present | - |
| 140 | (record) | present | - |
| 141 | (record) | present | - |
| 142 | (record) | present | - |
| 143 | (record) | present | - |
| 144 | (record) | present | - |
| 145 | (record) | present | - |
| 146 | (record) | present | - |
| 147 | (record) | present | - |
| 148 | (record) | present | - |
| 149 | (record) | present | - |
| 150 | (record) | present | - |
| 151 | (record) | present | - |
| 152 | (record) | present | - |
| 153 | (record) | present | - |
| 154 | (record) | present | - |
| 155 | (record) | present | - |
| 156 | (record) | present | - |
| 157 | (record) | present | - |
| 158 | (record) | present | - |
| 159 | (record) | present | - |
| 160 | (record) | present | - |
| 161 | (record) | present | - |
| 162 | (record) | present | - |
| 163 | (record) | present | - |
| 164 | (record) | present | - |
| 165 | (record) | present | - |
| 166 | (record) | present | - |
| 167 | (record) | present | - |
| 168 | (record) | present | - |
| 169 | (record) | present | - |
| 170 | (record) | present | - |
| 171 | (record) | present | - |
| 172 | (record) | present | - |
| 173 | (record) | present | - |
| 174 | (record) | present | - |
| 175 | (record) | present | - |
| 176 | (record) | present | - |
| 177 | (record) | present | - |
| 178 | (record) | present | - |
| 179 | (record) | present | - |
| 180 | (record) | present | - |
| 181 | (record) | present | - |
| 182 | (record) | present | - |
| 183 | (record) | present | - |
| 184 | (record) | present | - |
| 185 | (record) | present | - |
| 186 | (record) | present | - |
| 187 | (record) | present | - |
| 188 | (record) | present | - |
| 189 | (record) | present | - |
| 190 | (record) | present | - |
| 191 | (record) | present | - |
| 192 | (record) | present | - |
| 193 | (record) | present | - |
| 194 | (record) | present | - |
| 195 | (record) | present | - |
| 196 | (record) | present | - |
| 197 | (record) | present | - |
| 198 | (record) | present | - |
| 199 | (record) | present | - |
| 200 | (record) | present | - |

## HTMLFILE: differences

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
| 54 | (record) | present | - |
| 55 | (record) | present | - |
| 56 | (record) | present | - |
| 57 | (record) | present | - |
| 58 | (record) | present | - |
| 59 | (record) | present | - |
| 60 | (record) | present | - |
| 61 | (record) | present | - |
| 62 | (record) | present | - |
| 63 | (record) | present | - |
| 64 | (record) | present | - |
| 65 | (record) | present | - |
| 66 | (record) | present | - |
| 67 | (record) | present | - |
| 68 | (record) | present | - |
| 69 | (record) | present | - |
| 70 | (record) | present | - |
| 71 | (record) | present | - |
| 72 | (record) | present | - |
| 73 | (record) | present | - |
| 74 | (record) | present | - |
| 75 | (record) | present | - |
| 76 | (record) | present | - |
| 77 | (record) | present | - |
| 78 | (record) | present | - |
| 79 | (record) | present | - |
| 80 | (record) | present | - |
| 81 | (record) | present | - |
| 82 | (record) | present | - |
| 83 | (record) | present | - |
| 84 | (record) | present | - |
| 85 | (record) | present | - |
| 86 | (record) | present | - |
| 87 | (record) | present | - |
| 88 | (record) | present | - |
| 89 | (record) | present | - |
| 90 | (record) | present | - |
| 91 | (record) | present | - |
| 92 | (record) | present | - |
| 93 | (record) | present | - |
| 94 | (record) | present | - |
| 95 | (record) | present | - |
| 96 | (record) | present | - |
| 97 | (record) | present | - |
| 98 | (record) | present | - |
| 99 | (record) | present | - |
| 100 | (record) | present | - |
| 101 | (record) | present | - |
| 102 | (record) | present | - |
| 103 | (record) | present | - |
| 104 | (record) | present | - |
| 105 | (record) | present | - |
| 106 | (record) | present | - |
| 107 | (record) | present | - |
| 108 | (record) | present | - |
| 109 | (record) | present | - |
| 110 | (record) | present | - |
| 111 | (record) | present | - |
| 112 | (record) | present | - |
| 113 | (record) | present | - |
| 114 | (record) | present | - |
| 115 | (record) | present | - |
| 116 | (record) | present | - |
| 117 | (record) | present | - |
| 118 | (record) | present | - |
| 119 | (record) | present | - |
| 120 | (record) | present | - |
| 121 | (record) | present | - |
| 122 | (record) | present | - |
| 123 | (record) | present | - |
| 124 | (record) | present | - |
| 125 | (record) | present | - |
| 126 | (record) | present | - |
| 127 | (record) | present | - |
| 128 | (record) | present | - |
| 129 | (record) | present | - |
| 130 | (record) | present | - |
| 131 | (record) | present | - |
| 132 | (record) | present | - |
| 133 | (record) | present | - |
| 134 | (record) | present | - |
| 135 | (record) | present | - |
| 136 | (record) | present | - |
| 137 | (record) | present | - |
| 138 | (record) | present | - |
| 139 | (record) | present | - |
| 140 | (record) | present | - |
| 141 | (record) | present | - |
| 142 | (record) | present | - |
| 143 | (record) | present | - |
| 144 | (record) | present | - |
| 145 | (record) | present | - |
| 146 | (record) | present | - |
| 147 | (record) | present | - |
| 148 | (record) | present | - |
| 149 | (record) | present | - |
| 150 | (record) | present | - |
| 151 | (record) | present | - |
| 152 | (record) | present | - |
| 153 | (record) | present | - |
| 154 | (record) | present | - |
| 155 | (record) | present | - |
| 156 | (record) | present | - |
| 157 | (record) | present | - |
| 158 | (record) | present | - |
| 159 | (record) | present | - |
| 160 | (record) | present | - |
| 161 | (record) | present | - |
| 162 | (record) | present | - |
| 163 | (record) | present | - |
| 164 | (record) | present | - |
| 165 | (record) | present | - |
| 166 | (record) | present | - |
| 167 | (record) | present | - |
| 168 | (record) | present | - |
| 169 | (record) | present | - |
| 170 | (record) | present | - |
| 171 | (record) | present | - |
| 172 | (record) | present | - |
| 173 | (record) | present | - |
| 174 | (record) | present | - |
| 175 | (record) | present | - |
| 176 | (record) | present | - |
| 177 | (record) | present | - |
| 178 | (record) | present | - |
| 179 | (record) | present | - |
| 180 | (record) | present | - |
| 181 | (record) | present | - |
| 182 | (record) | present | - |
| 183 | (record) | present | - |
| 184 | (record) | present | - |
| 185 | (record) | present | - |
| 186 | (record) | present | - |
| 187 | (record) | present | - |
| 188 | (record) | present | - |
| 189 | (record) | present | - |
| 190 | (record) | present | - |
| 191 | (record) | present | - |
| 192 | (record) | present | - |
| 193 | (record) | present | - |
| 194 | (record) | present | - |
| 195 | (record) | present | - |
| 196 | (record) | present | - |
| 197 | (record) | present | - |
| 198 | (record) | present | - |
| 199 | (record) | present | - |
| 200 | (record) | present | - |
