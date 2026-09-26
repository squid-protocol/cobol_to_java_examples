package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0019h50Service;

/**
 * CICS program R0019H50 (src/GML/R0019H50.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019908, P0019910, P0019912, P0019921; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0019h50")
@RequiredArgsConstructor
public class SrcGmlR0019h50Controller {

    private final SrcGmlR0019h50Service srcGmlR0019h50Service;

    /** Program-to-program entry: LINK at src/GML/R0019H01.pli:923. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0019h50Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}