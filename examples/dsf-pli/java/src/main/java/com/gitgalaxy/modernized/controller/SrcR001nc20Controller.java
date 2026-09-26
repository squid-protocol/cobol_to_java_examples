package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR001nc20Service;

/**
 * CICS program R001NC20 (src/R001NC20.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019921, P001NC01; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001nc20")
@RequiredArgsConstructor
public class SrcR001nc20Controller {

    private final SrcR001nc20Service srcR001nc20Service;

    /** Program-to-program entry: XCTL at src/R0013520.pli:157. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR001nc20Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}