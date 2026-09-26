# dsf-pli: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol, pli); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 1480 | 997 |
| Total lines | 583406 | 49898 |
| Code lines | 495533 | 25994 |
| Functions (paragraphs / methods) | 4428 | 3364 |
| Mean function complexity | 14.97 | 0.49 |
| Max function complexity | 616 | 9 |
| Mean function length (lines) | 119.6 | 3.6 |
| Functions with complexity > 10 | 1413 | 0 |
| Cognitive-load exposure (mean, 0-100) | 41.8 | 2.1 |
| Tech-debt exposure | 5.7 | 77.8 |
| Safety exposure | 80.6 | 1.8 |
| Verification exposure | 34.6 | 3.4 |
| Documentation exposure | 99.9 | 16.4 |
| API-exposure | 12.8 | 21.7 |
| State-flux exposure | 88.5 | 0.4 |

Source estate by language: pli 1473, cobol 7, markdown 2, plaintext 1.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
