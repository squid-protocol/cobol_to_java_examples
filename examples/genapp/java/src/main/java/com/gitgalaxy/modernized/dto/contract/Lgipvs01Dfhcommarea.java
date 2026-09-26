package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (base/src/lgipvs01.cbl), 90 bytes, from GitGalaxy's verified skeleton.
 * The DFHCOMMAREA Lgipvs01 declares in its LINKAGE SECTION.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Lgipvs01Dfhcommarea {

    // COMMA-DATA-TEXT: PIC X(11), offset 0, 11 bytes (base/src/lgipvs01.cbl)
    private String commaDataText;

    // COMMA-DATA-KEY: PIC X(21), offset 11, 21 bytes (base/src/lgipvs01.cbl)
    private String commaDataKey;

}