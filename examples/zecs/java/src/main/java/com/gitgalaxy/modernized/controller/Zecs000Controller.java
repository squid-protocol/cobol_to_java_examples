package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Zecs000Dfhcommarea;
import com.gitgalaxy.modernized.service.Zecs000Service;

/**
 * CICS program ZECS000 (Source/ZECS000.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (Source/ZECS000.cbl, 1 bytes) -> Zecs000Dfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/zecs000")
@RequiredArgsConstructor
public class Zecs000Controller {

    private final Zecs000Service zecs000Service;

    /** CICS transaction ZX@ID@ -> Zecs000 (CSD Source/CSDZC##.rdo:55 group ZC@ID@). */
    @PostMapping("/transactions/ZXx40IDx40")
    public ResponseEntity<Zecs000Dfhcommarea> transactionZXx40IDx40(@RequestBody Zecs000Dfhcommarea request) {
        return ResponseEntity.ok(zecs000Service.handleTransaction("ZX@ID@", request));
    }

}