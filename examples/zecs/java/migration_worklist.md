# Migration worklist

Every TODO the generators left in this project: where a fact was missing or two facts disagreed, the Java says so instead of guessing. Each item names the fact it rests on (from `traceability.json`) and a suggested resolution.

**93 items** across 5 program sources (COBOL, PL/I).

| nature | items | what it takes |
|---|---:|---|
| conflict | 0 | two facts disagree: a person decides which one the Java follows |
| fact-gap | 4 | a fact is missing: supply it and re-run |
| review | 74 | the Java runs as generated: check it on the target |
| port | 15 | business logic to write |

## By category

| category | nature | items | suggested resolution |
|---|---|---:|---|
| [Unresolved layouts](#missing-layout) | fact-gap | 1 | Add the missing copybook / %INCLUDE member or record to the repository and re-run; the DTO then gets its real fields. |
| [Data-driven queue names](#queue-name) | fact-gap | 3 | Resolve the name (the MOVEs into the operand, or the installation's symbol table) and pass it: the port takes any queue name. |
| [CICS responses the COBOL never tests](#unchecked-resp) | review | 73 | Decide what a failed call does: the COBOL ignores it, so the Java throws; catch it where the old behaviour (carry on) is really wanted. |
| [Unit-of-work boundaries to split](#transaction-split) | port | 3 | End the transaction at the SYNCPOINT the comment cites: a nested REQUIRES_NEW call, or two service methods. |
| [Calls to other services](#interface-call) | port | 1 | Wire the called service (or a mock) in place of the placeholder. |
| [Business logic to port](#business-logic) | port | 11 | Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch. |
| [Target configuration](#configuration) | review | 1 | Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file. |

## By program source

| source | conflict | fact-gap | review | port | total |
|---|---:|---:|---:|---:|---:|
| `Source/ZECS001.cbl` |  | 1 | 36 | 4 | 41 |
| `Source/ZECS000.cbl` |  | 1 | 22 | 5 | 28 |
| `Source/ZECS003.cbl` |  |  | 8 | 2 | 10 |
| `Source/ZECSPLT.cbl` |  | 1 | 5 | 2 | 8 |
| `Source/ECS001.cbl` |  | 1 | 2 | 2 | 5 |
| `(project configuration)` |  |  | 1 |  | 1 |

<a id="missing-layout"></a>
## Unresolved layouts (fact-gap)

_Resolution:_ Add the missing copybook / %INCLUDE member or record to the repository and re-run; the DTO then gets its real fields.

**`Source/ECS001.cbl`**

- [ ] **WL-0001** `src/main/java/com/gitgalaxy/modernized/controller/Ecs001Controller.java:11` (`Ecs001Controller#link`): no COMMAREA layout: no LINKAGE DFHCOMMAREA, and no resolved caller passes this program a COMMAREA

<a id="queue-name"></a>
## Data-driven queue names (fact-gap)

_Resolution:_ Resolve the name (the MOVEs into the operand, or the installation's symbol table) and pass it: the port takes any queue name.

**`Source/ZECS000.cbl`**

- [ ] **WL-0002** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:116` (`Zecs000Service#writeqTdL780`): @tdq@ is an installation symbol: set the real queue name
  - fact: `Source/ZECS000.cbl:780`, CICS resources (open (5 public / 0 private estates))

**`Source/ZECS001.cbl`**

- [ ] **WL-0003** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:125` (`Zecs001Service#writeqTdL2137`): @tdq@ is an installation symbol: set the real queue name
  - fact: `Source/ZECS001.cbl:2137`, CICS resources (open (5 public / 0 private estates))

**`Source/ZECSPLT.cbl`**

- [ ] **WL-0004** `src/main/java/com/gitgalaxy/modernized/service/ZecspltService.java:42` (`ZecspltService#writeqTdL135`): @tdq@ is an installation symbol: set the real queue name
  - fact: `Source/ZECSPLT.cbl:135`, CICS resources (open (5 public / 0 private estates))

<a id="unchecked-resp"></a>
## CICS responses the COBOL never tests (review)

_Resolution:_ Decide what a failed call does: the COBOL ignores it, so the Java throws; catch it where the old behaviour (carry on) is really wanted.

**`Source/ECS001.cbl`**

- [ ] **WL-0005** `src/main/java/com/gitgalaxy/modernized/service/Ecs001Service.java:16` (`Ecs001Service`): the RESP of WEB at line 243 (paragraph A4000-EXECUTE-SERVICE) is never tested
  - fact: `Source/ECS001.cbl:243`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0006** `src/main/java/com/gitgalaxy/modernized/service/Ecs001Service.java:17` (`Ecs001Service`): the RESP of SEND at line 411 (paragraph Z1000-EXIT-PROGRAM) is never tested
  - fact: `Source/ECS001.cbl:411`, units of work and handlers (field-tested (6 public / 0 private estates))

**`Source/ZECS000.cbl`**

- [ ] **WL-0007** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:28` (`Zecs000Service`): the RESP of RETRIEVE at line 257 (paragraph 1000-RETRIEVE) is never tested
  - fact: `Source/ZECS000.cbl:257`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0008** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:29` (`Zecs000Service`): the RESP of ASKTIME at line 269 (paragraph 1000-RETRIEVE) is never tested
  - fact: `Source/ZECS000.cbl:269`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0009** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:30` (`Zecs000Service`): the RESP of FORMATTIME at line 333 (paragraph 1300-WRITE) is never tested
  - fact: `Source/ZECS000.cbl:333`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0010** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:31` (`Zecs000Service`): the RESP of FORMATTIME at line 368 (paragraph 1400-UPDATE) is never tested
  - fact: `Source/ZECS000.cbl:368`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0011** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:32` (`Zecs000Service`): the RESP of REWRITE at line 389 (paragraph 1400-UPDATE) is never tested
  - fact: `Source/ZECS000.cbl:389`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0012** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:33` (`Zecs000Service`): the RESP of REWRITE at line 498 (paragraph 3110-REWRITE) is never tested
  - fact: `Source/ZECS000.cbl:498`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0013** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:34` (`Zecs000Service`): the RESP of SYNCPOINT at line 504 (paragraph 3110-REWRITE) is never tested
  - fact: `Source/ZECS000.cbl:504`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0014** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:35` (`Zecs000Service`): the RESP of DELETE at line 525 (paragraph 3200-DELETE) is never tested
  - fact: `Source/ZECS000.cbl:525`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0015** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:36` (`Zecs000Service`): the RESP of DELETE at line 546 (paragraph 3210-DELETE) is never tested
  - fact: `Source/ZECS000.cbl:546`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0016** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:37` (`Zecs000Service`): the RESP of SYNCPOINT at line 560 (paragraph 3220-SYNCPOINT) is never tested
  - fact: `Source/ZECS000.cbl:560`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0017** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:38` (`Zecs000Service`): the RESP of DELAY at line 563 (paragraph 3220-SYNCPOINT) is never tested
  - fact: `Source/ZECS000.cbl:563`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0018** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:39` (`Zecs000Service`): the RESP of WEB at line 625 (paragraph 7100-WEB-OPEN) is never tested
  - fact: `Source/ZECS000.cbl:625`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0019** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:40` (`Zecs000Service`): the RESP of INQUIRE at line 651 (paragraph 7200-WEB-CONVERSE) is never tested
  - fact: `Source/ZECS000.cbl:651`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0020** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:41` (`Zecs000Service`): the RESP of WEB at line 672 (paragraph 7200-WEB-CONVERSE) is never tested
  - fact: `Source/ZECS000.cbl:672`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0021** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:42` (`Zecs000Service`): the RESP of WEB at line 696 (paragraph 7300-WEB-CLOSE) is never tested
  - fact: `Source/ZECS000.cbl:696`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0022** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:43` (`Zecs000Service`): the RESP of START at line 713 (paragraph 8000-RESTART) is never tested
  - fact: `Source/ZECS000.cbl:713`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0023** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:44` (`Zecs000Service`): the RESP of START at line 732 (paragraph 8100-RESTART) is never tested
  - fact: `Source/ZECS000.cbl:732`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0024** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:45` (`Zecs000Service`): the RESP of FORMATTIME at line 771 (paragraph 9900-WRITE-CSSL) is never tested
  - fact: `Source/ZECS000.cbl:771`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0025** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:46` (`Zecs000Service`): the RESP of WRITEQ at line 780 (paragraph 9900-WRITE-CSSL) is never tested
  - fact: `Source/ZECS000.cbl:780`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0026** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:47` (`Zecs000Service`): the RESP of ASKTIME at line 793 (paragraph 9950-ABS) is never tested
  - fact: `Source/ZECS000.cbl:793`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0027** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:48` (`Zecs000Service`): the RESP of DOCUMENT at line 810 (paragraph 9999-GET-URL) is never tested
  - fact: `Source/ZECS000.cbl:810`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0028** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java` (`Zecs000Service`): the RESP of WEB at line 827 (paragraph 9999-GET-URL) is never tested
  - fact: `Source/ZECS000.cbl:827`, units of work and handlers (field-tested (6 public / 0 private estates))

**`Source/ZECS001.cbl`**

- [ ] **WL-0029** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:35` (`Zecs001Service`): the RESP of WEB at line 467 (paragraph 1000-ACCESS-PARMS) is never tested
  - fact: `Source/ZECS001.cbl:467`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0030** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:36` (`Zecs001Service`): the RESP of WEB at line 530 (paragraph 1000-ACCESS-PARMS) is never tested
  - fact: `Source/ZECS001.cbl:530`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0031** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:37` (`Zecs001Service`): the RESP of DOCUMENT at line 652 (paragraph 1210-ZCXXSD) is never tested
  - fact: `Source/ZECS001.cbl:652`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0032** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:38` (`Zecs001Service`): the RESP of INQUIRE at line 731 (paragraph 1312-CHECK-ETTL) is never tested
  - fact: `Source/ZECS001.cbl:731`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0033** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:39` (`Zecs001Service`): the RESP of XCTL at line 753 (paragraph 1320-CLEAR) is never tested
  - fact: `Source/ZECS001.cbl:753`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0034** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:40` (`Zecs001Service`): the RESP of LINK at line 795 (paragraph 1500-AUTHENTICATE) is never tested
  - fact: `Source/ZECS001.cbl:795`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0035** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:41` (`Zecs001Service`): the RESP of READ at line 1011 (paragraph 3300-READ-FILE) is never tested
  - fact: `Source/ZECS001.cbl:1011`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0036** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:42` (`Zecs001Service`): the RESP of REWRITE at line 1023 (paragraph 3300-READ-FILE) is never tested
  - fact: `Source/ZECS001.cbl:1023`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0037** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:43` (`Zecs001Service`): the RESP of GETMAIN at line 1104 (paragraph 3400-STAGE) is never tested
  - fact: `Source/ZECS001.cbl:1104`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0038** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:44` (`Zecs001Service`): the RESP of FREEMAIN at line 1180 (paragraph 3510-FREEMAIN) is never tested
  - fact: `Source/ZECS001.cbl:1180`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0039** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:45` (`Zecs001Service`): the RESP of WEB at line 1214 (paragraph 3600-SEND-RESPONSE) is never tested
  - fact: `Source/ZECS001.cbl:1214`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0040** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of ASKTIME at line 1730 (paragraph 5600-CHECK-TTL) is never tested
  - fact: `Source/ZECS001.cbl:1730`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0041** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of ASKTIME at line 2150 (paragraph 9950-ABS) is never tested
  - fact: `Source/ZECS001.cbl:2150`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0042** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of DELETE at line 1572 (paragraph 4700-DELETE) is never tested
  - fact: `Source/ZECS001.cbl:1572`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0043** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of DELETE at line 1614 (paragraph 5100-DELETE-KEY) is never tested
  - fact: `Source/ZECS001.cbl:1614`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0044** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of DELETE at line 1631 (paragraph 5200-DELETE-FILE) is never tested
  - fact: `Source/ZECS001.cbl:1631`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0045** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of DOCUMENT at line 2081 (paragraph 9700-STATUS-204) is never tested
  - fact: `Source/ZECS001.cbl:2081`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0046** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of FORMATTIME at line 2128 (paragraph 9900-WRITE-CSSL) is never tested
  - fact: `Source/ZECS001.cbl:2128`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0047** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of GET at line 1246 (paragraph 4000-GET-COUNTER) is never tested
  - fact: `Source/ZECS001.cbl:1246`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0048** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of SYNCPOINT at line 1444 (paragraph 4300-SEND-RESPONSE) is never tested
  - fact: `Source/ZECS001.cbl:1444`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0049** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of SYNCPOINT at line 2160 (paragraph 9999-ROLLBACK) is never tested
  - fact: `Source/ZECS001.cbl:2160`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0050** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 1225 (paragraph 3600-SEND-RESPONSE) is never tested
  - fact: `Source/ZECS001.cbl:1225`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0051** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 1659 (paragraph 5300-SEND-RESPONSE) is never tested
  - fact: `Source/ZECS001.cbl:1659`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0052** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 1759 (paragraph 5700-SEND-ABS) is never tested
  - fact: `Source/ZECS001.cbl:1759`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0053** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 1830 (paragraph 8100-WEB-OPEN) is never tested
  - fact: `Source/ZECS001.cbl:1830`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0054** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 1861 (paragraph 8200-WEB-CONVERSE) is never tested
  - fact: `Source/ZECS001.cbl:1861`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0055** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 1882 (paragraph 8200-WEB-CONVERSE) is never tested
  - fact: `Source/ZECS001.cbl:1882`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0056** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 1903 (paragraph 8200-WEB-CONVERSE) is never tested
  - fact: `Source/ZECS001.cbl:1903`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0057** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 1927 (paragraph 8300-WEB-CLOSE) is never tested
  - fact: `Source/ZECS001.cbl:1927`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0058** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 1951 (paragraph 9001-ACAO) is never tested
  - fact: `Source/ZECS001.cbl:1951`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0059** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 2017 (paragraph 9400-STATUS-400) is never tested
  - fact: `Source/ZECS001.cbl:2017`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0060** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 2040 (paragraph 9500-STATUS-409) is never tested
  - fact: `Source/ZECS001.cbl:2040`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0061** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 2062 (paragraph 9600-AUTH-ERROR) is never tested
  - fact: `Source/ZECS001.cbl:2062`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0062** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 2087 (paragraph 9700-STATUS-204) is never tested
  - fact: `Source/ZECS001.cbl:2087`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0063** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WEB at line 2108 (paragraph 9800-STATUS-507) is never tested
  - fact: `Source/ZECS001.cbl:2108`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0064** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java` (`Zecs001Service`): the RESP of WRITEQ at line 2137 (paragraph 9900-WRITE-CSSL) is never tested
  - fact: `Source/ZECS001.cbl:2137`, units of work and handlers (field-tested (6 public / 0 private estates))

**`Source/ZECS003.cbl`**

- [ ] **WL-0065** `src/main/java/com/gitgalaxy/modernized/service/Zecs003Service.java:16` (`Zecs003Service`): the RESP of ASKTIME at line 196 (paragraph 1000-INITIALIZE) is never tested
  - fact: `Source/ZECS003.cbl:196`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0066** `src/main/java/com/gitgalaxy/modernized/service/Zecs003Service.java:17` (`Zecs003Service`): the RESP of DELETE at line 272 (paragraph 3100-DELETE) is never tested
  - fact: `Source/ZECS003.cbl:272`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0067** `src/main/java/com/gitgalaxy/modernized/service/Zecs003Service.java:18` (`Zecs003Service`): the RESP of DELETE at line 279 (paragraph 3100-DELETE) is never tested
  - fact: `Source/ZECS003.cbl:279`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0068** `src/main/java/com/gitgalaxy/modernized/service/Zecs003Service.java:19` (`Zecs003Service`): the RESP of WEB at line 355 (paragraph 7100-WEB-OPEN) is never tested
  - fact: `Source/ZECS003.cbl:355`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0069** `src/main/java/com/gitgalaxy/modernized/service/Zecs003Service.java:20` (`Zecs003Service`): the RESP of INQUIRE at line 378 (paragraph 7200-WEB-CONVERSE) is never tested
  - fact: `Source/ZECS003.cbl:378`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0070** `src/main/java/com/gitgalaxy/modernized/service/Zecs003Service.java:21` (`Zecs003Service`): the RESP of WEB at line 400 (paragraph 7200-WEB-CONVERSE) is never tested
  - fact: `Source/ZECS003.cbl:400`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0071** `src/main/java/com/gitgalaxy/modernized/service/Zecs003Service.java:22` (`Zecs003Service`): the RESP of WEB at line 426 (paragraph 7300-WEB-CLOSE) is never tested
  - fact: `Source/ZECS003.cbl:426`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0072** `src/main/java/com/gitgalaxy/modernized/service/Zecs003Service.java:23` (`Zecs003Service`): the RESP of WEB at line 440 (paragraph 8000-SEND-RESPONSE) is never tested
  - fact: `Source/ZECS003.cbl:440`, units of work and handlers (field-tested (6 public / 0 private estates))

**`Source/ZECSPLT.cbl`**

- [ ] **WL-0073** `src/main/java/com/gitgalaxy/modernized/service/ZecspltService.java:14` (`ZecspltService`): the RESP of INQUIRE at line 77 (paragraph 1000-INQUIRE-START) is never tested
  - fact: `Source/ZECSPLT.cbl:77`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0074** `src/main/java/com/gitgalaxy/modernized/service/ZecspltService.java:15` (`ZecspltService`): the RESP of START at line 126 (paragraph 2200-START) is never tested
  - fact: `Source/ZECSPLT.cbl:126`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0075** `src/main/java/com/gitgalaxy/modernized/service/ZecspltService.java:16` (`ZecspltService`): the RESP of WRITEQ at line 135 (paragraph 2200-START) is never tested
  - fact: `Source/ZECSPLT.cbl:135`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0076** `src/main/java/com/gitgalaxy/modernized/service/ZecspltService.java:17` (`ZecspltService`): the RESP of WRITE at line 141 (paragraph 2200-START) is never tested
  - fact: `Source/ZECSPLT.cbl:141`, units of work and handlers (field-tested (6 public / 0 private estates))
- [ ] **WL-0077** `src/main/java/com/gitgalaxy/modernized/service/ZecspltService.java:18` (`ZecspltService`): the RESP of INQUIRE at line 153 (paragraph 3000-INQUIRE-END) is never tested
  - fact: `Source/ZECSPLT.cbl:153`, units of work and handlers (field-tested (6 public / 0 private estates))

<a id="transaction-split"></a>
## Unit-of-work boundaries to split (port)

_Resolution:_ End the transaction at the SYNCPOINT the comment cites: a nested REQUIRES_NEW call, or two service methods.

**`Source/ZECS000.cbl`**

- [ ] **WL-0078** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:92`: split the transaction here
- [ ] **WL-0079** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:102`: split the transaction here

**`Source/ZECS001.cbl`**

- [ ] **WL-0080** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:112`: split the transaction here

<a id="interface-call"></a>
## Calls to other services (port)

_Resolution:_ Wire the called service (or a mock) in place of the placeholder.

**`Source/ZECS001.cbl`**

- [ ] **WL-0081** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:59`: Implement or mock interface call to: ZuidstckService

<a id="business-logic"></a>
## Business logic to port (port)

_Resolution:_ Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch.

**`Source/ECS001.cbl`**

- [ ] **WL-0082** `src/main/java/com/gitgalaxy/modernized/service/Ecs001Service.java:28`: Implement extracted business rules here
- [ ] **WL-0083** `src/main/java/com/gitgalaxy/modernized/service/Ecs001Service.java:31`: implement from the program's business rules

**`Source/ZECS000.cbl`**

- [ ] **WL-0084** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:63`: Implement extracted business rules here
- [ ] **WL-0085** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:66`: implement from the program's business rules
- [ ] **WL-0086** `src/main/java/com/gitgalaxy/modernized/service/Zecs000Service.java:111`: port paragraph 9100-ABEND's logic

**`Source/ZECS001.cbl`**

- [ ] **WL-0087** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:63`: Implement extracted business rules here
- [ ] **WL-0088** `src/main/java/com/gitgalaxy/modernized/service/Zecs001Service.java:66`: implement from the program's business rules

**`Source/ZECS003.cbl`**

- [ ] **WL-0089** `src/main/java/com/gitgalaxy/modernized/service/Zecs003Service.java:34`: Implement extracted business rules here
- [ ] **WL-0090** `src/main/java/com/gitgalaxy/modernized/service/Zecs003Service.java:37`: implement from the program's business rules

**`Source/ZECSPLT.cbl`**

- [ ] **WL-0091** `src/main/java/com/gitgalaxy/modernized/service/ZecspltService.java:31`: Implement extracted business rules here
- [ ] **WL-0092** `src/main/java/com/gitgalaxy/modernized/service/ZecspltService.java:34`: implement from the program's business rules

<a id="configuration"></a>
## Target configuration (review)

_Resolution:_ Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file.

**`(project configuration)`**

- [ ] **WL-0093** `src/main/resources/application.yml:9`: Update these credentials for your target environment
