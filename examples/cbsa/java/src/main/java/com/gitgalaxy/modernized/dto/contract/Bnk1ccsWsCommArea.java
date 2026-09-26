package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-COMM-AREA (src/base/cobol_src/BNK1CCS.cbl), 5 bytes, from GitGalaxy's verified skeleton.
 * Bytes 0-4 of the COMMAREA Bnk1ccs reads: MOVE DFHCOMMAREA at src/base/cobol_src/BNK1CCS.cbl:263.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1ccsWsCommArea {

    // WS-COMM-DATA: PIC X, offset 0, 1 bytes (src/base/cobol_src/BNK1CCS.cbl)
    private String wsCommData;

    // WS-COMM-TERM: PIC S9(8) COMP, offset 1, 4 bytes (src/base/cobol_src/BNK1CCS.cbl)
    private Integer wsCommTerm;

}