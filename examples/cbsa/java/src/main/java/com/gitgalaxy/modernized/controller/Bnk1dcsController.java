package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1dcsWsCommArea;
import com.gitgalaxy.modernized.service.Bnk1dcsService;

/**
 * CICS program BNK1DCS (src/base/cobol_src/BNK1DCS.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: WS-COMM-AREA (src/base/cobol_src/BNK1DCS.cbl, 266 bytes) -> Bnk1dcsWsCommArea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/bnk1dcs")
@RequiredArgsConstructor
public class Bnk1dcsController {

    private final Bnk1dcsService bnk1dcsService;

    /** CICS transaction ODCS -> Bnk1dcs (CSD etc/install/base/installjcl/BANK.csd:465 group BANK). */
    @PostMapping("/transactions/ODCS")
    public ResponseEntity<Bnk1dcsWsCommArea> transactionODCS(@RequestBody Bnk1dcsWsCommArea request) {
        return ResponseEntity.ok(bnk1dcsService.handleTransaction("ODCS", request));
    }

}