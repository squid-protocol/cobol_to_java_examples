# COCRDLIC -- COBOL vs Java (ported), CICS

Case `carddemo-cardlist`: aws-mainframe-modernization-carddemo `app/cbl/COCRDLIC.cbl`, transaction CCLI, clock `2022/07/18 10:30:15.00`. Each scenario is one task; its events (SEND MAP, SEND TEXT, RETURN, XCTL, ABEND) are paired in order and compared field by field -- screen DATA fields and every COMMAREA field; a SEND MAP also its attribute, colour and highlight bytes, cursor and options (X'00' and X'40' are not claimed).

Stub files, from the engine's facts: `CARDDAT` -> AWS.M2.CARDDEMO.CARDDATA.VSAM.KSDS key 16@0

| scenario | events equal | total |
|---|---|---|
| select-invalid-code-on-a-page-ending-at-the-last-card | 3 | 3 |
| account-filter-not-numeric | 3 | 3 |
| account-filter-short | 3 | 3 |
| card-filter-not-numeric | 3 | 3 |
| both-filters-not-numeric | 3 | 3 |
| pf8-next-page | 3 | 3 |
| pf8-to-the-last-page | 3 | 3 |
| pf8-at-the-last-page | 3 | 3 |
| pf8-at-the-last-page-after-enter | 3 | 3 |
| pf20-acts-as-pf8 | 3 | 3 |
| pf7-previous-page | 3 | 3 |
| pf7-back-to-the-first-page | 3 | 3 |
| pf7-at-the-first-page | 3 | 3 |
| pf7-with-account-filter-runs-off-the-top | 3 | 3 |
| select-view | 2 | 2 |
| select-update | 2 | 2 |
| select-lowercase-is-invalid | 3 | 3 |
| select-invalid-code-on-page-2 | 3 | 3 |
| select-two-and-an-invalid-code | 3 | 3 |
| account-filter-with-an-invalid-code | 3 | 3 |
| select-two-rows | 3 | 3 |
| pf3-to-menu | 2 | 2 |
| pf3-xctl-fails | 3 | 3 |
| pf15-acts-as-pf3 | 2 | 2 |
| pf3-on-first-entry-lists | 2 | 2 |
| reenter-context-from-another-program | 2 | 2 |
| pf10-with-a-selection-views | 2 | 2 |
| readnext-io-error-on-the-look-ahead | 3 | 3 |
| readprev-io-error-first | 3 | 3 |
| readprev-io-error-mid-page | 3 | 3 |
| pf8-at-the-last-page-flag-neither-shown-nor-not | 3 | 3 |
| pf8-next-page-carries-return-flag | 3 | 3 |
| pf3-from-menu-stale-first-card-faulting-carddat | 2 | 2 |
| full-commarea-length | 3 | 3 |
| select-view-xctl-fails | 3 | 3 |
| select-update-xctl-fails | 3 | 3 |
| pf8-with-card-filter-skips-to-the-matching-card | 3 | 3 |
| pf8-with-all-zeros-account-filter | 3 | 3 |
| pf8-with-all-zeros-card-filter | 3 | 3 |
| pf8-endbr-invreq | 2 | 2 |
| pf7-endbr-invreq | 2 | 2 |
| pf8-page-ends-exactly-on-the-last-card | 3 | 3 |
| pf8-page-number-zero-no-next-page | 3 | 3 |
| pf7-at-the-first-page-account-filter-matches-nothing | 3 | 3 |
| no-commarea-pf7 | 2 | 2 |
| pf8-back-from-card-view-keeps-the-selected-ids | 2 | 2 |

## Through the deployed entry points (java-facade, #4449)

Every scenario once more, entered through the program's Spring facade with the scenario's task handed to it through the joined region.

| scenario | events equal | total | entered by | verdict |
|---|---|---|---|---|
| select-invalid-code-on-a-page-ending-at-the-last-card | 3 | 3 | COCRDLIC.handleTransaction | pass |
| account-filter-not-numeric | 3 | 3 | COCRDLIC.handleTransaction | pass |
| account-filter-short | 3 | 3 | COCRDLIC.handleTransaction | pass |
| card-filter-not-numeric | 3 | 3 | COCRDLIC.handleTransaction | pass |
| both-filters-not-numeric | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf8-next-page | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf8-to-the-last-page | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf8-at-the-last-page | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf8-at-the-last-page-after-enter | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf20-acts-as-pf8 | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf7-previous-page | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf7-back-to-the-first-page | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf7-at-the-first-page | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf7-with-account-filter-runs-off-the-top | 3 | 3 | COCRDLIC.handleTransaction | pass |
| select-view | 2 | 2 | COCRDLIC.handleTransaction | pass |
| select-update | 2 | 2 | COCRDLIC.handleTransaction | pass |
| select-lowercase-is-invalid | 3 | 3 | COCRDLIC.handleTransaction | pass |
| select-invalid-code-on-page-2 | 3 | 3 | COCRDLIC.handleTransaction | pass |
| select-two-and-an-invalid-code | 3 | 3 | COCRDLIC.handleTransaction | pass |
| account-filter-with-an-invalid-code | 3 | 3 | COCRDLIC.handleTransaction | pass |
| select-two-rows | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf3-to-menu | 2 | 2 | COCRDLIC.handleTransaction | pass |
| pf3-xctl-fails | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf15-acts-as-pf3 | 2 | 2 | COCRDLIC.handleTransaction | pass |
| pf3-on-first-entry-lists | 2 | 2 | COCRDLIC.handleTransaction | pass |
| reenter-context-from-another-program | 2 | 2 | COCRDLIC.handleTransaction | pass |
| pf10-with-a-selection-views | 2 | 2 | COCRDLIC.handleTransaction | pass |
| readnext-io-error-on-the-look-ahead | 3 | 3 | COCRDLIC.handleTransaction | pass |
| readprev-io-error-first | 3 | 3 | COCRDLIC.handleTransaction | pass |
| readprev-io-error-mid-page | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf8-at-the-last-page-flag-neither-shown-nor-not | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf8-next-page-carries-return-flag | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf3-from-menu-stale-first-card-faulting-carddat | 2 | 2 | COCRDLIC.handleTransaction | pass |
| full-commarea-length | 3 | 3 | COCRDLIC.handleTransaction | pass |
| select-view-xctl-fails | 3 | 3 | COCRDLIC.handleTransaction | pass |
| select-update-xctl-fails | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf8-with-card-filter-skips-to-the-matching-card | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf8-with-all-zeros-account-filter | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf8-with-all-zeros-card-filter | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf8-endbr-invreq | 2 | 2 | COCRDLIC.handleTransaction | pass |
| pf7-endbr-invreq | 2 | 2 | COCRDLIC.handleTransaction | pass |
| pf8-page-ends-exactly-on-the-last-card | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf8-page-number-zero-no-next-page | 3 | 3 | COCRDLIC.handleTransaction | pass |
| pf7-at-the-first-page-account-filter-matches-nothing | 3 | 3 | COCRDLIC.handleTransaction | pass |
| no-commarea-pf7 | 2 | 2 | COCRDLIC.handleTransaction | pass |
| pf8-back-from-card-view-keeps-the-selected-ids | 2 | 2 | COCRDLIC.handleTransaction | pass |

## COBOL coverage (#4023)

COCRDLIC: proven on 46 scenarios, covering 36/36 paragraphs and 147/149 branches.

Dead (nothing can reach them): `0000-MAIN-EXIT`, `SEND-LONG-TEXT`, `SEND-LONG-TEXT-EXIT`, `SEND-PLAIN-TEXT`, `SEND-PLAIN-TEXT-EXIT`.

Live code no run reached:

- IF at line 757 in `1250-SETUP-ARRAY-ATTRIBS`: never true
- EVALUATE at line 897 in `1400-SETUP-MESSAGE`: `OTHER` never taken

Branch points no path reaches, after a transfer of control (not counted, #4602): IF at line 586.
