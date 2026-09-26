package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl), 272 bytes, from GitGalaxy's verified skeleton.
 * The DFHCOMMAREA Copaus2c declares in its LINKAGE SECTION.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class Copaus2cDfhcommarea {

    // WS-ACCT-ID: PIC 9(11), offset 0, 11 bytes (app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl)
    private Long wsAcctId;

    // WS-CUST-ID: PIC 9(9), offset 11, 9 bytes (app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl)
    private Integer wsCustId;

    // PA-AUTH-DATE-9C: PIC S9(05) COMP-3, offset 20, 3 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private Integer paAuthDate9C;

    // PA-AUTH-TIME-9C: PIC S9(09) COMP-3, offset 23, 5 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private Integer paAuthTime9C;

    // PA-AUTH-ORIG-DATE: PIC X(06), offset 28, 6 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paAuthOrigDate;

    // PA-AUTH-ORIG-TIME: PIC X(06), offset 34, 6 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paAuthOrigTime;

    // PA-CARD-NUM: PIC X(16), offset 40, 16 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paCardNum;

    // PA-AUTH-TYPE: PIC X(04), offset 56, 4 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paAuthType;

    // PA-CARD-EXPIRY-DATE: PIC X(04), offset 60, 4 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paCardExpiryDate;

    // PA-MESSAGE-TYPE: PIC X(06), offset 64, 6 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paMessageType;

    // PA-MESSAGE-SOURCE: PIC X(06), offset 70, 6 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paMessageSource;

    // PA-AUTH-ID-CODE: PIC X(06), offset 76, 6 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paAuthIdCode;

    // PA-AUTH-RESP-CODE: PIC X(02), offset 82, 2 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paAuthRespCode;

    // PA-AUTH-RESP-REASON: PIC X(04), offset 84, 4 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paAuthRespReason;

    // PA-PROCESSING-CODE: PIC 9(06), offset 88, 6 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private Integer paProcessingCode;

    // PA-TRANSACTION-AMT: PIC S9(10)V99 COMP-3, offset 94, 7 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private BigDecimal paTransactionAmt;

    // PA-APPROVED-AMT: PIC S9(10)V99 COMP-3, offset 101, 7 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private BigDecimal paApprovedAmt;

    // PA-MERCHANT-CATAGORY-CODE: PIC X(04), offset 108, 4 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paMerchantCatagoryCode;

    // PA-ACQR-COUNTRY-CODE: PIC X(03), offset 112, 3 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paAcqrCountryCode;

    // PA-POS-ENTRY-MODE: PIC 9(02), offset 115, 2 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private Integer paPosEntryMode;

    // PA-MERCHANT-ID: PIC X(15), offset 117, 15 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paMerchantId;

    // PA-MERCHANT-NAME: PIC X(22), offset 132, 22 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paMerchantName;

    // PA-MERCHANT-CITY: PIC X(13), offset 154, 13 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paMerchantCity;

    // PA-MERCHANT-STATE: PIC X(02), offset 167, 2 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paMerchantState;

    // PA-MERCHANT-ZIP: PIC X(09), offset 169, 9 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paMerchantZip;

    // PA-TRANSACTION-ID: PIC X(15), offset 178, 15 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paTransactionId;

    // PA-MATCH-STATUS: PIC X(01), offset 193, 1 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paMatchStatus;

    // PA-AUTH-FRAUD: PIC X(01), offset 194, 1 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paAuthFraud;

    // PA-FRAUD-RPT-DATE: PIC X(08), offset 195, 8 bytes (app/app-authorization-ims-db2-mq/cpy/CIPAUDTY.cpy)
    private String paFraudRptDate;

    // WS-FRD-ACTION: PIC X(01), offset 220, 1 bytes (app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl)
    private String wsFrdAction;

    // WS-FRD-UPDATE-STATUS: PIC X(01), offset 221, 1 bytes (app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl)
    private String wsFrdUpdateStatus;

    // WS-FRD-ACT-MSG: PIC X(50), offset 222, 50 bytes (app/app-authorization-ims-db2-mq/cbl/COPAUS2C.cbl)
    private String wsFrdActMsg;

}