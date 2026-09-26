package com.gitgalaxy.modernized.dto.db2;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * DB2 table CARDDEMO.TRANSACTION_TYPE, as DECLAREd at app/app-transaction-type-db2/dcl/DCLTRTYP.dcl:28.
 * No primary key is declared, so this is a row, not a JPA entity.
 * DB2 table access field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class TransactionTypeRow {

    // TR_TYPE CHAR(2) NOT NULL (column 1)
    private String trType;

    // TR_DESCRIPTION VARCHAR(50) NOT NULL (column 2)
    private String trDescription;

}