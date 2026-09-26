package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CoactvwcCommarea;
import com.gitgalaxy.modernized.service.CoactvwcService;

/**
 * CICS program COACTVWC (app/cbl/COACTVWC.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/cbl/COACTVWC.cbl, 172 bytes) -> CoactvwcCommarea.
 * TODO: callers also pass WS-COMMAREA (app/cbl/COACTVWC.cbl, 2000 bytes) at app/cbl/COACTVWC.cbl:402.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/coactvwc")
@RequiredArgsConstructor
public class CoactvwcController {

    private final CoactvwcService coactvwcService;

    /** CICS transaction CAVW -> Coactvwc (CSD app/csd/CARDDEMO.CSD:181 group CARDDEMO; app/csd/CARDDEMO.CSD:317 group CARDDEMO). */
    @PostMapping("/transactions/CAVW")
    public ResponseEntity<CoactvwcCommarea> transactionCAVW(@RequestBody CoactvwcCommarea request) {
        return ResponseEntity.ok(coactvwcService.handleTransaction("CAVW", request));
    }

    /** Program-to-program entry: XCTL at app/cbl/COMEN01C.cbl:156 (data-driven, table), XCTL at app/cbl/COMEN01C.cbl:184 (data-driven, table). */
    @PostMapping("/link")
    public ResponseEntity<CoactvwcCommarea> link(@RequestBody CoactvwcCommarea request) {
        return ResponseEntity.ok(coactvwcService.handleLink(request));
    }

}