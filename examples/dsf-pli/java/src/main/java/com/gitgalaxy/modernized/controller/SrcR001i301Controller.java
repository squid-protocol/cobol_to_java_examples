package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.SrcR001i101InternKomOmr;
import com.gitgalaxy.modernized.service.SrcR001i301Service;

/**
 * CICS program R001I301 (src/R001I301.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: INTERN_KOM_OMR (src/R001I101.pli, 26 bytes) -> SrcR001i101InternKomOmr.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001i301")
@RequiredArgsConstructor
public class SrcR001i301Controller {

    private final SrcR001i301Service srcR001i301Service;

    /** Program-to-program entry: LINK at src/R001I101.pli:306. */
    @PostMapping("/link")
    public ResponseEntity<SrcR001i101InternKomOmr> link(@RequestBody SrcR001i101InternKomOmr request) {
        return ResponseEntity.ok(srcR001i301Service.handleLink(request));
    }

}