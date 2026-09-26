package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0016401Service;

/**
 * CICS program R0016401 (src/GML/R0016401.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019906, P0019908, P0019912; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0016401")
@RequiredArgsConstructor
public class SrcGmlR0016401Controller {

    private final SrcGmlR0016401Service srcGmlR0016401Service;

    /** Program-to-program entry: LINK at src/GML/R0010452.pli:432, LINK at src/GML/R0010452.pli:454, LINK at src/GML/R0019951.pli:341, LINK at src/GML/R0019951.pli:380, LINK at src/GML/R0019961.pli:95, LINK at src/GML/R0019961.pli:139, LINK at src/GML/R0019F01.pli:673, LINK at src/GML/R0019F02.pli:714, LINK at src/GML/R0019F03.pli:679, LINK at src/GML/R0019F05.pli:755. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0016401Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}