package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0010422Service;

/**
 * CICS program R0010422 (src/R0010422.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, S001A2; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0010422")
@RequiredArgsConstructor
public class SrcR0010422Controller {

    private final SrcR0010422Service srcR0010422Service;

    /** Program-to-program entry: XCTL at src/R0010420.pli:99. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0010422Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}