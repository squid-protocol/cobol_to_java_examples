package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0010480Service;

/**
 * CICS program R0010480 (src/GML/R0010480.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012001, P0012002, P0012003, P0019906, P0019908, P0019910, P0019912, P0019921, P0019924, P0019925, P0019959, S00101, S001V1, S001V2, S001V3; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0010480")
@RequiredArgsConstructor
public class SrcGmlR0010480Controller {

    private final SrcGmlR0010480Service srcGmlR0010480Service;

    /** Program-to-program entry: XCTL at src/GML/R0012001.pli:244. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0010480Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}