package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.Dirty02Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/dirty02")
@RequiredArgsConstructor
public class Dirty02Controller {

    private final Dirty02Service dirty02Service;

    @PostMapping(value = "/execute-batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> executeDirty02Batch(
        @RequestParam("clnoutFile") MultipartFile clnoutFile,
        @RequestParam("dirtoutFile") MultipartFile dirtoutFile
    ) {
        // ⚠️ BATCH PARADIGM DETECTED
        // Pass the InputStream directly to the Service layer.
        dirty02Service.executeDirty02(/* pass streams here */);

        // Expected Outputs: DIRTOUT
        return ResponseEntity.ok().build();
    }
}