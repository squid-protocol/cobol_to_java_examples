package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.R0019h41Service;

/**
 * CICS program R0019H41 (src/R0019H41.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0014009, P0019014, P0019906, P0019908, P0019910, P0019912, P0019921, P0019924, P0019925, P001992G, P0019930, S0019H; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/r0019h41")
@RequiredArgsConstructor
public class R0019h41Controller {

    private final R0019h41Service r0019h41Service;

    /** Program-to-program entry: XCTL at src/R0010426.pli:137. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        r0019h41Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}