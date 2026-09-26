package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * PL/I structure INTERN_KOM_OMR (src/GML/R001O301.pli), 26 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA R001o301 receives as its main procedure's parameter (INTERN_KOM_OMR).
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class R001o301InternKomOmr {

    // HOVED_KOM_PTR: POINTER, offset 0, 4 bytes (src/GML/R001O301.pli)
    private Long hovedKomPtr;

    // FRA_FNR: PIC '(11)9', offset 4, 11 bytes (src/GML/R001O301.pli)
    private Long fraFnr;

    // TIL_FNR: PIC '(11)9', offset 15, 11 bytes (src/GML/R001O301.pli)
    private Long tilFnr;

}