package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map COTRN1A of mapset COTRN01 (app/bms/COTRN01.bms): the screen as a view model (#3619).
 * SEND at app/cbl/COTRN01C.cbl:219; RECEIVE at app/cbl/COTRN01C.cbl:232.
 * One property per named field (symbolic map COTRN1AI / COTRN1AO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Cotrn1aScreen implements ScreenModel {

    public static final String MAPSET = "COTRN01";
    public static final String MAP = "COTRN1A";
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
            new ScreenField(null, 4, 30, 16, false, false, true, false, false, "View Transaction", "NEUTRAL", 1),
            new ScreenField(null, 6, 6, 14, false, false, false, false, false, "Enter Tran ID:", "TURQUOISE", 1),
            new ScreenField("TRNIDIN", 6, 21, 16, true, false, false, false, true, " ", "GREEN", 1),
            new ScreenField(null, 6, 38, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 8, 6, 70, false, false, false, false, false, "----------------------------------------------------------------------", "NEUTRAL", 1),
            new ScreenField(null, 10, 6, 15, false, false, false, false, false, "Transaction ID:", "TURQUOISE", 1),
            new ScreenField("TRNID", 10, 22, 16, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 10, 39, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 10, 45, 12, false, false, false, false, false, "Card Number:", "TURQUOISE", 1),
            new ScreenField("CARDNUM", 10, 58, 16, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 10, 75, 0, false, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 12, 6, 8, false, false, false, false, false, "Type CD:", "TURQUOISE", 1),
            new ScreenField("TTYPCD", 12, 15, 2, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 12, 18, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 12, 23, 12, false, false, false, false, false, "Category CD:", "TURQUOISE", 1),
            new ScreenField("TCATCD", 12, 36, 4, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 12, 41, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 12, 46, 7, false, false, false, false, false, "Source:", "TURQUOISE", 1),
            new ScreenField("TRNSRC", 12, 54, 10, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 12, 65, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 14, 6, 12, false, false, false, false, false, "Description:", "TURQUOISE", 1),
            new ScreenField("TDESC", 14, 19, 60, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 14, 80, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 16, 6, 7, false, false, false, false, false, "Amount:", "TURQUOISE", 1),
            new ScreenField("TRNAMT", 16, 14, 12, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 16, 27, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 16, 31, 10, false, false, false, false, false, "Orig Date:", "TURQUOISE", 1),
            new ScreenField("TORIGDT", 16, 42, 10, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 16, 53, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 16, 57, 10, false, false, false, false, false, "Proc Date:", "TURQUOISE", 1),
            new ScreenField("TPROCDT", 16, 68, 10, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 16, 79, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 18, 6, 12, false, false, false, false, false, "Merchant ID:", "TURQUOISE", 1),
            new ScreenField("MID", 18, 19, 9, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 18, 29, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 18, 33, 14, false, false, false, false, false, "Merchant Name:", "TURQUOISE", 1),
            new ScreenField("MNAME", 18, 48, 30, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 18, 79, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 20, 6, 14, false, false, false, false, false, "Merchant City:", "TURQUOISE", 1),
            new ScreenField("MCITY", 20, 21, 25, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 20, 47, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 20, 53, 13, false, false, false, false, false, "Merchant Zip:", "TURQUOISE", 1),
            new ScreenField("MZIP", 20, 67, 10, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 20, 78, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("ERRMSG", 23, 1, 78, false, false, true, false, false, null, "RED", 1),
            new ScreenField(null, 24, 1, 47, false, false, false, false, false, "ENTER=Fetch  F3=Back  F4=Clear  F5=Browse Tran.", "YELLOW", 1));

    /** TRNNAME: (1,7), 4 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COTRN01.bms:34. Symbolic map TRNNAMEI, TRNNAMEO. */
    private String trnname;

    /** TITLE01: (1,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COTRN01.bms:38. Symbolic map TITLE01I, TITLE01O. */
    private String title01;

    /** CURDATE: (1,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COTRN01.bms:47. Symbolic map CURDATEI, CURDATEO. */
    private String curdate;

    /** PGMNAME: (2,7), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COTRN01.bms:57. Symbolic map PGMNAMEI, PGMNAMEO. */
    private String pgmname;

    /** TITLE02: (2,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COTRN01.bms:61. Symbolic map TITLE02I, TITLE02O. */
    private String title02;

    /** CURTIME: (2,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COTRN01.bms:70. Symbolic map CURTIMEI, CURTIMEO. */
    private String curtime;

    /** TRNIDIN: (6,21), 16 bytes, ATTRB=FSET,IC,NORM,UNPROT -- app/bms/COTRN01.bms:85. Symbolic map TRNIDINI, TRNIDINO. */
    private String trnidin;

    /** TRNID: (10,22), 16 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:105. Symbolic map TRNIDI, TRNIDO. */
    private String trnid;

    /** CARDNUM: (10,58), 16 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:118. Symbolic map CARDNUMI, CARDNUMO. */
    private String cardnum;

    /** TTYPCD: (12,15), 2 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:132. Symbolic map TTYPCDI, TTYPCDO. */
    private String ttypcd;

    /** TCATCD: (12,36), 4 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:144. Symbolic map TCATCDI, TCATCDO. */
    private String tcatcd;

    /** TRNSRC: (12,54), 10 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:156. Symbolic map TRNSRCI, TRNSRCO. */
    private String trnsrc;

    /** TDESC: (14,19), 60 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:168. Symbolic map TDESCI, TDESCO. */
    private String tdesc;

    /** TRNAMT: (16,14), 12 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:180. Symbolic map TRNAMTI, TRNAMTO. */
    private String trnamt;

    /** TORIGDT: (16,42), 10 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:192. Symbolic map TORIGDTI, TORIGDTO. */
    private String torigdt;

    /** TPROCDT: (16,68), 10 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:204. Symbolic map TPROCDTI, TPROCDTO. */
    private String tprocdt;

    /** MID: (18,19), 9 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:216. Symbolic map MIDI, MIDO. */
    private String mid;

    /** MNAME: (18,48), 30 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:228. Symbolic map MNAMEI, MNAMEO. */
    private String mname;

    /** MCITY: (20,21), 25 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:240. Symbolic map MCITYI, MCITYO. */
    private String mcity;

    /** MZIP: (20,67), 10 bytes, ATTRB=ASKIP,NORM -- app/bms/COTRN01.bms:252. Symbolic map MZIPI, MZIPO. */
    private String mzip;

    /** ERRMSG: (23,1), 78 bytes, ATTRB=ASKIP,BRT,FSET -- app/bms/COTRN01.bms:259. Symbolic map ERRMSGI, ERRMSGO. */
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
        values.put("TRNIDIN", trnidin);
        values.put("TRNID", trnid);
        values.put("CARDNUM", cardnum);
        values.put("TTYPCD", ttypcd);
        values.put("TCATCD", tcatcd);
        values.put("TRNSRC", trnsrc);
        values.put("TDESC", tdesc);
        values.put("TRNAMT", trnamt);
        values.put("TORIGDT", torigdt);
        values.put("TPROCDT", tprocdt);
        values.put("MID", mid);
        values.put("MNAME", mname);
        values.put("MCITY", mcity);
        values.put("MZIP", mzip);
        values.put("ERRMSG", errmsg);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Cotrn1aScreen fromValues(Map<String, String> values) {
        Cotrn1aScreen screen = new Cotrn1aScreen();
        screen.setTrnname(values.get("TRNNAME"));
        screen.setTitle01(values.get("TITLE01"));
        screen.setCurdate(values.get("CURDATE"));
        screen.setPgmname(values.get("PGMNAME"));
        screen.setTitle02(values.get("TITLE02"));
        screen.setCurtime(values.get("CURTIME"));
        screen.setTrnidin(values.get("TRNIDIN"));
        screen.setTrnid(values.get("TRNID"));
        screen.setCardnum(values.get("CARDNUM"));
        screen.setTtypcd(values.get("TTYPCD"));
        screen.setTcatcd(values.get("TCATCD"));
        screen.setTrnsrc(values.get("TRNSRC"));
        screen.setTdesc(values.get("TDESC"));
        screen.setTrnamt(values.get("TRNAMT"));
        screen.setTorigdt(values.get("TORIGDT"));
        screen.setTprocdt(values.get("TPROCDT"));
        screen.setMid(values.get("MID"));
        screen.setMname(values.get("MNAME"));
        screen.setMcity(values.get("MCITY"));
        screen.setMzip(values.get("MZIP"));
        screen.setErrmsg(values.get("ERRMSG"));
        return screen;
    }
}
