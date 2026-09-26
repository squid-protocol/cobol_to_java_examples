package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.service.R001sp01Service;


@RestController
@RequestMapping("/api/v1/r001sp01")
@RequiredArgsConstructor
public class R001sp01Controller {

    private final R001sp01Service r001sp01Service;

    @PostMapping("/execute")
    public ResponseEntity<?> executeR001sp01(
        /* No external data dependencies detected */
    ) {
        // TRANSACTIONAL PARADIGM DETECTED
        r001sp01Service.executeR001sp01(/* pass DTOs here */);

        return ResponseEntity.noContent().build();
    }
}