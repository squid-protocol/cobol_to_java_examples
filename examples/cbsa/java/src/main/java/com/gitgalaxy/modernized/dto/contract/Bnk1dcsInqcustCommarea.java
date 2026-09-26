package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record INQCUST-COMMAREA (src/base/cobol_src/BNK1DCS.cbl), 265 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Inqcust receives, as passed by LINK at src/base/cobol_src/BNK1DCS.cbl:833.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1dcsInqcustCommarea {

    // INQCUST-EYE: PIC X(4), offset 0, 4 bytes (src/base/cobol_copy/INQCUST.cpy)
    private String inqcustEye;

    // INQCUST-SCODE: PIC X(6), offset 4, 6 bytes (src/base/cobol_copy/INQCUST.cpy)
    private String inqcustScode;

    // INQCUST-CUSTNO: PIC 9(10), offset 10, 10 bytes (src/base/cobol_copy/INQCUST.cpy)
    private Long inqcustCustno;

    // INQCUST-NAME: PIC X(60), offset 20, 60 bytes (src/base/cobol_copy/INQCUST.cpy)
    private String inqcustName;

    // INQCUST-ADDR: PIC X(160), offset 80, 160 bytes (src/base/cobol_copy/INQCUST.cpy)
    private String inqcustAddr;

    // INQCUST-DOB-DD: PIC 99, offset 240, 2 bytes (src/base/cobol_copy/INQCUST.cpy)
    private Integer inqcustDobDd;

    // INQCUST-DOB-MM: PIC 99, offset 242, 2 bytes (src/base/cobol_copy/INQCUST.cpy)
    private Integer inqcustDobMm;

    // INQCUST-DOB-YYYY: PIC 9999, offset 244, 4 bytes (src/base/cobol_copy/INQCUST.cpy)
    private Integer inqcustDobYyyy;

    // INQCUST-CREDIT-SCORE: PIC 999, offset 248, 3 bytes (src/base/cobol_copy/INQCUST.cpy)
    private Integer inqcustCreditScore;

    // INQCUST-CS-REVIEW-DD: PIC 99, offset 251, 2 bytes (src/base/cobol_copy/INQCUST.cpy)
    private Integer inqcustCsReviewDd;

    // INQCUST-CS-REVIEW-MM: PIC 99, offset 253, 2 bytes (src/base/cobol_copy/INQCUST.cpy)
    private Integer inqcustCsReviewMm;

    // INQCUST-CS-REVIEW-YYYY: PIC 9999, offset 255, 4 bytes (src/base/cobol_copy/INQCUST.cpy)
    private Integer inqcustCsReviewYyyy;

    // INQCUST-INQ-SUCCESS: PIC X, offset 259, 1 bytes (src/base/cobol_copy/INQCUST.cpy)
    private String inqcustInqSuccess;

    // INQCUST-INQ-FAIL-CD: PIC X, offset 260, 1 bytes (src/base/cobol_copy/INQCUST.cpy)
    private String inqcustInqFailCd;

    // INQCUST-PCB-POINTER: POINTER, offset 261, 4 bytes (src/base/cobol_copy/INQCUST.cpy)
    private String inqcustPcbPointer;

}