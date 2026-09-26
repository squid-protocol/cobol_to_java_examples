package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.PaudbunlService;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/paudbunl")
@RequiredArgsConstructor
public class PaudbunlController {

    private final PaudbunlService paudbunlService;

    @PostMapping(value = "/execute-batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> executePaudbunlBatch(
        @RequestParam("outfil1File") MultipartFile outfil1File,
        @RequestParam("outfil2File") MultipartFile outfil2File
    ) {
        // BATCH PARADIGM DETECTED
        // Pass the InputStream directly to the Service layer.
        paudbunlService.executePaudbunl(/* pass streams here */);

        // Expected Outputs: OUTFIL1, OUTFIL2
        return ResponseEntity.ok().build();
    }
}