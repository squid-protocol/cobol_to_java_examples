package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * PL/I structure FEIL_STRUC (src/R0011306.pli), 85 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA SrcR0019921 receives, as passed by LINK at src/R0011306.pli:521, LINK at src/R0011306.pli:559, LINK at src/R0011306.pli:597, LINK at src/R0011306.pli:633.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class FeilStruc2 {

    // FEIL_NR: FIXED DEC(5), offset 0, 3 bytes (src/R0011306.pli)
    private Integer feilNr;

    // FEIL_MELDING: CHAR(78), offset 3, 78 bytes (src/R0011306.pli)
    private String feilMelding;

    // KOM_OMR_PEKER: POINTER, offset 81, 4 bytes (src/R0011306.pli)
    private Long komOmrPeker;

}