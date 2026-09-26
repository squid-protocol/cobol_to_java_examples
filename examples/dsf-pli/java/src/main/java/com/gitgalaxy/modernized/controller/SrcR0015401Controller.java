package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0015401Service;

/**
 * CICS program R0015401 (src/R0015401.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0019908, P0019910, P0019912, P0019921, P0019928, P0019931, P0019939; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0015401")
@RequiredArgsConstructor
public class SrcR0015401Controller {

    private final SrcR0015401Service srcR0015401Service;

    /** Program-to-program entry: LINK at src/R0010451.pli:573, LINK at src/R0010452.pli:353, LINK at src/R0011820.pli:378, LINK at src/R0013001.pli:685, LINK at src/R0019951.pli:301, LINK at src/R0019961.pli:121, LINK at src/R0019E01.pli:1840, LINK at src/R0019E01.pli:1867, LINK at src/R0019E01.pli:1996, LINK at src/R0019E01.pli:2320, LINK at src/R0019E04.pli:1884, LINK at src/R0019E04.pli:1911, LINK at src/R0019E04.pli:2040, LINK at src/R0019E04.pli:2364, LINK at src/R0019F01.pli:905. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0015401Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}