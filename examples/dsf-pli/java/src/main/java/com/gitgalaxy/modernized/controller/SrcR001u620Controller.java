package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR001u620Service;

/**
 * CICS program R001U620 (src/R001U620.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019913, P0019921, P0019924, P001U601; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001u620")
@RequiredArgsConstructor
public class SrcR001u620Controller {

    private final SrcR001u620Service srcR001u620Service;

    /** Program-to-program entry: XCTL at src/R0013520.pli:110. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR001u620Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}