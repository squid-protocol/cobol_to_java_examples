package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CarddemoCommarea;
import com.gitgalaxy.modernized.service.Comen01cService;

/**
 * CICS program COMEN01C (app/cbl/COMEN01C.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/cbl/COMEN01C.cbl, 160 bytes) -> CarddemoCommarea.
 * TODO: callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/cbl/COCRDLIC.cbl:402, app/cbl/COMEN01C.cbl:107, app/cbl/COSGN00C.cbl:236.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/comen01c")
@RequiredArgsConstructor
public class Comen01cController {

    private final Comen01cService comen01cService;

    /** CICS transaction CM00 -> Comen01c (CSD app/csd/CARDDEMO.CSD:399 group CARDDEMO). */
    @PostMapping("/transactions/CM00")
    public ResponseEntity<CarddemoCommarea> transactionCM00(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(comen01cService.handleTransaction("CM00", request));
    }

    /** Program-to-program entry: XCTL at app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:322 (data-driven, moves), XCTL at app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:674 (data-driven, moves), XCTL at app/cbl/COACTUPC.cbl:956 (data-driven, moves), XCTL at app/cbl/COACTVWC.cbl:349 (data-driven, moves), XCTL at app/cbl/COBIL00C.cbl:281 (data-driven, moves), XCTL at app/cbl/COCRDLIC.cbl:402, XCTL at app/cbl/COCRDSLC.cbl:331 (data-driven, moves), XCTL at app/cbl/COCRDUPC.cbl:473 (data-driven, moves), XCTL at app/cbl/CORPT00C.cbl:548 (data-driven, moves), XCTL at app/cbl/COSGN00C.cbl:236, XCTL at app/cbl/COTRN00C.cbl:192 (data-driven, moves), XCTL at app/cbl/COTRN00C.cbl:518 (data-driven, moves), XCTL at app/cbl/COTRN01C.cbl:205 (data-driven, moves), XCTL at app/cbl/COTRN02C.cbl:508 (data-driven, moves). */
    @PostMapping("/link")
    public ResponseEntity<CarddemoCommarea> link(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(comen01cService.handleLink(request));
    }

}