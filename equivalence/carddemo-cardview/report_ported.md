# COCRDSLC -- COBOL vs Java (ported), CICS

Case `carddemo-cardview`: aws-mainframe-modernization-carddemo `app/cbl/COCRDSLC.cbl`, transaction CCDL, clock `2022/07/18 10:30:15.00`. Each scenario is one task; its events (SEND MAP, SEND TEXT, RETURN, XCTL, ABEND) are paired in order and compared field by field -- screen DATA fields and every COMMAREA field; a SEND MAP also its attribute, colour and highlight bytes, cursor and options (X'00' and X'40' are not claimed).

Stub files, from the engine's facts: `CARDAIX` -> AWS.M2.CARDDEMO.CARDDATA.VSAM.KSDS key 11@16 via PATH AWS.M2.CARDDEMO.CARDDATA.VSAM.AIX.PATH, AIX AWS.M2.CARDDEMO.CARDDATA.VSAM.AIX; `CARDDAT` -> AWS.M2.CARDDEMO.CARDDATA.VSAM.KSDS key 16@0

| scenario | events equal | total |
|---|---|---|
| enter-from-menu | 2 | 2 |
| enter-carried-to-tranid | 2 | 2 |
| no-commarea | 2 | 2 |
| from-card-list | 2 | 2 |
| from-card-list-card-not-on-file | 2 | 2 |
| view-card | 3 | 3 |
| view-another-card | 3 | 3 |
| card-not-on-file | 3 | 3 |
| both-filters-blank | 3 | 3 |
| account-blank | 3 | 3 |
| card-blank | 3 | 3 |
| account-star | 3 | 3 |
| account-zero | 3 | 3 |
| account-not-numeric | 3 | 3 |
| card-not-numeric | 3 | 3 |
| both-not-numeric | 3 | 3 |
| other-key-acts-as-enter | 3 | 3 |
| pf3-back-to-caller | 1 | 1 |
| pf3-back-to-menu | 1 | 1 |
| unexpected-context | 2 | 2 |
| card-file-io-error | 3 | 3 |
| card-file-not-open | 3 | 3 |
| pf3-xctl-fails-abend-routine | 4 | 4 |
| from-card-list-as-the-list-sends-it | 2 | 2 |
| full-commarea-length | 3 | 3 |

## Through the deployed entry points (java-facade, #4449)

Every scenario once more, entered through the program's Spring facade with the scenario's task handed to it through the joined region.

| scenario | events equal | total | entered by | verdict |
|---|---|---|---|---|
| enter-from-menu | 2 | 2 | COCRDSLC.handleTransaction | pass |
| enter-carried-to-tranid | 2 | 2 | COCRDSLC.handleTransaction | pass |
| no-commarea | 2 | 2 | COCRDSLC.handleTransaction | pass |
| from-card-list | 2 | 2 | COCRDSLC.handleTransaction | pass |
| from-card-list-card-not-on-file | 2 | 2 | COCRDSLC.handleTransaction | pass |
| view-card | 3 | 3 | COCRDSLC.handleTransaction | pass |
| view-another-card | 3 | 3 | COCRDSLC.handleTransaction | pass |
| card-not-on-file | 3 | 3 | COCRDSLC.handleTransaction | pass |
| both-filters-blank | 3 | 3 | COCRDSLC.handleTransaction | pass |
| account-blank | 3 | 3 | COCRDSLC.handleTransaction | pass |
| card-blank | 3 | 3 | COCRDSLC.handleTransaction | pass |
| account-star | 3 | 3 | COCRDSLC.handleTransaction | pass |
| account-zero | 3 | 3 | COCRDSLC.handleTransaction | pass |
| account-not-numeric | 3 | 3 | COCRDSLC.handleTransaction | pass |
| card-not-numeric | 3 | 3 | COCRDSLC.handleTransaction | pass |
| both-not-numeric | 3 | 3 | COCRDSLC.handleTransaction | pass |
| other-key-acts-as-enter | 3 | 3 | COCRDSLC.handleTransaction | pass |
| pf3-back-to-caller | 1 | 1 | COCRDSLC.handleTransaction | pass |
| pf3-back-to-menu | 1 | 1 | COCRDSLC.handleTransaction | pass |
| unexpected-context | 2 | 2 | COCRDSLC.handleTransaction | pass |
| card-file-io-error | 3 | 3 | COCRDSLC.handleTransaction | pass |
| card-file-not-open | 3 | 3 | COCRDSLC.handleTransaction | pass |
| pf3-xctl-fails-abend-routine | 4 | 4 | COCRDSLC.handleTransaction | pass |
| from-card-list-as-the-list-sends-it | 2 | 2 | COCRDSLC.handleTransaction | pass |
| full-commarea-length | 3 | 3 | COCRDSLC.handleTransaction | pass |

## COBOL coverage (#4023)

COCRDSLC: proven on 25 scenarios, covering 30/30 paragraphs and 69/75 branches.

Dead (nothing can reach them): `0000-MAIN-EXIT`, `9150-GETCARD-BYACCT`, `9150-GETCARD-BYACCT-EXIT`, `SEND-LONG-TEXT`, `SEND-LONG-TEXT-EXIT`, `SEND-PLAIN-TEXT-EXIT`.

Live code no run reached:

- IF at line 553 in `1300-SETUP-SCREEN-ATTRS`: never true
- IF at line 656 in `2210-EDIT-ACCOUNT`: never false
- IF at line 668 in `2210-EDIT-ACCOUNT`: never false
- IF at line 759 in `9100-GETCARD-BYACCTCARD`: never false
- IF at line 764 in `9100-GETCARD-BYACCTCARD`: never false
- IF at line 859 in `ABEND-ROUTINE`: never true

Branch points no path reaches, after a transfer of control (not counted, #4602): IF at line 386.
