package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.R0018021Service;

/**
 * CICS program R0018021 (src/R0018021.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0018011, P0018201, P0019906, P0019908, P0019910, P0019912; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/r0018021")
@RequiredArgsConstructor
public class R0018021Controller {

    private final R0018021Service r0018021Service;

    /** Program-to-program entry: LINK at src/R0018010.pli:1158. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        r0018021Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}