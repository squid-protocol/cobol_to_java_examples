package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0014141Service;

/**
 * CICS program R0014141 (src/GML/R0014141.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0014002, P0014003, P0014009, P0019906, P0019908, P0019910, P0019912, P0019921, P0019924; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0014141")
@RequiredArgsConstructor
public class SrcGmlR0014141Controller {

    private final SrcGmlR0014141Service srcGmlR0014141Service;

    /** Program-to-program entry: LINK at src/GML/R0014131.pli:182, LINK at src/GML/R0014131.pli:385, LINK at src/GML/R0014231.pli:88, LINK at src/GML/R0014231.pli:238, LINK at src/GML/R0014252.pli:73, LINK at src/GML/R0014323.pli:48, LINK at src/GML/R0014370.pli:233, LINK at src/GML/R0014422.pli:71, LINK at src/GML/R0014422.pli:89, LINK at src/GML/R0014522.pli:92, LINK at src/GML/R0014522.pli:180, LINK at src/GML/R0014722.pli:46. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0014141Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}