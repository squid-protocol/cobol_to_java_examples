package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.UpdaccDfhcommarea;
import com.gitgalaxy.modernized.service.UpdaccService;

/**
 * CICS program UPDACC (src/base/cobol_src/UPDACC.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (src/base/cobol_src/UPDACC.cbl, 99 bytes) -> UpdaccDfhcommarea.
 * TODO: DFHCOMMAREA (src/base/cobol_src/BNK1UAC.cbl, 103 bytes), passed at src/base/cobol_src/BNK1UAC.cbl:954, disagrees with this program's declared DFHCOMMAREA (99 bytes: 103 vs 99 bytes; fields first differ at COMM-PCB1-POINTER / None) -- confirm which layout the program reads.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/updacc")
@RequiredArgsConstructor
public class UpdaccController {

    private final UpdaccService updaccService;

    /** Program-to-program entry: LINK at src/base/cobol_src/BNK1UAC.cbl:954. */
    @PostMapping("/link")
    public ResponseEntity<UpdaccDfhcommarea> link(@RequestBody UpdaccDfhcommarea request) {
        return ResponseEntity.ok(updaccService.handleLink(request));
    }

}