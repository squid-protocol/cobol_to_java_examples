package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.InqaccCommarea;
import com.gitgalaxy.modernized.service.InqaccService;

/**
 * CICS program INQACC (src/base/cobol_src/INQACC.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: INQACC-COMMAREA (src/base/cobol_copy/INQACC.cpy, 103 bytes) -> InqaccCommarea.
 * TODO: callers also pass DFHCOMMAREA (src/base/cobol_src/BNK1UAC.cbl, 103 bytes) at src/base/cobol_src/BNK1UAC.cbl:767.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/inqacc")
@RequiredArgsConstructor
public class InqaccController {

    private final InqaccService inqaccService;

    /** Program-to-program entry: LINK at src/base/cobol_src/BNK1DAC.cbl:553, LINK at src/base/cobol_src/BNK1UAC.cbl:767. */
    @PostMapping("/link")
    public ResponseEntity<InqaccCommarea> link(@RequestBody InqaccCommarea request) {
        return ResponseEntity.ok(inqaccService.handleLink(request));
    }

}