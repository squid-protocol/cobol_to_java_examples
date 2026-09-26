package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (Source/ZECSPLT.cbl), 1 bytes, from GitGalaxy's verified skeleton.
 * The DFHCOMMAREA Zecsplt declares in its LINKAGE SECTION.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class ZecspltDfhcommarea {

    // DFHCOMMAREA: PIC X(01), offset 0, 1 bytes (Source/ZECSPLT.cbl)
    private String dfhcommarea;

}