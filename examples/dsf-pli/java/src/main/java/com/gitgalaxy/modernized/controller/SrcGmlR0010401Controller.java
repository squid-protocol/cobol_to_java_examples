package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0010401Service;

/**
 * CICS program R0010401 (src/GML/R0010401.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019959, S00101; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0010401")
@RequiredArgsConstructor
public class SrcGmlR0010401Controller {

    private final SrcGmlR0010401Service srcGmlR0010401Service;

    /** Program-to-program entry: XCTL at src/GML/R0010420.pli:160, XCTL at src/GML/R0010501.pli:190, XCTL at src/GML/R0010501.pli:392, XCTL at src/GML/R0010601.pli:208, XCTL at src/GML/R0010601.pli:228, XCTL at src/GML/R0010601.pli:517, XCTL at src/GML/R0010701.pli:151, XCTL at src/GML/R0010701.pli:221, XCTL at src/GML/R0010801.pli:126, XCTL at src/GML/R0010801.pli:141, XCTL at src/GML/R0010801.pli:396, XCTL at src/GML/R0010901.pli:88, XCTL at src/GML/R0010901.pli:192, XCTL at src/GML/R0011001.pli:124, XCTL at src/GML/R0011001.pli:142, XCTL at src/GML/R0011001.pli:325, XCTL at src/GML/R0011001.pli:374, XCTL at src/GML/R0011101.pli:91, XCTL at src/GML/R0011101.pli:167, XCTL at src/GML/R0011201.pli:103, XCTL at src/GML/R0011201.pli:209, XCTL at src/GML/R0011301.pli:146, XCTL at src/GML/R0011301.pli:165, XCTL at src/GML/R0011301.pli:184, XCTL at src/GML/R0011301.pli:205, XCTL at src/GML/R0011301.pli:367, XCTL at src/GML/R0011301.pli:400, XCTL at src/GML/R0011301.pli:441, XCTL at src/GML/R0011301.pli:446, XCTL at src/GML/R0011304.pli:161, XCTL at src/GML/R0011304.pli:187, XCTL at src/GML/R0011401.pli:94, XCTL at src/GML/R0011401.pli:194, XCTL at src/GML/R0011501.pli:99, XCTL at src/GML/R0011501.pli:172, XCTL at src/GML/R0011601.pli:91, XCTL at src/GML/R0011601.pli:159, XCTL at src/GML/R0011701.pli:89, XCTL at src/GML/R0011701.pli:160, XCTL at src/GML/R0011801.pli:116, XCTL at src/GML/R0011801.pli:192, XCTL at src/GML/R0011831.pli:156, XCTL at src/GML/R0011831.pli:325, XCTL at src/GML/R0011901.pli:178, XCTL at src/GML/R0011901.pli:320, XCTL at src/GML/R0012001.pli:252, XCTL at src/GML/R0013520.pli:479, XCTL at src/GML/R001B001.pli:1484, XCTL at src/GML/R001I401.pli:158, XCTL at src/GML/R001I401.pli:352, XCTL at src/GML/R001N501.pli:172, XCTL at src/GML/R001N501.pli:354, XCTL at src/GML/R001N601.pli:199, XCTL at src/GML/R001N601.pli:219, XCTL at src/GML/R001N601.pli:502, XCTL at src/GML/R001N801.pli:118, XCTL at src/GML/R001N801.pli:133, XCTL at src/GML/R001N801.pli:393, XCTL at src/GML/R001N901.pli:87, XCTL at src/GML/R001N901.pli:191, XCTL at src/GML/R001NB01.pli:92, XCTL at src/GML/R001NB01.pli:168, XCTL at src/GML/R001NC01.pli:123, XCTL at src/GML/R001NC01.pli:260, XCTL at src/GML/R001U601.pli:235, XCTL at src/GML/R001U601.pli:255, XCTL at src/GML/R001U601.pli:556, XCTL at src/GML/R001U801.pli:224, XCTL at src/GML/R001U801.pli:244, XCTL at src/GML/R001U801.pli:548, XCTL at src/GML/R001UC01.pli:118, XCTL at src/GML/R001UC01.pli:257, XCTL at src/GML/R001UE01.pli:105, XCTL at src/GML/R001UE01.pli:215, XCTL at src/GML/R001UJ01.pli:170, XCTL at src/GML/R001UJ01.pli:312. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0010401Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}