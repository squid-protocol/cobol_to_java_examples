# CBACT04C: COBOL vs Java, record by record

`app/cbl/CBACT04C.cbl` from [aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo), run as
job INTCALC step STEP15 (`PARM='2022071800'`), on the same inputs as COBOL under
GnuCOBOL and as the generated Java, every output record diffed field by field, decimals exact.

| Java side | records equal |
|---|---|
| as generated (the stub) | 5 / 105 |
| generated + the hand port in `port/` | **105 / 105** |

- `report_ported.md`, `report_generated.md`: the two runs, every differing field.
- `port/`: the ported service (it replaces the generated one); each block names the COBOL paragraph it ports.
- `case.json`: the program, its datasets (keys, copybooks), PARM and pinned clock. TCATBALF: CardDemo's tcatbal.txt keys (the 50 account / type / category rows) with balances rewritten so the interest arithmetic is exercised -- the corpus ships every balance as zero. The first eight are S9(09)V99's extremes and truncation edges (+-999999999.99, +-0.01, 0, 11.99 / 12.01 / -12.01 around a monthly rate's cent), the rest spread over -50000.00..199999.99. Every other input is the corpus's own data. Derived from CardDemo (Apache-2.0; Copyright Amazon.com, Inc. or its affiliates): LICENSE and NOTICE here are the source's own. #4049 (the test-strengthening loop, tests/tools/strengthen.py, claude-sonnet-5-5; the expected results are the COBOL's own): records appended to ACCTFILE (acctdata.txt), XREFFILE (cardxref.txt), TCATBALF (tcatbal.txt), DISCGRP (discgrp.txt) -- acct51-big-balance-group-a: An 8-digit balance with a group that has its own discount-group records reaches the found-record path and stresses the digit/scale limits of the balance update.; xref-card-for-acct51: Account 51 needs a cross-reference entry so the run continues instead of abending.; tcat51-cat1-half-cent: 0.40 at the 15.00 rate gives interest of exactly 0.005, which truncation and half-up rounding handle differently.; discgrp-a-cat9999-zero-rate: A zero interest rate makes the IF DIS-INT-RATE NOT = 0 test false and skips the interest computation.; acct52-follower-default-group: A later account forces the update and rewrite of account 51, which would otherwise be the last account and never be rewritten.; xref-card-for-acct52: Account 52 needs a cross-reference entry so the run continues instead of abending.; discgrp-blank-cat8-zero-rate: Gives the blank account group a direct zero-rate record, so the lookup succeeds without the default fallback and the zero-rate path is taken.; discgrp-blank-cat9-rate15: Gives the blank account group a direct nonzero-rate record for category 9, so interest is computed from a directly found rate.; tcat-acct3-cat8-zero-rate: Second category record for account 3, which looks up the zero-rate record and skips the interest computation.; tcat-acct3-cat9-half-cent: Same-account follower whose interest is 0.50*15/1200 = 0.00625, which rounds to 0.01 under HALF_UP and truncates to 0.00.; tcat-acct1-cat9-big-round-up: Same-account follower with interest 12499999.999875, which is 12499999.99 truncated and 12500000.00 under HALF_UP, and it also changes the account balance update..

Reproduce, from a GitGalaxy checkout (Docker and a JDK 17 + Maven needed):

```
python tests/tools/mainframe_corpus.py fetch aws-mainframe-modernization-carddemo
python tests/tools/equivalence.py run carddemo-intcalc                    # the port
python tests/tools/equivalence.py run carddemo-intcalc --generated-only   # the stub
```
