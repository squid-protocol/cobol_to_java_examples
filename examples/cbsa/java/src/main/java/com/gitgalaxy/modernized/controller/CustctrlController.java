package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CustctrlDfhcommarea;
import com.gitgalaxy.modernized.service.CustctrlService;

/**
 * CICS program CUSTCTRL (src/base/cobol_src/CUSTCTRL.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (src/base/cobol_src/CUSTCTRL.cbl, 259 bytes) -> CustctrlDfhcommarea.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/custctrl")
@RequiredArgsConstructor
public class CustctrlController {

    private final CustctrlService custctrlService;

    /** Program-to-program entry: no CSD transaction enters this program. */
    @PostMapping("/link")
    public ResponseEntity<CustctrlDfhcommarea> link(@RequestBody CustctrlDfhcommarea request) {
        return ResponseEntity.ok(custctrlService.handleLink(request));
    }

}