package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map CCRDLIA of mapset COCRDLI (app/bms/COCRDLI.bms): the screen as a view model (#3619).
 * SEND at app/cbl/COCRDLIC.cbl:939; RECEIVE at app/cbl/COCRDLIC.cbl:963.
 * One property per named field (symbolic map CCRDLIAI / CCRDLIAO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CcrdliaScreen implements ScreenModel {

    public static final String MAPSET = "COCRDLI";
    public static final String MAP = "CCRDLIA";
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
            new ScreenField(null, 4, 31, 17, false, false, false, false, false, "List Credit Cards", "NEUTRAL", 1),
            new ScreenField(null, 4, 70, 5, false, false, false, false, false, "Page ", null, 1),
            new ScreenField("PAGENO", 4, 76, 3, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 6, 22, 19, false, false, false, false, false, "Account Number    :", "TURQUOISE", 1),
            new ScreenField("ACCTSID", 6, 44, 11, true, false, false, false, true, null, "GREEN", 1),
            new ScreenField(null, 6, 56, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 7, 22, 19, false, false, false, false, false, "Credit Card Number:", "TURQUOISE", 1),
            new ScreenField("CARDSID", 7, 44, 16, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 7, 61, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 9, 10, 10, false, false, false, false, false, "Select    ", "NEUTRAL", 1),
            new ScreenField(null, 9, 21, 14, false, false, false, false, false, "Account Number", "NEUTRAL", 1),
            new ScreenField(null, 9, 45, 13, false, false, false, false, false, " Card Number ", "NEUTRAL", 1),
            new ScreenField(null, 9, 66, 7, false, false, false, false, false, "Active ", "NEUTRAL", 1),
            new ScreenField(null, 10, 10, 6, false, false, false, false, false, "------", "NEUTRAL", 1),
            new ScreenField(null, 10, 20, 15, false, false, false, false, false, "---------------", "NEUTRAL", 1),
            new ScreenField(null, 10, 43, 15, false, false, false, false, false, "---------------", "NEUTRAL", 1),
            new ScreenField(null, 10, 65, 8, false, false, false, false, false, "--------", "NEUTRAL", 1),
            new ScreenField("CRDSEL1", 11, 12, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField(null, 11, 14, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("ACCTNO1", 11, 22, 11, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDNUM1", 11, 43, 16, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSTS1", 11, 67, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSEL2", 12, 12, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField(null, 12, 14, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("CRDSTP2", 12, 14, 1, false, false, false, true, false, null, "DEFAULT", 1),
            new ScreenField("ACCTNO2", 12, 22, 11, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDNUM2", 12, 43, 16, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSTS2", 12, 67, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSEL3", 13, 12, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField(null, 13, 14, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("CRDSTP3", 13, 14, 1, false, false, false, true, false, null, "DEFAULT", 1),
            new ScreenField("ACCTNO3", 13, 22, 11, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDNUM3", 13, 43, 16, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSTS3", 13, 67, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSEL4", 14, 12, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField(null, 14, 14, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("CRDSTP4", 14, 14, 1, false, false, false, true, false, null, "DEFAULT", 1),
            new ScreenField("ACCTNO4", 14, 22, 11, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDNUM4", 14, 43, 16, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSTS4", 14, 67, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSEL5", 15, 12, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField(null, 15, 14, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("CRDSTP5", 15, 14, 1, false, false, false, true, false, null, "DEFAULT", 1),
            new ScreenField("ACCTNO5", 15, 22, 11, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDNUM5", 15, 43, 16, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSTS5", 15, 67, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSEL6", 16, 12, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField(null, 16, 14, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("CRDSTP6", 16, 14, 1, false, false, false, true, false, null, "DEFAULT", 1),
            new ScreenField("ACCTNO6", 16, 22, 11, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDNUM6", 16, 43, 16, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSTS6", 16, 67, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSEL7", 17, 12, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField(null, 17, 14, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("CRDSTP7", 17, 14, 1, false, false, false, true, false, null, "DEFAULT", 1),
            new ScreenField("ACCTNO7", 17, 22, 11, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDNUM7", 17, 43, 16, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("CRDSTS7", 17, 67, 1, false, false, false, false, false, null, "DEFAULT", 1),
            new ScreenField("INFOMSG", 20, 19, 45, false, false, false, false, false, null, "NEUTRAL", 1),
            new ScreenField(null, 20, 65, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("ERRMSG", 23, 1, 78, false, false, true, false, false, null, "RED", 1),
            new ScreenField(null, 24, 1, 78, false, false, false, false, false, "  F3=Exit F7=Backward  F8=Forward", "TURQUOISE", 1));

    /** TRNNAME: (1,7), 4 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COCRDLI.bms:34. Symbolic map TRNNAMEI, TRNNAMEO. */
    private String trnname;

    /** TITLE01: (1,21), 40 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDLI.bms:38. Symbolic map TITLE01I, TITLE01O. */
    private String title01;

    /** CURDATE: (1,71), 8 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDLI.bms:47. Symbolic map CURDATEI, CURDATEO. */
    private String curdate;

    /** PGMNAME: (2,7), 8 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDLI.bms:57. Symbolic map PGMNAMEI, PGMNAMEO. */
    private String pgmname;

    /** TITLE02: (2,21), 40 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDLI.bms:61. Symbolic map TITLE02I, TITLE02O. */
    private String title02;

    /** CURTIME: (2,71), 8 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDLI.bms:70. Symbolic map CURTIMEI, CURTIMEO. */
    private String curtime;

    /** PAGENO: (4,76), 3 bytes, ATTRB=ASKIP,NORM -- app/bms/COCRDLI.bms:82. Symbolic map PAGENOI, PAGENOO. */
    private String pageno;

    /** ACCTSID: (6,44), 11 bytes, ATTRB=FSET,IC,NORM,UNPROT -- app/bms/COCRDLI.bms:89. Symbolic map ACCTSIDI, ACCTSIDO. */
    private String acctsid;

    /** CARDSID: (7,44), 16 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COCRDLI.bms:101. Symbolic map CARDSIDI, CARDSIDO. */
    private String cardsid;

    /** CRDSEL1: (11,12), 1 bytes, ATTRB=FSET,NORM,PROT -- app/bms/COCRDLI.bms:140. Symbolic map CRDSEL1I, CRDSEL1O. */
    private String crdsel1;

    /** ACCTNO1: (11,22), 11 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:147. Symbolic map ACCTNO1I, ACCTNO1O. */
    private String acctno1;

    /** CRDNUM1: (11,43), 16 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:152. Symbolic map CRDNUM1I, CRDNUM1O. */
    private String crdnum1;

    /** CRDSTS1: (11,67), 1 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:157. Symbolic map CRDSTS1I, CRDSTS1O. */
    private String crdsts1;

    /** CRDSEL2: (12,12), 1 bytes, ATTRB=FSET,NORM,PROT -- app/bms/COCRDLI.bms:162. Symbolic map CRDSEL2I, CRDSEL2O. */
    private String crdsel2;

    /** CRDSTP2: (12,14), 1 bytes, ATTRB=ASKIP,DRK,FSET -- app/bms/COCRDLI.bms:169. Symbolic map CRDSTP2I, CRDSTP2O. */
    private String crdstp2;

    /** ACCTNO2: (12,22), 11 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:174. Symbolic map ACCTNO2I, ACCTNO2O. */
    private String acctno2;

    /** CRDNUM2: (12,43), 16 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:179. Symbolic map CRDNUM2I, CRDNUM2O. */
    private String crdnum2;

    /** CRDSTS2: (12,67), 1 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:184. Symbolic map CRDSTS2I, CRDSTS2O. */
    private String crdsts2;

    /** CRDSEL3: (13,12), 1 bytes, ATTRB=FSET,NORM,PROT -- app/bms/COCRDLI.bms:189. Symbolic map CRDSEL3I, CRDSEL3O. */
    private String crdsel3;

    /** CRDSTP3: (13,14), 1 bytes, ATTRB=ASKIP,DRK,FSET -- app/bms/COCRDLI.bms:196. Symbolic map CRDSTP3I, CRDSTP3O. */
    private String crdstp3;

    /** ACCTNO3: (13,22), 11 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:201. Symbolic map ACCTNO3I, ACCTNO3O. */
    private String acctno3;

    /** CRDNUM3: (13,43), 16 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:206. Symbolic map CRDNUM3I, CRDNUM3O. */
    private String crdnum3;

    /** CRDSTS3: (13,67), 1 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:211. Symbolic map CRDSTS3I, CRDSTS3O. */
    private String crdsts3;

    /** CRDSEL4: (14,12), 1 bytes, ATTRB=FSET,NORM,PROT -- app/bms/COCRDLI.bms:216. Symbolic map CRDSEL4I, CRDSEL4O. */
    private String crdsel4;

    /** CRDSTP4: (14,14), 1 bytes, ATTRB=ASKIP,DRK,FSET -- app/bms/COCRDLI.bms:223. Symbolic map CRDSTP4I, CRDSTP4O. */
    private String crdstp4;

    /** ACCTNO4: (14,22), 11 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:228. Symbolic map ACCTNO4I, ACCTNO4O. */
    private String acctno4;

    /** CRDNUM4: (14,43), 16 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:233. Symbolic map CRDNUM4I, CRDNUM4O. */
    private String crdnum4;

    /** CRDSTS4: (14,67), 1 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:238. Symbolic map CRDSTS4I, CRDSTS4O. */
    private String crdsts4;

    /** CRDSEL5: (15,12), 1 bytes, ATTRB=FSET,NORM,PROT -- app/bms/COCRDLI.bms:243. Symbolic map CRDSEL5I, CRDSEL5O. */
    private String crdsel5;

    /** CRDSTP5: (15,14), 1 bytes, ATTRB=ASKIP,DRK,FSET -- app/bms/COCRDLI.bms:250. Symbolic map CRDSTP5I, CRDSTP5O. */
    private String crdstp5;

    /** ACCTNO5: (15,22), 11 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:255. Symbolic map ACCTNO5I, ACCTNO5O. */
    private String acctno5;

    /** CRDNUM5: (15,43), 16 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:260. Symbolic map CRDNUM5I, CRDNUM5O. */
    private String crdnum5;

    /** CRDSTS5: (15,67), 1 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:265. Symbolic map CRDSTS5I, CRDSTS5O. */
    private String crdsts5;

    /** CRDSEL6: (16,12), 1 bytes, ATTRB=FSET,NORM,PROT -- app/bms/COCRDLI.bms:270. Symbolic map CRDSEL6I, CRDSEL6O. */
    private String crdsel6;

    /** CRDSTP6: (16,14), 1 bytes, ATTRB=ASKIP,DRK,FSET -- app/bms/COCRDLI.bms:277. Symbolic map CRDSTP6I, CRDSTP6O. */
    private String crdstp6;

    /** ACCTNO6: (16,22), 11 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:282. Symbolic map ACCTNO6I, ACCTNO6O. */
    private String acctno6;

    /** CRDNUM6: (16,43), 16 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:287. Symbolic map CRDNUM6I, CRDNUM6O. */
    private String crdnum6;

    /** CRDSTS6: (16,67), 1 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:292. Symbolic map CRDSTS6I, CRDSTS6O. */
    private String crdsts6;

    /** CRDSEL7: (17,12), 1 bytes, ATTRB=FSET,NORM,PROT -- app/bms/COCRDLI.bms:297. Symbolic map CRDSEL7I, CRDSEL7O. */
    private String crdsel7;

    /** CRDSTP7: (17,14), 1 bytes, ATTRB=ASKIP,DRK,FSET -- app/bms/COCRDLI.bms:304. Symbolic map CRDSTP7I, CRDSTP7O. */
    private String crdstp7;

    /** ACCTNO7: (17,22), 11 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:309. Symbolic map ACCTNO7I, ACCTNO7O. */
    private String acctno7;

    /** CRDNUM7: (17,43), 16 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:314. Symbolic map CRDNUM7I, CRDNUM7O. */
    private String crdnum7;

    /** CRDSTS7: (17,67), 1 bytes, ATTRB=NORM,PROT -- app/bms/COCRDLI.bms:319. Symbolic map CRDSTS7I, CRDSTS7O. */
    private String crdsts7;

    /** INFOMSG: (20,19), 45 bytes, ATTRB=PROT -- app/bms/COCRDLI.bms:324. Symbolic map INFOMSGI, INFOMSGO. */
    private String infomsg;

    /** ERRMSG: (23,1), 78 bytes, ATTRB=ASKIP,BRT,FSET -- app/bms/COCRDLI.bms:331. Symbolic map ERRMSGI, ERRMSGO. */
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
        values.put("PAGENO", pageno);
        values.put("ACCTSID", acctsid);
        values.put("CARDSID", cardsid);
        values.put("CRDSEL1", crdsel1);
        values.put("ACCTNO1", acctno1);
        values.put("CRDNUM1", crdnum1);
        values.put("CRDSTS1", crdsts1);
        values.put("CRDSEL2", crdsel2);
        values.put("CRDSTP2", crdstp2);
        values.put("ACCTNO2", acctno2);
        values.put("CRDNUM2", crdnum2);
        values.put("CRDSTS2", crdsts2);
        values.put("CRDSEL3", crdsel3);
        values.put("CRDSTP3", crdstp3);
        values.put("ACCTNO3", acctno3);
        values.put("CRDNUM3", crdnum3);
        values.put("CRDSTS3", crdsts3);
        values.put("CRDSEL4", crdsel4);
        values.put("CRDSTP4", crdstp4);
        values.put("ACCTNO4", acctno4);
        values.put("CRDNUM4", crdnum4);
        values.put("CRDSTS4", crdsts4);
        values.put("CRDSEL5", crdsel5);
        values.put("CRDSTP5", crdstp5);
        values.put("ACCTNO5", acctno5);
        values.put("CRDNUM5", crdnum5);
        values.put("CRDSTS5", crdsts5);
        values.put("CRDSEL6", crdsel6);
        values.put("CRDSTP6", crdstp6);
        values.put("ACCTNO6", acctno6);
        values.put("CRDNUM6", crdnum6);
        values.put("CRDSTS6", crdsts6);
        values.put("CRDSEL7", crdsel7);
        values.put("CRDSTP7", crdstp7);
        values.put("ACCTNO7", acctno7);
        values.put("CRDNUM7", crdnum7);
        values.put("CRDSTS7", crdsts7);
        values.put("INFOMSG", infomsg);
        values.put("ERRMSG", errmsg);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static CcrdliaScreen fromValues(Map<String, String> values) {
        CcrdliaScreen screen = new CcrdliaScreen();
        screen.setTrnname(values.get("TRNNAME"));
        screen.setTitle01(values.get("TITLE01"));
        screen.setCurdate(values.get("CURDATE"));
        screen.setPgmname(values.get("PGMNAME"));
        screen.setTitle02(values.get("TITLE02"));
        screen.setCurtime(values.get("CURTIME"));
        screen.setPageno(values.get("PAGENO"));
        screen.setAcctsid(values.get("ACCTSID"));
        screen.setCardsid(values.get("CARDSID"));
        screen.setCrdsel1(values.get("CRDSEL1"));
        screen.setAcctno1(values.get("ACCTNO1"));
        screen.setCrdnum1(values.get("CRDNUM1"));
        screen.setCrdsts1(values.get("CRDSTS1"));
        screen.setCrdsel2(values.get("CRDSEL2"));
        screen.setCrdstp2(values.get("CRDSTP2"));
        screen.setAcctno2(values.get("ACCTNO2"));
        screen.setCrdnum2(values.get("CRDNUM2"));
        screen.setCrdsts2(values.get("CRDSTS2"));
        screen.setCrdsel3(values.get("CRDSEL3"));
        screen.setCrdstp3(values.get("CRDSTP3"));
        screen.setAcctno3(values.get("ACCTNO3"));
        screen.setCrdnum3(values.get("CRDNUM3"));
        screen.setCrdsts3(values.get("CRDSTS3"));
        screen.setCrdsel4(values.get("CRDSEL4"));
        screen.setCrdstp4(values.get("CRDSTP4"));
        screen.setAcctno4(values.get("ACCTNO4"));
        screen.setCrdnum4(values.get("CRDNUM4"));
        screen.setCrdsts4(values.get("CRDSTS4"));
        screen.setCrdsel5(values.get("CRDSEL5"));
        screen.setCrdstp5(values.get("CRDSTP5"));
        screen.setAcctno5(values.get("ACCTNO5"));
        screen.setCrdnum5(values.get("CRDNUM5"));
        screen.setCrdsts5(values.get("CRDSTS5"));
        screen.setCrdsel6(values.get("CRDSEL6"));
        screen.setCrdstp6(values.get("CRDSTP6"));
        screen.setAcctno6(values.get("ACCTNO6"));
        screen.setCrdnum6(values.get("CRDNUM6"));
        screen.setCrdsts6(values.get("CRDSTS6"));
        screen.setCrdsel7(values.get("CRDSEL7"));
        screen.setCrdstp7(values.get("CRDSTP7"));
        screen.setAcctno7(values.get("ACCTNO7"));
        screen.setCrdnum7(values.get("CRDNUM7"));
        screen.setCrdsts7(values.get("CRDSTS7"));
        screen.setInfomsg(values.get("INFOMSG"));
        screen.setErrmsg(values.get("ERRMSG"));
        return screen;
    }
}
