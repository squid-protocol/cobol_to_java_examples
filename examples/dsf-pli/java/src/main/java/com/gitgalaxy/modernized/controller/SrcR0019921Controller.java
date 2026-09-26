package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.FeilStruc2;
import com.gitgalaxy.modernized.service.SrcR0019921Service;

/**
 * CICS program R0019921 (src/R0019921.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: FEIL_STRUC (src/R0011306.pli, 85 bytes) -> FeilStruc2.
 * TODO: callers also pass FEIL_STRUC (src/R0010450.pli, 89 bytes) at src/R0010450.pli:715.
 * TODO: callers also pass FEIL_STRUC (src/R0011820.pli, 85 bytes) at src/R0011820.pli:438.
 * TODO: callers also pass FEIL_STRUC (src/R0019944.pli, 85 bytes) at src/R0019944.pli:60.
 * TODO: callers also pass FEIL_STRUC (src/R0019963.pli, 85 bytes) at src/R0019963.pli:50.
 * TODO: callers also pass FEIL_STRUC (src/R0019969.pli, 85 bytes) at src/R0019969.pli:51.
 * TODO: callers also pass FEIL_STRUC (src/R0019971.pli, 85 bytes) at src/R0019971.pli:44.
 * TODO: callers also pass FEIL_STRUC (src/R0019D70.pli, 85 bytes) at src/R0019D70.pli:533.
 * TODO: callers also pass FEIL_STRUC (src/R0019E04.pli, 85 bytes) at src/R0019E04.pli:4516.
 * TODO: callers also pass FEIL_STRUC (src/R0019F01.pli, 85 bytes) at src/R0019F01.pli:1294.
 * TODO: callers also pass FEIL_STRUC (src/R0019H01.pli, 81 bytes) at src/R0019H01.pli:1304.
 * TODO: callers also pass FEIL_STRUC (src/R0019H21.pli, 81 bytes) at src/R0019H21.pli:1065.
 * TODO: callers also pass FEIL_STRUC (src/R0019H31.pli, 85 bytes) at src/R0019H31.pli:1024.
 * TODO: callers also pass FEIL_STRUC (src/R0019H3A.pli, 85 bytes) at src/R0019H3A.pli:978.
 * TODO: callers also pass FEIL_STRUC (src/R0019H41.pli, 81 bytes) at src/R0019H41.pli:969.
 * TODO: callers also pass FEIL_STRUC (src/R0019H60.pli, 85 bytes) at src/R0019H60.pli:1021.
 * TODO: callers also pass FEIL_STRUC (src/R001HL21.pli, 81 bytes) at src/R001HL21.pli:1023.
 * TODO: callers also pass FEIL_STRUC (src/R001I201.pli, 85 bytes) at src/R001I201.pli:2728.
 * TODO: callers also pass FEIL_STRUC (src/R001I301.pli, 85 bytes) at src/R001I301.pli:2156.
 * TODO: callers also pass FEIL_STRUC (src/R001I501.pli, 85 bytes) at src/R001I501.pli:1942.
 * TODO: callers also pass FEIL_STRUC (src/R001I701.pli, 85 bytes) at src/R001I701.pli:699.
 * TODO: callers also pass FEIL_STRUC (src/R001I903.pli, 85 bytes) at src/R001I903.pli:3868.
 * TODO: callers also pass FEIL_STRUC (src/R001NO10.pli, 85 bytes) at src/R001NO10.pli:1781.
 * TODO: callers also pass FEIL_STRUC (src/R001TK44.pli, 85 bytes) at src/R001TK44.pli:38.
 * TODO: callers also pass FEIL_STRUC (src/R001TK46.pli, 85 bytes) at src/R001TK46.pli:38.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-r0019921")
@RequiredArgsConstructor
public class SrcR0019921Controller {

    private final SrcR0019921Service srcR0019921Service;

    /** Program-to-program entry: LINK at src/R0010450.pli:715, LINK at src/R0011306.pli:521, LINK at src/R0011306.pli:559, LINK at src/R0011306.pli:597, LINK at src/R0011306.pli:633, LINK at src/R0011820.pli:438, LINK at src/R0019944.pli:60, LINK at src/R0019963.pli:50, LINK at src/R0019969.pli:51, LINK at src/R0019971.pli:44, LINK at src/R0019D70.pli:533, LINK at src/R0019E04.pli:4516, LINK at src/R0019F01.pli:1294, LINK at src/R0019H01.pli:1304, LINK at src/R0019H21.pli:1065, LINK at src/R0019H31.pli:1024, LINK at src/R0019H3A.pli:978, LINK at src/R0019H41.pli:969, LINK at src/R0019H60.pli:1021, LINK at src/R001HL21.pli:1023, LINK at src/R001I201.pli:2728, LINK at src/R001I301.pli:2156, LINK at src/R001I501.pli:1942, LINK at src/R001I701.pli:699, LINK at src/R001I903.pli:3868, LINK at src/R001NO10.pli:1781, LINK at src/R001TK44.pli:38, LINK at src/R001TK46.pli:38. */
    @PostMapping("/link")
    public ResponseEntity<FeilStruc2> link(@RequestBody FeilStruc2 request) {
        return ResponseEntity.ok(srcR0019921Service.handleLink(request));
    }

}