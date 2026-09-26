package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.R001te01Commarea;
import com.gitgalaxy.modernized.service.R001te01Service;

/**
 * CICS program R001TE01 (src/GML/R001TE01.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: COMMAREA (src/GML/R001TE01.pli, 6 bytes) -> R001te01Commarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/r001te01")
@RequiredArgsConstructor
public class R001te01Controller {

    private final R001te01Service r001te01Service;

    /** Program-to-program entry: no CSD transaction enters this program. */
    @PostMapping("/link")
    public ResponseEntity<R001te01Commarea> link(@RequestBody R001te01Commarea request) {
        return ResponseEntity.ok(r001te01Service.handleLink(request));
    }

}