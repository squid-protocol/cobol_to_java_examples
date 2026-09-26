package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CocrdslcCommarea;
import com.gitgalaxy.modernized.service.CocrdslcService;

/**
 * CICS program COCRDSLC (app/cbl/COCRDSLC.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/cbl/COCRDSLC.cbl, 172 bytes) -> CocrdslcCommarea.
 * TODO: callers also pass WS-COMMAREA (app/cbl/COCRDSLC.cbl, 2000 bytes) at app/cbl/COCRDSLC.cbl:402.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/cocrdslc")
@RequiredArgsConstructor
public class CocrdslcController {

    private final CocrdslcService cocrdslcService;

    /** CICS transaction CCDL -> Cocrdslc (CSD app/csd/CARDDEMO.CSD:219 group CARDDEMO; app/csd/CARDDEMO.CSD:347 group CARDDEMO). */
    @PostMapping("/transactions/CCDL")
    public ResponseEntity<CocrdslcCommarea> transactionCCDL(@RequestBody CocrdslcCommarea request) {
        return ResponseEntity.ok(cocrdslcService.handleTransaction("CCDL", request));
    }

    /** Program-to-program entry: XCTL at app/cbl/COCRDLIC.cbl:538 (data-driven, moves), XCTL at app/cbl/COCRDLIC.cbl:566 (data-driven, moves), XCTL at app/cbl/COMEN01C.cbl:156 (data-driven, table), XCTL at app/cbl/COMEN01C.cbl:184 (data-driven, table). */
    @PostMapping("/link")
    public ResponseEntity<CocrdslcCommarea> link(@RequestBody CocrdslcCommarea request) {
        return ResponseEntity.ok(cocrdslcService.handleLink(request));
    }

}