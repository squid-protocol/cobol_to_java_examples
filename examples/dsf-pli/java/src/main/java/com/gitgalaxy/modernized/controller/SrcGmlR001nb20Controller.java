package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR001nb20Service;

/**
 * CICS program R001NB20 (src/GML/R001NB20.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019921, P001NB01; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r001nb20")
@RequiredArgsConstructor
public class SrcGmlR001nb20Controller {

    private final SrcGmlR001nb20Service srcGmlR001nb20Service;

    /** Program-to-program entry: XCTL at src/GML/R0013520.pli:152. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR001nb20Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}