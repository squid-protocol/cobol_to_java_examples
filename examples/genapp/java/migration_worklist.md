# Migration worklist

Every TODO the generators left in this project: where a fact was missing or two facts disagreed, the Java says so instead of guessing. Each item names the fact it rests on (from `traceability.json`) and a suggested resolution.

**362 items** across 31 program sources (COBOL, PL/I).

| nature | items | what it takes |
|---|---:|---|
| conflict | 72 | two facts disagree: a person decides which one the Java follows |
| fact-gap | 14 | a fact is missing: supply it and re-run |
| review | 185 | the Java runs as generated: check it on the target |
| port | 91 | business logic to write |

## By category

| category | nature | items | suggested resolution |
|---|---|---:|---|
| [COMMAREA layout mismatches](#commarea-mismatch) | conflict | 70 | For each caller, confirm which layout the callee reads (the COBOL MOVEs into DFHCOMMAREA say); map that caller's record onto the DTO, or give the callee one DTO per entry. |
| [Programs reading another record layout](#record-variant) | conflict | 2 | Map the program's record onto the entity's fields (or split the entity); the two layouts' sizes are in the TODO. |
| [Unresolved layouts](#missing-layout) | fact-gap | 5 | Add the missing copybook / %INCLUDE member or record to the repository and re-run; the DTO then gets its real fields. |
| [Data-driven queue names](#queue-name) | fact-gap | 9 | Resolve the name (the MOVEs into the operand, or the installation's symbol table) and pass it: the port takes any queue name. |
| [CICS responses the COBOL never tests](#unchecked-resp) | review | 150 | Decide what a failed call does: the COBOL ignores it, so the Java throws; catch it where the old behaviour (carry on) is really wanted. |
| [Positioned SQL (WHERE CURRENT OF)](#db2-positioned) | review | 1 | Rewrite the UPDATE / DELETE to the row's key: JDBC keeps no cursor position here. |
| [DB2 SQL on another database](#db2-dialect) | review | 33 | Run each statement on the target database; DB2-only syntax (FETCH FIRST, WITH UR, special registers) needs its equivalent. |
| [Business logic to port](#business-logic) | port | 91 | Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch. |
| [Target configuration](#configuration) | review | 1 | Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file. |

## By program source

| source | conflict | fact-gap | review | port | total |
|---|---:|---:|---:|---:|---:|
| `base/src/lgsetup.cbl` |  |  | 82 | 2 | 84 |
| `base/src/lgwebst5.cbl` |  | 9 | 45 | 2 | 56 |
| `base/src/lgstsq.cbl` | 39 |  | 5 | 2 | 46 |
| `base/src/lgipdb01.cbl` | 1 |  | 14 | 3 | 18 |
| `base/src/lgapdb01.cbl` | 1 |  | 7 | 3 | 11 |
| `base/src/lgupdb01.cbl` | 1 |  | 7 | 3 | 11 |
| `base/src/lgicvs01.cbl` | 1 |  | 7 | 2 | 10 |
| `base/src/lgtestc1.cbl` |  |  | 4 | 5 | 9 |
| `base/src/lgipvs01.cbl` | 1 |  | 4 | 2 | 7 |
| `base/src/lgacdb01.cbl` | 1 |  | 2 | 3 | 6 |
| `base/src/lgapol01.cbl` | 4 |  |  | 2 | 6 |
| `base/src/lgastat1.cbl` |  |  | 3 | 3 | 6 |
| `base/src/lgdpol01.cbl` | 4 |  |  | 2 | 6 |
| `base/src/lgipol01.cbl` | 4 |  |  | 2 | 6 |
| `base/src/lgacdb02.cbl` | 1 |  | 1 | 3 | 5 |
| `base/src/lgacvs01.cbl` | 1 | 1 |  | 3 | 5 |
| `base/src/lgapvs01.cbl` | 1 | 1 |  | 3 | 5 |
| `base/src/lgdpdb01.cbl` | 1 |  | 1 | 3 | 5 |
| `base/src/lgdpvs01.cbl` | 1 | 1 |  | 3 | 5 |
| `base/src/lgicdb01.cbl` | 1 |  | 1 | 3 | 5 |
| `base/src/lgtestp1.cbl` |  |  |  | 5 | 5 |
| `base/src/lgtestp2.cbl` |  |  |  | 5 | 5 |
| `base/src/lgtestp3.cbl` |  |  |  | 5 | 5 |
| `base/src/lgtestp4.cbl` |  |  |  | 5 | 5 |
| `base/src/lgucdb01.cbl` | 1 |  | 1 | 3 | 5 |
| `base/src/lgucvs01.cbl` | 1 | 1 |  | 3 | 5 |
| `base/src/lgupol01.cbl` | 3 |  |  | 2 | 5 |
| `base/src/lgupvs01.cbl` | 1 | 1 |  | 3 | 5 |
| `base/src/lgacus01.cbl` | 1 |  |  | 2 | 3 |
| `base/src/lgicus01.cbl` | 1 |  |  | 2 | 3 |
| `base/src/lgucus01.cbl` | 1 |  |  | 2 | 3 |
| `(project configuration)` |  |  | 1 |  | 1 |

<a id="commarea-mismatch"></a>
## COMMAREA layout mismatches (conflict)

_Resolution:_ For each caller, confirm which layout the callee reads (the COBOL MOVEs into DFHCOMMAREA say); map that caller's record onto the DTO, or give the callee one DTO per entry.

**`base/src/lgacdb01.cbl`**

- [ ] **WL-0001** `src/main/java/com/gitgalaxy/modernized/service/Lgacdb01Service.java:72` (`Lgacdb01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgacdb01.cbl:308`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, call targets (open (6 public / 0 private estates))

**`base/src/lgacdb02.cbl`**

- [ ] **WL-0002** `src/main/java/com/gitgalaxy/modernized/service/Lgacdb02Service.java:50` (`Lgacdb02Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgacdb02.cbl:205`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgacdb02.cbl:213`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgacdb02.cbl:219`, call targets (open (6 public / 0 private estates))

**`base/src/lgacus01.cbl`**

- [ ] **WL-0003** `src/main/java/com/gitgalaxy/modernized/service/Lgacus01Service.java:52` (`Lgacus01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgacus01.cbl:159`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgacus01.cbl:167`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgacus01.cbl:173`, call targets (open (6 public / 0 private estates))

**`base/src/lgacvs01.cbl`**

- [ ] **WL-0004** `src/main/java/com/gitgalaxy/modernized/service/Lgacvs01Service.java:58` (`Lgacvs01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgacvs01.cbl:102`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgacvs01.cbl:109`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgacvs01.cbl:115`, call targets (open (6 public / 0 private estates))

**`base/src/lgapdb01.cbl`**

- [ ] **WL-0005** `src/main/java/com/gitgalaxy/modernized/service/Lgapdb01Service.java:68` (`Lgapdb01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgapdb01.cbl:575`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgapdb01.cbl:583`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgapdb01.cbl:589`, call targets (open (6 public / 0 private estates))

**`base/src/lgapol01.cbl`**

- [ ] **WL-0006** `src/main/java/com/gitgalaxy/modernized/controller/Lgapol01Controller.java:20` (`Lgapol01Controller#link`): callers also pass COMM-AREA (base/src/lgtestp2.cbl, 32500 bytes) at base/src/lgtestp2.cbl:105
  - fact: `base/src/lgtestp1.cbl:115`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:105`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp3.cbl:106`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0007** `src/main/java/com/gitgalaxy/modernized/controller/Lgapol01Controller.java:21` (`Lgapol01Controller#link`): callers also pass COMM-AREA (base/src/lgtestp3.cbl, 32500 bytes) at base/src/lgtestp3.cbl:106
  - fact: `base/src/lgtestp1.cbl:115`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:105`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp3.cbl:106`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0008** `src/main/java/com/gitgalaxy/modernized/controller/Lgapol01Controller.java:22` (`Lgapol01Controller#link`): callers also pass COMM-AREA (base/src/lgtestp4.cbl, 32500 bytes) at base/src/lgtestp4.cbl:178
  - fact: `base/src/lgtestp1.cbl:115`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:105`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp3.cbl:106`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0009** `src/main/java/com/gitgalaxy/modernized/service/Lgapol01Service.java:52` (`Lgapol01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgapol01.cbl:149`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgapol01.cbl:157`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgapol01.cbl:163`, call targets (open (6 public / 0 private estates))

**`base/src/lgapvs01.cbl`**

- [ ] **WL-0010** `src/main/java/com/gitgalaxy/modernized/service/Lgapvs01Service.java:58` (`Lgapvs01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgapvs01.cbl:169`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgapvs01.cbl:176`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgapvs01.cbl:182`, call targets (open (6 public / 0 private estates))

**`base/src/lgdpdb01.cbl`**

- [ ] **WL-0011** `src/main/java/com/gitgalaxy/modernized/service/Lgdpdb01Service.java:60` (`Lgdpdb01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgdpdb01.cbl:225`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgdpdb01.cbl:233`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgdpdb01.cbl:239`, call targets (open (6 public / 0 private estates))

**`base/src/lgdpol01.cbl`**

- [ ] **WL-0012** `src/main/java/com/gitgalaxy/modernized/controller/Lgdpol01Controller.java:20` (`Lgdpol01Controller#link`): callers also pass COMM-AREA (base/src/lgtestp2.cbl, 32500 bytes) at base/src/lgtestp2.cbl:129
  - fact: `base/src/lgtestp1.cbl:139`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:129`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp3.cbl:129`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0013** `src/main/java/com/gitgalaxy/modernized/controller/Lgdpol01Controller.java:21` (`Lgdpol01Controller#link`): callers also pass COMM-AREA (base/src/lgtestp3.cbl, 32500 bytes) at base/src/lgtestp3.cbl:129
  - fact: `base/src/lgtestp1.cbl:139`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:129`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp3.cbl:129`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0014** `src/main/java/com/gitgalaxy/modernized/controller/Lgdpol01Controller.java:22` (`Lgdpol01Controller#link`): callers also pass COMM-AREA (base/src/lgtestp4.cbl, 32500 bytes) at base/src/lgtestp4.cbl:201
  - fact: `base/src/lgtestp1.cbl:139`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:129`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp3.cbl:129`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0015** `src/main/java/com/gitgalaxy/modernized/service/Lgdpol01Service.java:52` (`Lgdpol01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgdpol01.cbl:166`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgdpol01.cbl:174`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgdpol01.cbl:180`, call targets (open (6 public / 0 private estates))

**`base/src/lgdpvs01.cbl`**

- [ ] **WL-0016** `src/main/java/com/gitgalaxy/modernized/service/Lgdpvs01Service.java:58` (`Lgdpvs01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgdpvs01.cbl:113`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgdpvs01.cbl:120`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgdpvs01.cbl:126`, call targets (open (6 public / 0 private estates))

**`base/src/lgicdb01.cbl`**

- [ ] **WL-0017** `src/main/java/com/gitgalaxy/modernized/service/Lgicdb01Service.java:50` (`Lgicdb01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgicdb01.cbl:225`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgicdb01.cbl:233`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgicdb01.cbl:239`, call targets (open (6 public / 0 private estates))

**`base/src/lgicus01.cbl`**

- [ ] **WL-0018** `src/main/java/com/gitgalaxy/modernized/service/Lgicus01Service.java:52` (`Lgicus01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgicus01.cbl:146`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgicus01.cbl:154`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgicus01.cbl:160`, call targets (open (6 public / 0 private estates))

**`base/src/lgipdb01.cbl`**

- [ ] **WL-0019** `src/main/java/com/gitgalaxy/modernized/service/Lgipdb01Service.java:58` (`Lgipdb01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgipdb01.cbl:1010`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgipdb01.cbl:1018`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgipdb01.cbl:1024`, call targets (open (6 public / 0 private estates))

**`base/src/lgipol01.cbl`**

- [ ] **WL-0020** `src/main/java/com/gitgalaxy/modernized/controller/Lgipol01Controller.java:20` (`Lgipol01Controller#link`): callers also pass COMM-AREA (base/src/lgtestp2.cbl, 32500 bytes) at base/src/lgtestp2.cbl:67, base/src/lgtestp2.cbl:159
  - fact: `base/src/lgtestp1.cbl:72`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp1.cbl:173`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:67`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0021** `src/main/java/com/gitgalaxy/modernized/controller/Lgipol01Controller.java:21` (`Lgipol01Controller#link`): callers also pass COMM-AREA (base/src/lgtestp3.cbl, 32500 bytes) at base/src/lgtestp3.cbl:70, base/src/lgtestp3.cbl:159
  - fact: `base/src/lgtestp1.cbl:72`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp1.cbl:173`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:67`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0022** `src/main/java/com/gitgalaxy/modernized/controller/Lgipol01Controller.java:22` (`Lgipol01Controller#link`): callers also pass COMM-AREA (base/src/lgtestp4.cbl, 32500 bytes) at base/src/lgtestp4.cbl:122
  - fact: `base/src/lgtestp1.cbl:72`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp1.cbl:173`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:67`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0023** `src/main/java/com/gitgalaxy/modernized/service/Lgipol01Service.java:52` (`Lgipol01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgipol01.cbl:119`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgipol01.cbl:127`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgipol01.cbl:133`, call targets (open (6 public / 0 private estates))

**`base/src/lgstsq.cbl`**

- [ ] **WL-0024** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:20` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgacdb02.cbl, 99 bytes) at base/src/lgacdb02.cbl:213, base/src/lgacdb02.cbl:219
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0025** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:21` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgacus01.cbl, 99 bytes) at base/src/lgacus01.cbl:167, base/src/lgacus01.cbl:173
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0026** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:22` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgacvs01.cbl, 99 bytes) at base/src/lgacvs01.cbl:109, base/src/lgacvs01.cbl:115
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0027** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:23` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgapdb01.cbl, 99 bytes) at base/src/lgapdb01.cbl:583, base/src/lgapdb01.cbl:589
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0028** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:24` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgapol01.cbl, 99 bytes) at base/src/lgapol01.cbl:157, base/src/lgapol01.cbl:163
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0029** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:25` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgapvs01.cbl, 99 bytes) at base/src/lgapvs01.cbl:176, base/src/lgapvs01.cbl:182
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0030** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:26` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgdpdb01.cbl, 99 bytes) at base/src/lgdpdb01.cbl:233, base/src/lgdpdb01.cbl:239
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0031** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:27` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgdpol01.cbl, 99 bytes) at base/src/lgdpol01.cbl:174, base/src/lgdpol01.cbl:180
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0032** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:28` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgdpvs01.cbl, 99 bytes) at base/src/lgdpvs01.cbl:120, base/src/lgdpvs01.cbl:126
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0033** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:29` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgicdb01.cbl, 99 bytes) at base/src/lgicdb01.cbl:233, base/src/lgicdb01.cbl:239
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0034** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:30` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgicus01.cbl, 99 bytes) at base/src/lgicus01.cbl:154, base/src/lgicus01.cbl:160
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0035** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:31` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgipdb01.cbl, 99 bytes) at base/src/lgipdb01.cbl:1018, base/src/lgipdb01.cbl:1024
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0036** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:32` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgipol01.cbl, 99 bytes) at base/src/lgipol01.cbl:127, base/src/lgipol01.cbl:133
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0037** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:33` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgucdb01.cbl, 99 bytes) at base/src/lgucdb01.cbl:210, base/src/lgucdb01.cbl:216
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0038** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:34` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgucus01.cbl, 99 bytes) at base/src/lgucus01.cbl:160, base/src/lgucus01.cbl:166
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0039** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:35` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgucvs01.cbl, 99 bytes) at base/src/lgucvs01.cbl:124, base/src/lgucvs01.cbl:130
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0040** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:36` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgupdb01.cbl, 99 bytes) at base/src/lgupdb01.cbl:523, base/src/lgupdb01.cbl:529
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0041** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:37` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgupol01.cbl, 99 bytes) at base/src/lgupol01.cbl:189, base/src/lgupol01.cbl:195
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0042** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:38` (`LgstsqController#link`): callers also pass CA-ERROR-MSG (base/src/lgupvs01.cbl, 99 bytes) at base/src/lgupvs01.cbl:194, base/src/lgupvs01.cbl:200
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0043** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:39` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgacdb01.cbl, 71 bytes) at base/src/lgacdb01.cbl:308
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0044** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:40` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgacdb02.cbl, 71 bytes) at base/src/lgacdb02.cbl:205
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0045** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:41` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgacus01.cbl, 45 bytes) at base/src/lgacus01.cbl:159
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0046** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:42` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgacvs01.cbl, 85 bytes) at base/src/lgacvs01.cbl:102
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0047** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:43` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgapdb01.cbl, 87 bytes) at base/src/lgapdb01.cbl:575
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0048** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:44` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgapol01.cbl, 45 bytes) at base/src/lgapol01.cbl:149
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0049** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:45` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgapvs01.cbl, 101 bytes) at base/src/lgapvs01.cbl:169
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0050** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:46` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgdpdb01.cbl, 87 bytes) at base/src/lgdpdb01.cbl:225
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0051** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:47` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgdpol01.cbl, 45 bytes) at base/src/lgdpol01.cbl:166
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0052** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:48` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgdpvs01.cbl, 102 bytes) at base/src/lgdpvs01.cbl:113
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0053** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:49` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgicdb01.cbl, 71 bytes) at base/src/lgicdb01.cbl:225
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0054** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:50` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgicus01.cbl, 45 bytes) at base/src/lgicus01.cbl:146
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0055** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:51` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgipdb01.cbl, 87 bytes) at base/src/lgipdb01.cbl:1010
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0056** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:52` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgipol01.cbl, 45 bytes) at base/src/lgipol01.cbl:119
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0057** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:53` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgucdb01.cbl, 71 bytes) at base/src/lgucdb01.cbl:202
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0058** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:54` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgucus01.cbl, 45 bytes) at base/src/lgucus01.cbl:152
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0059** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:55` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgucvs01.cbl, 85 bytes) at base/src/lgucvs01.cbl:117
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0060** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:56` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgupdb01.cbl, 87 bytes) at base/src/lgupdb01.cbl:515
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0061** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:57` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgupol01.cbl, 45 bytes) at base/src/lgupol01.cbl:181
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0062** `src/main/java/com/gitgalaxy/modernized/controller/LgstsqController.java:58` (`LgstsqController#link`): callers also pass ERROR-MSG (base/src/lgupvs01.cbl, 101 bytes) at base/src/lgupvs01.cbl:187
  - fact: `base/src/lgacdb01.cbl:308`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:316`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgacdb01.cbl:322`, CICS resources (open (5 public / 0 private estates))

**`base/src/lgucdb01.cbl`**

- [ ] **WL-0063** `src/main/java/com/gitgalaxy/modernized/service/Lgucdb01Service.java:60` (`Lgucdb01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgucdb01.cbl:202`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgucdb01.cbl:210`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgucdb01.cbl:216`, call targets (open (6 public / 0 private estates))

**`base/src/lgucus01.cbl`**

- [ ] **WL-0064** `src/main/java/com/gitgalaxy/modernized/service/Lgucus01Service.java:52` (`Lgucus01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgucus01.cbl:152`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgucus01.cbl:160`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgucus01.cbl:166`, call targets (open (6 public / 0 private estates))

**`base/src/lgucvs01.cbl`**

- [ ] **WL-0065** `src/main/java/com/gitgalaxy/modernized/service/Lgucvs01Service.java:59` (`Lgucvs01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgucvs01.cbl:117`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgucvs01.cbl:124`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgucvs01.cbl:130`, call targets (open (6 public / 0 private estates))

**`base/src/lgupdb01.cbl`**

- [ ] **WL-0066** `src/main/java/com/gitgalaxy/modernized/service/Lgupdb01Service.java:66` (`Lgupdb01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgupdb01.cbl:515`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgupdb01.cbl:523`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgupdb01.cbl:529`, call targets (open (6 public / 0 private estates))

**`base/src/lgupol01.cbl`**

- [ ] **WL-0067** `src/main/java/com/gitgalaxy/modernized/controller/Lgupol01Controller.java:20` (`Lgupol01Controller#link`): callers also pass COMM-AREA (base/src/lgtestp2.cbl, 32500 bytes) at base/src/lgtestp2.cbl:198
  - fact: `base/src/lgtestp1.cbl:216`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:198`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp3.cbl:196`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0068** `src/main/java/com/gitgalaxy/modernized/controller/Lgupol01Controller.java:21` (`Lgupol01Controller#link`): callers also pass COMM-AREA (base/src/lgtestp3.cbl, 32500 bytes) at base/src/lgtestp3.cbl:196
  - fact: `base/src/lgtestp1.cbl:216`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:198`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/src/lgtestp3.cbl:196`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0069** `src/main/java/com/gitgalaxy/modernized/service/Lgupol01Service.java:52` (`Lgupol01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgupol01.cbl:181`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgupol01.cbl:189`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgupol01.cbl:195`, call targets (open (6 public / 0 private estates))

**`base/src/lgupvs01.cbl`**

- [ ] **WL-0070** `src/main/java/com/gitgalaxy/modernized/service/Lgupvs01Service.java:60` (`Lgupvs01Service#linkLgstsq`): this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
  - fact: `base/src/lgupvs01.cbl:187`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgupvs01.cbl:194`, call targets (open (6 public / 0 private estates))
  - fact: `base/src/lgupvs01.cbl:200`, call targets (open (6 public / 0 private estates))

<a id="record-variant"></a>
## Programs reading another record layout (conflict)

_Resolution:_ Map the program's record onto the entity's fields (or split the entity); the two layouts' sizes are in the TODO.

**`base/src/lgicvs01.cbl`**

- [ ] **WL-0071** `src/main/java/com/gitgalaxy/modernized/service/Lgicvs01Service.java:58` (`Lgicvs01Service#readKsdscust`): this program uses CA-AREA (225 bytes); the entity follows CA-CUSTOMER-NUM (10 bytes) -- map one onto the other
  - fact: `base/src/lgicvs01.cbl:199`, VSAM defines (open (3 public / 0 private estates))

**`base/src/lgipvs01.cbl`**

- [ ] **WL-0072** `src/main/java/com/gitgalaxy/modernized/service/Lgipvs01Service.java:52` (`Lgipvs01Service#readKsdspoly`): this program uses CA-AREA (64 bytes); the entity follows WF-POLICY-INFO (64 bytes) -- map one onto the other
  - fact: `base/src/lgipvs01.cbl:111`, VSAM defines (open (3 public / 0 private estates))

<a id="missing-layout"></a>
## Unresolved layouts (fact-gap)

_Resolution:_ Add the missing copybook / %INCLUDE member or record to the repository and re-run; the DTO then gets its real fields.

**`base/src/lgacvs01.cbl`**

- [ ] **WL-0073** `src/main/java/com/gitgalaxy/modernized/controller/Lgacvs01Controller.java:20` (`Lgacvs01Controller#link`, `Lgacvs01Controller#transactionVSCA`): DFHCOMMAREA (base/src/lgacdb01.cbl), passed at base/src/lgacdb01.cbl:174, has no known width; this program's declared DFHCOMMAREA (32500 bytes) is used -- confirm the callers pass it
  - fact: `base/src/lgacdb01.cbl:174`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/cntl/cdef123.jcl:162`, entry transactions (open (4 public / 0 private estates))

**`base/src/lgapvs01.cbl`**

- [ ] **WL-0074** `src/main/java/com/gitgalaxy/modernized/controller/Lgapvs01Controller.java:20` (`Lgapvs01Controller#link`, `Lgapvs01Controller#transactionVSPA`): DFHCOMMAREA (base/src/lgapdb01.cbl), passed at base/src/lgapdb01.cbl:243, has no known width; this program's declared DFHCOMMAREA (32500 bytes) is used -- confirm the callers pass it
  - fact: `base/src/lgapdb01.cbl:243`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/cntl/cdef123.jcl:165`, entry transactions (open (4 public / 0 private estates))

**`base/src/lgdpvs01.cbl`**

- [ ] **WL-0075** `src/main/java/com/gitgalaxy/modernized/controller/Lgdpvs01Controller.java:20` (`Lgdpvs01Controller#link`, `Lgdpvs01Controller#transactionVSPD`): DFHCOMMAREA (base/src/lgdpdb01.cbl), passed at base/src/lgdpdb01.cbl:168, has no known width; this program's declared DFHCOMMAREA (32500 bytes) is used -- confirm the callers pass it
  - fact: `base/src/lgdpdb01.cbl:168`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/cntl/cdef123.jcl:168`, entry transactions (open (4 public / 0 private estates))

**`base/src/lgucvs01.cbl`**

- [ ] **WL-0076** `src/main/java/com/gitgalaxy/modernized/controller/Lgucvs01Controller.java:20` (`Lgucvs01Controller#link`, `Lgucvs01Controller#transactionVSC1`): DFHCOMMAREA (base/src/lgucdb01.cbl), passed at base/src/lgucdb01.cbl:136, has no known width; this program's declared DFHCOMMAREA (32500 bytes) is used -- confirm the callers pass it
  - fact: `base/src/lgucdb01.cbl:136`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/cntl/cdef123.jcl:177`, entry transactions (open (4 public / 0 private estates))

**`base/src/lgupvs01.cbl`**

- [ ] **WL-0077** `src/main/java/com/gitgalaxy/modernized/controller/Lgupvs01Controller.java:20` (`Lgupvs01Controller#link`, `Lgupvs01Controller#transactionVSP1`): DFHCOMMAREA (base/src/lgupdb01.cbl), passed at base/src/lgupdb01.cbl:209, has no known width; this program's declared DFHCOMMAREA (32500 bytes) is used -- confirm the callers pass it
  - fact: `base/src/lgupdb01.cbl:209`, CICS resources (open (5 public / 0 private estates))
  - fact: `base/cntl/cdef123.jcl:180`, entry transactions (open (4 public / 0 private estates))

<a id="queue-name"></a>
## Data-driven queue names (fact-gap)

_Resolution:_ Resolve the name (the MOVEs into the operand, or the installation's symbol table) and pass it: the port takes any queue name.

**`base/src/lgwebst5.cbl`**

- [ ] **WL-0078** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:74` (`Lgwebst5Service#deleteqTsL778`): the queue name is data-driven (QUEUE(WS-TSQname)): pass it
  - fact: `base/src/lgwebst5.cbl:778`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0079** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:81` (`Lgwebst5Service#deleteqTsL729`): the queue name is data-driven (QUEUE(WS-TSQNAME)): pass it
  - fact: `base/src/lgwebst5.cbl:729`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0080** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:88` (`Lgwebst5Service#writeqTsL734`): the queue name is data-driven (QUEUE(WS-TSQNAME)): pass it
  - fact: `base/src/lgwebst5.cbl:734`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0081** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:95` (`Lgwebst5Service#writeqTsL756`): the queue name is data-driven (QUEUE(WS-TSQNAME)): pass it
  - fact: `base/src/lgwebst5.cbl:756`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0082** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:102` (`Lgwebst5Service#readqTsL720`): the queue name is data-driven (QUEUE(WS-TSQname)): pass it
  - fact: `base/src/lgwebst5.cbl:720`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0083** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:109` (`Lgwebst5Service#readqTsL771`): the queue name is data-driven (QUEUE(WS-TSQname)): pass it
  - fact: `base/src/lgwebst5.cbl:771`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0084** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:116` (`Lgwebst5Service#writeqTsL783`): the queue name is data-driven (QUEUE(WS-TSQname)): pass it
  - fact: `base/src/lgwebst5.cbl:783`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0085** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:123` (`Lgwebst5Service#writeqTsL789`): the queue name is data-driven (QUEUE(WS-TSQname)): pass it
  - fact: `base/src/lgwebst5.cbl:789`, CICS resources (open (5 public / 0 private estates))
- [ ] **WL-0086** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:130` (`Lgwebst5Service#writeqTsL796`): the queue name is data-driven (QUEUE(WS-TSQname)): pass it
  - fact: `base/src/lgwebst5.cbl:796`, CICS resources (open (5 public / 0 private estates))

<a id="unchecked-resp"></a>
## CICS responses the COBOL never tests (review)

_Resolution:_ Decide what a failed call does: the COBOL ignores it, so the Java throws; catch it where the old behaviour (carry on) is really wanted.

**`base/src/lgastat1.cbl`**

- [ ] **WL-0087** `src/main/java/com/gitgalaxy/modernized/service/Lgastat1Service.java:24` (`Lgastat1Service`): the RESP of GET at line 79 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgastat1.cbl:79`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0088** `src/main/java/com/gitgalaxy/modernized/service/Lgastat1Service.java:25` (`Lgastat1Service`): the RESP of WRITEQ at line 115 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgastat1.cbl:115`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0089** `src/main/java/com/gitgalaxy/modernized/service/Lgastat1Service.java:26` (`Lgastat1Service`): the RESP of GET at line 129 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgastat1.cbl:129`, units of work and handlers (field-tested (6 public / 0 private estates))

**`base/src/lgicvs01.cbl`**

- [ ] **WL-0090** `src/main/java/com/gitgalaxy/modernized/service/Lgicvs01Service.java:28` (`Lgicvs01Service`): the RESP of ASSIGN at line 97 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgicvs01.cbl:97`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0091** `src/main/java/com/gitgalaxy/modernized/service/Lgicvs01Service.java:29` (`Lgicvs01Service`): the RESP of ASSIGN at line 101 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgicvs01.cbl:101`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0092** `src/main/java/com/gitgalaxy/modernized/service/Lgicvs01Service.java:30` (`Lgicvs01Service`): the RESP of ASSIGN at line 105 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgicvs01.cbl:105`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0093** `src/main/java/com/gitgalaxy/modernized/service/Lgicvs01Service.java:31` (`Lgicvs01Service`): the RESP of RECEIVE at line 114 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgicvs01.cbl:114`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0094** `src/main/java/com/gitgalaxy/modernized/service/Lgicvs01Service.java:32` (`Lgicvs01Service`): the RESP of WRITEQ at line 163 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgicvs01.cbl:163`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0095** `src/main/java/com/gitgalaxy/modernized/service/Lgicvs01Service.java:33` (`Lgicvs01Service`): the RESP of WRITEQ at line 172 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgicvs01.cbl:172`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0096** `src/main/java/com/gitgalaxy/modernized/service/Lgicvs01Service.java:34` (`Lgicvs01Service`): the RESP of WRITEQ at line 181 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgicvs01.cbl:181`, units of work and handlers (field-tested (6 public / 0 private estates))

**`base/src/lgipvs01.cbl`**

- [ ] **WL-0097** `src/main/java/com/gitgalaxy/modernized/service/Lgipvs01Service.java:26` (`Lgipvs01Service`): the RESP of ASSIGN at line 79 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgipvs01.cbl:79`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0098** `src/main/java/com/gitgalaxy/modernized/service/Lgipvs01Service.java:27` (`Lgipvs01Service`): the RESP of ASSIGN at line 83 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgipvs01.cbl:83`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0099** `src/main/java/com/gitgalaxy/modernized/service/Lgipvs01Service.java:28` (`Lgipvs01Service`): the RESP of ASSIGN at line 87 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgipvs01.cbl:87`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0100** `src/main/java/com/gitgalaxy/modernized/service/Lgipvs01Service.java:29` (`Lgipvs01Service`): the RESP of RECEIVE at line 98 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgipvs01.cbl:98`, units of work and handlers (field-tested (6 public / 0 private estates))

**`base/src/lgsetup.cbl`**

- [ ] **WL-0101** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:20` (`LgsetupService`): the RESP of RECEIVE at line 128 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:128`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0102** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:21` (`LgsetupService`): the RESP of DELETEQ at line 138 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:138`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0103** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:22` (`LgsetupService`): the RESP of DELETEQ at line 142 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:142`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0104** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:23` (`LgsetupService`): the RESP of DELETEQ at line 146 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:146`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0105** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:24` (`LgsetupService`): the RESP of DELETEQ at line 150 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:150`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0106** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:25` (`LgsetupService`): the RESP of WRITEQ at line 157 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:157`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0107** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:26` (`LgsetupService`): the RESP of WRITEQ at line 164 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:164`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0108** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:27` (`LgsetupService`): the RESP of WRITEQ at line 171 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:171`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0109** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:28` (`LgsetupService`): the RESP of DELETE at line 179 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:179`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0110** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:29` (`LgsetupService`): the RESP of DEFINE at line 183 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:183`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0111** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:30` (`LgsetupService`): the RESP of DELETE at line 189 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:189`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0112** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:31` (`LgsetupService`): the RESP of DEFINE at line 193 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:193`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0113** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:32` (`LgsetupService`): the RESP of DELETE at line 198 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:198`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0114** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:33` (`LgsetupService`): the RESP of DEFINE at line 202 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:202`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0115** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:34` (`LgsetupService`): the RESP of DELETE at line 207 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:207`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0116** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:35` (`LgsetupService`): the RESP of DEFINE at line 211 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:211`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0117** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:36` (`LgsetupService`): the RESP of DELETE at line 216 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:216`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0118** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:37` (`LgsetupService`): the RESP of DEFINE at line 220 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:220`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0119** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:38` (`LgsetupService`): the RESP of DELETE at line 226 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:226`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0120** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:39` (`LgsetupService`): the RESP of DEFINE at line 230 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:230`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0121** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:40` (`LgsetupService`): the RESP of DELETE at line 235 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:235`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0122** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:41` (`LgsetupService`): the RESP of DEFINE at line 239 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:239`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0123** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:42` (`LgsetupService`): the RESP of DELETE at line 244 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:244`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0124** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:43` (`LgsetupService`): the RESP of DEFINE at line 248 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:248`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0125** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:44` (`LgsetupService`): the RESP of DELETE at line 253 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:253`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0126** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:45` (`LgsetupService`): the RESP of DEFINE at line 257 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:257`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0127** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:46` (`LgsetupService`): the RESP of DELETE at line 262 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:262`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0128** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:47` (`LgsetupService`): the RESP of DEFINE at line 266 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:266`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0129** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:48` (`LgsetupService`): the RESP of DELETE at line 271 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:271`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0130** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:49` (`LgsetupService`): the RESP of DEFINE at line 275 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:275`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0131** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 284 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:284`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0132** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 293 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:293`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0133** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 303 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:303`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0134** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 312 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:312`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0135** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 321 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:321`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0136** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 330 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:330`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0137** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 339 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:339`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0138** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 348 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:348`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0139** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 357 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:357`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0140** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 366 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:366`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0141** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 376 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:376`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0142** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 385 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:385`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0143** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 394 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:394`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0144** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 403 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:403`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0145** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 412 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:412`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0146** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 421 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:421`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0147** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 430 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:430`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0148** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 439 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:439`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0149** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 449 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:449`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0150** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 458 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:458`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0151** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 467 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:467`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0152** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 476 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:476`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0153** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 485 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:485`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0154** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 494 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:494`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0155** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 503 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:503`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0156** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DEFINE at line 512 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:512`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0157** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 280 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:280`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0158** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 289 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:289`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0159** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 299 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:299`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0160** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 308 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:308`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0161** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 317 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:317`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0162** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 326 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:326`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0163** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 335 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:335`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0164** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 344 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:344`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0165** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 353 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:353`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0166** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 362 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:362`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0167** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 372 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:372`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0168** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 381 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:381`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0169** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 390 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:390`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0170** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 399 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:399`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0171** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 408 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:408`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0172** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 417 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:417`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0173** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 426 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:426`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0174** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 435 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:435`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0175** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 445 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:445`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0176** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 454 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:454`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0177** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 463 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:463`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0178** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 472 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:472`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0179** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 481 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:481`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0180** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 490 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:490`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0181** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 499 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:499`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0182** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java` (`LgsetupService`): the RESP of DELETE at line 508 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgsetup.cbl:508`, units of work and handlers (field-tested (6 public / 0 private estates))

**`base/src/lgstsq.cbl`**

- [ ] **WL-0183** `src/main/java/com/gitgalaxy/modernized/service/LgstsqService.java:21` (`LgstsqService`): the RESP of ASSIGN at line 60 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgstsq.cbl:60`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0184** `src/main/java/com/gitgalaxy/modernized/service/LgstsqService.java:22` (`LgstsqService`): the RESP of ASSIGN at line 64 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgstsq.cbl:64`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0185** `src/main/java/com/gitgalaxy/modernized/service/LgstsqService.java:23` (`LgstsqService`): the RESP of RECEIVE at line 73 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgstsq.cbl:73`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0186** `src/main/java/com/gitgalaxy/modernized/service/LgstsqService.java:24` (`LgstsqService`): the RESP of WRITEQ at line 94 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgstsq.cbl:94`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0187** `src/main/java/com/gitgalaxy/modernized/service/LgstsqService.java:25` (`LgstsqService`): the RESP of WRITEQ at line 105 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgstsq.cbl:105`, units of work and handlers (field-tested (6 public / 0 private estates))

**`base/src/lgtestc1.cbl`**

- [ ] **WL-0188** `src/main/java/com/gitgalaxy/modernized/service/Lgtestc1Service.java:31` (`Lgtestc1Service`): the RESP of WRITEQ at line 307 (paragraph WRITE-GENACNTL) is never tested
  - fact: `base/src/lgtestc1.cbl:307`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0189** `src/main/java/com/gitgalaxy/modernized/service/Lgtestc1Service.java:32` (`Lgtestc1Service`): the RESP of WRITEQ at line 321 (paragraph WRITE-GENACNTL) is never tested
  - fact: `base/src/lgtestc1.cbl:321`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0190** `src/main/java/com/gitgalaxy/modernized/service/Lgtestc1Service.java:33` (`Lgtestc1Service`): the RESP of WRITEQ at line 329 (paragraph WRITE-GENACNTL) is never tested
  - fact: `base/src/lgtestc1.cbl:329`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0191** `src/main/java/com/gitgalaxy/modernized/service/Lgtestc1Service.java:34` (`Lgtestc1Service`): the RESP of WRITEQ at line 335 (paragraph WRITE-GENACNTL) is never tested
  - fact: `base/src/lgtestc1.cbl:335`, units of work and handlers (field-tested (6 public / 0 private estates))

**`base/src/lgwebst5.cbl`**

- [ ] **WL-0192** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:22` (`Lgwebst5Service`): the RESP of QUERY at line 268 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:268`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0193** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:23` (`Lgwebst5Service`): the RESP of QUERY at line 281 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:281`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0194** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:24` (`Lgwebst5Service`): the RESP of QUERY at line 296 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:296`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0195** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:25` (`Lgwebst5Service`): the RESP of QUERY at line 304 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:304`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0196** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:26` (`Lgwebst5Service`): the RESP of QUERY at line 318 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:318`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0197** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:27` (`Lgwebst5Service`): the RESP of QUERY at line 327 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:327`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0198** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:28` (`Lgwebst5Service`): the RESP of QUERY at line 341 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:341`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0199** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:29` (`Lgwebst5Service`): the RESP of QUERY at line 349 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:349`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0200** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:30` (`Lgwebst5Service`): the RESP of QUERY at line 363 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:363`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0201** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:31` (`Lgwebst5Service`): the RESP of QUERY at line 371 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:371`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0202** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:32` (`Lgwebst5Service`): the RESP of QUERY at line 385 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:385`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0203** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:33` (`Lgwebst5Service`): the RESP of QUERY at line 393 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:393`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0204** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:34` (`Lgwebst5Service`): the RESP of QUERY at line 407 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:407`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0205** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:35` (`Lgwebst5Service`): the RESP of QUERY at line 416 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:416`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0206** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:36` (`Lgwebst5Service`): the RESP of QUERY at line 430 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:430`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0207** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:37` (`Lgwebst5Service`): the RESP of QUERY at line 438 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:438`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0208** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:38` (`Lgwebst5Service`): the RESP of QUERY at line 452 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:452`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0209** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:39` (`Lgwebst5Service`): the RESP of QUERY at line 460 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:460`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0210** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:40` (`Lgwebst5Service`): the RESP of QUERY at line 474 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:474`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0211** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:41` (`Lgwebst5Service`): the RESP of QUERY at line 482 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:482`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0212** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:42` (`Lgwebst5Service`): the RESP of QUERY at line 496 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:496`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0213** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:43` (`Lgwebst5Service`): the RESP of QUERY at line 505 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:505`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0214** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:44` (`Lgwebst5Service`): the RESP of QUERY at line 519 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:519`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0215** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:45` (`Lgwebst5Service`): the RESP of QUERY at line 527 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:527`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0216** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:46` (`Lgwebst5Service`): the RESP of QUERY at line 541 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:541`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0217** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:47` (`Lgwebst5Service`): the RESP of QUERY at line 549 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:549`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0218** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:48` (`Lgwebst5Service`): the RESP of QUERY at line 563 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:563`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0219** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:49` (`Lgwebst5Service`): the RESP of QUERY at line 571 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:571`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0220** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:50` (`Lgwebst5Service`): the RESP of QUERY at line 585 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:585`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0221** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of DELETEQ at line 729 (paragraph Tran-Rate-Interval) is never tested
  - fact: `base/src/lgwebst5.cbl:729`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0222** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of DELETEQ at line 778 (paragraph Tran-Rate-Counts) is never tested
  - fact: `base/src/lgwebst5.cbl:778`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0223** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of QUERY at line 594 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:594`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0224** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of QUERY at line 608 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:608`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0225** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of QUERY at line 616 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:616`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0226** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of QUERY at line 630 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:630`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0227** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of QUERY at line 638 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:638`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0228** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of QUERY at line 652 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:652`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0229** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of QUERY at line 662 (paragraph MAINLINE) is never tested
  - fact: `base/src/lgwebst5.cbl:662`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0230** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of READQ at line 771 (paragraph Tran-Rate-Counts) is never tested
  - fact: `base/src/lgwebst5.cbl:771`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0231** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of START at line 761 (paragraph Tran-Rate-Interval) is never tested
  - fact: `base/src/lgwebst5.cbl:761`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0232** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of WRITEQ at line 734 (paragraph Tran-Rate-Interval) is never tested
  - fact: `base/src/lgwebst5.cbl:734`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0233** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of WRITEQ at line 756 (paragraph Tran-Rate-Interval) is never tested
  - fact: `base/src/lgwebst5.cbl:756`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0234** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of WRITEQ at line 783 (paragraph Tran-Rate-Counts) is never tested
  - fact: `base/src/lgwebst5.cbl:783`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0235** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of WRITEQ at line 789 (paragraph Tran-Rate-Counts) is never tested
  - fact: `base/src/lgwebst5.cbl:789`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0236** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java` (`Lgwebst5Service`): the RESP of WRITEQ at line 796 (paragraph Tran-Rate-Counts) is never tested
  - fact: `base/src/lgwebst5.cbl:796`, units of work and handlers (field-tested (6 public / 0 private estates))

<a id="db2-positioned"></a>
## Positioned SQL (WHERE CURRENT OF) (review)

_Resolution:_ Rewrite the UPDATE / DELETE to the row's key: JDBC keeps no cursor position here.

**`base/src/lgupdb01.cbl`**

- [ ] **WL-0237** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java:139` (`PolicyRepository#updateL318Lgupdb01`): a positioned statement (WHERE CURRENT OF): rewrite it to the row's key
  - fact: `base/src/lgupdb01.cbl:318`, DB2 table access (open (3 public / 0 private estates))

<a id="db2-dialect"></a>
## DB2 SQL on another database (review)

_Resolution:_ Run each statement on the target database; DB2-only syntax (FETCH FIRST, WITH UR, special registers) needs its equivalent.

**`base/src/lgacdb01.cbl`**

- [ ] **WL-0238** `src/main/java/com/gitgalaxy/modernized/repository/db2/CustomerRepository.java` (`CustomerRepository#insertL222Lgacdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgacdb01.cbl:222`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0239** `src/main/java/com/gitgalaxy/modernized/repository/db2/CustomerRepository.java` (`CustomerRepository#insertL251Lgacdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgacdb01.cbl:251`, DB2 table access (open (3 public / 0 private estates))

**`base/src/lgacdb02.cbl`**

- [ ] **WL-0240** `src/main/java/com/gitgalaxy/modernized/repository/db2/CustomerSecureRepository.java` (`CustomerSecureRepository#insertL166Lgacdb02`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgacdb02.cbl:166`, DB2 table access (open (3 public / 0 private estates))

**`base/src/lgapdb01.cbl`**

- [ ] **WL-0241** `src/main/java/com/gitgalaxy/modernized/repository/db2/CommercialRepository.java` (`CommercialRepository#insertL499Lgapdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgapdb01.cbl:499`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0242** `src/main/java/com/gitgalaxy/modernized/repository/db2/EndowmentRepository.java` (`EndowmentRepository#insertL346Lgapdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgapdb01.cbl:346`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0243** `src/main/java/com/gitgalaxy/modernized/repository/db2/EndowmentRepository.java` (`EndowmentRepository#insertL368Lgapdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgapdb01.cbl:368`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0244** `src/main/java/com/gitgalaxy/modernized/repository/db2/HouseRepository.java` (`HouseRepository#insertL409Lgapdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgapdb01.cbl:409`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0245** `src/main/java/com/gitgalaxy/modernized/repository/db2/MotorRepository.java` (`MotorRepository#insertL449Lgapdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgapdb01.cbl:449`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0246** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#insertL268Lgapdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgapdb01.cbl:268`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0247** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#selectL316Lgapdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgapdb01.cbl:316`, DB2 table access (open (3 public / 0 private estates))

**`base/src/lgdpdb01.cbl`**

- [ ] **WL-0248** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#deleteL189Lgdpdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgdpdb01.cbl:189`, DB2 table access (open (3 public / 0 private estates))

**`base/src/lgicdb01.cbl`**

- [ ] **WL-0249** `src/main/java/com/gitgalaxy/modernized/repository/db2/CustomerRepository.java` (`CustomerRepository#selectL169Lgicdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgicdb01.cbl:169`, DB2 table access (open (3 public / 0 private estates))

**`base/src/lgipdb01.cbl`**

- [ ] **WL-0250** `src/main/java/com/gitgalaxy/modernized/repository/db2/CommercialRepository.java` (`CommercialRepository#cursorCustCursorL89Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:89`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0251** `src/main/java/com/gitgalaxy/modernized/repository/db2/CommercialRepository.java` (`CommercialRepository#cursorZipCursorL120Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:120`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0252** `src/main/java/com/gitgalaxy/modernized/repository/db2/CommercialRepository.java` (`CommercialRepository#selectL631Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:631`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0253** `src/main/java/com/gitgalaxy/modernized/repository/db2/CommercialRepository.java` (`CommercialRepository#selectL734Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:734`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0254** `src/main/java/com/gitgalaxy/modernized/repository/db2/EndowmentRepository.java` (`EndowmentRepository#selectL330Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:330`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0255** `src/main/java/com/gitgalaxy/modernized/repository/db2/HouseRepository.java` (`HouseRepository#selectL444Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:444`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0256** `src/main/java/com/gitgalaxy/modernized/repository/db2/MotorRepository.java` (`MotorRepository#selectL532Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:532`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0257** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#cursorCustCursorL89Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:89`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0258** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#cursorZipCursorL120Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:120`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0259** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#selectL330Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:330`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0260** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#selectL444Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:444`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0261** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#selectL532Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:532`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0262** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#selectL631Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:631`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0263** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#selectL734Lgipdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgipdb01.cbl:734`, DB2 table access (open (3 public / 0 private estates))

**`base/src/lgucdb01.cbl`**

- [ ] **WL-0264** `src/main/java/com/gitgalaxy/modernized/repository/db2/CustomerRepository.java` (`CustomerRepository#updateL155Lgucdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgucdb01.cbl:155`, DB2 table access (open (3 public / 0 private estates))

**`base/src/lgupdb01.cbl`**

- [ ] **WL-0265** `src/main/java/com/gitgalaxy/modernized/repository/db2/EndowmentRepository.java` (`EndowmentRepository#updateL394Lgupdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgupdb01.cbl:394`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0266** `src/main/java/com/gitgalaxy/modernized/repository/db2/HouseRepository.java` (`HouseRepository#updateL431Lgupdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgupdb01.cbl:431`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0267** `src/main/java/com/gitgalaxy/modernized/repository/db2/MotorRepository.java` (`MotorRepository#updateL469Lgupdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgupdb01.cbl:469`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0268** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#cursorPolicyCursorL128Lgupdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgupdb01.cbl:128`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0269** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#selectL329Lgupdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgupdb01.cbl:329`, DB2 table access (open (3 public / 0 private estates))
- [ ] **WL-0270** `src/main/java/com/gitgalaxy/modernized/repository/db2/PolicyRepository.java` (`PolicyRepository#updateL318Lgupdb01`): DB2 SQL on postgresql -- review the statement
  - fact: `base/src/lgupdb01.cbl:318`, DB2 table access (open (3 public / 0 private estates))

<a id="business-logic"></a>
## Business logic to port (port)

_Resolution:_ Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch.

**`base/src/lgacdb01.cbl`**

- [ ] **WL-0271** `src/main/java/com/gitgalaxy/modernized/service/Lgacdb01Service.java:43`: Implement extracted business rules here
- [ ] **WL-0272** `src/main/java/com/gitgalaxy/modernized/service/Lgacdb01Service.java:46`: implement from the program's business rules
- [ ] **WL-0273** `src/main/java/com/gitgalaxy/modernized/service/Lgacdb01Service.java:52`: implement from the program's business rules

**`base/src/lgacdb02.cbl`**

- [ ] **WL-0274** `src/main/java/com/gitgalaxy/modernized/service/Lgacdb02Service.java:33`: Implement extracted business rules here
- [ ] **WL-0275** `src/main/java/com/gitgalaxy/modernized/service/Lgacdb02Service.java:36`: implement from the program's business rules
- [ ] **WL-0276** `src/main/java/com/gitgalaxy/modernized/service/Lgacdb02Service.java:42`: implement from the program's business rules

**`base/src/lgacus01.cbl`**

- [ ] **WL-0277** `src/main/java/com/gitgalaxy/modernized/service/Lgacus01Service.java:35`: Implement extracted business rules here
- [ ] **WL-0278** `src/main/java/com/gitgalaxy/modernized/service/Lgacus01Service.java:38`: implement from the program's business rules

**`base/src/lgacvs01.cbl`**

- [ ] **WL-0279** `src/main/java/com/gitgalaxy/modernized/service/Lgacvs01Service.java:41`: Implement extracted business rules here
- [ ] **WL-0280** `src/main/java/com/gitgalaxy/modernized/service/Lgacvs01Service.java:44`: implement from the program's business rules
- [ ] **WL-0281** `src/main/java/com/gitgalaxy/modernized/service/Lgacvs01Service.java:50`: implement from the program's business rules

**`base/src/lgapdb01.cbl`**

- [ ] **WL-0282** `src/main/java/com/gitgalaxy/modernized/service/Lgapdb01Service.java:45`: Implement extracted business rules here
- [ ] **WL-0283** `src/main/java/com/gitgalaxy/modernized/service/Lgapdb01Service.java:48`: implement from the program's business rules
- [ ] **WL-0284** `src/main/java/com/gitgalaxy/modernized/service/Lgapdb01Service.java:54`: implement from the program's business rules

**`base/src/lgapol01.cbl`**

- [ ] **WL-0285** `src/main/java/com/gitgalaxy/modernized/service/Lgapol01Service.java:35`: Implement extracted business rules here
- [ ] **WL-0286** `src/main/java/com/gitgalaxy/modernized/service/Lgapol01Service.java:38`: implement from the program's business rules

**`base/src/lgapvs01.cbl`**

- [ ] **WL-0287** `src/main/java/com/gitgalaxy/modernized/service/Lgapvs01Service.java:41`: Implement extracted business rules here
- [ ] **WL-0288** `src/main/java/com/gitgalaxy/modernized/service/Lgapvs01Service.java:44`: implement from the program's business rules
- [ ] **WL-0289** `src/main/java/com/gitgalaxy/modernized/service/Lgapvs01Service.java:50`: implement from the program's business rules

**`base/src/lgastat1.cbl`**

- [ ] **WL-0290** `src/main/java/com/gitgalaxy/modernized/service/Lgastat1Service.java:39`: Implement extracted business rules here
- [ ] **WL-0291** `src/main/java/com/gitgalaxy/modernized/service/Lgastat1Service.java:42`: implement from the program's business rules
- [ ] **WL-0292** `src/main/java/com/gitgalaxy/modernized/service/Lgastat1Service.java:48`: implement from the program's business rules

**`base/src/lgdpdb01.cbl`**

- [ ] **WL-0293** `src/main/java/com/gitgalaxy/modernized/service/Lgdpdb01Service.java:37`: Implement extracted business rules here
- [ ] **WL-0294** `src/main/java/com/gitgalaxy/modernized/service/Lgdpdb01Service.java:40`: implement from the program's business rules
- [ ] **WL-0295** `src/main/java/com/gitgalaxy/modernized/service/Lgdpdb01Service.java:46`: implement from the program's business rules

**`base/src/lgdpol01.cbl`**

- [ ] **WL-0296** `src/main/java/com/gitgalaxy/modernized/service/Lgdpol01Service.java:35`: Implement extracted business rules here
- [ ] **WL-0297** `src/main/java/com/gitgalaxy/modernized/service/Lgdpol01Service.java:38`: implement from the program's business rules

**`base/src/lgdpvs01.cbl`**

- [ ] **WL-0298** `src/main/java/com/gitgalaxy/modernized/service/Lgdpvs01Service.java:41`: Implement extracted business rules here
- [ ] **WL-0299** `src/main/java/com/gitgalaxy/modernized/service/Lgdpvs01Service.java:44`: implement from the program's business rules
- [ ] **WL-0300** `src/main/java/com/gitgalaxy/modernized/service/Lgdpvs01Service.java:50`: implement from the program's business rules

**`base/src/lgicdb01.cbl`**

- [ ] **WL-0301** `src/main/java/com/gitgalaxy/modernized/service/Lgicdb01Service.java:33`: Implement extracted business rules here
- [ ] **WL-0302** `src/main/java/com/gitgalaxy/modernized/service/Lgicdb01Service.java:36`: implement from the program's business rules
- [ ] **WL-0303** `src/main/java/com/gitgalaxy/modernized/service/Lgicdb01Service.java:42`: implement from the program's business rules

**`base/src/lgicus01.cbl`**

- [ ] **WL-0304** `src/main/java/com/gitgalaxy/modernized/service/Lgicus01Service.java:35`: Implement extracted business rules here
- [ ] **WL-0305** `src/main/java/com/gitgalaxy/modernized/service/Lgicus01Service.java:38`: implement from the program's business rules

**`base/src/lgicvs01.cbl`**

- [ ] **WL-0306** `src/main/java/com/gitgalaxy/modernized/service/Lgicvs01Service.java:48`: Implement extracted business rules here
- [ ] **WL-0307** `src/main/java/com/gitgalaxy/modernized/service/Lgicvs01Service.java:51`: implement from the program's business rules

**`base/src/lgipdb01.cbl`**

- [ ] **WL-0308** `src/main/java/com/gitgalaxy/modernized/service/Lgipdb01Service.java:41`: Implement extracted business rules here
- [ ] **WL-0309** `src/main/java/com/gitgalaxy/modernized/service/Lgipdb01Service.java:44`: implement from the program's business rules
- [ ] **WL-0310** `src/main/java/com/gitgalaxy/modernized/service/Lgipdb01Service.java:50`: implement from the program's business rules

**`base/src/lgipol01.cbl`**

- [ ] **WL-0311** `src/main/java/com/gitgalaxy/modernized/service/Lgipol01Service.java:35`: Implement extracted business rules here
- [ ] **WL-0312** `src/main/java/com/gitgalaxy/modernized/service/Lgipol01Service.java:38`: implement from the program's business rules

**`base/src/lgipvs01.cbl`**

- [ ] **WL-0313** `src/main/java/com/gitgalaxy/modernized/service/Lgipvs01Service.java:42`: Implement extracted business rules here
- [ ] **WL-0314** `src/main/java/com/gitgalaxy/modernized/service/Lgipvs01Service.java:45`: implement from the program's business rules

**`base/src/lgsetup.cbl`**

- [ ] **WL-0315** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:63`: Implement extracted business rules here
- [ ] **WL-0316** `src/main/java/com/gitgalaxy/modernized/service/LgsetupService.java:66`: implement from the program's business rules

**`base/src/lgstsq.cbl`**

- [ ] **WL-0317** `src/main/java/com/gitgalaxy/modernized/service/LgstsqService.java:39`: Implement extracted business rules here
- [ ] **WL-0318** `src/main/java/com/gitgalaxy/modernized/service/LgstsqService.java:42`: implement from the program's business rules

**`base/src/lgtestc1.cbl`**

- [ ] **WL-0319** `src/main/java/com/gitgalaxy/modernized/service/Lgtestc1Service.java:49`: Implement extracted business rules here
- [ ] **WL-0320** `src/main/java/com/gitgalaxy/modernized/service/Lgtestc1Service.java:52`: implement from the program's business rules
- [ ] **WL-0321** `src/main/java/com/gitgalaxy/modernized/service/Lgtestc1Service.java:96`: port paragraph ENDIT's logic
- [ ] **WL-0322** `src/main/java/com/gitgalaxy/modernized/service/Lgtestc1Service.java:100` (`Lgtestc1Service#renderSsmapc1`): port the logic that fills SSMAPC1O before the SEND
  - fact: `base/src/lgtestc1.cbl:64`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestc1.cbl:107`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestc1.cbl:142`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0323** `src/main/java/com/gitgalaxy/modernized/service/Lgtestc1Service.java:108` (`Lgtestc1Service#submitSsmapc1`): port the logic that reads SSMAPC1I after the RECEIVE
  - fact: `base/src/lgtestc1.cbl:79`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestc1.cbl:172`, BMS screen fields (open (3 public / 0 private estates))

**`base/src/lgtestp1.cbl`**

- [ ] **WL-0324** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp1Service.java:39`: Implement extracted business rules here
- [ ] **WL-0325** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp1Service.java:42`: implement from the program's business rules
- [ ] **WL-0326** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp1Service.java:100`: port paragraph ENDIT's logic
- [ ] **WL-0327** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp1Service.java:104` (`Lgtestp1Service#renderSsmapp1`): port the logic that fills SSMAPP1O before the SEND
  - fact: `base/src/lgtestp1.cbl:47`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestp1.cbl:91`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestp1.cbl:129`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0328** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp1Service.java:112` (`Lgtestp1Service#submitSsmapp1`): port the logic that reads SSMAPP1I after the RECEIVE
  - fact: `base/src/lgtestp1.cbl:61`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestp1.cbl:196`, BMS screen fields (open (3 public / 0 private estates))

**`base/src/lgtestp2.cbl`**

- [ ] **WL-0329** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp2Service.java:40`: Implement extracted business rules here
- [ ] **WL-0330** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp2Service.java:43`: implement from the program's business rules
- [ ] **WL-0331** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp2Service.java:101`: port paragraph ENDIT's logic
- [ ] **WL-0332** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp2Service.java:105` (`Lgtestp2Service#renderSsmapp2`): port the logic that fills SSMAPP2O before the SEND
  - fact: `base/src/lgtestp2.cbl:42`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:84`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:119`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0333** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp2Service.java:113` (`Lgtestp2Service#submitSsmapp2`): port the logic that reads SSMAPP2I after the RECEIVE
  - fact: `base/src/lgtestp2.cbl:56`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestp2.cbl:180`, BMS screen fields (open (3 public / 0 private estates))

**`base/src/lgtestp3.cbl`**

- [ ] **WL-0334** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp3Service.java:40`: Implement extracted business rules here
- [ ] **WL-0335** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp3Service.java:43`: implement from the program's business rules
- [ ] **WL-0336** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp3Service.java:101`: port paragraph ENDIT's logic
- [ ] **WL-0337** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp3Service.java:105` (`Lgtestp3Service#renderSsmapp3`): port the logic that fills SSMAPP3O before the SEND
  - fact: `base/src/lgtestp3.cbl:45`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestp3.cbl:86`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestp3.cbl:119`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0338** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp3Service.java:113` (`Lgtestp3Service#submitSsmapp3`): port the logic that reads SSMAPP3I after the RECEIVE
  - fact: `base/src/lgtestp3.cbl:59`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestp3.cbl:179`, BMS screen fields (open (3 public / 0 private estates))

**`base/src/lgtestp4.cbl`**

- [ ] **WL-0339** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp4Service.java:40`: Implement extracted business rules here
- [ ] **WL-0340** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp4Service.java:43`: implement from the program's business rules
- [ ] **WL-0341** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp4Service.java:89`: port paragraph ENDIT's logic
- [ ] **WL-0342** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp4Service.java:93` (`Lgtestp4Service#renderSsmapp4`): port the logic that fills SSMAPP4O before the SEND
  - fact: `base/src/lgtestp4.cbl:52`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestp4.cbl:150`, BMS screen fields (open (3 public / 0 private estates))
  - fact: `base/src/lgtestp4.cbl:191`, BMS screen fields (open (3 public / 0 private estates))
- [ ] **WL-0343** `src/main/java/com/gitgalaxy/modernized/service/Lgtestp4Service.java:101` (`Lgtestp4Service#submitSsmapp4`): port the logic that reads SSMAPP4I after the RECEIVE
  - fact: `base/src/lgtestp4.cbl:66`, BMS screen fields (open (3 public / 0 private estates))

**`base/src/lgucdb01.cbl`**

- [ ] **WL-0344** `src/main/java/com/gitgalaxy/modernized/service/Lgucdb01Service.java:37`: Implement extracted business rules here
- [ ] **WL-0345** `src/main/java/com/gitgalaxy/modernized/service/Lgucdb01Service.java:40`: implement from the program's business rules
- [ ] **WL-0346** `src/main/java/com/gitgalaxy/modernized/service/Lgucdb01Service.java:46`: implement from the program's business rules

**`base/src/lgucus01.cbl`**

- [ ] **WL-0347** `src/main/java/com/gitgalaxy/modernized/service/Lgucus01Service.java:35`: Implement extracted business rules here
- [ ] **WL-0348** `src/main/java/com/gitgalaxy/modernized/service/Lgucus01Service.java:38`: implement from the program's business rules

**`base/src/lgucvs01.cbl`**

- [ ] **WL-0349** `src/main/java/com/gitgalaxy/modernized/service/Lgucvs01Service.java:42`: Implement extracted business rules here
- [ ] **WL-0350** `src/main/java/com/gitgalaxy/modernized/service/Lgucvs01Service.java:45`: implement from the program's business rules
- [ ] **WL-0351** `src/main/java/com/gitgalaxy/modernized/service/Lgucvs01Service.java:51`: implement from the program's business rules

**`base/src/lgupdb01.cbl`**

- [ ] **WL-0352** `src/main/java/com/gitgalaxy/modernized/service/Lgupdb01Service.java:43`: Implement extracted business rules here
- [ ] **WL-0353** `src/main/java/com/gitgalaxy/modernized/service/Lgupdb01Service.java:46`: implement from the program's business rules
- [ ] **WL-0354** `src/main/java/com/gitgalaxy/modernized/service/Lgupdb01Service.java:52`: implement from the program's business rules

**`base/src/lgupol01.cbl`**

- [ ] **WL-0355** `src/main/java/com/gitgalaxy/modernized/service/Lgupol01Service.java:35`: Implement extracted business rules here
- [ ] **WL-0356** `src/main/java/com/gitgalaxy/modernized/service/Lgupol01Service.java:38`: implement from the program's business rules

**`base/src/lgupvs01.cbl`**

- [ ] **WL-0357** `src/main/java/com/gitgalaxy/modernized/service/Lgupvs01Service.java:43`: Implement extracted business rules here
- [ ] **WL-0358** `src/main/java/com/gitgalaxy/modernized/service/Lgupvs01Service.java:46`: implement from the program's business rules
- [ ] **WL-0359** `src/main/java/com/gitgalaxy/modernized/service/Lgupvs01Service.java:52`: implement from the program's business rules

**`base/src/lgwebst5.cbl`**

- [ ] **WL-0360** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:64`: Implement extracted business rules here
- [ ] **WL-0361** `src/main/java/com/gitgalaxy/modernized/service/Lgwebst5Service.java:67`: implement from the program's business rules

<a id="configuration"></a>
## Target configuration (review)

_Resolution:_ Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file.

**`(project configuration)`**

- [ ] **WL-0362** `src/main/resources/application.yml:9`: Update these credentials for your target environment
