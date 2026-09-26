# genapp: provenance

- **Source:** [https://github.com/cicsdev/cics-genapp](https://github.com/cicsdev/cics-genapp) at commit `f6f3f4b2580d31b7d8dcc31ce3e3676f4cceaaaa` (IBM CICS GenApp: the general insurance application (CICS, DB2, VSAM)).
- **Source licence:** EPL-2.0. This directory is derived from that source (its names, literals and
  source references carry over), so the source's licence terms apply to it. The source's own licence and
  notice files are copied here unchanged (LICENSE), and every
  generated Java file opens with a notice naming the source, its commit and licence, and that it was
  modified in generation.
- **Generator:** [GitGalaxy](https://github.com/squid-protocol/gitgalaxy) at commit [`0c2e00183aeb`](https://github.com/squid-protocol/gitgalaxy/commit/0c2e00183aebfc87b66a1f75296920e474abf5c5).
- **Commands** (from a GitGalaxy checkout at that commit, the corpus at that ref):

  ```
  python tests/tools/mainframe_corpus.py fetch cics-genapp
  python tests/tools/publish_examples.py <this repository> --only genapp
  ```

  which runs `cobol-refractor <corpus> --scan`, then `cobol-to-java <clean room>` with the default
  target config (Spring Boot 3.2, Java 17, Lombok, Maven), and blanks the run's timestamps.
- **Compiles:** the repository's `compile` workflow builds `java/` on every push; GitGalaxy's own
  `java-compile` CI builds this corpus in 17 target configurations.
