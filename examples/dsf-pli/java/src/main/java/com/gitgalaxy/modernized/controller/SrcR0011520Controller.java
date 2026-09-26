package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0011520Service;

/**
 * CICS program R0011520 (src/R0011520.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0011301, P0011501, P0012002, P0012003, P0019906, P0019908, P0019910, P0019912, P0019927, P0019929, P0019940, P0019952; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0011520")
@RequiredArgsConstructor
public class SrcR0011520Controller {

    private final SrcR0011520Service srcR0011520Service;

    /** Program-to-program entry: LINK at src/R0012001.pli:192, LINK at src/R0012001.pli:198, LINK at src/R001NO10.pli:901. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0011520Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}