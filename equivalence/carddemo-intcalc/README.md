# CBACT04C: COBOL vs Java, record by record

`app/cbl/CBACT04C.cbl` from [aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo), run as
job INTCALC step STEP15 (`PARM='2022071800'`), on the same inputs as COBOL under
GnuCOBOL and as the generated Java, every output record diffed field by field, decimals exact.

| Java side | records equal |
|---|---|
| as generated (the stub) | 4 / 100 |
| generated + the hand port in `port/` | **100 / 100** |

- `report_ported.md`, `report_generated.md`: the two runs, every differing field.
- `port/`: the ported service (it replaces the generated one); each block names the COBOL paragraph it ports.
- `case.json`: the program, its datasets (keys, copybooks), PARM and pinned clock. TCATBALF: CardDemo's tcatbal.txt keys (the 50 account / type / category rows) with balances rewritten so the interest arithmetic is exercised -- the corpus ships every balance as zero. The first eight are S9(09)V99's extremes and truncation edges (+-999999999.99, +-0.01, 0, 11.99 / 12.01 / -12.01 around a monthly rate's cent), the rest spread over -50000.00..199999.99. Every other input is the corpus's own data. Derived from CardDemo (Apache-2.0; Copyright Amazon.com, Inc. or its affiliates): LICENSE and NOTICE here are the source's own.

Reproduce, from a GitGalaxy checkout (Docker and a JDK 17 + Maven needed):

```
python tests/tools/mainframe_corpus.py fetch aws-mainframe-modernization-carddemo
python tests/tools/equivalence.py run carddemo-intcalc                    # the port
python tests/tools/equivalence.py run carddemo-intcalc --generated-only   # the stub
```
