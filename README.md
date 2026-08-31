# 🌌 GitGalaxy: COBOL to Java Translation Examples

This repository contains 10 unedited, auto-generated Spring Boot architectures created by the [GitGalaxy](https://github.com/squid-protocol/gitgalaxy) deterministic legacy migration pipeline. 

These outputs were generated seamlessly via our automated batch test harness. They are designed to prove the structural integrity of our extraction engine—demonstrating that GitGalaxy can generate perfectly compiling, architecturally sound Java environments *before* AI is introduced to handle the internal logic.

## 🏗️ What You Are Looking At

Each folder in this repository represents a distinct legacy COBOL codebase that has been translated into a modern **Spring Boot 3.2** microservice architecture. 

If you click into any of these examples, you will find:
* **`pom.xml` & `application.yml`**: A complete, ready-to-use Maven build system.
* **`src/main/java/.../entity/`**: Legacy `PIC`, `OCCURS`, and `REDEFINES` clauses translated into flawless JPA Entities.
* **`src/main/java/.../controller/`**: Legacy DAG lineage intent mapped into modern REST Controller endpoints.
* **`src/main/java/.../service/`**: Auto-wired service layers containing Mock Services to safely catch unresolved external mainframe calls.
* **`ai_agent_jobs/`**: The strict JSON task tickets generated for autonomous AI agents to fill in the isolated business logic.

## 🧪 100% Compilable

Every single architecture in this repository compiles out-of-the-box. You can clone this repository, navigate into any of the example folders, and run:

```bash
mvn clean compile
```

## 📂 The Corpus Examples
We selected a diverse array of structural complexities for this showcase, avoiding recursive outputs to provide a clean look at standard and edge-case translations:

1. **`cics-genapp`**: The gold standard IBM benchmark (Enterprise CICS/DB2).
2. **`gnucobol`**: A heavyweight compiler (Massive size, complex structure).
3. **`CICS-Cobol`**: A standard mainframe transactional workload.
4. **`cics-java-jcics-samples`**: Complex legacy bridging and wrappers.
5. **`cobol-programming-course`**: Algorithmic snippets and standard educational paradigms.
6. **`cobrix`**: A modern big-data parser dealing with mainframe layouts.
7. **`otterkit`**: A compiler/toolchain stress test.
8. **`cobol-samples`**: Pure data-processing examples.
9. **`vscode_cobol`**: Edge-case syntax highlighting tool architecture.
10. **`fake_cobol_repo`**: Intentionally malformed or edge-case testing code.

## 📚 How the pipeline works

The full mechanism behind these outputs is documented in the GitGalaxy docs site's **Legacy
Bridge** chapter: the [refraction controller](https://squid-protocol.github.io/gitgalaxy/05-01-legacy-refraction-controller)
(the deterministic COBOL→architecture mapping), [Spring Boot scaffolding](https://squid-protocol.github.io/gitgalaxy/05-02-spring-boot-scaffolding),
[entity & memory mapping](https://squid-protocol.github.io/gitgalaxy/05-03-entity-and-memory-mapping)
(`PIC`/`OCCURS`/`REDEFINES` → JPA), [API & service contracts](https://squid-protocol.github.io/gitgalaxy/05-04-api-and-service-contracts),
the [autonomous agent tickets](https://squid-protocol.github.io/gitgalaxy/05-05-autonomous-agent-tickets)
that populate `ai_agent_jobs/`, and the [batch test harness](https://squid-protocol.github.io/gitgalaxy/05-06-batch-test-harness)
that generated this whole repo. The source lives in the engine's
[`gitgalaxy/tools/cobol_to_java`](https://github.com/squid-protocol/gitgalaxy/tree/main/gitgalaxy/tools/cobol_to_java).

Several of the source repos here (cics-genapp, cics-java-jcics-samples, gnucobol) also appear in
[gitgalaxy-raw-output](https://github.com/squid-protocol/gitgalaxy-raw-output) as unedited
analysis scans, and in the [language-crucible](https://github.com/squid-protocol/language-crucible)
COBOL/JCL benchmark corpus — the same codebases, seen by the analysis, benchmark, and
translation legs of the system.

## The GitGalaxy constellation

This repo is one strand of the web of repos that build, prove, and showcase
[GitGalaxy](https://github.com/squid-protocol/gitgalaxy):

- [gitgalaxy](https://github.com/squid-protocol/gitgalaxy) — the engine (this repo showcases its `cobol_to_java` pipeline)
- **cobol_to_java_examples** — *you are here*: 10 auto-generated, compiling Spring Boot translations
- [gitgalaxy-raw-output](https://github.com/squid-protocol/gitgalaxy-raw-output) — unedited analysis scans of real repos, including several of this repo's sources
- [language-crucible](https://github.com/squid-protocol/language-crucible) — the pinned adversarial corpus (COBOL/JCL heavy) behind the engine's regression gate
- [keyword-rosetta](https://github.com/squid-protocol/keyword-rosetta) — one planted program in 46 languages, measuring cross-language measurement consistency
- [gitgalaxy-population-analyses](https://github.com/squid-protocol/gitgalaxy-population-analyses) — statistical analyses over the scan population
- [squid-telemetry](https://github.com/squid-protocol/squid-telemetry) — public distribution/adoption metrics
- Docs: [architecture & methodology site](https://squid-protocol.github.io/gitgalaxy/) · [Legacy Bridge chapter](https://squid-protocol.github.io/gitgalaxy/05-01-legacy-refraction-controller) · [Museum of Code](https://squid-protocol.github.io/gitgalaxy/museum-of-code/) · [gitgalaxy.io](https://gitgalaxy.io/)

---
*Generated automatically via the GitGalaxy Batch Test Harness.*
