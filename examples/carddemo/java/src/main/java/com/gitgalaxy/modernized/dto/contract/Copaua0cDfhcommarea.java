package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl), 4096 bytes, from GitGalaxy's verified skeleton.
 * The DFHCOMMAREA Copaua0c declares in its LINKAGE SECTION.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Copaua0cDfhcommarea {

    // LK-COMMAREA: PIC X(4096), offset 0, 4096 bytes (app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl)
    private String lkCommarea;

}