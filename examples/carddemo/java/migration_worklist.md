# Migration worklist

Every TODO the generators left in this project: where a fact was missing or two facts disagreed, the Java says so instead of guessing. Each item names the fact it rests on (from `traceability.json`) and a suggested resolution.

**198 items** across 50 program sources (COBOL, PL/I).

| nature | items | what it takes |
|---|---:|---|
| conflict | 35 | two facts disagree: a person decides which one the Java follows |
| fact-gap | 7 | a fact is missing: supply it and re-run |
| review | 56 | the Java runs as generated: check it on the target |
| port | 100 | business logic to write |

## By category

| category | nature | items | suggested resolution |
|---|---|---:|---|
| [COMMAREA layout mismatches](#commarea-mismatch) | conflict | 21 | For each caller, confirm which layout the callee reads (the COBOL MOVEs into DFHCOMMAREA say); map that caller's record onto the DTO, or give the callee one DTO per entry. |
| [Programs reading another record layout](#record-variant) | conflict | 14 | Map the program's record onto the entity's fields (or split the entity); the two layouts' sizes are in the TODO. |
| [Unresolved layouts](#missing-layout) | fact-gap | 2 | Add the missing copybook / %INCLUDE member or record to the repository and re-run; the DTO then gets its real fields. |
| [Keys that are not one field](#vsam-key) | fact-gap | 5 | Name the key: split the record so the key is one field, or keep the String vsamKey in step with the record; for a browse, add a range query over the key. |
| [Utility job steps to port](#batch-utility) | port | 7 | Replace the utility with its Spring Batch equivalent (SORT -> a sorting step, IDCAMS REPRO -> a copy, a TSO / IMS runner -> the program's runBatch), reading its control statements in SYSIN. |
| [CICS responses the COBOL never tests](#unchecked-resp) | review | 40 | Decide what a failed call does: the COBOL ignores it, so the Java throws; catch it where the old behaviour (carry on) is really wanted. |
| [DB2 SQL on another database](#db2-dialect) | review | 15 | Run each statement on the target database; DB2-only syntax (FETCH FIRST, WITH UR, special registers) needs its equivalent. |
| [Unit-of-work boundaries to split](#transaction-split) | port | 14 | End the transaction at the SYNCPOINT the comment cites: a nested REQUIRES_NEW call, or two service methods. |
| [Calls to other services](#interface-call) | port | 1 | Wire the called service (or a mock) in place of the placeholder. |
| [Business logic to port](#business-logic) | port | 78 | Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch. |
| [Target configuration](#configuration) | review | 1 | Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file. |

## By program source

Listed in port order: the programs the most other code depends on first ([ai_agent_jobs/port_order.md](ai_agent_jobs/port_order.md)).

| source | conflict | fact-gap | review | port | total |
|---|---:|---:|---:|---:|---:|
| 1. `app/cbl/CSUTLDTC.cbl` |  |  |  | 1 | 1 |
| 2. `app/cbl/COMEN01C.cbl` | 1 |  | 1 | 2 | 4 |
| 3. `app/cbl/CBTRN03C.cbl` | 1 |  |  | 1 | 2 |
| 4. `app/app-transaction-type-db2/cbl/COTRTUPC.cbl` | 2 |  | 7 | 7 | 16 |
| 5. `app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl` |  |  | 4 | 2 | 6 |
| 6. `app/cbl/COADM01C.cbl` | 1 |  | 1 | 3 | 5 |
| 7. `app/cbl/CBACT01C.cbl` | 1 |  |  | 1 | 2 |
| 8. `app/cbl/CBACT02C.cbl` | 1 |  |  | 1 | 2 |
| 9. `app/cbl/CBACT03C.cbl` | 1 |  |  | 1 | 2 |
| 10. `app/cbl/CBACT04C.cbl` | 2 | 1 |  | 1 | 4 |
| 11. `app/cbl/CBCUS01C.cbl` | 1 |  |  | 1 | 2 |
| 12. `app/cbl/CBEXPORT.cbl` | 1 |  |  | 1 | 2 |
| 13. `app/cbl/CBIMPORT.cbl` |  | 1 |  | 1 | 2 |
| 14. `app/app-authorization-ims-db2-mq/cbl/CBPAUP0C.cbl` |  |  |  | 1 | 1 |
| 15. `app/cbl/CBSTM03A.CBL` |  |  |  | 1 | 1 |
| 16. `app/cbl/CBTRN02C.cbl` | 3 |  |  | 1 | 4 |
| 17. `app/cbl/COBSWAIT.cbl` |  |  |  | 1 | 1 |
| 18. `app/app-transaction-type-db2/cbl/COBTUPDT.cbl` |  |  | 3 | 1 | 4 |
| 19. `app/app-authorization-ims-db2-mq/cbl/DBUNLDGS.CBL` |  |  |  | 1 | 1 |
| 20. `app/app-authorization-ims-db2-mq/cbl/PAUDBLOD.CBL` |  |  |  | 1 | 1 |
| 21. `app/app-authorization-ims-db2-mq/cbl/PAUDBUNL.CBL` |  |  |  | 1 | 1 |
| 22. `app/app-vsam-mq/cbl/COACCT01.cbl` |  | 1 |  | 4 | 5 |
| 23. `app/app-vsam-mq/cbl/CODATE01.cbl` |  | 1 |  | 4 | 5 |
| 24. `app/app-transaction-type-db2/cbl/COTRTLIC.cbl` | 1 |  | 7 | 5 | 13 |
| 25. `app/cbl/CBSTM03B.CBL` | 3 | 1 |  | 1 | 5 |
| 26. `app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl` |  |  | 3 | 4 | 7 |
| 27. `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl` | 1 |  | 1 | 3 | 5 |
| 28. `app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl` | 1 |  | 1 | 3 | 5 |
| 29. `app/cbl/COACTUPC.cbl` | 1 |  | 3 | 4 | 8 |
| 30. `app/cbl/COACTVWC.cbl` | 1 |  | 3 | 3 | 7 |
| 31. `app/cbl/COBIL00C.cbl` | 1 |  | 1 | 2 | 4 |
| 32. `app/cbl/COCRDLIC.cbl` | 1 |  | 4 | 2 | 7 |
| 33. `app/cbl/COCRDSLC.cbl` | 1 |  | 3 | 3 | 7 |
| 34. `app/cbl/COCRDUPC.cbl` | 1 |  | 3 | 4 | 8 |
| 35. `app/cbl/CORPT00C.cbl` | 1 |  | 1 | 3 | 5 |
| 36. `app/cbl/COSGN00C.cbl` |  |  | 1 | 2 | 3 |
| 37. `app/cbl/COTRN00C.cbl` | 1 |  | 1 | 2 | 4 |
| 38. `app/cbl/COTRN01C.cbl` | 1 |  | 1 | 2 | 4 |
| 39. `app/cbl/COTRN02C.cbl` | 1 |  | 1 | 2 | 4 |
| 40. `app/cbl/COUSR00C.cbl` | 1 |  | 1 | 2 | 4 |
| 41. `app/cbl/COUSR01C.cbl` | 1 |  | 1 | 2 | 4 |
| 42. `app/cbl/COUSR02C.cbl` | 1 |  | 1 | 2 | 4 |
| 43. `app/cbl/COUSR03C.cbl` | 1 |  | 1 | 2 | 4 |
| 44. `app/cbl/CBTRN01C.cbl` |  |  |  | 1 | 1 |
| `app/jcl/CBEXPORT.jcl` |  | 2 |  | 1 | 3 |
| `app/jcl/CREASTMT.JCL` |  |  |  | 2 | 2 |
| `app/jcl/TRANREPT.jcl` |  |  |  | 2 | 2 |
| `(project configuration)` |  |  | 1 |  | 1 |
| `app/app-authorization-ims-db2-mq/jcl/UNLDGSAM.JCL` |  |  |  | 1 | 1 |
| `app/app-authorization-ims-db2-mq/jcl/UNLDPADB.JCL` |  |  |  | 1 | 1 |
| `app/app-transaction-type-db2/cpy/CSDB2RPY.cpy` |  |  | 1 |  | 1 |

<a id="commarea-mismatch"></a>
## COMMAREA layout mismatches (conflict)

_Resolution:_ For each caller, confirm which layout the callee reads (the COBOL MOVEs into DFHCOMMAREA say); map that caller's record onto the DTO, or give the callee one DTO per entry.

**`app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUS0C_port_ticket.md`](ai_agent_jobs/COPAUS0C_port_ticket.md)

- [ ] **WL-0001** `src/main/java/com/gitgalaxy/modernized/controller/Copaus0cController.java:20` (`Copaus0cController#link`, `Copaus0cController#transactionCPVS`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 380 bytes) at app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:254
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:322`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:674`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl:367`, CICS resources (open (5 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUS1C_port_ticket.md`](ai_agent_jobs/COPAUS1C_port_ticket.md)

- [ ] **WL-0002** `src/main/java/com/gitgalaxy/modernized/controller/Copaus1cController.java:20` (`Copaus1cController#link`, `Copaus1cController#transactionCPVD`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 480 bytes) at app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl:202
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:322`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:674`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-authorization-ims-db2-mq/csd/CRDDEMO2.csd:39`, entry transactions (open (4 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTLIC.cbl`** -- porting ticket [`ai_agent_jobs/COTRTLIC_port_ticket.md`](ai_agent_jobs/COTRTLIC_port_ticket.md)

- [ ] **WL-0003** `src/main/java/com/gitgalaxy/modernized/controller/CotrtlicController.java:20` (`CotrtlicController#link`, `CotrtlicController#transactionCTLI`): callers also pass WS-COMMAREA (app/app-transaction-type-db2/cbl/COTRTLIC.cbl, 2000 bytes) at app/app-transaction-type-db2/cbl/COTRTLIC.cbl:910
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-transaction-type-db2/csd/CRDDEMOD.csd:25`, entry transactions (open (4 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTUPC.cbl`** -- porting ticket [`ai_agent_jobs/COTRTUPC_port_ticket.md`](ai_agent_jobs/COTRTUPC_port_ticket.md)

- [ ] **WL-0004** `src/main/java/com/gitgalaxy/modernized/controller/CotrtupcController.java:20` (`CotrtupcController#link`, `CotrtupcController#transactionCTTU`): callers also pass WS-COMMAREA (app/app-transaction-type-db2/cbl/COTRTUPC.cbl, 2000 bytes) at app/app-transaction-type-db2/cbl/COTRTUPC.cbl:567
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:620`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:648`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0005** `src/main/java/com/gitgalaxy/modernized/controller/CotrtupcController.java:21` (`CotrtupcController#link`, `CotrtupcController#transactionCTTU`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/app-transaction-type-db2/cbl/COTRTLIC.cbl:648
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:620`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:648`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COACTUPC.cbl`** -- porting ticket [`ai_agent_jobs/COACTUPC_port_ticket.md`](ai_agent_jobs/COACTUPC_port_ticket.md)

- [ ] **WL-0006** `src/main/java/com/gitgalaxy/modernized/controller/CoactupcController.java:20` (`CoactupcController#link`, `CoactupcController#transactionCAUP`): callers also pass WS-COMMAREA (app/cbl/COACTUPC.cbl, 2000 bytes) at app/cbl/COACTUPC.cbl:1015
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:306`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COACTVWC.cbl`** -- porting ticket [`ai_agent_jobs/COACTVWC_port_ticket.md`](ai_agent_jobs/COACTVWC_port_ticket.md)

- [ ] **WL-0007** `src/main/java/com/gitgalaxy/modernized/controller/CoactvwcController.java:20` (`CoactvwcController#link`, `CoactvwcController#transactionCAVW`): callers also pass WS-COMMAREA (app/cbl/COACTVWC.cbl, 2000 bytes) at app/cbl/COACTVWC.cbl:402
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:317`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COADM01C.cbl`** -- porting ticket [`ai_agent_jobs/COADM01C_port_ticket.md`](ai_agent_jobs/COADM01C_port_ticket.md)

- [ ] **WL-0008** `src/main/java/com/gitgalaxy/modernized/controller/Coadm01cController.java:20` (`Coadm01cController#link`, `Coadm01cController#transactionCA00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COADM01C.cbl:111, app/cbl/COADM01C.cbl:280, app/cbl/COSGN00C.cbl:231
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:620`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:457`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COSGN00C.cbl:231`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COBIL00C.cbl`** -- porting ticket [`ai_agent_jobs/COBIL00C_port_ticket.md`](ai_agent_jobs/COBIL00C_port_ticket.md)

- [ ] **WL-0009** `src/main/java/com/gitgalaxy/modernized/controller/Cobil00cController.java:20` (`Cobil00cController#link`, `Cobil00cController#transactionCB00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 218 bytes) at app/cbl/COBIL00C.cbl:146
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:337`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COCRDLIC.cbl`** -- porting ticket [`ai_agent_jobs/COCRDLIC_port_ticket.md`](ai_agent_jobs/COCRDLIC_port_ticket.md)

- [ ] **WL-0010** `src/main/java/com/gitgalaxy/modernized/controller/CocrdlicController.java:20` (`CocrdlicController#link`, `CocrdlicController#transactionCCLI`): callers also pass WS-COMMAREA (app/cbl/COCRDLIC.cbl, 2000 bytes) at app/cbl/COCRDLIC.cbl:615
  - fact: `app/cbl/COCRDLIC.cbl:538`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COCRDLIC.cbl:566`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COCRDSLC.cbl`** -- porting ticket [`ai_agent_jobs/COCRDSLC_port_ticket.md`](ai_agent_jobs/COCRDSLC_port_ticket.md)

- [ ] **WL-0011** `src/main/java/com/gitgalaxy/modernized/controller/CocrdslcController.java:20` (`CocrdslcController#link`, `CocrdslcController#transactionCCDL`): callers also pass WS-COMMAREA (app/cbl/COCRDSLC.cbl, 2000 bytes) at app/cbl/COCRDSLC.cbl:402
  - fact: `app/cbl/COCRDLIC.cbl:538`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COCRDLIC.cbl:566`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COCRDUPC.cbl`** -- porting ticket [`ai_agent_jobs/COCRDUPC_port_ticket.md`](ai_agent_jobs/COCRDUPC_port_ticket.md)

- [ ] **WL-0012** `src/main/java/com/gitgalaxy/modernized/controller/CocrdupcController.java:20` (`CocrdupcController#link`, `CocrdupcController#transactionCCUP`): callers also pass WS-COMMAREA (app/cbl/COCRDUPC.cbl, 2000 bytes) at app/cbl/COCRDUPC.cbl:554
  - fact: `app/cbl/COCRDLIC.cbl:538`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COCRDLIC.cbl:566`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COMEN01C.cbl`** -- porting ticket [`ai_agent_jobs/COMEN01C_port_ticket.md`](ai_agent_jobs/COMEN01C_port_ticket.md)

- [ ] **WL-0013** `src/main/java/com/gitgalaxy/modernized/controller/Comen01cController.java:20` (`Comen01cController#link`, `Comen01cController#transactionCM00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COCRDLIC.cbl:402, app/cbl/COMEN01C.cbl:107, app/cbl/COSGN00C.cbl:236
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:322`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:674`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COACTUPC.cbl:956`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/CORPT00C.cbl`** -- porting ticket [`ai_agent_jobs/CORPT00C_port_ticket.md`](ai_agent_jobs/CORPT00C_port_ticket.md)

- [ ] **WL-0014** `src/main/java/com/gitgalaxy/modernized/controller/Corpt00cController.java:20` (`Corpt00cController#link`, `Corpt00cController#transactionCR00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/CORPT00C.cbl:199, app/cbl/CORPT00C.cbl:587
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:409`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COTRN00C.cbl`** -- porting ticket [`ai_agent_jobs/COTRN00C_port_ticket.md`](ai_agent_jobs/COTRN00C_port_ticket.md)

- [ ] **WL-0015** `src/main/java/com/gitgalaxy/modernized/controller/Cotrn00cController.java:20` (`Cotrn00cController#link`, `Cotrn00cController#transactionCT00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 218 bytes) at app/cbl/COTRN00C.cbl:138
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COTRN01C.cbl:205`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COTRN01C.cbl`** -- porting ticket [`ai_agent_jobs/COTRN01C_port_ticket.md`](ai_agent_jobs/COTRN01C_port_ticket.md)

- [ ] **WL-0016** `src/main/java/com/gitgalaxy/modernized/controller/Cotrn01cController.java:20` (`Cotrn01cController#link`, `Cotrn01cController#transactionCT01`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 218 bytes) at app/cbl/COTRN01C.cbl:136
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COTRN00C.cbl:192`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COTRN02C.cbl`** -- porting ticket [`ai_agent_jobs/COTRN02C_port_ticket.md`](ai_agent_jobs/COTRN02C_port_ticket.md)

- [ ] **WL-0017** `src/main/java/com/gitgalaxy/modernized/controller/Cotrn02cController.java:20` (`Cotrn02cController#link`, `Cotrn02cController#transactionCT02`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 218 bytes) at app/cbl/COTRN02C.cbl:156, app/cbl/COTRN02C.cbl:530
  - fact: `app/cbl/COMEN01C.cbl:156`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COMEN01C.cbl:184`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:439`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COUSR00C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR00C_port_ticket.md`](ai_agent_jobs/COUSR00C_port_ticket.md)

- [ ] **WL-0018** `src/main/java/com/gitgalaxy/modernized/controller/Cousr00cController.java:20` (`Cousr00cController#link`, `Cousr00cController#transactionCU00`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 194 bytes) at app/cbl/COUSR00C.cbl:141
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:449`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COUSR01C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR01C_port_ticket.md`](ai_agent_jobs/COUSR01C_port_ticket.md)

- [ ] **WL-0019** `src/main/java/com/gitgalaxy/modernized/controller/Cousr01cController.java:20` (`Cousr01cController#link`, `Cousr01cController#transactionCU01`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COUSR01C.cbl:107
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/csd/CARDDEMO.CSD:459`, entry transactions (open (4 public / 0 private estates))

**`app/cbl/COUSR02C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR02C_port_ticket.md`](ai_agent_jobs/COUSR02C_port_ticket.md)

- [ ] **WL-0020** `src/main/java/com/gitgalaxy/modernized/controller/Cousr02cController.java:20` (`Cousr02cController#link`, `Cousr02cController#transactionCU02`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 194 bytes) at app/cbl/COUSR02C.cbl:135
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COUSR00C.cbl:196`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COUSR00C.cbl:206`, CICS resources (open (5 public / 0 private estates))

**`app/cbl/COUSR03C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR03C_port_ticket.md`](ai_agent_jobs/COUSR03C_port_ticket.md)

- [ ] **WL-0021** `src/main/java/com/gitgalaxy/modernized/controller/Cousr03cController.java:20` (`Cousr03cController#link`, `Cousr03cController#transactionCU03`): callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 194 bytes) at app/cbl/COUSR03C.cbl:134
  - fact: `app/cbl/COADM01C.cbl:145`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COUSR00C.cbl:196`, CICS resources (open (5 public / 0 private estates))
  - fact: `app/cbl/COUSR00C.cbl:206`, CICS resources (open (5 public / 0 private estates))

<a id="record-variant"></a>
## Programs reading another record layout (conflict)

_Resolution:_ Map the program's record onto the entity's fields (or split the entity); the two layouts' sizes are in the TODO.

**`app/cbl/CBACT01C.cbl`** -- porting ticket [`ai_agent_jobs/CBACT01C_port_ticket.md`](ai_agent_jobs/CBACT01C_port_ticket.md)

- [ ] **WL-0022** `src/main/java/com/gitgalaxy/modernized/service/Cbact01cService.java:30` (`Cbact01cService#readAllAcctfileFile`): this program uses FD-ACCTFILE-REC (300 bytes); the entity follows ACCOUNT-RECORD (300 bytes) -- map one onto the other
  - fact: `app/cbl/CBACT01C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBACT02C.cbl`** -- porting ticket [`ai_agent_jobs/CBACT02C_port_ticket.md`](ai_agent_jobs/CBACT02C_port_ticket.md)

- [ ] **WL-0023** `src/main/java/com/gitgalaxy/modernized/service/Cbact02cService.java:30` (`Cbact02cService#readAllCardfileFile`): this program uses FD-CARDFILE-REC (150 bytes); the entity follows CARD-RECORD (150 bytes) -- map one onto the other
  - fact: `app/cbl/CBACT02C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBACT03C.cbl`** -- porting ticket [`ai_agent_jobs/CBACT03C_port_ticket.md`](ai_agent_jobs/CBACT03C_port_ticket.md)

- [ ] **WL-0024** `src/main/java/com/gitgalaxy/modernized/service/Cbact03cService.java:30` (`Cbact03cService#readAllXreffileFile`): this program uses FD-XREFFILE-REC (50 bytes); the entity follows CARD-XREF-RECORD (50 bytes) -- map one onto the other
  - fact: `app/cbl/CBACT03C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBACT04C.cbl`** -- porting ticket [`ai_agent_jobs/CBACT04C_port_ticket.md`](ai_agent_jobs/CBACT04C_port_ticket.md)

- [ ] **WL-0025** `src/main/java/com/gitgalaxy/modernized/service/Cbact04cService.java:41` (`Cbact04cService#readAccountFile`, `Cbact04cService#rewriteAccountFile`): this program uses FD-ACCTFILE-REC (300 bytes); the entity follows ACCOUNT-RECORD (300 bytes) -- map one onto the other
  - fact: `app/cbl/CBACT04C.cbl`, VSAM defines (open (3 public / 0 private estates))
- [ ] **WL-0026** `src/main/java/com/gitgalaxy/modernized/service/Cbact04cService.java:51` (`Cbact04cService#readXrefFile`): this program uses FD-XREFFILE-REC (50 bytes); the entity follows CARD-XREF-RECORD (50 bytes) -- map one onto the other
  - fact: `app/cbl/CBACT04C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBCUS01C.cbl`** -- porting ticket [`ai_agent_jobs/CBCUS01C_port_ticket.md`](ai_agent_jobs/CBCUS01C_port_ticket.md)

- [ ] **WL-0027** `src/main/java/com/gitgalaxy/modernized/service/Cbcus01cService.java:30` (`Cbcus01cService#readAllCustfileFile`): this program uses FD-CUSTFILE-REC (500 bytes); the entity follows CUSTOMER-RECORD (500 bytes) -- map one onto the other
  - fact: `app/cbl/CBCUS01C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBEXPORT.cbl`** -- porting ticket [`ai_agent_jobs/CBEXPORT_port_ticket.md`](ai_agent_jobs/CBEXPORT_port_ticket.md)

- [ ] **WL-0028** `src/main/java/com/gitgalaxy/modernized/service/CbexportService.java:69` (`CbexportService#writeExportOutput`): this program uses EXPORT-OUTPUT-RECORD (500 bytes); the entity follows EXPORT-INPUT-RECORD (500 bytes) -- map one onto the other
  - fact: `app/cbl/CBEXPORT.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBSTM03B.CBL`** -- porting ticket [`ai_agent_jobs/CBSTM03B_port_ticket.md`](ai_agent_jobs/CBSTM03B_port_ticket.md)

- [ ] **WL-0029** `src/main/java/com/gitgalaxy/modernized/service/Cbstm03bService.java:46` (`Cbstm03bService#readAcctFile`): this program uses FD-ACCTFILE-REC (300 bytes); the entity follows ACCOUNT-RECORD (300 bytes) -- map one onto the other
  - fact: `app/cbl/CBSTM03B.CBL`, VSAM defines (open (3 public / 0 private estates))
- [ ] **WL-0030** `src/main/java/com/gitgalaxy/modernized/service/Cbstm03bService.java:52` (`Cbstm03bService#readAllXrefFile`): this program uses FD-XREFFILE-REC (50 bytes); the entity follows CARD-XREF-RECORD (50 bytes) -- map one onto the other
  - fact: `app/cbl/CBSTM03B.CBL`, VSAM defines (open (3 public / 0 private estates))
- [ ] **WL-0031** `src/main/java/com/gitgalaxy/modernized/service/Cbstm03bService.java:59` (`Cbstm03bService#readCustFile`): this program uses FD-CUSTFILE-REC (500 bytes); the entity follows CUSTOMER-RECORD (500 bytes) -- map one onto the other
  - fact: `app/cbl/CBSTM03B.CBL`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBTRN02C.cbl`** -- porting ticket [`ai_agent_jobs/CBTRN02C_port_ticket.md`](ai_agent_jobs/CBTRN02C_port_ticket.md)

- [ ] **WL-0032** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn02cService.java:40` (`Cbtrn02cService#readAccountFile`, `Cbtrn02cService#rewriteAccountFile`): this program uses FD-ACCTFILE-REC (300 bytes); the entity follows ACCOUNT-RECORD (300 bytes) -- map one onto the other
  - fact: `app/cbl/CBTRN02C.cbl`, VSAM defines (open (3 public / 0 private estates))
- [ ] **WL-0033** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn02cService.java:50` (`Cbtrn02cService#readXrefFile`): this program uses FD-XREFFILE-REC (50 bytes); the entity follows CARD-XREF-RECORD (50 bytes) -- map one onto the other
  - fact: `app/cbl/CBTRN02C.cbl`, VSAM defines (open (3 public / 0 private estates))
- [ ] **WL-0034** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn02cService.java:65` (`Cbtrn02cService#writeTransactFile`): this program uses FD-TRANFILE-REC (350 bytes); the entity follows TRAN-RECORD (350 bytes) -- map one onto the other
  - fact: `app/cbl/CBTRN02C.cbl`, VSAM defines (open (3 public / 0 private estates))

**`app/cbl/CBTRN03C.cbl`** -- porting ticket [`ai_agent_jobs/CBTRN03C_port_ticket.md`](ai_agent_jobs/CBTRN03C_port_ticket.md)

- [ ] **WL-0035** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn03cService.java:37` (`Cbtrn03cService#readXrefFile`): this program uses FD-CARDXREF-REC (50 bytes); the entity follows CARD-XREF-RECORD (50 bytes) -- map one onto the other
  - fact: `app/cbl/CBTRN03C.cbl`, VSAM defines (open (3 public / 0 private estates))

<a id="missing-layout"></a>
## Unresolved layouts (fact-gap)

_Resolution:_ Add the missing copybook / %INCLUDE member or record to the repository and re-run; the DTO then gets its real fields.

**`app/app-vsam-mq/cbl/COACCT01.cbl`** -- porting ticket [`ai_agent_jobs/COACCT01_port_ticket.md`](ai_agent_jobs/COACCT01_port_ticket.md)

- [ ] **WL-0036** `src/main/java/com/gitgalaxy/modernized/controller/Coacct01Controller.java:18` (`Coacct01Controller#transactionCDRA`): no COMMAREA layout: no LINKAGE DFHCOMMAREA, and no resolved caller passes this program a COMMAREA
  - fact: `app/app-vsam-mq/csd/CRDDEMOM.csd:17`, entry transactions (open (4 public / 0 private estates))

**`app/app-vsam-mq/cbl/CODATE01.cbl`** -- porting ticket [`ai_agent_jobs/CODATE01_port_ticket.md`](ai_agent_jobs/CODATE01_port_ticket.md)

- [ ] **WL-0037** `src/main/java/com/gitgalaxy/modernized/controller/Codate01Controller.java:18` (`Codate01Controller#transactionCDRD`): no COMMAREA layout: no LINKAGE DFHCOMMAREA, and no resolved caller passes this program a COMMAREA
  - fact: `app/app-vsam-mq/csd/CRDDEMOM.csd:27`, entry transactions (open (4 public / 0 private estates))

<a id="vsam-key"></a>
## Keys that are not one field (fact-gap)

_Resolution:_ Name the key: split the record so the key is one field, or keep the String vsamKey in step with the record; for a browse, add a range query over the key.

**`app/cbl/CBACT04C.cbl`** -- porting ticket [`ai_agent_jobs/CBACT04C_port_ticket.md`](ai_agent_jobs/CBACT04C_port_ticket.md)

- [ ] **WL-0038** `src/main/java/com/gitgalaxy/modernized/service/Cbact04cService.java:62`: its text parts order by the database's collation, not the code page's bytes

**`app/cbl/CBIMPORT.cbl`** -- porting ticket [`ai_agent_jobs/CBIMPORT_port_ticket.md`](ai_agent_jobs/CBIMPORT_port_ticket.md)

- [ ] **WL-0039** `src/main/java/com/gitgalaxy/modernized/service/CbimportService.java:30`: the key is not one field, so it orders by its text, not the code page's bytes

**`app/cbl/CBSTM03B.CBL`** -- porting ticket [`ai_agent_jobs/CBSTM03B_port_ticket.md`](ai_agent_jobs/CBSTM03B_port_ticket.md)

- [ ] **WL-0040** `src/main/java/com/gitgalaxy/modernized/service/Cbstm03bService.java:65`: its text parts order by the database's collation, not the code page's bytes

**`app/jcl/CBEXPORT.jcl`**

- [ ] **WL-0041** `src/main/java/com/gitgalaxy/modernized/entity/vsam/ExportInputRecord.java:19` (`ExportInputRecord`): the key (offset 28, 4 bytes, from IDCAMS KEYS) is not one field of EXPORT-INPUT-RECORD: carried as the String vsamKey -- keep it in step with the record
  - fact: `app/jcl/CBEXPORT.jcl:30`, VSAM defines (open (3 public / 0 private estates))
- [ ] **WL-0042** `src/main/java/com/gitgalaxy/modernized/entity/vsam/ExportInputRecord.java:28`: the key (offset 28, 4 bytes, from IDCAMS KEYS) is not one field of EXPORT-INPUT-RECORD: carried as the String vsamKey -- keep it in step with the record

<a id="batch-utility"></a>
## Utility job steps to port (port)

_Resolution:_ Replace the utility with its Spring Batch equivalent (SORT -> a sorting step, IDCAMS REPRO -> a copy, a TSO / IMS runner -> the program's runBatch), reading its control statements in SYSIN.

**`app/app-authorization-ims-db2-mq/jcl/UNLDGSAM.JCL`**

- [ ] **WL-0043** `src/main/java/com/gitgalaxy/modernized/batch/UnldgsamJobConfig.java` (`UnldgsamJobConfig#STEP01`): STEP01 runs DBUNLDGS through DFSRRC00, which uses the DFSRRC00 PARM position 14 ('N'), an IMS region option the oracle has no model of, which the DFSRRC00 model refuses -- not run: a utility step to port
  - fact: `app/app-authorization-ims-db2-mq/jcl/UNLDGSAM.JCL:26`, JCL job flow (open (5 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/jcl/UNLDPADB.JCL`**

- [ ] **WL-0044** `src/main/java/com/gitgalaxy/modernized/batch/UnldpadbJobConfig.java` (`UnldpadbJobConfig#STEP01`): STEP01 runs PAUDBUNL through DFSRRC00, which uses the DFSRRC00 PARM position 14 ('N'), an IMS region option the oracle has no model of, which the DFSRRC00 model refuses -- not run: a utility step to port
  - fact: `app/app-authorization-ims-db2-mq/jcl/UNLDPADB.JCL:38`, JCL job flow (open (5 public / 0 private estates))

**`app/jcl/CBEXPORT.jcl`**

- [ ] **WL-0045** `src/main/java/com/gitgalaxy/modernized/batch/CbexportJobConfig.java` (`CbexportJobConfig#STEP01`): STEP01 runs IDCAMS, which uses more than one IDCAMS command, which the IDCAMS model refuses -- not run as a record copy: a utility step to port
  - fact: `app/jcl/CBEXPORT.jcl:24`, JCL job flow (open (5 public / 0 private estates))

**`app/jcl/CREASTMT.JCL`**

- [ ] **WL-0046** `src/main/java/com/gitgalaxy/modernized/batch/CreastmtJobConfig.java` (`CreastmtJobConfig#DELDEF01`): DELDEF01 runs IDCAMS, which uses more than one IDCAMS command, which the IDCAMS model refuses -- not run as a record copy: a utility step to port
  - fact: `app/jcl/CREASTMT.JCL:22`, JCL job flow (open (5 public / 0 private estates))
- [ ] **WL-0047** `src/main/java/com/gitgalaxy/modernized/batch/CreastmtJobConfig.java` (`CreastmtJobConfig#STEP010`): STEP010 runs SORT, which is a DFSORT SORT the model lowers, but the job facts carry no record length (LRECL) to lower it -- not run: a utility step to port
  - fact: `app/jcl/CREASTMT.JCL:44`, JCL job flow (open (5 public / 0 private estates))

**`app/jcl/TRANREPT.jcl`**

- [ ] **WL-0048** `src/main/java/com/gitgalaxy/modernized/batch/TranreptJobConfig.java` (`TranreptJobConfig#STEP05R`): STEP05R runs SORT, which is a DFSORT SORT the model lowers, but the job facts carry no record length (LRECL) to lower it -- not run: a utility step to port
  - fact: `app/jcl/TRANREPT.jcl:37`, JCL job flow (open (5 public / 0 private estates))
- [ ] **WL-0049** `src/main/java/com/gitgalaxy/modernized/batch/TranreptJobConfig.java` (`TranreptJobConfig#STEP05R.PRC001`): STEP05R.PRC001 runs IDCAMS, which its SYSIN is a dataset of control statements (not read) -- not run as a record copy: a utility step to port
  - fact: `app/jcl/TRANREPT.jcl:23`, JCL job flow (open (5 public / 0 private estates))

<a id="unchecked-resp"></a>
## CICS responses the COBOL never tests (review)

_Resolution:_ Decide what a failed call does: the COBOL ignores it, so the Java throws; catch it where the old behaviour (carry on) is really wanted.

**`app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUA0C_port_ticket.md`](ai_agent_jobs/COPAUA0C_port_ticket.md)

- [ ] **WL-0050** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:35` (`Copaua0cService`): the RESP of ASKTIME at line 857 (paragraph 8500-INSERT-AUTH) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl:857`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0051** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:36` (`Copaua0cService`): the RESP of ASKTIME at line 986 (paragraph 9500-LOG-ERROR) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl:986`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0052** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:37` (`Copaua0cService`): the RESP of WRITEQ at line 1001 (paragraph 9500-LOG-ERROR) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl:1001`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUS0C_port_ticket.md`](ai_agent_jobs/COPAUS0C_port_ticket.md)

- [ ] **WL-0053** `src/main/java/com/gitgalaxy/modernized/service/Copaus0cService.java:33` (`Copaus0cService`): the RESP of RECEIVE at line 715 (paragraph RECEIVE-PAULST-SCREEN) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:715`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUS1C_port_ticket.md`](ai_agent_jobs/COPAUS1C_port_ticket.md)

- [ ] **WL-0054** `src/main/java/com/gitgalaxy/modernized/service/Copaus1cService.java:23` (`Copaus1cService`): the RESP of RECEIVE at line 400 (paragraph RECEIVE-AUTHVIEW-SCREEN) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl:400`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUS2C_port_ticket.md`](ai_agent_jobs/COPAUS2C_port_ticket.md)

- [ ] **WL-0055** `src/main/java/com/gitgalaxy/modernized/service/Copaus2cService.java:21` (`Copaus2cService`): the RESP of ASKTIME at line 91 (paragraph MAIN-PARA) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl:91`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0056** `src/main/java/com/gitgalaxy/modernized/service/Copaus2cService.java:22` (`Copaus2cService`): the RESP of FORMATTIME at line 95 (paragraph MAIN-PARA) is never tested
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl:95`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTLIC.cbl`** -- porting ticket [`ai_agent_jobs/COTRTLIC_port_ticket.md`](ai_agent_jobs/COTRTLIC_port_ticket.md)

- [ ] **WL-0057** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:24` (`CotrtlicService`): the RESP of RECEIVE at line 931 (paragraph 1100-RECEIVE-SCREEN) is never tested
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:931`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0058** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:25` (`CotrtlicService`): the RESP of SEND at line 1588 (paragraph 2600-SEND-SCREEN) is never tested
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:1588`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTUPC.cbl`** -- porting ticket [`ai_agent_jobs/COTRTUPC_port_ticket.md`](ai_agent_jobs/COTRTUPC_port_ticket.md)

- [ ] **WL-0059** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:23` (`CotrtupcService`): the RESP of RECEIVE at line 642 (paragraph 1100-RECEIVE-MAP) is never tested
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:642`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0060** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:24` (`CotrtupcService`): the RESP of SEND at line 1433 (paragraph 3400-SEND-SCREEN) is never tested
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1433`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0061** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:25` (`CotrtupcService`): the RESP of SEND at line 1684 (paragraph ABEND-ROUTINE) is never tested
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1684`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COACTUPC.cbl`** -- porting ticket [`ai_agent_jobs/COACTUPC_port_ticket.md`](ai_agent_jobs/COACTUPC_port_ticket.md)

- [ ] **WL-0062** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:38` (`CoactupcService`): the RESP of RECEIVE at line 1040 (paragraph 1100-RECEIVE-MAP) is never tested
  - fact: `app/cbl/COACTUPC.cbl:1040`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0063** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:39` (`CoactupcService`): the RESP of SEND at line 3594 (paragraph 3400-SEND-SCREEN) is never tested
  - fact: `app/cbl/COACTUPC.cbl:3594`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0064** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:40` (`CoactupcService`): the RESP of SEND at line 4211 (paragraph ABEND-ROUTINE) is never tested
  - fact: `app/cbl/COACTUPC.cbl:4211`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COACTVWC.cbl`** -- porting ticket [`ai_agent_jobs/COACTVWC_port_ticket.md`](ai_agent_jobs/COACTVWC_port_ticket.md)

- [ ] **WL-0065** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:34` (`CoactvwcService`): the RESP of SEND at line 583 (paragraph 1400-SEND-SCREEN) is never tested
  - fact: `app/cbl/COACTVWC.cbl:583`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0066** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:35` (`CoactvwcService`): the RESP of RECEIVE at line 611 (paragraph 2100-RECEIVE-MAP) is never tested
  - fact: `app/cbl/COACTVWC.cbl:611`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0067** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:36` (`CoactvwcService`): the RESP of SEND at line 924 (paragraph ABEND-ROUTINE) is never tested
  - fact: `app/cbl/COACTVWC.cbl:924`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COADM01C.cbl`** -- porting ticket [`ai_agent_jobs/COADM01C_port_ticket.md`](ai_agent_jobs/COADM01C_port_ticket.md)

- [ ] **WL-0068** `src/main/java/com/gitgalaxy/modernized/service/Coadm01cService.java:22` (`Coadm01cService`): the RESP of RECEIVE at line 194 (paragraph RECEIVE-MENU-SCREEN) is never tested
  - fact: `app/cbl/COADM01C.cbl:194`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COBIL00C.cbl`** -- porting ticket [`ai_agent_jobs/COBIL00C_port_ticket.md`](ai_agent_jobs/COBIL00C_port_ticket.md)

- [ ] **WL-0069** `src/main/java/com/gitgalaxy/modernized/service/Cobil00cService.java:37` (`Cobil00cService`): the RESP of RECEIVE at line 308 (paragraph RECEIVE-BILLPAY-SCREEN) is never tested
  - fact: `app/cbl/COBIL00C.cbl:308`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COCRDLIC.cbl`** -- porting ticket [`ai_agent_jobs/COCRDLIC_port_ticket.md`](ai_agent_jobs/COCRDLIC_port_ticket.md)

- [ ] **WL-0070** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:31` (`CocrdlicService`): the RESP of SEND at line 939 (paragraph 1500-SEND-SCREEN) is never tested
  - fact: `app/cbl/COCRDLIC.cbl:939`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0071** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:32` (`CocrdlicService`): the RESP of RECEIVE at line 963 (paragraph 2100-RECEIVE-SCREEN) is never tested
  - fact: `app/cbl/COCRDLIC.cbl:963`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0072** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:33` (`CocrdlicService`): the RESP of STARTBR at line 1129 (paragraph 9000-READ-FORWARD) is never tested
  - fact: `app/cbl/COCRDLIC.cbl:1129`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0073** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:34` (`CocrdlicService`): the RESP of STARTBR at line 1273 (paragraph 9100-READ-BACKWARDS) is never tested
  - fact: `app/cbl/COCRDLIC.cbl:1273`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COCRDSLC.cbl`** -- porting ticket [`ai_agent_jobs/COCRDSLC_port_ticket.md`](ai_agent_jobs/COCRDSLC_port_ticket.md)

- [ ] **WL-0074** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:29` (`CocrdslcService`): the RESP of SEND at line 569 (paragraph 1400-SEND-SCREEN) is never tested
  - fact: `app/cbl/COCRDSLC.cbl:569`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0075** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:30` (`CocrdslcService`): the RESP of RECEIVE at line 597 (paragraph 2100-RECEIVE-MAP) is never tested
  - fact: `app/cbl/COCRDSLC.cbl:597`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0076** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:31` (`CocrdslcService`): the RESP of SEND at line 865 (paragraph ABEND-ROUTINE) is never tested
  - fact: `app/cbl/COCRDSLC.cbl:865`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COCRDUPC.cbl`** -- porting ticket [`ai_agent_jobs/COCRDUPC_port_ticket.md`](ai_agent_jobs/COCRDUPC_port_ticket.md)

- [ ] **WL-0077** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:30` (`CocrdupcService`): the RESP of RECEIVE at line 579 (paragraph 1100-RECEIVE-MAP) is never tested
  - fact: `app/cbl/COCRDUPC.cbl:579`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0078** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:31` (`CocrdupcService`): the RESP of SEND at line 1329 (paragraph 3400-SEND-SCREEN) is never tested
  - fact: `app/cbl/COCRDUPC.cbl:1329`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0079** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:32` (`CocrdupcService`): the RESP of SEND at line 1539 (paragraph ABEND-ROUTINE) is never tested
  - fact: `app/cbl/COCRDUPC.cbl:1539`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COMEN01C.cbl`** -- porting ticket [`ai_agent_jobs/COMEN01C_port_ticket.md`](ai_agent_jobs/COMEN01C_port_ticket.md)

- [ ] **WL-0080** `src/main/java/com/gitgalaxy/modernized/service/Comen01cService.java:22` (`Comen01cService`): the RESP of RECEIVE at line 227 (paragraph RECEIVE-MENU-SCREEN) is never tested
  - fact: `app/cbl/COMEN01C.cbl:227`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/CORPT00C.cbl`** -- porting ticket [`ai_agent_jobs/CORPT00C_port_ticket.md`](ai_agent_jobs/CORPT00C_port_ticket.md)

- [ ] **WL-0081** `src/main/java/com/gitgalaxy/modernized/service/Corpt00cService.java:25` (`Corpt00cService`): the RESP of RECEIVE at line 598 (paragraph RECEIVE-TRNRPT-SCREEN) is never tested
  - fact: `app/cbl/CORPT00C.cbl:598`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COSGN00C.cbl`** -- porting ticket [`ai_agent_jobs/COSGN00C_port_ticket.md`](ai_agent_jobs/COSGN00C_port_ticket.md)

- [ ] **WL-0082** `src/main/java/com/gitgalaxy/modernized/service/Cosgn00cService.java:28` (`Cosgn00cService`): the RESP of RECEIVE at line 110 (paragraph PROCESS-ENTER-KEY) is never tested
  - fact: `app/cbl/COSGN00C.cbl:110`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COTRN00C.cbl`** -- porting ticket [`ai_agent_jobs/COTRN00C_port_ticket.md`](ai_agent_jobs/COTRN00C_port_ticket.md)

- [ ] **WL-0083** `src/main/java/com/gitgalaxy/modernized/service/Cotrn00cService.java:30` (`Cotrn00cService`): the RESP of RECEIVE at line 556 (paragraph RECEIVE-TRNLST-SCREEN) is never tested
  - fact: `app/cbl/COTRN00C.cbl:556`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COTRN01C.cbl`** -- porting ticket [`ai_agent_jobs/COTRN01C_port_ticket.md`](ai_agent_jobs/COTRN01C_port_ticket.md)

- [ ] **WL-0084** `src/main/java/com/gitgalaxy/modernized/service/Cotrn01cService.java:27` (`Cotrn01cService`): the RESP of RECEIVE at line 232 (paragraph RECEIVE-TRNVIEW-SCREEN) is never tested
  - fact: `app/cbl/COTRN01C.cbl:232`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COTRN02C.cbl`** -- porting ticket [`ai_agent_jobs/COTRN02C_port_ticket.md`](ai_agent_jobs/COTRN02C_port_ticket.md)

- [ ] **WL-0085** `src/main/java/com/gitgalaxy/modernized/service/Cotrn02cService.java:36` (`Cotrn02cService`): the RESP of RECEIVE at line 541 (paragraph RECEIVE-TRNADD-SCREEN) is never tested
  - fact: `app/cbl/COTRN02C.cbl:541`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COUSR00C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR00C_port_ticket.md`](ai_agent_jobs/COUSR00C_port_ticket.md)

- [ ] **WL-0086** `src/main/java/com/gitgalaxy/modernized/service/Cousr00cService.java:30` (`Cousr00cService`): the RESP of RECEIVE at line 551 (paragraph RECEIVE-USRLST-SCREEN) is never tested
  - fact: `app/cbl/COUSR00C.cbl:551`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COUSR01C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR01C_port_ticket.md`](ai_agent_jobs/COUSR01C_port_ticket.md)

- [ ] **WL-0087** `src/main/java/com/gitgalaxy/modernized/service/Cousr01cService.java:27` (`Cousr01cService`): the RESP of RECEIVE at line 203 (paragraph RECEIVE-USRADD-SCREEN) is never tested
  - fact: `app/cbl/COUSR01C.cbl:203`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COUSR02C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR02C_port_ticket.md`](ai_agent_jobs/COUSR02C_port_ticket.md)

- [ ] **WL-0088** `src/main/java/com/gitgalaxy/modernized/service/Cousr02cService.java:28` (`Cousr02cService`): the RESP of RECEIVE at line 285 (paragraph RECEIVE-USRUPD-SCREEN) is never tested
  - fact: `app/cbl/COUSR02C.cbl:285`, units of work and handlers (field-tested (6 public / 0 private estates))

**`app/cbl/COUSR03C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR03C_port_ticket.md`](ai_agent_jobs/COUSR03C_port_ticket.md)

- [ ] **WL-0089** `src/main/java/com/gitgalaxy/modernized/service/Cousr03cService.java:28` (`Cousr03cService`): the RESP of RECEIVE at line 232 (paragraph RECEIVE-USRDEL-SCREEN) is never tested
  - fact: `app/cbl/COUSR03C.cbl:232`, units of work and handlers (field-tested (6 public / 0 private estates))

<a id="db2-dialect"></a>
## DB2 SQL on another database (review)

_Resolution:_ Run each statement on the target database; DB2-only syntax (FETCH FIRST, WITH UR, special registers) needs its equivalent.

**`app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUS2C_port_ticket.md`](ai_agent_jobs/COPAUS2C_port_ticket.md)

- [ ] **WL-0090** `src/main/java/com/gitgalaxy/modernized/repository/db2/AuthfrdsRepository.java` (`AuthfrdsRepository#insertL141Copaus2c`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl:141`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0091** `src/main/java/com/gitgalaxy/modernized/repository/db2/AuthfrdsRepository.java` (`AuthfrdsRepository#updateL222Copaus2c`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl:222`, DB2 table access (open (3 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COBTUPDT.cbl`** -- porting ticket [`ai_agent_jobs/COBTUPDT_port_ticket.md`](ai_agent_jobs/COBTUPDT_port_ticket.md)

- [ ] **WL-0092** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#deleteL201Cobtupdt`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COBTUPDT.cbl:201`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0093** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#insertL137Cobtupdt`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COBTUPDT.cbl:137`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0094** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#updateL171Cobtupdt`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COBTUPDT.cbl:171`, DB2 table access (open (3 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTLIC.cbl`** -- porting ticket [`ai_agent_jobs/COTRTLIC_port_ticket.md`](ai_agent_jobs/COTRTLIC_port_ticket.md)

- [ ] **WL-0095** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#cursorCTrTypeBackwardL354Cotrtlic`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:354`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0096** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#cursorCTrTypeForwardL338Cotrtlic`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:338`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0097** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#deleteL1900Cotrtlic`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:1900`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0098** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#selectL1803Cotrtlic`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:1803`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0099** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#updateL1846Cotrtlic`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTLIC.cbl:1846`, DB2 table access (open (3 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTUPC.cbl`** -- porting ticket [`ai_agent_jobs/COTRTUPC_port_ticket.md`](ai_agent_jobs/COTRTUPC_port_ticket.md)

- [ ] **WL-0100** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#deleteL1627Cotrtupc`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1627`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0101** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#insertL1597Cotrtupc`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1597`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0102** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#selectL1475Cotrtupc`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1475`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0103** `src/main/java/com/gitgalaxy/modernized/repository/db2/TransactionTypeRepository.java` (`TransactionTypeRepository#updateL1544Cotrtupc`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cbl/COTRTUPC.cbl:1544`, DB2 table access (open (3 public / 0 private estates))

**`app/app-transaction-type-db2/cpy/CSDB2RPY.cpy`**

- [ ] **WL-0104** `src/main/java/com/gitgalaxy/modernized/repository/db2/Sysdummy1Repository.java` (`Sysdummy1Repository#selectL23Cotrtlic`): DB2 SQL on postgresql -- review the statement
  - fact: `app/app-transaction-type-db2/cpy/CSDB2RPY.cpy:23`, DB2 table access (open (3 public / 0 private estates))

<a id="transaction-split"></a>
## Unit-of-work boundaries to split (port)

_Resolution:_ End the transaction at the SYNCPOINT the comment cites: a nested REQUIRES_NEW call, or two service methods.

**`app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUA0C_port_ticket.md`](ai_agent_jobs/COPAUA0C_port_ticket.md)

- [ ] **WL-0105** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:113`: split the transaction here

**`app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUS0C_port_ticket.md`](ai_agent_jobs/COPAUS0C_port_ticket.md)

- [ ] **WL-0106** `src/main/java/com/gitgalaxy/modernized/service/Copaus0cService.java:184`: split the transaction here

**`app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUS1C_port_ticket.md`](ai_agent_jobs/COPAUS1C_port_ticket.md)

- [ ] **WL-0107** `src/main/java/com/gitgalaxy/modernized/service/Copaus1cService.java:155`: split the transaction here

**`app/app-transaction-type-db2/cbl/COTRTLIC.cbl`** -- porting ticket [`ai_agent_jobs/COTRTLIC_port_ticket.md`](ai_agent_jobs/COTRTLIC_port_ticket.md)

- [ ] **WL-0108** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:172`: split the transaction here
- [ ] **WL-0109** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:182`: split the transaction here
- [ ] **WL-0110** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:192`: split the transaction here

**`app/app-transaction-type-db2/cbl/COTRTUPC.cbl`** -- porting ticket [`ai_agent_jobs/COTRTUPC_port_ticket.md`](ai_agent_jobs/COTRTUPC_port_ticket.md)

- [ ] **WL-0111** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:151`: split the transaction here
- [ ] **WL-0112** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:161`: split the transaction here
- [ ] **WL-0113** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:171`: split the transaction here
- [ ] **WL-0114** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:181`: split the transaction here

**`app/app-vsam-mq/cbl/COACCT01.cbl`** -- porting ticket [`ai_agent_jobs/COACCT01_port_ticket.md`](ai_agent_jobs/COACCT01_port_ticket.md)

- [ ] **WL-0115** `src/main/java/com/gitgalaxy/modernized/service/Coacct01Service.java:87`: split the transaction here

**`app/app-vsam-mq/cbl/CODATE01.cbl`** -- porting ticket [`ai_agent_jobs/CODATE01_port_ticket.md`](ai_agent_jobs/CODATE01_port_ticket.md)

- [ ] **WL-0116** `src/main/java/com/gitgalaxy/modernized/service/Codate01Service.java:76`: split the transaction here

**`app/cbl/COACTUPC.cbl`** -- porting ticket [`ai_agent_jobs/COACTUPC_port_ticket.md`](ai_agent_jobs/COACTUPC_port_ticket.md)

- [ ] **WL-0117** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:191`: split the transaction here

**`app/cbl/COCRDUPC.cbl`** -- porting ticket [`ai_agent_jobs/COCRDUPC_port_ticket.md`](ai_agent_jobs/COCRDUPC_port_ticket.md)

- [ ] **WL-0118** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:167`: split the transaction here

<a id="interface-call"></a>
## Calls to other services (port)

_Resolution:_ Wire the called service (or a mock) in place of the placeholder.

**`app/cbl/CORPT00C.cbl`** -- porting ticket [`ai_agent_jobs/CORPT00C_port_ticket.md`](ai_agent_jobs/CORPT00C_port_ticket.md)

- [ ] **WL-0119** `src/main/java/com/gitgalaxy/modernized/service/Corpt00cService.java:152`: this program submits job TRNRPT00 through the internal reader, which runs PROC TRANREPT (app/proc/TRANREPT.prc): no generated job matches -- launch its steps

<a id="business-logic"></a>
## Business logic to port (port)

_Resolution:_ Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch.

**`app/app-authorization-ims-db2-mq/cbl/CBPAUP0C.cbl`** -- porting ticket [`ai_agent_jobs/CBPAUP0C_port_ticket.md`](ai_agent_jobs/CBPAUP0C_port_ticket.md)

- [ ] **WL-0120** `src/main/java/com/gitgalaxy/modernized/service/Cbpaup0cService.java:26` (`Cbpaup0cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/app-authorization-ims-db2-mq/jcl/CBPAUP0J.jcl:24`, JCL job flow (open (5 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUA0C_port_ticket.md`](ai_agent_jobs/COPAUA0C_port_ticket.md)

- [ ] **WL-0121** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:82`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0122** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:88`: port the PROCEDURE DIVISION into this task
- [ ] **WL-0123** `src/main/java/com/gitgalaxy/modernized/service/Copaua0cService.java:132` (`Copaua0cService#handleMqMessage`): port the logic that handles the MQ request
  - fact: `app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl:400`, MQ calls (open (1 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUS0C_port_ticket.md`](ai_agent_jobs/COPAUS0C_port_ticket.md)

- [ ] **WL-0124** `src/main/java/com/gitgalaxy/modernized/service/Copaus0cService.java:104`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0125** `src/main/java/com/gitgalaxy/modernized/service/Copaus0cService.java:110`: port the PROCEDURE DIVISION into this task

**`app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUS1C_port_ticket.md`](ai_agent_jobs/COPAUS1C_port_ticket.md)

- [ ] **WL-0126** `src/main/java/com/gitgalaxy/modernized/service/Copaus1cService.java:90`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0127** `src/main/java/com/gitgalaxy/modernized/service/Copaus1cService.java:96`: port the PROCEDURE DIVISION into this task

**`app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl`** -- porting ticket [`ai_agent_jobs/COPAUS2C_port_ticket.md`](ai_agent_jobs/COPAUS2C_port_ticket.md)

- [ ] **WL-0128** `src/main/java/com/gitgalaxy/modernized/service/Copaus2cService.java:33`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0129** `src/main/java/com/gitgalaxy/modernized/service/Copaus2cService.java:39`: port the PROCEDURE DIVISION into this task

**`app/app-authorization-ims-db2-mq/cbl/DBUNLDGS.CBL`** -- porting ticket [`ai_agent_jobs/DBUNLDGS_port_ticket.md`](ai_agent_jobs/DBUNLDGS_port_ticket.md)

- [ ] **WL-0130** `src/main/java/com/gitgalaxy/modernized/service/DbunldgsService.java:26` (`DbunldgsService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/app-authorization-ims-db2-mq/jcl/UNLDGSAM.JCL:26`, JCL job flow (open (5 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/PAUDBLOD.CBL`** -- porting ticket [`ai_agent_jobs/PAUDBLOD_port_ticket.md`](ai_agent_jobs/PAUDBLOD_port_ticket.md)

- [ ] **WL-0131** `src/main/java/com/gitgalaxy/modernized/service/PaudblodService.java:28` (`PaudblodService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/app-authorization-ims-db2-mq/jcl/LOADPADB.JCL:26`, JCL job flow (open (5 public / 0 private estates))

**`app/app-authorization-ims-db2-mq/cbl/PAUDBUNL.CBL`** -- porting ticket [`ai_agent_jobs/PAUDBUNL_port_ticket.md`](ai_agent_jobs/PAUDBUNL_port_ticket.md)

- [ ] **WL-0132** `src/main/java/com/gitgalaxy/modernized/service/PaudbunlService.java:28` (`PaudbunlService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/app-authorization-ims-db2-mq/jcl/UNLDPADB.JCL:38`, JCL job flow (open (5 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COBTUPDT.cbl`** -- porting ticket [`ai_agent_jobs/COBTUPDT_port_ticket.md`](ai_agent_jobs/COBTUPDT_port_ticket.md)

- [ ] **WL-0133** `src/main/java/com/gitgalaxy/modernized/service/CobtupdtService.java:30` (`CobtupdtService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/app-transaction-type-db2/jcl/MNTTRDB2.jcl:21`, JCL job flow (open (5 public / 0 private estates))

**`app/app-transaction-type-db2/cbl/COTRTLIC.cbl`** -- porting ticket [`ai_agent_jobs/COTRTLIC_port_ticket.md`](ai_agent_jobs/COTRTLIC_port_ticket.md)

- [ ] **WL-0134** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:95`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0135** `src/main/java/com/gitgalaxy/modernized/service/CotrtlicService.java:101`: port the PROCEDURE DIVISION into this task

**`app/app-transaction-type-db2/cbl/COTRTUPC.cbl`** -- porting ticket [`ai_agent_jobs/COTRTUPC_port_ticket.md`](ai_agent_jobs/COTRTUPC_port_ticket.md)

- [ ] **WL-0136** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:94`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0137** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:100`: port the PROCEDURE DIVISION into this task
- [ ] **WL-0138** `src/main/java/com/gitgalaxy/modernized/service/CotrtupcService.java:190`: port paragraph ABEND-ROUTINE's logic

**`app/app-vsam-mq/cbl/COACCT01.cbl`** -- porting ticket [`ai_agent_jobs/COACCT01_port_ticket.md`](ai_agent_jobs/COACCT01_port_ticket.md)

- [ ] **WL-0139** `src/main/java/com/gitgalaxy/modernized/service/Coacct01Service.java:66`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0140** `src/main/java/com/gitgalaxy/modernized/service/Coacct01Service.java:72`: port the PROCEDURE DIVISION into this task
- [ ] **WL-0141** `src/main/java/com/gitgalaxy/modernized/service/Coacct01Service.java:105` (`Coacct01Service#handleMqMessage`): port the logic that handles the MQ request
  - fact: `app/app-vsam-mq/cbl/COACCT01.cbl:352`, MQ calls (open (1 public / 0 private estates))

**`app/app-vsam-mq/cbl/CODATE01.cbl`** -- porting ticket [`ai_agent_jobs/CODATE01_port_ticket.md`](ai_agent_jobs/CODATE01_port_ticket.md)

- [ ] **WL-0142** `src/main/java/com/gitgalaxy/modernized/service/Codate01Service.java:60`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0143** `src/main/java/com/gitgalaxy/modernized/service/Codate01Service.java:66`: port the PROCEDURE DIVISION into this task
- [ ] **WL-0144** `src/main/java/com/gitgalaxy/modernized/service/Codate01Service.java:94` (`Codate01Service#handleMqMessage`): port the logic that handles the MQ request
  - fact: `app/app-vsam-mq/cbl/CODATE01.cbl:301`, MQ calls (open (1 public / 0 private estates))

**`app/cbl/CBACT01C.cbl`** -- porting ticket [`ai_agent_jobs/CBACT01C_port_ticket.md`](ai_agent_jobs/CBACT01C_port_ticket.md)

- [ ] **WL-0145** `src/main/java/com/gitgalaxy/modernized/service/Cbact01cService.java:43` (`Cbact01cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/READACCT.jcl:32`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBACT02C.cbl`** -- porting ticket [`ai_agent_jobs/CBACT02C_port_ticket.md`](ai_agent_jobs/CBACT02C_port_ticket.md)

- [ ] **WL-0146** `src/main/java/com/gitgalaxy/modernized/service/Cbact02cService.java:40` (`Cbact02cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/READCARD.jcl:22`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBACT03C.cbl`** -- porting ticket [`ai_agent_jobs/CBACT03C_port_ticket.md`](ai_agent_jobs/CBACT03C_port_ticket.md)

- [ ] **WL-0147** `src/main/java/com/gitgalaxy/modernized/service/Cbact03cService.java:40` (`Cbact03cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/READXREF.jcl:22`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBACT04C.cbl`** -- porting ticket [`ai_agent_jobs/CBACT04C_port_ticket.md`](ai_agent_jobs/CBACT04C_port_ticket.md)

- [ ] **WL-0148** `src/main/java/com/gitgalaxy/modernized/service/Cbact04cService.java:75` (`Cbact04cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/INTCALC.jcl:22`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBCUS01C.cbl`** -- porting ticket [`ai_agent_jobs/CBCUS01C_port_ticket.md`](ai_agent_jobs/CBCUS01C_port_ticket.md)

- [ ] **WL-0149** `src/main/java/com/gitgalaxy/modernized/service/Cbcus01cService.java:40` (`Cbcus01cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/READCUST.jcl:21`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBEXPORT.cbl`** -- porting ticket [`ai_agent_jobs/CBEXPORT_port_ticket.md`](ai_agent_jobs/CBEXPORT_port_ticket.md)

- [ ] **WL-0150** `src/main/java/com/gitgalaxy/modernized/service/CbexportService.java:89` (`CbexportService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/CBEXPORT.jcl:43`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBIMPORT.cbl`** -- porting ticket [`ai_agent_jobs/CBIMPORT_port_ticket.md`](ai_agent_jobs/CBIMPORT_port_ticket.md)

- [ ] **WL-0151** `src/main/java/com/gitgalaxy/modernized/service/CbimportService.java:45` (`CbimportService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/CBIMPORT.jcl:22`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBSTM03A.CBL`** -- porting ticket [`ai_agent_jobs/CBSTM03A_port_ticket.md`](ai_agent_jobs/CBSTM03A_port_ticket.md)

- [ ] **WL-0152** `src/main/java/com/gitgalaxy/modernized/service/Cbstm03aService.java:38` (`Cbstm03aService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/CREASTMT.JCL:79`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBSTM03B.CBL`** -- porting ticket [`ai_agent_jobs/CBSTM03B_port_ticket.md`](ai_agent_jobs/CBSTM03B_port_ticket.md)

- [ ] **WL-0153** `src/main/java/com/gitgalaxy/modernized/service/Cbstm03bService.java:39`: implement from the program's business rules

**`app/cbl/CBTRN01C.cbl`** -- porting ticket [`ai_agent_jobs/CBTRN01C_port_ticket.md`](ai_agent_jobs/CBTRN01C_port_ticket.md)

- [ ] **WL-0154** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn01cService.java:32` (`Cbtrn01cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE

**`app/cbl/CBTRN02C.cbl`** -- porting ticket [`ai_agent_jobs/CBTRN02C_port_ticket.md`](ai_agent_jobs/CBTRN02C_port_ticket.md)

- [ ] **WL-0155** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn02cService.java:79` (`Cbtrn02cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/POSTTRAN.jcl:23`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/CBTRN03C.cbl`** -- porting ticket [`ai_agent_jobs/CBTRN03C_port_ticket.md`](ai_agent_jobs/CBTRN03C_port_ticket.md)

- [ ] **WL-0156** `src/main/java/com/gitgalaxy/modernized/service/Cbtrn03cService.java:61` (`Cbtrn03cService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/TRANREPT.jcl:59`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/COACTUPC.cbl`** -- porting ticket [`ai_agent_jobs/COACTUPC_port_ticket.md`](ai_agent_jobs/COACTUPC_port_ticket.md)

- [ ] **WL-0157** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:111`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0158** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:117`: port the PROCEDURE DIVISION into this task
- [ ] **WL-0159** `src/main/java/com/gitgalaxy/modernized/service/CoactupcService.java:208`: port paragraph ABEND-ROUTINE's logic

**`app/cbl/COACTVWC.cbl`** -- porting ticket [`ai_agent_jobs/COACTVWC_port_ticket.md`](ai_agent_jobs/COACTVWC_port_ticket.md)

- [ ] **WL-0160** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:107`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0161** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:113`: port the PROCEDURE DIVISION into this task
- [ ] **WL-0162** `src/main/java/com/gitgalaxy/modernized/service/CoactvwcService.java:178`: port paragraph ABEND-ROUTINE's logic

**`app/cbl/COADM01C.cbl`** -- porting ticket [`ai_agent_jobs/COADM01C_port_ticket.md`](ai_agent_jobs/COADM01C_port_ticket.md)

- [ ] **WL-0163** `src/main/java/com/gitgalaxy/modernized/service/Coadm01cService.java:83`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0164** `src/main/java/com/gitgalaxy/modernized/service/Coadm01cService.java:89`: port the PROCEDURE DIVISION into this task
- [ ] **WL-0165** `src/main/java/com/gitgalaxy/modernized/service/Coadm01cService.java:147`: port paragraph PGMIDERR-ERR-PARA's logic

**`app/cbl/COBIL00C.cbl`** -- porting ticket [`ai_agent_jobs/COBIL00C_port_ticket.md`](ai_agent_jobs/COBIL00C_port_ticket.md)

- [ ] **WL-0166** `src/main/java/com/gitgalaxy/modernized/service/Cobil00cService.java:108`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0167** `src/main/java/com/gitgalaxy/modernized/service/Cobil00cService.java:114`: port the PROCEDURE DIVISION into this task

**`app/cbl/COBSWAIT.cbl`** -- porting ticket [`ai_agent_jobs/COBSWAIT_port_ticket.md`](ai_agent_jobs/COBSWAIT_port_ticket.md)

- [ ] **WL-0168** `src/main/java/com/gitgalaxy/modernized/service/CobswaitService.java:26` (`CobswaitService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `app/jcl/WAITSTEP.jcl:22`, JCL job flow (open (5 public / 0 private estates))

**`app/cbl/COCRDLIC.cbl`** -- porting ticket [`ai_agent_jobs/COCRDLIC_port_ticket.md`](ai_agent_jobs/COCRDLIC_port_ticket.md)

- [ ] **WL-0169** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:103`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0170** `src/main/java/com/gitgalaxy/modernized/service/CocrdlicService.java:109`: port the PROCEDURE DIVISION into this task

**`app/cbl/COCRDSLC.cbl`** -- porting ticket [`ai_agent_jobs/COCRDSLC_port_ticket.md`](ai_agent_jobs/COCRDSLC_port_ticket.md)

- [ ] **WL-0171** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:100`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0172** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:106`: port the PROCEDURE DIVISION into this task
- [ ] **WL-0173** `src/main/java/com/gitgalaxy/modernized/service/CocrdslcService.java:166`: port paragraph ABEND-ROUTINE's logic

**`app/cbl/COCRDUPC.cbl`** -- porting ticket [`ai_agent_jobs/COCRDUPC_port_ticket.md`](ai_agent_jobs/COCRDUPC_port_ticket.md)

- [ ] **WL-0174** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:101`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0175** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:107`: port the PROCEDURE DIVISION into this task
- [ ] **WL-0176** `src/main/java/com/gitgalaxy/modernized/service/CocrdupcService.java:176`: port paragraph ABEND-ROUTINE's logic

**`app/cbl/COMEN01C.cbl`** -- porting ticket [`ai_agent_jobs/COMEN01C_port_ticket.md`](ai_agent_jobs/COMEN01C_port_ticket.md)

- [ ] **WL-0177** `src/main/java/com/gitgalaxy/modernized/service/Comen01cService.java:83`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0178** `src/main/java/com/gitgalaxy/modernized/service/Comen01cService.java:89`: port the PROCEDURE DIVISION into this task

**`app/cbl/CORPT00C.cbl`** -- porting ticket [`ai_agent_jobs/CORPT00C_port_ticket.md`](ai_agent_jobs/CORPT00C_port_ticket.md)

- [ ] **WL-0179** `src/main/java/com/gitgalaxy/modernized/service/Corpt00cService.java:89`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0180** `src/main/java/com/gitgalaxy/modernized/service/Corpt00cService.java:95`: port the PROCEDURE DIVISION into this task

**`app/cbl/COSGN00C.cbl`** -- porting ticket [`ai_agent_jobs/COSGN00C_port_ticket.md`](ai_agent_jobs/COSGN00C_port_ticket.md)

- [ ] **WL-0181** `src/main/java/com/gitgalaxy/modernized/service/Cosgn00cService.java:93`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0182** `src/main/java/com/gitgalaxy/modernized/service/Cosgn00cService.java:99`: port the PROCEDURE DIVISION into this task

**`app/cbl/COTRN00C.cbl`** -- porting ticket [`ai_agent_jobs/COTRN00C_port_ticket.md`](ai_agent_jobs/COTRN00C_port_ticket.md)

- [ ] **WL-0183** `src/main/java/com/gitgalaxy/modernized/service/Cotrn00cService.java:99`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0184** `src/main/java/com/gitgalaxy/modernized/service/Cotrn00cService.java:105`: port the PROCEDURE DIVISION into this task

**`app/cbl/COTRN01C.cbl`** -- porting ticket [`ai_agent_jobs/COTRN01C_port_ticket.md`](ai_agent_jobs/COTRN01C_port_ticket.md)

- [ ] **WL-0185** `src/main/java/com/gitgalaxy/modernized/service/Cotrn01cService.java:96`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0186** `src/main/java/com/gitgalaxy/modernized/service/Cotrn01cService.java:102`: port the PROCEDURE DIVISION into this task

**`app/cbl/COTRN02C.cbl`** -- porting ticket [`ai_agent_jobs/COTRN02C_port_ticket.md`](ai_agent_jobs/COTRN02C_port_ticket.md)

- [ ] **WL-0187** `src/main/java/com/gitgalaxy/modernized/service/Cotrn02cService.java:106`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0188** `src/main/java/com/gitgalaxy/modernized/service/Cotrn02cService.java:112`: port the PROCEDURE DIVISION into this task

**`app/cbl/COUSR00C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR00C_port_ticket.md`](ai_agent_jobs/COUSR00C_port_ticket.md)

- [ ] **WL-0189** `src/main/java/com/gitgalaxy/modernized/service/Cousr00cService.java:99`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0190** `src/main/java/com/gitgalaxy/modernized/service/Cousr00cService.java:105`: port the PROCEDURE DIVISION into this task

**`app/cbl/COUSR01C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR01C_port_ticket.md`](ai_agent_jobs/COUSR01C_port_ticket.md)

- [ ] **WL-0191** `src/main/java/com/gitgalaxy/modernized/service/Cousr01cService.java:90`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0192** `src/main/java/com/gitgalaxy/modernized/service/Cousr01cService.java:96`: port the PROCEDURE DIVISION into this task

**`app/cbl/COUSR02C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR02C_port_ticket.md`](ai_agent_jobs/COUSR02C_port_ticket.md)

- [ ] **WL-0193** `src/main/java/com/gitgalaxy/modernized/service/Cousr02cService.java:97`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0194** `src/main/java/com/gitgalaxy/modernized/service/Cousr02cService.java:103`: port the PROCEDURE DIVISION into this task

**`app/cbl/COUSR03C.cbl`** -- porting ticket [`ai_agent_jobs/COUSR03C_port_ticket.md`](ai_agent_jobs/COUSR03C_port_ticket.md)

- [ ] **WL-0195** `src/main/java/com/gitgalaxy/modernized/service/Cousr03cService.java:97`: port the PROCEDURE DIVISION: read task.hasCommarea() / task.commarea(..) / task.aid() / task.receive(map, ..), and record what the program does through the task -- sendMap, sendText, returnTransid, link, xctl, abend -- in the order it does it
- [ ] **WL-0196** `src/main/java/com/gitgalaxy/modernized/service/Cousr03cService.java:103`: port the PROCEDURE DIVISION into this task

**`app/cbl/CSUTLDTC.cbl`** -- porting ticket [`ai_agent_jobs/CSUTLDTC_port_ticket.md`](ai_agent_jobs/CSUTLDTC_port_ticket.md)

- [ ] **WL-0197** `src/main/java/com/gitgalaxy/modernized/service/CsutldtcService.java:22`: implement from the program's business rules

<a id="configuration"></a>
## Target configuration (review)

_Resolution:_ Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file.

**`(project configuration)`**

- [ ] **WL-0198** `src/main/resources/application.yml:9`: Update these credentials for your target environment
