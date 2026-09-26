package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * PL/I structure FEIL_STRUC (src/GML/R0011306.pli), 85 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA SrcGmlR0019921 receives, as passed by LINK at src/GML/R0011306.pli:520, LINK at src/GML/R0011306.pli:558, LINK at src/GML/R0011306.pli:596, LINK at src/GML/R0011306.pli:632.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class FeilStruc {

    // FEIL_NR: FIXED DEC(5), offset 0, 3 bytes (src/GML/R0011306.pli)
    private Integer feilNr;

    // FEIL_MELDING: CHAR(78), offset 3, 78 bytes (src/GML/R0011306.pli)
    private String feilMelding;

    // KOM_OMR_PEKER: POINTER, offset 81, 4 bytes (src/GML/R0011306.pli)
    private Long komOmrPeker;

}