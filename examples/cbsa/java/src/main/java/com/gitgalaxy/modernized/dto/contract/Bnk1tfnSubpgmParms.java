package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record SUBPGM-PARMS (src/base/cobol_src/BNK1TFN.cbl), 90 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Xfrfun receives, as passed by LINK at src/base/cobol_src/BNK1TFN.cbl:496.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1tfnSubpgmParms {

    // SUBPGM-FACCNO: PIC 9(8), offset 0, 8 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private Integer subpgmFaccno;

    // SUBPGM-FSCODE: PIC 9(6), offset 8, 6 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private Integer subpgmFscode;

    // SUBPGM-TACCNO: PIC 9(8), offset 14, 8 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private Integer subpgmTaccno;

    // SUBPGM-TSCODE: PIC 9(6), offset 22, 6 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private Integer subpgmTscode;

    // SUBPGM-AMT: PIC S9(10)V99, offset 28, 12 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private BigDecimal subpgmAmt;

    // SUBPGM-FAVBAL: PIC S9(10)V99, offset 40, 12 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private BigDecimal subpgmFavbal;

    // SUBPGM-FACTBAL: PIC S9(10)V99, offset 52, 12 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private BigDecimal subpgmFactbal;

    // SUBPGM-TAVBAL: PIC S9(10)V99, offset 64, 12 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private BigDecimal subpgmTavbal;

    // SUBPGM-TACTBAL: PIC S9(10)V99, offset 76, 12 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private BigDecimal subpgmTactbal;

    // SUBPGM-FAIL-CODE: PIC X, offset 88, 1 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private String subpgmFailCode;

    // SUBPGM-SUCCESS: PIC X, offset 89, 1 bytes (src/base/cobol_src/BNK1TFN.cbl)
    private String subpgmSuccess;

}