package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgucus01Dfhcommarea;
import com.gitgalaxy.modernized.service.Lgucdb01Service;

/**
 * CICS program LGUCDB01 (base/src/lgucdb01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (base/src/lgucus01.cbl, 32500 bytes) -> Lgucus01Dfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgucdb01")
@RequiredArgsConstructor
public class Lgucdb01Controller {

    private final Lgucdb01Service lgucdb01Service;

    /** CICS transaction DSCI -> Lgucdb01 (CSD base/cntl/cdef123.jcl:156 group GENAAORP). */
    @PostMapping("/transactions/DSCI")
    public ResponseEntity<Lgucus01Dfhcommarea> transactionDSCI(@RequestBody Lgucus01Dfhcommarea request) {
        return ResponseEntity.ok(lgucdb01Service.handleTransaction("DSCI", request));
    }

    /** Program-to-program entry: LINK at base/src/lgucus01.cbl:128. */
    @PostMapping("/link")
    public ResponseEntity<Lgucus01Dfhcommarea> link(@RequestBody Lgucus01Dfhcommarea request) {
        return ResponseEntity.ok(lgucdb01Service.handleLink(request));
    }

}