package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CotrtupcCommarea;
import com.gitgalaxy.modernized.service.CotrtupcService;

/**
 * CICS program COTRTUPC (app/app-transaction-type-db2/cbl/COTRTUPC.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/app-transaction-type-db2/cbl/COTRTUPC.cbl, 265 bytes) -> CotrtupcCommarea.
 * TODO: callers also pass WS-COMMAREA (app/app-transaction-type-db2/cbl/COTRTUPC.cbl, 2000 bytes) at app/app-transaction-type-db2/cbl/COTRTUPC.cbl:567.
 * TODO: callers also pass CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy, 160 bytes) at app/app-transaction-type-db2/cbl/COTRTLIC.cbl:648.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/cotrtupc")
@RequiredArgsConstructor
public class CotrtupcController {

    private final CotrtupcService cotrtupcService;

    /** CICS transaction CTTU -> Cotrtupc (CSD app/app-transaction-type-db2/csd/CRDDEMOD.csd:18 group CARDDEMO; app/app-transaction-type-db2/csd/CRDDEMOD.csd:35 group CARDDEMO). */
    @PostMapping("/transactions/CTTU")
    public ResponseEntity<CotrtupcCommarea> transactionCTTU(@RequestBody CotrtupcCommarea request) {
        return ResponseEntity.ok(cotrtupcService.handleTransaction("CTTU", request));
    }

    /** Program-to-program entry: XCTL at app/app-transaction-type-db2/cbl/COTRTLIC.cbl:620 (data-driven, moves), XCTL at app/app-transaction-type-db2/cbl/COTRTLIC.cbl:648, XCTL at app/cbl/COADM01C.cbl:145 (data-driven, table). */
    @PostMapping("/link")
    public ResponseEntity<CotrtupcCommarea> link(@RequestBody CotrtupcCommarea request) {
        return ResponseEntity.ok(cotrtupcService.handleLink(request));
    }

}