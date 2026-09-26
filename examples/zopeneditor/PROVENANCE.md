# zopeneditor: provenance

- **Source:** [https://github.com/IBM/zopeneditor-sample](https://github.com/IBM/zopeneditor-sample) at commit `8f9835308de6159eb54f226041d5f81a780cb8eb` (IBM Z Open Editor sample: batch COBOL and PL/I with JCL).
- **Source licence:** Apache-2.0. This directory is derived from that source (its names, literals and
  source references carry over), so the source's licence terms apply to it.
- **Generator:** [GitGalaxy](https://github.com/squid-protocol/gitgalaxy) at commit [`d3d39e033cf7`](https://github.com/squid-protocol/gitgalaxy/commit/d3d39e033cf7c8b27f977808d96fd00204fa9b5e).
- **Commands** (from a GitGalaxy checkout at that commit, the corpus at that ref):

  ```
  python tests/tools/mainframe_corpus.py fetch zopeneditor-sample
  python tests/tools/publish_examples.py <this repository> --only zopeneditor
  ```

  which runs `cobol-refractor <corpus> --scan`, then `cobol-to-java <clean room>` with the default
  target config (Spring Boot 3.2, Java 17, Lombok, Maven), and blanks the run's timestamps.
- **Compiles:** the repository's `compile` workflow builds `java/` on every push; GitGalaxy's own
  `java-compile` CI builds this corpus in 17 target configurations.
