package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgtestp3CommArea;
import com.gitgalaxy.modernized.service.Lgtestp3Service;

/**
 * CICS program LGTESTP3 (base/src/lgtestp3.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: COMM-AREA (base/src/lgtestp3.cbl, 32500 bytes) -> Lgtestp3CommArea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgtestp3")
@RequiredArgsConstructor
public class Lgtestp3Controller {

    private final Lgtestp3Service lgtestp3Service;

    /** CICS transaction SSP3 -> Lgtestp3 (CSD base/cntl/cdef121.jcl:40 group GENASAT; base/cntl/cdef122.jcl:48 group GENATORT; base/cntl/cdef123.jcl:49 group GENATORT). */
    @PostMapping("/transactions/SSP3")
    public ResponseEntity<Lgtestp3CommArea> transactionSSP3(@RequestBody Lgtestp3CommArea request) {
        return ResponseEntity.ok(lgtestp3Service.handleTransaction("SSP3", request));
    }

}