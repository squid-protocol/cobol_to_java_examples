package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0015411Service;

/**
 * CICS program R0015411 (src/GML/R0015411.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019908, P0019910, P0019912, P0019921; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0015411")
@RequiredArgsConstructor
public class SrcGmlR0015411Controller {

    private final SrcGmlR0015411Service srcGmlR0015411Service;

    /** Program-to-program entry: LINK at src/GML/R0013001.pli:447. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0015411Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}