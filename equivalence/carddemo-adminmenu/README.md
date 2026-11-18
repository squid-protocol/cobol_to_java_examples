# COADM01C: COBOL vs Java, record by record

`app/cbl/COADM01C.cbl` from [aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo), run as
job None step None (`PARM='None'`), on the same inputs as COBOL under
GnuCOBOL and as the generated Java, every output record diffed field by field, decimals exact.

| Java side | records equal |
|---|---|
| as generated (the stub) | 0 / 88 |
| generated + the hand port in `port/` | **88 / 88** |

- `report_ported.md`, `report_generated.md`: the two runs, every differing field.
- `port/`: the ported service (it replaces the generated one); each block names the COBOL paragraph it ports.
- `case.json`: the program, its datasets (keys, copybooks), PARM and pinned clock. CardDemo's admin menu (transaction CA00, program COADM01C): it lists the six options of COADM02Y and XCTLs to the chosen program; an option outside 1-6 or zero is refused (OPTION is a NUM field, which a 3270 cannot key letters into, so no scenario types a non-numeric option, #5116). Options 5 and 6 (COTRTLIC, COTRTUPC) belong to CardDemo's optional DB2 module, which the base CSD (app/csd/CARDDEMO.CSD, named by the case) does not define, so their XCTL raises PGMIDERR and the program's HANDLE CONDITION label answers 'This option is not installed ...'. Derived from CardDemo (Apache-2.0; Copyright Amazon.com, Inc. or its affiliates): LICENSE and NOTICE here are the source's own.

Reproduce, from a GitGalaxy checkout (Docker and a JDK 17 + Maven needed):

```
python tests/tools/mainframe_corpus.py fetch aws-mainframe-modernization-carddemo
python tests/tools/equivalence.py run carddemo-adminmenu                    # the port
python tests/tools/equivalence.py run carddemo-adminmenu --generated-only   # the stub
```
