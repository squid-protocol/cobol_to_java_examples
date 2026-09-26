package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-COMMAREA (src/base/cobol_src/BNK1TFN.cbl), 28 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Bnk1tfn receives, as passed by RETURN TRANSID at src/base/cobol_src/BNK1TFN.cbl:247.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1tfnWsCommarea {

    // WS-COMMAREA-FACCNO: PIC 9(8), offset 0, 8 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private Integer wsCommareaFaccno;

    // WS-COMMAREA-TACCNO: PIC 9(8), offset 8, 8 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private Integer wsCommareaTaccno;

    // WS-COMMAREA-AMT: PIC 9(12), offset 16, 12 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private Long wsCommareaAmt;

}