package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR001tk61Service;

/**
 * CICS program R001TK61 (src/GML/R001TK61.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P001TK03, S001T2, S001T3; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r001tk61")
@RequiredArgsConstructor
public class SrcGmlR001tk61Controller {

    private final SrcGmlR001tk61Service srcGmlR001tk61Service;

    /** Program-to-program entry: no CSD transaction enters this program. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR001tk61Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}