# COBIL00C -- COBOL vs Java (ported), CICS

Case `carddemo-billpay`: aws-mainframe-modernization-carddemo `app/cbl/COBIL00C.cbl`, transaction CB00, clock `2022/07/18 10:30:15.00`. Each scenario is one task; its events (SEND MAP, SEND TEXT, RETURN, XCTL, ABEND) are paired in order and compared field by field -- screen DATA fields and every COMMAREA field; a SEND MAP also its attribute, colour and highlight bytes, cursor and options (X'00' and X'40' are not claimed).

Stub files, from the engine's facts: `ACCTDAT` -> AWS.M2.CARDDEMO.ACCTDATA.VSAM.KSDS key 11@0; `CXACAIX` -> AWS.M2.CARDDEMO.CARDXREF.VSAM.KSDS key 11@25 via PATH AWS.M2.CARDDEMO.CARDXREF.VSAM.AIX.PATH, AIX AWS.M2.CARDDEMO.CARDXREF.VSAM.AIX; `TRANSACT` -> AWS.M2.CARDDEMO.TRANSACT.VSAM.KSDS key 16@0

| scenario | events equal | total |
|---|---|---|
| first-entry | 2 | 2 |
| no-commarea | 1 | 1 |
| first-entry-with-selected-account | 3 | 3 |
| first-entry-with-long-selected-account | 3 | 3 |
| show-balance | 3 | 3 |
| pay-the-balance | 4 | 4 |
| pay-lowercase-y | 4 | 4 |
| decline-payment | 3 | 3 |
| confirm-invalid | 3 | 3 |
| account-empty | 3 | 3 |
| account-not-found | 3 | 3 |
| nothing-to-pay | 3 | 3 |
| pf4-clear | 3 | 3 |
| pf3-back | 2 | 2 |
| invalid-key | 3 | 3 |
| account-read-io-error | 3 | 3 |
| write-io-error | 4 | 4 |
| rewrite-io-error | 5 | 5 |
| pf3-back-to-caller | 2 | 2 |
| xref-not-found | 5 | 5 |
| xref-io-error | 5 | 5 |
| xref-aix-dupkey | 5 | 5 |
| startbr-not-found | 4 | 4 |
| startbr-io-error | 4 | 4 |
| readprev-endfile | 4 | 4 |
| readprev-io-error | 5 | 5 |
| write-duprec | 4 | 4 |
| pf3-xctl-fails | 3 | 3 |
| pf3-xctl-not-authorised | 3 | 3 |
| short-commarea-200 | 3 | 3 |
| short-commarea-201 | 3 | 3 |
| decline-lowercase-n | 3 | 3 |
| full-commarea-carried | 3 | 3 |
| pay-balance-over-one-million | 4 | 4 |
| pay-balance-ten-integer-digits | 4 | 4 |

## Through the deployed entry points (java-facade, #4449)

Every scenario once more, entered through the program's Spring facade with the scenario's task handed to it through the joined region.

| scenario | events equal | total | entered by | verdict |
|---|---|---|---|---|
| first-entry | 2 | 2 | COBIL00C.handleTransaction | pass |
| no-commarea | 1 | 1 | COBIL00C.handleTransaction | pass |
| first-entry-with-selected-account | 3 | 3 | COBIL00C.handleTransaction | pass |
| first-entry-with-long-selected-account | 3 | 3 | COBIL00C.handleTransaction | pass |
| show-balance | 3 | 3 | COBIL00C.handleTransaction | pass |
| pay-the-balance | 4 | 4 | COBIL00C.handleTransaction | pass |
| pay-lowercase-y | 4 | 4 | COBIL00C.handleTransaction | pass |
| decline-payment | 3 | 3 | COBIL00C.handleTransaction | pass |
| confirm-invalid | 3 | 3 | COBIL00C.handleTransaction | pass |
| account-empty | 3 | 3 | COBIL00C.handleTransaction | pass |
| account-not-found | 3 | 3 | COBIL00C.handleTransaction | pass |
| nothing-to-pay | 3 | 3 | COBIL00C.handleTransaction | pass |
| pf4-clear | 3 | 3 | COBIL00C.handleTransaction | pass |
| pf3-back | 2 | 2 | COBIL00C.handleTransaction | pass |
| invalid-key | 3 | 3 | COBIL00C.handleTransaction | pass |
| account-read-io-error | 3 | 3 | COBIL00C.handleTransaction | pass |
| write-io-error | 4 | 4 | COBIL00C.handleTransaction | pass |
| rewrite-io-error | 5 | 5 | COBIL00C.handleTransaction | pass |
| pf3-back-to-caller | 2 | 2 | COBIL00C.handleTransaction | pass |
| xref-not-found | 5 | 5 | COBIL00C.handleTransaction | pass |
| xref-io-error | 5 | 5 | COBIL00C.handleTransaction | pass |
| xref-aix-dupkey | 5 | 5 | COBIL00C.handleTransaction | pass |
| startbr-not-found | 4 | 4 | COBIL00C.handleTransaction | pass |
| startbr-io-error | 4 | 4 | COBIL00C.handleTransaction | pass |
| readprev-endfile | 4 | 4 | COBIL00C.handleTransaction | pass |
| readprev-io-error | 5 | 5 | COBIL00C.handleTransaction | pass |
| write-duprec | 4 | 4 | COBIL00C.handleTransaction | pass |
| pf3-xctl-fails | 3 | 3 | COBIL00C.handleTransaction | pass |
| pf3-xctl-not-authorised | 3 | 3 | COBIL00C.handleTransaction | pass |
| short-commarea-200 | 3 | 3 | COBIL00C.handleTransaction | pass |
| short-commarea-201 | 3 | 3 | COBIL00C.handleTransaction | pass |
| decline-lowercase-n | 3 | 3 | COBIL00C.handleTransaction | pass |
| full-commarea-carried | 3 | 3 | COBIL00C.handleTransaction | pass |
| pay-balance-over-one-million | 4 | 4 | COBIL00C.handleTransaction | pass |
| pay-balance-ten-integer-digits | 4 | 4 | COBIL00C.handleTransaction | pass |

## COBOL coverage (#4023)

COBIL00C: proven on 35 scenarios, covering 16/16 paragraphs and 46/48 branches.

Live code no run reached:

- IF at line 275 in `RETURN-TO-PREV-SCREEN`: never true
- EVALUATE at line 387 in `UPDATE-ACCTDAT-FILE`: `WHEN at line 390` never taken
