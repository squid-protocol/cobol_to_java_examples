# COBIL00C -- COBOL vs Java (generated), CICS

Case `carddemo-billpay`: aws-mainframe-modernization-carddemo `app/cbl/COBIL00C.cbl`, transaction CB00, clock `2022/07/18 10:30:15.00`. Each scenario is one task; its events (SEND MAP, SEND TEXT, RETURN, XCTL, ABEND) are paired in order and compared field by field -- screen DATA fields and every COMMAREA field; a SEND MAP also its attribute, colour and highlight bytes, cursor and options (X'00' and X'40' are not claimed).

Stub files, from the engine's facts: `ACCTDAT` -> AWS.M2.CARDDEMO.ACCTDATA.VSAM.KSDS key 11@0; `CXACAIX` -> AWS.M2.CARDDEMO.CARDXREF.VSAM.KSDS key 11@25 via PATH AWS.M2.CARDDEMO.CARDXREF.VSAM.AIX.PATH, AIX AWS.M2.CARDDEMO.CARDXREF.VSAM.AIX; `TRANSACT` -> AWS.M2.CARDDEMO.TRANSACT.VSAM.KSDS key 16@0

| scenario | events equal | total |
|---|---|---|
| first-entry | 0 | 2 |
| no-commarea | 0 | 1 |
| first-entry-with-selected-account | 0 | 3 |
| first-entry-with-long-selected-account | 0 | 3 |
| show-balance | 0 | 3 |
| pay-the-balance | 0 | 4 |
| pay-lowercase-y | 0 | 4 |
| decline-payment | 0 | 3 |
| confirm-invalid | 0 | 3 |
| account-empty | 0 | 3 |
| account-not-found | 0 | 3 |
| nothing-to-pay | 0 | 3 |
| pf4-clear | 0 | 3 |
| pf3-back | 0 | 2 |
| invalid-key | 0 | 3 |
| account-read-io-error | 0 | 3 |
| write-io-error | 0 | 4 |
| rewrite-io-error | 0 | 5 |
| pf3-back-to-caller | 0 | 2 |
| xref-not-found | 0 | 5 |
| xref-io-error | 0 | 5 |
| xref-aix-dupkey | 0 | 5 |
| startbr-not-found | 0 | 4 |
| startbr-io-error | 0 | 4 |
| readprev-endfile | 0 | 4 |
| readprev-io-error | 0 | 5 |
| write-duprec | 0 | 4 |
| pf3-xctl-fails | 0 | 3 |
| pf3-xctl-not-authorised | 0 | 3 |
| short-commarea-200 | 0 | 3 |
| short-commarea-201 | 0 | 3 |
| decline-lowercase-n | 0 | 3 |
| full-commarea-carried | 0 | 3 |
| pay-balance-over-one-million | 0 | 4 |
| pay-balance-ten-integer-digits | 0 | 4 |

## COBOL coverage (#4023)

COBIL00C: not proven; 35 scenarios cover 16/16 paragraphs and 46/48 branches.

Live code no run reached:

- IF at line 275 in `RETURN-TO-PREV-SCREEN`: never true
- EVALUATE at line 387 in `UPDATE-ACCTDAT-FILE`: `WHEN at line 390` never taken

## first-entry: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## no-commarea: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `XCTL` | `None` |

## first-entry-with-selected-account: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## first-entry-with-long-selected-account: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## show-balance: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pay-the-balance: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `RETURN` | `None` |

## pay-lowercase-y: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `RETURN` | `None` |

## decline-payment: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## confirm-invalid: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-empty: differences

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

## nothing-to-pay: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf4-clear: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf3-back: differences

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

## account-read-io-error: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## write-io-error: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `RETURN` | `None` |

## rewrite-io-error: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `SEND-MAP` | `None` |
| 5 | (event) | `RETURN` | `None` |

## pf3-back-to-caller: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## xref-not-found: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `SEND-MAP` | `None` |
| 5 | (event) | `RETURN` | `None` |

## xref-io-error: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `SEND-MAP` | `None` |
| 5 | (event) | `RETURN` | `None` |

## xref-aix-dupkey: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `SEND-MAP` | `None` |
| 5 | (event) | `RETURN` | `None` |

## startbr-not-found: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `ABEND` | `None` |

## startbr-io-error: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `ABEND` | `None` |

## readprev-endfile: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `RETURN` | `None` |

## readprev-io-error: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `SEND-MAP` | `None` |
| 5 | (event) | `RETURN` | `None` |

## write-duprec: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `RETURN` | `None` |

## pf3-xctl-fails: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
| 3 | (event) | `ABEND` | `None` |

## pf3-xctl-not-authorised: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
| 3 | (event) | `ABEND` | `None` |

## short-commarea-200: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## short-commarea-201: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## decline-lowercase-n: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## full-commarea-carried: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pay-balance-over-one-million: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `RETURN` | `None` |

## pay-balance-ten-integer-digits: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `SEND-MAP` | `None` |
| 4 | (event) | `RETURN` | `None` |

## account-read-io-error: DISPLAY output differs

| line | COBOL | Java |
|---|---|---|
| 1 | `RESP:00000001GREAS:00000012{` | `None` |

## write-io-error: DISPLAY output differs

| line | COBOL | Java |
|---|---|---|
| 1 | `RESP:00000001GREAS:00000012{` | `None` |

## rewrite-io-error: DISPLAY output differs

| line | COBOL | Java |
|---|---|---|
| 1 | `RESP:00000001GREAS:00000012{` | `None` |

## xref-io-error: DISPLAY output differs

| line | COBOL | Java |
|---|---|---|
| 1 | `RESP:00000001GREAS:00000012{` | `None` |

## xref-aix-dupkey: DISPLAY output differs

| line | COBOL | Java |
|---|---|---|
| 1 | `RESP:00000001EREAS:00000014{` | `None` |

## startbr-not-found: DISPLAY output differs

| line | COBOL | Java |
|---|---|---|
| 1 | `RESP:00000001FREAS:00000003D` | `None` |

## startbr-io-error: DISPLAY output differs

| line | COBOL | Java |
|---|---|---|
| 1 | `RESP:00000001GREAS:00000012{` | `None` |
| 2 | `RESP:00000001FREAS:00000003D` | `None` |

## readprev-io-error: DISPLAY output differs

| line | COBOL | Java |
|---|---|---|
| 1 | `RESP:00000001GREAS:00000012{` | `None` |
