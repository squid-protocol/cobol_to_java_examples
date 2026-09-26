# carddemo: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 109 | 224 |
| Total lines | 41126 | 19191 |
| Code lines | 33310 | 11093 |
| Functions (paragraphs / methods) | 891 | 579 |
| Mean function complexity | 3.2 | 1.08 |
| Max function complexity | 97 | 27 |
| Mean function length (lines) | 23.9 | 6.9 |
| Functions with complexity > 10 | 63 | 14 |
| Cognitive-load exposure (mean, 0-100) | 28.8 | 5.3 |
| Tech-debt exposure | 4.5 | 31.6 |
| Safety exposure | 40.3 | 27.1 |
| Verification exposure | 24.4 | 6.2 |
| Documentation exposure | 42.2 | 19.1 |
| API-exposure | 1.7 | 15.4 |
| State-flux exposure | 42.4 | 17.4 |

Source estate by language: cobol 109, jcl 62, bms 21, hlasm 12, plaintext 11, shell 9, markdown 6, db2_sql 6, csd 4.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
