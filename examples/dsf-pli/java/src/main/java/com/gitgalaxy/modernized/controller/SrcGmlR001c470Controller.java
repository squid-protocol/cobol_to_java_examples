package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR001c470Service;

/**
 * CICS program R001C470 (src/GML/R001C470.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P001U601, P001UC01, P001UE01, P001UJ01, S001F3; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r001c470")
@RequiredArgsConstructor
public class SrcGmlR001c470Controller {

    private final SrcGmlR001c470Service srcGmlR001c470Service;

    /** Program-to-program entry: LINK at src/GML/R0010470.pli:127. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR001c470Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}