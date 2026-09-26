# zecs: provenance

- **Source:** [https://github.com/walmartlabs/zECS](https://github.com/walmartlabs/zECS) at commit `6d6bcbbc89c9be086a58cb7ad2ff4d702e873d02` (Walmart zECS: an assembler + COBOL CICS key/value service).
- **Source licence:** Apache-2.0. This directory is derived from that source (its names, literals and
  source references carry over), so the source's licence terms apply to it. The source's own licence and
  notice files are copied here unchanged (LICENSE), and every
  generated Java file opens with a notice naming the source, its commit and licence, and that it was
  modified in generation.
- **Generator:** [GitGalaxy](https://github.com/squid-protocol/gitgalaxy) at commit [`695773d5a7a2`](https://github.com/squid-protocol/gitgalaxy/commit/695773d5a7a2d06311b764e89d713620083044a2).
- **Commands** (from a GitGalaxy checkout at that commit, the corpus at that ref):

  ```
  python tests/tools/mainframe_corpus.py fetch zecs
  python tests/tools/publish_examples.py <this repository> --only zecs
  ```

  which runs `cobol-refractor <corpus> --scan`, then `cobol-to-java <clean room>` with the default
  target config (Spring Boot 3.2, Java 17, Lombok, Maven), and blanks the run's timestamps.
- **Compiles:** the repository's `compile` workflow builds `java/` on every push; GitGalaxy's own
  `java-compile` CI builds this corpus in 17 target configurations.
