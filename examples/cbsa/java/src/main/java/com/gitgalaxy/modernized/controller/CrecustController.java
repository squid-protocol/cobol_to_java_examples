package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1ccsSubpgmParms;
import com.gitgalaxy.modernized.service.CrecustService;

/**
 * CICS program CRECUST (src/base/cobol_src/CRECUST.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: SUBPGM-PARMS (src/base/cobol_src/BNK1CCS.cbl, 261 bytes) -> Bnk1ccsSubpgmParms.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/crecust")
@RequiredArgsConstructor
public class CrecustController {

    private final CrecustService crecustService;

    /** Program-to-program entry: LINK at src/base/cobol_src/BNK1CCS.cbl:976. */
    @PostMapping("/link")
    public ResponseEntity<Bnk1ccsSubpgmParms> link(@RequestBody Bnk1ccsSubpgmParms request) {
        return ResponseEntity.ok(crecustService.handleLink(request));
    }

}