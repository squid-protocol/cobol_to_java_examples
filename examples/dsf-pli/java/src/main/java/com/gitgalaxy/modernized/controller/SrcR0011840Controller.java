package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0011840Service;

/**
 * CICS program R0011840 (src/R0011840.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0011831, P0019906, P0019908, P0019910, P0019912, P0019913, P0019921; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0011840")
@RequiredArgsConstructor
public class SrcR0011840Controller {

    private final SrcR0011840Service srcR0011840Service;

    /** Program-to-program entry: XCTL at src/R0013520.pli:119. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0011840Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}