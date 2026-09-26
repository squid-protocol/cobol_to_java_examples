package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0013001Service;

/**
 * CICS program R0013001 (src/R0013001.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019014, P0019906, P0019908, P0019910, P0019911, P0019912, P0019921, S00101; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0013001")
@RequiredArgsConstructor
public class SrcR0013001Controller {

    private final SrcR0013001Service srcR0013001Service;

    /** Program-to-program entry: LINK at src/R0012001.pli:248, LINK at src/R0012201.pli:299, LINK at src/R0012201.pli:341, LINK at src/R0012201.pli:357, LINK at src/R001NO10.pli:928. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0013001Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}