package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0011001Service;

/**
 * CICS program R0011001 (src/GML/R0011001.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0011001, P0019906, P0019908, P0019910, P0019912, S00110, S00120; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0011001")
@RequiredArgsConstructor
public class SrcGmlR0011001Controller {

    private final SrcGmlR0011001Service srcGmlR0011001Service;

    /** Program-to-program entry: XCTL at src/GML/R0013301.pli:72. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0011001Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}