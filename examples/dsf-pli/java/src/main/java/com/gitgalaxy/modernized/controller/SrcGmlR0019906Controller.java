package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.FnrReg;
import com.gitgalaxy.modernized.service.SrcGmlR0019906Service;

/**
 * CICS program R0019906 (src/GML/R0019906.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: FNR_REG (src/GML/R0011003.pli, 16 bytes) -> FnrReg.
 * TODO: callers also pass FNR_REG (src/GML/R0011303.pli, 16 bytes) at src/GML/R0011303.pli:74, src/GML/R0011303.pli:206, src/GML/R0011303.pli:339, src/GML/R0011303.pli:441, src/GML/R0011303.pli:556.
 * TODO: callers also pass FNR_REG (src/GML/R0010803.pli, 16 bytes) at src/GML/R0010803.pli:114, src/GML/R0010803.pli:312, src/GML/R0010803.pli:1049, src/GML/R0010803.pli:1086.
 * TODO: callers also pass FNR_REG (src/GML/R001N803.pli, 16 bytes) at src/GML/R001N803.pli:115, src/GML/R001N803.pli:251, src/GML/R001N803.pli:910, src/GML/R001N803.pli:947.
 * TODO: callers also pass FNR_REG (src/GML/R001U803.pli, 16 bytes) at src/GML/R001U803.pli:110, src/GML/R001U803.pli:267, src/GML/R001U803.pli:888, src/GML/R001U803.pli:925.
 * TODO: callers also pass FNR_REG (src/GML/R001I101.pli, 16 bytes) at src/GML/R001I101.pli:494, src/GML/R001I101.pli:625, src/GML/R001I101.pli:757.
 * TODO: callers also pass FNR_REG (src/GML/R0010503.pli, 16 bytes) at src/GML/R0010503.pli:182, src/GML/R0010503.pli:332.
 * TODO: callers also pass FNR_REG (src/GML/R0010603.pli, 16 bytes) at src/GML/R0010603.pli:270, src/GML/R0010603.pli:623.
 * TODO: callers also pass FNR_REG (src/GML/R0011103.pli, 16 bytes) at src/GML/R0011103.pli:119, src/GML/R0011103.pli:196.
 * TODO: callers also pass FNR_REG (src/GML/R0011203.pli, 16 bytes) at src/GML/R0011203.pli:128, src/GML/R0011203.pli:205.
 * TODO: callers also pass FNR_REG (src/GML/R0011403.pli, 16 bytes) at src/GML/R0011403.pli:172, src/GML/R0011403.pli:346.
 * TODO: callers also pass FNR_REG (src/GML/R0011603.pli, 16 bytes) at src/GML/R0011603.pli:103, src/GML/R0011603.pli:159.
 * TODO: callers also pass FNR_REG (src/GML/R0011703.pli, 16 bytes) at src/GML/R0011703.pli:93, src/GML/R0011703.pli:156.
 * TODO: callers also pass FNR_REG (src/GML/R0011903.pli, 16 bytes) at src/GML/R0011903.pli:205, src/GML/R0011903.pli:384.
 * TODO: callers also pass FNR_REG (src/GML/R001IA03.pli, 16 bytes) at src/GML/R001IA03.pli:58, src/GML/R001IA03.pli:76.
 * TODO: callers also pass FNR_REG (src/GML/R001N503.pli, 16 bytes) at src/GML/R001N503.pli:158, src/GML/R001N503.pli:398.
 * TODO: callers also pass FNR_REG (src/GML/R001N603.pli, 16 bytes) at src/GML/R001N603.pli:249, src/GML/R001N603.pli:607.
 * TODO: callers also pass FNR_REG (src/GML/R001NB03.pli, 16 bytes) at src/GML/R001NB03.pli:110, src/GML/R001NB03.pli:217.
 * TODO: callers also pass FNR_REG (src/GML/R001NC03.pli, 16 bytes) at src/GML/R001NC03.pli:109, src/GML/R001NC03.pli:214.
 * TODO: callers also pass FNR_REG (src/GML/R001U603.pli, 16 bytes) at src/GML/R001U603.pli:255, src/GML/R001U603.pli:872.
 * TODO: callers also pass FNR_REG (src/GML/R001UC03.pli, 16 bytes) at src/GML/R001UC03.pli:94, src/GML/R001UC03.pli:194.
 * TODO: callers also pass FNR_REG (src/GML/R001UE03.pli, 16 bytes) at src/GML/R001UE03.pli:140, src/GML/R001UE03.pli:376.
 * TODO: callers also pass FNR_REG (src/GML/R001UJ03.pli, 16 bytes) at src/GML/R001UJ03.pli:184, src/GML/R001UJ03.pli:346.
 * TODO: callers also pass FNR_REG (src/GML/R0010410.pli, 16 bytes) at src/GML/R0010410.pli:3312.
 * TODO: callers also pass FNR_REG (src/GML/R0010430.pli, 16 bytes) at src/GML/R0010430.pli:1432.
 * TODO: callers also pass FNR_REG (src/GML/R0010450.pli, 16 bytes) at src/GML/R0010450.pli:415.
 * TODO: callers also pass FNR_REG (src/GML/R0010480.pli, 16 bytes) at src/GML/R0010480.pli:672.
 * TODO: callers also pass FNR_REG (src/GML/R0010504.pli, 16 bytes) at src/GML/R0010504.pli:137.
 * TODO: callers also pass FNR_REG (src/GML/R0010604.pli, 16 bytes) at src/GML/R0010604.pli:138.
 * TODO: callers also pass FNR_REG (src/GML/R0010703.pli, 16 bytes) at src/GML/R0010703.pli:165.
 * TODO: callers also pass FNR_REG (src/GML/R0010903.pli, 16 bytes) at src/GML/R0010903.pli:107.
 * TODO: callers also pass FNR_REG (src/GML/R0011204.pli, 16 bytes) at src/GML/R0011204.pli:95.
 * TODO: callers also pass FNR_REG (src/GML/R0011503.pli, 16 bytes) at src/GML/R0011503.pli:73.
 * TODO: callers also pass FNR_REG (src/GML/R0011803.pli, 16 bytes) at src/GML/R0011803.pli:61.
 * TODO: callers also pass FNR_REG (src/GML/R0011833.pli, 16 bytes) at src/GML/R0011833.pli:109.
 * TODO: callers also pass FNR_REG (src/GML/R001B001.pli, 16 bytes) at src/GML/R001B001.pli:490.
 * TODO: callers also pass FNR_REG (src/GML/R001I402.pli, 16 bytes) at src/GML/R001I402.pli:219.
 * TODO: callers also pass FNR_REG (src/GML/R001I801.pli, 16 bytes) at src/GML/R001I801.pli:355.
 * TODO: callers also pass FNR_REG (src/GML/R001I903.pli, 16 bytes) at src/GML/R001I903.pli:1332.
 * TODO: callers also pass FNR_REG (src/GML/R001N504.pli, 16 bytes) at src/GML/R001N504.pli:116.
 * TODO: callers also pass FNR_REG (src/GML/R001N604.pli, 16 bytes) at src/GML/R001N604.pli:129.
 * TODO: callers also pass FNR_REG (src/GML/R001N903.pli, 16 bytes) at src/GML/R001N903.pli:108.
 * TODO: callers also pass FNR_REG (src/GML/R001NC04.pli, 16 bytes) at src/GML/R001NC04.pli:88.
 * TODO: callers also pass FNR_REG (src/GML/R001S001.pli, 16 bytes) at src/GML/R001S001.pli:385.
 * TODO: callers also pass FNR_REG (src/GML/R001S003.pli, 16 bytes) at src/GML/R001S003.pli:386.
 * TODO: callers also pass FNR_REG (src/GML/R001UC04.pli, 16 bytes) at src/GML/R001UC04.pli:90.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0019906")
@RequiredArgsConstructor
public class SrcGmlR0019906Controller {

    private final SrcGmlR0019906Service srcGmlR0019906Service;

    /** Program-to-program entry: LINK at src/GML/R0010410.pli:3312, LINK at src/GML/R0010430.pli:1432, LINK at src/GML/R0010450.pli:415, LINK at src/GML/R0010480.pli:672, LINK at src/GML/R0010503.pli:182, LINK at src/GML/R0010503.pli:332, LINK at src/GML/R0010504.pli:137, LINK at src/GML/R0010603.pli:270, LINK at src/GML/R0010603.pli:623, LINK at src/GML/R0010604.pli:138, LINK at src/GML/R0010703.pli:165, LINK at src/GML/R0010803.pli:114, LINK at src/GML/R0010803.pli:312, LINK at src/GML/R0010803.pli:1049, LINK at src/GML/R0010803.pli:1086, LINK at src/GML/R0010903.pli:107, LINK at src/GML/R0011003.pli:187, LINK at src/GML/R0011003.pli:327, LINK at src/GML/R0011003.pli:514, LINK at src/GML/R0011003.pli:838, LINK at src/GML/R0011003.pli:1059, LINK at src/GML/R0011103.pli:119, LINK at src/GML/R0011103.pli:196, LINK at src/GML/R0011203.pli:128, LINK at src/GML/R0011203.pli:205, LINK at src/GML/R0011204.pli:95, LINK at src/GML/R0011303.pli:74, LINK at src/GML/R0011303.pli:206, LINK at src/GML/R0011303.pli:339, LINK at src/GML/R0011303.pli:441, LINK at src/GML/R0011303.pli:556, LINK at src/GML/R0011403.pli:172, LINK at src/GML/R0011403.pli:346, LINK at src/GML/R0011503.pli:73, LINK at src/GML/R0011603.pli:103, LINK at src/GML/R0011603.pli:159, LINK at src/GML/R0011703.pli:93, LINK at src/GML/R0011703.pli:156, LINK at src/GML/R0011803.pli:61, LINK at src/GML/R0011833.pli:109, LINK at src/GML/R0011903.pli:205, LINK at src/GML/R0011903.pli:384, LINK at src/GML/R001B001.pli:490, LINK at src/GML/R001I101.pli:494, LINK at src/GML/R001I101.pli:625, LINK at src/GML/R001I101.pli:757, LINK at src/GML/R001I402.pli:219, LINK at src/GML/R001I801.pli:355, LINK at src/GML/R001I903.pli:1332, LINK at src/GML/R001IA03.pli:58, LINK at src/GML/R001IA03.pli:76, LINK at src/GML/R001N503.pli:158, LINK at src/GML/R001N503.pli:398, LINK at src/GML/R001N504.pli:116, LINK at src/GML/R001N603.pli:249, LINK at src/GML/R001N603.pli:607, LINK at src/GML/R001N604.pli:129, LINK at src/GML/R001N803.pli:115, LINK at src/GML/R001N803.pli:251, LINK at src/GML/R001N803.pli:910, LINK at src/GML/R001N803.pli:947, LINK at src/GML/R001N903.pli:108, LINK at src/GML/R001NB03.pli:110, LINK at src/GML/R001NB03.pli:217, LINK at src/GML/R001NC03.pli:109, LINK at src/GML/R001NC03.pli:214, LINK at src/GML/R001NC04.pli:88, LINK at src/GML/R001S001.pli:385, LINK at src/GML/R001S003.pli:386, LINK at src/GML/R001U603.pli:255, LINK at src/GML/R001U603.pli:872, LINK at src/GML/R001U803.pli:110, LINK at src/GML/R001U803.pli:267, LINK at src/GML/R001U803.pli:888, LINK at src/GML/R001U803.pli:925, LINK at src/GML/R001UC03.pli:94, LINK at src/GML/R001UC03.pli:194, LINK at src/GML/R001UC04.pli:90, LINK at src/GML/R001UE03.pli:140, LINK at src/GML/R001UE03.pli:376, LINK at src/GML/R001UJ03.pli:184, LINK at src/GML/R001UJ03.pli:346. */
    @PostMapping("/link")
    public ResponseEntity<FnrReg> link(@RequestBody FnrReg request) {
        return ResponseEntity.ok(srcGmlR0019906Service.handleLink(request));
    }

}