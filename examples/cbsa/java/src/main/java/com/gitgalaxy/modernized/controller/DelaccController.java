package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1dacParmsSubpgm;
import com.gitgalaxy.modernized.service.DelaccService;

/**
 * CICS program DELACC (src/base/cobol_src/DELACC.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: PARMS-SUBPGM (src/base/cobol_src/BNK1DAC.cbl, 122 bytes) -> Bnk1dacParmsSubpgm.
 * TODO: callers also pass DELACC-COMMAREA (src/base/cobol_src/DELCUS.cbl, 118 bytes) at src/base/cobol_src/DELCUS.cbl:312.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/delacc")
@RequiredArgsConstructor
public class DelaccController {

    private final DelaccService delaccService;

    /** Program-to-program entry: LINK at src/base/cobol_src/BNK1DAC.cbl:712, LINK at src/base/cobol_src/DELCUS.cbl:312. */
    @PostMapping("/link")
    public ResponseEntity<Bnk1dacParmsSubpgm> link(@RequestBody Bnk1dacParmsSubpgm request) {
        return ResponseEntity.ok(delaccService.handleLink(request));
    }

}