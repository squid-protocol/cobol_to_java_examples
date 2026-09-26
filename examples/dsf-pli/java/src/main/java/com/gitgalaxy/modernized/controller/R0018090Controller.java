package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.R0018090Service;

/**
 * CICS program R0018090 (src/R0018090.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010501, P0010601, P0010701, P0010801, P0010901, P0011001, P0011101, P0011201, P0011401, P0011601, P0011701, P0011831, P0011901, P0012002, P0012003, P0018201, P0019906, P0019908, P0019910, P0019911, P0019912, P0019921, P001N501, P001N601, P001N801, P001N901, P001NB01, P001NC01, P001U601, P001U801, P001UC01, P001UE01, P001UJ01, S00101; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/r0018090")
@RequiredArgsConstructor
public class R0018090Controller {

    private final R0018090Service r0018090Service;

    /** Program-to-program entry: LINK at src/R0010450.pli:540, LINK at src/R0010450.pli:652. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        r0018090Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}