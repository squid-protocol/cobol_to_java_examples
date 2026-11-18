# COCRDSLC -- COBOL vs Java (generated), CICS

Case `carddemo-cardview`: aws-mainframe-modernization-carddemo `app/cbl/COCRDSLC.cbl`, transaction CCDL, clock `2022/07/18 10:30:15.00`. Each scenario is one task; its events (SEND MAP, SEND TEXT, RETURN, XCTL, ABEND) are paired in order and compared field by field -- screen DATA fields and every COMMAREA field; a SEND MAP also its attribute, colour and highlight bytes, cursor and options (X'00' and X'40' are not claimed).

Stub files, from the engine's facts: `CARDAIX` -> AWS.M2.CARDDEMO.CARDDATA.VSAM.KSDS key 11@16 via PATH AWS.M2.CARDDEMO.CARDDATA.VSAM.AIX.PATH, AIX AWS.M2.CARDDEMO.CARDDATA.VSAM.AIX; `CARDDAT` -> AWS.M2.CARDDEMO.CARDDATA.VSAM.KSDS key 16@0

| scenario | events equal | total |
|---|---|---|
| enter-from-menu | 0 | 2 |
| enter-carried-to-tranid | 0 | 2 |
| no-commarea | 0 | 2 |
| from-card-list | 0 | 2 |
| from-card-list-card-not-on-file | 0 | 2 |
| view-card | 0 | 3 |
| view-another-card | 0 | 3 |
| card-not-on-file | 0 | 3 |
| both-filters-blank | 0 | 3 |
| account-blank | 0 | 3 |
| card-blank | 0 | 3 |
| account-star | 0 | 3 |
| account-zero | 0 | 3 |
| account-not-numeric | 0 | 3 |
| card-not-numeric | 0 | 3 |
| both-not-numeric | 0 | 3 |
| other-key-acts-as-enter | 0 | 3 |
| pf3-back-to-caller | 0 | 1 |
| pf3-back-to-menu | 0 | 1 |
| unexpected-context | 0 | 2 |
| card-file-io-error | 0 | 3 |
| card-file-not-open | 0 | 3 |
| pf3-xctl-fails-abend-routine | 0 | 4 |
| from-card-list-as-the-list-sends-it | 0 | 2 |
| full-commarea-length | 0 | 3 |

## COBOL coverage (#4023)

COCRDSLC: not proven; 25 scenarios cover 30/30 paragraphs and 69/75 branches.

Dead (nothing can reach them): `0000-MAIN-EXIT`, `9150-GETCARD-BYACCT`, `9150-GETCARD-BYACCT-EXIT`, `SEND-LONG-TEXT`, `SEND-LONG-TEXT-EXIT`, `SEND-PLAIN-TEXT-EXIT`.

Live code no run reached:

- IF at line 553 in `1300-SETUP-SCREEN-ATTRS`: never true
- IF at line 656 in `2210-EDIT-ACCOUNT`: never false
- IF at line 668 in `2210-EDIT-ACCOUNT`: never false
- IF at line 759 in `9100-GETCARD-BYACCTCARD`: never false
- IF at line 764 in `9100-GETCARD-BYACCTCARD`: never false
- IF at line 859 in `ABEND-ROUTINE`: never true

Branch points no path reaches, after a transfer of control (not counted, #4602): IF at line 386.

## enter-from-menu: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## enter-carried-to-tranid: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## no-commarea: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## from-card-list: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## from-card-list-card-not-on-file: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## view-card: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## view-another-card: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-not-on-file: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## both-filters-blank: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-blank: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-blank: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-star: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-zero: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-not-numeric: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-not-numeric: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## both-not-numeric: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## other-key-acts-as-enter: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf3-back-to-caller: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |

## pf3-back-to-menu: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |

## unexpected-context: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-TEXT` | `None` |
| 2 | (event) | `RETURN` | `None` |

## card-file-io-error: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-file-not-open: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf3-xctl-fails-abend-routine: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |
| 2 | (event) | `ABEND` | `None` |
| 3 | (event) | `SEND-TEXT` | `None` |
| 4 | (event) | `ABEND` | `None` |

## from-card-list-as-the-list-sends-it: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## full-commarea-length: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |
