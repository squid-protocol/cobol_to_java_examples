package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.Clean01Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/clean01")
@RequiredArgsConstructor
public class Clean01Controller {

    private final Clean01Service clean01Service;

    @PostMapping(value = "/execute-batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> executeClean01Batch(
        @RequestParam("clnoutFile") MultipartFile clnoutFile
    ) {
        // ⚠️ BATCH PARADIGM DETECTED
        // Pass the InputStream directly to the Service layer.
        clean01Service.executeClean01(/* pass streams here */);

        // Expected Outputs: CLNOUT
        return ResponseEntity.ok().build();
    }
}