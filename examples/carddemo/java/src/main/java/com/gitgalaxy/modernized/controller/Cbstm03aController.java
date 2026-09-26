package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.Cbstm03aService;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/cbstm03a")
@RequiredArgsConstructor
public class Cbstm03aController {

    private final Cbstm03aService cbstm03aService;

    @PostMapping(value = "/execute-batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> executeCbstm03aBatch(
        @RequestParam("stmtfileFile") MultipartFile stmtfileFile,
        @RequestParam("htmlfileFile") MultipartFile htmlfileFile
    ) {
        // BATCH PARADIGM DETECTED
        // Pass the InputStream directly to the Service layer.
        cbstm03aService.executeCbstm03a(/* pass streams here */);

        // Expected Outputs: HTMLFILE, STMTFILE
        return ResponseEntity.ok().build();
    }
}