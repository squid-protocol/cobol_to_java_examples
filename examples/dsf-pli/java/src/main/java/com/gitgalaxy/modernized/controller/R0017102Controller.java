package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.R0017102Service;

/**
 * CICS program R0017102 (src/GML/R0017102.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019001, P0019014, P0019906, P0019908, P0019912, P0019921; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/r0017102")
@RequiredArgsConstructor
public class R0017102Controller {

    private final R0017102Service r0017102Service;

    /** Program-to-program entry: LINK at src/GML/R0019F05.pli:709. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        r0017102Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}