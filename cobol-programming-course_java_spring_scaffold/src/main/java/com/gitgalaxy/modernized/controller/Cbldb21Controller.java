package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.Cbldb21Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/cbldb21")
@RequiredArgsConstructor
public class Cbldb21Controller {

    private final Cbldb21Service cbldb21Service;

    @PostMapping(value = "/execute-batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> executeCbldb21Batch(
        @RequestParam("reportFile") MultipartFile reportFile
    ) {
        // ⚠️ BATCH PARADIGM DETECTED
        // Pass the InputStream directly to the Service layer.
        cbldb21Service.executeCbldb21(/* pass streams here */);

        // Expected Outputs: REPORT
        return ResponseEntity.ok().build();
    }
}