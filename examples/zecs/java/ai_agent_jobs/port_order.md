# Port order

The porting tickets in the order to take them: the programs the most other code depends on first -- a shared service or error handler is ported, proven and approved before the programs that call it. Ordered by callers (the programs and JCL steps that CALL / LINK / XCTL / EXEC it), then by blast radius (its weight in the dependency graph, PageRank x 1000, which counts callers of callers).

| order | program | callers | blast radius | ticket |
|---:|---|---:|---:|---|
| 1 | `Source/ZECS000.cbl` | 2 | 35.778 | [ZECS000_port_ticket.md](ZECS000_port_ticket.md) |
| 2 | `Source/ZECS003.cbl` | 2 | 33.037 | [ZECS003_port_ticket.md](ZECS003_port_ticket.md) |
| 3 | `Source/ZECS001.cbl` | 1 | 31.965 | [ZECS001_port_ticket.md](ZECS001_port_ticket.md) |
| 4 | `Source/ZECSPLT.cbl` | 1 | 26.245 | [ZECSPLT_port_ticket.md](ZECSPLT_port_ticket.md) |
| 5 | `Source/ECS001.cbl` | 0 | 22.432 | [ECS001_port_ticket.md](ECS001_port_ticket.md) |
