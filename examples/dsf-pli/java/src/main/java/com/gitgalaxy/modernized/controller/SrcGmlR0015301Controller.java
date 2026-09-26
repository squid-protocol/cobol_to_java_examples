package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0015301Service;

/**
 * CICS program R0015301 (src/GML/R0015301.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012001, P0012002, P0012003, P0019906, P0019908, P0019910, P0019911, P0019912; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0015301")
@RequiredArgsConstructor
public class SrcGmlR0015301Controller {

    private final SrcGmlR0015301Service srcGmlR0015301Service;

    /** Program-to-program entry: LINK at src/GML/R0013001.pli:716, LINK at src/GML/R0016101.pli:294, LINK at src/GML/R0016101.pli:301. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0015301Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}