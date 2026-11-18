# COADM01C -- COBOL vs Java (ported), CICS

Case `carddemo-adminmenu`: aws-mainframe-modernization-carddemo `app/cbl/COADM01C.cbl`, transaction CA00, clock `2022/07/18 10:30:15.00`. Each scenario is one task; its events (SEND MAP, SEND TEXT, RETURN, XCTL, ABEND) are paired in order and compared field by field -- screen DATA fields and every COMMAREA field; a SEND MAP also its attribute, colour and highlight bytes, cursor and options (X'00' and X'40' are not claimed).

Stub files, from the engine's facts: 

| scenario | events equal | total |
|---|---|---|
| first-entry | 2 | 2 |
| no-commarea | 1 | 1 |
| option-1-user-list | 2 | 2 |
| option-2-add-user | 2 | 2 |
| option-3-update-user | 2 | 2 |
| option-4-delete-user | 2 | 2 |
| option-5-not-installed | 4 | 4 |
| option-6-not-installed | 4 | 4 |
| option-with-leading-zero | 2 | 2 |
| option-with-trailing-blank | 2 | 2 |
| option-past-the-last | 3 | 3 |
| option-zero | 3 | 3 |
| option-empty | 3 | 3 |
| pf3-sign-off | 2 | 2 |
| invalid-key | 3 | 3 |
| option-1-xctl-not-authorised | 3 | 3 |
| option-1-xctl-fails | 4 | 4 |
| pf3-xctl-not-authorised | 3 | 3 |
| pf3-xctl-fails | 4 | 4 |
| option-10 | 3 | 3 |
| option-12 | 3 | 3 |
| option-colon | 3 | 3 |
| option-less-than | 3 | 3 |
| pf3-blank-to-program | 2 | 2 |
| pf3-low-values-to-program | 2 | 2 |
| carried-commarea-fields | 2 | 2 |
| pf3-commarea-without-to-program | 2 | 2 |
| carried-account-and-card-fields | 2 | 2 |
| first-entry-carried-account-and-card-fields | 2 | 2 |
| no-commarea-xctl-fails | 3 | 3 |
| pf4-other-key | 3 | 3 |
| invalid-key-unread-option-field | 3 | 3 |
| short-commarea-146 | 2 | 2 |
| short-commarea-159 | 2 | 2 |

## Through the deployed entry points (java-facade, #4449)

Every scenario once more, entered through the program's Spring facade with the scenario's task handed to it through the joined region.

| scenario | events equal | total | entered by | verdict |
|---|---|---|---|---|
| first-entry | 2 | 2 | COADM01C.handleTransaction | pass |
| no-commarea | 1 | 1 | COADM01C.handleTransaction | pass |
| option-1-user-list | 2 | 2 | COADM01C.handleTransaction | pass |
| option-2-add-user | 2 | 2 | COADM01C.handleTransaction | pass |
| option-3-update-user | 2 | 2 | COADM01C.handleTransaction | pass |
| option-4-delete-user | 2 | 2 | COADM01C.handleTransaction | pass |
| option-5-not-installed | 4 | 4 | COADM01C.handleTransaction | pass |
| option-6-not-installed | 4 | 4 | COADM01C.handleTransaction | pass |
| option-with-leading-zero | 2 | 2 | COADM01C.handleTransaction | pass |
| option-with-trailing-blank | 2 | 2 | COADM01C.handleTransaction | pass |
| option-past-the-last | 3 | 3 | COADM01C.handleTransaction | pass |
| option-zero | 3 | 3 | COADM01C.handleTransaction | pass |
| option-empty | 3 | 3 | COADM01C.handleTransaction | pass |
| pf3-sign-off | 2 | 2 | COADM01C.handleTransaction | pass |
| invalid-key | 3 | 3 | COADM01C.handleTransaction | pass |
| option-1-xctl-not-authorised | 3 | 3 | COADM01C.handleTransaction | pass |
| option-1-xctl-fails | 4 | 4 | COADM01C.handleTransaction | pass |
| pf3-xctl-not-authorised | 3 | 3 | COADM01C.handleTransaction | pass |
| pf3-xctl-fails | 4 | 4 | COADM01C.handleTransaction | pass |
| option-10 | 3 | 3 | COADM01C.handleTransaction | pass |
| option-12 | 3 | 3 | COADM01C.handleTransaction | pass |
| option-colon | 3 | 3 | COADM01C.handleTransaction | pass |
| option-less-than | 3 | 3 | COADM01C.handleTransaction | pass |
| pf3-blank-to-program | 2 | 2 | COADM01C.handleTransaction | pass |
| pf3-low-values-to-program | 2 | 2 | COADM01C.handleTransaction | pass |
| carried-commarea-fields | 2 | 2 | COADM01C.handleTransaction | pass |
| pf3-commarea-without-to-program | 2 | 2 | COADM01C.handleTransaction | pass |
| carried-account-and-card-fields | 2 | 2 | COADM01C.handleTransaction | pass |
| first-entry-carried-account-and-card-fields | 2 | 2 | COADM01C.handleTransaction | pass |
| no-commarea-xctl-fails | 3 | 3 | COADM01C.handleTransaction | pass |
| pf4-other-key | 3 | 3 | COADM01C.handleTransaction | pass |
| invalid-key-unread-option-field | 3 | 3 | COADM01C.handleTransaction | pass |
| short-commarea-146 | 2 | 2 | COADM01C.handleTransaction | pass |
| short-commarea-159 | 2 | 2 | COADM01C.handleTransaction | pass |

## COBOL coverage (#4023)

COADM01C: proven on 34 scenarios, covering 8/8 paragraphs and 20/26 branches.

Live code no run reached:

- IF at line 141 in `PROCESS-ENTER-KEY`: never false
- EVALUATE at line 241 in `BUILD-MENU-OPTIONS`: `WHEN at line 254` never taken
- EVALUATE at line 241 in `BUILD-MENU-OPTIONS`: `WHEN at line 256` never taken
- EVALUATE at line 241 in `BUILD-MENU-OPTIONS`: `WHEN at line 258` never taken
- EVALUATE at line 241 in `BUILD-MENU-OPTIONS`: `WHEN at line 260` never taken
- EVALUATE at line 241 in `BUILD-MENU-OPTIONS`: `OTHER` never taken
