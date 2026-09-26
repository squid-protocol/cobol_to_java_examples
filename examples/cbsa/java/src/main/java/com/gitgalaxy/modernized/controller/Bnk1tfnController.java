package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1tfnWsCommarea;
import com.gitgalaxy.modernized.service.Bnk1tfnService;

/**
 * CICS program BNK1TFN (src/base/cobol_src/BNK1TFN.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: WS-COMMAREA (src/base/cobol_src/BNK1TFN.cbl, 28 bytes) -> Bnk1tfnWsCommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/bnk1tfn")
@RequiredArgsConstructor
public class Bnk1tfnController {

    private final Bnk1tfnService bnk1tfnService;

    /** CICS transaction OTFN -> Bnk1tfn (CSD etc/install/base/installjcl/BANK.csd:485 group BANK). */
    @PostMapping("/transactions/OTFN")
    public ResponseEntity<Bnk1tfnWsCommarea> transactionOTFN(@RequestBody Bnk1tfnWsCommarea request) {
        return ResponseEntity.ok(bnk1tfnService.handleTransaction("OTFN", request));
    }

}