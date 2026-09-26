package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgapvs01Dfhcommarea;
import com.gitgalaxy.modernized.service.Lgapvs01Service;

/**
 * CICS program LGAPVS01 (base/src/lgapvs01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (base/src/lgapvs01.cbl, 32500 bytes) -> Lgapvs01Dfhcommarea.
 * TODO: DFHCOMMAREA (base/src/lgapdb01.cbl), passed at base/src/lgapdb01.cbl:243, has no known width; this program's declared DFHCOMMAREA (32500 bytes) is used -- confirm the callers pass it.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgapvs01")
@RequiredArgsConstructor
public class Lgapvs01Controller {

    private final Lgapvs01Service lgapvs01Service;

    /** CICS transaction VSPA -> Lgapvs01 (CSD base/cntl/cdef123.jcl:165 group GENAAORP). */
    @PostMapping("/transactions/VSPA")
    public ResponseEntity<Lgapvs01Dfhcommarea> transactionVSPA(@RequestBody Lgapvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgapvs01Service.handleTransaction("VSPA", request));
    }

    /** Program-to-program entry: LINK at base/src/lgapdb01.cbl:243. */
    @PostMapping("/link")
    public ResponseEntity<Lgapvs01Dfhcommarea> link(@RequestBody Lgapvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgapvs01Service.handleLink(request));
    }

}