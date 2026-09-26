package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (src/base/cobol_src/GETSCODE.cbl), 6 bytes, from GitGalaxy's verified skeleton.
 * The DFHCOMMAREA Getscode declares in its LINKAGE SECTION.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class GetscodeDfhcommarea {

    // SORTCODE: PIC xXXXXX, offset 0, 6 bytes (src/base/cobol_copy/GETSCODE.cpy)
    private String sortcode;

}