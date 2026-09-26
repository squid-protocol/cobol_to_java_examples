package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgtestc1CommArea;
import com.gitgalaxy.modernized.service.Lgtestc1Service;

/**
 * CICS program LGTESTC1 (base/src/lgtestc1.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: COMM-AREA (base/src/lgtestc1.cbl, 32500 bytes) -> Lgtestc1CommArea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgtestc1")
@RequiredArgsConstructor
public class Lgtestc1Controller {

    private final Lgtestc1Service lgtestc1Service;

    /** CICS transaction SSC1 -> Lgtestc1 (CSD base/cntl/cdef121.jcl:34 group GENASAT; base/cntl/cdef122.jcl:42 group GENATORT; base/cntl/cdef123.jcl:43 group GENATORT). */
    @PostMapping("/transactions/SSC1")
    public ResponseEntity<Lgtestc1CommArea> transactionSSC1(@RequestBody Lgtestc1CommArea request) {
        return ResponseEntity.ok(lgtestc1Service.handleTransaction("SSC1", request));
    }

}