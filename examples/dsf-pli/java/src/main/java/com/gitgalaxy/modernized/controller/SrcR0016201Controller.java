package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0016201Service;

/**
 * CICS program R0016201 (src/R0016201.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0016201, P0016202, P0019906, P0019908, P0019912; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0016201")
@RequiredArgsConstructor
public class SrcR0016201Controller {

    private final SrcR0016201Service srcR0016201Service;

    /** Program-to-program entry: LINK at src/R0010452.pli:424, LINK at src/R0010452.pli:447. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0016201Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}