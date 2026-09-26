package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * PL/I structure FNR_REG (src/GML/R0011003.pli), 16 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA SrcGmlR0019906 receives, as passed by LINK at src/GML/R0011003.pli:187, LINK at src/GML/R0011003.pli:327, LINK at src/GML/R0011003.pli:514, LINK at src/GML/R0011003.pli:838, LINK at src/GML/R0011003.pli:1059.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class FnrReg {

    // FNR1: FIXED DEC(11), offset 0, 6 bytes (src/GML/R0011003.pli)
    private Long fnr1;

    // FNR2: FIXED DEC(11), offset 6, 6 bytes (src/GML/R0011003.pli)
    private Long fnr2;

    // BRUKERID: CHAR(4), offset 12, 4 bytes (src/GML/R0011003.pli)
    private String brukerid;

}