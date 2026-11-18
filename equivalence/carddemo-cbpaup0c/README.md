# CBPAUP0C: COBOL vs Java, record by record

`app/app-authorization-ims-db2-mq/cbl/CBPAUP0C.cbl` from [aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo), run as
job CBPAUP0J step STEP01 (`PARM='None'`), on the same inputs as COBOL under
GnuCOBOL and as the generated Java, every output record diffed field by field, decimals exact.

| Java side | records equal |
|---|---|
| as generated (the stub) | 0 / 183 |
| generated + the hand port in `port/` | **183 / 183** |

- `report_ported.md`, `report_generated.md`: the two runs, every differing field.
- `port/`: the ported service (it replaces the generated one); each block names the COBOL paragraph it ports.
- `case.json`: the program, its datasets (keys, copybooks), PARM and pinned clock. Job CBPAUP0J step STEP01 (DFSRRC00 PARM='BMP,CBPAUP0C,PSBPAUTB'): IMS enters CBPAUP0C as a BMP, PROCEDURE DIVISION USING the I/O PCB and the one DB PCB of PSB PSBPAUTB (CMPAT=YES, PROCOPT=AP). It reads the PRM-INFO card from SYSIN (expiry 13 days, checkpoint frequency 00002 so CHKP fires, debug N; with 05 expiry days the first summary's DLET answers DJ and the step abends, RC 16, on both sides), walks the pending-authorization database DBPAUTP0 (HIDAM: PAUTSUM0 root, PAUTDTL1 child) with GN / GNP, deletes (DLET) each expired detail and each emptied summary, and takes basic checkpoints (CHKP ID). The database is the corpus's own HD unload (data/EBCDIC/AWS.M2.CARDDEMO.IMSDATA.DBPAUTP0.dat: 22 roots, 202 children), laid out by CIPAUSMY / CIPAUDTY; the step's DISPLAY output, RETURN-CODE and the database as the step leaves it are compared. The DL/I model is register family I (tests/equivalence/ims/ggdli.c, cobolrt/dli/DetDli.java), #5857. Derived from CardDemo (Apache-2.0; Copyright Amazon.com, Inc. or its affiliates): LICENSE and NOTICE here are the source's own.

Reproduce, from a GitGalaxy checkout (Docker and a JDK 17 + Maven needed):

```
python tests/tools/mainframe_corpus.py fetch aws-mainframe-modernization-carddemo
python tests/tools/equivalence.py run carddemo-cbpaup0c                    # the port
python tests/tools/equivalence.py run carddemo-cbpaup0c --generated-only   # the stub
```
