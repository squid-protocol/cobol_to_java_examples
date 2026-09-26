package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-THIS-PROGCOMMAREA (app/app-transaction-type-db2/cbl/COTRTUPC.cbl), 105 bytes, from GitGalaxy's verified skeleton.
 * Bytes 160-264 of the COMMAREA Cotrtupc reads: MOVE DFHCOMMAREA(LENGTH OF CARDDEMO-COMMAREA + 1:LENGTH OF WS-THIS-PROGCOMMAREA) at app/app-transaction-type-db2/cbl/COTRTUPC.cbl:378.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CotrtupcWsThisProgcommarea {

    // TTUP-CHANGE-ACTION: PIC X(1), offset 0, 1 bytes (app/app-transaction-type-db2/cbl/COTRTUPC.cbl)
    private String ttupChangeAction;

    // TTUP-OLD-TTYP-TYPE: PIC X(02), offset 1, 2 bytes (app/app-transaction-type-db2/cbl/COTRTUPC.cbl)
    private String ttupOldTtypType;

    // TTUP-OLD-TTYP-TYPE-DESC: PIC X(50), offset 3, 50 bytes (app/app-transaction-type-db2/cbl/COTRTUPC.cbl)
    private String ttupOldTtypTypeDesc;

    // TTUP-NEW-TTYP-TYPE: PIC X(02), offset 53, 2 bytes (app/app-transaction-type-db2/cbl/COTRTUPC.cbl)
    private String ttupNewTtypType;

    // TTUP-NEW-TTYP-TYPE-DESC: PIC X(50), offset 55, 50 bytes (app/app-transaction-type-db2/cbl/COTRTUPC.cbl)
    private String ttupNewTtypTypeDesc;

}