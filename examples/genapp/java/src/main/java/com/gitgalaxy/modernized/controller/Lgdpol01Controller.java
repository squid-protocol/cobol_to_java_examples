package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Lgtestp1CommArea;
import com.gitgalaxy.modernized.service.Lgdpol01Service;

/**
 * CICS program LGDPOL01 (base/src/lgdpol01.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: COMM-AREA (base/src/lgtestp1.cbl, 32500 bytes) -> Lgtestp1CommArea.
 * TODO: callers also pass COMM-AREA (base/src/lgtestp2.cbl, 32500 bytes) at base/src/lgtestp2.cbl:129.
 * TODO: callers also pass COMM-AREA (base/src/lgtestp3.cbl, 32500 bytes) at base/src/lgtestp3.cbl:129.
 * TODO: callers also pass COMM-AREA (base/src/lgtestp4.cbl, 32500 bytes) at base/src/lgtestp4.cbl:201.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/lgdpol01")
@RequiredArgsConstructor
public class Lgdpol01Controller {

    private final Lgdpol01Service lgdpol01Service;

    /** Program-to-program entry: LINK at base/src/lgtestp1.cbl:139, LINK at base/src/lgtestp2.cbl:129, LINK at base/src/lgtestp3.cbl:129, LINK at base/src/lgtestp4.cbl:201. */
    @PostMapping("/link")
    public ResponseEntity<Lgtestp1CommArea> link(@RequestBody Lgtestp1CommArea request) {
        return ResponseEntity.ok(lgdpol01Service.handleLink(request));
    }

}