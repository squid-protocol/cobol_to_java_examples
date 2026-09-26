package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CarddemoCommarea;
import com.gitgalaxy.modernized.service.Corpt00cService;

/**
 * CICS program CORPT00C (app/cbl/CORPT00C.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/cbl/CORPT00C.cbl, 160 bytes) -> CarddemoCommarea.
 * TODO: callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/CORPT00C.cbl:199, app/cbl/CORPT00C.cbl:587.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/corpt00c")
@RequiredArgsConstructor
public class Corpt00cController {

    private final Corpt00cService corpt00cService;

    /** CICS transaction CR00 -> Corpt00c (CSD app/csd/CARDDEMO.CSD:409 group CARDDEMO). */
    @PostMapping("/transactions/CR00")
    public ResponseEntity<CarddemoCommarea> transactionCR00(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(corpt00cService.handleTransaction("CR00", request));
    }

    /** Program-to-program entry: XCTL at app/cbl/COMEN01C.cbl:156 (data-driven, table), XCTL at app/cbl/COMEN01C.cbl:184 (data-driven, table). */
    @PostMapping("/link")
    public ResponseEntity<CarddemoCommarea> link(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(corpt00cService.handleLink(request));
    }

}