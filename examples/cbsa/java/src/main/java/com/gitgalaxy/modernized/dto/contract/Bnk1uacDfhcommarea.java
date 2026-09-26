package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (src/base/cobol_src/BNK1UAC.cbl), 103 bytes, from GitGalaxy's verified skeleton.
 * The DFHCOMMAREA Bnk1uac declares in its LINKAGE SECTION.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1uacDfhcommarea {

    // COMM-EYE: PIC X(4), offset 0, 4 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private String commEye;

    // COMM-CUSTNO: PIC X(10), offset 4, 10 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private String commCustno;

    // COMM-SCODE: PIC X(6), offset 14, 6 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private String commScode;

    // COMM-ACCNO: PIC 9(8), offset 20, 8 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private Integer commAccno;

    // COMM-ACC-TYPE: PIC X(8), offset 28, 8 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private String commAccType;

    // COMM-INT-RATE: PIC 9(4)V99, offset 36, 6 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private BigDecimal commIntRate;

    // COMM-OPENED: PIC 9(8), offset 42, 8 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private Integer commOpened;

    // COMM-OVERDRAFT: PIC 9(8), offset 50, 8 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private Integer commOverdraft;

    // COMM-LAST-STMT-DT: PIC 9(8), offset 58, 8 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private Integer commLastStmtDt;

    // COMM-NEXT-STMT-DT: PIC 9(8), offset 66, 8 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private Integer commNextStmtDt;

    // COMM-AVAIL-BAL: PIC S9(10)V99, offset 74, 12 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private BigDecimal commAvailBal;

    // COMM-ACTUAL-BAL: PIC S9(10)V99, offset 86, 12 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private BigDecimal commActualBal;

    // COMM-SUCCESS: PIC X, offset 98, 1 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private String commSuccess;

    // COMM-PCB1-POINTER: POINTER, offset 99, 4 bytes (src/base/cobol_src/BNK1UAC.cbl)
    private String commPcb1Pointer;

}