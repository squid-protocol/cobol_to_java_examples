package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1cacSubpgmParms;
import com.gitgalaxy.modernized.service.CreaccService;

/**
 * CICS program CREACC (src/base/cobol_src/CREACC.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: SUBPGM-PARMS (src/base/cobol_src/BNK1CAC.cbl, 100 bytes) -> Bnk1cacSubpgmParms.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/creacc")
@RequiredArgsConstructor
public class CreaccController {

    private final CreaccService creaccService;

    /** Program-to-program entry: LINK at src/base/cobol_src/BNK1CAC.cbl:775. */
    @PostMapping("/link")
    public ResponseEntity<Bnk1cacSubpgmParms> link(@RequestBody Bnk1cacSubpgmParms request) {
        return ResponseEntity.ok(creaccService.handleLink(request));
    }

}