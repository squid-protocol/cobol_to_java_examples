package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Crdtagy4ChannelIn;
import com.gitgalaxy.modernized.dto.contract.Crdtagy4ChannelOut;
import com.gitgalaxy.modernized.service.Crdtagy4Service;

/**
 * CICS program CRDTAGY4 (src/base/cobol_src/CRDTAGY4.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * No COMMAREA: the program exchanges its data through its channel's containers.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/crdtagy4")
@RequiredArgsConstructor
public class Crdtagy4Controller {

    private final Crdtagy4Service crdtagy4Service;

    /** CICS transaction OCR4 -> Crdtagy4 (CSD etc/install/base/installjcl/BANK.csd:375 group BANK). */
    @PostMapping("/transactions/OCR4")
    public ResponseEntity<Crdtagy4ChannelOut> transactionOCR4(@RequestBody Crdtagy4ChannelIn request) {
        return ResponseEntity.ok(crdtagy4Service.handleTransaction("OCR4", request));
    }

}