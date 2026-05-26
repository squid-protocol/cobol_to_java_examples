package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.Cbl0106Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/cbl0106")
@RequiredArgsConstructor
public class Cbl0106Controller {

    private final Cbl0106Service cbl0106Service;

    @PostMapping(value = "/execute-batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> executeCbl0106Batch(
        @RequestParam("prtlineFile") MultipartFile prtlineFile,
        @RequestParam("acctrecFile") MultipartFile acctrecFile
    ) {
        // ⚠️ BATCH PARADIGM DETECTED
        // Pass the InputStream directly to the Service layer.
        cbl0106Service.executeCbl0106(/* pass streams here */);

        // Expected Outputs: PRTLINE
        return ResponseEntity.ok().build();
    }
}