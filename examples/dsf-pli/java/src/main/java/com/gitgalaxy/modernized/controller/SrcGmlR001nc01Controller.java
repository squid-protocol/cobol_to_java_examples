package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR001nc01Service;

/**
 * CICS program R001NC01 (src/GML/R001NC01.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P001NC01, S001NC; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r001nc01")
@RequiredArgsConstructor
public class SrcGmlR001nc01Controller {

    private final SrcGmlR001nc01Service srcGmlR001nc01Service;

    /** Program-to-program entry: XCTL at src/GML/R0013301.pli:80. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR001nc01Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}