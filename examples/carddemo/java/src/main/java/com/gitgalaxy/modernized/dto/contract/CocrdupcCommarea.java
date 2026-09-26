package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The COMMAREA Cocrdupc reads, as app/cbl/COCRDUPC.cbl unpacks DFHCOMMAREA at lines 396, 398: CARDDEMO-COMMAREA + WS-THIS-PROGCOMMAREA = 489 bytes.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CocrdupcCommarea {

    // DFHCOMMAREA(1:LENGTH OF CARDDEMO-COMMAREA) at line 396: offset 0, 160 bytes -> CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy)
    private CarddemoCommarea carddemoCommarea;

    // DFHCOMMAREA(LENGTH OF CARDDEMO-COMMAREA + 1:LENGTH OF WS-THIS-PROGCOMMAREA) at line 398: offset 160, 329 bytes -> WS-THIS-PROGCOMMAREA (app/cbl/COCRDUPC.cbl)
    private CocrdupcWsThisProgcommarea wsThisProgcommarea;

    /** A caller that passes only CARDDEMO-COMMAREA (the leading 160 bytes): the rest is not supplied. */
    public static CocrdupcCommarea fromPrefix(CarddemoCommarea carddemoCommarea) {
        CocrdupcCommarea commarea = new CocrdupcCommarea();
        commarea.carddemoCommarea = carddemoCommarea;
        return commarea;
    }
}