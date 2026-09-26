package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR00104kfService;

/**
 * CICS program R00104KF (src/GML/R00104KF.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter LOKAL_KOM_PTR, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019913, P001UJ01, S001F3; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r00104kf")
@RequiredArgsConstructor
public class SrcGmlR00104kfController {

    private final SrcGmlR00104kfService srcGmlR00104kfService;

    /** Program-to-program entry: LINK at src/GML/R001C412.pli:148. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR00104kfService.handleLink();
        return ResponseEntity.noContent().build();
    }

}