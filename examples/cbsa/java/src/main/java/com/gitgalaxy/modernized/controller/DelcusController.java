package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1dcsDelcusCommarea;
import com.gitgalaxy.modernized.service.DelcusService;

/**
 * CICS program DELCUS (src/base/cobol_src/DELCUS.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DELCUS-COMMAREA (src/base/cobol_src/BNK1DCS.cbl, 261 bytes) -> Bnk1dcsDelcusCommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/delcus")
@RequiredArgsConstructor
public class DelcusController {

    private final DelcusService delcusService;

    /** Program-to-program entry: LINK at src/base/cobol_src/BNK1DCS.cbl:969. */
    @PostMapping("/link")
    public ResponseEntity<Bnk1dcsDelcusCommarea> link(@RequestBody Bnk1dcsDelcusCommarea request) {
        return ResponseEntity.ok(delcusService.handleLink(request));
    }

}