package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR0010401Service;

/**
 * CICS program R0010401 (src/R0010401.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019999, S00101; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0010401")
@RequiredArgsConstructor
public class SrcR0010401Controller {

    private final SrcR0010401Service srcR0010401Service;

    /** Program-to-program entry: XCTL at src/R0010501.pli:186, XCTL at src/R0010501.pli:389, XCTL at src/R0010601.pli:208, XCTL at src/R0010601.pli:228, XCTL at src/R0010601.pli:520, XCTL at src/R0010801.pli:136, XCTL at src/R0010801.pli:151, XCTL at src/R0010801.pli:410, XCTL at src/R0011001.pli:127, XCTL at src/R0011001.pli:145, XCTL at src/R0011001.pli:329, XCTL at src/R0011001.pli:378, XCTL at src/R0011101.pli:90, XCTL at src/R0011101.pli:166, XCTL at src/R0011201.pli:94, XCTL at src/R0011201.pli:200, XCTL at src/R0011301.pli:142, XCTL at src/R0011301.pli:161, XCTL at src/R0011301.pli:180, XCTL at src/R0011301.pli:201, XCTL at src/R0011301.pli:363, XCTL at src/R0011301.pli:396, XCTL at src/R0011301.pli:437, XCTL at src/R0011301.pli:442, XCTL at src/R0011304.pli:156, XCTL at src/R0011304.pli:182, XCTL at src/R0011401.pli:91, XCTL at src/R0011401.pli:191, XCTL at src/R0011601.pli:93, XCTL at src/R0011601.pli:161, XCTL at src/R0011701.pli:93, XCTL at src/R0011701.pli:162, XCTL at src/R0011831.pli:149, XCTL at src/R0011831.pli:311, XCTL at src/R0011901.pli:175, XCTL at src/R0011901.pli:316, XCTL at src/R0012001.pli:368, XCTL at src/R0012101.pli:223, XCTL at src/R0013520.pli:470, XCTL at src/R001B001.pli:1475, XCTL at src/R001N501.pli:174, XCTL at src/R001N501.pli:356, XCTL at src/R001N601.pli:208, XCTL at src/R001N601.pli:228, XCTL at src/R001N601.pli:524, XCTL at src/R001N801.pli:134, XCTL at src/R001N801.pli:149, XCTL at src/R001N801.pli:407, XCTL at src/R001N901.pli:82, XCTL at src/R001N901.pli:186, XCTL at src/R001NB01.pli:91, XCTL at src/R001NB01.pli:167, XCTL at src/R001NC01.pli:121, XCTL at src/R001NC01.pli:258, XCTL at src/R001U601.pli:263, XCTL at src/R001U601.pli:306, XCTL at src/R001U601.pli:688, XCTL at src/R001U801.pli:246, XCTL at src/R001U801.pli:730, XCTL at src/R001UC01.pli:123, XCTL at src/R001UC01.pli:262, XCTL at src/R001UE01.pli:112, XCTL at src/R001UE01.pli:222, XCTL at src/R001UJ01.pli:173, XCTL at src/R001UJ01.pli:260. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR0010401Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}