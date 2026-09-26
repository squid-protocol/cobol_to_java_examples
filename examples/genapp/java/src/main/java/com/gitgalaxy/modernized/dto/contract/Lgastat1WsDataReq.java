package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-DATA-REQ (base/src/lgastat1.cbl), 6 bytes, from GitGalaxy's verified skeleton.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Lgastat1WsDataReq {

    // WS-DATA-REQ: PIC X(6), offset 0, 6 bytes (base/src/lgastat1.cbl)
    private String wsDataReq;

}