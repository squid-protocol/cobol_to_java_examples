package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0014901Service;

/**
 * CICS program R0014901 (src/R0014901.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0014003, P0019906, P0019908, P0019910, P0019911, P0019912, P0019921, P0019925; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0014901")
@RequiredArgsConstructor
public class SrcR0014901Controller {

    private final SrcR0014901Service srcR0014901Service;

    /** Program-to-program entry: LINK at src/R0010451.pli:547, LINK at src/R0011820.pli:364, LINK at src/R0013001.pli:539, LINK at src/R0019951.pli:238, LINK at src/R0019E01.pli:1744, LINK at src/R0019E01.pli:1903, LINK at src/R0019E04.pli:1788, LINK at src/R0019E04.pli:1947, LINK at src/R0019F01.pli:575. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0014901Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}