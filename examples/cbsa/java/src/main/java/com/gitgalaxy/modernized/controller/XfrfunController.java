package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1tfnSubpgmParms;
import com.gitgalaxy.modernized.service.XfrfunService;

/**
 * CICS program XFRFUN (src/base/cobol_src/XFRFUN.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: SUBPGM-PARMS (src/base/cobol_src/BNK1TFN.cbl, 90 bytes) -> Bnk1tfnSubpgmParms.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/xfrfun")
@RequiredArgsConstructor
public class XfrfunController {

    private final XfrfunService xfrfunService;

    /** Program-to-program entry: LINK at src/base/cobol_src/BNK1TFN.cbl:496. */
    @PostMapping("/link")
    public ResponseEntity<Bnk1tfnSubpgmParms> link(@RequestBody Bnk1tfnSubpgmParms request) {
        return ResponseEntity.ok(xfrfunService.handleLink(request));
    }

}