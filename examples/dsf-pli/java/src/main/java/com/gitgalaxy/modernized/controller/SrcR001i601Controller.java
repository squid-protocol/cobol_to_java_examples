package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.SrcR001i501KomOmr;
import com.gitgalaxy.modernized.service.SrcR001i601Service;

/**
 * CICS program R001I601 (src/R001I601.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: KOM_OMR (src/R001I501.pli, 67 bytes) -> SrcR001i501KomOmr.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001i601")
@RequiredArgsConstructor
public class SrcR001i601Controller {

    private final SrcR001i601Service srcR001i601Service;

    /** Program-to-program entry: LINK at src/R001I201.pli:418, LINK at src/R001I201.pli:440, LINK at src/R001I301.pli:388, LINK at src/R001I501.pli:364. */
    @PostMapping("/link")
    public ResponseEntity<SrcR001i501KomOmr> link(@RequestBody SrcR001i501KomOmr request) {
        return ResponseEntity.ok(srcR001i601Service.handleLink(request));
    }

}