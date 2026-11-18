# COCRDLIC: COBOL vs Java, record by record

`app/cbl/COCRDLIC.cbl` from [aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo), run as
job None step None (`PARM='None'`), on the same inputs as COBOL under
GnuCOBOL and as the generated Java, every output record diffed field by field, decimals exact.

| Java side | records equal |
|---|---|
| as generated (the stub) | 0 / 126 |
| generated + the hand port in `port/` | **126 / 126** |

- `report_ported.md`, `report_generated.md`: the two runs, every differing field.
- `port/`: the ported service (it replaces the generated one); each block names the COBOL paragraph it ports.
- `case.json`: the program, its datasets (keys, copybooks), PARM and pinned clock. CardDemo's credit card list (transaction CCLI, program COCRDLIC): seven cards a page browsed from CARDDAT (STARTBR GTEQ / READNEXT, ENDBR), filtered by an optional 11-digit account and 16-digit card number typed on the screen; an eighth READNEXT probes for a next page; PF8 / PF7 page forward from the probed card and back (READPREV) from the page's first; an 'S' or 'U' beside a row XCTLs to the card view (COCRDSLC) or update (COCRDUPC) with that row's account and card; PF3 (or PF15) XCTLs to the main menu; any other key acts as ENTER. The page state and the rows shown travel in the COMMAREA after CARDDEMO-COMMAREA (WS-THIS-PROGCOMMAREA, its rows as WS-ALL-ROWS); the scenarios that start mid-conversation set it as the program itself leaves it. Every file is the corpus's own data, but for `select-invalid-code-on-a-page-ending-at-the-last-card`'s own seed/carddata-7.txt (its first seven cards), so a page can end on the file's last record (50 cards, one per account: seven full pages and an eighth of one card). Defects of the original the scenarios show: a filtered browse starts at the current page's first card, not the file's start, so a card earlier in the file is never found (account-filter-from-page-3-misses-earlier-cards), and once a card filter has been used, clearing it lists from that card (enter-after-clearing-the-card-filter); a selection error browses from a key nothing set (spaces), so page 1's rows come back under the current page number (select-invalid-code-on-page-2); PF7 reports 'NO PREVIOUS PAGES TO DISPLAY' on arriving at page 1, and a filtered PF7 that runs off the start of the file shows an empty page 1 though a matching card exists; the STARTBR's RESP is never tested, so a file that is not open ends in the ENDBR (no RESP) abending with INVREQ; the PF3 / re-entry restart INITIALIZEs CARDDEMO-COMMAREA, user id included. Latent, not reachable with this data: WS-CA-SCREEN-NUM is PIC 9(1), so a tenth page would number 0. Derived from CardDemo (Apache-2.0; Copyright Amazon.com, Inc. or its affiliates): LICENSE and NOTICE here are the source's own.

Reproduce, from a GitGalaxy checkout (Docker and a JDK 17 + Maven needed):

```
python tests/tools/mainframe_corpus.py fetch aws-mainframe-modernization-carddemo
python tests/tools/equivalence.py run carddemo-cardlist                    # the port
python tests/tools/equivalence.py run carddemo-cardlist --generated-only   # the stub
```
