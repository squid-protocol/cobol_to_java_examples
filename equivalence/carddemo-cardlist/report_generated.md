# COCRDLIC -- COBOL vs Java (generated), CICS

Case `carddemo-cardlist`: aws-mainframe-modernization-carddemo `app/cbl/COCRDLIC.cbl`, transaction CCLI, clock `2022/07/18 10:30:15.00`. Each scenario is one task; its events (SEND MAP, SEND TEXT, RETURN, XCTL, ABEND) are paired in order and compared field by field -- screen DATA fields and every COMMAREA field; a SEND MAP also its attribute, colour and highlight bytes, cursor and options (X'00' and X'40' are not claimed).

Stub files, from the engine's facts: `CARDDAT` -> AWS.M2.CARDDEMO.CARDDATA.VSAM.KSDS key 16@0

| scenario | events equal | total |
|---|---|---|
| select-invalid-code-on-a-page-ending-at-the-last-card | 0 | 3 |
| account-filter-not-numeric | 0 | 3 |
| account-filter-short | 0 | 3 |
| card-filter-not-numeric | 0 | 3 |
| both-filters-not-numeric | 0 | 3 |
| pf8-next-page | 0 | 3 |
| pf8-to-the-last-page | 0 | 3 |
| pf8-at-the-last-page | 0 | 3 |
| pf8-at-the-last-page-after-enter | 0 | 3 |
| pf20-acts-as-pf8 | 0 | 3 |
| pf7-previous-page | 0 | 3 |
| pf7-back-to-the-first-page | 0 | 3 |
| pf7-at-the-first-page | 0 | 3 |
| pf7-with-account-filter-runs-off-the-top | 0 | 3 |
| select-view | 0 | 2 |
| select-update | 0 | 2 |
| select-lowercase-is-invalid | 0 | 3 |
| select-invalid-code-on-page-2 | 0 | 3 |
| select-two-and-an-invalid-code | 0 | 3 |
| account-filter-with-an-invalid-code | 0 | 3 |
| select-two-rows | 0 | 3 |
| pf3-to-menu | 0 | 2 |
| pf3-xctl-fails | 0 | 3 |
| pf15-acts-as-pf3 | 0 | 2 |
| pf3-on-first-entry-lists | 0 | 2 |
| reenter-context-from-another-program | 0 | 2 |
| pf10-with-a-selection-views | 0 | 2 |
| readnext-io-error-on-the-look-ahead | 0 | 3 |
| readprev-io-error-first | 0 | 3 |
| readprev-io-error-mid-page | 0 | 3 |
| pf8-at-the-last-page-flag-neither-shown-nor-not | 0 | 3 |
| pf8-next-page-carries-return-flag | 0 | 3 |
| pf3-from-menu-stale-first-card-faulting-carddat | 0 | 2 |
| full-commarea-length | 0 | 3 |
| select-view-xctl-fails | 0 | 3 |
| select-update-xctl-fails | 0 | 3 |
| pf8-with-card-filter-skips-to-the-matching-card | 0 | 3 |
| pf8-with-all-zeros-account-filter | 0 | 3 |
| pf8-with-all-zeros-card-filter | 0 | 3 |
| pf8-endbr-invreq | 0 | 2 |
| pf7-endbr-invreq | 0 | 2 |
| pf8-page-ends-exactly-on-the-last-card | 0 | 3 |
| pf8-page-number-zero-no-next-page | 0 | 3 |
| pf7-at-the-first-page-account-filter-matches-nothing | 0 | 3 |
| no-commarea-pf7 | 0 | 2 |
| pf8-back-from-card-view-keeps-the-selected-ids | 0 | 2 |

## COBOL coverage (#4023)

COCRDLIC: not proven; 46 scenarios cover 36/36 paragraphs and 147/149 branches.

Dead (nothing can reach them): `0000-MAIN-EXIT`, `SEND-LONG-TEXT`, `SEND-LONG-TEXT-EXIT`, `SEND-PLAIN-TEXT`, `SEND-PLAIN-TEXT-EXIT`.

Live code no run reached:

- IF at line 757 in `1250-SETUP-ARRAY-ATTRIBS`: never true
- EVALUATE at line 897 in `1400-SETUP-MESSAGE`: `OTHER` never taken

Branch points no path reaches, after a transfer of control (not counted, #4602): IF at line 586.

## select-invalid-code-on-a-page-ending-at-the-last-card: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-filter-not-numeric: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-filter-short: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## card-filter-not-numeric: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## both-filters-not-numeric: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf8-next-page: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf8-to-the-last-page: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf8-at-the-last-page: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf8-at-the-last-page-after-enter: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf20-acts-as-pf8: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf7-previous-page: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf7-back-to-the-first-page: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf7-at-the-first-page: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf7-with-account-filter-runs-off-the-top: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## select-view: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## select-update: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## select-lowercase-is-invalid: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## select-invalid-code-on-page-2: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## select-two-and-an-invalid-code: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## account-filter-with-an-invalid-code: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## select-two-rows: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf3-to-menu: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## pf3-xctl-fails: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
| 3 | (event) | `ABEND` | `None` |

## pf15-acts-as-pf3: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## pf3-on-first-entry-lists: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## reenter-context-from-another-program: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## pf10-with-a-selection-views: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |

## readnext-io-error-on-the-look-ahead: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## readprev-io-error-first: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## readprev-io-error-mid-page: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf8-at-the-last-page-flag-neither-shown-nor-not: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf8-next-page-carries-return-flag: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf3-from-menu-stale-first-card-faulting-carddat: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## full-commarea-length: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## select-view-xctl-fails: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
| 3 | (event) | `ABEND` | `None` |

## select-update-xctl-fails: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `XCTL` | `None` |
| 3 | (event) | `ABEND` | `None` |

## pf8-with-card-filter-skips-to-the-matching-card: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf8-with-all-zeros-account-filter: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf8-with-all-zeros-card-filter: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf8-endbr-invreq: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `ABEND` | `None` |

## pf7-endbr-invreq: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `ABEND` | `None` |

## pf8-page-ends-exactly-on-the-last-card: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf8-page-number-zero-no-next-page: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## pf7-at-the-first-page-account-filter-matches-nothing: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `RECEIVE-MAP` | `None` |
| 2 | (event) | `SEND-MAP` | `None` |
| 3 | (event) | `RETURN` | `None` |

## no-commarea-pf7: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |

## pf8-back-from-card-view-keeps-the-selected-ids: differences

| event | field | COBOL | Java |
|---|---|---|---|
| 1 | (event) | `SEND-MAP` | `None` |
| 2 | (event) | `RETURN` | `None` |
