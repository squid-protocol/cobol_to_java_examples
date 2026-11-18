# CBPAUP0C -- COBOL vs Java (ported)

Case `carddemo-cbpaup0c`: aws-mainframe-modernization-carddemo `app/app-authorization-ims-db2-mq/cbl/CBPAUP0C.cbl`, job CBPAUP0J step STEP01, PARM `None`, clock `2023/11/01 10:30:15.00`.

RETURN-CODE: COBOL `0`, Java `0`.

Key order covered: ASCII / ISO-8859-1 byte order on both sides (GnuCOBOL BDB, H2), not the mainframe's EBCDIC order.

| output | records equal | total | FILLER differs (not compared) |
|---|---|---|---|
| IMS DBPAUTP0 | 183 | 183 | 0 |

| JVM environment | locale | time zone | equal to COBOL |
|---|---|---|---|
| default | en-US | UTC | yes |

## Fault runs

Each run injects file statuses on both sides at the same statement (tests/equivalence/faults/ggfault.c for GnuCOBOL, the generated CobolFiles for Java) and is proven like the normal run: the same abend, or the same RETURN-CODE and outputs, and the same faults fired.

| fault | plan (DD OP NTH STATUS) | why | outcome | equal |
|---|---|---|---|---|
| debug-on | `SYSIN 13 00002 00005 Y` | #5857: the debug flag Y: every DL/I call DISPLAYs its segment (the DEBUG-ON branches) | both end RETURN-CODE 0 | yes |
| card-defaults | `SYSIN 13` | #5857: a card with only the expiry: the checkpoint frequency and display frequency default to 5 and 10 | both end RETURN-CODE 0 | yes |
| nothing-expires | `SYSIN 99 00002 00005 N` | #5857: an expiry no authorization reaches: no DLET, no emptied summary (the NOT-QUALIFIED-FOR-DELETE branch) | both end RETURN-CODE 0 | yes |
| expiry-abend | `SYSIN 05 00002 00005 N` | #5857: with 5 expiry days the first summary's DLET answers DJ and the step abends (RC 16) on both sides | both end RETURN-CODE 16 | yes |
| gn-error | `# DLI GN 2 AM` | #5857: the summary GN answers AM: AUTH SUMMARY READ FAILED and the step abends | both end RETURN-CODE 16 | yes |
| gnp-error | `# DLI GNP 3 AM` | #5857: the detail GNP answers AM: AUTH DETAIL READ FAILED and the step abends | both end RETURN-CODE 16 | yes |
| dlet-detail-error | `# DLI DLET 1 AM` | #5857: the first detail DLET answers AM: AUTH DETAIL DELETE FAILED and the step abends | both end RETURN-CODE 16 | yes |
| chkp-error | `# DLI CHKP 1 AM` | #5857: the first CHKP answers AM: CHKP FAILED and the step abends | both end RETURN-CODE 16 | yes |
| debug-expiry-abend | `SYSIN 05 00002 00005 Y` | #5857: with the debug flag the summary DLET DISPLAYs first, then answers DJ and the step abends | both end RETURN-CODE 16 | yes |
| checkpoint-display-compare | `SYSIN 13 00002 0000  N` | #5857: a display frequency of 0000 and a blank: the count (8 digits) sorts above that alphanumeric field, so the final CHKP DISPLAYs its count (the WS-NO-CHKP >= branch) | both end RETURN-CODE 0 | yes |
| checkpoint-freq-compare | `# DLI GN 3 AM`; `SYSIN 13     1 00005 N` | #6072: a checkpoint frequency of four blanks and a 1: not SPACES and not 0, so it is kept, and the summary count (8 digits) sorts above that alphanumeric field (a blank sorts below '0'), so WS-AUTH-SMRY-PROC-CNT > P-CHKP-FREQ is true after every summary and the CHKP fires each time (the checkpoint-frequency true branch). A basic CHKP drops the database position, so the next GN reads the first summary again and the step would never end: the third GN answers AM and the step abends (RC 16) on both sides | both end RETURN-CODE 16 | yes |
| expiry-not-numeric | `SYSIN XX 00002 00005 N` | #5857: a non-numeric expiry falls back to 5 days (the IS NUMERIC false branch) | both end RETURN-CODE 16 | yes |
| declined-expired | `SYSIN 13 00002 00005 N` | #6072: the shipped unload holds only approved ('00') details, so an expired detail never took the declined arm of 4000-CHECK-IF-EXPIRED (PA-AUTH-RESP-CODE = '00' false: the declined count and amount are subtracted). A declined detail copied from unload record 59 (an expired one, 0-based as skip counts) and inserted after it, with the next sequence time, reaches it on both sides (#6995 per-fault ims_seed) | both end RETURN-CODE 0 | yes |

## COBOL coverage (#4023)

CBPAUP0C: proven on 14 runs, covering 15/16 paragraphs and 39/40 branches.

Dead (nothing can reach them): `9999-EXIT`.

Live code no run reached:

- paragraph `6000-EXIT` (line 348)
- IF at line 340 in `6000-DELETE-AUTH-SUMMARY`: never true
