package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0013110Service;

/**
 * CICS program R0013110 (src/GML/R0013110.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019906, P0019908, P0019910, P0019912, P0019921, P0019928, P0019930; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0013110")
@RequiredArgsConstructor
public class SrcGmlR0013110Controller {

    private final SrcGmlR0013110Service srcGmlR0013110Service;

    /** Program-to-program entry: LINK at src/GML/R0010410.pli:3748, LINK at src/GML/R0010410.pli:3771, LINK at src/GML/R0010430.pli:1369, LINK at src/GML/R0010452.pli:186, LINK at src/GML/R0010452.pli:299, LINK at src/GML/R0010452.pli:327, LINK at src/GML/R0013101.pli:236, LINK at src/GML/R0013101.pli:344, LINK at src/GML/R0013101.pli:418, LINK at src/GML/R0013101.pli:477, LINK at src/GML/R0013101.pli:618, LINK at src/GML/R0019928.pli:87, LINK at src/GML/R0019928.pli:140, LINK at src/GML/R0019928.pli:202, LINK at src/GML/R0019F21.pli:47, LINK at src/GML/R0019F21.pli:151, LINK at src/GML/R0019F21.pli:257, LINK at src/GML/R001I601.pli:287. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0013110Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}