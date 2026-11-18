# carddemo: provenance

- **Source:** [https://github.com/aws-samples/aws-mainframe-modernization-carddemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo) at commit `59cc6c2fd7ebd7ef7925cad552a01a4b8b6e4d5e` (AWS CardDemo: CICS online (BMS screens, COMMAREA), VSAM, DB2, IMS, MQ and a JCL batch cycle).
- **Source licence:** Apache-2.0. This directory is derived from that source (its names, literals and
  source references carry over), so the source's licence terms apply to it. The source's own licence and
  notice files are copied here unchanged (LICENSE, NOTICE), and every
  generated Java file opens with a notice naming the source, its commit and licence, and that it was
  modified in generation.
- **Generator:** [GitGalaxy](https://github.com/squid-protocol/gitgalaxy) at commit [`93847302510e`](https://github.com/squid-protocol/gitgalaxy/commit/93847302510ebc9ab3f03c756de0c0ee1578e361).
- **Commands** (from a GitGalaxy checkout at that commit, the corpus at that ref):

  ```
  python tests/tools/mainframe_corpus.py fetch aws-mainframe-modernization-carddemo
  python tests/tools/publish_examples.py <this repository> --only carddemo
  ```

  which runs `cobol-refractor <corpus> --scan`, then `cobol-to-java <clean room>` with the default
  target config (Spring Boot 3.2, Java 17, Lombok, Maven), and blanks the run's timestamps.
- **Porting tickets:** `java/ai_agent_jobs/*_port_ticket.{json,md}`, one per program with business logic to
  write. Their numbered source listings (`ai_agent_jobs/sources/`) are left out here -- they are the source
  at the commit above -- and are regenerated with the tickets by the commands above.
- **Compiles:** the repository's `compile` workflow builds `java/` on every push; GitGalaxy's own
  `java-compile` CI builds this corpus in 17 target configurations.
