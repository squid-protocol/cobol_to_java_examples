package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The COMMAREA Coactupc reads, as app/cbl/COACTUPC.cbl unpacks DFHCOMMAREA at lines 888, 890: CARDDEMO-COMMAREA + WS-THIS-PROGCOMMAREA = 1033 bytes.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CoactupcCommarea {

    // DFHCOMMAREA(1:LENGTH OF CARDDEMO-COMMAREA) at line 888: offset 0, 160 bytes -> CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy)
    private CarddemoCommarea carddemoCommarea;

    // DFHCOMMAREA(LENGTH OF CARDDEMO-COMMAREA + 1:LENGTH OF WS-THIS-PROGCOMMAREA) at line 890: offset 160, 873 bytes -> WS-THIS-PROGCOMMAREA (app/cbl/COACTUPC.cbl)
    private CoactupcWsThisProgcommarea wsThisProgcommarea;

    /** A caller that passes only CARDDEMO-COMMAREA (the leading 160 bytes): the rest is not supplied. */
    public static CoactupcCommarea fromPrefix(CarddemoCommarea carddemoCommarea) {
        CoactupcCommarea commarea = new CoactupcCommarea();
        commarea.carddemoCommarea = carddemoCommarea;
        return commarea;
    }
}