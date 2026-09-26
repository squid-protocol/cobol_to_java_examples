package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0014401Service;

/**
 * CICS program R0014401 (src/GML/R0014401.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010601, P0014002, P0014003, P0014009, P0019906, P0019908, P0019910, P0019912, P0019921, P0019924, P0019925, P001N601, P001U601; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0014401")
@RequiredArgsConstructor
public class SrcGmlR0014401Controller {

    private final SrcGmlR0014401Service srcGmlR0014401Service;

    /** Program-to-program entry: LINK at src/GML/R0014001.pli:294, LINK at src/GML/R0014001.pli:371, LINK at src/GML/R0014001.pli:421, LINK at src/GML/R0014001.pli:484, LINK at src/GML/R0014001.pli:518, LINK at src/GML/R0014001.pli:568. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0014401Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}