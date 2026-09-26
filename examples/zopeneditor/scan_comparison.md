# zopeneditor: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol, pli, hlasm, rexx); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 23 | 30 |
| Total lines | 3438 | 1569 |
| Code lines | 2456 | 1069 |
| Functions (paragraphs / methods) | 71 | 46 |
| Mean function complexity | 3.69 | 1.98 |
| Max function complexity | 16 | 9 |
| Mean function length (lines) | 29.5 | 8.5 |
| Functions with complexity > 10 | 7 | 0 |
| Cognitive-load exposure (mean, 0-100) | 24.8 | 5.3 |
| Tech-debt exposure | 6.8 | 39.4 |
| Safety exposure | 44.9 | 28.8 |
| Verification exposure | 12.5 | 7.5 |
| Documentation exposure | 56.5 | 39.0 |
| API-exposure | 1.2 | 9.3 |
| State-flux exposure | 44.9 | 10.8 |

Source estate by language: cobol 13, jcl 10, plaintext 7, shell 4, rexx 4, pli 4, yaml 3, markdown 2, json 2, hlasm 2.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
