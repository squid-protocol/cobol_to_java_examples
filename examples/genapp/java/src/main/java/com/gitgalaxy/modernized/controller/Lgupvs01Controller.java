package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgupvs01Dfhcommarea;
import com.gitgalaxy.modernized.service.Lgupvs01Service;

/**
 * CICS program LGUPVS01 (base/src/lgupvs01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (base/src/lgupvs01.cbl, 32500 bytes) -> Lgupvs01Dfhcommarea.
 * TODO: DFHCOMMAREA (base/src/lgupdb01.cbl), passed at base/src/lgupdb01.cbl:209, has no known width; this program's declared DFHCOMMAREA (32500 bytes) is used -- confirm the callers pass it.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgupvs01")
@RequiredArgsConstructor
public class Lgupvs01Controller {

    private final Lgupvs01Service lgupvs01Service;

    /** CICS transaction VSP1 -> Lgupvs01 (CSD base/cntl/cdef123.jcl:180 group GENAAORP). */
    @PostMapping("/transactions/VSP1")
    public ResponseEntity<Lgupvs01Dfhcommarea> transactionVSP1(@RequestBody Lgupvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgupvs01Service.handleTransaction("VSP1", request));
    }

    /** Program-to-program entry: LINK at base/src/lgupdb01.cbl:209. */
    @PostMapping("/link")
    public ResponseEntity<Lgupvs01Dfhcommarea> link(@RequestBody Lgupvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgupvs01Service.handleLink(request));
    }

}