package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR001tk01Service;

/**
 * CICS program R001TK01 (src/R001TK01.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: the main procedure takes no parameter, and no resolved caller passes this program a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001tk01")
@RequiredArgsConstructor
public class SrcR001tk01Controller {

    private final SrcR001tk01Service srcR001tk01Service;

    /** Program-to-program entry: no CSD transaction enters this program. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR001tk01Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}