package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map COUSR1A of mapset COUSR01 (app/bms/COUSR01.bms): the screen as a view model (#3619).
 * SEND at app/cbl/COUSR01C.cbl:190; RECEIVE at app/cbl/COUSR01C.cbl:203.
 * One property per named field (symbolic map COUSR1AI / COUSR1AO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Cousr1aScreen implements ScreenModel {

    public static final String MAPSET = "COUSR01";
    public static final String MAP = "COUSR1A";
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
            new ScreenField(null, 4, 35, 9, false, false, true, false, false, "Add User", "NEUTRAL", 1),
            new ScreenField(null, 8, 6, 11, false, false, false, false, false, "First Name:", "TURQUOISE", 1),
            new ScreenField("FNAME", 8, 18, 20, true, false, false, false, true, null, "GREEN", 1),
            new ScreenField(null, 8, 39, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 8, 45, 10, false, false, false, false, false, "Last Name:", "TURQUOISE", 1),
            new ScreenField("LNAME", 8, 56, 20, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 8, 77, 0, false, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 11, 6, 8, false, false, false, false, false, "User ID:", "TURQUOISE", 1),
            new ScreenField("USERID", 11, 15, 8, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 11, 24, 8, false, false, false, false, false, "(8 Char)", "BLUE", 1),
            new ScreenField(null, 11, 45, 9, false, false, false, false, false, "Password:", "TURQUOISE", 1),
            new ScreenField("PASSWD", 11, 55, 8, true, false, false, true, false, null, "GREEN", 1),
            new ScreenField(null, 11, 64, 8, false, false, false, false, false, "(8 Char)", "BLUE", 1),
            new ScreenField(null, 14, 6, 11, false, false, false, false, false, "User Type: ", "TURQUOISE", 1),
            new ScreenField("USRTYPE", 14, 17, 1, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 14, 19, 17, false, false, false, false, false, "(A=Admin, U=User)", "BLUE", 1),
            new ScreenField("ERRMSG", 23, 1, 78, false, false, true, false, false, null, "RED", 1),
            new ScreenField(null, 24, 1, 43, false, false, false, false, false, "ENTER=Add User  F3=Back  F4=Clear  F12=Exit", "YELLOW", 1));

    /** TRNNAME: (1,7), 4 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR01.bms:34. Symbolic map TRNNAMEI, TRNNAMEO. */
    private String trnname;

    /** TITLE01: (1,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR01.bms:38. Symbolic map TITLE01I, TITLE01O. */
    private String title01;

    /** CURDATE: (1,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR01.bms:47. Symbolic map CURDATEI, CURDATEO. */
    private String curdate;

    /** PGMNAME: (2,7), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR01.bms:57. Symbolic map PGMNAMEI, PGMNAMEO. */
    private String pgmname;

    /** TITLE02: (2,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR01.bms:61. Symbolic map TITLE02I, TITLE02O. */
    private String title02;

    /** CURTIME: (2,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR01.bms:70. Symbolic map CURTIMEI, CURTIMEO. */
    private String curtime;

    /** FNAME: (8,18), 20 bytes, ATTRB=FSET,IC,NORM,UNPROT -- app/bms/COUSR01.bms:84. Symbolic map FNAMEI, FNAMEO. */
    private String fname;

    /** LNAME: (8,56), 20 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR01.bms:97. Symbolic map LNAMEI, LNAMEO. */
    private String lname;

    /** USERID: (11,15), 8 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR01.bms:111. Symbolic map USERIDI, USERIDO. */
    private String userid;

    /** PASSWD: (11,55), 8 bytes, ATTRB=DRK,FSET,UNPROT -- app/bms/COUSR01.bms:126. Symbolic map PASSWDI, PASSWDO. */
    private String passwd;

    /** USRTYPE: (14,17), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR01.bms:141. Symbolic map USRTYPEI, USRTYPEO. */
    private String usrtype;

    /** ERRMSG: (23,1), 78 bytes, ATTRB=ASKIP,BRT,FSET -- app/bms/COUSR01.bms:151. Symbolic map ERRMSGI, ERRMSGO. */
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
        values.put("FNAME", fname);
        values.put("LNAME", lname);
        values.put("USERID", userid);
        values.put("PASSWD", passwd);
        values.put("USRTYPE", usrtype);
        values.put("ERRMSG", errmsg);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Cousr1aScreen fromValues(Map<String, String> values) {
        Cousr1aScreen screen = new Cousr1aScreen();
        screen.setTrnname(values.get("TRNNAME"));
        screen.setTitle01(values.get("TITLE01"));
        screen.setCurdate(values.get("CURDATE"));
        screen.setPgmname(values.get("PGMNAME"));
        screen.setTitle02(values.get("TITLE02"));
        screen.setCurtime(values.get("CURTIME"));
        screen.setFname(values.get("FNAME"));
        screen.setLname(values.get("LNAME"));
        screen.setUserid(values.get("USERID"));
        screen.setPasswd(values.get("PASSWD"));
        screen.setUsrtype(values.get("USRTYPE"));
        screen.setErrmsg(values.get("ERRMSG"));
        return screen;
    }
}
