package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.R001te02Commarea;
import com.gitgalaxy.modernized.service.R001te02Service;

/**
 * CICS program R001TE02 (src/GML/R001TE02.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: COMMAREA (src/GML/R001TE02.pli, 6 bytes) -> R001te02Commarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/r001te02")
@RequiredArgsConstructor
public class R001te02Controller {

    private final R001te02Service r001te02Service;

    /** Program-to-program entry: no CSD transaction enters this program. */
    @PostMapping("/link")
    public ResponseEntity<R001te02Commarea> link(@RequestBody R001te02Commarea request) {
        return ResponseEntity.ok(r001te02Service.handleLink(request));
    }

}