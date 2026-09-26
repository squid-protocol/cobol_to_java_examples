package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.Coacct01Service;

/**
 * CICS program COACCT01 (app/app-vsam-mq/cbl/COACCT01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no LINKAGE DFHCOMMAREA, and no resolved caller passes this program a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/coacct01")
@RequiredArgsConstructor
public class Coacct01Controller {

    private final Coacct01Service coacct01Service;

    /** CICS transaction CDRA -> Coacct01 (CSD app/app-vsam-mq/csd/CRDDEMOM.csd:1 group CARDDEMO; app/app-vsam-mq/csd/CRDDEMOM.csd:17 group CARDDEMO). */
    @PostMapping("/transactions/CDRA")
    public ResponseEntity<Void> transactionCDRA() {
        coacct01Service.handleTransaction("CDRA");
        return ResponseEntity.noContent().build();
    }

}