package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR00104apService;

/**
 * CICS program R00104AP (src/R00104AP.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter LOKAL_KOM_PTR, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010501, P0019906, P0019908, P0019910, P0019912, P0019913, S001F1; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r00104ap")
@RequiredArgsConstructor
public class SrcR00104apController {

    private final SrcR00104apService srcR00104apService;

    /** Program-to-program entry: LINK at src/R0018A12.pli:167, LINK at src/R001A412.pli:173. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR00104apService.handleLink();
        return ResponseEntity.noContent().build();
    }

}