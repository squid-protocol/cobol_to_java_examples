package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CarddemoCommarea;
import com.gitgalaxy.modernized.service.Coadm01cService;

/**
 * CICS program COADM01C (app/cbl/COADM01C.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/cbl/COADM01C.cbl, 160 bytes) -> CarddemoCommarea.
 * TODO: callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COADM01C.cbl:111, app/cbl/COADM01C.cbl:280, app/cbl/COSGN00C.cbl:231.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/coadm01c")
@RequiredArgsConstructor
public class Coadm01cController {

    private final Coadm01cService coadm01cService;

    /** CICS transaction CA00 -> Coadm01c (CSD app/csd/CARDDEMO.CSD:327 group CARDDEMO). */
    @PostMapping("/transactions/CA00")
    public ResponseEntity<CarddemoCommarea> transactionCA00(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(coadm01cService.handleTransaction("CA00", request));
    }

    /** Program-to-program entry: XCTL at app/app-transaction-type-db2/cbl/COTRTLIC.cbl:620 (data-driven, moves), XCTL at app/app-transaction-type-db2/cbl/COTRTUPC.cbl:457 (data-driven, moves), XCTL at app/cbl/COSGN00C.cbl:231, XCTL at app/cbl/COUSR00C.cbl:196 (data-driven, moves), XCTL at app/cbl/COUSR00C.cbl:206 (data-driven, moves), XCTL at app/cbl/COUSR00C.cbl:514 (data-driven, moves), XCTL at app/cbl/COUSR01C.cbl:175 (data-driven, moves), XCTL at app/cbl/COUSR02C.cbl:258 (data-driven, moves), XCTL at app/cbl/COUSR03C.cbl:205 (data-driven, moves). */
    @PostMapping("/link")
    public ResponseEntity<CarddemoCommarea> link(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(coadm01cService.handleLink(request));
    }

}