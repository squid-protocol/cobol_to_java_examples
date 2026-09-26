package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0011831Service;

/**
 * CICS program R0011831 (src/R0011831.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0011831, P0019906, P0019908, P0019910, P0019912, S00183; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0011831")
@RequiredArgsConstructor
public class SrcR0011831Controller {

    private final SrcR0011831Service srcR0011831Service;

    /** Program-to-program entry: XCTL at src/R0013301.pli:42. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0011831Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}