package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0011820Service;

/**
 * CICS program R0011820 (src/R0011820.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0011801, P0019014, P0019906, P0019908, P0019910, P0019911, P0019912, P0019921; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0011820")
@RequiredArgsConstructor
public class SrcR0011820Controller {

    private final SrcR0011820Service srcR0011820Service;

    /** Program-to-program entry: LINK at src/R0012001.pli:217, LINK at src/R0012002.pli:133. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0011820Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}