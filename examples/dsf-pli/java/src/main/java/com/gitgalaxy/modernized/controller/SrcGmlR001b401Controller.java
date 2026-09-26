package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR001b401Service;

/**
 * CICS program R001B401 (src/GML/R001B401.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019959, S00101, S001N5, S001N6, S001N8, S001N9, S001NB, S001NC; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r001b401")
@RequiredArgsConstructor
public class SrcGmlR001b401Controller {

    private final SrcGmlR001b401Service srcGmlR001b401Service;

    /** Program-to-program entry: XCTL at src/GML/R0010401.pli:219. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR001b401Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}