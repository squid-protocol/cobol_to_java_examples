package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0013101Service;

/**
 * CICS program R0013101 (src/GML/R0013101.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010501, P0010601, P0011901, P0012002, P0012003, P0019906, P0019908, P0019910, P0019911, P0019912, P0019921, P001N501, P001N601, P001U601, P001UJ01; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0013101")
@RequiredArgsConstructor
public class SrcGmlR0013101Controller {

    private final SrcGmlR0013101Service srcGmlR0013101Service;

    /** Program-to-program entry: LINK at src/GML/R0010451.pli:127, LINK at src/GML/R0010451.pli:239, LINK at src/GML/R0011720.pli:538, LINK at src/GML/R0011820.pli:180, LINK at src/GML/R0013001.pli:221, LINK at src/GML/R0019E04.pli:1358, LINK at src/GML/R0019E04.pli:2094, LINK at src/GML/R0019E04.pli:2220, LINK at src/GML/R0019H01.pli:818, LINK at src/GML/R0019H60.pli:735, LINK at src/GML/R001I601.pli:357, LINK at src/GML/R001I601.pli:401. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0013101Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}