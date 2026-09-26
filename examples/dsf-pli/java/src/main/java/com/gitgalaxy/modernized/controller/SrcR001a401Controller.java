package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.SrcR001a401Service;

/**
 * CICS program R001A401 (src/R001A401.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * TODO: no COMMAREA layout: no structure parameter, or structure BASED on the main procedure's parameter COMMAREA_PEKER, is declared in the program or its %INCLUDE members; %INCLUDE members not in the repository: P0019906, P0019908, P0019910, P0019912, S00101, S00105, S00106, S00107, S00108, S00109, S00110, S00111, S00112, S00113, S00114, S00116, S00117, S00118, S00119, S00121, S00183, S001B0, S001I4; no resolved caller passes a COMMAREA.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r001a401")
@RequiredArgsConstructor
public class SrcR001a401Controller {

    private final SrcR001a401Service srcR001a401Service;

    /** Program-to-program entry: XCTL at src/R0010401.pli:170. */
    @PostMapping("/link")
    public ResponseEntity<Void> link() {
        srcR001a401Service.handleLink();
        return ResponseEntity.noContent().build();
    }

}