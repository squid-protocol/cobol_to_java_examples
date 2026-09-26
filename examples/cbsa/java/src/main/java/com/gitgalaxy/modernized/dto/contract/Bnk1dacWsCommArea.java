package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-COMM-AREA (src/base/cobol_src/BNK1DAC.cbl), 102 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Bnk1dac receives, as passed by RETURN TRANSID at src/base/cobol_src/BNK1DAC.cbl:295.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1dacWsCommArea {

    // WS-COMM-EYE: PIC X(4), offset 0, 4 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private String wsCommEye;

    // WS-COMM-CUSTNO: PIC X(10), offset 4, 10 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private String wsCommCustno;

    // WS-COMM-SCODE: PIC X(6), offset 14, 6 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private String wsCommScode;

    // WS-COMM-ACCNO: PIC 9(8), offset 20, 8 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private Integer wsCommAccno;

    // WS-COMM-ACC-TYPE: PIC X(8), offset 28, 8 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private String wsCommAccType;

    // WS-COMM-INT-RATE: PIC 9(4)V99, offset 36, 6 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private BigDecimal wsCommIntRate;

    // WS-COMM-OPENED: PIC 9(8), offset 42, 8 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private Integer wsCommOpened;

    // WS-COMM-OVERDRAFT: PIC 9(8), offset 50, 8 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private Integer wsCommOverdraft;

    // WS-COMM-LAST-STMT-DT: PIC 9(8), offset 58, 8 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private Integer wsCommLastStmtDt;

    // WS-COMM-NEXT-STMT-DT: PIC 9(8), offset 66, 8 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private Integer wsCommNextStmtDt;

    // WS-COMM-AVAIL-BAL: PIC S9(10)V99, offset 74, 12 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private BigDecimal wsCommAvailBal;

    // WS-COMM-ACTUAL-BAL: PIC S9(10)V99, offset 86, 12 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private BigDecimal wsCommActualBal;

    // WS-COMM-SUCCESS: PIC X, offset 98, 1 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private String wsCommSuccess;

    // WS-COMM-FAIL-CD: PIC X, offset 99, 1 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private String wsCommFailCd;

    // WS-COMM-DEL-SUCCESS: PIC X, offset 100, 1 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private String wsCommDelSuccess;

    // WS-COMM-DEL-FAIL-CD: PIC X, offset 101, 1 bytes (src/base/cobol_src/BNK1DAC.cbl)
    private String wsCommDelFailCd;

}