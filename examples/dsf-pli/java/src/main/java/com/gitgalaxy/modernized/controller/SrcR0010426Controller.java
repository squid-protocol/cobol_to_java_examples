package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0010426Service;

/**
 * CICS program R0010426 (src/R0010426.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, S0019A, S001A6; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0010426")
@RequiredArgsConstructor
public class SrcR0010426Controller {

    private final SrcR0010426Service srcR0010426Service;

    /** Program-to-program entry: XCTL at src/A0010301.pli:343, XCTL at src/R0010301.pli:424, XCTL at src/R001NO10.pli:2050. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0010426Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}