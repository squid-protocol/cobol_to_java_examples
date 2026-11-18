# CBSTM03A: COBOL vs Java, record by record

`app/cbl/CBSTM03A.CBL` from [aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo), run as
job CREASTMT step STEP040 (`PARM='None'`), on the same inputs as COBOL under
GnuCOBOL and as the generated Java, every output record diffed field by field, decimals exact.

| Java side | records equal |
|---|---|
| as generated (the stub) | 0 / 4186 |
| generated + the hand port in `port/` | **4186 / 4186** |

- `report_ported.md`, `report_generated.md`: the two runs, every differing field.
- `port/`: the ported service (it replaces the generated one); each block names the COBOL paragraph it ports.
- `case.json`: the program, its datasets (keys, copybooks), PARM and pinned clock. CardDemo CBSTM03A (job CREASTMT, STEP040), the statement writer: it walks PSA -> TCB -> TIOT to DISPLAY its job, step and DD names (register A2; `mvs_step` states the step, the DDs in CREASTMT.JCL order, on both sides), then drives CBSTM03B (CALLed, compiled and translated as a subprogram) through TRNXFILE, XREFFILE, CUSTFILE and ACCTFILE and writes the plain-text (STMTFILE) and HTML (HTMLFILE) statements, both compared with SYSOUT. TRNXFILE is the first three records of the corpus's dailytran.txt (trnx.txt here); the other three files are the corpus's own data. Derived from CardDemo (Apache-2.0; Copyright Amazon.com, Inc. or its affiliates): LICENSE and NOTICE here are the source's own.

Reproduce, from a GitGalaxy checkout (Docker and a JDK 17 + Maven needed):

```
python tests/tools/mainframe_corpus.py fetch aws-mainframe-modernization-carddemo
python tests/tools/equivalence.py run carddemo-cbstm03a                    # the port
python tests/tools/equivalence.py run carddemo-cbstm03a --generated-only   # the stub
```
