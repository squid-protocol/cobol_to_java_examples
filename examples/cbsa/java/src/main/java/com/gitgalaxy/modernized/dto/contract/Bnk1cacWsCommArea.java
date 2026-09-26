package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-COMM-AREA (src/base/cobol_src/BNK1CAC.cbl), 32 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Bnk1cac receives, as passed by RETURN TRANSID at src/base/cobol_src/BNK1CAC.cbl:248.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1cacWsCommArea {

    // WS-COMM-CUSTNO: PIC 9(10), offset 0, 10 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private Long wsCommCustno;

    // WS-COMM-ACCTYPE: PIC X(8), offset 10, 8 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private String wsCommAcctype;

    // WS-COMM-INTRT: PIC 9(4)V99, offset 18, 6 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private BigDecimal wsCommIntrt;

    // WS-COMM-OVERDR: PIC 9(8), offset 24, 8 bytes (src/base/cobol_src/BNK1CAC.cbl)
    private Integer wsCommOverdr;

}