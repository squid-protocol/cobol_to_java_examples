package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.Cbstm03bService;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/cbstm03b")
@RequiredArgsConstructor
public class Cbstm03bController {

    private final Cbstm03bService cbstm03bService;

    @PostMapping(value = "/execute-batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> executeCbstm03bBatch(
        @RequestParam("trnxfileFile") MultipartFile trnxfileFile,
        @RequestParam("xreffileFile") MultipartFile xreffileFile,
        @RequestParam("custfileFile") MultipartFile custfileFile,
        @RequestParam("acctfileFile") MultipartFile acctfileFile
    ) {
        // BATCH PARADIGM DETECTED
        // Pass the InputStream directly to the Service layer.
        cbstm03bService.executeCbstm03b(/* pass streams here */);

        return ResponseEntity.noContent().build();
    }
}