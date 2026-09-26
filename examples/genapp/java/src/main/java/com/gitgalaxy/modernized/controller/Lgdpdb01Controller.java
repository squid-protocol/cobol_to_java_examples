package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgdpol01Dfhcommarea;
import com.gitgalaxy.modernized.service.Lgdpdb01Service;

/**
 * CICS program LGDPDB01 (base/src/lgdpdb01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (base/src/lgdpol01.cbl, 32500 bytes) -> Lgdpol01Dfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgdpdb01")
@RequiredArgsConstructor
public class Lgdpdb01Controller {

    private final Lgdpdb01Service lgdpdb01Service;

    /** CICS transaction DSPD -> Lgdpdb01 (CSD base/cntl/cdef123.jcl:147 group GENAAORP). */
    @PostMapping("/transactions/DSPD")
    public ResponseEntity<Lgdpol01Dfhcommarea> transactionDSPD(@RequestBody Lgdpol01Dfhcommarea request) {
        return ResponseEntity.ok(lgdpdb01Service.handleTransaction("DSPD", request));
    }

    /** Program-to-program entry: LINK at base/src/lgdpol01.cbl:141. */
    @PostMapping("/link")
    public ResponseEntity<Lgdpol01Dfhcommarea> link(@RequestBody Lgdpol01Dfhcommarea request) {
        return ResponseEntity.ok(lgdpdb01Service.handleLink(request));
    }

}