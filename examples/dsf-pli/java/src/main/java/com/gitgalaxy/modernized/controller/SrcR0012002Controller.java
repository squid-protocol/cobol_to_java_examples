package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0012002Service;

/**
 * CICS program R0012002 (src/R0012002.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0014009, P0019906, P0019908, P0019910, P0019912, P0019924, P0019925; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0012002")
@RequiredArgsConstructor
public class SrcR0012002Controller {

    private final SrcR0012002Service srcR0012002Service;

    /** Program-to-program entry: LINK at src/R0012301.pli:883, LINK at src/R0019A03.pli:76. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0012002Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}