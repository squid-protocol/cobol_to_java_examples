package com.gitgalaxy.modernized.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import com.gitgalaxy.modernized.dto.contract.FeilStruc;
import com.gitgalaxy.modernized.service.SrcGmlR0019921Service;

/**
 * CICS program R0019921 (src/GML/R0019921.pli), generated from GitGalaxy's
 * verified skeleton (06_skeleton). Each endpoint names the fact it came from.
 * COMMAREA: FEIL_STRUC (src/GML/R0011306.pli, 85 bytes) -> FeilStruc.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0010450.pli, 89 bytes) at src/GML/R0010450.pli:660.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0011820.pli, 85 bytes) at src/GML/R0011820.pli:440.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0019944.pli, 85 bytes) at src/GML/R0019944.pli:59.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0019963.pli, 85 bytes) at src/GML/R0019963.pli:50.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0019969.pli, 85 bytes) at src/GML/R0019969.pli:51.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0019D70.pli, 85 bytes) at src/GML/R0019D70.pli:535.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0019E04.pli, 85 bytes) at src/GML/R0019E04.pli:4372.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0019F01.pli, 85 bytes) at src/GML/R0019F01.pli:1076.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0019F02.pli, 85 bytes) at src/GML/R0019F02.pli:1413.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0019F03.pli, 85 bytes) at src/GML/R0019F03.pli:1041.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0019F05.pli, 85 bytes) at src/GML/R0019F05.pli:1433.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0019H01.pli, 85 bytes) at src/GML/R0019H01.pli:1063.
 * TODO: callers also pass FEIL_STRUC (src/GML/R0019H60.pli, 85 bytes) at src/GML/R0019H60.pli:1021.
 * TODO: callers also pass FEIL_STRUC (src/GML/R001I201.pli, 85 bytes) at src/GML/R001I201.pli:2593.
 * TODO: callers also pass FEIL_STRUC (src/GML/R001I301.pli, 85 bytes) at src/GML/R001I301.pli:2086.
 * TODO: callers also pass FEIL_STRUC (src/GML/R001I501.pli, 85 bytes) at src/GML/R001I501.pli:1938.
 * TODO: callers also pass FEIL_STRUC (src/GML/R001I701.pli, 85 bytes) at src/GML/R001I701.pli:661.
 * TODO: callers also pass FEIL_STRUC (src/GML/R001I903.pli, 85 bytes) at src/GML/R001I903.pli:3860.
 * TODO: callers also pass FEIL_STRUC (src/GML/R001NO10.pli, 85 bytes) at src/GML/R001NO10.pli:1771.
 * TODO: callers also pass FEIL_STRUC (src/GML/R001O301.pli, 85 bytes) at src/GML/R001O301.pli:2003.
 * TODO: callers also pass FEIL_STRUC (src/GML/R001TK44.pli, 85 bytes) at src/GML/R001TK44.pli:38.
 * TODO: callers also pass FEIL_STRUC (src/GML/R001TK46.pli, 85 bytes) at src/GML/R001TK46.pli:38.
 * Field testing: entry transactions open (4 public / 0 private estates);
 * record fields field-tested (6 public / 0 private estates).
 */
@RestController
@RequestMapping("/api/v1/src-gml-r0019921")
@RequiredArgsConstructor
public class SrcGmlR0019921Controller {

    private final SrcGmlR0019921Service srcGmlR0019921Service;

    /** Program-to-program entry: LINK at src/GML/R0010450.pli:660, LINK at src/GML/R0011306.pli:520, LINK at src/GML/R0011306.pli:558, LINK at src/GML/R0011306.pli:596, LINK at src/GML/R0011306.pli:632, LINK at src/GML/R0011820.pli:440, LINK at src/GML/R0019944.pli:59, LINK at src/GML/R0019963.pli:50, LINK at src/GML/R0019969.pli:51, LINK at src/GML/R0019D70.pli:535, LINK at src/GML/R0019E04.pli:4372, LINK at src/GML/R0019F01.pli:1076, LINK at src/GML/R0019F02.pli:1413, LINK at src/GML/R0019F03.pli:1041, LINK at src/GML/R0019F05.pli:1433, LINK at src/GML/R0019H01.pli:1063, LINK at src/GML/R0019H60.pli:1021, LINK at src/GML/R001I201.pli:2593, LINK at src/GML/R001I301.pli:2086, LINK at src/GML/R001I501.pli:1938, LINK at src/GML/R001I701.pli:661, LINK at src/GML/R001I903.pli:3860, LINK at src/GML/R001NO10.pli:1771, LINK at src/GML/R001O301.pli:2003, LINK at src/GML/R001TK44.pli:38, LINK at src/GML/R001TK46.pli:38. */
    @PostMapping("/link")
    public ResponseEntity<FeilStruc> link(@RequestBody FeilStruc request) {
        return ResponseEntity.ok(srcGmlR0019921Service.handleLink(request));
    }

}