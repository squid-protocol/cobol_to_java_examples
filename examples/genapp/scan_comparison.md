# genapp: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol, hlasm, rexx); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 46 | 166 |
| Total lines | 9657 | 12765 |
| Code lines | 6967 | 7127 |
| Functions (paragraphs / methods) | 162 | 584 |
| Mean function complexity | 2.17 | 1.3 |
| Max function complexity | 16 | 108 |
| Mean function length (lines) | 35.8 | 6.6 |
| Functions with complexity > 10 | 7 | 8 |
| Cognitive-load exposure (mean, 0-100) | 58.7 | 6.9 |
| Tech-debt exposure | 10.3 | 25.9 |
| Safety exposure | 47.0 | 33.8 |
| Verification exposure | 5.5 | 4.3 |
| Documentation exposure | 33.7 | 8.7 |
| API-exposure | 1.5 | 18.1 |
| State-flux exposure | 69.6 | 24.6 |

Source estate by language: cobol 44, plaintext 41, jcl 29, markdown 14, rexx 2, shell 1, bms 1.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
