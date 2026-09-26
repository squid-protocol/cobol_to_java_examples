package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * PL/I structure COMMAREA (src/GML/R001TE01.pli), 6 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA R001te01 receives as its main procedure's parameter (COMMAREA).
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class R001te01Commarea {

    // SIDE: FIXED BIN(15), offset 0, 2 bytes (src/GML/R001TE01.pli)
    private Integer side;

    // TRANSKODE: CHAR(4), offset 2, 4 bytes (src/GML/R001TE01.pli)
    private String transkode;

}