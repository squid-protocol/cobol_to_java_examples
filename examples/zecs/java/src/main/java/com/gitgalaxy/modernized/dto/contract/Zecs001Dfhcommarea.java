package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (Source/ZECS001.cbl), 1 bytes, from GitGalaxy's verified skeleton.
 * The DFHCOMMAREA Zecs001 declares in its LINKAGE SECTION.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Zecs001Dfhcommarea {

    // DFHCOMMAREA: PIC X(01), offset 0, 1 bytes (Source/ZECS001.cbl)
    private String dfhcommarea;

}