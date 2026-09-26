package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-THIS-PROGCOMMAREA (app/app-transaction-type-db2/cbl/COTRTLIC.cbl), 427 bytes, from GitGalaxy's verified skeleton.
 * Bytes 160-586 of the COMMAREA Cotrtlic reads: MOVE DFHCOMMAREA(LENGTH OF CARDDEMO-COMMAREA + 1:LENGTH OF WS-THIS-PROGCOMMAREA) at app/app-transaction-type-db2/cbl/COTRTLIC.cbl:529.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CotrtlicWsThisProgcommarea {

    // WS-CA-TYPE-CD: PIC X(02), offset 0, 2 bytes (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private String wsCaTypeCd;

    // WS-CA-TYPE-DESC: PIC X(50), offset 2, 50 bytes (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private String wsCaTypeDesc;

    // WS-CA-ALL-ROWS-OUT: PIC X(364), offset 52, 364 bytes (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private String wsCaAllRowsOut;

    // WS-CA-ROW-SELECTED: PIC S9(4) COMP, offset 416, 2 bytes (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private Integer wsCaRowSelected;

    // WS-CA-LAST-TR-CODE: PIC X(02), offset 418, 2 bytes (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private String wsCaLastTrCode;

    // WS-CA-FIRST-TR-CODE: PIC X(02), offset 420, 2 bytes (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private String wsCaFirstTrCode;

    // WS-CA-SCREEN-NUM: PIC 9(1), offset 422, 1 bytes (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private Integer wsCaScreenNum;

    // WS-CA-LAST-PAGE-DISPLAYED: PIC 9(1), offset 423, 1 bytes (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private Integer wsCaLastPageDisplayed;

    // WS-CA-NEXT-PAGE-IND: PIC X(1), offset 424, 1 bytes (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private String wsCaNextPageInd;

    // WS-CA-DELETE-FLAG: PIC X, offset 425, 1 bytes (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private String wsCaDeleteFlag;

    // WS-CA-UPDATE-FLAG: PIC X, offset 426, 1 bytes (app/app-transaction-type-db2/cbl/COTRTLIC.cbl)
    private String wsCaUpdateFlag;

}