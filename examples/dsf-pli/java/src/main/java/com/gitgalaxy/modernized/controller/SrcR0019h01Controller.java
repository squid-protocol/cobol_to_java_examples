package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0019h01Service;

/**
 * CICS program R0019H01 (src/R0019H01.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0014009, P0019014, P0019906, P0019908, P0019910, P0019912, P0019921, P0019924, P0019925, P001992G, P0019930, P0019H90, S0011H; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0019h01")
@RequiredArgsConstructor
public class SrcR0019h01Controller {

    private final SrcR0019h01Service srcR0019h01Service;

    /** Program-to-program entry: XCTL at src/R0010421.pli:82, XCTL at src/R0010426.pli:97. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0019h01Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}