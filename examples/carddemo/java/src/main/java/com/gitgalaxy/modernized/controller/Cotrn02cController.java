package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CarddemoCommarea;
import com.gitgalaxy.modernized.service.Cotrn02cService;

/**
 * CICS program COTRN02C (app/cbl/COTRN02C.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/cbl/COTRN02C.cbl, 160 bytes) -> CarddemoCommarea.
 * TODO: callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COTRN02C.cbl:156, app/cbl/COTRN02C.cbl:530.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/cotrn02c")
@RequiredArgsConstructor
public class Cotrn02cController {

    private final Cotrn02cService cotrn02cService;

    /** CICS transaction CT02 -> Cotrn02c (CSD app/csd/CARDDEMO.CSD:439 group CARDDEMO). */
    @PostMapping("/transactions/CT02")
    public ResponseEntity<CarddemoCommarea> transactionCT02(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(cotrn02cService.handleTransaction("CT02", request));
    }

    /** Program-to-program entry: XCTL at app/cbl/COMEN01C.cbl:156 (data-driven, table), XCTL at app/cbl/COMEN01C.cbl:184 (data-driven, table). */
    @PostMapping("/link")
    public ResponseEntity<CarddemoCommarea> link(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(cotrn02cService.handleLink(request));
    }

}