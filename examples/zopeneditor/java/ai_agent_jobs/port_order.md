# Port order

The porting tickets in the order to take them: the programs the most other code depends on first -- a shared service or error handler is ported, proven and approved before the programs that call it. Ordered by callers (the programs and JCL steps that CALL / LINK / XCTL / EXEC it), then by blast radius (its weight in the dependency graph, PageRank x 1000, which counts callers of callers).

| order | program | callers | blast radius | ticket |
|---:|---|---:|---:|---|
| 1 | `COBOL/SAM2.cbl` | 2 | 23.247 | [COBOL__SAM2_port_ticket.md](COBOL__SAM2_port_ticket.md) |
| 2 | `COBOL/SAM1.cbl` | 1 | 25.386 | [COBOL__SAM1_port_ticket.md](COBOL__SAM1_port_ticket.md) |
| 3 | `PLI/PSAM1.pli` | 1 | 25.386 | [PSAM1_port_ticket.md](PSAM1_port_ticket.md) |
| 4 | `multiroot/sam/SAM1.cbl` | 1 | 24.511 | [multiroot__sam__SAM1_port_ticket.md](multiroot__sam__SAM1_port_ticket.md) |
| 5 | `multiroot/sam/SAM2.cbl` | 1 | 18.931 | [multiroot__sam__SAM2_port_ticket.md](multiroot__sam__SAM2_port_ticket.md) |
| 6 | `PLI/MACSAMP.pli` | 0 | 13.722 | [MACSAMP_port_ticket.md](MACSAMP_port_ticket.md) |
| 7 | `PLI/PSAM1LIB.pli` | 0 | 13.722 | [PSAM1LIB_port_ticket.md](PSAM1LIB_port_ticket.md) |
| 8 | `COBOL/SAM1LIB.cbl` | 0 | 13.722 | [SAM1LIB_port_ticket.md](SAM1LIB_port_ticket.md) |
