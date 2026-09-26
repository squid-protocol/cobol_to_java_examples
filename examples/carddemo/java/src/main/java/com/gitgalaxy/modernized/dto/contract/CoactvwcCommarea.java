package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The COMMAREA Coactvwc reads, as app/cbl/COACTVWC.cbl unpacks DFHCOMMAREA at lines 288, 290: CARDDEMO-COMMAREA + WS-THIS-PROGCOMMAREA = 172 bytes.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CoactvwcCommarea {

    // DFHCOMMAREA(1:LENGTH OF CARDDEMO-COMMAREA) at line 288: offset 0, 160 bytes -> CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy)
    private CarddemoCommarea carddemoCommarea;

    // DFHCOMMAREA(LENGTH OF CARDDEMO-COMMAREA + 1:LENGTH OF WS-THIS-PROGCOMMAREA) at line 290: offset 160, 12 bytes -> WS-THIS-PROGCOMMAREA (app/cbl/COACTVWC.cbl)
    private CoactvwcWsThisProgcommarea wsThisProgcommarea;

    /** A caller that passes only CARDDEMO-COMMAREA (the leading 160 bytes): the rest is not supplied. */
    public static CoactvwcCommarea fromPrefix(CarddemoCommarea carddemoCommarea) {
        CoactvwcCommarea commarea = new CoactvwcCommarea();
        commarea.carddemoCommarea = carddemoCommarea;
        return commarea;
    }
}