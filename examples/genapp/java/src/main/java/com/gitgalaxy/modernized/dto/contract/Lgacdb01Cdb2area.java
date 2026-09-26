package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record CDB2AREA (base/src/lgacdb01.cbl), 32500 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Lgacdb02 receives, as passed by LINK at base/src/lgacdb01.cbl:186.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Lgacdb01Cdb2area {

    // D2-REQUEST-ID: PIC X(6), offset 0, 6 bytes (base/src/lgacdb01.cbl)
    private String d2RequestId;

    // D2-RETURN-CODE: PIC 9(2), offset 6, 2 bytes (base/src/lgacdb01.cbl)
    private Integer d2ReturnCode;

    // D2-CUSTOMER-NUM: PIC 9(10), offset 8, 10 bytes (base/src/lgacdb01.cbl)
    private Long d2CustomerNum;

    // D2-CUSTSECR-PASS: PIC X(32), offset 18, 32 bytes (base/src/lgacdb01.cbl)
    private String d2CustsecrPass;

    // D2-CUSTSECR-COUNT: PIC X(4), offset 50, 4 bytes (base/src/lgacdb01.cbl)
    private String d2CustsecrCount;

    // D2-CUSTSECR-STATE: PIC X, offset 54, 1 bytes (base/src/lgacdb01.cbl)
    private String d2CustsecrState;

    // D2-CUSTSECR-DATA: PIC X(32445), offset 55, 32445 bytes (base/src/lgacdb01.cbl)
    private String d2CustsecrData;

}