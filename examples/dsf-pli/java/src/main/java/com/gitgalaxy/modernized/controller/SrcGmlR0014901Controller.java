package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0014901Service;

/**
 * CICS program R0014901 (src/GML/R0014901.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019911, P0019912, P0019921, P0019925; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0014901")
@RequiredArgsConstructor
public class SrcGmlR0014901Controller {

    private final SrcGmlR0014901Service srcGmlR0014901Service;

    /** Program-to-program entry: LINK at src/GML/R0010451.pli:539, LINK at src/GML/R0011820.pli:377, LINK at src/GML/R0013001.pli:588, LINK at src/GML/R0019951.pli:302, LINK at src/GML/R0019E04.pli:1753, LINK at src/GML/R0019E04.pli:1912, LINK at src/GML/R0019F01.pli:632, LINK at src/GML/R0019F02.pli:671, LINK at src/GML/R0019F03.pli:628, LINK at src/GML/R0019F05.pli:678. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0014901Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}