package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Crdtagy5ChannelIn;
import com.gitgalaxy.modernized.dto.contract.Crdtagy5ChannelOut;
import com.gitgalaxy.modernized.service.Crdtagy5Service;

/**
 * CICS program CRDTAGY5 (src/base/cobol_src/CRDTAGY5.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * No COMMAREA: the program exchanges its data through its channel's containers.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/crdtagy5")
@RequiredArgsConstructor
public class Crdtagy5Controller {

    private final Crdtagy5Service crdtagy5Service;

    /** CICS transaction OCR5 -> Crdtagy5 (CSD etc/install/base/installjcl/BANK.csd:385 group BANK). */
    @PostMapping("/transactions/OCR5")
    public ResponseEntity<Crdtagy5ChannelOut> transactionOCR5(@RequestBody Crdtagy5ChannelIn request) {
        return ResponseEntity.ok(crdtagy5Service.handleTransaction("OCR5", request));
    }

}