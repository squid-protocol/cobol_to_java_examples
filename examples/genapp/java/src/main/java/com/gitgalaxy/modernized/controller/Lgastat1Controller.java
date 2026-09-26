package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgastat1ChannelIn;
import com.gitgalaxy.modernized.dto.contract.Lgastat1Dfhcommarea;
import com.gitgalaxy.modernized.service.Lgastat1Service;

/**
 * CICS program LGASTAT1 (base/src/lgastat1.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (base/src/lgastat1.cbl, 32500 bytes) -> Lgastat1Dfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgastat1")
@RequiredArgsConstructor
public class Lgastat1Controller {

    private final Lgastat1Service lgastat1Service;

    /** CICS transaction LGST -> Lgastat1 (CSD base/cntl/cdef125.jcl:25 group GENAEVNT). */
    @PostMapping("/transactions/LGST")
    public ResponseEntity<Lgastat1Dfhcommarea> transactionLGST(@RequestBody Lgastat1Dfhcommarea request) {
        return ResponseEntity.ok(lgastat1Service.handleTransaction("LGST", request));
    }

    /** The program's channel: its GET CONTAINERs in, its PUT CONTAINERs out. */
    @PostMapping("/channel")
    public ResponseEntity<Void> channel(@RequestBody Lgastat1ChannelIn request) {
        lgastat1Service.handleChannel(request);
        return ResponseEntity.noContent().build();
    }

}