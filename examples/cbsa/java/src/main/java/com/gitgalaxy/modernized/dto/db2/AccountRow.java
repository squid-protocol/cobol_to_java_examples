package com.gitgalaxy.modernized.dto.db2;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * DB2 table ACCOUNT, as DECLAREd at src/base/cobol_copy/ACCDB2.cpy:7.
 * No primary key is declared, so this is a row, not a JPA entity.
 * DB2 table access field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class AccountRow {

    // ACCOUNT_EYECATCHER CHAR(4) (column 1)
    private String accountEyecatcher;

    // ACCOUNT_CUSTOMER_NUMBER CHAR(10) (column 2)
    private String accountCustomerNumber;

    // ACCOUNT_SORTCODE CHAR(6) NOT NULL (column 3)
    private String accountSortcode;

    // ACCOUNT_NUMBER CHAR(8) NOT NULL (column 4)
    private String accountNumber;

    // ACCOUNT_TYPE CHAR(8) (column 5)
    private String accountType;

    // ACCOUNT_INTEREST_RATE DECIMAL(4,2) (column 6)
    private BigDecimal accountInterestRate;

    // ACCOUNT_OPENED DATE (column 7)
    private LocalDate accountOpened;

    // ACCOUNT_OVERDRAFT_LIMIT INTEGER (column 8)
    private Integer accountOverdraftLimit;

    // ACCOUNT_LAST_STATEMENT DATE (column 9)
    private LocalDate accountLastStatement;

    // ACCOUNT_NEXT_STATEMENT DATE (column 10)
    private LocalDate accountNextStatement;

    // ACCOUNT_AVAILABLE_BALANCE DECIMAL(10,2) (column 11)
    private BigDecimal accountAvailableBalance;

    // ACCOUNT_ACTUAL_BALANCE DECIMAL(10,2) (column 12)
    private BigDecimal accountActualBalance;

}