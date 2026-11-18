# cbsa: GitGalaxy scan, source vs generated Java

Both trees scanned by the same GitGalaxy engine. Source side: the program code (cobol); Java side: every generated `.java` file.

| metric | source | generated Java |
|---|---|---|
| Source files | 68 | 177 |
| Total lines | 27768 | 15278 |
| Code lines | 18543 | 8060 |
| Functions (paragraphs / methods) | 682 | 614 |
| Mean function complexity | 1.49 | 1.04 |
| Max function complexity | 117 | 108 |
| Mean function length (lines) | 29.7 | 6.0 |
| Functions with complexity > 10 | 23 | 8 |
| Cognitive-load exposure (mean, 0-100) | 38.4 | 3.3 |
| Tech-debt exposure | 11.8 | 24.5 |
| Safety exposure | 29.6 | 24.3 |
| Verification exposure | 21.7 | 5.4 |
| Documentation exposure | 47.1 | 11.3 |
| API-exposure | 10.0 | 15.4 |
| State-flux exposure | 42.4 | 13.7 |

Source estate by language: jcl 109, java 83, cobol 68, json 52, xml 46, markdown 32, plaintext 16, html 12, bms 10, shell 2, css 2, batch 2, csd 1.

How to read it: the generated Java is the estate's STRUCTURE -- entities, DTOs, services, endpoints, batch jobs, wiring -- with each program's PROCEDURE DIVISION left as a traced TODO (migration_worklist.md). So its functions are small and simple, and its tech-debt exposure counts those TODO markers; the business logic moves over per program (see ../../equivalence).
