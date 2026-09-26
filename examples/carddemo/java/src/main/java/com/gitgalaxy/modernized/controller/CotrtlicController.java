package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CotrtlicCommarea;
import com.gitgalaxy.modernized.service.CotrtlicService;

/**
 * CICS program COTRTLIC (app/app-transaction-type-db2/cbl/COTRTLIC.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/app-transaction-type-db2/cbl/COTRTLIC.cbl, 587 bytes) -> CotrtlicCommarea.
 * TODO: callers also pass WS-COMMAREA (app/app-transaction-type-db2/cbl/COTRTLIC.cbl, 2000 bytes) at app/app-transaction-type-db2/cbl/COTRTLIC.cbl:910.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/cotrtlic")
@RequiredArgsConstructor
public class CotrtlicController {

    private final CotrtlicService cotrtlicService;

    /** CICS transaction CTLI -> Cotrtlic (CSD app/app-transaction-type-db2/csd/CRDDEMOD.csd:11 group CARDDEMO; app/app-transaction-type-db2/csd/CRDDEMOD.csd:25 group CARDDEMO). */
    @PostMapping("/transactions/CTLI")
    public ResponseEntity<CotrtlicCommarea> transactionCTLI(@RequestBody CotrtlicCommarea request) {
        return ResponseEntity.ok(cotrtlicService.handleTransaction("CTLI", request));
    }

    /** Program-to-program entry: XCTL at app/cbl/COADM01C.cbl:145 (data-driven, table). */
    @PostMapping("/link")
    public ResponseEntity<CotrtlicCommarea> link(@RequestBody CotrtlicCommarea request) {
        return ResponseEntity.ok(cotrtlicService.handleLink(request));
    }

}