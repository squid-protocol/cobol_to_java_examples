package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map COBIL0A of mapset COBIL00 (app/bms/COBIL00.bms): the screen as a view model (#3619).
 * SEND at app/cbl/COBIL00C.cbl:295; RECEIVE at app/cbl/COBIL00C.cbl:308.
 * One property per named field (symbolic map COBIL0AI / COBIL0AO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Cobil0aScreen implements ScreenModel {

    public static final String MAPSET = "COBIL00";
    public static final String MAP = "COBIL0A";
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
            new ScreenField(null, 4, 35, 12, false, false, true, false, false, "Bill Payment", "NEUTRAL", 1),
            new ScreenField(null, 6, 6, 14, false, false, false, false, false, "Enter Acct ID:", "GREEN", 1),
            new ScreenField("ACTIDIN", 6, 21, 11, true, false, false, false, true, null, "GREEN", 1),
            new ScreenField(null, 6, 33, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 8, 6, 70, false, false, false, false, false, "----------------------------------------------------------------------", "YELLOW", 1),
            new ScreenField(null, 11, 6, 25, false, false, false, false, false, "Your current balance is: ", "TURQUOISE", 1),
            new ScreenField("CURBAL", 11, 32, 14, false, false, false, false, false, null, "BLUE", 1),
            new ScreenField(null, 11, 47, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 15, 6, 53, false, false, false, false, false, "Do you want to pay your balance now. Please confirm: ", "TURQUOISE", 1),
            new ScreenField("CONFIRM", 15, 60, 1, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 15, 62, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 15, 63, 5, false, false, false, false, false, "(Y/N)", "NEUTRAL", 1),
            new ScreenField("ERRMSG", 23, 1, 78, false, false, true, false, false, null, "RED", 1),
            new ScreenField(null, 24, 1, 33, false, false, false, false, false, "ENTER=Continue  F3=Back  F4=Clear", "YELLOW", 1));

    /** TRNNAME: (1,7), 4 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COBIL00.bms:34. Symbolic map TRNNAMEI, TRNNAMEO. */
    private String trnname;

    /** TITLE01: (1,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COBIL00.bms:38. Symbolic map TITLE01I, TITLE01O. */
    private String title01;

    /** CURDATE: (1,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COBIL00.bms:47. Symbolic map CURDATEI, CURDATEO. */
    private String curdate;

    /** PGMNAME: (2,7), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COBIL00.bms:57. Symbolic map PGMNAMEI, PGMNAMEO. */
    private String pgmname;

    /** TITLE02: (2,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COBIL00.bms:61. Symbolic map TITLE02I, TITLE02O. */
    private String title02;

    /** CURTIME: (2,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COBIL00.bms:70. Symbolic map CURTIMEI, CURTIMEO. */
    private String curtime;

    /** ACTIDIN: (6,21), 11 bytes, ATTRB=FSET,IC,NORM,UNPROT -- app/bms/COBIL00.bms:85. Symbolic map ACTIDINI, ACTIDINO. */
    private String actidin;

    /** CURBAL: (11,32), 14 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COBIL00.bms:103. Symbolic map CURBALI, CURBALO. */
    private String curbal;

    /** CONFIRM: (15,60), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COBIL00.bms:115. Symbolic map CONFIRMI, CONFIRMO. */
    private String confirm;

    /** ERRMSG: (23,1), 78 bytes, ATTRB=ASKIP,BRT,FSET -- app/bms/COBIL00.bms:127. Symbolic map ERRMSGI, ERRMSGO. */
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
        values.put("ACTIDIN", actidin);
        values.put("CURBAL", curbal);
        values.put("CONFIRM", confirm);
        values.put("ERRMSG", errmsg);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Cobil0aScreen fromValues(Map<String, String> values) {
        Cobil0aScreen screen = new Cobil0aScreen();
        screen.setTrnname(values.get("TRNNAME"));
        screen.setTitle01(values.get("TITLE01"));
        screen.setCurdate(values.get("CURDATE"));
        screen.setPgmname(values.get("PGMNAME"));
        screen.setTitle02(values.get("TITLE02"));
        screen.setCurtime(values.get("CURTIME"));
        screen.setActidin(values.get("ACTIDIN"));
        screen.setCurbal(values.get("CURBAL"));
        screen.setConfirm(values.get("CONFIRM"));
        screen.setErrmsg(values.get("ERRMSG"));
        return screen;
    }
}
