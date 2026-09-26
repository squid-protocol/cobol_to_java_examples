package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR00104e3Service;

/**
 * CICS program R00104E3 (src/GML/R00104E3.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter LOKAL_KOM_PTR, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019913, P001N801, S001F2; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r00104e3")
@RequiredArgsConstructor
public class SrcGmlR00104e3Controller {

    private final SrcGmlR00104e3Service srcGmlR00104e3Service;

    /** Program-to-program entry: LINK at src/GML/R001B412.pli:191. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR00104e3Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}