package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.ZecspltDfhcommarea;
import com.gitgalaxy.modernized.service.ZecspltService;

/**
 * CICS program ZECSPLT (Source/ZECSPLT.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (Source/ZECSPLT.cbl, 1 bytes) -> ZecspltDfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/zecsplt")
@RequiredArgsConstructor
public class ZecspltController {

    private final ZecspltService zecspltService;

    /** CICS transaction ZPLT -> Zecsplt (CSD Source/CSDZECS.rdo:34 group ZECS). */
    @PostMapping("/transactions/ZPLT")
    public ResponseEntity<ZecspltDfhcommarea> transactionZPLT(@RequestBody ZecspltDfhcommarea request) {
        return ResponseEntity.ok(zecspltService.handleTransaction("ZPLT", request));
    }

}