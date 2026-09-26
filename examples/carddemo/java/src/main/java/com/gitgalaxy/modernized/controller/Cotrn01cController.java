package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CarddemoCommarea5;
import com.gitgalaxy.modernized.service.Cotrn01cService;

/**
 * CICS program COTRN01C (app/cbl/COTRN01C.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/cbl/COTRN01C.cbl, 218 bytes) -> CarddemoCommarea5.
 * TODO: callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 218 bytes) at app/cbl/COTRN01C.cbl:136.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/cotrn01c")
@RequiredArgsConstructor
public class Cotrn01cController {

    private final Cotrn01cService cotrn01cService;

    /** CICS transaction CT01 -> Cotrn01c (CSD app/csd/CARDDEMO.CSD:429 group CARDDEMO). */
    @PostMapping("/transactions/CT01")
    public ResponseEntity<CarddemoCommarea5> transactionCT01(@RequestBody CarddemoCommarea5 request) {
        return ResponseEntity.ok(cotrn01cService.handleTransaction("CT01", request));
    }

    /** Program-to-program entry: XCTL at app/cbl/COMEN01C.cbl:156 (data-driven, table), XCTL at app/cbl/COMEN01C.cbl:184 (data-driven, table), XCTL at app/cbl/COTRN00C.cbl:192 (data-driven, moves), XCTL at app/cbl/COTRN00C.cbl:518 (data-driven, moves). */
    @PostMapping("/link")
    public ResponseEntity<CarddemoCommarea5> link(@RequestBody CarddemoCommarea5 request) {
        return ResponseEntity.ok(cotrn01cService.handleLink(request));
    }

}