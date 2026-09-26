package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-THIS-PROGCOMMAREA (app/cbl/COCRDLIC.cbl), 254 bytes, from GitGalaxy's verified skeleton.
 * Bytes 160-413 of the COMMAREA Cocrdlic reads: MOVE DFHCOMMAREA(LENGTH OF CARDDEMO-COMMAREA + 1:LENGTH OF WS-THIS-PROGCOMMAREA) at app/cbl/COCRDLIC.cbl:329.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CocrdlicWsThisProgcommarea {

    // WS-CA-LAST-CARD-NUM: PIC X(16), offset 0, 16 bytes (app/cbl/COCRDLIC.cbl)
    private String wsCaLastCardNum;

    // WS-CA-LAST-CARD-ACCT-ID: PIC 9(11), offset 16, 11 bytes (app/cbl/COCRDLIC.cbl)
    private Long wsCaLastCardAcctId;

    // WS-CA-FIRST-CARD-NUM: PIC X(16), offset 27, 16 bytes (app/cbl/COCRDLIC.cbl)
    private String wsCaFirstCardNum;

    // WS-CA-FIRST-CARD-ACCT-ID: PIC 9(11), offset 43, 11 bytes (app/cbl/COCRDLIC.cbl)
    private Long wsCaFirstCardAcctId;

    // WS-CA-SCREEN-NUM: PIC 9(1), offset 54, 1 bytes (app/cbl/COCRDLIC.cbl)
    private Integer wsCaScreenNum;

    // WS-CA-LAST-PAGE-DISPLAYED: PIC 9(1), offset 55, 1 bytes (app/cbl/COCRDLIC.cbl)
    private Integer wsCaLastPageDisplayed;

    // WS-CA-NEXT-PAGE-IND: PIC X(1), offset 56, 1 bytes (app/cbl/COCRDLIC.cbl)
    private String wsCaNextPageInd;

    // WS-RETURN-FLAG: PIC X(1), offset 57, 1 bytes (app/cbl/COCRDLIC.cbl)
    private String wsReturnFlag;

    // WS-ALL-ROWS: PIC X(196), offset 58, 196 bytes (app/cbl/COCRDLIC.cbl)
    private String wsAllRows;

}