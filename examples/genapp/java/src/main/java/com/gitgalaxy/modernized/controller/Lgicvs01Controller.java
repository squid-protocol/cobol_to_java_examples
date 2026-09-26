package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgicvs01Dfhcommarea;
import com.gitgalaxy.modernized.service.Lgicvs01Service;

/**
 * CICS program LGICVS01 (base/src/lgicvs01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (base/src/lgicvs01.cbl, 84 bytes) -> Lgicvs01Dfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgicvs01")
@RequiredArgsConstructor
public class Lgicvs01Controller {

    private final Lgicvs01Service lgicvs01Service;

    /** CICS transaction LGCF -> Lgicvs01 (CSD base/cntl/cdef121.jcl:46 group GENASAT; base/cntl/cdef122.jcl:54 group GENATORT; base/cntl/cdef123.jcl:55 group GENATORT). */
    @PostMapping("/transactions/LGCF")
    public ResponseEntity<Lgicvs01Dfhcommarea> transactionLGCF(@RequestBody Lgicvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgicvs01Service.handleTransaction("LGCF", request));
    }

    /** CICS transaction VSCI -> Lgicvs01 (CSD base/cntl/cdef123.jcl:61 group GENATORP; base/cntl/cdef123.jcl:171 group GENAAORP). */
    @PostMapping("/transactions/VSCI")
    public ResponseEntity<Lgicvs01Dfhcommarea> transactionVSCI(@RequestBody Lgicvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgicvs01Service.handleTransaction("VSCI", request));
    }

}