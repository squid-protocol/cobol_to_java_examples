# Port order

The porting tickets in the order to take them: the programs the most other code depends on first -- a shared service or error handler is ported, proven and approved before the programs that call it. Ordered by callers (the programs and JCL steps that CALL / LINK / XCTL / EXEC it), then by blast radius (its weight in the dependency graph, PageRank x 1000, which counts callers of callers).

| order | program | callers | blast radius | ticket |
|---:|---|---:|---:|---|
| 1 | `base/src/lgstsq.cbl` | 20 | 52.265 | [lgstsq_port_ticket.md](lgstsq_port_ticket.md) |
| 2 | `base/src/lgapol01.cbl` | 4 | 9.776 | [lgapol01_port_ticket.md](lgapol01_port_ticket.md) |
| 3 | `base/src/lgdpol01.cbl` | 4 | 9.776 | [lgdpol01_port_ticket.md](lgdpol01_port_ticket.md) |
| 4 | `base/src/lgipol01.cbl` | 4 | 9.776 | [lgipol01_port_ticket.md](lgipol01_port_ticket.md) |
| 5 | `base/src/lgupol01.cbl` | 3 | 8.57 | [lgupol01_port_ticket.md](lgupol01_port_ticket.md) |
| 6 | `base/src/lgapdb01.cbl` | 1 | 8.445 | [lgapdb01_port_ticket.md](lgapdb01_port_ticket.md) |
| 7 | `base/src/lgdpdb01.cbl` | 1 | 8.445 | [lgdpdb01_port_ticket.md](lgdpdb01_port_ticket.md) |
| 8 | `base/src/lgupdb01.cbl` | 1 | 8.104 | [lgupdb01_port_ticket.md](lgupdb01_port_ticket.md) |
| 9 | `base/src/lgdpvs01.cbl` | 1 | 8.068 | [lgdpvs01_port_ticket.md](lgdpvs01_port_ticket.md) |
| 10 | `base/src/lgipdb01.cbl` | 1 | 7.753 | [lgipdb01_port_ticket.md](lgipdb01_port_ticket.md) |
| 11 | `base/src/lgucdb01.cbl` | 1 | 7.625 | [lgucdb01_port_ticket.md](lgucdb01_port_ticket.md) |
| 12 | `base/src/lgapvs01.cbl` | 1 | 7.47 | [lgapvs01_port_ticket.md](lgapvs01_port_ticket.md) |
| 13 | `base/src/lgupvs01.cbl` | 1 | 7.398 | [lgupvs01_port_ticket.md](lgupvs01_port_ticket.md) |
| 14 | `base/src/lgucvs01.cbl` | 1 | 7.296 | [lgucvs01_port_ticket.md](lgucvs01_port_ticket.md) |
| 15 | `base/src/lgacdb01.cbl` | 1 | 7.138 | [lgacdb01_port_ticket.md](lgacdb01_port_ticket.md) |
| 16 | `base/src/lgicdb01.cbl` | 1 | 7.138 | [lgicdb01_port_ticket.md](lgicdb01_port_ticket.md) |
| 17 | `base/src/lgacdb02.cbl` | 1 | 6.889 | [lgacdb02_port_ticket.md](lgacdb02_port_ticket.md) |
| 18 | `base/src/lgacvs01.cbl` | 1 | 6.889 | [lgacvs01_port_ticket.md](lgacvs01_port_ticket.md) |
| 19 | `base/src/lgacus01.cbl` | 1 | 6.881 | [lgacus01_port_ticket.md](lgacus01_port_ticket.md) |
| 20 | `base/src/lgicus01.cbl` | 1 | 6.881 | [lgicus01_port_ticket.md](lgicus01_port_ticket.md) |
| 21 | `base/src/lgucus01.cbl` | 1 | 6.881 | [lgucus01_port_ticket.md](lgucus01_port_ticket.md) |
| 22 | `base/src/lgastat1.cbl` | 0 | 5.675 | [lgastat1_port_ticket.md](lgastat1_port_ticket.md) |
| 23 | `base/src/lgicvs01.cbl` | 0 | 5.675 | [lgicvs01_port_ticket.md](lgicvs01_port_ticket.md) |
| 24 | `base/src/lgipvs01.cbl` | 0 | 5.675 | [lgipvs01_port_ticket.md](lgipvs01_port_ticket.md) |
| 25 | `base/src/lgsetup.cbl` | 0 | 5.675 | [lgsetup_port_ticket.md](lgsetup_port_ticket.md) |
| 26 | `base/src/lgtestc1.cbl` | 0 | 5.675 | [lgtestc1_port_ticket.md](lgtestc1_port_ticket.md) |
| 27 | `base/src/lgtestp1.cbl` | 0 | 5.675 | [lgtestp1_port_ticket.md](lgtestp1_port_ticket.md) |
| 28 | `base/src/lgtestp2.cbl` | 0 | 5.675 | [lgtestp2_port_ticket.md](lgtestp2_port_ticket.md) |
| 29 | `base/src/lgtestp3.cbl` | 0 | 5.675 | [lgtestp3_port_ticket.md](lgtestp3_port_ticket.md) |
| 30 | `base/src/lgtestp4.cbl` | 0 | 5.675 | [lgtestp4_port_ticket.md](lgtestp4_port_ticket.md) |
| 31 | `base/src/lgwebst5.cbl` | 0 | 5.675 | [lgwebst5_port_ticket.md](lgwebst5_port_ticket.md) |
