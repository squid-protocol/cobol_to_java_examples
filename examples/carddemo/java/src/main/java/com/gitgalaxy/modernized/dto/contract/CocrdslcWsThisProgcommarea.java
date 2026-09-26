package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-THIS-PROGCOMMAREA (app/cbl/COCRDSLC.cbl), 12 bytes, from GitGalaxy's verified skeleton.
 * Bytes 160-171 of the COMMAREA Cocrdslc reads: MOVE DFHCOMMAREA(LENGTH OF CARDDEMO-COMMAREA + 1:LENGTH OF WS-THIS-PROGCOMMAREA) at app/cbl/COCRDSLC.cbl:276.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CocrdslcWsThisProgcommarea {

    // CA-FROM-PROGRAM: PIC X(08), offset 0, 8 bytes (app/cbl/COCRDSLC.cbl)
    private String caFromProgram;

    // CA-FROM-TRANID: PIC X(04), offset 8, 4 bytes (app/cbl/COCRDSLC.cbl)
    private String caFromTranid;

}