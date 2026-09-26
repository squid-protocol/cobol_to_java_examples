package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0013301Service;

/**
 * CICS program R0013301 (src/GML/R0013301.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0013301")
@RequiredArgsConstructor
public class SrcGmlR0013301Controller {

    private final SrcGmlR0013301Service srcGmlR0013301Service;

    /** Program-to-program entry: LINK at src/GML/R0010480.pli:3783, LINK at src/GML/R0011520.pli:650, LINK at src/GML/R0013001.pli:252, LINK at src/GML/R0013001.pli:925, LINK at src/GML/R0013501.pli:96, LINK at src/GML/R0013520.pli:475, LINK at src/GML/R0013601.pli:78, LINK at src/GML/R001I501.pli:2048. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0013301Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}