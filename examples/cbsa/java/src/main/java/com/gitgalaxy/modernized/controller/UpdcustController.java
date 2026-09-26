package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1dcsUpdcustCommarea;
import com.gitgalaxy.modernized.service.UpdcustService;

/**
 * CICS program UPDCUST (src/base/cobol_src/UPDCUST.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: UPDCUST-COMMAREA (src/base/cobol_src/BNK1DCS.cbl, 261 bytes) -> Bnk1dcsUpdcustCommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/updcust")
@RequiredArgsConstructor
public class UpdcustController {

    private final UpdcustService updcustService;

    /** Program-to-program entry: LINK at src/base/cobol_src/BNK1DCS.cbl:1155. */
    @PostMapping("/link")
    public ResponseEntity<Bnk1dcsUpdcustCommarea> link(@RequestBody Bnk1dcsUpdcustCommarea request) {
        return ResponseEntity.ok(updcustService.handleLink(request));
    }

}