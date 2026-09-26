package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgacvs01Dfhcommarea;
import com.gitgalaxy.modernized.service.Lgacvs01Service;

/**
 * CICS program LGACVS01 (base/src/lgacvs01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (base/src/lgacvs01.cbl, 32500 bytes) -> Lgacvs01Dfhcommarea.
 * TODO: DFHCOMMAREA (base/src/lgacdb01.cbl), passed at base/src/lgacdb01.cbl:174, has no known width; this program's declared DFHCOMMAREA (32500 bytes) is used -- confirm the callers pass it.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgacvs01")
@RequiredArgsConstructor
public class Lgacvs01Controller {

    private final Lgacvs01Service lgacvs01Service;

    /** CICS transaction VSCA -> Lgacvs01 (CSD base/cntl/cdef123.jcl:162 group GENAAORP). */
    @PostMapping("/transactions/VSCA")
    public ResponseEntity<Lgacvs01Dfhcommarea> transactionVSCA(@RequestBody Lgacvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgacvs01Service.handleTransaction("VSCA", request));
    }

    /** Program-to-program entry: LINK at base/src/lgacdb01.cbl:174. */
    @PostMapping("/link")
    public ResponseEntity<Lgacvs01Dfhcommarea> link(@RequestBody Lgacvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgacvs01Service.handleLink(request));
    }

}