# zopeneditor: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol, pli, hlasm, rexx); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 23 | 37 |
| Total lines | 3438 | 2991 |
| Code lines | 2456 | 1887 |
| Functions (paragraphs / methods) | 71 | 128 |
| Mean function complexity | 3.69 | 2.03 |
| Max function complexity | 16 | 82 |
| Mean function length (lines) | 30.3 | 8.6 |
| Functions with complexity > 10 | 7 | 2 |
| Cognitive-load exposure (mean, 0-100) | 24.8 | 7.4 |
| Tech-debt exposure | 5.2 | 41.1 |
| Safety exposure | 34.9 | 34.5 |
| Verification exposure | 12.5 | 10.8 |
| Documentation exposure | 56.5 | 33.3 |
| API-exposure | 0.7 | 7.8 |
| State-flux exposure | 44.9 | 17.6 |

Source estate by language: cobol 13, jcl 10, plaintext 7, shell 4, rexx 4, pli 4, yaml 3, markdown 2, json 2, hlasm 2.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
