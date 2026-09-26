package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map BNK1CA of mapset BNK1CAM (src/base/bms_src/BNK1CAM.bms): the screen as a view model (#3619).
 * SEND at src/base/cobol_src/BNK1CAC.cbl:966, src/base/cobol_src/BNK1CAC.cbl:1040, src/base/cobol_src/BNK1CAC.cbl:1117; RECEIVE at src/base/cobol_src/BNK1CAC.cbl:356.
 * One property per named field (symbolic map BNK1CAI / BNK1CAO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1caScreen implements ScreenModel {

    public static final String MAPSET = "BNK1CAM";
    public static final String MAP = "BNK1CA";
    public static final List<ScreenField> LAYOUT = List.of(
            new ScreenField(null, 1, 1, 7, false, false, false, false, false, "BNK1CA ", "BLUE", 1),
            new ScreenField("COMPANY", 1, 18, 58, false, false, false, false, false, "CICS Bank Sample Application- Create Account. ", "RED", 1),
            new ScreenField(null, 3, 1, 57, false, false, false, false, false, "Please provide the requested information and press Enter.", "TURQUOISE", 1),
            new ScreenField(null, 6, 1, 18, false, false, false, false, false, "Customer number  :", "TURQUOISE", 1),
            new ScreenField("CUSTNO", 6, 23, 10, false, true, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 6, 34, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 7, 1, 18, false, false, false, false, false, "Account Type     :", "TURQUOISE", 1),
            new ScreenField("ACCTYP", 7, 23, 8, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 7, 32, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 8, 1, 18, false, false, false, false, false, "Interest Rate    :", "TURQUOISE", 1),
            new ScreenField("INTRT", 8, 23, 7, true, true, false, false, false, "0000.00", "GREEN", 1),
            new ScreenField(null, 8, 31, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 9, 1, 18, false, false, false, false, false, "Overdraft Limit  :", "TURQUOISE", 1),
            new ScreenField("OVERDR", 9, 23, 8, true, true, false, false, false, "0", "GREEN", 1),
            new ScreenField(null, 9, 32, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 13, 1, 18, false, false, false, false, false, "Account number   :", "NEUTRAL", 1),
            new ScreenField("ACCNO", 13, 23, 8, false, false, false, false, false, "        ", "NEUTRAL", 1),
            new ScreenField(null, 14, 1, 18, false, false, false, false, false, "Sort code        :", "NEUTRAL", 1),
            new ScreenField("SRTCD", 14, 23, 6, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 15, 1, 18, false, false, false, false, false, "Account Opened   :", "NEUTRAL", 1),
            new ScreenField("OPENDD", 15, 23, 2, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 15, 26, 1, false, false, false, false, false, "/", "NEUTRAL", 1),
            new ScreenField("OPENMM", 15, 28, 2, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 15, 31, 1, false, false, false, false, false, "/", "NEUTRAL", 1),
            new ScreenField("OPENYY", 15, 33, 4, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 16, 1, 18, false, false, false, false, false, "Last Stmt Date   :", "NEUTRAL", 1),
            new ScreenField("LSTMDD", 16, 23, 2, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 16, 26, 1, false, false, false, false, false, "/", "NEUTRAL", 1),
            new ScreenField("LSTMMM", 16, 28, 2, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 16, 31, 1, false, false, false, false, false, "/", "NEUTRAL", 1),
            new ScreenField("LSTMYY", 16, 33, 4, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 17, 1, 18, false, false, false, false, false, "Next Stmt Date   :", "NEUTRAL", 1),
            new ScreenField("NSTMTDD", 17, 23, 2, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 17, 26, 1, false, false, false, false, false, "/", "NEUTRAL", 1),
            new ScreenField("NSTMTMM", 17, 28, 2, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 17, 31, 1, false, false, false, false, false, "/", "NEUTRAL", 1),
            new ScreenField("NSTMTYY", 17, 33, 4, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 18, 1, 18, false, false, false, false, false, "Available Balance:", "NEUTRAL", 1),
            new ScreenField("AVAIL", 18, 22, 14, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 19, 1, 18, false, false, false, false, false, "Actual Balance   :", "NEUTRAL", 1),
            new ScreenField("ACTBAL", 19, 22, 14, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField("MESSAGE", 23, 1, 79, false, false, true, false, false, null, "YELLOW", 1),
            new ScreenField(null, 24, 1, 20, false, false, false, false, false, "F3=Exit   F12=Cancel", "BLUE", 1),
            new ScreenField("DUMMY", 24, 79, 1, false, false, false, true, false, " ", null, 1));

    /** COMPANY: (1,18), 58 bytes, ATTRB=NORM,PROT -- src/base/bms_src/BNK1CAM.bms:28. Symbolic map COMPANYI, COMPANYO. */
    private String company;

    /** CUSTNO: (6,23), 10 bytes, ATTRB=FSET,NORM,NUM -- src/base/bms_src/BNK1CAM.bms:36. Symbolic map CUSTNOI, CUSTNOO. */
    private String custno;

    /** ACCTYP: (7,23), 8 bytes, ATTRB=FSET,NORM,UNPROT -- src/base/bms_src/BNK1CAM.bms:41. Symbolic map ACCTYPI, ACCTYPO. */
    private String acctyp;

    /** INTRT: (8,23), 7 bytes, ATTRB=FSET,NORM,NUM,UNPROT -- src/base/bms_src/BNK1CAM.bms:46. Symbolic map INTRTI, INTRTO. */
    private String intrt;

    /** OVERDR: (9,23), 8 bytes, ATTRB=FSET,NORM,NUM,UNPROT -- src/base/bms_src/BNK1CAM.bms:52. Symbolic map OVERDRI, OVERDRO. */
    private String overdr;

    /** ACCNO: (13,23), 8 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:58. Symbolic map ACCNOI, ACCNOO. */
    private String accno;

    /** SRTCD: (14,23), 6 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:62. Symbolic map SRTCDI, SRTCDO. */
    private String srtcd;

    /** OPENDD: (15,23), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:66. Symbolic map OPENDDI, OPENDDO. */
    private String opendd;

    /** OPENMM: (15,28), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:70. Symbolic map OPENMMI, OPENMMO. */
    private String openmm;

    /** OPENYY: (15,33), 4 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:74. Symbolic map OPENYYI, OPENYYO. */
    private String openyy;

    /** LSTMDD: (16,23), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:78. Symbolic map LSTMDDI, LSTMDDO. */
    private String lstmdd;

    /** LSTMMM: (16,28), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:82. Symbolic map LSTMMMI, LSTMMMO. */
    private String lstmmm;

    /** LSTMYY: (16,33), 4 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:86. Symbolic map LSTMYYI, LSTMYYO. */
    private String lstmyy;

    /** NSTMTDD: (17,23), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:90. Symbolic map NSTMTDDI, NSTMTDDO. */
    private String nstmtdd;

    /** NSTMTMM: (17,28), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:94. Symbolic map NSTMTMMI, NSTMTMMO. */
    private String nstmtmm;

    /** NSTMTYY: (17,33), 4 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:98. Symbolic map NSTMTYYI, NSTMTYYO. */
    private String nstmtyy;

    /** AVAIL: (18,22), 14 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:102. Symbolic map AVAILI, AVAILO. */
    private String avail;

    /** ACTBAL: (19,22), 14 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1CAM.bms:106. Symbolic map ACTBALI, ACTBALO. */
    private String actbal;

    /** MESSAGE: (23,1), 79 bytes, ATTRB=BRT,PROT -- src/base/bms_src/BNK1CAM.bms:109. Symbolic map MESSAGEI, MESSAGEO. */
    private String message;

    /** DUMMY: (24,79), 1 bytes, ATTRB=DRK,FSET,PROT -- src/base/bms_src/BNK1CAM.bms:112. Symbolic map DUMMYI, DUMMYO. */
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
        values.put("CUSTNO", custno);
        values.put("ACCTYP", acctyp);
        values.put("INTRT", intrt);
        values.put("OVERDR", overdr);
        values.put("ACCNO", accno);
        values.put("SRTCD", srtcd);
        values.put("OPENDD", opendd);
        values.put("OPENMM", openmm);
        values.put("OPENYY", openyy);
        values.put("LSTMDD", lstmdd);
        values.put("LSTMMM", lstmmm);
        values.put("LSTMYY", lstmyy);
        values.put("NSTMTDD", nstmtdd);
        values.put("NSTMTMM", nstmtmm);
        values.put("NSTMTYY", nstmtyy);
        values.put("AVAIL", avail);
        values.put("ACTBAL", actbal);
        values.put("MESSAGE", message);
        values.put("DUMMY", dummy);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Bnk1caScreen fromValues(Map<String, String> values) {
        Bnk1caScreen screen = new Bnk1caScreen();
        screen.setCompany(values.get("COMPANY"));
        screen.setCustno(values.get("CUSTNO"));
        screen.setAcctyp(values.get("ACCTYP"));
        screen.setIntrt(values.get("INTRT"));
        screen.setOverdr(values.get("OVERDR"));
        screen.setAccno(values.get("ACCNO"));
        screen.setSrtcd(values.get("SRTCD"));
        screen.setOpendd(values.get("OPENDD"));
        screen.setOpenmm(values.get("OPENMM"));
        screen.setOpenyy(values.get("OPENYY"));
        screen.setLstmdd(values.get("LSTMDD"));
        screen.setLstmmm(values.get("LSTMMM"));
        screen.setLstmyy(values.get("LSTMYY"));
        screen.setNstmtdd(values.get("NSTMTDD"));
        screen.setNstmtmm(values.get("NSTMTMM"));
        screen.setNstmtyy(values.get("NSTMTYY"));
        screen.setAvail(values.get("AVAIL"));
        screen.setActbal(values.get("ACTBAL"));
        screen.setMessage(values.get("MESSAGE"));
        screen.setDummy(values.get("DUMMY"));
        return screen;
    }
}
