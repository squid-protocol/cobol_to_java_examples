package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CarddemoCommarea3;
import com.gitgalaxy.modernized.service.Copaus1cService;

/**
 * CICS program COPAUS1C (app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/app-authorization-ims-db2-mq/cbl/COPAUS1C.cbl, 480 bytes) -> CarddemoCommarea3.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/copaus1c")
@RequiredArgsConstructor
public class Copaus1cController {

    private final Copaus1cService copaus1cService;

    /** CICS transaction CPVD -> Copaus1c (CSD app/app-authorization-ims-db2-mq/csd/CRDDEMO2.csd:25 group CARDDEMO; app/app-authorization-ims-db2-mq/csd/CRDDEMO2.csd:39 group CARDDEMO). */
    @PostMapping("/transactions/CPVD")
    public ResponseEntity<CarddemoCommarea3> transactionCPVD(@RequestBody CarddemoCommarea3 request) {
        return ResponseEntity.ok(copaus1cService.handleTransaction("CPVD", request));
    }

    /** Program-to-program entry: XCTL at app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:322 (data-driven, moves), XCTL at app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:674 (data-driven, moves). */
    @PostMapping("/link")
    public ResponseEntity<CarddemoCommarea3> link(@RequestBody CarddemoCommarea3 request) {
        return ResponseEntity.ok(copaus1cService.handleLink(request));
    }

}