package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgtestc1CommArea;
import com.gitgalaxy.modernized.service.Lgucus01Service;

/**
 * CICS program LGUCUS01 (base/src/lgucus01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: COMM-AREA (base/src/lgtestc1.cbl, 32500 bytes) -> Lgtestc1CommArea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgucus01")
@RequiredArgsConstructor
public class Lgucus01Controller {

    private final Lgucus01Service lgucus01Service;

    /** Program-to-program entry: LINK at base/src/lgtestc1.cbl:190. */
    @PostMapping("/link")
    public ResponseEntity<Lgtestc1CommArea> link(@RequestBody Lgtestc1CommArea request) {
        return ResponseEntity.ok(lgucus01Service.handleLink(request));
    }

}