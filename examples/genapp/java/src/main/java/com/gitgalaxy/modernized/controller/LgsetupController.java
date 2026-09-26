package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.LgsetupDfhcommarea;
import com.gitgalaxy.modernized.service.LgsetupService;

/**
 * CICS program LGSETUP (base/src/lgsetup.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (base/src/lgsetup.cbl, 84 bytes) -> LgsetupDfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgsetup")
@RequiredArgsConstructor
public class LgsetupController {

    private final LgsetupService lgsetupService;

    /** CICS transaction LGSE -> Lgsetup (CSD base/cntl/cdef121.jcl:44 group GENASAT; base/cntl/cdef122.jcl:52 group GENATORT; base/cntl/cdef123.jcl:53 group GENATORT). */
    @PostMapping("/transactions/LGSE")
    public ResponseEntity<LgsetupDfhcommarea> transactionLGSE(@RequestBody LgsetupDfhcommarea request) {
        return ResponseEntity.ok(lgsetupService.handleTransaction("LGSE", request));
    }

}