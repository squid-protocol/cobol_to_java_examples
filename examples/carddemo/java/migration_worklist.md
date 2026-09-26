# Migration worklist

Every TODO the generators left in this project: where a fact was missing or two facts disagreed, the Java says so instead of guessing. Each item names the fact it rests on (from `traceability.json`) and a suggested resolution.

**277 items** across 47 program sources (COBOL, PL/I).

| nature | items | what it takes |
|---|---:|---|
| conflict | 31 | two facts disagree: a person decides which one the Java follows |
| fact-gap | 5 | a fact is missing: supply it and re-run |
| review | 55 | the Java runs as generated: check it on the target |
| port | 186 | business logic to write |

## By category

| category | nature | items | suggested resolution |
|---|---|---:|---|
| [COMMAREA layout mismatches](#commarea-mismatch) | conflict | 20 | For each caller, confirm which layout the callee reads (the COBOL MOVEs into DFHCOMMAREA say); map that caller's record onto the DTO, or give the callee one DTO per entry. |
| [Programs reading another record layout](#record-variant) | conflict | 11 | Map the program's record onto the entity's fields (or split the entity); the two layouts' sizes are in the TODO. |
| [Unresolved layouts](#missing-layout) | fact-gap | 3 | Add the missing copybook / %INCLUDE member or record to the repository and re-run; the DTO then gets its real fields. |
| [Keys that are not one field](#vsam-key) | fact-gap | 2 | Name the key: split the record so the key is one field, or keep the String vsamKey in step with the record; for a browse, add a range query over the key. |
| [Utility job steps to port](#batch-utility) | port | 6 | Replace the utility with its Spring Batch equivalent (SORT -> a sorting step, IDCAMS REPRO -> a copy, a TSO / IMS runner -> the program's runBatch), reading its control statements in SYSIN. |
| [CICS responses the COBOL never tests](#unchecked-resp) | review | 40 | Decide what a failed call does: the COBOL ignores it, so the Java throws; catch it where the old behaviour (carry on) is really wanted. |
| [DB2 SQL on another database](#db2-dialect) | review | 14 | Run each statement on the target database; DB2-only syntax (FETCH FIRST, WITH UR, special registers) needs its equivalent. |
| [Unit-of-work boundaries to split](#transaction-split) | port | 14 | End the transaction at the SYNCPOINT the comment cites: a nested REQUIRES_NEW call, or two service methods. |
| [Calls to other services](#interface-call) | port | 1 | Wire the called service (or a mock) in place of the placeholder. |
| [Business logic to port](#business-logic) | port | 165 | Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch. |
| [Target configuration](#configuration) | review | 1 | Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file. |

## By program source

| source | conflict | fact-gap | review | port | total |
|---|---:|---:|---:|---:|---:|
| `app/app-transaction-type-db2/cbl/COTRTUPC.cbl` | 2 |  | 7 | 11 | 20 |
| `app/app-transaction-type-db2/cbl/COTRTLIC.cbl` | 1 |  | 7 | 8 | 16 |
| `app/cbl/COACTUPC.cbl` | 1 |  | 3 | 8 | 12 |
| `app/cbl/COCRDUPC.cbl` | 1 |  | 3 | 8 | 12 |
| `app/cbl/COACTVWC.cbl` | 1 |  | 3 | 7 | 11 |
| `app/cbl/COCRDSLC.cbl` | 1 |  | 3 | 7 | 11 |
| `app/cbl/COCRDLIC.cbl` | 1 |  | 4 | 5 | 10 |
| `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl` | 1 |  | 1 | 6 | 8 |
| `app/cbl/COADM01C.cbl` | 1 |  | 1 | 6 | 8 |
| `app/cbl/CORPT00C.cbl` | 1 |  | 1 | 6 | 8 |
| `app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl` |  |  | 3 | 4 | 7 |
| `app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl` |  |  | 1 | 6 | 7 |
| `app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl` |  |  | 4 | 3 | 7 |
| `app/cbl/COBIL00C.cbl` | 1 |  | 1 | 5 | 7 |
| `app/cbl/COMEN01C.cbl` | 1 |  | 1 | 5 | 7 |
| `app/cbl/COSGN00C.cbl` |  | 1 | 1 | 5 | 7 |
| `app/cbl/COTRN00C.cbl` | 1 |  | 1 | 5 | 7 |
| `app/cbl/COTRN01C.cbl` | 1 |  | 1 | 5 | 7 |
| `app/cbl/COTRN02C.cbl` | 1 |  | 1 | 5 | 7 |
| `app/cbl/COUSR00C.cbl` | 1 |  | 1 | 5 | 7 |
| `app/cbl/COUSR01C.cbl` | 1 |  | 1 | 5 | 7 |
| `app/cbl/COUSR02C.cbl` | 1 |  | 1 | 5 | 7 |
| `app/cbl/COUSR03C.cbl` | 1 |  | 1 | 5 | 7 |
| `app/app-transaction-type-db2/cbl/COBTUPDT.cbl` |  |  | 3 | 2 | 5 |
| `app/app-vsam-mq/cbl/COACCT01.cbl` |  | 1 |  | 4 | 5 |
| `app/app-vsam-mq/cbl/CODATE01.cbl` |  | 1 |  | 4 | 5 |
| `app/cbl/CBTRN02C.cbl` | 3 |  |  | 2 | 5 |
| `app/cbl/CBACT04C.cbl` | 2 |  |  | 2 | 4 |
| `app/cbl/CBACT01C.cbl` | 1 |  |  | 2 | 3 |
| `app/cbl/CBACT02C.cbl` | 1 |  |  | 2 | 3 |
| `app/cbl/CBACT03C.cbl` | 1 |  |  | 2 | 3 |
| `app/cbl/CBCUS01C.cbl` | 1 |  |  | 2 | 3 |
| `app/cbl/CBEXPORT.cbl` | 1 |  |  | 2 | 3 |
| `app/cbl/CBTRN03C.cbl` | 1 |  |  | 2 | 3 |
| `app/jcl/CBEXPORT.jcl` |  | 2 |  | 1 | 3 |
| `app/jcl/CREASTMT.JCL` |  |  |  | 3 | 3 |
| `app/app-authorization-ims-db2-mq/cbl/CBPAUP0C.cbl` |  |  |  | 2 | 2 |
| `app/app-authorization-ims-db2-mq/cbl/DBUNLDGS.CBL` |  |  |  | 2 | 2 |
| `app/app-authorization-ims-db2-mq/cbl/PAUDBLOD.CBL` |  |  |  | 2 | 2 |
| `app/app-authorization-ims-db2-mq/cbl/PAUDBUNL.CBL` |  |  |  | 2 | 2 |
| `app/cbl/CBIMPORT.cbl` |  |  |  | 2 | 2 |
| `app/cbl/CBSTM03A.CBL` |  |  |  | 2 | 2 |
| `app/cbl/CBSTM03B.CBL` |  |  |  | 2 | 2 |
| `app/cbl/COBSWAIT.cbl` |  |  |  | 2 | 2 |
| `app/cbl/CSUTLDTC.cbl` |  |  |  | 2 | 2 |
| `app/jcl/TRANREPT.jcl` |  |  |  | 2 | 2 |
| `(project configuration)` |  |  | 1 |  | 1 |
| `app/cbl/CBTRN01C.cbl` |  |  |  | 1 | 1 |

<a id="commarea-mismatch"></a>
## COMMAREA layout mismatches (conflict)

_Resolution:_ For each caller, confirm which layout the callee reads (the COBOL MOVEs into DFHCOMMAREA say); map that caller's record onto the DTO, or give the callee one DTO per entry.

**`app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl`**

- [ ] **WL-0001** `src/main/java/com/gitgalaxy/modernized/controller/Copaus0cController.java:13` (`Copaus0cController#link`, `Copaus0cController#transactionCPVS`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:254
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:322`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:674`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl:367`, CICS resources (open (5 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTLIC.cbl`**

- [ ] **WL-0002** `src/main/java/com/gitgalaxy/modernized/controller/CotrtlicController.java:13` (`CotrtlicController#link`, `CotrtlicController#transactionCTLI`): callers also pass WS-COMMAREA (app/app-transaction-type-db2/cbl/COTRTLIC.cbl, 2000 bytes) at app/app-transaction-type-db2/cbl/COTRTLIC.cbl:910
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-transaction-type-db2/csd/CRDDEMOD.csd:11`, entry transactions (open (4 public / 0 private estates))
  - fact: `app/app-transaction-type-db2/csd/CRDDEMOD.csd:25`, entry transactions (open (4 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTUPC.cbl`**

- [ ] **WL-0003** `src/main/java/com/gitgalaxy/modernized/controller/CotrtupcController.java:13` (`CotrtupcController#link`, `CotrtupcController#transactionCTTU`): callers also pass WS-COMMAREA (app/app-transaction-type-db2/cbl/COTRTUPC.cbl, 2000 bytes) at app/app-transaction-type-db2/cbl/COTRTUPC.cbl:567
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:620`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:648`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0004** `src/main/java/com/gitgalaxy/modernized/controller/CotrtupcController.java:14` (`CotrtupcController#link`, `CotrtupcController#transactionCTTU`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/app-transaction-type-db2/cbl/COTRTLIC.cbl:648
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:620`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:648`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COACTUPC.cbl`**

- [ ] **WL-0005** `src/main/java/com/gitgalaxy/modernized/controller/CoactupcController.java:13` (`CoactupcController#link`, `CoactupcController#transactionCAUP`): callers also pass WS-COMMAREA (app/cbl/COACTUPC.cbl, 2000 bytes) at app/cbl/COACTUPC.cbl:1015
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:306`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COACTVWC.cbl`**

- [ ] **WL-0006** `src/main/java/com/gitgalaxy/modernized/controller/CoactvwcController.java:13` (`CoactvwcController#link`, `CoactvwcController#transactionCAVW`): callers also pass WS-COMMAREA (app/cbl/COACTVWC.cbl, 2000 bytes) at app/cbl/COACTVWC.cbl:402
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:181`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COADM01C.cbl`**

- [ ] **WL-0007** `src/main/java/com/gitgalaxy/modernized/controller/Coadm01cController.java:13` (`Coadm01cController#link`, `Coadm01cController#transactionCA00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COADM01C.cbl:111, app/cbl/COADM01C.cbl:280, app/cbl/COSGN00C.cbl:231
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:620`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:457`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COSGN00C.cbl:231`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COBIL00C.cbl`**

- [ ] **WL-0008** `src/main/java/com/gitgalaxy/modernized/controller/Cobil00cController.java:13` (`Cobil00cController#link`, `Cobil00cController#transactionCB00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 218 bytes) at app/cbl/COBIL00C.cbl:146
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:337`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COCRDLIC.cbl`**

- [ ] **WL-0009** `src/main/java/com/gitgalaxy/modernized/controller/CocrdlicController.java:13` (`CocrdlicController#link`, `CocrdlicController#transactionCC00`, `CocrdlicController#transactionCCLI`): callers also pass WS-COMMAREA (app/cbl/COCRDLIC.cbl, 2000 bytes) at app/cbl/COCRDLIC.cbl:615
  - fact: `app/cbl/COCRDLIC.cbl:538`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COCRDLIC.cbl:566`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COCRDSLC.cbl`**

- [ ] **WL-0010** `src/main/java/com/gitgalaxy/modernized/controller/CocrdslcController.java:13` (`CocrdslcController#link`, `CocrdslcController#transactionCCDL`): callers also pass WS-COMMAREA (app/cbl/COCRDSLC.cbl, 2000 bytes) at app/cbl/COCRDSLC.cbl:402
  - fact: `app/cbl/COCRDLIC.cbl:538`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COCRDLIC.cbl:566`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COCRDUPC.cbl`**

- [ ] **WL-0011** `src/main/java/com/gitgalaxy/modernized/controller/CocrdupcController.java:13` (`CocrdupcController#link`, `CocrdupcController#transactionCCUP`): callers also pass WS-COMMAREA (app/cbl/COCRDUPC.cbl, 2000 bytes) at app/cbl/COCRDUPC.cbl:554
  - fact: `app/cbl/COCRDLIC.cbl:538`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COCRDLIC.cbl:566`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COMEN01C.cbl`**

- [ ] **WL-0012** `src/main/java/com/gitgalaxy/modernized/controller/Comen01cController.java:13` (`Comen01cController#link`, `Comen01cController#transactionCM00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COCRDLIC.cbl:402, app/cbl/COMEN01C.cbl:107, app/cbl/COSGN00C.cbl:236
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:322`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:674`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COACTUPC.cbl:956`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/CORPT00C.cbl`**

- [ ] **WL-0013** `src/main/java/com/gitgalaxy/modernized/controller/Corpt00cController.java:13` (`Corpt00cController#link`, `Corpt00cController#transactionCR00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/CORPT00C.cbl:199, app/cbl/CORPT00C.cbl:587
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:409`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COTRN00C.cbl`**

- [ ] **WL-0014** `src/main/java/com/gitgalaxy/modernized/controller/Cotrn00cController.java:13` (`Cotrn00cController#link`, `Cotrn00cController#transactionCT00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 218 bytes) at app/cbl/COTRN00C.cbl:138
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COTRN01C.cbl:205`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COTRN01C.cbl`**

- [ ] **WL-0015** `src/main/java/com/gitgalaxy/modernized/controller/Cotrn01cController.java:13` (`Cotrn01cController#link`, `Cotrn01cController#transactionCT01`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 218 bytes) at app/cbl/COTRN01C.cbl:136
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COTRN00C.cbl:192`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COTRN02C.cbl`**

- [ ] **WL-0016** `src/main/java/com/gitgalaxy/modernized/controller/Cotrn02cController.java:13` (`Cotrn02cController#link`, `Cotrn02cController#transactionCT02`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COTRN02C.cbl:156, app/cbl/COTRN02C.cbl:530
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:439`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COUSR00C.cbl`**

- [ ] **WL-0017** `src/main/java/com/gitgalaxy/modernized/controller/Cousr00cController.java:13` (`Cousr00cController#link`, `Cousr00cController#transactionCU00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 194 bytes) at app/cbl/COUSR00C.cbl:141
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:449`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COUSR01C.cbl`**

- [ ] **WL-0018** `src/main/java/com/gitgalaxy/modernized/controller/Cousr01cController.java:13` (`Cousr01cController#link`, `Cousr01cController#transactionCU01`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COUSR01C.cbl:107
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:459`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COUSR02C.cbl`**

- [ ] **WL-0019** `src/main/java/com/gitgalaxy/modernized/controller/Cousr02cController.java:13` (`Cousr02cController#link`, `Cousr02cController#transactionCU02`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COUSR02C.cbl:135
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COUSR00C.cbl:196`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COUSR00C.cbl:206`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COUSR03C.cbl`**

- [ ] **WL-0020** `src/main/java/com/gitgalaxy/modernized/controller/Cousr03cController.java:13` (`Cousr03cController#link`, `Cousr03cController#transactionCU03`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COUSR03C.cbl:134
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COUSR00C.cbl:196`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COUSR00C.cbl:206`, CICS resources (open (5 public / 0 private estates))

<a id="record-variant"></a>
## Programs reading another record layout (conflict)

_Resolution:_ Map the program's record onto the entity's fields (or split the entity); the two layouts' sizes are in the TODO.

**`app/cbl/CBACT01C.cbl`**

- [ ] **WL-0021** `src/main/java/com/gitgalaxy/modernized/service/Cbact01cService.java:28` (`Cbact01cService#readAllAcctfileFile`): this program uses FD-ACCTFILE-REC (300 bytes); the entity follows ACCOUNT-RECORD (300 bytes) -- map one onto the other
  - fact: `app/cbl/CBACT01C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBACT02C.cbl`**

- [ ] **WL-0022** `src/main/java/com/gitgalaxy/modernized/service/Cbact02cService.java:28` (`Cbact02cService#readAllCardfileFile`): this program uses FD-CARDFILE-REC (150 bytes); the entity follows CARD-RECORD (150 bytes) -- map one onto the other
  - fact: `app/cbl/CBACT02C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBACT03C.cbl`**

- [ ] **WL-0023** `src/main/java/com/gitgalaxy/modernized/service/Cbact03cService.java:28` (`Cbact03cService#readAllXreffileFile`): this program uses FD-XREFFILE-REC (50 bytes); the entity follows CARD-XREF-RECORD (50 bytes) -- map one onto the other
  - fact: `app/cbl/CBACT03C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBACT04C.cbl`**

- [ ] **WL-0024** `src/main/java/com/gitgalaxy/modernized/service/Cbact04cService.java:39` (`Cbact04cService#readAccountFile`, `Cbact04cService#rewriteAccountFile`): this program uses FD-ACCTFILE-REC (300 bytes); the entity follows ACCOUNT-RECORD (300 bytes) -- map one onto the other
  - fact: `app/cbl/CBACT04C.cbl`, VSAM defines (open (3 public / 0 private estates))
- [ ] **WL-0025** `src/main/java/com/gitgalaxy/modernized/service/Cbact04cService.java:49` (`Cbact04cService#readXrefFile`): this program uses FD-XREFFILE-REC (50 bytes); the entity follows CARD-XREF-RECORD (50 bytes) -- map one onto the other
  - fact: `app/cbl/CBACT04C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBCUS01C.cbl`**

- [ ] **WL-0026** `src/main/java/com/gitgalaxy/modernized/service/Cbcus01cService.java:28` (`Cbcus01cService#readAllCustfileFile`): this program uses FD-CUSTFILE-REC (500 bytes); the entity follows CUSTOMER-RECORD (500 bytes) -- map one onto the other
  - fact: `app/cbl/CBCUS01C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBEXPORT.cbl`**

- [ ] **WL-0027** `src/main/java/com/gitgalaxy/modernized/service/CbexportService.java:63` (`CbexportService#writeExportOutput`): this program uses EXPORT-OUTPUT-RECORD (500 bytes); the entity follows EXPORT-INPUT-RECORD (500 bytes) -- map one onto the other
  - fact: `app/cbl/CBEXPORT.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBTRN02C.cbl`**

- [ ] **WL-0028** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn02cService.java:38` (`Cbtrn02cService#readAccountFile`, `Cbtrn02cService#rewriteAccountFile`): this program uses FD-ACCTFILE-REC (300 bytes); the entity follows ACCOUNT-RECORD (300 bytes) -- map one onto the other
  - fact: `app/cbl/CBTRN02C.cbl`, VSAM defines (open (3 public / 0 private estates))
- [ ] **WL-0029** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn02cService.java:48` (`Cbtrn02cService#readXrefFile`): this program uses FD-XREFFILE-REC (50 bytes); the entity follows CARD-XREF-RECORD (50 bytes) -- map one onto the other
  - fact: `app/cbl/CBTRN02C.cbl`, VSAM defines (open (3 public / 0 private estates))
- [ ] **WL-0030** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn02cService.java:63` (`Cbtrn02cService#writeTransactFile`): this program uses FD-TRANFILE-REC (350 bytes); the entity follows TRAN-RECORD (350 bytes) -- map one onto the other
  - fact: `app/cbl/CBTRN02C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBTRN03C.cbl`**

- [ ] **WL-0031** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn03cService.java:35` (`Cbtrn03cService#readXrefFile`): this program uses FD-CARDXREF-REC (50 bytes); the entity follows CARD-XREF-RECORD (50 bytes) -- map one onto the other
  - fact: `app/cbl/CBTRN03C.cbl`, VSAM defines (open (3 public / 0 private estates))

<a id="missing-layout"></a>
## Unresolved layouts (fact-gap)

_Resolution:_ Add the missing copybook / %INCLUDE member or record to the repository and re-run; the DTO then gets its real fields.

**`app/app-vsam-mq/cbl/COACCT01.cbl`**

- [ ] **WL-0032** `src/main/java/com/gitgalaxy/modernized/controller/Coacct01Controller.java:11` (`Coacct01Controller#transactionCDRA`): no COMMAREA layout: no LINKAGE DFHCOMMAREA, and no resolved caller passes this program a COMMAREA
  - fact: `app/app-vsam-mq/csd/CRDDEMOM.csd:1`, entry transactions (open (4 public / 0 private estates))
  - fact: `app/app-vsam-mq/csd/CRDDEMOM.csd:17`, entry transactions (open (4 public / 0 private estates))

**`app/app-vsam-mq/cbl/CODATE01.cbl`**

- [ ] **WL-0033** `src/main/java/com/gitgalaxy/modernized/controller/Codate01Controller.java:11` (`Codate01Controller#transactionCDRD`): no COMMAREA layout: no LINKAGE DFHCOMMAREA, and no resolved caller passes this program a COMMAREA
  - fact: `app/app-vsam-mq/csd/CRDDEMOM.csd:9`, entry transactions (open (4 public / 0 private estates))
  - fact: `app/app-vsam-mq/csd/CRDDEMOM.csd:27`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COSGN00C.cbl`**

- [ ] **WL-0034** `src/main/java/com/gitgalaxy/modernized/controller/Cosgn00cController.java:11` (`Cosgn00cController#link`, `Cosgn00cController#transactionCC00`): no COMMAREA layout: DFHCOMMAREA is variable-length or of unknown width, and no resolved LINK / XCTL / RETURN TRANSID passes this program a record
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:322`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:674`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COADM01C.cbl:168`, CICS resources (open (5 public / 0 private estates))

<a id="vsam-key"></a>
## Keys that are not one field (fact-gap)

_Resolution:_ Name the key: split the record so the key is one field, or keep the String vsamKey in step with the record; for a browse, add a range query over the key.

**`app/jcl/CBEXPORT.jcl`**

- [ ] **WL-0035** `src/main/java/com/gitgalaxy/modernized/entity/vsam/ExportInputRecord.java:12` (`ExportInputRecord`): the key (offset 28, 4 bytes, from IDCAMS KEYS) is not one field of EXPORT-INPUT-RECORD: carried as the String vsamKey -- keep it in step with the record
  - fact: `app/jcl/CBEXPORT.jcl:30`, VSAM defines (open (3 public / 0 private estates))
- [ ] **WL-0036** `src/main/java/com/gitgalaxy/modernized/entity/vsam/ExportInputRecord.java:21`: the key (offset 28, 4 bytes, from IDCAMS KEYS) is not one field of EXPORT-INPUT-RECORD: carried as the String vsamKey -- keep it in step with the record

<a id="batch-utility"></a>
## Utility job steps to port (port)

_Resolution:_ Replace the utility with its Spring Batch equivalent (SORT -> a sorting step, IDCAMS REPRO -> a copy, a TSO / IMS runner -> the program's runBatch), reading its control statements in SYSIN.

**`app/jcl/CBEXPORT.jcl`**

- [ ] **WL-0037** `src/main/java/com/gitgalaxy/modernized/batch/CbexportJobConfig.java` (`CbexportJobConfig#STEP01`): STEP01 runs the utility IDCAMS (its control statements are in SYSIN) -- a utility step to port
  - fact: `app/jcl/CBEXPORT.jcl:24`, JCL job flow (open (5 public / 0 private estates))

**`app/jcl/CREASTMT.JCL`**

- [ ] **WL-0038** `src/main/java/com/gitgalaxy/modernized/batch/CreastmtJobConfig.java` (`CreastmtJobConfig#DELDEF01`): DELDEF01 runs the utility IDCAMS (its control statements are in SYSIN) -- a utility step to port
  - fact: `app/jcl/CREASTMT.JCL:22`, JCL job flow (open (5 public / 0 private estates))
- [ ] **WL-0039** `src/main/java/com/gitgalaxy/modernized/batch/CreastmtJobConfig.java` (`CreastmtJobConfig#STEP010`): STEP010 runs the utility SORT (its control statements are in SYSIN) -- a utility step to port
  - fact: `app/jcl/CREASTMT.JCL:44`, JCL job flow (open (5 public / 0 private estates))
- [ ] **WL-0040** `src/main/java/com/gitgalaxy/modernized/batch/CreastmtJobConfig.java` (`CreastmtJobConfig#STEP020`): STEP020 runs the utility IDCAMS (its control statements are in SYSIN) -- a utility step to port
  - fact: `app/jcl/CREASTMT.JCL:56`, JCL job flow (open (5 public / 0 private estates))

**`app/jcl/TRANREPT.jcl`**

- [ ] **WL-0041** `src/main/java/com/gitgalaxy/modernized/batch/TranreptJobConfig.java` (`TranreptJobConfig#STEP05R`): STEP05R runs the utility SORT (its control statements are in SYSIN) -- a utility step to port
  - fact: `app/jcl/TRANREPT.jcl:37`, JCL job flow (open (5 public / 0 private estates))
- [ ] **WL-0042** `src/main/java/com/gitgalaxy/modernized/batch/TranreptJobConfig.java` (`TranreptJobConfig#STEP05R.PRC001`): STEP05R.PRC001 runs the utility IDCAMS (its control statements are in SYSIN) -- a utility step to port
  - fact: `app/jcl/TRANREPT.jcl:23`, JCL job flow (open (5 public / 0 private estates))

<a id="unchecked-resp"></a>
## CICS responses the COBOL never tests (review)

_Resolution:_ Decide what a failed call does: the COBOL ignores it, so the Java throws; catch it where the old behaviour (carry on) is really wanted.

**`app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl`**

- [ ] **WL-0043** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:27` (`Copaua0cService`): the RESP of ASKTIME at line 857 (paragraph 8500-INSERT-AUTH) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl:857`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0044** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:28` (`Copaua0cService`): the RESP of ASKTIME at line 986 (paragraph 9500-LOG-ERROR) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl:986`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0045** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:29` (`Copaua0cService`): the RESP of WRITEQ at line 1001 (paragraph 9500-LOG-ERROR) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl:1001`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl`**

- [ ] **WL-0046** `src/main/java/com/gitgalaxy/modernized/service/Copaus0cService.java:28` (`Copaus0cService`): the RESP of RECEIVE at line 715 (paragraph RECEIVE-PAULST-SCREEN) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:715`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl`**

- [ ] **WL-0047** `src/main/java/com/gitgalaxy/modernized/service/Copaus1cService.java:19` (`Copaus1cService`): the RESP of RECEIVE at line 400 (paragraph RECEIVE-AUTHVIEW-SCREEN) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl:400`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl`**

- [ ] **WL-0048** `src/main/java/com/gitgalaxy/modernized/service/Copaus2cService.java:13` (`Copaus2cService`): the RESP of ASKTIME at line 91 (paragraph MAIN-PARA) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl:91`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0049** `src/main/java/com/gitgalaxy/modernized/service/Copaus2cService.java:14` (`Copaus2cService`): the RESP of FORMATTIME at line 95 (paragraph MAIN-PARA) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl:95`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTLIC.cbl`**

- [ ] **WL-0050** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:18` (`CotrtlicService`): the RESP of RECEIVE at line 931 (paragraph 1100-RECEIVE-SCREEN) is never tested
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:931`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0051** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:19` (`CotrtlicService`): the RESP of SEND at line 1588 (paragraph 2600-SEND-SCREEN) is never tested
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:1588`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTUPC.cbl`**

- [ ] **WL-0052** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:18` (`CotrtupcService`): the RESP of RECEIVE at line 642 (paragraph 1100-RECEIVE-MAP) is never tested
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:642`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0053** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:19` (`CotrtupcService`): the RESP of SEND at line 1433 (paragraph 3400-SEND-SCREEN) is never tested
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1433`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0054** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:20` (`CotrtupcService`): the RESP of SEND at line 1684 (paragraph ABEND-ROUTINE) is never tested
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1684`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COACTUPC.cbl`**

- [ ] **WL-0055** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:33` (`CoactupcService`): the RESP of RECEIVE at line 1040 (paragraph 1100-RECEIVE-MAP) is never tested
  - fact: `app/cbl/COACTUPC.cbl:1040`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0056** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:34` (`CoactupcService`): the RESP of SEND at line 3594 (paragraph 3400-SEND-SCREEN) is never tested
  - fact: `app/cbl/COACTUPC.cbl:3594`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0057** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:35` (`CoactupcService`): the RESP of SEND at line 4211 (paragraph ABEND-ROUTINE) is never tested
  - fact: `app/cbl/COACTUPC.cbl:4211`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COACTVWC.cbl`**

- [ ] **WL-0058** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:29` (`CoactvwcService`): the RESP of SEND at line 583 (paragraph 1400-SEND-SCREEN) is never tested
  - fact: `app/cbl/COACTVWC.cbl:583`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0059** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:30` (`CoactvwcService`): the RESP of RECEIVE at line 611 (paragraph 2100-RECEIVE-MAP) is never tested
  - fact: `app/cbl/COACTVWC.cbl:611`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0060** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:31` (`CoactvwcService`): the RESP of SEND at line 924 (paragraph ABEND-ROUTINE) is never tested
  - fact: `app/cbl/COACTVWC.cbl:924`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COADM01C.cbl`**

- [ ] **WL-0061** `src/main/java/com/gitgalaxy/modernized/service/Coadm01cService.java:19` (`Coadm01cService`): the RESP of RECEIVE at line 194 (paragraph RECEIVE-MENU-SCREEN) is never tested
  - fact: `app/cbl/COADM01C.cbl:194`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COBIL00C.cbl`**

- [ ] **WL-0062** `src/main/java/com/gitgalaxy/modernized/service/Cobil00cService.java:31` (`Cobil00cService`): the RESP of RECEIVE at line 308 (paragraph RECEIVE-BILLPAY-SCREEN) is never tested
  - fact: `app/cbl/COBIL00C.cbl:308`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COCRDLIC.cbl`**

- [ ] **WL-0063** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:27` (`CocrdlicService`): the RESP of SEND at line 939 (paragraph 1500-SEND-SCREEN) is never tested
  - fact: `app/cbl/COCRDLIC.cbl:939`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0064** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:28` (`CocrdlicService`): the RESP of RECEIVE at line 963 (paragraph 2100-RECEIVE-SCREEN) is never tested
  - fact: `app/cbl/COCRDLIC.cbl:963`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0065** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:29` (`CocrdlicService`): the RESP of STARTBR at line 1129 (paragraph 9000-READ-FORWARD) is never tested
  - fact: `app/cbl/COCRDLIC.cbl:1129`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0066** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:30` (`CocrdlicService`): the RESP of STARTBR at line 1273 (paragraph 9100-READ-BACKWARDS) is never tested
  - fact: `app/cbl/COCRDLIC.cbl:1273`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COCRDSLC.cbl`**

- [ ] **WL-0067** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:24` (`CocrdslcService`): the RESP of SEND at line 569 (paragraph 1400-SEND-SCREEN) is never tested
  - fact: `app/cbl/COCRDSLC.cbl:569`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0068** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:25` (`CocrdslcService`): the RESP of RECEIVE at line 597 (paragraph 2100-RECEIVE-MAP) is never tested
  - fact: `app/cbl/COCRDSLC.cbl:597`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0069** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:26` (`CocrdslcService`): the RESP of SEND at line 865 (paragraph ABEND-ROUTINE) is never tested
  - fact: `app/cbl/COCRDSLC.cbl:865`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COCRDUPC.cbl`**

- [ ] **WL-0070** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:25` (`CocrdupcService`): the RESP of RECEIVE at line 579 (paragraph 1100-RECEIVE-MAP) is never tested
  - fact: `app/cbl/COCRDUPC.cbl:579`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0071** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:26` (`CocrdupcService`): the RESP of SEND at line 1329 (paragraph 3400-SEND-SCREEN) is never tested
  - fact: `app/cbl/COCRDUPC.cbl:1329`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0072** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:27` (`CocrdupcService`): the RESP of SEND at line 1539 (paragraph ABEND-ROUTINE) is never tested
  - fact: `app/cbl/COCRDUPC.cbl:1539`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COMEN01C.cbl`**

- [ ] **WL-0073** `src/main/java/com/gitgalaxy/modernized/service/Comen01cService.java:24` (`Comen01cService`): the RESP of RECEIVE at line 227 (paragraph RECEIVE-MENU-SCREEN) is never tested
  - fact: `app/cbl/COMEN01C.cbl:227`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/CORPT00C.cbl`**

- [ ] **WL-0074** `src/main/java/com/gitgalaxy/modernized/service/Corpt00cService.java:17` (`Corpt00cService`): the RESP of RECEIVE at line 598 (paragraph RECEIVE-TRNRPT-SCREEN) is never tested
  - fact: `app/cbl/CORPT00C.cbl:598`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COSGN00C.cbl`**

- [ ] **WL-0075** `src/main/java/com/gitgalaxy/modernized/service/Cosgn00cService.java:21` (`Cosgn00cService`): the RESP of RECEIVE at line 110 (paragraph PROCESS-ENTER-KEY) is never tested
  - fact: `app/cbl/COSGN00C.cbl:110`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COTRN00C.cbl`**

- [ ] **WL-0076** `src/main/java/com/gitgalaxy/modernized/service/Cotrn00cService.java:25` (`Cotrn00cService`): the RESP of RECEIVE at line 556 (paragraph RECEIVE-TRNLST-SCREEN) is never tested
  - fact: `app/cbl/COTRN00C.cbl:556`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COTRN01C.cbl`**

- [ ] **WL-0077** `src/main/java/com/gitgalaxy/modernized/service/Cotrn01cService.java:23` (`Cotrn01cService`): the RESP of RECEIVE at line 232 (paragraph RECEIVE-TRNVIEW-SCREEN) is never tested
  - fact: `app/cbl/COTRN01C.cbl:232`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COTRN02C.cbl`**

- [ ] **WL-0078** `src/main/java/com/gitgalaxy/modernized/service/Cotrn02cService.java:27` (`Cotrn02cService`): the RESP of RECEIVE at line 541 (paragraph RECEIVE-TRNADD-SCREEN) is never tested
  - fact: `app/cbl/COTRN02C.cbl:541`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COUSR00C.cbl`**

- [ ] **WL-0079** `src/main/java/com/gitgalaxy/modernized/service/Cousr00cService.java:24` (`Cousr00cService`): the RESP of RECEIVE at line 551 (paragraph RECEIVE-USRLST-SCREEN) is never tested
  - fact: `app/cbl/COUSR00C.cbl:551`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COUSR01C.cbl`**

- [ ] **WL-0080** `src/main/java/com/gitgalaxy/modernized/service/Cousr01cService.java:21` (`Cousr01cService`): the RESP of RECEIVE at line 203 (paragraph RECEIVE-USRADD-SCREEN) is never tested
  - fact: `app/cbl/COUSR01C.cbl:203`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COUSR02C.cbl`**

- [ ] **WL-0081** `src/main/java/com/gitgalaxy/modernized/service/Cousr02cService.java:22` (`Cousr02cService`): the RESP of RECEIVE at line 285 (paragraph RECEIVE-USRUPD-SCREEN) is never tested
  - fact: `app/cbl/COUSR02C.cbl:285`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COUSR03C.cbl`**

- [ ] **WL-0082** `src/main/java/com/gitgalaxy/modernized/service/Cousr03cService.java:22` (`Cousr03cService`): the RESP of RECEIVE at line 232 (paragraph RECEIVE-USRDEL-SCREEN) is never tested
  - fact: `app/cbl/COUSR03C.cbl:232`, units of work and handlers (field-tested (6 public / 0 private estates))

<a id="db2-dialect"></a>
## DB2 SQL on another database (review)

_Resolution:_ Run each statement on the target database; DB2-only syntax (FETCH FIRST, WITH UR, special registers) needs its equivalent.

**`app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl`**

- [ ] **WL-0083** `src/main/java/com/gitgalaxy/modernized/repository/db2/AuthfrdsRepository.java` (`AuthfrdsRepository#insertL141Copaus2c`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl:141`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0084** `src/main/java/com/gitgalaxy/modernized/repository/db2/AuthfrdsRepository.java` (`AuthfrdsRepository#updateL222Copaus2c`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl:222`, DB2 table access (open (3 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COBTUPDT.cbl`**

- [ ] **WL-0085** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#deleteL201Cobtupdt`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COBTUPDT.cbl:201`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0086** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#insertL137Cobtupdt`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COBTUPDT.cbl:137`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0087** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#updateL171Cobtupdt`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COBTUPDT.cbl:171`, DB2 table access (open (3 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTLIC.cbl`**

- [ ] **WL-0088** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#cursorCTrTypeBackwardL354Cotrtlic`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:354`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0089** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#cursorCTrTypeForwardL338Cotrtlic`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:338`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0090** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#deleteL1900Cotrtlic`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:1900`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0091** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#selectL1803Cotrtlic`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:1803`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0092** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#updateL1846Cotrtlic`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:1846`, DB2 table access (open (3 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTUPC.cbl`**

- [ ] **WL-0093** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#deleteL1627Cotrtupc`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1627`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0094** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#insertL1597Cotrtupc`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1597`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0095** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#selectL1475Cotrtupc`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1475`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0096** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#updateL1544Cotrtupc`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1544`, DB2 table access (open (3 public / 0 private estates))

<a id="transaction-split"></a>
## Unit-of-work boundaries to split (port)

_Resolution:_ End the transaction at the SYNCPOINT the comment cites: a nested REQUIRES_NEW call, or two service methods.

**`app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl`**

- [ ] **WL-0097** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:77`: split the transaction here

**`app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl`**

- [ ] **WL-0098** `src/main/java/com/gitgalaxy/modernized/service/Copaus0cService.java:120`: split the transaction here

**`app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl`**

- [ ] **WL-0099** `src/main/java/com/gitgalaxy/modernized/service/Copaus1cService.java:78`: split the transaction here

**`app/app-transaction-type-db2/cbl/COTRTLIC.cbl`**

- [ ] **WL-0100** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:93`: split the transaction here
- [ ] **WL-0101** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:103`: split the transaction here
- [ ] **WL-0102** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:113`: split the transaction here

**`app/app-transaction-type-db2/cbl/COTRTUPC.cbl`**

- [ ] **WL-0103** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:69`: split the transaction here
- [ ] **WL-0104** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:79`: split the transaction here
- [ ] **WL-0105** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:89`: split the transaction here
- [ ] **WL-0106** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:99`: split the transaction here

**`app/app-vsam-mq/cbl/COACCT01.cbl`**

- [ ] **WL-0107** `src/main/java/com/gitgalaxy/modernized/service/Coacct01Service.java:52`: split the transaction here

**`app/app-vsam-mq/cbl/CODATE01.cbl`**

- [ ] **WL-0108** `src/main/java/com/gitgalaxy/modernized/service/Codate01Service.java:41`: split the transaction here

**`app/cbl/COACTUPC.cbl`**

- [ ] **WL-0109** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:109`: split the transaction here

**`app/cbl/COCRDUPC.cbl`**

- [ ] **WL-0110** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:85`: split the transaction here

<a id="interface-call"></a>
## Calls to other services (port)

_Resolution:_ Wire the called service (or a mock) in place of the placeholder.

**`app/cbl/CORPT00C.cbl`**

- [ ] **WL-0111** `src/main/java/com/gitgalaxy/modernized/service/Corpt00cService.java:92`: this program submits job TRNRPT00 through the internal reader, which runs PROC TRANREPT (app/proc/TRANREPT.prc): no generated job matches -- launch its steps

<a id="business-logic"></a>
## Business logic to port (port)

_Resolution:_ Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch.

**`app/app-authorization-ims-db2-mq/cbl/CBPAUP0C.cbl`**

- [ ] **WL-0112** `src/main/java/com/gitgalaxy/modernized/service/Cbpaup0cService.java:18`: Implement extracted business rules here
- [ ] **WL-0113** `src/main/java/com/gitgalaxy/modernized/service/Cbpaup0cService.java:24` (`Cbpaup0cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/app-authorization-ims-db2-mq/jcl/CBPAUP0J.jcl:24`, JCL job flow (open (5 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl`**

- [ ] **WL-0114** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:46`: Implement extracted business rules here
- [ ] **WL-0115** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:49`: implement from the program's business rules
- [ ] **WL-0116** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:96` (`Copaua0cService#handleMqMessage`): port the logic that handles the MQ request
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl:400`, MQ calls (open (1 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl`**

- [ ] **WL-0117** `src/main/java/com/gitgalaxy/modernized/service/Copaus0cService.java:47`: Implement extracted business rules here
- [ ] **WL-0118** `src/main/java/com/gitgalaxy/modernized/service/Copaus0cService.java:50`: implement from the program's business rules
- [ ] **WL-0119** `src/main/java/com/gitgalaxy/modernized/service/Copaus0cService.java:56`: implement from the program's business rules
- [ ] **WL-0120** `src/main/java/com/gitgalaxy/modernized/service/Copaus0cService.java:124` (`Copaus0cService#renderCopau0a`): port the logic that fills COPAU0AO before the SEND
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:695`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:703`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0121** `src/main/java/com/gitgalaxy/modernized/service/Copaus0cService.java:132` (`Copaus0cService#submitCopau0a`): port the logic that reads COPAU0AI after the RECEIVE
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:715`, BMS screen fields (open (3 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl`**

- [ ] **WL-0122** `src/main/java/com/gitgalaxy/modernized/service/Copaus1cService.java:34`: Implement extracted business rules here
- [ ] **WL-0123** `src/main/java/com/gitgalaxy/modernized/service/Copaus1cService.java:37`: implement from the program's business rules
- [ ] **WL-0124** `src/main/java/com/gitgalaxy/modernized/service/Copaus1cService.java:43`: implement from the program's business rules
- [ ] **WL-0125** `src/main/java/com/gitgalaxy/modernized/service/Copaus1cService.java:90` (`Copaus1cService#renderCopau1a`): port the logic that fills COPAU1AO before the SEND
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl:381`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl:389`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0126** `src/main/java/com/gitgalaxy/modernized/service/Copaus1cService.java:98` (`Copaus1cService#submitCopau1a`): port the logic that reads COPAU1AI after the RECEIVE
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl:400`, BMS screen fields (open (3 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl`**

- [ ] **WL-0127** `src/main/java/com/gitgalaxy/modernized/service/Copaus2cService.java:27`: Implement extracted business rules here
- [ ] **WL-0128** `src/main/java/com/gitgalaxy/modernized/service/Copaus2cService.java:30`: implement from the program's business rules
- [ ] **WL-0129** `src/main/java/com/gitgalaxy/modernized/service/Copaus2cService.java:36`: implement from the program's business rules

**`app/app-authorization-ims-db2-mq/cbl/DBUNLDGS.CBL`**

- [ ] **WL-0130** `src/main/java/com/gitgalaxy/modernized/service/DbunldgsService.java:18`: Implement extracted business rules here
- [ ] **WL-0131** `src/main/java/com/gitgalaxy/modernized/service/DbunldgsService.java:24` (`DbunldgsService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/app-authorization-ims-db2-mq/jcl/UNLDGSAM.JCL:26`, JCL job flow (open (5 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/PAUDBLOD.CBL`**

- [ ] **WL-0132** `src/main/java/com/gitgalaxy/modernized/service/PaudblodService.java:18`: Implement extracted business rules here
- [ ] **WL-0133** `src/main/java/com/gitgalaxy/modernized/service/PaudblodService.java:26` (`PaudblodService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/app-authorization-ims-db2-mq/jcl/LOADPADB.JCL:26`, JCL job flow (open (5 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/PAUDBUNL.CBL`**

- [ ] **WL-0134** `src/main/java/com/gitgalaxy/modernized/service/PaudbunlService.java:18`: Implement extracted business rules here
- [ ] **WL-0135** `src/main/java/com/gitgalaxy/modernized/service/PaudbunlService.java:26` (`PaudbunlService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/app-authorization-ims-db2-mq/jcl/UNLDPADB.JCL:38`, JCL job flow (open (5 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COBTUPDT.cbl`**

- [ ] **WL-0136** `src/main/java/com/gitgalaxy/modernized/service/CobtupdtService.java:21`: Implement extracted business rules here
- [ ] **WL-0137** `src/main/java/com/gitgalaxy/modernized/service/CobtupdtService.java:28` (`CobtupdtService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/app-transaction-type-db2/jcl/MNTTRDB2.jcl:21`, JCL job flow (open (5 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTLIC.cbl`**

- [ ] **WL-0138** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:35`: Implement extracted business rules here
- [ ] **WL-0139** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:38`: implement from the program's business rules
- [ ] **WL-0140** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:44`: implement from the program's business rules
- [ ] **WL-0141** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:117` (`CotrtlicService#renderCtrtlia`): port the logic that fills CTRTLIAO before the SEND
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:1588`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0142** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:125` (`CotrtlicService#submitCtrtlia`): port the logic that reads CTRTLIAI after the RECEIVE
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:931`, BMS screen fields (open (3 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTUPC.cbl`**

- [ ] **WL-0143** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:35`: Implement extracted business rules here
- [ ] **WL-0144** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:38`: implement from the program's business rules
- [ ] **WL-0145** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:44`: implement from the program's business rules
- [ ] **WL-0146** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:108`: port paragraph ABEND-ROUTINE's logic
- [ ] **WL-0147** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:117`: port paragraph None's logic
- [ ] **WL-0148** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:130` (`CotrtupcService#renderCtrtupa`): port the logic that fills CTRTUPAO before the SEND
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1433`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0149** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:138` (`CotrtupcService#submitCtrtupa`): port the logic that reads CTRTUPAI after the RECEIVE
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:642`, BMS screen fields (open (3 public / 0 private estates))

**`app/app-vsam-mq/cbl/COACCT01.cbl`**

- [ ] **WL-0150** `src/main/java/com/gitgalaxy/modernized/service/Coacct01Service.java:32`: Implement extracted business rules here
- [ ] **WL-0151** `src/main/java/com/gitgalaxy/modernized/service/Coacct01Service.java:35`: implement from the program's business rules
- [ ] **WL-0152** `src/main/java/com/gitgalaxy/modernized/service/Coacct01Service.java:70` (`Coacct01Service#handleMqMessage`): port the logic that handles the MQ request
  - fact: `app/app-vsam-mq/cbl/COACCT01.cbl:352`, MQ calls (open (1 public / 0 private estates))

**`app/app-vsam-mq/cbl/CODATE01.cbl`**

- [ ] **WL-0153** `src/main/java/com/gitgalaxy/modernized/service/Codate01Service.java:26`: Implement extracted business rules here
- [ ] **WL-0154** `src/main/java/com/gitgalaxy/modernized/service/Codate01Service.java:29`: implement from the program's business rules
- [ ] **WL-0155** `src/main/java/com/gitgalaxy/modernized/service/Codate01Service.java:59` (`Codate01Service#handleMqMessage`): port the logic that handles the MQ request
  - fact: `app/app-vsam-mq/cbl/CODATE01.cbl:301`, MQ calls (open (1 public / 0 private estates))

**`app/cbl/CBACT01C.cbl`**

- [ ] **WL-0156** `src/main/java/com/gitgalaxy/modernized/service/Cbact01cService.java:24`: Implement extracted business rules here
- [ ] **WL-0157** `src/main/java/com/gitgalaxy/modernized/service/Cbact01cService.java:40` (`Cbact01cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/READACCT.jcl:32`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBACT02C.cbl`**

- [ ] **WL-0158** `src/main/java/com/gitgalaxy/modernized/service/Cbact02cService.java:24`: Implement extracted business rules here
- [ ] **WL-0159** `src/main/java/com/gitgalaxy/modernized/service/Cbact02cService.java:37` (`Cbact02cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/READCARD.jcl:22`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBACT03C.cbl`**

- [ ] **WL-0160** `src/main/java/com/gitgalaxy/modernized/service/Cbact03cService.java:24`: Implement extracted business rules here
- [ ] **WL-0161** `src/main/java/com/gitgalaxy/modernized/service/Cbact03cService.java:37` (`Cbact03cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/READXREF.jcl:22`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBACT04C.cbl`**

- [ ] **WL-0162** `src/main/java/com/gitgalaxy/modernized/service/Cbact04cService.java:35`: Implement extracted business rules here
- [ ] **WL-0163** `src/main/java/com/gitgalaxy/modernized/service/Cbact04cService.java:72` (`Cbact04cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/INTCALC.jcl:22`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBCUS01C.cbl`**

- [ ] **WL-0164** `src/main/java/com/gitgalaxy/modernized/service/Cbcus01cService.java:24`: Implement extracted business rules here
- [ ] **WL-0165** `src/main/java/com/gitgalaxy/modernized/service/Cbcus01cService.java:37` (`Cbcus01cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/READCUST.jcl:21`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBEXPORT.cbl`**

- [ ] **WL-0166** `src/main/java/com/gitgalaxy/modernized/service/CbexportService.java:39`: Implement extracted business rules here
- [ ] **WL-0167** `src/main/java/com/gitgalaxy/modernized/service/CbexportService.java:82` (`CbexportService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/CBEXPORT.jcl:43`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBIMPORT.cbl`**

- [ ] **WL-0168** `src/main/java/com/gitgalaxy/modernized/service/CbimportService.java:24`: Implement extracted business rules here
- [ ] **WL-0169** `src/main/java/com/gitgalaxy/modernized/service/CbimportService.java:42` (`CbimportService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/CBIMPORT.jcl:22`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBSTM03A.CBL`**

- [ ] **WL-0170** `src/main/java/com/gitgalaxy/modernized/service/Cbstm03aService.java:22`: Implement extracted business rules here
- [ ] **WL-0171** `src/main/java/com/gitgalaxy/modernized/service/Cbstm03aService.java:36` (`Cbstm03aService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/CREASTMT.JCL:79`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBSTM03B.CBL`**

- [ ] **WL-0172** `src/main/java/com/gitgalaxy/modernized/service/Cbstm03bService.java:17`: Implement extracted business rules here
- [ ] **WL-0173** `src/main/java/com/gitgalaxy/modernized/service/Cbstm03bService.java:20`: implement from the program's business rules

**`app/cbl/CBTRN01C.cbl`**

- [ ] **WL-0174** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn01cService.java:16`: Implement extracted business rules here

**`app/cbl/CBTRN02C.cbl`**

- [ ] **WL-0175** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn02cService.java:34`: Implement extracted business rules here
- [ ] **WL-0176** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn02cService.java:77` (`Cbtrn02cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/POSTTRAN.jcl:23`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBTRN03C.cbl`**

- [ ] **WL-0177** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn03cService.java:31`: Implement extracted business rules here
- [ ] **WL-0178** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn03cService.java:59` (`Cbtrn03cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/TRANREPT.jcl:59`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/COACTUPC.cbl`**

- [ ] **WL-0179** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:52`: Implement extracted business rules here
- [ ] **WL-0180** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:55`: implement from the program's business rules
- [ ] **WL-0181** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:61`: implement from the program's business rules
- [ ] **WL-0182** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:126`: port paragraph ABEND-ROUTINE's logic
- [ ] **WL-0183** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:135`: port paragraph None's logic
- [ ] **WL-0184** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:148` (`CoactupcService#renderCactupa`): port the logic that fills CACTUPAO before the SEND
  - fact: `app/cbl/COACTUPC.cbl:3594`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0185** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:156` (`CoactupcService#submitCactupa`): port the logic that reads CACTUPAI after the RECEIVE
  - fact: `app/cbl/COACTUPC.cbl:1040`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COACTVWC.cbl`**

- [ ] **WL-0186** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:48`: Implement extracted business rules here
- [ ] **WL-0187** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:51`: implement from the program's business rules
- [ ] **WL-0188** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:57`: implement from the program's business rules
- [ ] **WL-0189** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:96`: port paragraph ABEND-ROUTINE's logic
- [ ] **WL-0190** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:105`: port paragraph None's logic
- [ ] **WL-0191** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:118` (`CoactvwcService#renderCactvwa`): port the logic that fills CACTVWAO before the SEND
  - fact: `app/cbl/COACTVWC.cbl:583`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0192** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:126` (`CoactvwcService#submitCactvwa`): port the logic that reads CACTVWAI after the RECEIVE
  - fact: `app/cbl/COACTVWC.cbl:611`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COADM01C.cbl`**

- [ ] **WL-0193** `src/main/java/com/gitgalaxy/modernized/service/Coadm01cService.java:39`: Implement extracted business rules here
- [ ] **WL-0194** `src/main/java/com/gitgalaxy/modernized/service/Coadm01cService.java:42`: implement from the program's business rules
- [ ] **WL-0195** `src/main/java/com/gitgalaxy/modernized/service/Coadm01cService.java:48`: implement from the program's business rules
- [ ] **WL-0196** `src/main/java/com/gitgalaxy/modernized/service/Coadm01cService.java:93`: port paragraph PGMIDERR-ERR-PARA's logic
- [ ] **WL-0197** `src/main/java/com/gitgalaxy/modernized/service/Coadm01cService.java:97` (`Coadm01cService#renderCoadm1a`): port the logic that fills COADM1AO before the SEND
  - fact: `app/cbl/COADM01C.cbl:182`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0198** `src/main/java/com/gitgalaxy/modernized/service/Coadm01cService.java:105` (`Coadm01cService#submitCoadm1a`): port the logic that reads COADM1AI after the RECEIVE
  - fact: `app/cbl/COADM01C.cbl:194`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COBIL00C.cbl`**

- [ ] **WL-0199** `src/main/java/com/gitgalaxy/modernized/service/Cobil00cService.java:49`: Implement extracted business rules here
- [ ] **WL-0200** `src/main/java/com/gitgalaxy/modernized/service/Cobil00cService.java:52`: implement from the program's business rules
- [ ] **WL-0201** `src/main/java/com/gitgalaxy/modernized/service/Cobil00cService.java:58`: implement from the program's business rules
- [ ] **WL-0202** `src/main/java/com/gitgalaxy/modernized/service/Cobil00cService.java:107` (`Cobil00cService#renderCobil0a`): port the logic that fills COBIL0AO before the SEND
  - fact: `app/cbl/COBIL00C.cbl:295`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0203** `src/main/java/com/gitgalaxy/modernized/service/Cobil00cService.java:115` (`Cobil00cService#submitCobil0a`): port the logic that reads COBIL0AI after the RECEIVE
  - fact: `app/cbl/COBIL00C.cbl:308`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COBSWAIT.cbl`**

- [ ] **WL-0204** `src/main/java/com/gitgalaxy/modernized/service/CobswaitService.java:18`: Implement extracted business rules here
- [ ] **WL-0205** `src/main/java/com/gitgalaxy/modernized/service/CobswaitService.java:24` (`CobswaitService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/WAITSTEP.jcl:22`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/COCRDLIC.cbl`**

- [ ] **WL-0206** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:47`: Implement extracted business rules here
- [ ] **WL-0207** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:50`: implement from the program's business rules
- [ ] **WL-0208** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:56`: implement from the program's business rules
- [ ] **WL-0209** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:113` (`CocrdlicService#renderCcrdlia`): port the logic that fills CCRDLIAO before the SEND
  - fact: `app/cbl/COCRDLIC.cbl:939`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0210** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:121` (`CocrdlicService#submitCcrdlia`): port the logic that reads CCRDLIAI after the RECEIVE
  - fact: `app/cbl/COCRDLIC.cbl:963`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COCRDSLC.cbl`**

- [ ] **WL-0211** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:41`: Implement extracted business rules here
- [ ] **WL-0212** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:44`: implement from the program's business rules
- [ ] **WL-0213** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:50`: implement from the program's business rules
- [ ] **WL-0214** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:84`: port paragraph ABEND-ROUTINE's logic
- [ ] **WL-0215** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:93`: port paragraph None's logic
- [ ] **WL-0216** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:106` (`CocrdslcService#renderCcrdsla`): port the logic that fills CCRDSLAO before the SEND
  - fact: `app/cbl/COCRDSLC.cbl:569`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0217** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:114` (`CocrdslcService#submitCcrdsla`): port the logic that reads CCRDSLAI after the RECEIVE
  - fact: `app/cbl/COCRDSLC.cbl:597`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COCRDUPC.cbl`**

- [ ] **WL-0218** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:42`: Implement extracted business rules here
- [ ] **WL-0219** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:45`: implement from the program's business rules
- [ ] **WL-0220** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:51`: implement from the program's business rules
- [ ] **WL-0221** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:94`: port paragraph ABEND-ROUTINE's logic
- [ ] **WL-0222** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:103`: port paragraph None's logic
- [ ] **WL-0223** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:116` (`CocrdupcService#renderCcrdupa`): port the logic that fills CCRDUPAO before the SEND
  - fact: `app/cbl/COCRDUPC.cbl:1329`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0224** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:124` (`CocrdupcService#submitCcrdupa`): port the logic that reads CCRDUPAI after the RECEIVE
  - fact: `app/cbl/COCRDUPC.cbl:579`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COMEN01C.cbl`**

- [ ] **WL-0225** `src/main/java/com/gitgalaxy/modernized/service/Comen01cService.java:49`: Implement extracted business rules here
- [ ] **WL-0226** `src/main/java/com/gitgalaxy/modernized/service/Comen01cService.java:52`: implement from the program's business rules
- [ ] **WL-0227** `src/main/java/com/gitgalaxy/modernized/service/Comen01cService.java:58`: implement from the program's business rules
- [ ] **WL-0228** `src/main/java/com/gitgalaxy/modernized/service/Comen01cService.java:139` (`Comen01cService#renderComen1a`): port the logic that fills COMEN1AO before the SEND
  - fact: `app/cbl/COMEN01C.cbl:215`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0229** `src/main/java/com/gitgalaxy/modernized/service/Comen01cService.java:147` (`Comen01cService#submitComen1a`): port the logic that reads COMEN1AI after the RECEIVE
  - fact: `app/cbl/COMEN01C.cbl:227`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/CORPT00C.cbl`**

- [ ] **WL-0230** `src/main/java/com/gitgalaxy/modernized/service/Corpt00cService.java:34`: Implement extracted business rules here
- [ ] **WL-0231** `src/main/java/com/gitgalaxy/modernized/service/Corpt00cService.java:37`: implement from the program's business rules
- [ ] **WL-0232** `src/main/java/com/gitgalaxy/modernized/service/Corpt00cService.java:43`: implement from the program's business rules
- [ ] **WL-0233** `src/main/java/com/gitgalaxy/modernized/service/Corpt00cService.java:70` (`Corpt00cService#renderCorpt0a`): port the logic that fills CORPT0AO before the SEND
  - fact: `app/cbl/CORPT00C.cbl:563`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `app/cbl/CORPT00C.cbl:571`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0234** `src/main/java/com/gitgalaxy/modernized/service/Corpt00cService.java:78` (`Corpt00cService#submitCorpt0a`): port the logic that reads CORPT0AI after the RECEIVE
  - fact: `app/cbl/CORPT00C.cbl:598`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COSGN00C.cbl`**

- [ ] **WL-0235** `src/main/java/com/gitgalaxy/modernized/service/Cosgn00cService.java:37`: Implement extracted business rules here
- [ ] **WL-0236** `src/main/java/com/gitgalaxy/modernized/service/Cosgn00cService.java:40`: implement from the program's business rules
- [ ] **WL-0237** `src/main/java/com/gitgalaxy/modernized/service/Cosgn00cService.java:45`: implement from the program's business rules
- [ ] **WL-0238** `src/main/java/com/gitgalaxy/modernized/service/Cosgn00cService.java:68` (`Cosgn00cService#renderCosgn0a`): port the logic that fills COSGN0AO before the SEND
  - fact: `app/cbl/COSGN00C.cbl:151`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0239** `src/main/java/com/gitgalaxy/modernized/service/Cosgn00cService.java:76` (`Cosgn00cService#submitCosgn0a`): port the logic that reads COSGN0AI (the default) after the RECEIVE
  - fact: `app/cbl/COSGN00C.cbl:110`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COTRN00C.cbl`**

- [ ] **WL-0240** `src/main/java/com/gitgalaxy/modernized/service/Cotrn00cService.java:42`: Implement extracted business rules here
- [ ] **WL-0241** `src/main/java/com/gitgalaxy/modernized/service/Cotrn00cService.java:45`: implement from the program's business rules
- [ ] **WL-0242** `src/main/java/com/gitgalaxy/modernized/service/Cotrn00cService.java:51`: implement from the program's business rules
- [ ] **WL-0243** `src/main/java/com/gitgalaxy/modernized/service/Cotrn00cService.java:99` (`Cotrn00cService#renderCotrn0a`): port the logic that fills COTRN0AO before the SEND
  - fact: `app/cbl/COTRN00C.cbl:534`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `app/cbl/COTRN00C.cbl:542`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0244** `src/main/java/com/gitgalaxy/modernized/service/Cotrn00cService.java:107` (`Cotrn00cService#submitCotrn0a`): port the logic that reads COTRN0AI after the RECEIVE
  - fact: `app/cbl/COTRN00C.cbl:556`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COTRN01C.cbl`**

- [ ] **WL-0245** `src/main/java/com/gitgalaxy/modernized/service/Cotrn01cService.java:40`: Implement extracted business rules here
- [ ] **WL-0246** `src/main/java/com/gitgalaxy/modernized/service/Cotrn01cService.java:43`: implement from the program's business rules
- [ ] **WL-0247** `src/main/java/com/gitgalaxy/modernized/service/Cotrn01cService.java:49`: implement from the program's business rules
- [ ] **WL-0248** `src/main/java/com/gitgalaxy/modernized/service/Cotrn01cService.java:78` (`Cotrn01cService#renderCotrn1a`): port the logic that fills COTRN1AO before the SEND
  - fact: `app/cbl/COTRN01C.cbl:219`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0249** `src/main/java/com/gitgalaxy/modernized/service/Cotrn01cService.java:86` (`Cotrn01cService#submitCotrn1a`): port the logic that reads COTRN1AI after the RECEIVE
  - fact: `app/cbl/COTRN01C.cbl:232`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COTRN02C.cbl`**

- [ ] **WL-0250** `src/main/java/com/gitgalaxy/modernized/service/Cotrn02cService.java:45`: Implement extracted business rules here
- [ ] **WL-0251** `src/main/java/com/gitgalaxy/modernized/service/Cotrn02cService.java:48`: implement from the program's business rules
- [ ] **WL-0252** `src/main/java/com/gitgalaxy/modernized/service/Cotrn02cService.java:54`: implement from the program's business rules
- [ ] **WL-0253** `src/main/java/com/gitgalaxy/modernized/service/Cotrn02cService.java:105` (`Cotrn02cService#renderCotrn2a`): port the logic that fills COTRN2AO before the SEND
  - fact: `app/cbl/COTRN02C.cbl:522`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0254** `src/main/java/com/gitgalaxy/modernized/service/Cotrn02cService.java:113` (`Cotrn02cService#submitCotrn2a`): port the logic that reads COTRN2AI after the RECEIVE
  - fact: `app/cbl/COTRN02C.cbl:541`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COUSR00C.cbl`**

- [ ] **WL-0255** `src/main/java/com/gitgalaxy/modernized/service/Cousr00cService.java:42`: Implement extracted business rules here
- [ ] **WL-0256** `src/main/java/com/gitgalaxy/modernized/service/Cousr00cService.java:45`: implement from the program's business rules
- [ ] **WL-0257** `src/main/java/com/gitgalaxy/modernized/service/Cousr00cService.java:51`: implement from the program's business rules
- [ ] **WL-0258** `src/main/java/com/gitgalaxy/modernized/service/Cousr00cService.java:121` (`Cousr00cService#renderCousr0a`): port the logic that fills COUSR0AO before the SEND
  - fact: `app/cbl/COUSR00C.cbl:529`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `app/cbl/COUSR00C.cbl:537`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0259** `src/main/java/com/gitgalaxy/modernized/service/Cousr00cService.java:129` (`Cousr00cService#submitCousr0a`): port the logic that reads COUSR0AI after the RECEIVE
  - fact: `app/cbl/COUSR00C.cbl:551`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COUSR01C.cbl`**

- [ ] **WL-0260** `src/main/java/com/gitgalaxy/modernized/service/Cousr01cService.java:37`: Implement extracted business rules here
- [ ] **WL-0261** `src/main/java/com/gitgalaxy/modernized/service/Cousr01cService.java:40`: implement from the program's business rules
- [ ] **WL-0262** `src/main/java/com/gitgalaxy/modernized/service/Cousr01cService.java:46`: implement from the program's business rules
- [ ] **WL-0263** `src/main/java/com/gitgalaxy/modernized/service/Cousr01cService.java:72` (`Cousr01cService#renderCousr1a`): port the logic that fills COUSR1AO before the SEND
  - fact: `app/cbl/COUSR01C.cbl:190`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0264** `src/main/java/com/gitgalaxy/modernized/service/Cousr01cService.java:80` (`Cousr01cService#submitCousr1a`): port the logic that reads COUSR1AI after the RECEIVE
  - fact: `app/cbl/COUSR01C.cbl:203`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COUSR02C.cbl`**

- [ ] **WL-0265** `src/main/java/com/gitgalaxy/modernized/service/Cousr02cService.java:38`: Implement extracted business rules here
- [ ] **WL-0266** `src/main/java/com/gitgalaxy/modernized/service/Cousr02cService.java:41`: implement from the program's business rules
- [ ] **WL-0267** `src/main/java/com/gitgalaxy/modernized/service/Cousr02cService.java:47`: implement from the program's business rules
- [ ] **WL-0268** `src/main/java/com/gitgalaxy/modernized/service/Cousr02cService.java:78` (`Cousr02cService#renderCousr2a`): port the logic that fills COUSR2AO before the SEND
  - fact: `app/cbl/COUSR02C.cbl:272`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0269** `src/main/java/com/gitgalaxy/modernized/service/Cousr02cService.java:86` (`Cousr02cService#submitCousr2a`): port the logic that reads COUSR2AI after the RECEIVE
  - fact: `app/cbl/COUSR02C.cbl:285`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/COUSR03C.cbl`**

- [ ] **WL-0270** `src/main/java/com/gitgalaxy/modernized/service/Cousr03cService.java:38`: Implement extracted business rules here
- [ ] **WL-0271** `src/main/java/com/gitgalaxy/modernized/service/Cousr03cService.java:41`: implement from the program's business rules
- [ ] **WL-0272** `src/main/java/com/gitgalaxy/modernized/service/Cousr03cService.java:47`: implement from the program's business rules
- [ ] **WL-0273** `src/main/java/com/gitgalaxy/modernized/service/Cousr03cService.java:78` (`Cousr03cService#renderCousr3a`): port the logic that fills COUSR3AO before the SEND
  - fact: `app/cbl/COUSR03C.cbl:219`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0274** `src/main/java/com/gitgalaxy/modernized/service/Cousr03cService.java:86` (`Cousr03cService#submitCousr3a`): port the logic that reads COUSR3AI after the RECEIVE
  - fact: `app/cbl/COUSR03C.cbl:232`, BMS screen fields (open (3 public / 0 private estates))

**`app/cbl/CSUTLDTC.cbl`**

- [ ] **WL-0275** `src/main/java/com/gitgalaxy/modernized/service/CsutldtcService.java:16`: Implement extracted business rules here
- [ ] **WL-0276** `src/main/java/com/gitgalaxy/modernized/service/CsutldtcService.java:19`: implement from the program's business rules

<a id="configuration"></a>
## Target configuration (review)

_Resolution:_ Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file.

**`(project configuration)`**

- [ ] **WL-0277** `src/main/resources/application.yml:9`: Update these credentials for your target environment
