package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0019928Service;

/**
 * CICS program R0019928 (src/GML/R0019928.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019911, P0019912, P0019921; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0019928")
@RequiredArgsConstructor
public class SrcGmlR0019928Controller {

    private final SrcGmlR0019928Service srcGmlR0019928Service;

    /** Program-to-program entry: LINK at src/GML/R0010520.pli:463, LINK at src/GML/R0010520.pli:570, LINK at src/GML/R0010620.pli:565, LINK at src/GML/R0010620.pli:679, LINK at src/GML/R0010820.pli:118, LINK at src/GML/R0011020.pli:115, LINK at src/GML/R0011020.pli:149, LINK at src/GML/R0011020.pli:507, LINK at src/GML/R0011120.pli:116, LINK at src/GML/R0011120.pli:553, LINK at src/GML/R0011220.pli:409, LINK at src/GML/R0011430.pli:105, LINK at src/GML/R0011920.pli:501, LINK at src/GML/R001N520.pli:465, LINK at src/GML/R001N520.pli:572, LINK at src/GML/R001N620.pli:564, LINK at src/GML/R001N620.pli:706, LINK at src/GML/R001N820.pli:160, LINK at src/GML/R001NB20.pli:98, LINK at src/GML/R001NB20.pli:539, LINK at src/GML/R001NC20.pli:449, LINK at src/GML/R001U620.pli:573, LINK at src/GML/R001U820.pli:158, LINK at src/GML/R001UC20.pli:428, LINK at src/GML/R001UE30.pli:97, LINK at src/GML/R001UJ20.pli:459. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0019928Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}