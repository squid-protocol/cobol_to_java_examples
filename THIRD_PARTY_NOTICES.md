# Third-party notices

This repository holds output GENERATED FROM third-party source code. Each directory below is derived from
the source named (its identifiers, literals, record layouts and source references carry over, and the
generator modified and reorganised it), so **the source's licence applies to that directory**. The
source's own licence and notice files are copied into the directory unchanged, every generated Java file
opens with a notice naming its source, commit and licence, and each example's `PROVENANCE.md` records
exactly how it was produced.

| directory | derived from | licence | licence / notice files included |
|---|---|---|---|
| `examples/carddemo/` | [aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo) at `59cc6c2fd7eb` | Apache-2.0 | LICENSE, NOTICE |
| `examples/cbsa/` | [cics-banking-sample-application-cbsa](https://github.com/cicsdev/cics-banking-sample-application-cbsa) at `417334533178` | EPL-2.0 | LICENSE, NOTICES |
| `examples/genapp/` | [cics-genapp](https://github.com/cicsdev/cics-genapp) at `f6f3f4b2580d` | EPL-2.0 | LICENSE |
| `examples/zecs/` | [zecs](https://github.com/walmartlabs/zECS) at `6d6bcbbc89c9` | Apache-2.0 | LICENSE |
| `examples/zopeneditor/` | [zopeneditor-sample](https://github.com/IBM/zopeneditor-sample) at `8f9835308de6` | Apache-2.0 | LICENSE |
| `examples/dsf-pli/` | [dsf](https://github.com/navikt/DSF) at `faade4961e31` | MIT | LICENSE.md |
| `equivalence/carddemo-intcalc/` | [aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo) at `59cc6c2fd7eb` | Apache-2.0 | LICENSE, NOTICE |

The equivalence case's `port/` is a hand translation of the source program and its data file is the
source's data with changed balances: both are derived from that source too.

Everything else in this repository -- `README.md`, this file, `.github/` and `.publish/` -- is licensed
under the Apache License 2.0 (`LICENSE`).

## Trademarks

IBM, CICS, DB2, IMS and z/OS are trademarks of International Business Machines Corporation; AWS and Amazon Web Services are trademarks of Amazon.com, Inc. or its affiliates; Walmart is a trademark of Walmart Apps, LLC; NAV is the Norwegian Labour and Welfare Administration. Their names are used only to identify the source code these examples are derived from. This repository is not affiliated with, sponsored or endorsed by any of them.
