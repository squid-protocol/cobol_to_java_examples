package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CocrdlicCommarea;
import com.gitgalaxy.modernized.service.CocrdlicService;

/**
 * CICS program COCRDLIC (app/cbl/COCRDLIC.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/cbl/COCRDLIC.cbl, 414 bytes) -> CocrdlicCommarea.
 * TODO: callers also pass WS-COMMAREA (app/cbl/COCRDLIC.cbl, 2000 bytes) at app/cbl/COCRDLIC.cbl:615.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/cocrdlic")
@RequiredArgsConstructor
public class CocrdlicController {

    private final CocrdlicService cocrdlicService;

    /** CICS transaction CC00 -> Cocrdlic (CSD app/csd/CARDDEMO.CSD:203 group CARDDEMO). */
    @PostMapping("/transactions/CC00")
    public ResponseEntity<CocrdlicCommarea> transactionCC00(@RequestBody CocrdlicCommarea request) {
        return ResponseEntity.ok(cocrdlicService.handleTransaction("CC00", request));
    }

    /** CICS transaction CCLI -> Cocrdlic (CSD app/csd/CARDDEMO.CSD:357 group CARDDEMO). */
    @PostMapping("/transactions/CCLI")
    public ResponseEntity<CocrdlicCommarea> transactionCCLI(@RequestBody CocrdlicCommarea request) {
        return ResponseEntity.ok(cocrdlicService.handleTransaction("CCLI", request));
    }

    /** Program-to-program entry: XCTL at app/cbl/COCRDLIC.cbl:538 (data-driven, moves), XCTL at app/cbl/COCRDLIC.cbl:566 (data-driven, moves), XCTL at app/cbl/COMEN01C.cbl:156 (data-driven, table), XCTL at app/cbl/COMEN01C.cbl:184 (data-driven, table). */
    @PostMapping("/link")
    public ResponseEntity<CocrdlicCommarea> link(@RequestBody CocrdlicCommarea request) {
        return ResponseEntity.ok(cocrdlicService.handleLink(request));
    }

}