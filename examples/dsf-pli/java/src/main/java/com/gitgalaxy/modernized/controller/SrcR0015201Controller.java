package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0015201Service;

/**
 * CICS program R0015201 (src/R0015201.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012001, P0012002, P0012003, P0019906, P0019908, P0019910, P0019912, P0019921; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0015201")
@RequiredArgsConstructor
public class SrcR0015201Controller {

    private final SrcR0015201Service srcR0015201Service;

    /** Program-to-program entry: LINK at src/R0010410.pli:5353, LINK at src/R0010410.pli:5427, LINK at src/R0010452.pli:85, LINK at src/R0010452.pli:140, LINK at src/R0019952.pli:204. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0015201Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}