package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.GetscodeDfhcommarea;
import com.gitgalaxy.modernized.service.GetscodeService;

/**
 * CICS program GETSCODE (src/base/cobol_src/GETSCODE.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (src/base/cobol_src/GETSCODE.cbl, 6 bytes) -> GetscodeDfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/getscode")
@RequiredArgsConstructor
public class GetscodeController {

    private final GetscodeService getscodeService;

    /** Program-to-program entry: LINK at src/webui/src/main/java/com/ibm/cics/cip/bankliberty/api/json/SortCodeResource.java:68. */
    @PostMapping("/link")
    public ResponseEntity<GetscodeDfhcommarea> link(@RequestBody GetscodeDfhcommarea request) {
        return ResponseEntity.ok(getscodeService.handleLink(request));
    }

}