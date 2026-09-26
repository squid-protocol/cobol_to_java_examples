package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.PaudblodService;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/paudblod")
@RequiredArgsConstructor
public class PaudblodController {

    private final PaudblodService paudblodService;

    @PostMapping(value = "/execute-batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> executePaudblodBatch(
        @RequestParam("infile1File") MultipartFile infile1File,
        @RequestParam("infile2File") MultipartFile infile2File
    ) {
        // BATCH PARADIGM DETECTED
        // Pass the InputStream directly to the Service layer.
        paudblodService.executePaudblod(/* pass streams here */);

        return ResponseEntity.noContent().build();
    }
}