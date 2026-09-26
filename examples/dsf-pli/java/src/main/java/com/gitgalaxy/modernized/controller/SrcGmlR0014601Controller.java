package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0014601Service;

/**
 * CICS program R0014601 (src/GML/R0014601.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019912, P0019921, P001N901; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0014601")
@RequiredArgsConstructor
public class SrcGmlR0014601Controller {

    private final SrcGmlR0014601Service srcGmlR0014601Service;

    /** Program-to-program entry: LINK at src/GML/R0014001.pli:320. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0014601Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}