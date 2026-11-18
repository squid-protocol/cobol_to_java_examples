# Port order

The porting tickets in the order to take them: the programs the most other code depends on first -- a shared service or error handler is ported, proven and approved before the programs that call it. Ordered by callers (the programs and JCL steps that CALL / LINK / XCTL / EXEC it), then by blast radius (its weight in the dependency graph, PageRank x 1000, which counts callers of callers).

| order | program | callers | blast radius | ticket |
|---:|---|---:|---:|---|
| 1 | `app/cbl/CSUTLDTC.cbl` | 3 | 6.804 | [CSUTLDTC_port_ticket.md](CSUTLDTC_port_ticket.md) |
| 2 | `app/cbl/COMEN01C.cbl` | 3 | 4.007 | [COMEN01C_port_ticket.md](COMEN01C_port_ticket.md) |
| 3 | `app/cbl/CBTRN03C.cbl` | 2 | 8.649 | [CBTRN03C_port_ticket.md](CBTRN03C_port_ticket.md) |
| 4 | `app/app-transaction-type-db2/cbl/COTRTUPC.cbl` | 2 | 4.863 | [COTRTUPC_port_ticket.md](COTRTUPC_port_ticket.md) |
| 5 | `app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl` | 2 | 4.251 | [COPAUS2C_port_ticket.md](COPAUS2C_port_ticket.md) |
| 6 | `app/cbl/COADM01C.cbl` | 2 | 3.721 | [COADM01C_port_ticket.md](COADM01C_port_ticket.md) |
| 7 | `app/cbl/CBACT01C.cbl` | 1 | 5.926 | [CBACT01C_port_ticket.md](CBACT01C_port_ticket.md) |
| 8 | `app/cbl/CBACT02C.cbl` | 1 | 5.926 | [CBACT02C_port_ticket.md](CBACT02C_port_ticket.md) |
| 9 | `app/cbl/CBACT03C.cbl` | 1 | 5.926 | [CBACT03C_port_ticket.md](CBACT03C_port_ticket.md) |
| 10 | `app/cbl/CBACT04C.cbl` | 1 | 5.926 | [CBACT04C_port_ticket.md](CBACT04C_port_ticket.md) |
| 11 | `app/cbl/CBCUS01C.cbl` | 1 | 5.926 | [CBCUS01C_port_ticket.md](CBCUS01C_port_ticket.md) |
| 12 | `app/cbl/CBEXPORT.cbl` | 1 | 5.926 | [CBEXPORT_port_ticket.md](CBEXPORT_port_ticket.md) |
| 13 | `app/cbl/CBIMPORT.cbl` | 1 | 5.926 | [CBIMPORT_port_ticket.md](CBIMPORT_port_ticket.md) |
| 14 | `app/app-authorization-ims-db2-mq/cbl/CBPAUP0C.cbl` | 1 | 5.926 | [CBPAUP0C_port_ticket.md](CBPAUP0C_port_ticket.md) |
| 15 | `app/cbl/CBSTM03A.CBL` | 1 | 5.926 | [CBSTM03A_port_ticket.md](CBSTM03A_port_ticket.md) |
| 16 | `app/cbl/CBTRN02C.cbl` | 1 | 5.926 | [CBTRN02C_port_ticket.md](CBTRN02C_port_ticket.md) |
| 17 | `app/cbl/COBSWAIT.cbl` | 1 | 5.926 | [COBSWAIT_port_ticket.md](COBSWAIT_port_ticket.md) |
| 18 | `app/app-transaction-type-db2/cbl/COBTUPDT.cbl` | 1 | 5.926 | [COBTUPDT_port_ticket.md](COBTUPDT_port_ticket.md) |
| 19 | `app/app-authorization-ims-db2-mq/cbl/DBUNLDGS.CBL` | 1 | 5.926 | [DBUNLDGS_port_ticket.md](DBUNLDGS_port_ticket.md) |
| 20 | `app/app-authorization-ims-db2-mq/cbl/PAUDBLOD.CBL` | 1 | 5.926 | [PAUDBLOD_port_ticket.md](PAUDBLOD_port_ticket.md) |
| 21 | `app/app-authorization-ims-db2-mq/cbl/PAUDBUNL.CBL` | 1 | 5.926 | [PAUDBUNL_port_ticket.md](PAUDBUNL_port_ticket.md) |
| 22 | `app/app-vsam-mq/cbl/COACCT01.cbl` | 1 | 4.565 | [COACCT01_port_ticket.md](COACCT01_port_ticket.md) |
| 23 | `app/app-vsam-mq/cbl/CODATE01.cbl` | 1 | 4.565 | [CODATE01_port_ticket.md](CODATE01_port_ticket.md) |
| 24 | `app/app-transaction-type-db2/cbl/COTRTLIC.cbl` | 1 | 4.565 | [COTRTLIC_port_ticket.md](COTRTLIC_port_ticket.md) |
| 25 | `app/cbl/CBSTM03B.CBL` | 1 | 4.211 | [CBSTM03B_port_ticket.md](CBSTM03B_port_ticket.md) |
| 26 | `app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl` | 1 | 3.884 | [COPAUA0C_port_ticket.md](COPAUA0C_port_ticket.md) |
| 27 | `app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl` | 1 | 3.884 | [COPAUS0C_port_ticket.md](COPAUS0C_port_ticket.md) |
| 28 | `app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl` | 1 | 3.884 | [COPAUS1C_port_ticket.md](COPAUS1C_port_ticket.md) |
| 29 | `app/cbl/COACTUPC.cbl` | 1 | 3.363 | [COACTUPC_port_ticket.md](COACTUPC_port_ticket.md) |
| 30 | `app/cbl/COACTVWC.cbl` | 1 | 3.363 | [COACTVWC_port_ticket.md](COACTVWC_port_ticket.md) |
| 31 | `app/cbl/COBIL00C.cbl` | 1 | 3.363 | [COBIL00C_port_ticket.md](COBIL00C_port_ticket.md) |
| 32 | `app/cbl/COCRDLIC.cbl` | 1 | 3.363 | [COCRDLIC_port_ticket.md](COCRDLIC_port_ticket.md) |
| 33 | `app/cbl/COCRDSLC.cbl` | 1 | 3.363 | [COCRDSLC_port_ticket.md](COCRDSLC_port_ticket.md) |
| 34 | `app/cbl/COCRDUPC.cbl` | 1 | 3.363 | [COCRDUPC_port_ticket.md](COCRDUPC_port_ticket.md) |
| 35 | `app/cbl/CORPT00C.cbl` | 1 | 3.363 | [CORPT00C_port_ticket.md](CORPT00C_port_ticket.md) |
| 36 | `app/cbl/COSGN00C.cbl` | 1 | 3.363 | [COSGN00C_port_ticket.md](COSGN00C_port_ticket.md) |
| 37 | `app/cbl/COTRN00C.cbl` | 1 | 3.363 | [COTRN00C_port_ticket.md](COTRN00C_port_ticket.md) |
| 38 | `app/cbl/COTRN01C.cbl` | 1 | 3.363 | [COTRN01C_port_ticket.md](COTRN01C_port_ticket.md) |
| 39 | `app/cbl/COTRN02C.cbl` | 1 | 3.363 | [COTRN02C_port_ticket.md](COTRN02C_port_ticket.md) |
| 40 | `app/cbl/COUSR00C.cbl` | 1 | 3.363 | [COUSR00C_port_ticket.md](COUSR00C_port_ticket.md) |
| 41 | `app/cbl/COUSR01C.cbl` | 1 | 3.363 | [COUSR01C_port_ticket.md](COUSR01C_port_ticket.md) |
| 42 | `app/cbl/COUSR02C.cbl` | 1 | 3.363 | [COUSR02C_port_ticket.md](COUSR02C_port_ticket.md) |
| 43 | `app/cbl/COUSR03C.cbl` | 1 | 3.363 | [COUSR03C_port_ticket.md](COUSR03C_port_ticket.md) |
| 44 | `app/cbl/CBTRN01C.cbl` | 0 | 3.203 | [CBTRN01C_port_ticket.md](CBTRN01C_port_ticket.md) |
