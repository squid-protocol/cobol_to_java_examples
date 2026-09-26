package com.gitgalaxy.modernized.dto.db2;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * DB2 table CARDDEMO.AUTHFRDS, as DECLAREd at app/app-authorization-ims-db2-mq/dcl/AUTHFRDS.dcl:24.
 * No primary key is declared, so this is a row, not a JPA entity.
 * DB2 table access field testing: open (3 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class AuthfrdsRow {

    // CARD_NUM CHAR(16) NOT NULL (column 1)
    private String cardNum;

    // AUTH_TS TIMESTAMP NOT NULL (column 2)
    private LocalDateTime authTs;

    // AUTH_TYPE CHAR(4) (column 3)
    private String authType;

    // CARD_EXPIRY_DATE CHAR(4) (column 4)
    private String cardExpiryDate;

    // MESSAGE_TYPE CHAR(6) (column 5)
    private String messageType;

    // MESSAGE_SOURCE CHAR(6) (column 6)
    private String messageSource;

    // AUTH_ID_CODE CHAR(6) (column 7)
    private String authIdCode;

    // AUTH_RESP_CODE CHAR(2) (column 8)
    private String authRespCode;

    // AUTH_RESP_REASON CHAR(4) (column 9)
    private String authRespReason;

    // PROCESSING_CODE CHAR(6) (column 10)
    private String processingCode;

    // TRANSACTION_AMT DECIMAL(12,2) (column 11)
    private BigDecimal transactionAmt;

    // APPROVED_AMT DECIMAL(12,2) (column 12)
    private BigDecimal approvedAmt;

    // MERCHANT_CATAGORY_CODE CHAR(4) (column 13)
    private String merchantCatagoryCode;

    // ACQR_COUNTRY_CODE CHAR(3) (column 14)
    private String acqrCountryCode;

    // POS_ENTRY_MODE SMALLINT (column 15)
    private Integer posEntryMode;

    // MERCHANT_ID CHAR(15) (column 16)
    private String merchantId;

    // MERCHANT_NAME VARCHAR(22) (column 17)
    private String merchantName;

    // MERCHANT_CITY CHAR(13) (column 18)
    private String merchantCity;

    // MERCHANT_STATE CHAR(2) (column 19)
    private String merchantState;

    // MERCHANT_ZIP CHAR(9) (column 20)
    private String merchantZip;

    // TRANSACTION_ID CHAR(15) (column 21)
    private String transactionId;

    // MATCH_STATUS CHAR(1) (column 22)
    private String matchStatus;

    // AUTH_FRAUD CHAR(1) (column 23)
    private String authFraud;

    // FRAUD_RPT_DATE DATE (column 24)
    private LocalDate fraudRptDate;

    // ACCT_ID DECIMAL(11,0) (column 25)
    private BigDecimal acctId;

    // CUST_ID DECIMAL(9,0) (column 26)
    private BigDecimal custId;

}