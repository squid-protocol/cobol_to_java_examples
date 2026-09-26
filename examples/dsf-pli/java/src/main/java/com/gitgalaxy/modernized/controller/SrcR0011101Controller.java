package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0011101Service;

/**
 * CICS program R0011101 (src/R0011101.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0011101, P0019906, P0019908, P0019910, P0019912, S00111; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0011101")
@RequiredArgsConstructor
public class SrcR0011101Controller {

    private final SrcR0011101Service srcR0011101Service;

    /** Program-to-program entry: XCTL at src/R0013301.pli:64. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0011101Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}