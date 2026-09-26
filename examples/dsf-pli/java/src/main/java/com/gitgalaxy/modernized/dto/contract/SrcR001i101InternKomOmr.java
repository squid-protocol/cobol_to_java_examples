package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * PL/I structure INTERN_KOM_OMR (src/R001I101.pli), 26 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA SrcR001i201 receives, as passed by LINK at src/R001I101.pli:288.
 * The COMMAREA SrcR001i301 receives, as passed by LINK at src/R001I101.pli:306.
 * The COMMAREA SrcR001i701 receives, as passed by LINK at src/R001I101.pli:324.
 * The COMMAREA SrcR001i801 receives, as passed by LINK at src/R001I101.pli:340.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class SrcR001i101InternKomOmr {

    // HOVED_KOM_PTR: POINTER, offset 0, 4 bytes (src/R001I101.pli)
    private Long hovedKomPtr;

    // FRA_FNR: PIC '(11)9', offset 4, 11 bytes (src/R001I101.pli)
    private Long fraFnr;

    // TIL_FNR: PIC '(11)9', offset 15, 11 bytes (src/R001I101.pli)
    private Long tilFnr;

}