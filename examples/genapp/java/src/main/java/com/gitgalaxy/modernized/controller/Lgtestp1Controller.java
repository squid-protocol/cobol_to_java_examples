package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgtestp1CommArea;
import com.gitgalaxy.modernized.service.Lgtestp1Service;

/**
 * CICS program LGTESTP1 (base/src/lgtestp1.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: COMM-AREA (base/src/lgtestp1.cbl, 32500 bytes) -> Lgtestp1CommArea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgtestp1")
@RequiredArgsConstructor
public class Lgtestp1Controller {

    private final Lgtestp1Service lgtestp1Service;

    /** CICS transaction SSP1 -> Lgtestp1 (CSD base/cntl/cdef121.jcl:36 group GENASAT; base/cntl/cdef122.jcl:44 group GENATORT; base/cntl/cdef123.jcl:45 group GENATORT). */
    @PostMapping("/transactions/SSP1")
    public ResponseEntity<Lgtestp1CommArea> transactionSSP1(@RequestBody Lgtestp1CommArea request) {
        return ResponseEntity.ok(lgtestp1Service.handleTransaction("SSP1", request));
    }

}