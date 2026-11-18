# Migration worklist

Every TODO the generators left in this project: where a fact was missing or two facts disagreed, the Java says so instead of guessing. Each item names the fact it rests on (from `traceability.json`) and a suggested resolution.

**19 items** across 10 program sources (COBOL, PL/I).

| nature | items | what it takes |
|---|---:|---|
| conflict | 0 | two facts disagree: a person decides which one the Java follows |
| fact-gap | 0 | a fact is missing: supply it and re-run |
| review | 1 | the Java runs as generated: check it on the target |
| port | 18 | business logic to write |

## By category

| category | nature | items | suggested resolution |
|---|---|---:|---|
| [Utility job steps to port](#batch-utility) | port | 7 | Replace the utility with its Spring Batch equivalent (SORT -> a sorting step, IDCAMS REPRO -> a copy, a TSO / IMS runner -> the program's runBatch), reading its control statements in SYSIN. |
| [Calls to other services](#interface-call) | port | 3 | Wire the called service (or a mock) in place of the placeholder. |
| [Business logic to port](#business-logic) | port | 8 | Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch. |
| [Target configuration](#configuration) | review | 1 | Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file. |

## By program source

Listed in port order: the programs the most other code depends on first ([ai_agent_jobs/port_order.md](ai_agent_jobs/port_order.md)).

| source | conflict | fact-gap | review | port | total |
|---|---:|---:|---:|---:|---:|
| 1. `COBOL/SAM2.cbl` |  |  |  | 1 | 1 |
| 2. `COBOL/SAM1.cbl` |  |  |  | 2 | 2 |
| 3. `PLI/PSAM1.pli` |  |  |  | 1 | 1 |
| 4. `multiroot/sam/SAM1.cbl` |  |  |  | 2 | 2 |
| 5. `multiroot/sam/SAM2.cbl` |  |  |  | 1 | 1 |
| 6. `PLI/MACSAMP.pli` |  |  |  | 1 | 1 |
| 7. `PLI/PSAM1LIB.pli` |  |  |  | 1 | 1 |
| 8. `COBOL/SAM1LIB.cbl` |  |  |  | 2 | 2 |
| `JCL/RUN.jcl` |  |  |  | 4 | 4 |
| `JCL/RUNPSAM1.jcl` |  |  |  | 3 | 3 |
| `(project configuration)` |  |  | 1 |  | 1 |

<a id="batch-utility"></a>
## Utility job steps to port (port)

_Resolution:_ Replace the utility with its Spring Batch equivalent (SORT -> a sorting step, IDCAMS REPRO -> a copy, a TSO / IMS runner -> the program's runBatch), reading its control statements in SYSIN.

**`JCL/RUN.jcl`**

- [ ] **WL-0001** `src/main/java/com/gitgalaxy/modernized/batch/ZderunJobConfig.java` (`ZderunJobConfig#CMPLSAM1`): CMPLSAM1 runs the utility IGYCRCTL (its control statements are in SYSIN) -- a utility step to port
  - fact: `JCL/RUN.jcl:72`, JCL job flow (open (5 public / 0 private estates))
- [ ] **WL-0002** `src/main/java/com/gitgalaxy/modernized/batch/ZderunJobConfig.java` (`ZderunJobConfig#CMPLSAM2`): CMPLSAM2 runs the utility IGYCRCTL (its control statements are in SYSIN) -- a utility step to port
  - fact: `JCL/RUN.jcl:42`, JCL job flow (open (5 public / 0 private estates))
- [ ] **WL-0003** `src/main/java/com/gitgalaxy/modernized/batch/ZderunJobConfig.java` (`ZderunJobConfig#LINKSAM1`): LINKSAM1 runs the utility IEWL (its control statements are in SYSIN) -- a utility step to port
  - fact: `JCL/RUN.jcl:120`, JCL job flow (open (5 public / 0 private estates))
- [ ] **WL-0004** `src/main/java/com/gitgalaxy/modernized/batch/ZderunJobConfig.java` (`ZderunJobConfig#LINKSAM2`): LINKSAM2 runs the utility IEWL (its control statements are in SYSIN) -- a utility step to port
  - fact: `JCL/RUN.jcl:103`, JCL job flow (open (5 public / 0 private estates))

**`JCL/RUNPSAM1.jcl`**

- [ ] **WL-0005** `src/main/java/com/gitgalaxy/modernized/batch/Zdepsm1JobConfig.java` (`Zdepsm1JobConfig#CMPPSAM1`): CMPPSAM1 runs the utility IBMZPLI (its control statements are in SYSIN) -- a utility step to port
  - fact: `JCL/RUNPSAM1.jcl:46`, JCL job flow (open (5 public / 0 private estates))
- [ ] **WL-0006** `src/main/java/com/gitgalaxy/modernized/batch/Zdepsm1JobConfig.java` (`Zdepsm1JobConfig#CMPPSAM2`): CMPPSAM2 runs the utility IBMZPLI (its control statements are in SYSIN) -- a utility step to port
  - fact: `JCL/RUNPSAM1.jcl:35`, JCL job flow (open (5 public / 0 private estates))
- [ ] **WL-0007** `src/main/java/com/gitgalaxy/modernized/batch/Zdepsm1JobConfig.java` (`Zdepsm1JobConfig#LNKPSAM1`): LNKPSAM1 runs the utility IEWL (its control statements are in SYSIN) -- a utility step to port
  - fact: `JCL/RUNPSAM1.jcl:59`, JCL job flow (open (5 public / 0 private estates))

<a id="interface-call"></a>
## Calls to other services (port)

_Resolution:_ Wire the called service (or a mock) in place of the placeholder.

**`COBOL/SAM1.cbl`** -- porting ticket [`ai_agent_jobs/COBOL__SAM1_port_ticket.md`](ai_agent_jobs/COBOL__SAM1_port_ticket.md)

- [ ] **WL-0008** `src/main/java/com/gitgalaxy/modernized/service/CobolSam1Service.java:31`: Implement or mock interface call to: Sam2Service

**`COBOL/SAM1LIB.cbl`** -- porting ticket [`ai_agent_jobs/SAM1LIB_port_ticket.md`](ai_agent_jobs/SAM1LIB_port_ticket.md)

- [ ] **WL-0009** `src/main/java/com/gitgalaxy/modernized/service/Sam1libService.java:31`: Implement or mock interface call to: Sam2Service

**`multiroot/sam/SAM1.cbl`** -- porting ticket [`ai_agent_jobs/multiroot__sam__SAM1_port_ticket.md`](ai_agent_jobs/multiroot__sam__SAM1_port_ticket.md)

- [ ] **WL-0010** `src/main/java/com/gitgalaxy/modernized/service/MultirootSamSam1Service.java:32`: Implement or mock interface call to: Sam2Service

<a id="business-logic"></a>
## Business logic to port (port)

_Resolution:_ Port the cited paragraphs; the skeleton names the COBOL lines and the facts they touch.

**`COBOL/SAM1.cbl`** -- porting ticket [`ai_agent_jobs/COBOL__SAM1_port_ticket.md`](ai_agent_jobs/COBOL__SAM1_port_ticket.md)

- [ ] **WL-0011** `src/main/java/com/gitgalaxy/modernized/service/CobolSam1Service.java:52` (`CobolSam1Service#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `JCL/RUN.jcl:147`, JCL job flow (open (5 public / 0 private estates))

**`COBOL/SAM1LIB.cbl`** -- porting ticket [`ai_agent_jobs/SAM1LIB_port_ticket.md`](ai_agent_jobs/SAM1LIB_port_ticket.md)

- [ ] **WL-0012** `src/main/java/com/gitgalaxy/modernized/service/Sam1libService.java:52` (`Sam1libService#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE

**`COBOL/SAM2.cbl`** -- porting ticket [`ai_agent_jobs/COBOL__SAM2_port_ticket.md`](ai_agent_jobs/COBOL__SAM2_port_ticket.md)

- [ ] **WL-0013** `src/main/java/com/gitgalaxy/modernized/service/CobolSam2Service.java:24`: implement from the program's business rules

**`PLI/MACSAMP.pli`** -- porting ticket [`ai_agent_jobs/MACSAMP_port_ticket.md`](ai_agent_jobs/MACSAMP_port_ticket.md)

- [ ] **WL-0014** `src/main/java/com/gitgalaxy/modernized/service/MacsampService.java:23`: Implement extracted business rules here

**`PLI/PSAM1.pli`** -- porting ticket [`ai_agent_jobs/PSAM1_port_ticket.md`](ai_agent_jobs/PSAM1_port_ticket.md)

- [ ] **WL-0015** `src/main/java/com/gitgalaxy/modernized/service/Psam1Service.java:26` (`Psam1Service#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE
  - fact: `JCL/RUNPSAM1.jcl:74`, JCL job flow (open (5 public / 0 private estates))

**`PLI/PSAM1LIB.pli`** -- porting ticket [`ai_agent_jobs/PSAM1LIB_port_ticket.md`](ai_agent_jobs/PSAM1LIB_port_ticket.md)

- [ ] **WL-0016** `src/main/java/com/gitgalaxy/modernized/service/Psam1libService.java:23`: Implement extracted business rules here

**`multiroot/sam/SAM1.cbl`** -- porting ticket [`ai_agent_jobs/multiroot__sam__SAM1_port_ticket.md`](ai_agent_jobs/multiroot__sam__SAM1_port_ticket.md)

- [ ] **WL-0017** `src/main/java/com/gitgalaxy/modernized/service/MultirootSamSam1Service.java:53` (`MultirootSamSam1Service#runBatch`): port the PROCEDURE DIVISION main line; return its RETURN-CODE

**`multiroot/sam/SAM2.cbl`** -- porting ticket [`ai_agent_jobs/multiroot__sam__SAM2_port_ticket.md`](ai_agent_jobs/multiroot__sam__SAM2_port_ticket.md)

- [ ] **WL-0018** `src/main/java/com/gitgalaxy/modernized/service/MultirootSamSam2Service.java:25`: implement from the program's business rules

<a id="configuration"></a>
## Target configuration (review)

_Resolution:_ Point the datasource at the target database; the password comes from SPRING_DATASOURCE_PASSWORD at run time, never from a file.

**`(project configuration)`**

- [ ] **WL-0019** `src/main/resources/application.yml:9`: Update these credentials for your target environment
