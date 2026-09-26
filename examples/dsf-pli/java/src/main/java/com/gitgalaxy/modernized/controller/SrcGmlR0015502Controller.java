package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0015502Service;

/**
 * CICS program R0015502 (src/GML/R0015502.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter LOKAL_KOM_PTR, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019908, P0019912, P0019913; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0015502")
@RequiredArgsConstructor
public class SrcGmlR0015502Controller {

    private final SrcGmlR0015502Service srcGmlR0015502Service;

    /** Program-to-program entry: LINK at src/GML/R0010452.pli:392. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0015502Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}