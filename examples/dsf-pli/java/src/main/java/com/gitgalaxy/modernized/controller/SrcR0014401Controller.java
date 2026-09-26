package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0014401Service;

/**
 * CICS program R0014401 (src/R0014401.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010601, P0014002, P0014003, P0014009, P0019906, P0019908, P0019910, P0019912, P0019921, P0019924, P0019925, P001N601, P001U601; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0014401")
@RequiredArgsConstructor
public class SrcR0014401Controller {

    private final SrcR0014401Service srcR0014401Service;

    /** Program-to-program entry: LINK at src/R0014001.pli:330, LINK at src/R0014001.pli:407, LINK at src/R0014001.pli:459, LINK at src/R0014001.pli:526, LINK at src/R0014001.pli:560, LINK at src/R0014001.pli:612. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0014401Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}