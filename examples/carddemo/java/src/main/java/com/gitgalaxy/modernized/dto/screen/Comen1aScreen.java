package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map COMEN1A of mapset COMEN01 (app/bms/COMEN01.bms): the screen as a view model (#3619).
 * SEND at app/cbl/COMEN01C.cbl:215; RECEIVE at app/cbl/COMEN01C.cbl:227.
 * One property per named field (symbolic map COMEN1AI / COMEN1AO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Comen1aScreen implements ScreenModel {

    public static final String MAPSET = "COMEN01";
    public static final String MAP = "COMEN1A";
    public static final List<ScreenField> LAYOUT = List.of(
            new ScreenField(null, 1, 1, 5, false, false, false, false, false, "Tran:", "BLUE", 1),
            new ScreenField("TRNNAME", 1, 7, 4, false, false, false, false, false, null, "BLUE", 1),
            new ScreenField("TITLE01", 1, 21, 40, false, false, false, false, false, null, "YELLOW", 1),
            new ScreenField(null, 1, 65, 5, false, false, false, false, false, "Date:", "BLUE", 1),
            new ScreenField("CURDATE", 1, 71, 8, false, false, false, false, false, "mm/dd/yy", "BLUE", 1),
            new ScreenField(null, 2, 1, 5, false, false, false, false, false, "Prog:", "BLUE", 1),
            new ScreenField("PGMNAME", 2, 7, 8, false, false, false, false, false, null, "BLUE", 1),
            new ScreenField("TITLE02", 2, 21, 40, false, false, false, false, false, null, "YELLOW", 1),
            new ScreenField(null, 2, 65, 5, false, false, false, false, false, "Time:", "BLUE", 1),
            new ScreenField("CURTIME", 2, 71, 8, false, false, false, false, false, "hh:mm:ss", "BLUE", 1),
            new ScreenField(null, 4, 35, 9, false, false, true, false, false, "Main Menu", "NEUTRAL", 1),
            new ScreenField("OPTN001", 6, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("OPTN002", 7, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("OPTN003", 8, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("OPTN004", 9, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("OPTN005", 10, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("OPTN006", 11, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("OPTN007", 12, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("OPTN008", 13, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("OPTN009", 14, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("OPTN010", 15, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("OPTN011", 16, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("OPTN012", 17, 20, 40, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 20, 15, 25, false, false, true, false, false, "Please select an option :", "TURQUOISE", 1),
            new ScreenField("OPTION", 20, 41, 2, true, true, false, false, true, null, null, 1),
            new ScreenField(null, 20, 44, 0, false, false, false, false, false, null, "GREEN", 1),
            new ScreenField("ERRMSG", 23, 1, 78, false, false, true, false, false, null, "RED", 1),
            new ScreenField(null, 24, 1, 23, false, false, false, false, false, "ENTER=Continue  F3=Exit", "YELLOW", 1));

    /** TRNNAME: (1,7), 4 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:34. Symbolic map TRNNAMEI, TRNNAMEO. */
    private String trnname;

    /** TITLE01: (1,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:38. Symbolic map TITLE01I, TITLE01O. */
    private String title01;

    /** CURDATE: (1,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:47. Symbolic map CURDATEI, CURDATEO. */
    private String curdate;

    /** PGMNAME: (2,7), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:57. Symbolic map PGMNAMEI, PGMNAMEO. */
    private String pgmname;

    /** TITLE02: (2,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:61. Symbolic map TITLE02I, TITLE02O. */
    private String title02;

    /** CURTIME: (2,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:70. Symbolic map CURTIMEI, CURTIMEO. */
    private String curtime;

    /** OPTN001: (6,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:80. Symbolic map OPTN001I, OPTN001O. */
    private String optn001;

    /** OPTN002: (7,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:85. Symbolic map OPTN002I, OPTN002O. */
    private String optn002;

    /** OPTN003: (8,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:90. Symbolic map OPTN003I, OPTN003O. */
    private String optn003;

    /** OPTN004: (9,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:95. Symbolic map OPTN004I, OPTN004O. */
    private String optn004;

    /** OPTN005: (10,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:100. Symbolic map OPTN005I, OPTN005O. */
    private String optn005;

    /** OPTN006: (11,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:105. Symbolic map OPTN006I, OPTN006O. */
    private String optn006;

    /** OPTN007: (12,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:110. Symbolic map OPTN007I, OPTN007O. */
    private String optn007;

    /** OPTN008: (13,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:115. Symbolic map OPTN008I, OPTN008O. */
    private String optn008;

    /** OPTN009: (14,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:120. Symbolic map OPTN009I, OPTN009O. */
    private String optn009;

    /** OPTN010: (15,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:125. Symbolic map OPTN010I, OPTN010O. */
    private String optn010;

    /** OPTN011: (16,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:130. Symbolic map OPTN011I, OPTN011O. */
    private String optn011;

    /** OPTN012: (17,20), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COMEN01.bms:135. Symbolic map OPTN012I, OPTN012O. */
    private String optn012;

    /** OPTION: (20,41), 2 bytes, ATTRB=FSET,IC,NORM,NUM,UNPROT -- app/bms/COMEN01.bms:145. Symbolic map OPTIONI, OPTIONO. */
    private String option;

    /** ERRMSG: (23,1), 78 bytes, ATTRB=ASKIP,BRT,FSET -- app/bms/COMEN01.bms:154. Symbolic map ERRMSGI, ERRMSGO. */
    private String errmsg;

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
        values.put("TRNNAME", trnname);
        values.put("TITLE01", title01);
        values.put("CURDATE", curdate);
        values.put("PGMNAME", pgmname);
        values.put("TITLE02", title02);
        values.put("CURTIME", curtime);
        values.put("OPTN001", optn001);
        values.put("OPTN002", optn002);
        values.put("OPTN003", optn003);
        values.put("OPTN004", optn004);
        values.put("OPTN005", optn005);
        values.put("OPTN006", optn006);
        values.put("OPTN007", optn007);
        values.put("OPTN008", optn008);
        values.put("OPTN009", optn009);
        values.put("OPTN010", optn010);
        values.put("OPTN011", optn011);
        values.put("OPTN012", optn012);
        values.put("OPTION", option);
        values.put("ERRMSG", errmsg);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Comen1aScreen fromValues(Map<String, String> values) {
        Comen1aScreen screen = new Comen1aScreen();
        screen.setTrnname(values.get("TRNNAME"));
        screen.setTitle01(values.get("TITLE01"));
        screen.setCurdate(values.get("CURDATE"));
        screen.setPgmname(values.get("PGMNAME"));
        screen.setTitle02(values.get("TITLE02"));
        screen.setCurtime(values.get("CURTIME"));
        screen.setOptn001(values.get("OPTN001"));
        screen.setOptn002(values.get("OPTN002"));
        screen.setOptn003(values.get("OPTN003"));
        screen.setOptn004(values.get("OPTN004"));
        screen.setOptn005(values.get("OPTN005"));
        screen.setOptn006(values.get("OPTN006"));
        screen.setOptn007(values.get("OPTN007"));
        screen.setOptn008(values.get("OPTN008"));
        screen.setOptn009(values.get("OPTN009"));
        screen.setOptn010(values.get("OPTN010"));
        screen.setOptn011(values.get("OPTN011"));
        screen.setOptn012(values.get("OPTN012"));
        screen.setOption(values.get("OPTION"));
        screen.setErrmsg(values.get("ERRMSG"));
        return screen;
    }
}
