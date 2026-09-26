package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * PL/I structure INTERN_KOM_OMR (src/GML/R001I101.pli), 26 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA SrcGmlR001i201 receives, as passed by LINK at src/GML/R001I101.pli:293.
 * The COMMAREA SrcGmlR001i301 receives, as passed by LINK at src/GML/R001I101.pli:311.
 * The COMMAREA SrcGmlR001i701 receives, as passed by LINK at src/GML/R001I101.pli:329.
 * The COMMAREA SrcGmlR001i801 receives, as passed by LINK at src/GML/R001I101.pli:345.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class SrcGmlR001i101InternKomOmr {

    // HOVED_KOM_PTR: POINTER, offset 0, 4 bytes (src/GML/R001I101.pli)
    private Long hovedKomPtr;

    // FRA_FNR: PIC '(11)9', offset 4, 11 bytes (src/GML/R001I101.pli)
    private Long fraFnr;

    // TIL_FNR: PIC '(11)9', offset 15, 11 bytes (src/GML/R001I101.pli)
    private Long tilFnr;

}