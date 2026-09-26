package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0013110Service;

/**
 * CICS program R0013110 (src/R0013110.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019906, P0019908, P0019910, P0019912, P0019921, P0019928, P0019930; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0013110")
@RequiredArgsConstructor
public class SrcR0013110Controller {

    private final SrcR0013110Service srcR0013110Service;

    /** Program-to-program entry: LINK at src/R0010410.pli:5566, LINK at src/R0010410.pli:5584, LINK at src/R0010430.pli:1388, LINK at src/R0010452.pli:176, LINK at src/R0010452.pli:294, LINK at src/R0010452.pli:322, LINK at src/R0013101.pli:228, LINK at src/R0013101.pli:335, LINK at src/R0013101.pli:409, LINK at src/R0013101.pli:463, LINK at src/R0013101.pli:611, LINK at src/R0019928.pli:81, LINK at src/R0019928.pli:134, LINK at src/R0019928.pli:250, LINK at src/R0019F21.pli:40, LINK at src/R0019F21.pli:144, LINK at src/R0019F21.pli:250, LINK at src/R001I601.pli:293. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0013110Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}