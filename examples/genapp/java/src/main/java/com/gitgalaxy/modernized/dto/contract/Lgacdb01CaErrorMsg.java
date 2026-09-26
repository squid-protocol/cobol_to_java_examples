package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record CA-ERROR-MSG (base/src/lgacdb01.cbl), 99 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Lgstsq receives, as passed by LINK at base/src/lgacdb01.cbl:316, LINK at base/src/lgacdb01.cbl:322.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Lgacdb01CaErrorMsg {

    // CA-DATA: PIC X(90), offset 9, 90 bytes (base/src/lgacdb01.cbl)
    private String caData;

}