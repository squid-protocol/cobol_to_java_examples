package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.CoactupcCommarea;
import com.gitgalaxy.modernized.service.CoactupcService;

/**
 * CICS program COACTUPC (app/cbl/COACTUPC.cbl), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: DFHCOMMAREA (app/cbl/COACTUPC.cbl, 1033 bytes) -> CoactupcCommarea.
 * TODO: callers also pass WS-COMMAREA (app/cbl/COACTUPC.cbl, 2000 bytes) at app/cbl/COACTUPC.cbl:1015.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/coactupc")
@RequiredArgsConstructor
public class CoactupcController {

    private final CoactupcService coactupcService;

    /** CICS transaction CAUP -> Coactupc (CSD app/csd/CARDDEMO.CSD:306 group CARDDEMO). */
    @PostMapping("/transactions/CAUP")
    public ResponseEntity<CoactupcCommarea> transactionCAUP(@RequestBody CoactupcCommarea request) {
        return ResponseEntity.ok(coactupcService.handleTransaction("CAUP", request));
    }

    /** Program-to-program entry: XCTL at app/cbl/COMEN01C.cbl:156 (data-driven, table), XCTL at app/cbl/COMEN01C.cbl:184 (data-driven, table). */
    @PostMapping("/link")
    public ResponseEntity<CoactupcCommarea> link(@RequestBody CoactupcCommarea request) {
        return ResponseEntity.ok(coactupcService.handleLink(request));
    }

}