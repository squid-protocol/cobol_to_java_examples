package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.Cbldb23Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/cbldb23")
@RequiredArgsConstructor
public class Cbldb23Controller {

    private final Cbldb23Service cbldb23Service;

    @PostMapping(value = "/execute-batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> executeCbldb23Batch(
        @RequestParam("reportFile") MultipartFile reportFile,
        @RequestParam("da-s-cardinFile") MultipartFile daSCardinFile
    ) {
        // ⚠️ BATCH PARADIGM DETECTED
        // Pass the InputStream directly to the Service layer.
        cbldb23Service.executeCbldb23(/* pass streams here */);

        // Expected Outputs: REPORT
        return ResponseEntity.ok().build();
    }
}