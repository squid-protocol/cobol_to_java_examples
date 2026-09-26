package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR001nb01Service;

/**
 * CICS program R001NB01 (src/R001NB01.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P001NB01, S001NB; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001nb01")
@RequiredArgsConstructor
public class SrcR001nb01Controller {

    private final SrcR001nb01Service srcR001nb01Service;

    /** Program-to-program entry: XCTL at src/R0013301.pli:66. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR001nb01Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}