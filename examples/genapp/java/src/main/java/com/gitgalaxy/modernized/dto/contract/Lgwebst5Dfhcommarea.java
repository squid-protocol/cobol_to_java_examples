package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (base/src/lgwebst5.cbl), 84 bytes, from GitGalaxy's verified skeleton.
 * The DFHCOMMAREA Lgwebst5 declares in its LINKAGE SECTION.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Lgwebst5Dfhcommarea {

    // COMMA-DATA-H: PIC X(14), offset 0, 14 bytes (base/src/lgwebst5.cbl)
    private String commaDataH;

    // COMMA-DATA-HIGH: PIC 9(10), offset 14, 10 bytes (base/src/lgwebst5.cbl)
    private Long commaDataHigh;

}