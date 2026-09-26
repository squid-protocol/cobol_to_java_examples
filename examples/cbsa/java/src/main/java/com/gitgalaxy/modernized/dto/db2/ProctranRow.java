package com.gitgalaxy.modernized.dto.db2;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * DB2 table PROCTRAN, as DECLAREd at src/base/cobol_copy/PROCDB2.cpy:7.
 * No primary key is declared, so this is a row, not a JPA entity.
 * DB2 table access field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class ProctranRow {

    // PROCTRAN_EYECATCHER CHAR(4) (column 1)
    private String proctranEyecatcher;

    // PROCTRAN_SORTCODE CHAR(6) NOT NULL (column 2)
    private String proctranSortcode;

    // PROCTRAN_NUMBER CHAR(8) NOT NULL (column 3)
    private String proctranNumber;

    // PROCTRAN_DATE CHAR(8) (column 4)
    private String proctranDate;

    // PROCTRAN_TIME CHAR(6) (column 5)
    private String proctranTime;

    // PROCTRAN_REF CHAR(12) (column 6)
    private String proctranRef;

    // PROCTRAN_TYPE CHAR(3) (column 7)
    private String proctranType;

    // PROCTRAN_DESC CHAR(40) (column 8)
    private String proctranDesc;

    // PROCTRAN_AMOUNT DECIMAL(12,2) (column 9)
    private BigDecimal proctranAmount;

}