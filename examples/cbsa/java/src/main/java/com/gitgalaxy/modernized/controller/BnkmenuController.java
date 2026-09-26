package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.BnkmenuCommunicationArea;
import com.gitgalaxy.modernized.service.BnkmenuService;

/**
 * CICS program BNKMENU (src/base/cobol_src/BNKMENU.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: COMMUNICATION-AREA (src/base/cobol_src/BNKMENU.cbl, 1 bytes) -> BnkmenuCommunicationArea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/bnkmenu")
@RequiredArgsConstructor
public class BnkmenuController {

    private final BnkmenuService bnkmenuService;

    /** CICS transaction OMEN -> Bnkmenu (CSD etc/install/base/installjcl/BANK.csd:475 group BANK). */
    @PostMapping("/transactions/OMEN")
    public ResponseEntity<BnkmenuCommunicationArea> transactionOMEN(@RequestBody BnkmenuCommunicationArea request) {
        return ResponseEntity.ok(bnkmenuService.handleTransaction("OMEN", request));
    }

}