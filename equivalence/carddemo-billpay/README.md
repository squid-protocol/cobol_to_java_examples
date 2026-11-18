# COBIL00C: COBOL vs Java, record by record

`app/cbl/COBIL00C.cbl` from [aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo), run as
job None step None (`PARM='None'`), on the same inputs as COBOL under
GnuCOBOL and as the generated Java, every output record diffed field by field, decimals exact.

| Java side | records equal |
|---|---|
| as generated (the stub) | 0 / 119 |
| generated + the hand port in `port/` | **119 / 119** |

- `report_ported.md`, `report_generated.md`: the two runs, every differing field.
- `port/`: the ported service (it replaces the generated one); each block names the COBOL paragraph it ports.
- `case.json`: the program, its datasets (keys, copybooks), PARM and pinned clock. CardDemo's bill payment (transaction CB00, program COBIL00C): an account's balance is read FOR UPDATE and shown; on confirmation the whole balance is paid -- a new transaction (the last id + 1, found by a HIGH-VALUES STARTBR and a READPREV; its timestamps from ASKTIME / FORMATTIME at the task's clock) is WRITEn to TRANSACT and the account REWRITten. Each scenario's files are compared after the task. acctdata.txt is CardDemo's own accounts plus one synthetic account, 00000099999, with a zero balance (written for this case) for 'You have nothing to pay...'. Derived from CardDemo (Apache-2.0; Copyright Amazon.com, Inc. or its affiliates): LICENSE and NOTICE here are the source's own.

Reproduce, from a GitGalaxy checkout (Docker and a JDK 17 + Maven needed):

```
python tests/tools/mainframe_corpus.py fetch aws-mainframe-modernization-carddemo
python tests/tools/equivalence.py run carddemo-billpay                    # the port
python tests/tools/equivalence.py run carddemo-billpay --generated-only   # the stub
```
