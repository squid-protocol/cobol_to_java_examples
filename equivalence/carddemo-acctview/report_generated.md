# COACTVWC -- COBOL vs Java (generated), CICS

Case `carddemo-acctview`: aws-mainframe-modernization-carddemo `app/cbl/COACTVWC.cbl`, transaction CAVW, clock `2022/07/18 10:30:15.00`. Each scenario is one task; its events (SEND MAP, SEND TEXT, RETURN, XCTL, ABEND) are paired in order and compared field by field -- screen DATA fields and every COMMAREA field; a SEND MAP also its attribute, colour and highlight bytes, cursor and options (X'00' and X'40' are not claimed).

Stub files, from the engine's facts: `ACCTDAT` -> AWS.M2.CARDDEMO.ACCTDATA.VSAM.KSDS key 11@0; `CUSTDAT` -> AWS.M2.CARDDEMO.CUSTDATA.VSAM.KSDS key 9@0; `CXACAIX` -> AWS.M2.CARDDEMO.CARDXREF.VSAM.KSDS key 11@25 via PATH AWS.M2.CARDDEMO.CARDXREF.VSAM.AIX.PATH, AIX AWS.M2.CARDDEMO.CARDXREF.VSAM.AIX

| scenario | events equal | total |
|---|---|---|
| enter-from-menu | 0 | 2 |
| view-account | 0 | 3 |
| account-not-on-file | 0 | 3 |
| account-not-numeric | 0 | 3 |
| pf3-back-to-menu | 0 | 1 |
| xref-file-notopen | 0 | 3 |
| account-not-found | 0 | 3 |
| account-io-error | 0 | 3 |
| customer-not-found | 0 | 3 |
| account-and-customer-not-found | 0 | 3 |
| customer-file-disabled | 0 | 3 |
| reenter-carried-fields | 0 | 3 |
| star-account-id | 0 | 3 |
| blank-account-id | 0 | 3 |
| pf3-blank-caller | 0 | 1 |
| pf3-from-itself | 0 | 1 |
| context-two | 0 | 2 |
| no-commarea-enter | 0 | 2 |
| no-commarea-pf3 | 0 | 1 |
| large-balance-group-account | 0 | 3 |
| carried-account-status | 0 | 3 |
| pf15-back-to-menu | 0 | 1 |
| carried-middle-name-and-ids | 0 | 3 |
| pf3-low-values-caller | 0 | 1 |
| card-number-blank | 0 | 3 |
| card-number-comma-trailing-letter | 0 | 3 |
| card-number-inner-space | 0 | 3 |
| card-number-minus-sign | 0 | 3 |
| card-number-trailing-space | 0 | 3 |
| card-number-space-then-plus | 0 | 3 |
| card-number-plus-sign | 0 | 3 |
| card-number-letter-inside | 0 | 3 |
| card-number-all-letters | 0 | 3 |
| card-number-letter-digit-mix | 0 | 3 |
| card-number-point | 0 | 3 |
| pf3-xctl-fails-abend-routine | 0 | 4 |
| invalid-key-acts-as-enter | 0 | 3 |

## COBOL coverage (#4023)

COACTVWC: not proven; 37 scenarios cover 32/32 paragraphs and 61/69 branches.

Dead (nothing can reach them): `0000-MAIN-EXIT`, `SEND-LONG-TEXT`, `SEND-LONG-TEXT-EXIT`, `SEND-PLAIN-TEXT-EXIT`.

Live code no run reached:

- IF at line 567 in `1300-SETUP-SCREEN-ATTRS`: never true
- IF at line 657 in `2210-EDIT-ACCOUNT`: never false
- IF at line 670 in `2210-EDIT-ACCOUNT`: never false
- IF at line 704 in `9000-READ-ACCT`: never true
- IF at line 713 in `9000-READ-ACCT`: never true
- IF at line 744 in `9200-GETCARDXREF-BYACCT`: never false
- IF at line 793 in `9300-GETACCTDATA-BYACCT`: never false
- IF at line 918 in `ABEND-ROUTINE`: never true

Branch points no path reaches, after a transfer of control (not counted, #4602): IF at line 387.

## enter-from-menu: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## view-account: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-not-on-file: differences

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

## pf3-back-to-menu: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |

## xref-file-notopen: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-not-found: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-io-error: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## customer-not-found: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-and-customer-not-found: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## customer-file-disabled: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## reenter-carried-fields: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## star-account-id: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## blank-account-id: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf3-blank-caller: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |

## pf3-from-itself: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |

## context-two: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-TEXT` | `None` |
| 2 | (event) | `RETURN` | `None` |

## no-commarea-enter: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## no-commarea-pf3: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |

## large-balance-group-account: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## carried-account-status: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf15-back-to-menu: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |

## carried-middle-name-and-ids: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf3-low-values-caller: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |

## card-number-blank: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-number-comma-trailing-letter: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-number-inner-space: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-number-minus-sign: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-number-trailing-space: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-number-space-then-plus: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-number-plus-sign: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-number-letter-inside: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-number-all-letters: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-number-letter-digit-mix: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-number-point: differences

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

## invalid-key-acts-as-enter: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |
