package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (src/base/cobol_src/GETCOMPY.cbl), 40 bytes, from GitGalaxy's verified skeleton.
 * The DFHCOMMAREA Getcompy declares in its LINKAGE SECTION.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class GetcompyDfhcommarea {

    // COMPANY-NAME: PIC x(40), offset 0, 40 bytes (src/base/cobol_copy/GETCOMPY.cpy)
    private String companyName;

}