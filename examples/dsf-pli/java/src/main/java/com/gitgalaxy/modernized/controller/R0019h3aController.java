package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.R0019h3aService;

/**
 * CICS program R0019H3A (src/R0019H3A.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0014009, P0019014, P0019906, P0019908, P0019910, P0019912, P0019921, P0019924, P0019925, P001992G, P0019930, P0019H31, S0019H; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/r0019h3a")
@RequiredArgsConstructor
public class R0019h3aController {

    private final R0019h3aService r0019h3aService;

    /** Program-to-program entry: no CSD transaction enters this program. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        r0019h3aService.handleLink();
        return ResponseEntity.noContent().build();
    }

}