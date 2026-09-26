package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-COMM-AREA (src/base/cobol_src/BNK1DCS.cbl), 266 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Bnk1dcs receives, as passed by RETURN TRANSID at src/base/cobol_src/BNK1DCS.cbl:326.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1dcsWsCommArea {

    // WS-COMM-TERM: PIC S9(8) COMP, offset 0, 4 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private Integer wsCommTerm;

    // WS-COMM-EYE: PIC X(4), offset 4, 4 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private String wsCommEye;

    // WS-COMM-SCODE: PIC X(6), offset 8, 6 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private String wsCommScode;

    // WS-COMM-CUSTNO: PIC X(10), offset 14, 10 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private String wsCommCustno;

    // WS-COMM-NAME: PIC X(60), offset 24, 60 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private String wsCommName;

    // WS-COMM-ADDR: PIC X(160), offset 84, 160 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private String wsCommAddr;

    // WS-COMM-DOB: PIC 9(8), offset 244, 8 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private Integer wsCommDob;

    // WS-COMM-CREDIT-SCORE: PIC 9(3), offset 252, 3 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private Integer wsCommCreditScore;

    // WS-COMM-CS-REVIEW-DATE: PIC 9(8), offset 255, 8 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private Integer wsCommCsReviewDate;

    // WS-COMM-DEL-SUCCESS: PIC X, offset 263, 1 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private String wsCommDelSuccess;

    // WS-COMM-DEL-FAIL-CD: PIC X, offset 264, 1 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private String wsCommDelFailCd;

    // WS-COMM-UPDATE: PIC X, offset 265, 1 bytes (src/base/cobol_src/BNK1DCS.cbl)
    private String wsCommUpdate;

}