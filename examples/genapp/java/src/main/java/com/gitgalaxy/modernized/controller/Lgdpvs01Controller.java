package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgdpvs01Dfhcommarea;
import com.gitgalaxy.modernized.service.Lgdpvs01Service;

/**
 * CICS program LGDPVS01 (base/src/lgdpvs01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (base/src/lgdpvs01.cbl, 32500 bytes) -> Lgdpvs01Dfhcommarea.
 * TODO: DFHCOMMAREA (base/src/lgdpdb01.cbl), passed at base/src/lgdpdb01.cbl:168, has no known width; this program's declared DFHCOMMAREA (32500 bytes) is used -- confirm the callers pass it.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgdpvs01")
@RequiredArgsConstructor
public class Lgdpvs01Controller {

    private final Lgdpvs01Service lgdpvs01Service;

    /** CICS transaction VSPD -> Lgdpvs01 (CSD base/cntl/cdef123.jcl:168 group GENAAORP). */
    @PostMapping("/transactions/VSPD")
    public ResponseEntity<Lgdpvs01Dfhcommarea> transactionVSPD(@RequestBody Lgdpvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgdpvs01Service.handleTransaction("VSPD", request));
    }

    /** Program-to-program entry: LINK at base/src/lgdpdb01.cbl:168. */
    @PostMapping("/link")
    public ResponseEntity<Lgdpvs01Dfhcommarea> link(@RequestBody Lgdpvs01Dfhcommarea request) {
        return ResponseEntity.ok(lgdpvs01Service.handleLink(request));
    }

}