package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0010430Service;

/**
 * CICS program R0010430 (src/R0010430.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019906, P0019908, P0019910, P0019912, P0019921, P0019924, P0019925, S001A8; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0010430")
@RequiredArgsConstructor
public class SrcR0010430Controller {

    private final SrcR0010430Service srcR0010430Service;

    /** Program-to-program entry: XCTL at src/R0010420.pli:117. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0010430Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}