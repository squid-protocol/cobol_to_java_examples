# zecs: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol, hlasm, rexx); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 10 | 42 |
| Total lines | 4838 | 4255 |
| Code lines | 3138 | 2702 |
| Functions (paragraphs / methods) | 223 | 159 |
| Mean function complexity | 1.03 | 3.09 |
| Max function complexity | 19 | 108 |
| Mean function length (lines) | 13.1 | 9.1 |
| Functions with complexity > 10 | 3 | 6 |
| Cognitive-load exposure (mean, 0-100) | 46.8 | 7.7 |
| Tech-debt exposure | 4.0 | 35.7 |
| Safety exposure | 51.2 | 29.4 |
| Verification exposure | 25.6 | 7.9 |
| Documentation exposure | 70.0 | 24.6 |
| API-exposure | 0.9 | 15.3 |
| State-flux exposure | 55.5 | 19.9 |

Source estate by language: jcl 13, cobol 7, csd 6, markdown 4, plaintext 3, hlasm 2, yaml 1, rexx 1.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
