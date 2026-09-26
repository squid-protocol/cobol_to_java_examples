package com.gitgalaxy.modernized.dto.screen;

/**
 * One BMS field (DFHMDF) of a map: where it sits on the 3270 screen and how it behaves (#3619).
 * `name` is null for a screen literal (a label, which never reaches the symbolic map); `line` / `column`
 * are POS=(line,column) -- the attribute byte, so the data starts one column after it; `input` is
 * ATTRB=UNPROT, `numeric` ATTRB=NUM, `bright` BRT, `dark` DRK, `cursor` IC; `initial` the INITIAL text;
 * `occurs` the OCCURS count (1 without one).
 */
public record ScreenField(String name, int line, int column, int length, boolean input, boolean numeric,
                          boolean bright, boolean dark, boolean cursor, String initial, String color, int occurs) {
}
