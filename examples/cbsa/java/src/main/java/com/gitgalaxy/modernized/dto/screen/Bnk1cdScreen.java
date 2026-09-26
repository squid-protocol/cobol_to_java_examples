package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map BNK1CD of mapset BNK1CDM (src/base/bms_src/BNK1CDM.bms): the screen as a view model (#3619).
 * SEND at src/base/cobol_src/BNK1CRA.cbl:649, src/base/cobol_src/BNK1CRA.cbl:723, src/base/cobol_src/BNK1CRA.cbl:797; RECEIVE at src/base/cobol_src/BNK1CRA.cbl:370.
 * One property per named field (symbolic map BNK1CDI / BNK1CDO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1cdScreen implements ScreenModel {

    public static final String MAPSET = "BNK1CDM";
    public static final String MAP = "BNK1CD";
    public static final List<ScreenField> LAYOUT = List.of(
            new ScreenField(null, 1, 1, 7, false, false, false, false, false, "BNK1CD ", "BLUE", 1),
            new ScreenField("COMPANY", 1, 15, 58, false, false, false, false, false, "CICS Bank Sample Application - Credit/Debit Funds.", "RED", 1),
            new ScreenField(null, 3, 1, 61, false, false, false, false, false, "Provide an ACCOUNT number and an AMOUNT and then press Enter.", "TURQUOISE", 1),
            new ScreenField(null, 8, 1, 15, false, false, false, false, false, "ACCOUNT NUMBER:", "TURQUOISE", 1),
            new ScreenField("ACCNO", 8, 17, 8, false, true, false, false, true, null, "GREEN", 1),
            new ScreenField(null, 8, 26, 7, false, false, false, false, false, "AMOUNT:", "TURQUOISE", 1),
            new ScreenField("SIGN", 8, 35, 1, true, false, false, false, false, "+", "GREEN", 1),
            new ScreenField("AMT", 8, 37, 13, true, false, false, false, false, "0000000000.00", "GREEN", 1),
            new ScreenField(null, 8, 51, 1, false, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 10, 1, 16, false, false, false, false, false, "Sort Code: ", "TURQUOISE", 1),
            new ScreenField("SORTC", 10, 21, 6, false, true, false, false, false, "      ", "NEUTRAL", 1),
            new ScreenField(null, 11, 1, 18, false, false, false, false, false, "Available Balance:", "TURQUOISE", 1),
            new ScreenField("AVBAL", 11, 20, 14, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 12, 1, 16, false, false, false, false, false, "Actual Balance:", "TURQUOISE", 1),
            new ScreenField("ACTBAL", 12, 20, 14, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField("MESSAGE", 23, 1, 79, false, false, true, false, false, null, "YELLOW", 1),
            new ScreenField(null, 24, 1, 20, false, false, false, false, false, "F3=Exit   F12=Cancel", "BLUE", 1),
            new ScreenField("DUMMY", 24, 79, 1, false, false, false, true, false, " ", null, 1));

    /** COMPANY: (1,15), 58 bytes, ATTRB=NORM,PROT -- src/base/bms_src/BNK1CDM.bms:29. Symbolic map COMPANYI, COMPANYO. */
    private String company;

    /** ACCNO: (8,17), 8 bytes, ATTRB=FSET,IC,NORM,NUM -- src/base/bms_src/BNK1CDM.bms:38. Symbolic map ACCNOI, ACCNOO. */
    private String accno;

    /** SIGN: (8,35), 1 bytes, ATTRB=FSET,NORM,UNPROT -- src/base/bms_src/BNK1CDM.bms:44. Symbolic map SIGNI, SIGNO. */
    private String sign;

    /** AMT: (8,37), 13 bytes, ATTRB=FSET,NORM,UNPROT -- src/base/bms_src/BNK1CDM.bms:46. Symbolic map AMTI, AMTO. */
    private String amt;

    /** SORTC: (10,21), 6 bytes, ATTRB=NORM,NUM,PROT -- src/base/bms_src/BNK1CDM.bms:52. Symbolic map SORTCI, SORTCO. */
    private String sortc;

    /** AVBAL: (11,20), 14 bytes, ATTRB=NORM,PROT -- src/base/bms_src/BNK1CDM.bms:56. Symbolic map AVBALI, AVBALO. */
    private String avbal;

    /** ACTBAL: (12,20), 14 bytes, ATTRB=NORM,PROT -- src/base/bms_src/BNK1CDM.bms:60. Symbolic map ACTBALI, ACTBALO. */
    private String actbal;

    /** MESSAGE: (23,1), 79 bytes, ATTRB=BRT,PROT -- src/base/bms_src/BNK1CDM.bms:63. Symbolic map MESSAGEI, MESSAGEO. */
    private String message;

    /** DUMMY: (24,79), 1 bytes, ATTRB=DRK,FSET,PROT -- src/base/bms_src/BNK1CDM.bms:66. Symbolic map DUMMYI, DUMMYO. */
    private String dummy;

    @Override
    public String mapsetName() {
        return MAPSET;
    }

    @Override
    public String mapName() {
        return MAP;
    }

    @Override
    public List<ScreenField> screenLayout() {
        return LAYOUT;
    }

    @Override
    public Map<String, String> screenValues() {
        Map<String, String> values = new LinkedHashMap<>();
        values.put("COMPANY", company);
        values.put("ACCNO", accno);
        values.put("SIGN", sign);
        values.put("AMT", amt);
        values.put("SORTC", sortc);
        values.put("AVBAL", avbal);
        values.put("ACTBAL", actbal);
        values.put("MESSAGE", message);
        values.put("DUMMY", dummy);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Bnk1cdScreen fromValues(Map<String, String> values) {
        Bnk1cdScreen screen = new Bnk1cdScreen();
        screen.setCompany(values.get("COMPANY"));
        screen.setAccno(values.get("ACCNO"));
        screen.setSign(values.get("SIGN"));
        screen.setAmt(values.get("AMT"));
        screen.setSortc(values.get("SORTC"));
        screen.setAvbal(values.get("AVBAL"));
        screen.setActbal(values.get("ACTBAL"));
        screen.setMessage(values.get("MESSAGE"));
        screen.setDummy(values.get("DUMMY"));
        return screen;
    }
}
