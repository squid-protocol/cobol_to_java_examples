package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record SUBPGM-PARMS (src/base/cobol_src/BNK1CAC.cbl), 100 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Creacc receives, as passed by LINK at src/base/cobol_src/BNK1CAC.cbl:775.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1cacSubpgmParms {

    // SUBPGM-EYECATCHER: PIC X(4), offset 0, 4 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private String subpgmEyecatcher;

    // SUBPGM-CUSTNO: PIC 9(10), offset 4, 10 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private Long subpgmCustno;

    // SUBPGM-SORTCODE: PIC 9(6) DISPLAY, offset 14, 6 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private Integer subpgmSortcode;

    // SUBPGM-NUMBER: PIC 9(8) DISPLAY, offset 20, 8 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private Integer subpgmNumber;

    // SUBPGM-ACC-TYPE: PIC X(8), offset 28, 8 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private String subpgmAccType;

    // SUBPGM-INT-RT: PIC 9(4)V99, offset 36, 6 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private BigDecimal subpgmIntRt;

    // SUBPGM-OPENED: PIC 9(8), offset 42, 8 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private Integer subpgmOpened;

    // SUBPGM-OVERDR-LIM: PIC 9(8), offset 50, 8 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private Integer subpgmOverdrLim;

    // SUBPGM-LAST-STMT-DT: PIC 9(8), offset 58, 8 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private Integer subpgmLastStmtDt;

    // SUBPGM-NEXT-STMT-DT: PIC 9(8), offset 66, 8 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private Integer subpgmNextStmtDt;

    // SUBPGM-AVAIL-BAL: PIC S9(10)V99, offset 74, 12 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private BigDecimal subpgmAvailBal;

    // SUBPGM-ACT-BAL: PIC S9(10)V99, offset 86, 12 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private BigDecimal subpgmActBal;

    // SUBPGM-SUCCESS: PIC X, offset 98, 1 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private String subpgmSuccess;

    // SUBPGM-FAIL-CODE: PIC X, offset 99, 1 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private String subpgmFailCode;

}