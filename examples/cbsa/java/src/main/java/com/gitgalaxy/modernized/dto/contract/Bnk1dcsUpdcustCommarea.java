package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record UPDCUST-COMMAREA (src/base/cobol_src/BNK1DCS.cbl), 261 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Updcust receives, as passed by LINK at src/base/cobol_src/BNK1DCS.cbl:1155.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1dcsUpdcustCommarea {

    // COMM-EYE: PIC X(4), offset 0, 4 bytes (src/base/cobol_copy/UPDCUST.cpy)
    private String commEye;

    // COMM-SCODE: PIC X(6), offset 4, 6 bytes (src/base/cobol_copy/UPDCUST.cpy)
    private String commScode;

    // COMM-CUSTNO: PIC X(10), offset 10, 10 bytes (src/base/cobol_copy/UPDCUST.cpy)
    private String commCustno;

    // COMM-NAME: PIC X(60), offset 20, 60 bytes (src/base/cobol_copy/UPDCUST.cpy)
    private String commName;

    // COMM-ADDR: PIC X(160), offset 80, 160 bytes (src/base/cobol_copy/UPDCUST.cpy)
    private String commAddr;

    // COMM-DOB: PIC 9(8), offset 240, 8 bytes (src/base/cobol_copy/UPDCUST.cpy)
    private Integer commDob;

    // COMM-CREDIT-SCORE: PIC 9(3), offset 248, 3 bytes (src/base/cobol_copy/UPDCUST.cpy)
    private Integer commCreditScore;

    // COMM-CS-REVIEW-DATE: PIC 9(8), offset 251, 8 bytes (src/base/cobol_copy/UPDCUST.cpy)
    private Integer commCsReviewDate;

    // COMM-UPD-SUCCESS: PIC X, offset 259, 1 bytes (src/base/cobol_copy/UPDCUST.cpy)
    private String commUpdSuccess;

    // COMM-UPD-FAIL-CD: PIC X, offset 260, 1 bytes (src/base/cobol_copy/UPDCUST.cpy)
    private String commUpdFailCd;

}