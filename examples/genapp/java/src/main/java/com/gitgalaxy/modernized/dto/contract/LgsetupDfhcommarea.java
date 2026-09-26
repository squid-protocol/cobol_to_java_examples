package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (base/src/lgsetup.cbl), 84 bytes, from GitGalaxy's verified skeleton.
 * The DFHCOMMAREA Lgsetup declares in its LINKAGE SECTION.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class LgsetupDfhcommarea {

    // COMMA-DATA-H: PIC X(14), offset 0, 14 bytes (base/src/lgsetup.cbl)
    private String commaDataH;

    // COMMA-DATA-HIGH: PIC 9(10), offset 14, 10 bytes (base/src/lgsetup.cbl)
    private Long commaDataHigh;

}