package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR001i501Service;

/**
 * CICS program R001I501 (src/R001I501.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019906, P0019908, P0019910, P0019912, P0019927, P0019928, P0019930, P001I401, S001I4; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001i501")
@RequiredArgsConstructor
public class SrcR001i501Controller {

    private final SrcR001i501Service srcR001i501Service;

    /** Program-to-program entry: LINK at src/R0012001.pli:223. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR001i501Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}