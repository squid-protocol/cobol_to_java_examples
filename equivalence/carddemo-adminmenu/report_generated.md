# COADM01C -- COBOL vs Java (generated), CICS

Case `carddemo-adminmenu`: aws-mainframe-modernization-carddemo `app/cbl/COADM01C.cbl`, transaction CA00, clock `2022/07/18 10:30:15.00`. Each scenario is one task; its events (SEND MAP, SEND TEXT, RETURN, XCTL, ABEND) are paired in order and compared field by field -- screen DATA fields and every COMMAREA field; a SEND MAP also its attribute, colour and highlight bytes, cursor and options (X'00' and X'40' are not claimed).

Stub files, from the engine's facts: 

| scenario | events equal | total |
|---|---|---|
| first-entry | 0 | 2 |
| no-commarea | 0 | 1 |
| option-1-user-list | 0 | 2 |
| option-2-add-user | 0 | 2 |
| option-3-update-user | 0 | 2 |
| option-4-delete-user | 0 | 2 |
| option-5-not-installed | 0 | 4 |
| option-6-not-installed | 0 | 4 |
| option-with-leading-zero | 0 | 2 |
| option-with-trailing-blank | 0 | 2 |
| option-past-the-last | 0 | 3 |
| option-zero | 0 | 3 |
| option-empty | 0 | 3 |
| pf3-sign-off | 0 | 2 |
| invalid-key | 0 | 3 |
| option-1-xctl-not-authorised | 0 | 3 |
| option-1-xctl-fails | 0 | 4 |
| pf3-xctl-not-authorised | 0 | 3 |
| pf3-xctl-fails | 0 | 4 |
| option-10 | 0 | 3 |
| option-12 | 0 | 3 |
| option-colon | 0 | 3 |
| option-less-than | 0 | 3 |
| pf3-blank-to-program | 0 | 2 |
| pf3-low-values-to-program | 0 | 2 |
| carried-commarea-fields | 0 | 2 |
| pf3-commarea-without-to-program | 0 | 2 |
| carried-account-and-card-fields | 0 | 2 |
| first-entry-carried-account-and-card-fields | 0 | 2 |
| no-commarea-xctl-fails | 0 | 3 |
| pf4-other-key | 0 | 3 |
| invalid-key-unread-option-field | 0 | 3 |
| short-commarea-146 | 0 | 2 |
| short-commarea-159 | 0 | 2 |

## COBOL coverage (#4023)

COADM01C: not proven; 34 scenarios cover 8/8 paragraphs and 20/26 branches.

Live code no run reached:

- IF at line 141 in `PROCESS-ENTER-KEY`: never false
- EVALUATE at line 241 in `BUILD-MENU-OPTIONS`: `WHEN at line 254` never taken
- EVALUATE at line 241 in `BUILD-MENU-OPTIONS`: `WHEN at line 256` never taken
- EVALUATE at line 241 in `BUILD-MENU-OPTIONS`: `WHEN at line 258` never taken
- EVALUATE at line 241 in `BUILD-MENU-OPTIONS`: `WHEN at line 260` never taken
- EVALUATE at line 241 in `BUILD-MENU-OPTIONS`: `OTHER` never taken

## first-entry: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## no-commarea: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |

## option-1-user-list: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## option-2-add-user: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## option-3-update-user: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## option-4-delete-user: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## option-5-not-installed: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `RETURN` | `None` |

## option-6-not-installed: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `RETURN` | `None` |

## option-with-leading-zero: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## option-with-trailing-blank: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## option-past-the-last: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## option-zero: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## option-empty: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf3-sign-off: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## invalid-key: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## option-1-xctl-not-authorised: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
| 3 | (event) | `ABEND` | `None` |

## option-1-xctl-fails: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `RETURN` | `None` |

## pf3-xctl-not-authorised: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
| 3 | (event) | `ABEND` | `None` |

## pf3-xctl-fails: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `RETURN` | `None` |

## option-10: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## option-12: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## option-colon: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## option-less-than: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf3-blank-to-program: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## pf3-low-values-to-program: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## carried-commarea-fields: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## pf3-commarea-without-to-program: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## carried-account-and-card-fields: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## first-entry-carried-account-and-card-fields: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## no-commarea-xctl-fails: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf4-other-key: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## invalid-key-unread-option-field: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## short-commarea-146: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## short-commarea-159: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
