package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgtestp1CommArea;
import com.gitgalaxy.modernized.service.Lgupol01Service;

/**
 * CICS program LGUPOL01 (base/src/lgupol01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: COMM-AREA (base/src/lgtestp1.cbl, 32500 bytes) -> Lgtestp1CommArea.
 * TODO: callers also pass COMM-AREA (base/src/lgtestp2.cbl, 32500 bytes) at base/src/lgtestp2.cbl:198.
 * TODO: callers also pass COMM-AREA (base/src/lgtestp3.cbl, 32500 bytes) at base/src/lgtestp3.cbl:196.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgupol01")
@RequiredArgsConstructor
public class Lgupol01Controller {

    private final Lgupol01Service lgupol01Service;

    /** Program-to-program entry: LINK at base/src/lgtestp1.cbl:216, LINK at base/src/lgtestp2.cbl:198, LINK at base/src/lgtestp3.cbl:196. */
    @PostMapping("/link")
    public ResponseEntity<Lgtestp1CommArea> link(@RequestBody Lgtestp1CommArea request) {
        return ResponseEntity.ok(lgupol01Service.handleLink(request));
    }

}