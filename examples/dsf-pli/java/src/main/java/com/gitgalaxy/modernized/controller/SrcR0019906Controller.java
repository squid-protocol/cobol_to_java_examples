package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.FnrReg2;
import com.gitgalaxy.modernized.service.SrcR0019906Service;

/**
 * CICS program R0019906 (src/R0019906.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: FNR_REG (src/R0011003.pli, 16 bytes) -> FnrReg2.
 * TODO: callers also pass FNR_REG (src/R0011303.pli, 16 bytes) at src/R0011303.pli:78, src/R0011303.pli:226, src/R0011303.pli:359, src/R0011303.pli:461, src/R0011303.pli:576.
 * TODO: callers also pass FNR_REG (src/R0010803.pli, 16 bytes) at src/R0010803.pli:108, src/R0010803.pli:314, src/R0010803.pli:1007, src/R0010803.pli:1044.
 * TODO: callers also pass FNR_REG (src/R001N803.pli, 16 bytes) at src/R001N803.pli:118, src/R001N803.pli:261, src/R001N803.pli:909, src/R001N803.pli:946.
 * TODO: callers also pass FNR_REG (src/R001U803.pli, 16 bytes) at src/R001U803.pli:113, src/R001U803.pli:316, src/R001U803.pli:755, src/R001U803.pli:792.
 * TODO: callers also pass FNR_REG (src/R001I101.pli, 16 bytes) at src/R001I101.pli:490, src/R001I101.pli:621, src/R001I101.pli:754.
 * TODO: callers also pass FNR_REG (src/R0010503.pli, 16 bytes) at src/R0010503.pli:136, src/R0010503.pli:296.
 * TODO: callers also pass FNR_REG (src/R0010603.pli, 16 bytes) at src/R0010603.pli:236, src/R0010603.pli:585.
 * TODO: callers also pass FNR_REG (src/R0011103.pli, 16 bytes) at src/R0011103.pli:106, src/R0011103.pli:201.
 * TODO: callers also pass FNR_REG (src/R0011203.pli, 16 bytes) at src/R0011203.pli:90, src/R0011203.pli:172.
 * TODO: callers also pass FNR_REG (src/R0011403.pli, 16 bytes) at src/R0011403.pli:150, src/R0011403.pli:326.
 * TODO: callers also pass FNR_REG (src/R0011603.pli, 16 bytes) at src/R0011603.pli:106, src/R0011603.pli:179.
 * TODO: callers also pass FNR_REG (src/R0011703.pli, 16 bytes) at src/R0011703.pli:68, src/R0011703.pli:136.
 * TODO: callers also pass FNR_REG (src/R0011903.pli, 16 bytes) at src/R0011903.pli:179, src/R0011903.pli:347.
 * TODO: callers also pass FNR_REG (src/R001IA03.pli, 16 bytes) at src/R001IA03.pli:79, src/R001IA03.pli:97.
 * TODO: callers also pass FNR_REG (src/R001N503.pli, 16 bytes) at src/R001N503.pli:128, src/R001N503.pli:438.
 * TODO: callers also pass FNR_REG (src/R001N603.pli, 16 bytes) at src/R001N603.pli:221, src/R001N603.pli:586.
 * TODO: callers also pass FNR_REG (src/R001NB03.pli, 16 bytes) at src/R001NB03.pli:96, src/R001NB03.pli:222.
 * TODO: callers also pass FNR_REG (src/R001NC03.pli, 16 bytes) at src/R001NC03.pli:87, src/R001NC03.pli:195.
 * TODO: callers also pass FNR_REG (src/R001U603.pli, 16 bytes) at src/R001U603.pli:263, src/R001U603.pli:926.
 * TODO: callers also pass FNR_REG (src/R001UC03.pli, 16 bytes) at src/R001UC03.pli:81, src/R001UC03.pli:222.
 * TODO: callers also pass FNR_REG (src/R001UE03.pli, 16 bytes) at src/R001UE03.pli:130, src/R001UE03.pli:404.
 * TODO: callers also pass FNR_REG (src/R001UJ03.pli, 16 bytes) at src/R001UJ03.pli:130, src/R001UJ03.pli:352.
 * TODO: callers also pass FNR_REG (src/R0010410.pli, 16 bytes) at src/R0010410.pli:5092.
 * TODO: callers also pass FNR_REG (src/R0010430.pli, 16 bytes) at src/R0010430.pli:1434.
 * TODO: callers also pass FNR_REG (src/R0010450.pli, 16 bytes) at src/R0010450.pli:428.
 * TODO: callers also pass FNR_REG (src/R0010480.pli, 16 bytes) at src/R0010480.pli:643.
 * TODO: callers also pass FNR_REG (src/R0010504.pli, 16 bytes) at src/R0010504.pli:130.
 * TODO: callers also pass FNR_REG (src/R0010604.pli, 16 bytes) at src/R0010604.pli:130.
 * TODO: callers also pass FNR_REG (src/R0011204.pli, 16 bytes) at src/R0011204.pli:84.
 * TODO: callers also pass FNR_REG (src/R0011503.pli, 16 bytes) at src/R0011503.pli:70.
 * TODO: callers also pass FNR_REG (src/R0011803.pli, 16 bytes) at src/R0011803.pli:65.
 * TODO: callers also pass FNR_REG (src/R0011833.pli, 16 bytes) at src/R0011833.pli:109.
 * TODO: callers also pass FNR_REG (src/R0012101.pli, 16 bytes) at src/R0012101.pli:399.
 * TODO: callers also pass FNR_REG (src/R0012301.pli, 16 bytes) at src/R0012301.pli:421.
 * TODO: callers also pass FNR_REG (src/R0019A02.pli, 16 bytes) at src/R0019A02.pli:100.
 * TODO: callers also pass FNR_REG (src/R001B001.pli, 16 bytes) at src/R001B001.pli:481.
 * TODO: callers also pass FNR_REG (src/R001I402.pli, 16 bytes) at src/R001I402.pli:219.
 * TODO: callers also pass FNR_REG (src/R001I801.pli, 16 bytes) at src/R001I801.pli:356.
 * TODO: callers also pass FNR_REG (src/R001I903.pli, 16 bytes) at src/R001I903.pli:1335.
 * TODO: callers also pass FNR_REG (src/R001N504.pli, 16 bytes) at src/R001N504.pli:117.
 * TODO: callers also pass FNR_REG (src/R001N604.pli, 16 bytes) at src/R001N604.pli:131.
 * TODO: callers also pass FNR_REG (src/R001N903.pli, 16 bytes) at src/R001N903.pli:109.
 * TODO: callers also pass FNR_REG (src/R001NC04.pli, 16 bytes) at src/R001NC04.pli:79.
 * TODO: callers also pass FNR_REG (src/R001S001.pli, 16 bytes) at src/R001S001.pli:378.
 * TODO: callers also pass FNR_REG (src/R001S003.pli, 16 bytes) at src/R001S003.pli:390.
 * TODO: callers also pass FNR_REG (src/R001UC04.pli, 16 bytes) at src/R001UC04.pli:82.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0019906")
@RequiredArgsConstructor
public class SrcR0019906Controller {

    private final SrcR0019906Service srcR0019906Service;

    /** Program-to-program entry: LINK at src/R0010410.pli:5092, LINK at src/R0010430.pli:1434, LINK at src/R0010450.pli:428, LINK at src/R0010480.pli:643, LINK at src/R0010503.pli:136, LINK at src/R0010503.pli:296, LINK at src/R0010504.pli:130, LINK at src/R0010603.pli:236, LINK at src/R0010603.pli:585, LINK at src/R0010604.pli:130, LINK at src/R0010803.pli:108, LINK at src/R0010803.pli:314, LINK at src/R0010803.pli:1007, LINK at src/R0010803.pli:1044, LINK at src/R0011003.pli:212, LINK at src/R0011003.pli:348, LINK at src/R0011003.pli:558, LINK at src/R0011003.pli:901, LINK at src/R0011003.pli:1116, LINK at src/R0011103.pli:106, LINK at src/R0011103.pli:201, LINK at src/R0011203.pli:90, LINK at src/R0011203.pli:172, LINK at src/R0011204.pli:84, LINK at src/R0011303.pli:78, LINK at src/R0011303.pli:226, LINK at src/R0011303.pli:359, LINK at src/R0011303.pli:461, LINK at src/R0011303.pli:576, LINK at src/R0011403.pli:150, LINK at src/R0011403.pli:326, LINK at src/R0011503.pli:70, LINK at src/R0011603.pli:106, LINK at src/R0011603.pli:179, LINK at src/R0011703.pli:68, LINK at src/R0011703.pli:136, LINK at src/R0011803.pli:65, LINK at src/R0011833.pli:109, LINK at src/R0011903.pli:179, LINK at src/R0011903.pli:347, LINK at src/R0012101.pli:399, LINK at src/R0012301.pli:421, LINK at src/R0019A02.pli:100, LINK at src/R001B001.pli:481, LINK at src/R001I101.pli:490, LINK at src/R001I101.pli:621, LINK at src/R001I101.pli:754, LINK at src/R001I402.pli:219, LINK at src/R001I801.pli:356, LINK at src/R001I903.pli:1335, LINK at src/R001IA03.pli:79, LINK at src/R001IA03.pli:97, LINK at src/R001N503.pli:128, LINK at src/R001N503.pli:438, LINK at src/R001N504.pli:117, LINK at src/R001N603.pli:221, LINK at src/R001N603.pli:586, LINK at src/R001N604.pli:131, LINK at src/R001N803.pli:118, LINK at src/R001N803.pli:261, LINK at src/R001N803.pli:909, LINK at src/R001N803.pli:946, LINK at src/R001N903.pli:109, LINK at src/R001NB03.pli:96, LINK at src/R001NB03.pli:222, LINK at src/R001NC03.pli:87, LINK at src/R001NC03.pli:195, LINK at src/R001NC04.pli:79, LINK at src/R001S001.pli:378, LINK at src/R001S003.pli:390, LINK at src/R001U603.pli:263, LINK at src/R001U603.pli:926, LINK at src/R001U803.pli:113, LINK at src/R001U803.pli:316, LINK at src/R001U803.pli:755, LINK at src/R001U803.pli:792, LINK at src/R001UC03.pli:81, LINK at src/R001UC03.pli:222, LINK at src/R001UC04.pli:82, LINK at src/R001UE03.pli:130, LINK at src/R001UE03.pli:404, LINK at src/R001UJ03.pli:130, LINK at src/R001UJ03.pli:352. */
    @PostMapping("/link")
    public ResponseEntity<FnrReg2> link(@RequestBody FnrReg2 request) {
        return ResponseEntity.ok(srcR0019906Service.handleLink(request));
    }

}