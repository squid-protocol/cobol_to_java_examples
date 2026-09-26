package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0010490Service;

/**
 * CICS program R0010490 (src/GML/R0010490.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0010501, P0010601, P0010701, P0010801, P0010901, P0011001, P0011101, P0011201, P0011401, P0011601, P0011701, P0011831, P0011901, P0012001, P0012002, P0012003, P0019906, P0019908, P0019910, P0019911, P0019912, P001N501, P001N601, P001N801, P001N901, P001NB01, P001NC01, P001U601, P001U801, P001UC01, P001UE01, P001UJ01, S00101; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0010490")
@RequiredArgsConstructor
public class SrcGmlR0010490Controller {

    private final SrcGmlR0010490Service srcGmlR0010490Service;

    /** Program-to-program entry: LINK at src/GML/R0010450.pli:524, LINK at src/GML/R0010450.pli:609, LINK at src/GML/R0010501.pli:481, LINK at src/GML/R0010601.pli:611, LINK at src/GML/R0010701.pli:283, LINK at src/GML/R0010801.pli:493, LINK at src/GML/R0010901.pli:281, LINK at src/GML/R0011001.pli:486, LINK at src/GML/R0011101.pli:254, LINK at src/GML/R0011201.pli:299, LINK at src/GML/R0011401.pli:278, LINK at src/GML/R0011501.pli:233, LINK at src/GML/R0011601.pli:241, LINK at src/GML/R0011701.pli:243, LINK at src/GML/R0011901.pli:409, LINK at src/GML/R001N501.pli:442, LINK at src/GML/R001N601.pli:596, LINK at src/GML/R001N801.pli:490, LINK at src/GML/R001N901.pli:280, LINK at src/GML/R001NB01.pli:255, LINK at src/GML/R001NC01.pli:352, LINK at src/GML/R001U601.pli:650, LINK at src/GML/R001U801.pli:642, LINK at src/GML/R001UC01.pli:349, LINK at src/GML/R001UE01.pli:299, LINK at src/GML/R001UJ01.pli:401. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0010490Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}