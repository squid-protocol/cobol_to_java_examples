package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record INQACC-COMMAREA (src/base/cobol_copy/INQACC.cpy), 103 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Inqacc receives, as passed by LINK at src/base/cobol_src/BNK1DAC.cbl:553.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class InqaccCommarea {

    // INQACC-EYE: PIC X(4), offset 0, 4 bytes (src/base/cobol_copy/INQACC.cpy)
    private String inqaccEye;

    // INQACC-CUSTNO: PIC 9(10), offset 4, 10 bytes (src/base/cobol_copy/INQACC.cpy)
    private Long inqaccCustno;

    // INQACC-SCODE: PIC 9(6), offset 14, 6 bytes (src/base/cobol_copy/INQACC.cpy)
    private Integer inqaccScode;

    // INQACC-ACCNO: PIC 9(8), offset 20, 8 bytes (src/base/cobol_copy/INQACC.cpy)
    private Integer inqaccAccno;

    // INQACC-ACC-TYPE: PIC X(8), offset 28, 8 bytes (src/base/cobol_copy/INQACC.cpy)
    private String inqaccAccType;

    // INQACC-INT-RATE: PIC 9(4)V99, offset 36, 6 bytes (src/base/cobol_copy/INQACC.cpy)
    private BigDecimal inqaccIntRate;

    // INQACC-OPENED: PIC 9(8), offset 42, 8 bytes (src/base/cobol_copy/INQACC.cpy)
    private Integer inqaccOpened;

    // INQACC-OVERDRAFT: PIC 9(8), offset 50, 8 bytes (src/base/cobol_copy/INQACC.cpy)
    private Integer inqaccOverdraft;

    // INQACC-LAST-STMT-DT: PIC 9(8), offset 58, 8 bytes (src/base/cobol_copy/INQACC.cpy)
    private Integer inqaccLastStmtDt;

    // INQACC-NEXT-STMT-DT: PIC 9(8), offset 66, 8 bytes (src/base/cobol_copy/INQACC.cpy)
    private Integer inqaccNextStmtDt;

    // INQACC-AVAIL-BAL: PIC S9(10)V99, offset 74, 12 bytes (src/base/cobol_copy/INQACC.cpy)
    private BigDecimal inqaccAvailBal;

    // INQACC-ACTUAL-BAL: PIC S9(10)V99, offset 86, 12 bytes (src/base/cobol_copy/INQACC.cpy)
    private BigDecimal inqaccActualBal;

    // INQACC-SUCCESS: PIC X, offset 98, 1 bytes (src/base/cobol_copy/INQACC.cpy)
    private String inqaccSuccess;

    // INQACC-PCB1-POINTER: POINTER, offset 99, 4 bytes (src/base/cobol_copy/INQACC.cpy)
    private String inqaccPcb1Pointer;

}