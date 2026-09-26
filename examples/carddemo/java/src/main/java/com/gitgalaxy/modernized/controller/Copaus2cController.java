package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Copaus2cDfhcommarea;
import com.gitgalaxy.modernized.service.Copaus2cService;

/**
 * CICS program COPAUS2C (app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl, 272 bytes) -> Copaus2cDfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/copaus2c")
@RequiredArgsConstructor
public class Copaus2cController {

    private final Copaus2cService copaus2cService;

    /** CICS transaction CPVD -> Copaus2c (CSD app/app-authorization-ims-db2-mq/csd/CRDDEMO2.csd:32 group CARDDEMO). */
    @PostMapping("/transactions/CPVD")
    public ResponseEntity<Copaus2cDfhcommarea> transactionCPVD(@RequestBody Copaus2cDfhcommarea request) {
        return ResponseEntity.ok(copaus2cService.handleTransaction("CPVD", request));
    }

    /** Program-to-program entry: LINK at app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl:248. */
    @PostMapping("/link")
    public ResponseEntity<Copaus2cDfhcommarea> link(@RequestBody Copaus2cDfhcommarea request) {
        return ResponseEntity.ok(copaus2cService.handleLink(request));
    }

}