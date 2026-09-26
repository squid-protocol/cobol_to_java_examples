package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgucvs01Dfhcommarea;
import com.gitgalaxy.modernized.service.Lgucvs01Service;

/**
 * CICS program LGUCVS01 (base/src/lgucvs01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (base/src/lgucvs01.cbl, 32500 bytes) -> Lgucvs01Dfhcommarea.
 * TODO: DFHCOMMAREA (base/src/lgucdb01.cbl), passed at base/src/lgucdb01.cbl:136, has no known width; this program's declared DFHCOMMAREA (32500 bytes) is used -- confirm the callers pass it.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgucvs01")
@RequiredArgsConstructor
public class Lgucvs01Controller {

    private final Lgucvs01Service lgucvs01Service;

    /** CICS transaction VSC1 -> Lgucvs01 (CSD base/cntl/cdef123.jcl:177 group GENAAORP). */
    @PostMapping("/transactions/VSC1")
    public ResponseEntity<Lgucvs01Dfhcommarea> transactionVSC1(@RequestBody Lgucvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgucvs01Service.handleTransaction("VSC1", request));
    }

    /** Program-to-program entry: LINK at base/src/lgucdb01.cbl:136. */
    @PostMapping("/link")
    public ResponseEntity<Lgucvs01Dfhcommarea> link(@RequestBody Lgucvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgucvs01Service.handleLink(request));
    }

}