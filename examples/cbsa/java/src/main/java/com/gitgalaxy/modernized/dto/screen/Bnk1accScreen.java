package com.gitgalaxy.modernized.dto.screen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BMS map BNK1ACC of mapset BNK1ACC (src/base/bms_src/BNK1ACC.bms): the screen as a view model (#3619).
 * SEND at src/base/cobol_src/BNK1CCA.cbl:622, src/base/cobol_src/BNK1CCA.cbl:696, src/base/cobol_src/BNK1CCA.cbl:772; RECEIVE at src/base/cobol_src/BNK1CCA.cbl:333.
 * One property per named field (symbolic map BNK1ACCI / BNK1ACCO); LAYOUT is every field in
 * screen order, labels included. BMS screen fields field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Bnk1accScreen implements ScreenModel {

    public static final String MAPSET = "BNK1ACC";
    public static final String MAP = "BNK1ACC";
    public static final List<ScreenField> LAYOUT = List.of(
            new ScreenField(null, 1, 1, 7, false, false, false, false, false, "BNK1ACC", "BLUE", 1),
            new ScreenField("COMPANY", 1, 14, 60, false, false, false, false, false, "CICS Bank Sample Application - Accounts for Customers.", "RED", 1),
            new ScreenField(null, 3, 1, 44, false, false, false, false, false, "Provide a Customer number. Then press Enter.", "TURQUOISE", 1),
            new ScreenField(null, 5, 1, 15, false, false, false, false, false, "CUSTOMER NUMBER", "TURQUOISE", 1),
            new ScreenField("CUSTNO", 5, 17, 10, false, true, false, false, true, null, "GREEN", 1),
            new ScreenField(null, 5, 28, 1, false, false, false, false, false, null, null, 1),
            new ScreenField(null, 8, 1, 41, false, false, false, false, false, "SORT CODE   ACCOUNT NUMBER   ACCOUNT TYPE", "NEUTRAL", 1),
            new ScreenField(null, 8, 43, 33, false, false, false, false, false, "   AVAIL BALANCE   ACTUAL BALANCE", "NEUTRAL", 1),
            new ScreenField("ACCOUNT", 9, 1, 79, false, false, false, false, false, null, "NEUTRAL", 10),
            new ScreenField("MESSAGE", 23, 1, 79, false, false, true, false, false, null, "YELLOW", 1),
            new ScreenField(null, 24, 1, 20, false, false, false, false, false, "F3=Exit   F12=Cancel", "BLUE", 1),
            new ScreenField("DUMMY", 24, 79, 1, false, false, false, true, false, " ", null, 1));

    /** COMPANY: (1,14), 60 bytes, ATTRB=NORM,PROT -- src/base/bms_src/BNK1ACC.bms:30. Symbolic map COMPANYI, COMPANYO. */
    private String company;

    /** CUSTNO: (5,17), 10 bytes, ATTRB=IC,NORM,NUM -- src/base/bms_src/BNK1ACC.bms:38. Symbolic map CUSTNOI, CUSTNOO. */
    private String custno;

    /** ACCOUNT: (9,1), 79 bytes, ATTRB=ASKIP,FSET,NORM,PROT; OCCURS=10 -- src/base/bms_src/BNK1ACC.bms:47. Symbolic map ACCOUNTI, ACCOUNTO. */
    private List<String> account;

    /** MESSAGE: (23,1), 79 bytes, ATTRB=ASKIP,BRT,PROT -- src/base/bms_src/BNK1ACC.bms:50. Symbolic map MESSAGEI, MESSAGEO. */
    private String message;

    /** DUMMY: (24,79), 1 bytes, ATTRB=ASKIP,DRK,FSET,PROT -- src/base/bms_src/BNK1ACC.bms:55. Symbolic map DUMMYI, DUMMYO. */
    private String dummy;

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
        values.put("COMPANY", company);
        values.put("CUSTNO", custno);
        if (account != null) {
            for (int i = 0; i < account.size(); i++) {
                values.put("ACCOUNT" + "." + (i + 1), account.get(i));
            }
        }
        values.put("MESSAGE", message);
        values.put("DUMMY", dummy);
        return values;
    }

    /** A view model from posted form values (keys as `screenValues` writes them). */
    public static Bnk1accScreen fromValues(Map<String, String> values) {
        Bnk1accScreen screen = new Bnk1accScreen();
        screen.setCompany(values.get("COMPANY"));
        screen.setCustno(values.get("CUSTNO"));
        {
            List<String> items = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                items.add(values.get("ACCOUNT" + "." + i));
            }
            screen.setAccount(items);
        }
        screen.setMessage(values.get("MESSAGE"));
        screen.setDummy(values.get("DUMMY"));
        return screen;
    }
}
