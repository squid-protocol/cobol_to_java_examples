package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR001i101Service;

/**
 * CICS program R001I101 (src/R001I101.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0014009, P0019906, P0019908, P0019910, P0019912, P0019921, P0019924, P0019925, S001I1, S001IA; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001i101")
@RequiredArgsConstructor
public class SrcR001i101Controller {

    private final SrcR001i101Service srcR001i101Service;

    /** Program-to-program entry: XCTL at src/R001I301.pli:2117, XCTL at src/R001I701.pli:368, XCTL at src/R001I801.pli:492. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR001i101Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}