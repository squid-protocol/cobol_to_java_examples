# Migration worklist

Every TODO the generators left in this project: where a fact was missing or two facts disagreed, the Java says so instead of guessing. Each item names the fact it rests on (from `traceability.json`) and a suggested resolution.

**187 items** across 32 program sources (COBOL, PL/I).

| nature | items | what it takes |
|---|---:|---|
| conflict | 36 | two facts disagree: a person decides which one the Java follows |
| fact-gap | 7 | a fact is missing: supply it and re-run |
| review | 46 | the Java runs as generated: check it on the target |
| port | 98 | business logic to write |

## By category

| category | nature | items | suggested resolution |
|---|---|---:|---|
| [COMMAREA layout mismatches](#commarea-mismatch) | conflict | 35 | For each caller, confirm which layout the callee reads (the COBOL MOVEs into DFHCOMMAREA say); map that caller's record onto the DTO, or give the callee one DTO per entry. |
| [Programs reading another record layout](#record-variant) | conflict | 1 | Map the program's record onto the entity's fields (or split the entity); the two layouts' sizes are in the TODO. |
| [Unresolved layouts](#missing-layout) | fact-gap | 6 | Add the missing copybook / %INCLUDE member or record to the repository and re-run; the DTO then gets its real fields. |
| [Keys that are not one field](#vsam-key) | fact-gap | 1 | Name the key: split the record so the key is one field, or keep the String vsamKey in step with the record; for a browse, add a range query over the key. |
| [Utility job steps to port](#batch-utility) | port | 2 | Replace the utility with its Spring Batch equivalent (SORT -> a sorting step, IDCAMS REPRO -> a copy, a TSO / IMS runner -> the program's runBatch), reading its control statements in SYSIN. |
| [CICS responses the COBOL never tests](#unchecked-resp) | review | 14 | Decide what a failed call does: the COBOL ignores it, so the Java throws; catch it where the old behaviour (carry on) is really wanted. |
| [DB2 SQL on another database](#db2-dialect) | review | 31 | Run each statement on the target database; DB2-only syntax (FETCH FIRST, WITH UR, special registers) needs its equivalent. |
| [Unit-of-work boundaries to split](#transaction-split) | port | 3 | End the transaction at the SYNCPOINT the comment cites: a nested REQUIRES_NEW call, or two service methods. |
| [Business logic to port](#business-logic) | port | 93 | Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch. |
| [Target configuration](#configuration) | review | 1 | Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file. |

## By program source

| source | conflict | fact-gap | review | port | total |
|---|---:|---:|---:|---:|---:|
| `src/base/cobol_src/ABNDPROC.cbl` | 22 |  |  | 2 | 24 |
| `src/base/cobol_src/BNK1CCS.cbl` | 1 | 1 | 4 | 6 | 12 |
| `src/base/cobol_src/BANKDATA.cbl` |  |  | 6 | 5 | 11 |
| `src/base/cobol_src/BNK1DCS.cbl` |  |  | 3 | 6 | 9 |
| `src/base/cobol_src/CREACC.cbl` |  |  | 7 | 2 | 9 |
| `src/base/cobol_src/BNK1UAC.cbl` | 3 |  | 1 | 4 | 8 |
| `src/base/cobol_src/XFRFUN.cbl` |  |  | 5 | 3 | 8 |
| `src/base/cobol_src/DBCRFUN.cbl` |  |  | 3 | 3 | 6 |
| `src/base/cobol_src/DELACC.cbl` | 1 |  | 3 | 2 | 6 |
| `src/base/cobol_src/INQACC.cbl` | 1 |  | 2 | 3 | 6 |
| `src/base/cobol_src/INQACCCU.cbl` | 2 |  | 1 | 3 | 6 |
| `src/base/cobol_src/INQCUST.cbl` | 3 |  |  | 3 | 6 |
| `src/base/cobol_src/BNK1CAC.cbl` |  |  | 1 | 4 | 5 |
| `src/base/cobol_src/BNK1CCA.cbl` |  |  | 1 | 4 | 5 |
| `src/base/cobol_src/BNK1CRA.cbl` |  |  | 1 | 4 | 5 |
| `src/base/cobol_src/BNK1DAC.cbl` |  |  | 1 | 4 | 5 |
| `src/base/cobol_src/BNK1TFN.cbl` |  |  | 1 | 4 | 5 |
| `src/base/cobol_src/UPDACC.cbl` | 1 |  | 2 | 2 | 5 |
| `src/base/cobol_src/BNKMENU.cbl` |  |  |  | 4 | 4 |
| `src/base/cobol_src/CRDTAGY1.cbl` |  | 1 |  | 3 | 4 |
| `src/base/cobol_src/CRDTAGY2.cbl` |  | 1 |  | 3 | 4 |
| `src/base/cobol_src/CRDTAGY3.cbl` |  | 1 |  | 3 | 4 |
| `src/base/cobol_src/CRDTAGY4.cbl` |  | 1 |  | 3 | 4 |
| `src/base/cobol_src/CRDTAGY5.cbl` |  | 1 |  | 3 | 4 |
| `src/base/cobol_src/DELCUS.cbl` | 1 |  | 1 | 2 | 4 |
| `etc/install/base/installjcl/BANKDATA.jcl` |  | 1 |  | 2 | 3 |
| `src/base/cobol_src/CRECUST.cbl` |  |  | 1 | 2 | 3 |
| `src/base/cobol_src/CUSTCTRL.cbl` | 1 |  |  | 2 | 3 |
| `src/base/cobol_src/ACCTCTRL.cbl` |  |  | 1 | 1 | 2 |
| `src/base/cobol_src/GETCOMPY.cbl` |  |  |  | 2 | 2 |
| `src/base/cobol_src/GETSCODE.cbl` |  |  |  | 2 | 2 |
| `src/base/cobol_src/UPDCUST.cbl` |  |  |  | 2 | 2 |
| `(project configuration)` |  |  | 1 |  | 1 |

<a id="commarea-mismatch"></a>
## COMMAREA layout mismatches (conflict)

_Resolution:_ For each caller, confirm which layout the callee reads (the COBOL MOVEs into DFHCOMMAREA say); map that caller's record onto the DTO, or give the callee one DTO per entry.

**`src/base/cobol_src/ABNDPROC.cbl`**

- [ ] **WL-0001** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:13` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/XFRFUN.cbl, 681 bytes) at src/base/cobol_src/XFRFUN.cbl:364, src/base/cobol_src/XFRFUN.cbl:463, src/base/cobol_src/XFRFUN.cbl:573, src/base/cobol_src/XFRFUN.cbl:664, src/base/cobol_src/XFRFUN.cbl:737, src/base/cobol_src/XFRFUN.cbl:813, src/base/cobol_src/XFRFUN.cbl:881, src/base/cobol_src/XFRFUN.cbl:1165, src/base/cobol_src/XFRFUN.cbl:1262, src/base/cobol_src/XFRFUN.cbl:1341, src/base/cobol_src/XFRFUN.cbl:1459, src/base/cobol_src/XFRFUN.cbl:1541, src/base/cobol_src/XFRFUN.cbl:1701, src/base/cobol_src/XFRFUN.cbl:1873
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0002** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:14` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/BNK1DCS.cbl, 681 bytes) at src/base/cobol_src/BNK1DCS.cbl:381, src/base/cobol_src/BNK1DCS.cbl:579, src/base/cobol_src/BNK1DCS.cbl:654, src/base/cobol_src/BNK1DCS.cbl:888, src/base/cobol_src/BNK1DCS.cbl:1024, src/base/cobol_src/BNK1DCS.cbl:1210, src/base/cobol_src/BNK1DCS.cbl:1466, src/base/cobol_src/BNK1DCS.cbl:1543, src/base/cobol_src/BNK1DCS.cbl:1621, src/base/cobol_src/BNK1DCS.cbl:1723, src/base/cobol_src/BNK1DCS.cbl:1807, src/base/cobol_src/BNK1DCS.cbl:1888
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0003** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:15` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/BNK1CCS.cbl, 681 bytes) at src/base/cobol_src/BNK1CCS.cbl:331, src/base/cobol_src/BNK1CCS.cbl:462, src/base/cobol_src/BNK1CCS.cbl:557, src/base/cobol_src/BNK1CCS.cbl:1031, src/base/cobol_src/BNK1CCS.cbl:1181, src/base/cobol_src/BNK1CCS.cbl:1264, src/base/cobol_src/BNK1CCS.cbl:1342, src/base/cobol_src/BNK1CCS.cbl:1420, src/base/cobol_src/BNK1CCS.cbl:1498, src/base/cobol_src/BNK1CCS.cbl:1578
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0004** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:16` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/BNK1UAC.cbl, 681 bytes) at src/base/cobol_src/BNK1UAC.cbl:350, src/base/cobol_src/BNK1UAC.cbl:474, src/base/cobol_src/BNK1UAC.cbl:822, src/base/cobol_src/BNK1UAC.cbl:1009, src/base/cobol_src/BNK1UAC.cbl:1130, src/base/cobol_src/BNK1UAC.cbl:1206, src/base/cobol_src/BNK1UAC.cbl:1282, src/base/cobol_src/BNK1UAC.cbl:1361
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0005** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:17` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/BNK1CAC.cbl, 681 bytes) at src/base/cobol_src/BNK1CAC.cbl:309, src/base/cobol_src/BNK1CAC.cbl:416, src/base/cobol_src/BNK1CAC.cbl:834, src/base/cobol_src/BNK1CAC.cbl:1026, src/base/cobol_src/BNK1CAC.cbl:1102, src/base/cobol_src/BNK1CAC.cbl:1179, src/base/cobol_src/BNK1CAC.cbl:1257
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0006** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:18` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/BNK1CCA.cbl, 681 bytes) at src/base/cobol_src/BNK1CCA.cbl:280, src/base/cobol_src/BNK1CCA.cbl:389, src/base/cobol_src/BNK1CCA.cbl:490, src/base/cobol_src/BNK1CCA.cbl:677, src/base/cobol_src/BNK1CCA.cbl:752, src/base/cobol_src/BNK1CCA.cbl:830, src/base/cobol_src/BNK1CCA.cbl:909
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0007** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:19` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/BNK1CRA.cbl, 681 bytes) at src/base/cobol_src/BNK1CRA.cbl:318, src/base/cobol_src/BNK1CRA.cbl:425, src/base/cobol_src/BNK1CRA.cbl:566, src/base/cobol_src/BNK1CRA.cbl:704, src/base/cobol_src/BNK1CRA.cbl:778, src/base/cobol_src/BNK1CRA.cbl:853, src/base/cobol_src/BNK1CRA.cbl:931
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0008** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:20` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/BNK1DAC.cbl, 681 bytes) at src/base/cobol_src/BNK1DAC.cbl:350, src/base/cobol_src/BNK1DAC.cbl:481, src/base/cobol_src/BNK1DAC.cbl:608, src/base/cobol_src/BNK1DAC.cbl:882, src/base/cobol_src/BNK1DAC.cbl:961, src/base/cobol_src/BNK1DAC.cbl:1036, src/base/cobol_src/BNK1DAC.cbl:1115
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0009** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:21` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/BNK1TFN.cbl, 681 bytes) at src/base/cobol_src/BNK1TFN.cbl:302, src/base/cobol_src/BNK1TFN.cbl:411, src/base/cobol_src/BNK1TFN.cbl:551, src/base/cobol_src/BNK1TFN.cbl:727, src/base/cobol_src/BNK1TFN.cbl:801, src/base/cobol_src/BNK1TFN.cbl:876, src/base/cobol_src/BNK1TFN.cbl:954
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0010** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:22` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/INQACC.cbl, 681 bytes) at src/base/cobol_src/INQACC.cbl:321, src/base/cobol_src/INQACC.cbl:401, src/base/cobol_src/INQACC.cbl:516, src/base/cobol_src/INQACC.cbl:738, src/base/cobol_src/INQACC.cbl:810, src/base/cobol_src/INQACC.cbl:924
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0011** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:23` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/CREACC.cbl, 681 bytes) at src/base/cobol_src/CREACC.cbl:508, src/base/cobol_src/CREACC.cbl:586, src/base/cobol_src/CREACC.cbl:674, src/base/cobol_src/CREACC.cbl:751, src/base/cobol_src/CREACC.cbl:1055
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0012** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:24` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/INQACCCU.cbl, 681 bytes) at src/base/cobol_src/INQACCCU.cbl:321, src/base/cobol_src/INQACCCU.cbl:424, src/base/cobol_src/INQACCCU.cbl:563, src/base/cobol_src/INQACCCU.cbl:794
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0013** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:25` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/DELCUS.cbl, 681 bytes) at src/base/cobol_src/DELCUS.cbl:439, src/base/cobol_src/DELCUS.cbl:565, src/base/cobol_src/DELCUS.cbl:717
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0014** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:26` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/DBCRFUN.cbl, 681 bytes) at src/base/cobol_src/DBCRFUN.cbl:620, src/base/cobol_src/DBCRFUN.cbl:807
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0015** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:27` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/INQCUST.cbl, 681 bytes) at src/base/cobol_src/INQCUST.cbl:406, src/base/cobol_src/INQCUST.cbl:528
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0016** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:28` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/CRDTAGY1.cbl, 681 bytes) at src/base/cobol_src/CRDTAGY1.cbl:180
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0017** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:29` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/CRDTAGY2.cbl, 681 bytes) at src/base/cobol_src/CRDTAGY2.cbl:179
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0018** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:30` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/CRDTAGY3.cbl, 681 bytes) at src/base/cobol_src/CRDTAGY3.cbl:179
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0019** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:31` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/CRDTAGY4.cbl, 681 bytes) at src/base/cobol_src/CRDTAGY4.cbl:180
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0020** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:32` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/CRDTAGY5.cbl, 681 bytes) at src/base/cobol_src/CRDTAGY5.cbl:179
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0021** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:33` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/CRECUST.cbl, 681 bytes) at src/base/cobol_src/CRECUST.cbl:1250
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0022** `src/main/java/com/gitgalaxy/modernized/controller/AbndprocController.java:34` (`AbndprocController#link`): callers also pass ABNDINFO-REC (src/base/cobol_src/DELACC.cbl, 681 bytes) at src/base/cobol_src/DELACC.cbl:603
  - fact: `src/base/cobol_src/BNK1CAC.cbl:309`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:416`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:834`, CICS resources (open (5 public / 0 private estates))

**`src/base/cobol_src/BNK1CCS.cbl`**

- [ ] **WL-0023** `src/main/java/com/gitgalaxy/modernized/controller/Bnk1ccsController.java:13` (`Bnk1ccsController#transactionOCCS`): callers also pass WS-COMM-AREA (src/base/cobol_src/BNK1CCS.cbl, 5 bytes) at src/base/cobol_src/BNK1CCS.cbl:249, src/base/cobol_src/BNK1CCS.cbl:276
  - fact: `etc/install/base/installjcl/BANK.csd:435`, entry transactions (open (4 public / 0 private estates))

**`src/base/cobol_src/BNK1UAC.cbl`**

- [ ] **WL-0024** `src/main/java/com/gitgalaxy/modernized/controller/Bnk1uacController.java:13` (`Bnk1uacController#transactionOUAC`): WS-COMM-AREA (src/base/cobol_src/BNK1UAC.cbl, 99 bytes), passed at src/base/cobol_src/BNK1UAC.cbl:295, disagrees with this program's declared DFHCOMMAREA (103 bytes: 99 vs 103 bytes; fields first differ at None / COMM-PCB1-POINTER) -- confirm which layout the program reads
  - fact: `etc/install/base/installjcl/BANK.csd:495`, entry transactions (open (4 public / 0 private estates))
- [ ] **WL-0025** `src/main/java/com/gitgalaxy/modernized/service/Bnk1uacService.java:54` (`Bnk1uacService#linkInqacc`): this site passes DFHCOMMAREA; INQACC receives INQACC-COMMAREA (src/base/cobol_copy/INQACC.cpy) -- map one layout onto the other
  - fact: `src/base/cobol_src/BNK1UAC.cbl:767`, call targets (open (6 public / 0 private estates))
- [ ] **WL-0026** `src/main/java/com/gitgalaxy/modernized/service/Bnk1uacService.java:61` (`Bnk1uacService#linkUpdacc`): this site passes DFHCOMMAREA (103 bytes); UPDACC declares DFHCOMMAREA (src/base/cobol_src/UPDACC.cbl, 99 bytes) -- map one layout onto the other
  - fact: `src/base/cobol_src/BNK1UAC.cbl:954`, call targets (open (6 public / 0 private estates))

**`src/base/cobol_src/DELACC.cbl`**

- [ ] **WL-0027** `src/main/java/com/gitgalaxy/modernized/controller/DelaccController.java:13` (`DelaccController#link`): callers also pass DELACC-COMMAREA (src/base/cobol_src/DELCUS.cbl, 118 bytes) at src/base/cobol_src/DELCUS.cbl:312
  - fact: `src/base/cobol_src/BNK1DAC.cbl:712`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/DELCUS.cbl:312`, CICS resources (open (5 public / 0 private estates))

**`src/base/cobol_src/DELCUS.cbl`**

- [ ] **WL-0028** `src/main/java/com/gitgalaxy/modernized/service/DelcusService.java:57` (`DelcusService#linkDelacc`): this site passes DELACC-COMMAREA; DELACC receives PARMS-SUBPGM (src/base/cobol_src/BNK1DAC.cbl) -- map one layout onto the other
  - fact: `src/base/cobol_src/DELCUS.cbl:312`, call targets (open (6 public / 0 private estates))

**`src/base/cobol_src/INQACC.cbl`**

- [ ] **WL-0029** `src/main/java/com/gitgalaxy/modernized/controller/InqaccController.java:13` (`InqaccController#link`): callers also pass DFHCOMMAREA (src/base/cobol_src/BNK1UAC.cbl, 103 bytes) at src/base/cobol_src/BNK1UAC.cbl:767
  - fact: `src/base/cobol_src/BNK1DAC.cbl:553`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1UAC.cbl:767`, CICS resources (open (5 public / 0 private estates))

**`src/base/cobol_src/INQACCCU.cbl`**

- [ ] **WL-0030** `src/main/java/com/gitgalaxy/modernized/controller/InqacccuController.java:13` (`InqacccuController#link`): callers also pass INQACCCU-COMMAREA (src/base/cobol_src/CREACC.cbl, 1981 bytes) at src/base/cobol_src/CREACC.cbl:1088
  - fact: `src/base/cobol_src/BNK1CCA.cbl:435`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/CREACC.cbl:1088`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/DELCUS.cbl:334`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0031** `src/main/java/com/gitgalaxy/modernized/controller/InqacccuController.java:14` (`InqacccuController#link`): callers also pass INQACCCU-COMMAREA (src/base/cobol_src/DELCUS.cbl, 1981 bytes) at src/base/cobol_src/DELCUS.cbl:334
  - fact: `src/base/cobol_src/BNK1CCA.cbl:435`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/CREACC.cbl:1088`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/DELCUS.cbl:334`, CICS resources (open (5 public / 0 private estates))

**`src/base/cobol_src/INQCUST.cbl`**

- [ ] **WL-0032** `src/main/java/com/gitgalaxy/modernized/controller/InqcustController.java:13` (`InqcustController#link`): callers also pass INQCUST-COMMAREA (src/base/cobol_src/CREACC.cbl, 265 bytes) at src/base/cobol_src/CREACC.cbl:304
  - fact: `src/base/cobol_src/BNK1DCS.cbl:833`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/CREACC.cbl:304`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/DELCUS.cbl:260`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0033** `src/main/java/com/gitgalaxy/modernized/controller/InqcustController.java:14` (`InqcustController#link`): callers also pass INQCUST-COMMAREA (src/base/cobol_src/DELCUS.cbl, 265 bytes) at src/base/cobol_src/DELCUS.cbl:260
  - fact: `src/base/cobol_src/BNK1DCS.cbl:833`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/CREACC.cbl:304`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/DELCUS.cbl:260`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0034** `src/main/java/com/gitgalaxy/modernized/controller/InqcustController.java:15` (`InqcustController#link`): callers also pass INQCUST-COMMAREA (src/base/cobol_src/INQACCCU.cbl, 265 bytes) at src/base/cobol_src/INQACCCU.cbl:851
  - fact: `src/base/cobol_src/BNK1DCS.cbl:833`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/CREACC.cbl:304`, CICS resources (open (5 public / 0 private estates))
  - fact: `src/base/cobol_src/DELCUS.cbl:260`, CICS resources (open (5 public / 0 private estates))

**`src/base/cobol_src/UPDACC.cbl`**

- [ ] **WL-0035** `src/main/java/com/gitgalaxy/modernized/controller/UpdaccController.java:13` (`UpdaccController#link`): DFHCOMMAREA (src/base/cobol_src/BNK1UAC.cbl, 103 bytes), passed at src/base/cobol_src/BNK1UAC.cbl:954, disagrees with this program's declared DFHCOMMAREA (99 bytes: 103 vs 99 bytes; fields first differ at COMM-PCB1-POINTER / None) -- confirm which layout the program reads
  - fact: `src/base/cobol_src/BNK1UAC.cbl:954`, CICS resources (open (5 public / 0 private estates))

<a id="record-variant"></a>
## Programs reading another record layout (conflict)

_Resolution:_ Map the program's record onto the entity's fields (or split the entity); the two layouts' sizes are in the TODO.

**`src/base/cobol_src/CUSTCTRL.cbl`**

- [ ] **WL-0036** `src/main/java/com/gitgalaxy/modernized/service/CustctrlService.java:42` (`CustctrlService#readCustomer`): this program uses DFHCOMMAREA (259 bytes); the entity follows OUTPUT-DATA (259 bytes) -- map one onto the other
  - fact: `src/base/cobol_src/CUSTCTRL.cbl:162`, VSAM defines (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/CUSTCTRL.cbl:178`, VSAM defines (open (3 public / 0 private estates))

<a id="missing-layout"></a>
## Unresolved layouts (fact-gap)

_Resolution:_ Add the missing copybook / %INCLUDE member or record to the repository and re-run; the DTO then gets its real fields.

**`src/base/cobol_src/BNK1CCS.cbl`**

- [ ] **WL-0037** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:33`: SEND MAP BNK1CCM (mapset BNK1CCM) at src/base/cobol_src/BNK1CCS.cbl:236: no single BMS source defines it (candidates: none in the repository); mapset BNK1CCM defines BNK1CC

**`src/base/cobol_src/CRDTAGY1.cbl`**

- [ ] **WL-0038** `src/main/java/com/gitgalaxy/modernized/controller/Crdtagy1Controller.java` (`Crdtagy1Controller#transactionOCR1`): no COMMAREA layout: no LINKAGE DFHCOMMAREA, and no resolved caller passes this program a COMMAREA
  - fact: `etc/install/base/installjcl/BANK.csd:345`, entry transactions (open (4 public / 0 private estates))

**`src/base/cobol_src/CRDTAGY2.cbl`**

- [ ] **WL-0039** `src/main/java/com/gitgalaxy/modernized/controller/Crdtagy2Controller.java` (`Crdtagy2Controller#transactionOCR2`): no COMMAREA layout: no LINKAGE DFHCOMMAREA, and no resolved caller passes this program a COMMAREA
  - fact: `etc/install/base/installjcl/BANK.csd:355`, entry transactions (open (4 public / 0 private estates))

**`src/base/cobol_src/CRDTAGY3.cbl`**

- [ ] **WL-0040** `src/main/java/com/gitgalaxy/modernized/controller/Crdtagy3Controller.java` (`Crdtagy3Controller#transactionOCR3`): no COMMAREA layout: no LINKAGE DFHCOMMAREA, and no resolved caller passes this program a COMMAREA
  - fact: `etc/install/base/installjcl/BANK.csd:365`, entry transactions (open (4 public / 0 private estates))

**`src/base/cobol_src/CRDTAGY4.cbl`**

- [ ] **WL-0041** `src/main/java/com/gitgalaxy/modernized/controller/Crdtagy4Controller.java` (`Crdtagy4Controller#transactionOCR4`): no COMMAREA layout: no LINKAGE DFHCOMMAREA, and no resolved caller passes this program a COMMAREA
  - fact: `etc/install/base/installjcl/BANK.csd:375`, entry transactions (open (4 public / 0 private estates))

**`src/base/cobol_src/CRDTAGY5.cbl`**

- [ ] **WL-0042** `src/main/java/com/gitgalaxy/modernized/controller/Crdtagy5Controller.java` (`Crdtagy5Controller#transactionOCR5`): no COMMAREA layout: no LINKAGE DFHCOMMAREA, and no resolved caller passes this program a COMMAREA
  - fact: `etc/install/base/installjcl/BANK.csd:385`, entry transactions (open (4 public / 0 private estates))

<a id="vsam-key"></a>
## Keys that are not one field (fact-gap)

_Resolution:_ Name the key: split the record so the key is one field, or keep the String vsamKey in step with the record; for a browse, add a range query over the key.

**`etc/install/base/installjcl/BANKDATA.jcl`**

- [ ] **WL-0043** `src/main/java/com/gitgalaxy/modernized/repository/vsam/OutputDataRepository.java:19`: start from a key -- a range over an @EmbeddedId is not a derived query

<a id="batch-utility"></a>
## Utility job steps to port (port)

_Resolution:_ Replace the utility with its Spring Batch equivalent (SORT -> a sorting step, IDCAMS REPRO -> a copy, a TSO / IMS runner -> the program's runBatch), reading its control statements in SYSIN.

**`etc/install/base/installjcl/BANKDATA.jcl`**

- [ ] **WL-0044** `src/main/java/com/gitgalaxy/modernized/batch/BankdataJobConfig.java` (`BankdataJobConfig#BANKDAT0`): BANKDAT0 runs the utility IDCAMS (its control statements are in SYSIN) -- a utility step to port
  - fact: `etc/install/base/installjcl/BANKDATA.jcl:36`, JCL job flow (open (5 public / 0 private estates))
- [ ] **WL-0045** `src/main/java/com/gitgalaxy/modernized/batch/BankdataJobConfig.java` (`BankdataJobConfig#BANKDAT1`): BANKDAT1 runs the utility IDCAMS (its control statements are in SYSIN) -- a utility step to port
  - fact: `etc/install/base/installjcl/BANKDATA.jcl:56`, JCL job flow (open (5 public / 0 private estates))

<a id="unchecked-resp"></a>
## CICS responses the COBOL never tests (review)

_Resolution:_ Decide what a failed call does: the COBOL ignores it, so the Java throws; catch it where the old behaviour (carry on) is really wanted.

**`src/base/cobol_src/BNK1CAC.cbl`**

- [ ] **WL-0046** `src/main/java/com/gitgalaxy/modernized/service/Bnk1cacService.java:25` (`Bnk1cacService`): the RESP of RETURN at line 186 (paragraph A010) is never tested
  - fact: `src/base/cobol_src/BNK1CAC.cbl:186`, units of work and handlers (field-tested (6 public / 0 private estates))

**`src/base/cobol_src/BNK1CCA.cbl`**

- [ ] **WL-0047** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccaService.java:25` (`Bnk1ccaService`): the RESP of RETURN at line 178 (paragraph A010) is never tested
  - fact: `src/base/cobol_src/BNK1CCA.cbl:178`, units of work and handlers (field-tested (6 public / 0 private estates))

**`src/base/cobol_src/BNK1CCS.cbl`**

- [ ] **WL-0048** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:28` (`Bnk1ccsService`): the RESP of RETURN at line 208 (paragraph A010) is never tested
  - fact: `src/base/cobol_src/BNK1CCS.cbl:208`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0049** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:29` (`Bnk1ccsService`): the RESP of INQUIRE at line 392 (paragraph RM010) is never tested
  - fact: `src/base/cobol_src/BNK1CCS.cbl:392`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0050** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:30` (`Bnk1ccsService`): the RESP of INQUIRE at line 1105 (paragraph STD010) is never tested
  - fact: `src/base/cobol_src/BNK1CCS.cbl:1105`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0051** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:31` (`Bnk1ccsService`): the RESP of SET at line 1605 (paragraph ATT010) is never tested
  - fact: `src/base/cobol_src/BNK1CCS.cbl:1605`, units of work and handlers (field-tested (6 public / 0 private estates))

**`src/base/cobol_src/BNK1CRA.cbl`**

- [ ] **WL-0052** `src/main/java/com/gitgalaxy/modernized/service/Bnk1craService.java:25` (`Bnk1craService`): the RESP of RETURN at line 201 (paragraph A010) is never tested
  - fact: `src/base/cobol_src/BNK1CRA.cbl:201`, units of work and handlers (field-tested (6 public / 0 private estates))

**`src/base/cobol_src/BNK1DAC.cbl`**

- [ ] **WL-0053** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dacService.java:27` (`Bnk1dacService`): the RESP of RETURN at line 213 (paragraph A010) is never tested
  - fact: `src/base/cobol_src/BNK1DAC.cbl:213`, units of work and handlers (field-tested (6 public / 0 private estates))

**`src/base/cobol_src/BNK1DCS.cbl`**

- [ ] **WL-0054** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dcsService.java:32` (`Bnk1dcsService`): the RESP of RETURN at line 233 (paragraph A010) is never tested
  - fact: `src/base/cobol_src/BNK1DCS.cbl:233`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0055** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dcsService.java:33` (`Bnk1dcsService`): the RESP of INQUIRE at line 509 (paragraph RM010) is never tested
  - fact: `src/base/cobol_src/BNK1DCS.cbl:509`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0056** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dcsService.java:34` (`Bnk1dcsService`): the RESP of INQUIRE at line 1648 (paragraph STD010) is never tested
  - fact: `src/base/cobol_src/BNK1DCS.cbl:1648`, units of work and handlers (field-tested (6 public / 0 private estates))

**`src/base/cobol_src/BNK1TFN.cbl`**

- [ ] **WL-0057** `src/main/java/com/gitgalaxy/modernized/service/Bnk1tfnService.java:25` (`Bnk1tfnService`): the RESP of RETURN at line 198 (paragraph A010) is never tested
  - fact: `src/base/cobol_src/BNK1TFN.cbl:198`, units of work and handlers (field-tested (6 public / 0 private estates))

**`src/base/cobol_src/BNK1UAC.cbl`**

- [ ] **WL-0058** `src/main/java/com/gitgalaxy/modernized/service/Bnk1uacService.java:27` (`Bnk1uacService`): the RESP of RETURN at line 222 (paragraph A010) is never tested
  - fact: `src/base/cobol_src/BNK1UAC.cbl:222`, units of work and handlers (field-tested (6 public / 0 private estates))

**`src/base/cobol_src/CREACC.cbl`**

- [ ] **WL-0059** `src/main/java/com/gitgalaxy/modernized/service/CreaccService.java:23` (`CreaccService`): the RESP of LINK at line 1088 (paragraph CAC010) is never tested
  - fact: `src/base/cobol_src/CREACC.cbl:1088`, units of work and handlers (field-tested (6 public / 0 private estates))

<a id="db2-dialect"></a>
## DB2 SQL on another database (review)

_Resolution:_ Run each statement on the target database; DB2-only syntax (FETCH FIRST, WITH UR, special registers) needs its equivalent.

**`src/base/cobol_src/ACCTCTRL.cbl`**

- [ ] **WL-0060** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#selectL165Acctctrl`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/ACCTCTRL.cbl:165`, DB2 table access (open (3 public / 0 private estates))

**`src/base/cobol_src/BANKDATA.cbl`**

- [ ] **WL-0061** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#deleteL1192Bankdata`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/BANKDATA.cbl:1192`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0062** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#insertL808Bankdata`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/BANKDATA.cbl:808`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0063** `src/main/java/com/gitgalaxy/modernized/repository/db2/ControlRepository.java` (`ControlRepository#deleteL1256Bankdata`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/BANKDATA.cbl:1256`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0064** `src/main/java/com/gitgalaxy/modernized/repository/db2/ControlRepository.java` (`ControlRepository#deleteL1322Bankdata`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/BANKDATA.cbl:1322`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0065** `src/main/java/com/gitgalaxy/modernized/repository/db2/ControlRepository.java` (`ControlRepository#insertL613Bankdata`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/BANKDATA.cbl:613`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0066** `src/main/java/com/gitgalaxy/modernized/repository/db2/ControlRepository.java` (`ControlRepository#insertL642Bankdata`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/BANKDATA.cbl:642`, DB2 table access (open (3 public / 0 private estates))

**`src/base/cobol_src/CREACC.cbl`**

- [ ] **WL-0067** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#insertL826Creacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/CREACC.cbl:826`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0068** `src/main/java/com/gitgalaxy/modernized/repository/db2/ControlRepository.java` (`ControlRepository#selectL444Creacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/CREACC.cbl:444`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0069** `src/main/java/com/gitgalaxy/modernized/repository/db2/ControlRepository.java` (`ControlRepository#selectL611Creacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/CREACC.cbl:611`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0070** `src/main/java/com/gitgalaxy/modernized/repository/db2/ControlRepository.java` (`ControlRepository#updateL529Creacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/CREACC.cbl:529`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0071** `src/main/java/com/gitgalaxy/modernized/repository/db2/ControlRepository.java` (`ControlRepository#updateL694Creacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/CREACC.cbl:694`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0072** `src/main/java/com/gitgalaxy/modernized/repository/db2/ProctranRepository.java` (`ProctranRepository#insertL969Creacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/CREACC.cbl:969`, DB2 table access (open (3 public / 0 private estates))

**`src/base/cobol_src/CRECUST.cbl`**

- [ ] **WL-0073** `src/main/java/com/gitgalaxy/modernized/repository/db2/ProctranRepository.java` (`ProctranRepository#insertL1168Crecust`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/CRECUST.cbl:1168`, DB2 table access (open (3 public / 0 private estates))

**`src/base/cobol_src/DBCRFUN.cbl`**

- [ ] **WL-0074** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#selectL245Dbcrfun`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/DBCRFUN.cbl:245`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0075** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#updateL392Dbcrfun`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/DBCRFUN.cbl:392`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0076** `src/main/java/com/gitgalaxy/modernized/repository/db2/ProctranRepository.java` (`ProctranRepository#insertL524Dbcrfun`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/DBCRFUN.cbl:524`, DB2 table access (open (3 public / 0 private estates))

**`src/base/cobol_src/DELACC.cbl`**

- [ ] **WL-0077** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#deleteL438Delacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/DELACC.cbl:438`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0078** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#selectL248Delacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/DELACC.cbl:248`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0079** `src/main/java/com/gitgalaxy/modernized/repository/db2/ProctranRepository.java` (`ProctranRepository#insertL521Delacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/DELACC.cbl:521`, DB2 table access (open (3 public / 0 private estates))

**`src/base/cobol_src/DELCUS.cbl`**

- [ ] **WL-0080** `src/main/java/com/gitgalaxy/modernized/repository/db2/ProctranRepository.java` (`ProctranRepository#insertL636Delcus`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/DELCUS.cbl:636`, DB2 table access (open (3 public / 0 private estates))

**`src/base/cobol_src/INQACC.cbl`**

- [ ] **WL-0081** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#cursorAccCursorL66Inqacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/INQACC.cbl:66`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0082** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#selectL843Inqacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/INQACC.cbl:843`, DB2 table access (open (3 public / 0 private estates))

**`src/base/cobol_src/INQACCCU.cbl`**

- [ ] **WL-0083** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#cursorAccCursorL74Inqacccu`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/INQACCCU.cbl:74`, DB2 table access (open (3 public / 0 private estates))

**`src/base/cobol_src/UPDACC.cbl`**

- [ ] **WL-0084** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#selectL191Updacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/UPDACC.cbl:191`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0085** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#updateL278Updacc`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/UPDACC.cbl:278`, DB2 table access (open (3 public / 0 private estates))

**`src/base/cobol_src/XFRFUN.cbl`**

- [ ] **WL-0086** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#selectL1057Xfrfun`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/XFRFUN.cbl:1057`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0087** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#selectL930Xfrfun`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/XFRFUN.cbl:930`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0088** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#updateL1362Xfrfun`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/XFRFUN.cbl:1362`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0089** `src/main/java/com/gitgalaxy/modernized/repository/db2/AccountRepository.java` (`AccountRepository#updateL992Xfrfun`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/XFRFUN.cbl:992`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0090** `src/main/java/com/gitgalaxy/modernized/repository/db2/ProctranRepository.java` (`ProctranRepository#insertL1616Xfrfun`): DB2 SQL on postgresql -- review the statement
  - fact: `src/base/cobol_src/XFRFUN.cbl:1616`, DB2 table access (open (3 public / 0 private estates))

<a id="transaction-split"></a>
## Unit-of-work boundaries to split (port)

_Resolution:_ End the transaction at the SYNCPOINT the comment cites: a nested REQUIRES_NEW call, or two service methods.

**`src/base/cobol_src/BANKDATA.cbl`**

- [ ] **WL-0091** `src/main/java/com/gitgalaxy/modernized/service/BankdataService.java:35`: split the transaction here
- [ ] **WL-0092** `src/main/java/com/gitgalaxy/modernized/service/BankdataService.java:45`: split the transaction here
- [ ] **WL-0093** `src/main/java/com/gitgalaxy/modernized/service/BankdataService.java:55`: split the transaction here

<a id="business-logic"></a>
## Business logic to port (port)

_Resolution:_ Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch.

**`src/base/cobol_src/ABNDPROC.cbl`**

- [ ] **WL-0094** `src/main/java/com/gitgalaxy/modernized/service/AbndprocService.java:31`: Implement extracted business rules here
- [ ] **WL-0095** `src/main/java/com/gitgalaxy/modernized/service/AbndprocService.java:34`: implement from the program's business rules

**`src/base/cobol_src/ACCTCTRL.cbl`**

- [ ] **WL-0096** `src/main/java/com/gitgalaxy/modernized/service/AcctctrlService.java:19`: Implement extracted business rules here

**`src/base/cobol_src/BANKDATA.cbl`**

- [ ] **WL-0097** `src/main/java/com/gitgalaxy/modernized/service/BankdataService.java:25`: Implement extracted business rules here
- [ ] **WL-0098** `src/main/java/com/gitgalaxy/modernized/service/BankdataService.java:62` (`BankdataService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `etc/install/base/installjcl/BANKDATA.jcl:94`, JCL job flow (open (5 public / 0 private estates))

**`src/base/cobol_src/BNK1CAC.cbl`**

- [ ] **WL-0099** `src/main/java/com/gitgalaxy/modernized/service/Bnk1cacService.java:40`: Implement extracted business rules here
- [ ] **WL-0100** `src/main/java/com/gitgalaxy/modernized/service/Bnk1cacService.java:43`: implement from the program's business rules
- [ ] **WL-0101** `src/main/java/com/gitgalaxy/modernized/service/Bnk1cacService.java:142` (`Bnk1cacService#renderBnk1ca`): port the logic that fills BNK1CAO before the SEND
  - fact: `src/base/cobol_src/BNK1CAC.cbl:966`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:1040`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CAC.cbl:1117`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0102** `src/main/java/com/gitgalaxy/modernized/service/Bnk1cacService.java:150` (`Bnk1cacService#submitBnk1ca`): port the logic that reads BNK1CAI after the RECEIVE
  - fact: `src/base/cobol_src/BNK1CAC.cbl:356`, BMS screen fields (open (3 public / 0 private estates))

**`src/base/cobol_src/BNK1CCA.cbl`**

- [ ] **WL-0103** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccaService.java:40`: Implement extracted business rules here
- [ ] **WL-0104** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccaService.java:43`: implement from the program's business rules
- [ ] **WL-0105** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccaService.java:147` (`Bnk1ccaService#renderBnk1acc`): port the logic that fills BNK1ACCO before the SEND
  - fact: `src/base/cobol_src/BNK1CCA.cbl:622`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CCA.cbl:696`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CCA.cbl:772`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0106** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccaService.java:155` (`Bnk1ccaService#submitBnk1acc`): port the logic that reads BNK1ACCI after the RECEIVE
  - fact: `src/base/cobol_src/BNK1CCA.cbl:333`, BMS screen fields (open (3 public / 0 private estates))

**`src/base/cobol_src/BNK1CCS.cbl`**

- [ ] **WL-0107** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:47`: Implement extracted business rules here
- [ ] **WL-0108** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:50`: implement from the program's business rules
- [ ] **WL-0109** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:178`: port paragraph HANDLE-ABEND's logic
- [ ] **WL-0110** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:196`: port paragraph None's logic
- [ ] **WL-0111** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:209` (`Bnk1ccsService#renderBnk1cc`): port the logic that fills BNK1CCO before the SEND
  - fact: `src/base/cobol_src/BNK1CCS.cbl:1286`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CCS.cbl:1364`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CCS.cbl:1441`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0112** `src/main/java/com/gitgalaxy/modernized/service/Bnk1ccsService.java:217` (`Bnk1ccsService#submitBnk1cc`): port the logic that reads BNK1CCI after the RECEIVE
  - fact: `src/base/cobol_src/BNK1CCS.cbl:500`, BMS screen fields (open (3 public / 0 private estates))

**`src/base/cobol_src/BNK1CRA.cbl`**

- [ ] **WL-0113** `src/main/java/com/gitgalaxy/modernized/service/Bnk1craService.java:40`: Implement extracted business rules here
- [ ] **WL-0114** `src/main/java/com/gitgalaxy/modernized/service/Bnk1craService.java:43`: implement from the program's business rules
- [ ] **WL-0115** `src/main/java/com/gitgalaxy/modernized/service/Bnk1craService.java:142` (`Bnk1craService#renderBnk1cd`): port the logic that fills BNK1CDO before the SEND
  - fact: `src/base/cobol_src/BNK1CRA.cbl:649`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CRA.cbl:723`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1CRA.cbl:797`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0116** `src/main/java/com/gitgalaxy/modernized/service/Bnk1craService.java:150` (`Bnk1craService#submitBnk1cd`): port the logic that reads BNK1CDI after the RECEIVE
  - fact: `src/base/cobol_src/BNK1CRA.cbl:370`, BMS screen fields (open (3 public / 0 private estates))

**`src/base/cobol_src/BNK1DAC.cbl`**

- [ ] **WL-0117** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dacService.java:43`: Implement extracted business rules here
- [ ] **WL-0118** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dacService.java:46`: implement from the program's business rules
- [ ] **WL-0119** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dacService.java:151` (`Bnk1dacService#renderBnk1da`): port the logic that fills BNK1DAO before the SEND
  - fact: `src/base/cobol_src/BNK1DAC.cbl:827`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1DAC.cbl:906`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1DAC.cbl:980`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0120** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dacService.java:159` (`Bnk1dacService#submitBnk1da`): port the logic that reads BNK1DAI after the RECEIVE
  - fact: `src/base/cobol_src/BNK1DAC.cbl:426`, BMS screen fields (open (3 public / 0 private estates))

**`src/base/cobol_src/BNK1DCS.cbl`**

- [ ] **WL-0121** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dcsService.java:51`: Implement extracted business rules here
- [ ] **WL-0122** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dcsService.java:54`: implement from the program's business rules
- [ ] **WL-0123** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dcsService.java:216`: port paragraph ABEND-HANDLING's logic
- [ ] **WL-0124** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dcsService.java:234`: port paragraph None's logic
- [ ] **WL-0125** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dcsService.java:238` (`Bnk1dcsService#renderBnk1dc`): port the logic that fills BNK1DCO before the SEND
  - fact: `src/base/cobol_src/BNK1DCS.cbl:1410`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1DCS.cbl:1487`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1DCS.cbl:1564`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0126** `src/main/java/com/gitgalaxy/modernized/service/Bnk1dcsService.java:246` (`Bnk1dcsService#submitBnk1dc`): port the logic that reads BNK1DCI after the RECEIVE
  - fact: `src/base/cobol_src/BNK1DCS.cbl:597`, BMS screen fields (open (3 public / 0 private estates))

**`src/base/cobol_src/BNK1TFN.cbl`**

- [ ] **WL-0127** `src/main/java/com/gitgalaxy/modernized/service/Bnk1tfnService.java:40`: Implement extracted business rules here
- [ ] **WL-0128** `src/main/java/com/gitgalaxy/modernized/service/Bnk1tfnService.java:43`: implement from the program's business rules
- [ ] **WL-0129** `src/main/java/com/gitgalaxy/modernized/service/Bnk1tfnService.java:142` (`Bnk1tfnService#renderBnk1tf`): port the logic that fills BNK1TFO before the SEND
  - fact: `src/base/cobol_src/BNK1TFN.cbl:672`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1TFN.cbl:746`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1TFN.cbl:820`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0130** `src/main/java/com/gitgalaxy/modernized/service/Bnk1tfnService.java:150` (`Bnk1tfnService#submitBnk1tf`): port the logic that reads BNK1TFI after the RECEIVE
  - fact: `src/base/cobol_src/BNK1TFN.cbl:356`, BMS screen fields (open (3 public / 0 private estates))

**`src/base/cobol_src/BNK1UAC.cbl`**

- [ ] **WL-0131** `src/main/java/com/gitgalaxy/modernized/service/Bnk1uacService.java:43`: Implement extracted business rules here
- [ ] **WL-0132** `src/main/java/com/gitgalaxy/modernized/service/Bnk1uacService.java:46`: implement from the program's business rules
- [ ] **WL-0133** `src/main/java/com/gitgalaxy/modernized/service/Bnk1uacService.java:164` (`Bnk1uacService#renderBnk1ua`): port the logic that fills BNK1UAO before the SEND
  - fact: `src/base/cobol_src/BNK1UAC.cbl:1074`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1UAC.cbl:1150`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNK1UAC.cbl:1225`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0134** `src/main/java/com/gitgalaxy/modernized/service/Bnk1uacService.java:172` (`Bnk1uacService#submitBnk1ua`): port the logic that reads BNK1UAI after the RECEIVE
  - fact: `src/base/cobol_src/BNK1UAC.cbl:419`, BMS screen fields (open (3 public / 0 private estates))

**`src/base/cobol_src/BNKMENU.cbl`**

- [ ] **WL-0135** `src/main/java/com/gitgalaxy/modernized/service/BnkmenuService.java:44`: Implement extracted business rules here
- [ ] **WL-0136** `src/main/java/com/gitgalaxy/modernized/service/BnkmenuService.java:47`: implement from the program's business rules
- [ ] **WL-0137** `src/main/java/com/gitgalaxy/modernized/service/BnkmenuService.java:217` (`BnkmenuService#renderBnk1me`): port the logic that fills BNK1MEO before the SEND
  - fact: `src/base/cobol_src/BNKMENU.cbl:979`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNKMENU.cbl:1053`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `src/base/cobol_src/BNKMENU.cbl:1129`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0138** `src/main/java/com/gitgalaxy/modernized/service/BnkmenuService.java:225` (`BnkmenuService#submitBnk1me`): port the logic that reads BNK1MEI after the RECEIVE
  - fact: `src/base/cobol_src/BNKMENU.cbl:274`, BMS screen fields (open (3 public / 0 private estates))

**`src/base/cobol_src/CRDTAGY1.cbl`**

- [ ] **WL-0139** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy1Service.java:31`: Implement extracted business rules here
- [ ] **WL-0140** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy1Service.java:34`: implement from the program's business rules
- [ ] **WL-0141** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy1Service.java:37`: build the response

**`src/base/cobol_src/CRDTAGY2.cbl`**

- [ ] **WL-0142** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy2Service.java:31`: Implement extracted business rules here
- [ ] **WL-0143** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy2Service.java:34`: implement from the program's business rules
- [ ] **WL-0144** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy2Service.java:37`: build the response

**`src/base/cobol_src/CRDTAGY3.cbl`**

- [ ] **WL-0145** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy3Service.java:31`: Implement extracted business rules here
- [ ] **WL-0146** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy3Service.java:34`: implement from the program's business rules
- [ ] **WL-0147** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy3Service.java:37`: build the response

**`src/base/cobol_src/CRDTAGY4.cbl`**

- [ ] **WL-0148** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy4Service.java:31`: Implement extracted business rules here
- [ ] **WL-0149** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy4Service.java:34`: implement from the program's business rules
- [ ] **WL-0150** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy4Service.java:37`: build the response

**`src/base/cobol_src/CRDTAGY5.cbl`**

- [ ] **WL-0151** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy5Service.java:31`: Implement extracted business rules here
- [ ] **WL-0152** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy5Service.java:34`: implement from the program's business rules
- [ ] **WL-0153** `src/main/java/com/gitgalaxy/modernized/service/Crdtagy5Service.java:37`: build the response

**`src/base/cobol_src/CREACC.cbl`**

- [ ] **WL-0154** `src/main/java/com/gitgalaxy/modernized/service/CreaccService.java:41`: Implement extracted business rules here
- [ ] **WL-0155** `src/main/java/com/gitgalaxy/modernized/service/CreaccService.java:44`: implement from the program's business rules

**`src/base/cobol_src/CRECUST.cbl`**

- [ ] **WL-0156** `src/main/java/com/gitgalaxy/modernized/service/CrecustService.java:48`: Implement extracted business rules here
- [ ] **WL-0157** `src/main/java/com/gitgalaxy/modernized/service/CrecustService.java:51`: implement from the program's business rules

**`src/base/cobol_src/CUSTCTRL.cbl`**

- [ ] **WL-0158** `src/main/java/com/gitgalaxy/modernized/service/CustctrlService.java:32`: Implement extracted business rules here
- [ ] **WL-0159** `src/main/java/com/gitgalaxy/modernized/service/CustctrlService.java:35`: implement from the program's business rules

**`src/base/cobol_src/DBCRFUN.cbl`**

- [ ] **WL-0160** `src/main/java/com/gitgalaxy/modernized/service/DbcrfunService.java:33`: Implement extracted business rules here
- [ ] **WL-0161** `src/main/java/com/gitgalaxy/modernized/service/DbcrfunService.java:36`: implement from the program's business rules
- [ ] **WL-0162** `src/main/java/com/gitgalaxy/modernized/service/DbcrfunService.java:86`: port paragraph ABEND-HANDLING's logic

**`src/base/cobol_src/DELACC.cbl`**

- [ ] **WL-0163** `src/main/java/com/gitgalaxy/modernized/service/DelaccService.java:28`: Implement extracted business rules here
- [ ] **WL-0164** `src/main/java/com/gitgalaxy/modernized/service/DelaccService.java:31`: implement from the program's business rules

**`src/base/cobol_src/DELCUS.cbl`**

- [ ] **WL-0165** `src/main/java/com/gitgalaxy/modernized/service/DelcusService.java:46`: Implement extracted business rules here
- [ ] **WL-0166** `src/main/java/com/gitgalaxy/modernized/service/DelcusService.java:49`: implement from the program's business rules

**`src/base/cobol_src/GETCOMPY.cbl`**

- [ ] **WL-0167** `src/main/java/com/gitgalaxy/modernized/service/GetcompyService.java:17`: Implement extracted business rules here
- [ ] **WL-0168** `src/main/java/com/gitgalaxy/modernized/service/GetcompyService.java:20`: implement from the program's business rules

**`src/base/cobol_src/GETSCODE.cbl`**

- [ ] **WL-0169** `src/main/java/com/gitgalaxy/modernized/service/GetscodeService.java:17`: Implement extracted business rules here
- [ ] **WL-0170** `src/main/java/com/gitgalaxy/modernized/service/GetscodeService.java:20`: implement from the program's business rules

**`src/base/cobol_src/INQACC.cbl`**

- [ ] **WL-0171** `src/main/java/com/gitgalaxy/modernized/service/InqaccService.java:30`: Implement extracted business rules here
- [ ] **WL-0172** `src/main/java/com/gitgalaxy/modernized/service/InqaccService.java:33`: implement from the program's business rules
- [ ] **WL-0173** `src/main/java/com/gitgalaxy/modernized/service/InqaccService.java:119`: port paragraph ABEND-HANDLING's logic

**`src/base/cobol_src/INQACCCU.cbl`**

- [ ] **WL-0174** `src/main/java/com/gitgalaxy/modernized/service/InqacccuService.java:35`: Implement extracted business rules here
- [ ] **WL-0175** `src/main/java/com/gitgalaxy/modernized/service/InqacccuService.java:38`: implement from the program's business rules
- [ ] **WL-0176** `src/main/java/com/gitgalaxy/modernized/service/InqacccuService.java:132`: port paragraph ABEND-HANDLING's logic

**`src/base/cobol_src/INQCUST.cbl`**

- [ ] **WL-0177** `src/main/java/com/gitgalaxy/modernized/service/InqcustService.java:43`: Implement extracted business rules here
- [ ] **WL-0178** `src/main/java/com/gitgalaxy/modernized/service/InqcustService.java:46`: implement from the program's business rules
- [ ] **WL-0179** `src/main/java/com/gitgalaxy/modernized/service/InqcustService.java:93`: port paragraph ABEND-HANDLING's logic

**`src/base/cobol_src/UPDACC.cbl`**

- [ ] **WL-0180** `src/main/java/com/gitgalaxy/modernized/service/UpdaccService.java:22`: Implement extracted business rules here
- [ ] **WL-0181** `src/main/java/com/gitgalaxy/modernized/service/UpdaccService.java:25`: implement from the program's business rules

**`src/base/cobol_src/UPDCUST.cbl`**

- [ ] **WL-0182** `src/main/java/com/gitgalaxy/modernized/service/UpdcustService.java:32`: Implement extracted business rules here
- [ ] **WL-0183** `src/main/java/com/gitgalaxy/modernized/service/UpdcustService.java:35`: implement from the program's business rules

**`src/base/cobol_src/XFRFUN.cbl`**

- [ ] **WL-0184** `src/main/java/com/gitgalaxy/modernized/service/XfrfunService.java:39`: Implement extracted business rules here
- [ ] **WL-0185** `src/main/java/com/gitgalaxy/modernized/service/XfrfunService.java:42`: implement from the program's business rules
- [ ] **WL-0186** `src/main/java/com/gitgalaxy/modernized/service/XfrfunService.java:272`: port paragraph ABEND-HANDLING's logic

<a id="configuration"></a>
## Target configuration (review)

_Resolution:_ Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file.

**`(project configuration)`**

- [ ] **WL-0187** `src/main/resources/application.yml:9`: Update these credentials for your target environment
