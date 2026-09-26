package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgtestc1CommArea;
import com.gitgalaxy.modernized.service.Lgacus01Service;

/**
 * CICS program LGACUS01 (base/src/lgacus01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: COMM-AREA (base/src/lgtestc1.cbl, 32500 bytes) -> Lgtestc1CommArea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgacus01")
@RequiredArgsConstructor
public class Lgacus01Controller {

    private final Lgacus01Service lgacus01Service;

    /** Program-to-program entry: LINK at base/src/lgtestc1.cbl:128. */
    @PostMapping("/link")
    public ResponseEntity<Lgtestc1CommArea> link(@RequestBody Lgtestc1CommArea request) {
        return ResponseEntity.ok(lgacus01Service.handleLink(request));
    }

}