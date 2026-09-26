package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Zecs001Dfhcommarea;
import com.gitgalaxy.modernized.service.Zecs001Service;

/**
 * CICS program ZECS001 (Source/ZECS001.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (Source/ZECS001.cbl, 1 bytes) -> Zecs001Dfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/zecs001")
@RequiredArgsConstructor
public class Zecs001Controller {

    private final Zecs001Service zecs001Service;

    /** CICS transaction ZC@ID@ -> Zecs001 (CSD Source/CSDZC##.rdo:31 group ZC@ID@). */
    @PostMapping("/transactions/ZCx40IDx40")
    public ResponseEntity<Zecs001Dfhcommarea> transactionZCx40IDx40(@RequestBody Zecs001Dfhcommarea request) {
        return ResponseEntity.ok(zecs001Service.handleTransaction("ZC@ID@", request));
    }

    /** CICS transaction ZD@ID@ -> Zecs001 (CSD Source/CSDZC##.rdo:39 group ZC@ID@). */
    @PostMapping("/transactions/ZDx40IDx40")
    public ResponseEntity<Zecs001Dfhcommarea> transactionZDx40IDx40(@RequestBody Zecs001Dfhcommarea request) {
        return ResponseEntity.ok(zecs001Service.handleTransaction("ZD@ID@", request));
    }

    /** CICS transaction ZR@ID@ -> Zecs001 (CSD Source/CSDZC##.rdo:47 group ZC@ID@). */
    @PostMapping("/transactions/ZRx40IDx40")
    public ResponseEntity<Zecs001Dfhcommarea> transactionZRx40IDx40(@RequestBody Zecs001Dfhcommarea request) {
        return ResponseEntity.ok(zecs001Service.handleTransaction("ZR@ID@", request));
    }

}