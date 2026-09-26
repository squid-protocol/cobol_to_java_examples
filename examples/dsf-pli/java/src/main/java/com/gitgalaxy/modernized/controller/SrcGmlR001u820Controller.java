package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR001u820Service;

/**
 * CICS program R001U820 (src/GML/R001U820.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019921, P001U801; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r001u820")
@RequiredArgsConstructor
public class SrcGmlR001u820Controller {

    private final SrcGmlR001u820Service srcGmlR001u820Service;

    /** Program-to-program entry: XCTL at src/GML/R0013520.pli:126. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR001u820Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}