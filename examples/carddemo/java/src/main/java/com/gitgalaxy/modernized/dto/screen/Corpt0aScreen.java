package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map CORPT0A of mapset CORPT00 (app/bms/CORPT00.bms): the screen as a view model (#3619).
 * SEND at app/cbl/CORPT00C.cbl:563, app/cbl/CORPT00C.cbl:571; RECEIVE at app/cbl/CORPT00C.cbl:598.
 * One property per named field (symbolic map CORPT0AI / CORPT0AO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Corpt0aScreen implements ScreenModel {

    public static final String MAPSET = "CORPT00";
    public static final String MAP = "CORPT0A";
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
            new ScreenField(null, 4, 30, 19, false, false, true, false, false, "Transaction Reports", "NEUTRAL", 1),
            new ScreenField("MONTHLY", 7, 10, 1, true, false, false, false, true, " ", "GREEN", 1),
            new ScreenField(null, 7, 12, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 7, 15, 23, false, false, true, false, false, "Monthly (Current Month)", "TURQUOISE", 1),
            new ScreenField("YEARLY", 9, 10, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 9, 12, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 9, 15, 23, false, false, true, false, false, "Yearly (Current Year)", "TURQUOISE", 1),
            new ScreenField("CUSTOM", 11, 10, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 11, 12, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 11, 15, 23, false, false, true, false, false, "Custom (Date Range)", "TURQUOISE", 1),
            new ScreenField(null, 13, 15, 12, false, false, false, false, false, "Start Date :", "TURQUOISE", 1),
            new ScreenField("SDTMM", 13, 29, 2, true, true, false, false, false, "  ", "GREEN", 1),
            new ScreenField(null, 13, 32, 1, false, false, false, false, false, "/", "BLUE", 1),
            new ScreenField("SDTDD", 13, 34, 2, true, true, false, false, false, "  ", "GREEN", 1),
            new ScreenField(null, 13, 37, 1, false, false, false, false, false, "/", "BLUE", 1),
            new ScreenField("SDTYYYY", 13, 39, 4, true, true, false, false, false, "    ", "GREEN", 1),
            new ScreenField(null, 13, 44, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 13, 46, 12, false, false, false, false, false, "(MM/DD/YYYY)", "BLUE", 1),
            new ScreenField(null, 14, 15, 12, false, false, false, false, false, "  End Date :", "TURQUOISE", 1),
            new ScreenField("EDTMM", 14, 29, 2, true, true, false, false, false, "  ", "GREEN", 1),
            new ScreenField(null, 14, 32, 1, false, false, false, false, false, "/", "BLUE", 1),
            new ScreenField("EDTDD", 14, 34, 2, true, true, false, false, false, "  ", "GREEN", 1),
            new ScreenField(null, 14, 37, 1, false, false, false, false, false, "/", "BLUE", 1),
            new ScreenField("EDTYYYY", 14, 39, 4, true, true, false, false, false, "    ", "GREEN", 1),
            new ScreenField(null, 14, 44, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 14, 46, 12, false, false, false, false, false, "(MM/DD/YYYY)", "BLUE", 1),
            new ScreenField(null, 19, 6, 59, false, false, false, false, false, "The Report will be submitted for printing. Please confirm: ", "TURQUOISE", 1),
            new ScreenField("CONFIRM", 19, 66, 1, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 19, 68, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 19, 69, 5, false, false, false, false, false, "(Y/N)", "NEUTRAL", 1),
            new ScreenField("ERRMSG", 23, 1, 78, false, false, true, false, false, null, "RED", 1),
            new ScreenField(null, 24, 1, 23, false, false, false, false, false, "ENTER=Continue  F3=Back", "YELLOW", 1));

    /** TRNNAME: (1,7), 4 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/CORPT00.bms:34. Symbolic map TRNNAMEI, TRNNAMEO. */
    private String trnname;

    /** TITLE01: (1,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/CORPT00.bms:38. Symbolic map TITLE01I, TITLE01O. */
    private String title01;

    /** CURDATE: (1,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/CORPT00.bms:47. Symbolic map CURDATEI, CURDATEO. */
    private String curdate;

    /** PGMNAME: (2,7), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/CORPT00.bms:57. Symbolic map PGMNAMEI, PGMNAMEO. */
    private String pgmname;

    /** TITLE02: (2,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/CORPT00.bms:61. Symbolic map TITLE02I, TITLE02O. */
    private String title02;

    /** CURTIME: (2,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/CORPT00.bms:70. Symbolic map CURTIMEI, CURTIMEO. */
    private String curtime;

    /** MONTHLY: (7,10), 1 bytes, ATTRB=FSET,IC,NORM,UNPROT -- app/bms/CORPT00.bms:80. Symbolic map MONTHLYI, MONTHLYO. */
    private String monthly;

    /** YEARLY: (9,10), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/CORPT00.bms:94. Symbolic map YEARLYI, YEARLYO. */
    private String yearly;

    /** CUSTOM: (11,10), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/CORPT00.bms:108. Symbolic map CUSTOMI, CUSTOMO. */
    private String custom;

    /** SDTMM: (13,29), 2 bytes, ATTRB=FSET,NORM,NUM,UNPROT -- app/bms/CORPT00.bms:127. Symbolic map SDTMMI, SDTMMO. */
    private String sdtmm;

    /** SDTDD: (13,34), 2 bytes, ATTRB=FSET,NORM,NUM,UNPROT -- app/bms/CORPT00.bms:138. Symbolic map SDTDDI, SDTDDO. */
    private String sdtdd;

    /** SDTYYYY: (13,39), 4 bytes, ATTRB=FSET,NORM,NUM,UNPROT -- app/bms/CORPT00.bms:149. Symbolic map SDTYYYYI, SDTYYYYO. */
    private String sdtyyyy;

    /** EDTMM: (14,29), 2 bytes, ATTRB=FSET,NORM,NUM,UNPROT -- app/bms/CORPT00.bms:166. Symbolic map EDTMMI, EDTMMO. */
    private String edtmm;

    /** EDTDD: (14,34), 2 bytes, ATTRB=FSET,NORM,NUM,UNPROT -- app/bms/CORPT00.bms:177. Symbolic map EDTDDI, EDTDDO. */
    private String edtdd;

    /** EDTYYYY: (14,39), 4 bytes, ATTRB=FSET,NORM,NUM,UNPROT -- app/bms/CORPT00.bms:188. Symbolic map EDTYYYYI, EDTYYYYO. */
    private String edtyyyy;

    /** CONFIRM: (19,66), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/CORPT00.bms:206. Symbolic map CONFIRMI, CONFIRMO. */
    private String confirm;

    /** ERRMSG: (23,1), 78 bytes, ATTRB=ASKIP,BRT,FSET -- app/bms/CORPT00.bms:218. Symbolic map ERRMSGI, ERRMSGO. */
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
        values.put("MONTHLY", monthly);
        values.put("YEARLY", yearly);
        values.put("CUSTOM", custom);
        values.put("SDTMM", sdtmm);
        values.put("SDTDD", sdtdd);
        values.put("SDTYYYY", sdtyyyy);
        values.put("EDTMM", edtmm);
        values.put("EDTDD", edtdd);
        values.put("EDTYYYY", edtyyyy);
        values.put("CONFIRM", confirm);
        values.put("ERRMSG", errmsg);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Corpt0aScreen fromValues(Map<String, String> values) {
        Corpt0aScreen screen = new Corpt0aScreen();
        screen.setTrnname(values.get("TRNNAME"));
        screen.setTitle01(values.get("TITLE01"));
        screen.setCurdate(values.get("CURDATE"));
        screen.setPgmname(values.get("PGMNAME"));
        screen.setTitle02(values.get("TITLE02"));
        screen.setCurtime(values.get("CURTIME"));
        screen.setMonthly(values.get("MONTHLY"));
        screen.setYearly(values.get("YEARLY"));
        screen.setCustom(values.get("CUSTOM"));
        screen.setSdtmm(values.get("SDTMM"));
        screen.setSdtdd(values.get("SDTDD"));
        screen.setSdtyyyy(values.get("SDTYYYY"));
        screen.setEdtmm(values.get("EDTMM"));
        screen.setEdtdd(values.get("EDTDD"));
        screen.setEdtyyyy(values.get("EDTYYYY"));
        screen.setConfirm(values.get("CONFIRM"));
        screen.setErrmsg(values.get("ERRMSG"));
        return screen;
    }
}
