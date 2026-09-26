package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map CCRDSLA of mapset COCRDSL (app/bms/COCRDSL.bms): the screen as a view model (#3619).
 * SEND at app/cbl/COCRDSLC.cbl:569; RECEIVE at app/cbl/COCRDSLC.cbl:597.
 * One property per named field (symbolic map CCRDSLAI / CCRDSLAO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CcrdslaScreen implements ScreenModel {

    public static final String MAPSET = "COCRDSL";
    public static final String MAP = "CCRDSLA";
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
            new ScreenField(null, 4, 30, 23, false, false, false, false, false, "View Credit Card Detail", "NEUTRAL", 1),
            new ScreenField(null, 7, 23, 19, false, false, false, false, false, "Account Number    :", "TURQUOISE", 1),
            new ScreenField("ACCTSID", 7, 45, 11, true, false, false, false, true, null, "DEFAULT", 1),
            new ScreenField(null, 7, 57, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 8, 23, 19, false, false, false, false, false, "Card Number       :", "TURQUOISE", 1),
            new ScreenField("CARDSID", 8, 45, 16, true, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField(null, 8, 62, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 11, 4, 20, false, false, false, false, false, "Name on card      :", "TURQUOISE", 1),
            new ScreenField("CRDNAME", 11, 25, 50, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 11, 76, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 13, 4, 20, false, false, false, false, false, "Card Active Y/N   : ", "TURQUOISE", 1),
            new ScreenField("CRDSTCD", 13, 25, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 13, 27, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 15, 4, 20, false, false, false, false, false, "Expiry Date       : ", "TURQUOISE", 1),
            new ScreenField("EXPMON", 15, 25, 2, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 15, 28, 1, false, false, false, false, false, "/", null, 1),
            new ScreenField("EXPYEAR", 15, 30, 4, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 15, 35, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("INFOMSG", 20, 25, 40, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField("ERRMSG", 23, 1, 80, false, false, true, false, false, null, "RED", 1),
            new ScreenField("FKEYS", 24, 1, 75, false, false, false, false, false, "ENTER=Search Cards  F3=Exit", "YELLOW", 1));

    /** TRNNAME: (1,7), 4 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COCRDSL.bms:34. Symbolic map TRNNAMEI, TRNNAMEO. */
    private String trnname;

    /** TITLE01: (1,21), 40 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDSL.bms:38. Symbolic map TITLE01I, TITLE01O. */
    private String title01;

    /** CURDATE: (1,71), 8 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDSL.bms:47. Symbolic map CURDATEI, CURDATEO. */
    private String curdate;

    /** PGMNAME: (2,7), 8 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDSL.bms:57. Symbolic map PGMNAMEI, PGMNAMEO. */
    private String pgmname;

    /** TITLE02: (2,21), 40 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDSL.bms:61. Symbolic map TITLE02I, TITLE02O. */
    private String title02;

    /** CURTIME: (2,71), 8 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDSL.bms:70. Symbolic map CURTIMEI, CURTIMEO. */
    private String curtime;

    /** ACCTSID: (7,45), 11 bytes, ATTRB=FSET,IC,NORM,UNPROT -- app/bms/COCRDSL.bms:84. Symbolic map ACCTSIDI, ACCTSIDO. */
    private String acctsid;

    /** CARDSID: (8,45), 16 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COCRDSL.bms:96. Symbolic map CARDSIDI, CARDSIDO. */
    private String cardsid;

    /** CRDNAME: (11,25), 50 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDSL.bms:107. Symbolic map CRDNAMEI, CRDNAMEO. */
    private String crdname;

    /** CRDSTCD: (13,25), 1 bytes, ATTRB=ASKIP -- app/bms/COCRDSL.bms:116. Symbolic map CRDSTCDI, CRDSTCDO. */
    private String crdstcd;

    /** EXPMON: (15,25), 2 bytes, ATTRB=ASKIP -- app/bms/COCRDSL.bms:126. Symbolic map EXPMONI, EXPMONO. */
    private String expmon;

    /** EXPYEAR: (15,30), 4 bytes, ATTRB=ASKIP -- app/bms/COCRDSL.bms:133. Symbolic map EXPYEARI, EXPYEARO. */
    private String expyear;

    /** INFOMSG: (20,25), 40 bytes, ATTRB=PROT -- app/bms/COCRDSL.bms:139. Symbolic map INFOMSGI, INFOMSGO. */
    private String infomsg;

    /** ERRMSG: (23,1), 80 bytes, ATTRB=ASKIP,BRT,FSET -- app/bms/COCRDSL.bms:144. Symbolic map ERRMSGI, ERRMSGO. */
    private String errmsg;

    /** FKEYS: (24,1), 75 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDSL.bms:148. Symbolic map FKEYSI, FKEYSO. */
    private String fkeys;

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
        values.put("ACCTSID", acctsid);
        values.put("CARDSID", cardsid);
        values.put("CRDNAME", crdname);
        values.put("CRDSTCD", crdstcd);
        values.put("EXPMON", expmon);
        values.put("EXPYEAR", expyear);
        values.put("INFOMSG", infomsg);
        values.put("ERRMSG", errmsg);
        values.put("FKEYS", fkeys);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static CcrdslaScreen fromValues(Map<String, String> values) {
        CcrdslaScreen screen = new CcrdslaScreen();
        screen.setTrnname(values.get("TRNNAME"));
        screen.setTitle01(values.get("TITLE01"));
        screen.setCurdate(values.get("CURDATE"));
        screen.setPgmname(values.get("PGMNAME"));
        screen.setTitle02(values.get("TITLE02"));
        screen.setCurtime(values.get("CURTIME"));
        screen.setAcctsid(values.get("ACCTSID"));
        screen.setCardsid(values.get("CARDSID"));
        screen.setCrdname(values.get("CRDNAME"));
        screen.setCrdstcd(values.get("CRDSTCD"));
        screen.setExpmon(values.get("EXPMON"));
        screen.setExpyear(values.get("EXPYEAR"));
        screen.setInfomsg(values.get("INFOMSG"));
        screen.setErrmsg(values.get("ERRMSG"));
        screen.setFkeys(values.get("FKEYS"));
        return screen;
    }
}
