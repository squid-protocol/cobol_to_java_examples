package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR001a470Service;

/**
 * CICS program R001A470 (src/GML/R001A470.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010501, P0010601, P0010701, P0010801, P0010901, P0011001, P0011101, P0011201, P0011401, P0011501, P0011601, P0011701, P0011831, P0011901, P0019906, P0019908, P0019910, P0019912, S001F1; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r001a470")
@RequiredArgsConstructor
public class SrcGmlR001a470Controller {

    private final SrcGmlR001a470Service srcGmlR001a470Service;

    /** Program-to-program entry: LINK at src/GML/R0010470.pli:120. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR001a470Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}