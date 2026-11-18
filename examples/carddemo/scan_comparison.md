# carddemo: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 109 | 240 |
| Total lines | 41126 | 22882 |
| Code lines | 32562 | 13035 |
| Functions (paragraphs / methods) | 901 | 731 |
| Mean function complexity | 3.22 | 1.04 |
| Max function complexity | 97 | 108 |
| Mean function length (lines) | 24.1 | 7.7 |
| Functions with complexity > 10 | 63 | 10 |
| Cognitive-load exposure (mean, 0-100) | 28.9 | 2.9 |
| Tech-debt exposure | 1.6 | 27.0 |
| Safety exposure | 31.4 | 33.4 |
| Verification exposure | 24.4 | 4.3 |
| Documentation exposure | 43.1 | 19.8 |
| API-exposure | 1.7 | 15.3 |
| State-flux exposure | 42.5 | 21.2 |

Source estate by language: cobol 109, jcl 62, bms 21, hlasm 12, plaintext 11, shell 9, markdown 6, db2_sql 6, csd 4.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
