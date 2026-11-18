# COCRDSLC: COBOL vs Java, record by record

`app/cbl/COCRDSLC.cbl` from [aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo), run as
job None step None (`PARM='None'`), on the same inputs as COBOL under
GnuCOBOL and as the generated Java, every output record diffed field by field, decimals exact.

| Java side | records equal |
|---|---|
| as generated (the stub) | 0 / 65 |
| generated + the hand port in `port/` | **65 / 65** |

- `report_ported.md`, `report_generated.md`: the two runs, every differing field.
- `port/`: the ported service (it replaces the generated one); each block names the COBOL paragraph it ports.
- `case.json`: the program, its datasets (keys, copybooks), PARM and pinned clock. CardDemo's card detail screen (transaction CCDL, program COCRDSLC): from the menu it sends the empty screen; from the card list it reads the selected card and shows it; re-entered it edits the account and card filters (blank, '*', zero, not numeric), reads the card by number and shows it; PF3 returns to the caller or the menu; any other key acts as ENTER. 9150-GETCARD-BYACCT (the account path) is never performed. Every file is the corpus's own data. Derived from CardDemo (Apache-2.0; Copyright Amazon.com, Inc. or its affiliates): LICENSE and NOTICE here are the source's own.

Reproduce, from a GitGalaxy checkout (Docker and a JDK 17 + Maven needed):

```
python tests/tools/mainframe_corpus.py fetch aws-mainframe-modernization-carddemo
python tests/tools/equivalence.py run carddemo-cardview                    # the port
python tests/tools/equivalence.py run carddemo-cardview --generated-only   # the stub
```
