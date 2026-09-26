package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record LK-M03B-AREA (app/cbl/CBSTM03B.CBL), 1040 bytes, from GitGalaxy's verified skeleton.
 * USING parameter 1 of Cbstm03b.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Cbstm03bLkM03bArea {

    // LK-M03B-DD: PIC X(08), offset 0, 8 bytes (app/cbl/CBSTM03B.CBL)
    private String lkM03BDd;

    // LK-M03B-OPER: PIC X(01), offset 8, 1 bytes (app/cbl/CBSTM03B.CBL)
    private String lkM03BOper;

    // LK-M03B-RC: PIC X(02), offset 9, 2 bytes (app/cbl/CBSTM03B.CBL)
    private String lkM03BRc;

    // LK-M03B-KEY: PIC X(25), offset 11, 25 bytes (app/cbl/CBSTM03B.CBL)
    private String lkM03BKey;

    // LK-M03B-KEY-LN: PIC S9(4), offset 36, 4 bytes (app/cbl/CBSTM03B.CBL)
    private Integer lkM03BKeyLn;

    // LK-M03B-FLDT: PIC X(1000), offset 40, 1000 bytes (app/cbl/CBSTM03B.CBL)
    private String lkM03BFldt;

}