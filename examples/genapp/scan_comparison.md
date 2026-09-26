# genapp: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol, hlasm, rexx); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 46 | 151 |
| Total lines | 9657 | 8285 |
| Code lines | 6967 | 4828 |
| Functions (paragraphs / methods) | 157 | 418 |
| Mean function complexity | 2.24 | 1.08 |
| Max function complexity | 16 | 24 |
| Mean function length (lines) | 36.9 | 4.4 |
| Functions with complexity > 10 | 7 | 5 |
| Cognitive-load exposure (mean, 0-100) | 58.7 | 3.3 |
| Tech-debt exposure | 23.8 | 38.8 |
| Safety exposure | 62.1 | 15.9 |
| Verification exposure | 5.5 | 4.4 |
| Documentation exposure | 33.7 | 11.5 |
| API-exposure | 1.5 | 17.4 |
| State-flux exposure | 69.6 | 8.5 |

Source estate by language: cobol 44, plaintext 41, jcl 29, markdown 13, rexx 2, shell 1, bms 1.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
