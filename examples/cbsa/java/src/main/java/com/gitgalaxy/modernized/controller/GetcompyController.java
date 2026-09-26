package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.GetcompyDfhcommarea;
import com.gitgalaxy.modernized.service.GetcompyService;

/**
 * CICS program GETCOMPY (src/base/cobol_src/GETCOMPY.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (src/base/cobol_src/GETCOMPY.cbl, 40 bytes) -> GetcompyDfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/getcompy")
@RequiredArgsConstructor
public class GetcompyController {

    private final GetcompyService getcompyService;

    /** Program-to-program entry: LINK at src/webui/src/main/java/com/ibm/cics/cip/bankliberty/api/json/CompanyNameResource.java:78. */
    @PostMapping("/link")
    public ResponseEntity<GetcompyDfhcommarea> link(@RequestBody GetcompyDfhcommarea request) {
        return ResponseEntity.ok(getcompyService.handleLink(request));
    }

}