package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record COMMUNICATION-AREA (src/base/cobol_src/BNKMENU.cbl), 1 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Bnkmenu receives, as passed by RETURN TRANSID at src/base/cobol_src/BNKMENU.cbl:170.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class BnkmenuCommunicationArea {

    // COMMUNICATION-AREA: PIC X, offset 0, 1 bytes (src/base/cobol_src/BNKMENU.cbl)
    private String communicationArea;

}