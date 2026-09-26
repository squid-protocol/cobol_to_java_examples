package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The COMMAREA Cotrtlic reads, as app/app-transaction-type-db2/cbl/COTRTLIC.cbl unpacks DFHCOMMAREA at lines 527, 529: CARDDEMO-COMMAREA + WS-THIS-PROGCOMMAREA = 587 bytes.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CotrtlicCommarea {

    // DFHCOMMAREA(1:LENGTH OF CARDDEMO-COMMAREA) at line 527: offset 0, 160 bytes -> CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy)
    private CarddemoCommarea carddemoCommarea;

    // DFHCOMMAREA(LENGTH OF CARDDEMO-COMMAREA + 1:LENGTH OF WS-THIS-PROGCOMMAREA) at line 529: offset 160, 427 bytes -> WS-THIS-PROGCOMMAREA (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private CotrtlicWsThisProgcommarea wsThisProgcommarea;

    /** A caller that passes only CARDDEMO-COMMAREA (the leading 160 bytes): the rest is not supplied. */
    public static CotrtlicCommarea fromPrefix(CarddemoCommarea carddemoCommarea) {
        CotrtlicCommarea commarea = new CotrtlicCommarea();
        commarea.carddemoCommarea = carddemoCommarea;
        return commarea;
    }
}