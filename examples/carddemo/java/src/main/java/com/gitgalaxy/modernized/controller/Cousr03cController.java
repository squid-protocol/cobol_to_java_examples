package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CarddemoCommarea;
import com.gitgalaxy.modernized.service.Cousr03cService;

/**
 * CICS program COUSR03C (app/cbl/COUSR03C.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/cbl/COUSR03C.cbl, 160 bytes) -> CarddemoCommarea.
 * TODO: callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COUSR03C.cbl:134.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/cousr03c")
@RequiredArgsConstructor
public class Cousr03cController {

    private final Cousr03cService cousr03cService;

    /** CICS transaction CU03 -> Cousr03c (CSD app/csd/CARDDEMO.CSD:479 group CARDDEMO). */
    @PostMapping("/transactions/CU03")
    public ResponseEntity<CarddemoCommarea> transactionCU03(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(cousr03cService.handleTransaction("CU03", request));
    }

    /** Program-to-program entry: XCTL at app/cbl/COADM01C.cbl:145 (data-driven, table), XCTL at app/cbl/COUSR00C.cbl:196 (data-driven, moves), XCTL at app/cbl/COUSR00C.cbl:206 (data-driven, moves), XCTL at app/cbl/COUSR00C.cbl:514 (data-driven, moves). */
    @PostMapping("/link")
    public ResponseEntity<CarddemoCommarea> link(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(cousr03cService.handleLink(request));
    }

}