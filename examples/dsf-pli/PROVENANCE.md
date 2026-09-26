# dsf-pli: provenance

- **Source:** [https://github.com/navikt/DSF](https://github.com/navikt/DSF) at commit `faade4961e316c89e8c312456bae411c63f1c482` (NAV DSF: the Norwegian pension system, 431 PL/I programs under CICS / IMS).
- **Source licence:** MIT. This directory is derived from that source (its names, literals and
  source references carry over), so the source's licence terms apply to it.
- **Generator:** [GitGalaxy](https://github.com/squid-protocol/gitgalaxy) at commit [`d3d39e033cf7`](https://github.com/squid-protocol/gitgalaxy/commit/d3d39e033cf7c8b27f977808d96fd00204fa9b5e).
- **Commands** (from a GitGalaxy checkout at that commit, the corpus at that ref):

  ```
  python tests/tools/mainframe_corpus.py fetch dsf
  python tests/tools/publish_examples.py <this repository> --only dsf-pli
  ```

  which runs `cobol-refractor <corpus> --scan`, then `cobol-to-java <clean room>` with the default
  target config (Spring Boot 3.2, Java 17, Lombok, Maven), and blanks the run's timestamps.
- **Compiles:** the repository's `compile` workflow builds `java/` on every push; GitGalaxy's own
  `java-compile` CI builds this corpus in 17 target configurations.
