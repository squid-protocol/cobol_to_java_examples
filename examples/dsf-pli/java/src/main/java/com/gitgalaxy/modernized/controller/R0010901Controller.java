package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.R0010901Service;

/**
 * CICS program R0010901 (src/GML/R0010901.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010901, P0019906, P0019908, P0019910, P0019912, S00109; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/r0010901")
@RequiredArgsConstructor
public class R0010901Controller {

    private final R0010901Service r0010901Service;

    /** Program-to-program entry: XCTL at src/GML/R0013301.pli:68, XCTL at src/R0013301.pli:58. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        r0010901Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}