package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-COMM-AREA (src/base/cobol_src/BNK1CRA.cbl), 21 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Bnk1cra receives, as passed by RETURN TRANSID at src/base/cobol_src/BNK1CRA.cbl:263.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1craWsCommArea {

    // WS-COMM-ACCNO: PIC X(8), offset 0, 8 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private String wsCommAccno;

    // WS-COMM-SIGN: PIC X, offset 8, 1 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private String wsCommSign;

    // WS-COMM-AMT: PIC 9(12), offset 9, 12 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private Long wsCommAmt;

}