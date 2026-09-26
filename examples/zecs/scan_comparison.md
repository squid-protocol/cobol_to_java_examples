# zecs: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol, hlasm, rexx); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 10 | 33 |
| Total lines | 4838 | 2350 |
| Code lines | 3138 | 1481 |
| Functions (paragraphs / methods) | 218 | 77 |
| Mean function complexity | 1.04 | 1.3 |
| Max function complexity | 19 | 9 |
| Mean function length (lines) | 13.2 | 5.6 |
| Functions with complexity > 10 | 3 | 0 |
| Cognitive-load exposure (mean, 0-100) | 46.9 | 6.4 |
| Tech-debt exposure | 5.3 | 42.7 |
| Safety exposure | 67.2 | 20.6 |
| Verification exposure | 25.7 | 7.1 |
| Documentation exposure | 70.0 | 29.3 |
| API-exposure | 0.9 | 15.1 |
| State-flux exposure | 55.5 | 16.8 |

Source estate by language: jcl 10, cobol 7, csd 6, markdown 4, plaintext 3, hlasm 2, yaml 1, rexx 1.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
