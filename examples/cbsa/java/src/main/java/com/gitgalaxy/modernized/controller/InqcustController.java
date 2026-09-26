package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.Bnk1dcsInqcustCommarea;
import com.gitgalaxy.modernized.service.InqcustService;

/**
 * CICS program INQCUST (src/base/cobol_src/INQCUST.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: INQCUST-COMMAREA (src/base/cobol_src/BNK1DCS.cbl, 265 bytes) -> Bnk1dcsInqcustCommarea.
 * TODO: callers also pass INQCUST-COMMAREA (src/base/cobol_src/CREACC.cbl, 265 bytes) at src/base/cobol_src/CREACC.cbl:304.
 * TODO: callers also pass INQCUST-COMMAREA (src/base/cobol_src/DELCUS.cbl, 265 bytes) at src/base/cobol_src/DELCUS.cbl:260.
 * TODO: callers also pass INQCUST-COMMAREA (src/base/cobol_src/INQACCCU.cbl, 265 bytes) at src/base/cobol_src/INQACCCU.cbl:851.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/inqcust")
@RequiredArgsConstructor
public class InqcustController {

    private final InqcustService inqcustService;

    /** Program-to-program entry: LINK at src/base/cobol_src/BNK1DCS.cbl:833, LINK at src/base/cobol_src/CREACC.cbl:304, LINK at src/base/cobol_src/DELCUS.cbl:260, LINK at src/base/cobol_src/INQACCCU.cbl:851. */
    @PostMapping("/link")
    public ResponseEntity<Bnk1dcsInqcustCommarea> link(@RequestBody Bnk1dcsInqcustCommarea request) {
        return ResponseEntity.ok(inqcustService.handleLink(request));
    }

}