# COACTVWC: COBOL vs Java, record by record

`app/cbl/COACTVWC.cbl` from [aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo), run as
job None step None (`PARM='None'`), on the same inputs as COBOL under
GnuCOBOL and as the generated Java, every output record diffed field by field, decimals exact.

| Java side | records equal |
|---|---|
| as generated (the stub) | 0 / 97 |
| generated + the hand port in `port/` | **97 / 97** |

- `report_ported.md`, `report_generated.md`: the two runs, every differing field.
- `port/`: the ported service (it replaces the generated one); each block names the COBOL paragraph it ports.
- `case.json`: the program, its datasets (keys, copybooks), PARM and pinned clock. CardDemo's account view (transaction CAVW), pseudo-conversational: entered from the menu it sends the empty screen; re-entered with an account id it reads the card cross-reference (through the CXACAIX alternate index), the account and the customer, and sends them; PF3 returns to the menu. Every file is the corpus's own data. Derived from CardDemo (Apache-2.0; Copyright Amazon.com, Inc. or its affiliates): LICENSE and NOTICE here are the source's own. #4049: *-4049.txt are records appended to CardDemo's own files (a copy of its first account, customer and card cross-reference with the key and a few fields changed: account 51, a group id, a balance of 1,234,567.89; #4443: accounts 52-62 are copies of account 51 whose card cross-reference holds an odd card number), derived from CardDemo's data under the same licence.

Reproduce, from a GitGalaxy checkout (Docker and a JDK 17 + Maven needed):

```
python tests/tools/mainframe_corpus.py fetch aws-mainframe-modernization-carddemo
python tests/tools/equivalence.py run carddemo-acctview                    # the port
python tests/tools/equivalence.py run carddemo-acctview --generated-only   # the stub
```
