package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.R001o301InternKomOmr;
import com.gitgalaxy.modernized.service.R001o301Service;

/**
 * CICS program R001O301 (src/GML/R001O301.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: INTERN_KOM_OMR (src/GML/R001O301.pli, 26 bytes) -> R001o301InternKomOmr.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/r001o301")
@RequiredArgsConstructor
public class R001o301Controller {

    private final R001o301Service r001o301Service;

    /** Program-to-program entry: no CSD transaction enters this program. */
    @PostMapping("/link")
    public ResponseEntity<R001o301InternKomOmr> link(@RequestBody R001o301InternKomOmr request) {
        return ResponseEntity.ok(r001o301Service.handleLink(request));
    }

}