package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.Dirty03Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/dirty03")
@RequiredArgsConstructor
public class Dirty03Controller {

    private final Dirty03Service dirty03Service;

    @PostMapping(value = "/execute-batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> executeDirty03Batch(
        @RequestParam("dirtoutFile") MultipartFile dirtoutFile
    ) {
        // ⚠️ BATCH PARADIGM DETECTED
        // Pass the InputStream directly to the Service layer.
        dirty03Service.executeDirty03(/* pass streams here */);

        return ResponseEntity.noContent().build();
    }
}