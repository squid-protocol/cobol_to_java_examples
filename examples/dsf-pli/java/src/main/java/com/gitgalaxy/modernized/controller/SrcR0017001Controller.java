package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0017001Service;

/**
 * CICS program R0017001 (src/R0017001.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0014003, P0014009, P0019001, P0019014, P0019906, P0019908, P0019910, P0019911, P0019912, P0019921, P0019924, P0019925; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0017001")
@RequiredArgsConstructor
public class SrcR0017001Controller {

    private final SrcR0017001Service srcR0017001Service;

    /** Program-to-program entry: LINK at src/R0011820.pli:351, LINK at src/R0013001.pli:334, LINK at src/R0013001.pli:377, LINK at src/R0014901.pli:495, LINK at src/R0014901.pli:516, LINK at src/R0014901.pli:539, LINK at src/R0014901.pli:2005, LINK at src/R0019951.pli:272, LINK at src/R0019961.pli:85. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0017001Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}