package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Crdtagy3ChannelIn;
import com.gitgalaxy.modernized.dto.contract.Crdtagy3ChannelOut;
import com.gitgalaxy.modernized.service.Crdtagy3Service;

/**
 * CICS program CRDTAGY3 (src/base/cobol_src/CRDTAGY3.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * No COMMAREA: the program exchanges its data through its channel's containers.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/crdtagy3")
@RequiredArgsConstructor
public class Crdtagy3Controller {

    private final Crdtagy3Service crdtagy3Service;

    /** CICS transaction OCR3 -> Crdtagy3 (CSD etc/install/base/installjcl/BANK.csd:365 group BANK). */
    @PostMapping("/transactions/OCR3")
    public ResponseEntity<Crdtagy3ChannelOut> transactionOCR3(@RequestBody Crdtagy3ChannelIn request) {
        return ResponseEntity.ok(crdtagy3Service.handleTransaction("OCR3", request));
    }

}