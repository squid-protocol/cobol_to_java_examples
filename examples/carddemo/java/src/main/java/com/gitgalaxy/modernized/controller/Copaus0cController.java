package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CarddemoCommarea;
import com.gitgalaxy.modernized.service.Copaus0cService;

/**
 * CICS program COPAUS0C (app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl, 160 bytes) -> CarddemoCommarea.
 * TODO: callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:254.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/copaus0c")
@RequiredArgsConstructor
public class Copaus0cController {

    private final Copaus0cService copaus0cService;

    /** CICS transaction CPVS -> Copaus0c (CSD app/app-authorization-ims-db2-mq/csd/CRDDEMO2.csd:18 group CARDDEMO; app/app-authorization-ims-db2-mq/csd/CRDDEMO2.csd:49 group CARDDEMO). */
    @PostMapping("/transactions/CPVS")
    public ResponseEntity<CarddemoCommarea> transactionCPVS(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(copaus0cService.handleTransaction("CPVS", request));
    }

    /** Program-to-program entry: XCTL at app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:322 (data-driven, moves), XCTL at app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:674 (data-driven, moves), XCTL at app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl:367 (data-driven, moves), XCTL at app/cbl/COMEN01C.cbl:156 (data-driven, table), XCTL at app/cbl/COMEN01C.cbl:184 (data-driven, table). */
    @PostMapping("/link")
    public ResponseEntity<CarddemoCommarea> link(@RequestBody CarddemoCommarea request) {
        return ResponseEntity.ok(copaus0cService.handleLink(request));
    }

}