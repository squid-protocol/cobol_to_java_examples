package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-DATA-RC (base/src/lgastat1.cbl), 2 bytes, from GitGalaxy's verified skeleton.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Lgastat1WsDataRc {

    // WS-DATA-RC: PIC X(2), offset 0, 2 bytes (base/src/lgastat1.cbl)
    private String wsDataRc;

}