package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0014501Service;

/**
 * CICS program R0014501 (src/R0014501.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010601, P0010801, P0014002, P0014003, P0014009, P0019906, P0019908, P0019912, P0019921, P0019924, P0019925, P001N601, P001N801, P001U601, P001U801; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0014501")
@RequiredArgsConstructor
public class SrcR0014501Controller {

    private final SrcR0014501Service srcR0014501Service;

    /** Program-to-program entry: LINK at src/R0014001.pli:399, LINK at src/R0014001.pli:551. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0014501Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}