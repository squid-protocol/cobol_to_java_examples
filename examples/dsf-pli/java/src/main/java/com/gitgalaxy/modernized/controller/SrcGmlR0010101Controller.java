package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcGmlR0010101Service;

/**
 * CICS program R0010101 (src/GML/R0010101.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: the main procedure takes no parameter, and no resolved caller passes this program a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0010101")
@RequiredArgsConstructor
public class SrcGmlR0010101Controller {

    private final SrcGmlR0010101Service srcGmlR0010101Service;

    /** Program-to-program entry: no CSD transaction enters this program. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcGmlR0010101Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}