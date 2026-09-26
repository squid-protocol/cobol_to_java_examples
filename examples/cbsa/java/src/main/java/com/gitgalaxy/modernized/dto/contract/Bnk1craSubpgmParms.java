package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record SUBPGM-PARMS (src/base/cobol_src/BNK1CRA.cbl), 92 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Dbcrfun receives, as passed by LINK at src/base/cobol_src/BNK1CRA.cbl:511.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1craSubpgmParms {

    // SUBPGM-ACCNO: PIC X(8), offset 0, 8 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private String subpgmAccno;

    // SUBPGM-AMT: PIC S9(10)V99, offset 8, 12 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private BigDecimal subpgmAmt;

    // SUBPGM-SORTC: PIC 9(6), offset 20, 6 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private Integer subpgmSortc;

    // SUBPGM-AV-BAL: PIC S9(10)V99, offset 26, 12 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private BigDecimal subpgmAvBal;

    // SUBPGM-ACT-BAL: PIC S9(10)V99, offset 38, 12 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private BigDecimal subpgmActBal;

    // SUBPGM-APPLID: PIC X(8), offset 50, 8 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private String subpgmApplid;

    // SUBPGM-USERID: PIC X(8), offset 58, 8 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private String subpgmUserid;

    // SUBPGM-FACILITY-NAME: PIC X(8), offset 66, 8 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private String subpgmFacilityName;

    // SUBPGM-NETWRK-ID: PIC X(8), offset 74, 8 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private String subpgmNetwrkId;

    // SUBPGM-FACILTYPE: PIC S9(8) COMP, offset 82, 4 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private Integer subpgmFaciltype;

    // SUBPGM-SUCCESS: PIC X, offset 90, 1 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private String subpgmSuccess;

    // SUBPGM-FAIL-CODE: PIC X, offset 91, 1 bytes (src/base/cobol_src/BNK1CRA.cbl)
    private String subpgmFailCode;

}