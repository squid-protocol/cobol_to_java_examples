package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0014801Service;

/**
 * CICS program R0014801 (src/R0014801.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0011101, P0019906, P0019908, P0019910, P0019912, P0019921, P001NB01; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0014801")
@RequiredArgsConstructor
public class SrcR0014801Controller {

    private final SrcR0014801Service srcR0014801Service;

    /** Program-to-program entry: LINK at src/R0014001.pli:388. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0014801Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}