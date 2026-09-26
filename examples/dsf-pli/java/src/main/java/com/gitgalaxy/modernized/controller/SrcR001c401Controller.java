package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR001c401Service;

/**
 * CICS program R001C401 (src/R001C401.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, S00101, S001U6, S001U8, S001UC, S001UE, S001UJ; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001c401")
@RequiredArgsConstructor
public class SrcR001c401Controller {

    private final SrcR001c401Service srcR001c401Service;

    /** Program-to-program entry: XCTL at src/R0010401.pli:182. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR001c401Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}