package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR001n820Service;

/**
 * CICS program R001N820 (src/GML/R001N820.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019921, P001N801; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r001n820")
@RequiredArgsConstructor
public class SrcGmlR001n820Controller {

    private final SrcGmlR001n820Service srcGmlR001n820Service;

    /** Program-to-program entry: XCTL at src/GML/R0013520.pli:124. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR001n820Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}