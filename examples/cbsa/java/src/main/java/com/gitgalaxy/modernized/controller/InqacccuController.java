package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1ccaInqacccuCommarea;
import com.gitgalaxy.modernized.service.InqacccuService;

/**
 * CICS program INQACCCU (src/base/cobol_src/INQACCCU.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: INQACCCU-COMMAREA (src/base/cobol_src/BNK1CCA.cbl, 1981 bytes) -> Bnk1ccaInqacccuCommarea.
 * TODO: callers also pass INQACCCU-COMMAREA (src/base/cobol_src/CREACC.cbl, 1981 bytes) at src/base/cobol_src/CREACC.cbl:1088.
 * TODO: callers also pass INQACCCU-COMMAREA (src/base/cobol_src/DELCUS.cbl, 1981 bytes) at src/base/cobol_src/DELCUS.cbl:334.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/inqacccu")
@RequiredArgsConstructor
public class InqacccuController {

    private final InqacccuService inqacccuService;

    /** Program-to-program entry: LINK at src/base/cobol_src/BNK1CCA.cbl:435, LINK at src/base/cobol_src/CREACC.cbl:1088, LINK at src/base/cobol_src/DELCUS.cbl:334. */
    @PostMapping("/link")
    public ResponseEntity<Bnk1ccaInqacccuCommarea> link(@RequestBody Bnk1ccaInqacccuCommarea request) {
        return ResponseEntity.ok(inqacccuService.handleLink(request));
    }

}