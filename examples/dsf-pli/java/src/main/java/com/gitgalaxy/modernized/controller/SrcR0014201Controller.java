package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0014201Service;

/**
 * CICS program R0014201 (src/R0014201.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010501, P0011401, P0014002, P0014003, P0014009, P0019906, P0019908, P0019910, P0019912, P0019921, P0019924, P0019980, P001N501; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0014201")
@RequiredArgsConstructor
public class SrcR0014201Controller {

    private final SrcR0014201Service srcR0014201Service;

    /** Program-to-program entry: LINK at src/R0014001.pli:270, LINK at src/R0014001.pli:309, LINK at src/R0014001.pli:438, LINK at src/R0014001.pli:505, LINK at src/R0014001.pli:591. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0014201Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}