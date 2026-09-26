package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR001tk09Service;

/**
 * CICS program R001TK09 (src/GML/R001TK09.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012003, P001TK03, P001TK51, P001TK52, P001TK53, P001TK55, P001TK56, P001TK57, S001T3, S001T6; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r001tk09")
@RequiredArgsConstructor
public class SrcGmlR001tk09Controller {

    private final SrcGmlR001tk09Service srcGmlR001tk09Service;

    /** Program-to-program entry: no CSD transaction enters this program. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR001tk09Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}