package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CarddemoCommarea2;
import com.gitgalaxy.modernized.service.Cobil00cService;

/**
 * CICS program COBIL00C (app/cbl/COBIL00C.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/cbl/COBIL00C.cbl, 218 bytes) -> CarddemoCommarea2.
 * TODO: callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 218 bytes) at app/cbl/COBIL00C.cbl:146.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/cobil00c")
@RequiredArgsConstructor
public class Cobil00cController {

    private final Cobil00cService cobil00cService;

    /** CICS transaction CB00 -> Cobil00c (CSD app/csd/CARDDEMO.CSD:337 group CARDDEMO). */
    @PostMapping("/transactions/CB00")
    public ResponseEntity<CarddemoCommarea2> transactionCB00(@RequestBody CarddemoCommarea2 request) {
        return ResponseEntity.ok(cobil00cService.handleTransaction("CB00", request));
    }

    /** Program-to-program entry: XCTL at app/cbl/COMEN01C.cbl:156 (data-driven, table), XCTL at app/cbl/COMEN01C.cbl:184 (data-driven, table). */
    @PostMapping("/link")
    public ResponseEntity<CarddemoCommarea2> link(@RequestBody CarddemoCommarea2 request) {
        return ResponseEntity.ok(cobil00cService.handleLink(request));
    }

}