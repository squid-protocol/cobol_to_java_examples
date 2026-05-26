package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.Cbldb22Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/cbldb22")
@RequiredArgsConstructor
public class Cbldb22Controller {

    private final Cbldb22Service cbldb22Service;

    @PostMapping(value = "/execute-batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> executeCbldb22Batch(
        @RequestParam("reportFile") MultipartFile reportFile,
        @RequestParam("da-s-recinFile") MultipartFile daSRecinFile
    ) {
        // ⚠️ BATCH PARADIGM DETECTED
        // Pass the InputStream directly to the Service layer.
        cbldb22Service.executeCbldb22(/* pass streams here */);

        // Expected Outputs: REPORT
        return ResponseEntity.ok().build();
    }
}