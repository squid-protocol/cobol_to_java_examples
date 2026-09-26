package com.gitgalaxy.modernized.dto.db2;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * DB2 table CONTROL, STTESTER.CONTROL, as DECLAREd at src/base/cobol_copy/CONTDB2.cpy:7.
 * No primary key is declared, so this is a row, not a JPA entity.
 * DB2 table access field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class ControlRow {

    // CONTROL_NAME CHAR(32) NOT NULL (column 1)
    private String controlName;

    // CONTROL_VALUE_NUM INTEGER (column 2)
    private Integer controlValueNum;

    // CONTROL_VALUE_STR CHAR(40) (column 3)
    private String controlValueStr;

}