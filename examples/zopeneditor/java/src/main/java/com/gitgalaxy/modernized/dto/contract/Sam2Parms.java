package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record SAM2-PARMS (multiroot/copybooks/trans/SAM2PARM.cpy), 33 bytes, from GitGalaxy's verified skeleton.
 * USING parameter 5 of MultirootSamSam2.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Sam2Parms {

    // CRUNCH-TOTAL: PIC 9(16), offset 0, 16 bytes (multiroot/copybooks/trans/SAM2PARM.cpy)
    private Long crunchTotal;

    // CRUNCH-AVG: PIC 9(16), offset 17, 16 bytes (multiroot/copybooks/trans/SAM2PAR5.cpy)
    private Long crunchAvg;

}