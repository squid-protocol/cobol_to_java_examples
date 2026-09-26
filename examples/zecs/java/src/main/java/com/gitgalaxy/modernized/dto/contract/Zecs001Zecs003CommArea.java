package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record ZECS003-COMM-AREA (Source/ZECS001.cbl), 13 bytes, from GitGalaxy's verified skeleton.
 * The COMMAREA Zecs003 receives, as passed by XCTL at Source/ZECS001.cbl:753.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Zecs001Zecs003CommArea {

    // CA-TYPE: PIC X(03), offset 0, 3 bytes (Source/ZECS001.cbl)
    private String caType;

    // CA-URI-FIELD-01: PIC X(10), offset 3, 10 bytes (Source/ZECS001.cbl)
    private String caUriField01;

}