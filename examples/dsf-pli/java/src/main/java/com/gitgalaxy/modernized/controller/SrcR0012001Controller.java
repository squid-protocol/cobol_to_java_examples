package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0012001Service;

/**
 * CICS program R0012001 (src/R0012001.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0014009, P0019906, P0019908, P0019910, P0019912, P0019924, P0019925, S00118; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0012001")
@RequiredArgsConstructor
public class SrcR0012001Controller {

    private final SrcR0012001Service srcR0012001Service;

    /** Program-to-program entry: XCTL at src/R0010401.pli:238, XCTL at src/R0010480.pli:3222, XCTL at src/R0011501.pli:176, XCTL at src/R0011801.pli:207, XCTL at src/R001I401.pli:354. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0012001Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}