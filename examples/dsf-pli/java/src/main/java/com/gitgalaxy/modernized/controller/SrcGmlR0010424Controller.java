package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0010424Service;

/**
 * CICS program R0010424 (src/GML/R0010424.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, S001A4; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0010424")
@RequiredArgsConstructor
public class SrcGmlR0010424Controller {

    private final SrcGmlR0010424Service srcGmlR0010424Service;

    /** Program-to-program entry: XCTL at src/GML/R0010420.pli:103. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0010424Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}