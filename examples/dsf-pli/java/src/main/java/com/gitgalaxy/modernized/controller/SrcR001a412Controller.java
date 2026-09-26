package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR001a412Service;

/**
 * CICS program R001A412 (src/R001A412.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter LOKAL_KOM_PTR, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, P0019913, S001F1; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001a412")
@RequiredArgsConstructor
public class SrcR001a412Controller {

    private final SrcR001a412Service srcR001a412Service;

    /** Program-to-program entry: LINK at src/R0010412.pli:200. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR001a412Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}