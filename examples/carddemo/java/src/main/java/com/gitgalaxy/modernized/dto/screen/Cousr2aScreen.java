package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map COUSR2A of mapset COUSR02 (app/bms/COUSR02.bms): the screen as a view model (#3619).
 * SEND at app/cbl/COUSR02C.cbl:272; RECEIVE at app/cbl/COUSR02C.cbl:285.
 * One property per named field (symbolic map COUSR2AI / COUSR2AO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Cousr2aScreen implements ScreenModel {

    public static final String MAPSET = "COUSR02";
    public static final String MAP = "COUSR2A";
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
            new ScreenField(null, 4, 35, 11, false, false, true, false, false, "Update User", "NEUTRAL", 1),
            new ScreenField(null, 6, 6, 14, false, false, false, false, false, "Enter User ID:", "GREEN", 1),
            new ScreenField("USRIDIN", 6, 21, 8, true, false, false, false, true, null, "GREEN", 1),
            new ScreenField(null, 6, 30, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 8, 6, 70, false, false, false, false, false, "**********************************************************************", "YELLOW", 1),
            new ScreenField(null, 11, 6, 11, false, false, false, false, false, "First Name:", "TURQUOISE", 1),
            new ScreenField("FNAME", 11, 18, 20, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 11, 39, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 11, 45, 10, false, false, false, false, false, "Last Name:", "TURQUOISE", 1),
            new ScreenField("LNAME", 11, 56, 20, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 11, 77, 0, false, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 13, 6, 9, false, false, false, false, false, "Password:", "TURQUOISE", 1),
            new ScreenField("PASSWD", 13, 16, 8, true, false, false, true, false, null, "GREEN", 1),
            new ScreenField(null, 13, 25, 8, false, false, false, false, false, "(8 Char)", "BLUE", 1),
            new ScreenField(null, 15, 6, 11, false, false, false, false, false, "User Type: ", "TURQUOISE", 1),
            new ScreenField("USRTYPE", 15, 17, 1, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 15, 19, 17, false, false, false, false, false, "(A=Admin, U=User)", "BLUE", 1),
            new ScreenField("ERRMSG", 23, 1, 78, false, false, true, false, false, null, "RED", 1),
            new ScreenField(null, 24, 1, 58, false, false, false, false, false, "ENTER=Fetch  F3=Save&Exit  F4=Clear  F5=Save  F12=Cancel", "YELLOW", 1));

    /** TRNNAME: (1,7), 4 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR02.bms:34. Symbolic map TRNNAMEI, TRNNAMEO. */
    private String trnname;

    /** TITLE01: (1,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR02.bms:38. Symbolic map TITLE01I, TITLE01O. */
    private String title01;

    /** CURDATE: (1,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR02.bms:47. Symbolic map CURDATEI, CURDATEO. */
    private String curdate;

    /** PGMNAME: (2,7), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR02.bms:57. Symbolic map PGMNAMEI, PGMNAMEO. */
    private String pgmname;

    /** TITLE02: (2,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR02.bms:61. Symbolic map TITLE02I, TITLE02O. */
    private String title02;

    /** CURTIME: (2,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR02.bms:70. Symbolic map CURTIMEI, CURTIMEO. */
    private String curtime;

    /** USRIDIN: (6,21), 8 bytes, ATTRB=FSET,IC,NORM,UNPROT -- app/bms/COUSR02.bms:85. Symbolic map USRIDINI, USRIDINO. */
    private String usridin;

    /** FNAME: (11,18), 20 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR02.bms:103. Symbolic map FNAMEI, FNAMEO. */
    private String fname;

    /** LNAME: (11,56), 20 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR02.bms:116. Symbolic map LNAMEI, LNAMEO. */
    private String lname;

    /** PASSWD: (13,16), 8 bytes, ATTRB=DRK,FSET,UNPROT -- app/bms/COUSR02.bms:130. Symbolic map PASSWDI, PASSWDO. */
    private String passwd;

    /** USRTYPE: (15,17), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR02.bms:145. Symbolic map USRTYPEI, USRTYPEO. */
    private String usrtype;

    /** ERRMSG: (23,1), 78 bytes, ATTRB=ASKIP,BRT,FSET -- app/bms/COUSR02.bms:155. Symbolic map ERRMSGI, ERRMSGO. */
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
        values.put("USRIDIN", usridin);
        values.put("FNAME", fname);
        values.put("LNAME", lname);
        values.put("PASSWD", passwd);
        values.put("USRTYPE", usrtype);
        values.put("ERRMSG", errmsg);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Cousr2aScreen fromValues(Map<String, String> values) {
        Cousr2aScreen screen = new Cousr2aScreen();
        screen.setTrnname(values.get("TRNNAME"));
        screen.setTitle01(values.get("TITLE01"));
        screen.setCurdate(values.get("CURDATE"));
        screen.setPgmname(values.get("PGMNAME"));
        screen.setTitle02(values.get("TITLE02"));
        screen.setCurtime(values.get("CURTIME"));
        screen.setUsridin(values.get("USRIDIN"));
        screen.setFname(values.get("FNAME"));
        screen.setLname(values.get("LNAME"));
        screen.setPasswd(values.get("PASSWD"));
        screen.setUsrtype(values.get("USRTYPE"));
        screen.setErrmsg(values.get("ERRMSG"));
        return screen;
    }
}
