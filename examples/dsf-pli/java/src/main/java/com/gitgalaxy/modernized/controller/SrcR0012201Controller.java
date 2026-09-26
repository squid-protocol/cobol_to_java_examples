package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0012201Service;

/**
 * CICS program R0012201 (src/R0012201.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010801, P0011001, P0011101, P0011601, P0019906, P0019908, P0019910, P0019912, P001N801, P001NB01, P001U801; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0012201")
@RequiredArgsConstructor
public class SrcR0012201Controller {

    private final SrcR0012201Service srcR0012201Service;

    /** Program-to-program entry: LINK at src/R0012001.pli:205, LINK at src/R001NO10.pli:907. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0012201Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}