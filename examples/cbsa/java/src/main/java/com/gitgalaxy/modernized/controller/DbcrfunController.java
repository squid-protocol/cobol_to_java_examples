package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1craSubpgmParms;
import com.gitgalaxy.modernized.service.DbcrfunService;

/**
 * CICS program DBCRFUN (src/base/cobol_src/DBCRFUN.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: SUBPGM-PARMS (src/base/cobol_src/BNK1CRA.cbl, 92 bytes) -> Bnk1craSubpgmParms.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/dbcrfun")
@RequiredArgsConstructor
public class DbcrfunController {

    private final DbcrfunService dbcrfunService;

    /** Program-to-program entry: LINK at src/base/cobol_src/BNK1CRA.cbl:511. */
    @PostMapping("/link")
    public ResponseEntity<Bnk1craSubpgmParms> link(@RequestBody Bnk1craSubpgmParms request) {
        return ResponseEntity.ok(dbcrfunService.handleLink(request));
    }

}