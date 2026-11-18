# Port order

The porting tickets in the order to take them: the programs the most other code depends on first -- a shared service or error handler is ported, proven and approved before the programs that call it. Ordered by callers (the programs and JCL steps that CALL / LINK / XCTL / EXEC it), then by blast radius (its weight in the dependency graph, PageRank x 1000, which counts callers of callers).

| order | program | callers | blast radius | ticket |
|---:|---|---:|---:|---|
| 1 | `src/base/cobol_src/ABNDPROC.cbl` | 23 | 9.058 | [ABNDPROC_port_ticket.md](ABNDPROC_port_ticket.md) |
| 2 | `src/base/cobol_src/INQCUST.cbl` | 4 | 2.122 | [INQCUST_port_ticket.md](INQCUST_port_ticket.md) |
| 3 | `src/base/cobol_src/INQACCCU.cbl` | 3 | 2.087 | [INQACCCU_port_ticket.md](INQACCCU_port_ticket.md) |
| 4 | `src/base/cobol_src/INQACC.cbl` | 2 | 2.118 | [INQACC_port_ticket.md](INQACC_port_ticket.md) |
| 5 | `src/base/cobol_src/DELACC.cbl` | 2 | 1.903 | [DELACC_port_ticket.md](DELACC_port_ticket.md) |
| 6 | `src/base/cobol_src/GETSCODE.cbl` | 1 | 2.974 | [GETSCODE_port_ticket.md](GETSCODE_port_ticket.md) |
| 7 | `src/base/cobol_src/BANKDATA.cbl` | 1 | 2.834 | [BANKDATA_port_ticket.md](BANKDATA_port_ticket.md) |
| 8 | `src/base/cobol_src/GETCOMPY.cbl` | 1 | 2.183 | [GETCOMPY_port_ticket.md](GETCOMPY_port_ticket.md) |
| 9 | `src/base/cobol_src/CREACC.cbl` | 1 | 1.966 | [CREACC_port_ticket.md](CREACC_port_ticket.md) |
| 10 | `src/base/cobol_src/CRECUST.cbl` | 1 | 1.966 | [CRECUST_port_ticket.md](CRECUST_port_ticket.md) |
| 11 | `src/base/cobol_src/DBCRFUN.cbl` | 1 | 1.966 | [DBCRFUN_port_ticket.md](DBCRFUN_port_ticket.md) |
| 12 | `src/base/cobol_src/XFRFUN.cbl` | 1 | 1.966 | [XFRFUN_port_ticket.md](XFRFUN_port_ticket.md) |
| 13 | `src/base/cobol_src/UPDACC.cbl` | 1 | 1.857 | [UPDACC_port_ticket.md](UPDACC_port_ticket.md) |
| 14 | `src/base/cobol_src/DELCUS.cbl` | 1 | 1.695 | [DELCUS_port_ticket.md](DELCUS_port_ticket.md) |
| 15 | `src/base/cobol_src/UPDCUST.cbl` | 1 | 1.695 | [UPDCUST_port_ticket.md](UPDCUST_port_ticket.md) |
| 16 | `src/base/cobol_src/ACCTCTRL.cbl` | 0 | 1.532 | [ACCTCTRL_port_ticket.md](ACCTCTRL_port_ticket.md) |
| 17 | `src/base/cobol_src/BNK1CAC.cbl` | 0 | 1.532 | [BNK1CAC_port_ticket.md](BNK1CAC_port_ticket.md) |
| 18 | `src/base/cobol_src/BNK1CCA.cbl` | 0 | 1.532 | [BNK1CCA_port_ticket.md](BNK1CCA_port_ticket.md) |
| 19 | `src/base/cobol_src/BNK1CCS.cbl` | 0 | 1.532 | [BNK1CCS_port_ticket.md](BNK1CCS_port_ticket.md) |
| 20 | `src/base/cobol_src/BNK1CRA.cbl` | 0 | 1.532 | [BNK1CRA_port_ticket.md](BNK1CRA_port_ticket.md) |
| 21 | `src/base/cobol_src/BNK1DAC.cbl` | 0 | 1.532 | [BNK1DAC_port_ticket.md](BNK1DAC_port_ticket.md) |
| 22 | `src/base/cobol_src/BNK1DCS.cbl` | 0 | 1.532 | [BNK1DCS_port_ticket.md](BNK1DCS_port_ticket.md) |
| 23 | `src/base/cobol_src/BNK1TFN.cbl` | 0 | 1.532 | [BNK1TFN_port_ticket.md](BNK1TFN_port_ticket.md) |
| 24 | `src/base/cobol_src/BNK1UAC.cbl` | 0 | 1.532 | [BNK1UAC_port_ticket.md](BNK1UAC_port_ticket.md) |
| 25 | `src/base/cobol_src/BNKMENU.cbl` | 0 | 1.532 | [BNKMENU_port_ticket.md](BNKMENU_port_ticket.md) |
| 26 | `src/base/cobol_src/CRDTAGY1.cbl` | 0 | 1.532 | [CRDTAGY1_port_ticket.md](CRDTAGY1_port_ticket.md) |
| 27 | `src/base/cobol_src/CRDTAGY2.cbl` | 0 | 1.532 | [CRDTAGY2_port_ticket.md](CRDTAGY2_port_ticket.md) |
| 28 | `src/base/cobol_src/CRDTAGY3.cbl` | 0 | 1.532 | [CRDTAGY3_port_ticket.md](CRDTAGY3_port_ticket.md) |
| 29 | `src/base/cobol_src/CRDTAGY4.cbl` | 0 | 1.532 | [CRDTAGY4_port_ticket.md](CRDTAGY4_port_ticket.md) |
| 30 | `src/base/cobol_src/CRDTAGY5.cbl` | 0 | 1.532 | [CRDTAGY5_port_ticket.md](CRDTAGY5_port_ticket.md) |
| 31 | `src/base/cobol_src/CUSTCTRL.cbl` | 0 | 1.532 | [CUSTCTRL_port_ticket.md](CUSTCTRL_port_ticket.md) |
