package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map COSGN0A of mapset COSGN00 (app/bms/COSGN00.bms): the screen as a view model (#3619).
 * SEND at app/cbl/COSGN00C.cbl:151; RECEIVE at app/cbl/COSGN00C.cbl:110.
 * One property per named field (symbolic map COSGN0AI / COSGN0AO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Cosgn0aScreen implements ScreenModel {

    public static final String MAPSET = "COSGN00";
    public static final String MAP = "COSGN0A";
    public static final List<ScreenField> LAYOUT = List.of(
            new ScreenField(null, 1, 1, 6, false, false, false, false, false, "Tran :", "BLUE", 1),
            new ScreenField("TRNNAME", 1, 8, 4, false, false, false, false, false, null, "BLUE", 1),
            new ScreenField("TITLE01", 1, 21, 40, false, false, false, false, false, null, "YELLOW", 1),
            new ScreenField(null, 1, 64, 6, false, false, false, false, false, "Date :", "BLUE", 1),
            new ScreenField("CURDATE", 1, 71, 8, false, false, false, false, false, "mm/dd/yy", "BLUE", 1),
            new ScreenField(null, 2, 1, 6, false, false, false, false, false, "Prog :", "BLUE", 1),
            new ScreenField("PGMNAME", 2, 8, 8, false, false, false, false, false, null, "BLUE", 1),
            new ScreenField("TITLE02", 2, 21, 40, false, false, false, false, false, null, "YELLOW", 1),
            new ScreenField(null, 2, 64, 6, false, false, false, false, false, "Time :", "BLUE", 1),
            new ScreenField("CURTIME", 2, 71, 9, false, false, false, false, false, "Ahh:mm:ss", "BLUE", 1),
            new ScreenField(null, 3, 1, 6, false, false, false, false, false, "AppID:", "BLUE", 1),
            new ScreenField("APPLID", 3, 8, 8, false, false, false, false, false, null, "BLUE", 1),
            new ScreenField(null, 3, 64, 6, false, false, false, false, false, "SysID:", "BLUE", 1),
            new ScreenField("SYSID", 3, 71, 8, false, false, false, false, false, "        ", "BLUE", 1),
            new ScreenField(null, 5, 6, 66, false, false, false, false, false, "This is a Credit Card Demo Application for Mainframe Modernization", "NEUTRAL", 1),
            new ScreenField(null, 7, 21, 42, false, false, false, false, false, "+========================================+", "BLUE", 1),
            new ScreenField(null, 8, 21, 42, false, false, false, false, false, "|%%%%%%%  NATIONAL RESERVE NOTE  %%%%%%%%|", "BLUE", 1),
            new ScreenField(null, 9, 21, 42, false, false, false, false, false, "|%(1)  THE UNITED STATES OF KICSLAND (1)%|", "BLUE", 1),
            new ScreenField(null, 10, 21, 42, false, false, false, false, false, "|%$$              ___       ********  $$%|", "BLUE", 1),
            new ScreenField(null, 11, 21, 42, false, false, false, false, false, "|%$    {x}       (o o)                 $%|", "BLUE", 1),
            new ScreenField(null, 12, 21, 42, false, false, false, false, false, "|%$     ******  (  V  )      O N E     $%|", "BLUE", 1),
            new ScreenField(null, 13, 21, 42, false, false, false, false, false, "|%(1)          ---m-m---             (1)%|", "BLUE", 1),
            new ScreenField(null, 14, 21, 42, false, false, false, false, false, "|%%~~~~~~~~~~~ ONE DOLLAR ~~~~~~~~~~~~~%%|", "BLUE", 1),
            new ScreenField(null, 15, 21, 42, false, false, false, false, false, "+========================================+", "BLUE", 1),
            new ScreenField(null, 17, 16, 49, false, false, false, false, false, "Type your User ID and Password, then press ENTER:", "TURQUOISE", 1),
            new ScreenField(null, 19, 29, 13, false, false, false, false, false, "User ID     :", "TURQUOISE", 1),
            new ScreenField("USERID", 19, 43, 8, true, false, false, false, true, null, "GREEN", 1),
            new ScreenField(null, 19, 52, 0, false, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 19, 52, 8, false, false, false, false, false, "(8 Char)", "BLUE", 1),
            new ScreenField(null, 20, 29, 13, false, false, false, false, false, "Password    :", "TURQUOISE", 1),
            new ScreenField("PASSWD", 20, 43, 8, true, false, false, true, false, "________", "GREEN", 1),
            new ScreenField(null, 20, 52, 0, false, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 20, 52, 8, false, false, false, false, false, "(8 Char)", "BLUE", 1),
            new ScreenField(null, 20, 61, 1, true, false, false, true, false, " ", null, 1),
            new ScreenField(null, 20, 63, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("ERRMSG", 23, 1, 78, false, false, true, false, false, null, "RED", 1),
            new ScreenField(null, 24, 1, 22, false, false, false, false, false, "ENTER=Sign-on  F3=Exit", "YELLOW", 1));

    /** TRNNAME: (1,8), 4 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COSGN00.bms:34. Symbolic map TRNNAMEI, TRNNAMEO. */
    private String trnname;

    /** TITLE01: (1,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COSGN00.bms:38. Symbolic map TITLE01I, TITLE01O. */
    private String title01;

    /** CURDATE: (1,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COSGN00.bms:47. Symbolic map CURDATEI, CURDATEO. */
    private String curdate;

    /** PGMNAME: (2,8), 8 bytes, ATTRB=FSET,NORM,PROT -- app/bms/COSGN00.bms:57. Symbolic map PGMNAMEI, PGMNAMEO. */
    private String pgmname;

    /** TITLE02: (2,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COSGN00.bms:61. Symbolic map TITLE02I, TITLE02O. */
    private String title02;

    /** CURTIME: (2,71), 9 bytes, ATTRB=FSET,NORM,PROT -- app/bms/COSGN00.bms:70. Symbolic map CURTIMEI, CURTIMEO. */
    private String curtime;

    /** APPLID: (3,8), 8 bytes, ATTRB=FSET,NORM,PROT -- app/bms/COSGN00.bms:80. Symbolic map APPLIDI, APPLIDO. */
    private String applid;

    /** SYSID: (3,71), 8 bytes, ATTRB=FSET,NORM,PROT -- app/bms/COSGN00.bms:89. Symbolic map SYSIDI, SYSIDO. */
    private String sysid;

    /** USERID: (19,43), 8 bytes, ATTRB=FSET,IC,NORM,UNPROT -- app/bms/COSGN00.bms:156. Symbolic map USERIDI, USERIDO. */
    private String userid;

    /** PASSWD: (20,43), 8 bytes, ATTRB=DRK,FSET,UNPROT -- app/bms/COSGN00.bms:175. Symbolic map PASSWDI, PASSWDO. */
    private String passwd;

    /** ERRMSG: (23,1), 78 bytes, ATTRB=ASKIP,BRT,FSET -- app/bms/COSGN00.bms:197. Symbolic map ERRMSGI, ERRMSGO. */
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
        values.put("APPLID", applid);
        values.put("SYSID", sysid);
        values.put("USERID", userid);
        values.put("PASSWD", passwd);
        values.put("ERRMSG", errmsg);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Cosgn0aScreen fromValues(Map<String, String> values) {
        Cosgn0aScreen screen = new Cosgn0aScreen();
        screen.setTrnname(values.get("TRNNAME"));
        screen.setTitle01(values.get("TITLE01"));
        screen.setCurdate(values.get("CURDATE"));
        screen.setPgmname(values.get("PGMNAME"));
        screen.setTitle02(values.get("TITLE02"));
        screen.setCurtime(values.get("CURTIME"));
        screen.setApplid(values.get("APPLID"));
        screen.setSysid(values.get("SYSID"));
        screen.setUserid(values.get("USERID"));
        screen.setPasswd(values.get("PASSWD"));
        screen.setErrmsg(values.get("ERRMSG"));
        return screen;
    }
}
