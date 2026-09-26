# cbsa: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 68 | 164 |
| Total lines | 27768 | 11802 |
| Code lines | 18609 | 6965 |
| Functions (paragraphs / methods) | 682 | 474 |
| Mean function complexity | 1.46 | 2.58 |
| Max function complexity | 117 | 24 |
| Mean function length (lines) | 28.4 | 6.0 |
| Functions with complexity > 10 | 22 | 1 |
| Cognitive-load exposure (mean, 0-100) | 38.3 | 4.6 |
| Tech-debt exposure | 15.1 | 27.7 |
| Safety exposure | 38.1 | 22.0 |
| Verification exposure | 21.7 | 10.9 |
| Documentation exposure | 47.1 | 14.2 |
| API-exposure | 11.0 | 14.8 |
| State-flux exposure | 42.4 | 10.9 |

Source estate by language: jcl 109, java 82, cobol 68, json 53, xml 47, markdown 33, css 32, javascript 31, plaintext 17, html 13, bms 10, shell 2, batch 2, yaml 1, csd 1.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
