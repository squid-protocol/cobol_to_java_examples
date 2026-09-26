package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.R0018012Service;

/**
 * CICS program R0018012 (src/R0018012.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter LOKAL_KOM_PTR, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019913; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/r0018012")
@RequiredArgsConstructor
public class R0018012Controller {

    private final R0018012Service r0018012Service;

    /** Program-to-program entry: XCTL at src/R0018010.pli:1249. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        r0018012Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}