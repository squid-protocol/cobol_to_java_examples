package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1dacWsCommArea;
import com.gitgalaxy.modernized.service.Bnk1dacService;

/**
 * CICS program BNK1DAC (src/base/cobol_src/BNK1DAC.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: WS-COMM-AREA (src/base/cobol_src/BNK1DAC.cbl, 102 bytes) -> Bnk1dacWsCommArea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/bnk1dac")
@RequiredArgsConstructor
public class Bnk1dacController {

    private final Bnk1dacService bnk1dacService;

    /** CICS transaction ODAC -> Bnk1dac (CSD etc/install/base/installjcl/BANK.csd:455 group BANK). */
    @PostMapping("/transactions/ODAC")
    public ResponseEntity<Bnk1dacWsCommArea> transactionODAC(@RequestBody Bnk1dacWsCommArea request) {
        return ResponseEntity.ok(bnk1dacService.handleTransaction("ODAC", request));
    }

}