package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.SrcGmlR001i101InternKomOmr;
import com.gitgalaxy.modernized.service.SrcGmlR001i201Service;

/**
 * CICS program R001I201 (src/GML/R001I201.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: INTERN_KOM_OMR (src/GML/R001I101.pli, 26 bytes) -> SrcGmlR001i101InternKomOmr.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r001i201")
@RequiredArgsConstructor
public class SrcGmlR001i201Controller {

    private final SrcGmlR001i201Service srcGmlR001i201Service;

    /** Program-to-program entry: LINK at src/GML/R001I101.pli:293. */
    @PostMapping("/link")
    public ResponseEntity<SrcGmlR001i101InternKomOmr> link(@RequestBody SrcGmlR001i101InternKomOmr request) {
        return ResponseEntity.ok(srcGmlR001i201Service.handleLink(request));
    }

}