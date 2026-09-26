package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0016001Service;

/**
 * CICS program R0016001 (src/GML/R0016001.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0012002, P0012003, P0014009, P0016001, P0018201, P0018202, P0018203, P0018204, P0018205, P0018206, P0018207, P0018208, P0018209, P0018210, P0018211, P0018214, P0018215, P0018216, P0018217, P0018219, P0018220, P0019906, P0019908, P0019911, P0019912, P0019921; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0016001")
@RequiredArgsConstructor
public class SrcGmlR0016001Controller {

    private final SrcGmlR0016001Service srcGmlR0016001Service;

    /** Program-to-program entry: LINK at src/GML/R0013001.pli:483, LINK at src/GML/R0014901.pli:546, LINK at src/GML/R0014901.pli:554, LINK at src/GML/R00149X1.pli:410, LINK at src/GML/R00149X1.pli:417, LINK at src/GML/R0019951.pli:327, LINK at src/GML/R0019961.pli:77, LINK at src/GML/R0019E04.pli:1825, LINK at src/GML/R0019E04.pli:1982, LINK at src/GML/R0019E04.pli:2312, LINK at src/GML/R0019H01.pli:905. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0016001Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}