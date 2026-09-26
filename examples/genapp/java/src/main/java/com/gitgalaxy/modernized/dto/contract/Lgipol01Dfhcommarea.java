package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (base/src/lgipol01.cbl), 32500 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Lgipdb01 receives, as passed by LINK at base/src/lgipol01.cbl:91.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Lgipol01Dfhcommarea {

    // CA-REQUEST-ID: PIC X(6), offset 0, 6 bytes (base/src/lgcmarea.cpy)
    private String caRequestId;

    // CA-RETURN-CODE: PIC 9(2), offset 6, 2 bytes (base/src/lgcmarea.cpy)
    private Integer caReturnCode;

    // CA-CUSTOMER-NUM: PIC 9(10), offset 8, 10 bytes (base/src/lgcmarea.cpy)
    private Long caCustomerNum;

    // CA-REQUEST-SPECIFIC: PIC X(32482), offset 18, 32482 bytes (base/src/lgcmarea.cpy)
    private String caRequestSpecific;

}