package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgipvs01Dfhcommarea;
import com.gitgalaxy.modernized.service.Lgipvs01Service;

/**
 * CICS program LGIPVS01 (base/src/lgipvs01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (base/src/lgipvs01.cbl, 90 bytes) -> Lgipvs01Dfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgipvs01")
@RequiredArgsConstructor
public class Lgipvs01Controller {

    private final Lgipvs01Service lgipvs01Service;

    /** CICS transaction LGPF -> Lgipvs01 (CSD base/cntl/cdef121.jcl:48 group GENASAT; base/cntl/cdef122.jcl:56 group GENATORT; base/cntl/cdef123.jcl:57 group GENATORT). */
    @PostMapping("/transactions/LGPF")
    public ResponseEntity<Lgipvs01Dfhcommarea> transactionLGPF(@RequestBody Lgipvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgipvs01Service.handleTransaction("LGPF", request));
    }

    /** CICS transaction VSPI -> Lgipvs01 (CSD base/cntl/cdef123.jcl:64 group GENATORP; base/cntl/cdef123.jcl:174 group GENAAORP). */
    @PostMapping("/transactions/VSPI")
    public ResponseEntity<Lgipvs01Dfhcommarea> transactionVSPI(@RequestBody Lgipvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgipvs01Service.handleTransaction("VSPI", request));
    }

}