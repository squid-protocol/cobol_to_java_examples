package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1craWsCommArea;
import com.gitgalaxy.modernized.service.Bnk1craService;

/**
 * CICS program BNK1CRA (src/base/cobol_src/BNK1CRA.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: WS-COMM-AREA (src/base/cobol_src/BNK1CRA.cbl, 21 bytes) -> Bnk1craWsCommArea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/bnk1cra")
@RequiredArgsConstructor
public class Bnk1craController {

    private final Bnk1craService bnk1craService;

    /** CICS transaction OCRA -> Bnk1cra (CSD etc/install/base/installjcl/BANK.csd:445 group BANK). */
    @PostMapping("/transactions/OCRA")
    public ResponseEntity<Bnk1craWsCommArea> transactionOCRA(@RequestBody Bnk1craWsCommArea request) {
        return ResponseEntity.ok(bnk1craService.handleTransaction("OCRA", request));
    }

}