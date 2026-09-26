package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR001ia01Service;

/**
 * CICS program R001IA01 (src/GML/R001IA01.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019906, P0019908, P0019910, P0019912, P0019927, P001IA01, S001IA; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r001ia01")
@RequiredArgsConstructor
public class SrcGmlR001ia01Controller {

    private final SrcGmlR001ia01Service srcGmlR001ia01Service;

    /** Program-to-program entry: XCTL at src/GML/R001I101.pli:372. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR001ia01Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}