package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map BNK1UA of mapset BNK1UAM (src/base/bms_src/BNK1UAM.bms): the screen as a view model (#3619).
 * SEND at src/base/cobol_src/BNK1UAC.cbl:1074, src/base/cobol_src/BNK1UAC.cbl:1150, src/base/cobol_src/BNK1UAC.cbl:1225; RECEIVE at src/base/cobol_src/BNK1UAC.cbl:419.
 * One property per named field (symbolic map BNK1UAI / BNK1UAO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1uaScreen implements ScreenModel {

    public static final String MAPSET = "BNK1UAM";
    public static final String MAP = "BNK1UA";
    public static final List<ScreenField> LAYOUT = List.of(
            new ScreenField(null, 1, 1, 7, false, false, false, false, false, "BNK1UA ", "BLUE", 1),
            new ScreenField("COMPANY", 1, 17, 52, false, false, false, false, false, "CICS Bank Sample Application - Update Account.", "RED", 1),
            new ScreenField(null, 3, 1, 34, false, false, false, false, false, "Please provide an ACCOUNT number.", "TURQUOISE", 1),
            new ScreenField(null, 5, 1, 15, false, false, false, false, false, "ACCOUNT NUMBER", "TURQUOISE", 1),
            new ScreenField("ACCNO", 5, 17, 8, true, true, false, false, true, null, "GREEN", 1),
            new ScreenField(null, 5, 26, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 7, 1, 18, false, false, false, false, false, " Customer Number:", "NEUTRAL", 1),
            new ScreenField("CUSTNO", 7, 20, 10, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 7, 32, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 8, 1, 18, false, false, false, false, false, " Sort Code      :", "NEUTRAL", 1),
            new ScreenField("SORTC", 8, 20, 6, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 8, 27, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 9, 1, 18, false, false, false, false, false, " Account Number :", "NEUTRAL", 1),
            new ScreenField("ACCNO2", 9, 20, 8, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 9, 32, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 10, 1, 18, false, false, false, false, false, " Account Type   :", "NEUTRAL", 1),
            new ScreenField("ACTYPE", 10, 20, 8, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 10, 29, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 11, 1, 18, false, false, false, false, false, " Interest Rate  :", "NEUTRAL", 1),
            new ScreenField("INTRT", 11, 20, 7, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 11, 28, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 12, 1, 18, false, false, false, false, false, " Account Opened :", "NEUTRAL", 1),
            new ScreenField("OPENDD", 12, 20, 2, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 12, 23, 1, false, false, false, false, false, "/", "TURQUOISE", 1),
            new ScreenField("OPENMM", 12, 25, 2, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 12, 28, 1, false, false, false, false, false, "/", "TURQUOISE", 1),
            new ScreenField("OPENYY", 12, 30, 4, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 13, 1, 18, false, false, false, false, false, " Overdraft limit:", "NEUTRAL", 1),
            new ScreenField("OVERDR", 13, 20, 8, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 13, 29, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 14, 1, 18, false, false, false, false, false, " Last statement :", "NEUTRAL", 1),
            new ScreenField("LSTMTDD", 14, 20, 2, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 14, 23, 1, false, false, false, false, false, "/", "TURQUOISE", 1),
            new ScreenField("LSTMTMM", 14, 25, 2, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 14, 28, 1, false, false, false, false, false, "/", "TURQUOISE", 1),
            new ScreenField("LSTMTYY", 14, 30, 4, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 14, 35, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 15, 1, 18, false, false, false, false, false, " Next statement :", "NEUTRAL", 1),
            new ScreenField("NSTMTDD", 15, 20, 2, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 15, 23, 1, false, false, false, false, false, "/", "NEUTRAL", 1),
            new ScreenField("NSTMTMM", 15, 25, 2, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 15, 28, 1, false, false, false, false, false, "/", "NEUTRAL", 1),
            new ScreenField("NSTMTYY", 15, 30, 4, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 16, 1, 17, false, false, false, false, false, " Available Bal  :", "NEUTRAL", 1),
            new ScreenField("AVBAL", 16, 19, 14, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField(null, 17, 1, 17, false, false, false, false, false, " Actual Balance :", "NEUTRAL", 1),
            new ScreenField("ACTBAL", 17, 19, 14, false, false, false, false, false, null, "TURQUOISE", 1),
            new ScreenField("MESSAGE", 23, 1, 79, false, false, true, false, false, null, "YELLOW", 1),
            new ScreenField(null, 24, 1, 20, false, false, false, false, false, "F3=Exit   F12=Cancel", "BLUE", 1),
            new ScreenField("DUMMY", 24, 79, 1, false, false, false, true, false, " ", null, 1));

    /** COMPANY: (1,17), 52 bytes, ATTRB=NORM,PROT -- src/base/bms_src/BNK1UAM.bms:28. Symbolic map COMPANYI, COMPANYO. */
    private String company;

    /** ACCNO: (5,17), 8 bytes, ATTRB=IC,NORM,NUM,UNPROT -- src/base/bms_src/BNK1UAM.bms:35. Symbolic map ACCNOI, ACCNOO. */
    private String accno;

    /** CUSTNO: (7,20), 10 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:41. Symbolic map CUSTNOI, CUSTNOO. */
    private String custno;

    /** SORTC: (8,20), 6 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:46. Symbolic map SORTCI, SORTCO. */
    private String sortc;

    /** ACCNO2: (9,20), 8 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:51. Symbolic map ACCNO2I, ACCNO2O. */
    private String accno2;

    /** ACTYPE: (10,20), 8 bytes, ATTRB=FSET,NORM,UNPROT -- src/base/bms_src/BNK1UAM.bms:56. Symbolic map ACTYPEI, ACTYPEO. */
    private String actype;

    /** INTRT: (11,20), 7 bytes, ATTRB=FSET,NORM,UNPROT; PICIN=- PICOUT=9999.99 -- src/base/bms_src/BNK1UAM.bms:61. Symbolic map INTRTI, INTRTO. */
    private String intrt;

    /** OPENDD: (12,20), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:67. Symbolic map OPENDDI, OPENDDO. */
    private String opendd;

    /** OPENMM: (12,25), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:71. Symbolic map OPENMMI, OPENMMO. */
    private String openmm;

    /** OPENYY: (12,30), 4 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:75. Symbolic map OPENYYI, OPENYYO. */
    private String openyy;

    /** OVERDR: (13,20), 8 bytes, ATTRB=FSET,NORM,UNPROT -- src/base/bms_src/BNK1UAM.bms:79. Symbolic map OVERDRI, OVERDRO. */
    private String overdr;

    /** LSTMTDD: (14,20), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:84. Symbolic map LSTMTDDI, LSTMTDDO. */
    private String lstmtdd;

    /** LSTMTMM: (14,25), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:88. Symbolic map LSTMTMMI, LSTMTMMO. */
    private String lstmtmm;

    /** LSTMTYY: (14,30), 4 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:92. Symbolic map LSTMTYYI, LSTMTYYO. */
    private String lstmtyy;

    /** NSTMTDD: (15,20), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:97. Symbolic map NSTMTDDI, NSTMTDDO. */
    private String nstmtdd;

    /** NSTMTMM: (15,25), 2 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:101. Symbolic map NSTMTMMI, NSTMTMMO. */
    private String nstmtmm;

    /** NSTMTYY: (15,30), 4 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:105. Symbolic map NSTMTYYI, NSTMTYYO. */
    private String nstmtyy;

    /** AVBAL: (16,19), 14 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:109. Symbolic map AVBALI, AVBALO. */
    private String avbal;

    /** ACTBAL: (17,19), 14 bytes, ATTRB=FSET,NORM,PROT -- src/base/bms_src/BNK1UAM.bms:113. Symbolic map ACTBALI, ACTBALO. */
    private String actbal;

    /** MESSAGE: (23,1), 79 bytes, ATTRB=BRT,PROT -- src/base/bms_src/BNK1UAM.bms:116. Symbolic map MESSAGEI, MESSAGEO. */
    private String message;

    /** DUMMY: (24,79), 1 bytes, ATTRB=DRK,FSET,PROT -- src/base/bms_src/BNK1UAM.bms:119. Symbolic map DUMMYI, DUMMYO. */
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
        values.put("CUSTNO", custno);
        values.put("SORTC", sortc);
        values.put("ACCNO2", accno2);
        values.put("ACTYPE", actype);
        values.put("INTRT", intrt);
        values.put("OPENDD", opendd);
        values.put("OPENMM", openmm);
        values.put("OPENYY", openyy);
        values.put("OVERDR", overdr);
        values.put("LSTMTDD", lstmtdd);
        values.put("LSTMTMM", lstmtmm);
        values.put("LSTMTYY", lstmtyy);
        values.put("NSTMTDD", nstmtdd);
        values.put("NSTMTMM", nstmtmm);
        values.put("NSTMTYY", nstmtyy);
        values.put("AVBAL", avbal);
        values.put("ACTBAL", actbal);
        values.put("MESSAGE", message);
        values.put("DUMMY", dummy);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Bnk1uaScreen fromValues(Map<String, String> values) {
        Bnk1uaScreen screen = new Bnk1uaScreen();
        screen.setCompany(values.get("COMPANY"));
        screen.setAccno(values.get("ACCNO"));
        screen.setCustno(values.get("CUSTNO"));
        screen.setSortc(values.get("SORTC"));
        screen.setAccno2(values.get("ACCNO2"));
        screen.setActype(values.get("ACTYPE"));
        screen.setIntrt(values.get("INTRT"));
        screen.setOpendd(values.get("OPENDD"));
        screen.setOpenmm(values.get("OPENMM"));
        screen.setOpenyy(values.get("OPENYY"));
        screen.setOverdr(values.get("OVERDR"));
        screen.setLstmtdd(values.get("LSTMTDD"));
        screen.setLstmtmm(values.get("LSTMTMM"));
        screen.setLstmtyy(values.get("LSTMTYY"));
        screen.setNstmtdd(values.get("NSTMTDD"));
        screen.setNstmtmm(values.get("NSTMTMM"));
        screen.setNstmtyy(values.get("NSTMTYY"));
        screen.setAvbal(values.get("AVBAL"));
        screen.setActbal(values.get("ACTBAL"));
        screen.setMessage(values.get("MESSAGE"));
        screen.setDummy(values.get("DUMMY"));
        return screen;
    }
}
