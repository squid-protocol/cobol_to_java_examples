package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR001b470Service;

/**
 * CICS program R001B470 (src/R001B470.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P001N501, P001N601, P001N801, P001N901, P001NB01, P001NC01, S001F2; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001b470")
@RequiredArgsConstructor
public class SrcR001b470Controller {

    private final SrcR001b470Service srcR001b470Service;

    /** Program-to-program entry: LINK at src/R0010470.pli:105. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR001b470Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}