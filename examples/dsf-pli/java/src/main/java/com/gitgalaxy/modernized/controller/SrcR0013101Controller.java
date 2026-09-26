package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0013101Service;

/**
 * CICS program R0013101 (src/R0013101.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010501, P0010601, P0011901, P0012002, P0012003, P0019906, P0019908, P0019910, P0019911, P0019912, P0019921, P001N501, P001N601, P001U601, P001UJ01; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0013101")
@RequiredArgsConstructor
public class SrcR0013101Controller {

    private final SrcR0013101Service srcR0013101Service;

    /** Program-to-program entry: LINK at src/R0010451.pli:124, LINK at src/R0010451.pli:245, LINK at src/R0011720.pli:647, LINK at src/R0011820.pli:164, LINK at src/R0013001.pli:184, LINK at src/R0019E01.pli:1345, LINK at src/R0019E01.pli:2084, LINK at src/R0019E01.pli:2204, LINK at src/R0019E04.pli:1389, LINK at src/R0019E04.pli:2128, LINK at src/R0019E04.pli:2248, LINK at src/R0019H01.pli:877, LINK at src/R0019H21.pli:860, LINK at src/R0019H31.pli:832, LINK at src/R0019H3A.pli:808, LINK at src/R0019H41.pli:800, LINK at src/R0019H60.pli:735, LINK at src/R001HL21.pli:843, LINK at src/R001I601.pli:363, LINK at src/R001I601.pli:407. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0013101Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}