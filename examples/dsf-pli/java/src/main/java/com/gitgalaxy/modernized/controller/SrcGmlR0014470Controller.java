package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0014470Service;

/**
 * CICS program R0014470 (src/GML/R0014470.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0014002, P0014003, P0014009, P0019906, P0019908, P0019910, P0019912, P0019921, P0019939, P0019966, P0019985; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0014470")
@RequiredArgsConstructor
public class SrcGmlR0014470Controller {

    private final SrcGmlR0014470Service srcGmlR0014470Service;

    /** Program-to-program entry: LINK at src/GML/R0014001.pli:633, LINK at src/GML/R0014001.pli:656. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0014470Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}