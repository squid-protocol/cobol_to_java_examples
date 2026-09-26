package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map COUSR0A of mapset COUSR00 (app/bms/COUSR00.bms): the screen as a view model (#3619).
 * SEND at app/cbl/COUSR00C.cbl:529, app/cbl/COUSR00C.cbl:537; RECEIVE at app/cbl/COUSR00C.cbl:551.
 * One property per named field (symbolic map COUSR0AI / COUSR0AO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Cousr0aScreen implements ScreenModel {

    public static final String MAPSET = "COUSR00";
    public static final String MAP = "COUSR0A";
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
            new ScreenField(null, 4, 35, 10, false, false, true, false, false, "List Users", "NEUTRAL", 1),
            new ScreenField(null, 4, 65, 5, false, false, true, false, false, "Page:", "TURQUOISE", 1),
            new ScreenField("PAGENUM", 4, 71, 8, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 6, 5, 15, false, false, false, false, false, "Search User ID:", "TURQUOISE", 1),
            new ScreenField("USRIDIN", 6, 21, 8, true, false, false, false, false, null, "GREEN", 1),
            new ScreenField(null, 6, 30, 0, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 8, 5, 3, false, false, false, false, false, "Sel", "NEUTRAL", 1),
            new ScreenField(null, 8, 12, 8, false, false, false, false, false, "User ID ", "NEUTRAL", 1),
            new ScreenField(null, 8, 24, 20, false, false, false, false, false, "     First Name     ", "NEUTRAL", 1),
            new ScreenField(null, 8, 48, 20, false, false, false, false, false, "     Last Name      ", "NEUTRAL", 1),
            new ScreenField(null, 8, 72, 4, false, false, false, false, false, "Type", "NEUTRAL", 1),
            new ScreenField(null, 9, 5, 3, false, false, false, false, false, "---", "NEUTRAL", 1),
            new ScreenField(null, 9, 12, 8, false, false, false, false, false, "--------", "NEUTRAL", 1),
            new ScreenField(null, 9, 24, 20, false, false, false, false, false, "--------------------", "NEUTRAL", 1),
            new ScreenField(null, 9, 48, 20, false, false, false, false, false, "--------------------", "NEUTRAL", 1),
            new ScreenField(null, 9, 72, 4, false, false, false, false, false, "----", "NEUTRAL", 1),
            new ScreenField("SEL0001", 10, 6, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 10, 8, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("USRID01", 10, 12, 8, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("FNAME01", 10, 24, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("LNAME01", 10, 48, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("UTYPE01", 10, 73, 1, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("SEL0002", 11, 6, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 11, 8, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("USRID02", 11, 12, 8, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("FNAME02", 11, 24, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("LNAME02", 11, 48, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("UTYPE02", 11, 73, 1, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("SEL0003", 12, 6, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 12, 8, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("USRID03", 12, 12, 8, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("FNAME03", 12, 24, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("LNAME03", 12, 48, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("UTYPE03", 12, 73, 1, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("SEL0004", 13, 6, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 13, 8, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("USRID04", 13, 12, 8, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("FNAME04", 13, 24, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("LNAME04", 13, 48, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("UTYPE04", 13, 73, 1, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("SEL0005", 14, 6, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 14, 8, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("USRID05", 14, 12, 8, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("FNAME05", 14, 24, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("LNAME05", 14, 48, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("UTYPE05", 14, 73, 1, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("SEL0006", 15, 6, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 15, 8, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("USRID06", 15, 12, 8, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("FNAME06", 15, 24, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("LNAME06", 15, 48, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("UTYPE06", 15, 73, 1, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("SEL0007", 16, 6, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 16, 8, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("USRID07", 16, 12, 8, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("FNAME07", 16, 24, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("LNAME07", 16, 48, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("UTYPE07", 16, 73, 1, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("SEL0008", 17, 6, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 17, 8, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("USRID08", 17, 12, 8, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("FNAME08", 17, 24, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("LNAME08", 17, 48, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("UTYPE08", 17, 73, 1, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("SEL0009", 18, 6, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 18, 8, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("USRID09", 18, 12, 8, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("FNAME09", 18, 24, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("LNAME09", 18, 48, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("UTYPE09", 18, 73, 1, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("SEL0010", 19, 6, 1, true, false, false, false, false, " ", "GREEN", 1),
            new ScreenField(null, 19, 8, 0, false, false, false, false, false, null, null, 1),
            new ScreenField("USRID10", 19, 12, 8, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("FNAME10", 19, 24, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("LNAME10", 19, 48, 20, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField("UTYPE10", 19, 73, 1, false, false, false, false, false, " ", "BLUE", 1),
            new ScreenField(null, 21, 12, 56, false, false, true, false, false, "Type 'U' to Update or 'D' to Delete a User from the list", "NEUTRAL", 1),
            new ScreenField("ERRMSG", 23, 1, 78, false, false, true, false, false, null, "RED", 1),
            new ScreenField(null, 24, 1, 48, false, false, false, false, false, "ENTER=Continue  F3=Back  F7=Backward  F8=Forward", "YELLOW", 1));

    /** TRNNAME: (1,7), 4 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:34. Symbolic map TRNNAMEI, TRNNAMEO. */
    private String trnname;

    /** TITLE01: (1,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:38. Symbolic map TITLE01I, TITLE01O. */
    private String title01;

    /** CURDATE: (1,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:47. Symbolic map CURDATEI, CURDATEO. */
    private String curdate;

    /** PGMNAME: (2,7), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:57. Symbolic map PGMNAMEI, PGMNAMEO. */
    private String pgmname;

    /** TITLE02: (2,21), 40 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:61. Symbolic map TITLE02I, TITLE02O. */
    private String title02;

    /** CURTIME: (2,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:70. Symbolic map CURTIMEI, CURTIMEO. */
    private String curtime;

    /** PAGENUM: (4,71), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:85. Symbolic map PAGENUMI, PAGENUMO. */
    private String pagenum;

    /** USRIDIN: (6,21), 8 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR00.bms:95. Symbolic map USRIDINI, USRIDINO. */
    private String usridin;

    /** SEL0001: (10,6), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR00.bms:153. Symbolic map SEL0001I, SEL0001O. */
    private String sel0001;

    /** USRID01: (10,12), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:162. Symbolic map USRID01I, USRID01O. */
    private String usrid01;

    /** FNAME01: (10,24), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:167. Symbolic map FNAME01I, FNAME01O. */
    private String fname01;

    /** LNAME01: (10,48), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:172. Symbolic map LNAME01I, LNAME01O. */
    private String lname01;

    /** UTYPE01: (10,73), 1 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:177. Symbolic map UTYPE01I, UTYPE01O. */
    private String utype01;

    /** SEL0002: (11,6), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR00.bms:182. Symbolic map SEL0002I, SEL0002O. */
    private String sel0002;

    /** USRID02: (11,12), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:191. Symbolic map USRID02I, USRID02O. */
    private String usrid02;

    /** FNAME02: (11,24), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:196. Symbolic map FNAME02I, FNAME02O. */
    private String fname02;

    /** LNAME02: (11,48), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:201. Symbolic map LNAME02I, LNAME02O. */
    private String lname02;

    /** UTYPE02: (11,73), 1 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:206. Symbolic map UTYPE02I, UTYPE02O. */
    private String utype02;

    /** SEL0003: (12,6), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR00.bms:211. Symbolic map SEL0003I, SEL0003O. */
    private String sel0003;

    /** USRID03: (12,12), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:220. Symbolic map USRID03I, USRID03O. */
    private String usrid03;

    /** FNAME03: (12,24), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:225. Symbolic map FNAME03I, FNAME03O. */
    private String fname03;

    /** LNAME03: (12,48), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:230. Symbolic map LNAME03I, LNAME03O. */
    private String lname03;

    /** UTYPE03: (12,73), 1 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:235. Symbolic map UTYPE03I, UTYPE03O. */
    private String utype03;

    /** SEL0004: (13,6), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR00.bms:240. Symbolic map SEL0004I, SEL0004O. */
    private String sel0004;

    /** USRID04: (13,12), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:249. Symbolic map USRID04I, USRID04O. */
    private String usrid04;

    /** FNAME04: (13,24), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:254. Symbolic map FNAME04I, FNAME04O. */
    private String fname04;

    /** LNAME04: (13,48), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:259. Symbolic map LNAME04I, LNAME04O. */
    private String lname04;

    /** UTYPE04: (13,73), 1 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:264. Symbolic map UTYPE04I, UTYPE04O. */
    private String utype04;

    /** SEL0005: (14,6), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR00.bms:269. Symbolic map SEL0005I, SEL0005O. */
    private String sel0005;

    /** USRID05: (14,12), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:278. Symbolic map USRID05I, USRID05O. */
    private String usrid05;

    /** FNAME05: (14,24), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:283. Symbolic map FNAME05I, FNAME05O. */
    private String fname05;

    /** LNAME05: (14,48), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:288. Symbolic map LNAME05I, LNAME05O. */
    private String lname05;

    /** UTYPE05: (14,73), 1 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:293. Symbolic map UTYPE05I, UTYPE05O. */
    private String utype05;

    /** SEL0006: (15,6), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR00.bms:298. Symbolic map SEL0006I, SEL0006O. */
    private String sel0006;

    /** USRID06: (15,12), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:307. Symbolic map USRID06I, USRID06O. */
    private String usrid06;

    /** FNAME06: (15,24), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:312. Symbolic map FNAME06I, FNAME06O. */
    private String fname06;

    /** LNAME06: (15,48), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:317. Symbolic map LNAME06I, LNAME06O. */
    private String lname06;

    /** UTYPE06: (15,73), 1 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:322. Symbolic map UTYPE06I, UTYPE06O. */
    private String utype06;

    /** SEL0007: (16,6), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR00.bms:327. Symbolic map SEL0007I, SEL0007O. */
    private String sel0007;

    /** USRID07: (16,12), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:336. Symbolic map USRID07I, USRID07O. */
    private String usrid07;

    /** FNAME07: (16,24), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:341. Symbolic map FNAME07I, FNAME07O. */
    private String fname07;

    /** LNAME07: (16,48), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:346. Symbolic map LNAME07I, LNAME07O. */
    private String lname07;

    /** UTYPE07: (16,73), 1 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:351. Symbolic map UTYPE07I, UTYPE07O. */
    private String utype07;

    /** SEL0008: (17,6), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR00.bms:356. Symbolic map SEL0008I, SEL0008O. */
    private String sel0008;

    /** USRID08: (17,12), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:365. Symbolic map USRID08I, USRID08O. */
    private String usrid08;

    /** FNAME08: (17,24), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:370. Symbolic map FNAME08I, FNAME08O. */
    private String fname08;

    /** LNAME08: (17,48), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:375. Symbolic map LNAME08I, LNAME08O. */
    private String lname08;

    /** UTYPE08: (17,73), 1 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:380. Symbolic map UTYPE08I, UTYPE08O. */
    private String utype08;

    /** SEL0009: (18,6), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR00.bms:385. Symbolic map SEL0009I, SEL0009O. */
    private String sel0009;

    /** USRID09: (18,12), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:394. Symbolic map USRID09I, USRID09O. */
    private String usrid09;

    /** FNAME09: (18,24), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:399. Symbolic map FNAME09I, FNAME09O. */
    private String fname09;

    /** LNAME09: (18,48), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:404. Symbolic map LNAME09I, LNAME09O. */
    private String lname09;

    /** UTYPE09: (18,73), 1 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:409. Symbolic map UTYPE09I, UTYPE09O. */
    private String utype09;

    /** SEL0010: (19,6), 1 bytes, ATTRB=FSET,NORM,UNPROT -- app/bms/COUSR00.bms:414. Symbolic map SEL0010I, SEL0010O. */
    private String sel0010;

    /** USRID10: (19,12), 8 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:423. Symbolic map USRID10I, USRID10O. */
    private String usrid10;

    /** FNAME10: (19,24), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:428. Symbolic map FNAME10I, FNAME10O. */
    private String fname10;

    /** LNAME10: (19,48), 20 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:433. Symbolic map LNAME10I, LNAME10O. */
    private String lname10;

    /** UTYPE10: (19,73), 1 bytes, ATTRB=ASKIP,FSET,NORM -- app/bms/COUSR00.bms:438. Symbolic map UTYPE10I, UTYPE10O. */
    private String utype10;

    /** ERRMSG: (23,1), 78 bytes, ATTRB=ASKIP,BRT,FSET -- app/bms/COUSR00.bms:449. Symbolic map ERRMSGI, ERRMSGO. */
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
        values.put("PAGENUM", pagenum);
        values.put("USRIDIN", usridin);
        values.put("SEL0001", sel0001);
        values.put("USRID01", usrid01);
        values.put("FNAME01", fname01);
        values.put("LNAME01", lname01);
        values.put("UTYPE01", utype01);
        values.put("SEL0002", sel0002);
        values.put("USRID02", usrid02);
        values.put("FNAME02", fname02);
        values.put("LNAME02", lname02);
        values.put("UTYPE02", utype02);
        values.put("SEL0003", sel0003);
        values.put("USRID03", usrid03);
        values.put("FNAME03", fname03);
        values.put("LNAME03", lname03);
        values.put("UTYPE03", utype03);
        values.put("SEL0004", sel0004);
        values.put("USRID04", usrid04);
        values.put("FNAME04", fname04);
        values.put("LNAME04", lname04);
        values.put("UTYPE04", utype04);
        values.put("SEL0005", sel0005);
        values.put("USRID05", usrid05);
        values.put("FNAME05", fname05);
        values.put("LNAME05", lname05);
        values.put("UTYPE05", utype05);
        values.put("SEL0006", sel0006);
        values.put("USRID06", usrid06);
        values.put("FNAME06", fname06);
        values.put("LNAME06", lname06);
        values.put("UTYPE06", utype06);
        values.put("SEL0007", sel0007);
        values.put("USRID07", usrid07);
        values.put("FNAME07", fname07);
        values.put("LNAME07", lname07);
        values.put("UTYPE07", utype07);
        values.put("SEL0008", sel0008);
        values.put("USRID08", usrid08);
        values.put("FNAME08", fname08);
        values.put("LNAME08", lname08);
        values.put("UTYPE08", utype08);
        values.put("SEL0009", sel0009);
        values.put("USRID09", usrid09);
        values.put("FNAME09", fname09);
        values.put("LNAME09", lname09);
        values.put("UTYPE09", utype09);
        values.put("SEL0010", sel0010);
        values.put("USRID10", usrid10);
        values.put("FNAME10", fname10);
        values.put("LNAME10", lname10);
        values.put("UTYPE10", utype10);
        values.put("ERRMSG", errmsg);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Cousr0aScreen fromValues(Map<String, String> values) {
        Cousr0aScreen screen = new Cousr0aScreen();
        screen.setTrnname(values.get("TRNNAME"));
        screen.setTitle01(values.get("TITLE01"));
        screen.setCurdate(values.get("CURDATE"));
        screen.setPgmname(values.get("PGMNAME"));
        screen.setTitle02(values.get("TITLE02"));
        screen.setCurtime(values.get("CURTIME"));
        screen.setPagenum(values.get("PAGENUM"));
        screen.setUsridin(values.get("USRIDIN"));
        screen.setSel0001(values.get("SEL0001"));
        screen.setUsrid01(values.get("USRID01"));
        screen.setFname01(values.get("FNAME01"));
        screen.setLname01(values.get("LNAME01"));
        screen.setUtype01(values.get("UTYPE01"));
        screen.setSel0002(values.get("SEL0002"));
        screen.setUsrid02(values.get("USRID02"));
        screen.setFname02(values.get("FNAME02"));
        screen.setLname02(values.get("LNAME02"));
        screen.setUtype02(values.get("UTYPE02"));
        screen.setSel0003(values.get("SEL0003"));
        screen.setUsrid03(values.get("USRID03"));
        screen.setFname03(values.get("FNAME03"));
        screen.setLname03(values.get("LNAME03"));
        screen.setUtype03(values.get("UTYPE03"));
        screen.setSel0004(values.get("SEL0004"));
        screen.setUsrid04(values.get("USRID04"));
        screen.setFname04(values.get("FNAME04"));
        screen.setLname04(values.get("LNAME04"));
        screen.setUtype04(values.get("UTYPE04"));
        screen.setSel0005(values.get("SEL0005"));
        screen.setUsrid05(values.get("USRID05"));
        screen.setFname05(values.get("FNAME05"));
        screen.setLname05(values.get("LNAME05"));
        screen.setUtype05(values.get("UTYPE05"));
        screen.setSel0006(values.get("SEL0006"));
        screen.setUsrid06(values.get("USRID06"));
        screen.setFname06(values.get("FNAME06"));
        screen.setLname06(values.get("LNAME06"));
        screen.setUtype06(values.get("UTYPE06"));
        screen.setSel0007(values.get("SEL0007"));
        screen.setUsrid07(values.get("USRID07"));
        screen.setFname07(values.get("FNAME07"));
        screen.setLname07(values.get("LNAME07"));
        screen.setUtype07(values.get("UTYPE07"));
        screen.setSel0008(values.get("SEL0008"));
        screen.setUsrid08(values.get("USRID08"));
        screen.setFname08(values.get("FNAME08"));
        screen.setLname08(values.get("LNAME08"));
        screen.setUtype08(values.get("UTYPE08"));
        screen.setSel0009(values.get("SEL0009"));
        screen.setUsrid09(values.get("USRID09"));
        screen.setFname09(values.get("FNAME09"));
        screen.setLname09(values.get("LNAME09"));
        screen.setUtype09(values.get("UTYPE09"));
        screen.setSel0010(values.get("SEL0010"));
        screen.setUsrid10(values.get("USRID10"));
        screen.setFname10(values.get("FNAME10"));
        screen.setLname10(values.get("LNAME10"));
        screen.setUtype10(values.get("UTYPE10"));
        screen.setErrmsg(values.get("ERRMSG"));
        return screen;
    }
}
