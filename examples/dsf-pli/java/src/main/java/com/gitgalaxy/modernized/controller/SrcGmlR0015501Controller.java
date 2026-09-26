package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0015501Service;

/**
 * CICS program R0015501 (src/GML/R0015501.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter LOKAL_KOM_PTR, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019908, P0019912, P0019913, P0019929, P0019931; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0015501")
@RequiredArgsConstructor
public class SrcGmlR0015501Controller {

    private final SrcGmlR0015501Service srcGmlR0015501Service;

    /** Program-to-program entry: LINK at src/GML/R0010451.pli:472, LINK at src/GML/R0010452.pli:397, LINK at src/GML/R0010622.pli:175, LINK at src/GML/R001N622.pli:143, LINK at src/GML/R001U622.pli:173. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0015501Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}