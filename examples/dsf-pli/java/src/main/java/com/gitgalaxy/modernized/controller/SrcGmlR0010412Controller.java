package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0010412Service;

/**
 * CICS program R0010412 (src/GML/R0010412.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter LOKAL_KOM_PTR, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019913; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0010412")
@RequiredArgsConstructor
public class SrcGmlR0010412Controller {

    private final SrcGmlR0010412Service srcGmlR0010412Service;

    /** Program-to-program entry: XCTL at src/GML/R0010410.pli:3650, LINK at src/GML/R0010451.pli:596, LINK at src/GML/R0010452.pli:476. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0010412Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}