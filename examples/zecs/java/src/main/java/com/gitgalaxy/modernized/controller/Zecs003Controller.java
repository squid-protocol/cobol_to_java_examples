package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Zecs001Zecs003CommArea;
import com.gitgalaxy.modernized.service.Zecs003Service;

/**
 * CICS program ZECS003 (Source/ZECS003.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: ZECS003-COMM-AREA (Source/ZECS001.cbl, 13 bytes) -> Zecs001Zecs003CommArea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/zecs003")
@RequiredArgsConstructor
public class Zecs003Controller {

    private final Zecs003Service zecs003Service;

    /** Program-to-program entry: XCTL at Source/ZECS001.cbl:753. */
    @PostMapping("/link")
    public ResponseEntity<Zecs001Zecs003CommArea> link(@RequestBody Zecs001Zecs003CommArea request) {
        return ResponseEntity.ok(zecs003Service.handleLink(request));
    }

}