package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgtestp2CommArea;
import com.gitgalaxy.modernized.service.Lgtestp2Service;

/**
 * CICS program LGTESTP2 (base/src/lgtestp2.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: COMM-AREA (base/src/lgtestp2.cbl, 32500 bytes) -> Lgtestp2CommArea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgtestp2")
@RequiredArgsConstructor
public class Lgtestp2Controller {

    private final Lgtestp2Service lgtestp2Service;

    /** CICS transaction SSP2 -> Lgtestp2 (CSD base/cntl/cdef121.jcl:38 group GENASAT; base/cntl/cdef122.jcl:46 group GENATORT; base/cntl/cdef123.jcl:47 group GENATORT). */
    @PostMapping("/transactions/SSP2")
    public ResponseEntity<Lgtestp2CommArea> transactionSSP2(@RequestBody Lgtestp2CommArea request) {
        return ResponseEntity.ok(lgtestp2Service.handleTransaction("SSP2", request));
    }

}