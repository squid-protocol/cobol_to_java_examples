# dsf-pli: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol, pli); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 1480 | 1045 |
| Total lines | 583406 | 64708 |
| Code lines | 495513 | 30166 |
| Functions (paragraphs / methods) | 4431 | 3503 |
| Mean function complexity | 14.8 | 0.24 |
| Max function complexity | 616 | 223 |
| Mean function length (lines) | 114.0 | 4.4 |
| Functions with complexity > 10 | 1390 | 6 |
| Cognitive-load exposure (mean, 0-100) | 41.8 | 0.6 |
| Tech-debt exposure | 4.3 | 69.9 |
| Safety exposure | 61.5 | 21.3 |
| Verification exposure | 33.7 | 3.0 |
| Documentation exposure | 99.9 | 5.3 |
| API-exposure | 14.6 | 21.7 |
| State-flux exposure | 88.5 | 1.1 |

Source estate by language: pli 1473, cobol 7, markdown 2, plaintext 1.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
