package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.R0012010Service;

/**
 * CICS program R0012010 (src/R0012010.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010501, P0010601, P0010801, P0010901, P0011001, P0011101, P0011201, P0011401, P0011601, P0011701, P0011901, P0012002, P0012003, P0019906, P0019908, P0019910, P0019912, P0019927, P0019929, P0019940, P0019952, P001N501, P001N601, P001N801, P001N901, P001NB01, P001NC01, P001U601, P001U801, P001UC01, P001UE01, P001UJ01; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/r0012010")
@RequiredArgsConstructor
public class R0012010Controller {

    private final R0012010Service r0012010Service;

    /** Program-to-program entry: LINK at src/R0012001.pli:182, LINK at src/R001NO10.pli:887. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        r0012010Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}