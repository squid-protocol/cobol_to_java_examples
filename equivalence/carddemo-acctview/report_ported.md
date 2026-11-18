# COACTVWC -- COBOL vs Java (ported), CICS

Case `carddemo-acctview`: aws-mainframe-modernization-carddemo `app/cbl/COACTVWC.cbl`, transaction CAVW, clock `2022/07/18 10:30:15.00`. Each scenario is one task; its events (SEND MAP, SEND TEXT, RETURN, XCTL, ABEND) are paired in order and compared field by field -- screen DATA fields and every COMMAREA field; a SEND MAP also its attribute, colour and highlight bytes, cursor and options (X'00' and X'40' are not claimed).

Stub files, from the engine's facts: `ACCTDAT` -> AWS.M2.CARDDEMO.ACCTDATA.VSAM.KSDS key 11@0; `CUSTDAT` -> AWS.M2.CARDDEMO.CUSTDATA.VSAM.KSDS key 9@0; `CXACAIX` -> AWS.M2.CARDDEMO.CARDXREF.VSAM.KSDS key 11@25 via PATH AWS.M2.CARDDEMO.CARDXREF.VSAM.AIX.PATH, AIX AWS.M2.CARDDEMO.CARDXREF.VSAM.AIX

| scenario | events equal | total |
|---|---|---|
| enter-from-menu | 2 | 2 |
| view-account | 3 | 3 |
| account-not-on-file | 3 | 3 |
| account-not-numeric | 3 | 3 |
| pf3-back-to-menu | 1 | 1 |
| xref-file-notopen | 3 | 3 |
| account-not-found | 3 | 3 |
| account-io-error | 3 | 3 |
| customer-not-found | 3 | 3 |
| account-and-customer-not-found | 3 | 3 |
| customer-file-disabled | 3 | 3 |
| reenter-carried-fields | 3 | 3 |
| star-account-id | 3 | 3 |
| blank-account-id | 3 | 3 |
| pf3-blank-caller | 1 | 1 |
| pf3-from-itself | 1 | 1 |
| context-two | 2 | 2 |
| no-commarea-enter | 2 | 2 |
| no-commarea-pf3 | 1 | 1 |
| large-balance-group-account | 3 | 3 |
| carried-account-status | 3 | 3 |
| pf15-back-to-menu | 1 | 1 |
| carried-middle-name-and-ids | 3 | 3 |
| pf3-low-values-caller | 1 | 1 |
| card-number-blank | 3 | 3 |
| card-number-comma-trailing-letter | 3 | 3 |
| card-number-inner-space | 3 | 3 |
| card-number-minus-sign | 3 | 3 |
| card-number-trailing-space | 3 | 3 |
| card-number-space-then-plus | 3 | 3 |
| card-number-plus-sign | 3 | 3 |
| card-number-letter-inside | 3 | 3 |
| card-number-all-letters | 3 | 3 |
| card-number-letter-digit-mix | 3 | 3 |
| card-number-point | 3 | 3 |
| pf3-xctl-fails-abend-routine | 4 | 4 |
| invalid-key-acts-as-enter | 3 | 3 |

## Through the deployed entry points (java-facade, #4449)

Every scenario once more, entered through the program's Spring facade with the scenario's task handed to it through the joined region.

| scenario | events equal | total | entered by | verdict |
|---|---|---|---|---|
| enter-from-menu | 2 | 2 | COACTVWC.handleTransaction | pass |
| view-account | 3 | 3 | COACTVWC.handleTransaction | pass |
| account-not-on-file | 3 | 3 | COACTVWC.handleTransaction | pass |
| account-not-numeric | 3 | 3 | COACTVWC.handleTransaction | pass |
| pf3-back-to-menu | 1 | 1 | COACTVWC.handleTransaction | pass |
| xref-file-notopen | 3 | 3 | COACTVWC.handleTransaction | pass |
| account-not-found | 3 | 3 | COACTVWC.handleTransaction | pass |
| account-io-error | 3 | 3 | COACTVWC.handleTransaction | pass |
| customer-not-found | 3 | 3 | COACTVWC.handleTransaction | pass |
| account-and-customer-not-found | 3 | 3 | COACTVWC.handleTransaction | pass |
| customer-file-disabled | 3 | 3 | COACTVWC.handleTransaction | pass |
| reenter-carried-fields | 3 | 3 | COACTVWC.handleTransaction | pass |
| star-account-id | 3 | 3 | COACTVWC.handleTransaction | pass |
| blank-account-id | 3 | 3 | COACTVWC.handleTransaction | pass |
| pf3-blank-caller | 1 | 1 | COACTVWC.handleTransaction | pass |
| pf3-from-itself | 1 | 1 | COACTVWC.handleTransaction | pass |
| context-two | 2 | 2 | COACTVWC.handleTransaction | pass |
| no-commarea-enter | 2 | 2 | COACTVWC.handleTransaction | pass |
| no-commarea-pf3 | 1 | 1 | COACTVWC.handleTransaction | pass |
| large-balance-group-account | 3 | 3 | COACTVWC.handleTransaction | pass |
| carried-account-status | 3 | 3 | COACTVWC.handleTransaction | pass |
| pf15-back-to-menu | 1 | 1 | COACTVWC.handleTransaction | pass |
| carried-middle-name-and-ids | 3 | 3 | COACTVWC.handleTransaction | pass |
| pf3-low-values-caller | 1 | 1 | COACTVWC.handleTransaction | pass |
| card-number-blank | 3 | 3 | COACTVWC.handleTransaction | pass |
| card-number-comma-trailing-letter | 3 | 3 | COACTVWC.handleTransaction | pass |
| card-number-inner-space | 3 | 3 | COACTVWC.handleTransaction | pass |
| card-number-minus-sign | 3 | 3 | COACTVWC.handleTransaction | pass |
| card-number-trailing-space | 3 | 3 | COACTVWC.handleTransaction | pass |
| card-number-space-then-plus | 3 | 3 | COACTVWC.handleTransaction | pass |
| card-number-plus-sign | 3 | 3 | COACTVWC.handleTransaction | pass |
| card-number-letter-inside | 3 | 3 | COACTVWC.handleTransaction | pass |
| card-number-all-letters | 3 | 3 | COACTVWC.handleTransaction | pass |
| card-number-letter-digit-mix | 3 | 3 | COACTVWC.handleTransaction | pass |
| card-number-point | 3 | 3 | COACTVWC.handleTransaction | pass |
| pf3-xctl-fails-abend-routine | 4 | 4 | COACTVWC.handleTransaction | pass |
| invalid-key-acts-as-enter | 3 | 3 | COACTVWC.handleTransaction | pass |

## COBOL coverage (#4023)

COACTVWC: proven on 37 scenarios, covering 32/32 paragraphs and 61/69 branches.

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
