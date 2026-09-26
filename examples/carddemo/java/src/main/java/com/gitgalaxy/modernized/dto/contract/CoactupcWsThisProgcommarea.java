package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record WS-THIS-PROGCOMMAREA (app/cbl/COACTUPC.cbl), 873 bytes, from GitGalaxy's verified skeleton.
 * Bytes 160-1032 of the COMMAREA Coactupc reads: MOVE DFHCOMMAREA(LENGTH OF CARDDEMO-COMMAREA + 1:LENGTH OF WS-THIS-PROGCOMMAREA) at app/cbl/COACTUPC.cbl:890.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CoactupcWsThisProgcommarea {

    // ACUP-CHANGE-ACTION: PIC X(1), offset 0, 1 bytes (app/cbl/COACTUPC.cbl)
    private String acupChangeAction;

    // ACUP-OLD-ACCT-ID-X: PIC X(11), offset 1, 11 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldAcctIdX;

    // ACUP-OLD-ACTIVE-STATUS: PIC X(01), offset 12, 1 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldActiveStatus;

    // ACUP-OLD-CURR-BAL: PIC X(12), offset 13, 12 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCurrBal;

    // ACUP-OLD-CREDIT-LIMIT: PIC X(12), offset 25, 12 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCreditLimit;

    // ACUP-OLD-CASH-CREDIT-LIMIT: PIC X(12), offset 37, 12 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCashCreditLimit;

    // ACUP-OLD-OPEN-DATE: PIC X(08), offset 49, 8 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldOpenDate;

    // ACUP-OLD-EXPIRAION-DATE: PIC X(08), offset 57, 8 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldExpiraionDate;

    // ACUP-OLD-REISSUE-DATE: PIC X(08), offset 65, 8 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldReissueDate;

    // ACUP-OLD-CURR-CYC-CREDIT: PIC X(12), offset 73, 12 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCurrCycCredit;

    // ACUP-OLD-CURR-CYC-DEBIT: PIC X(12), offset 85, 12 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCurrCycDebit;

    // ACUP-OLD-GROUP-ID: PIC X(10), offset 97, 10 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldGroupId;

    // ACUP-OLD-CUST-ID-X: PIC X(09), offset 107, 9 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustIdX;

    // ACUP-OLD-CUST-FIRST-NAME: PIC X(25), offset 116, 25 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustFirstName;

    // ACUP-OLD-CUST-MIDDLE-NAME: PIC X(25), offset 141, 25 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustMiddleName;

    // ACUP-OLD-CUST-LAST-NAME: PIC X(25), offset 166, 25 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustLastName;

    // ACUP-OLD-CUST-ADDR-LINE-1: PIC X(50), offset 191, 50 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustAddrLine1;

    // ACUP-OLD-CUST-ADDR-LINE-2: PIC X(50), offset 241, 50 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustAddrLine2;

    // ACUP-OLD-CUST-ADDR-LINE-3: PIC X(50), offset 291, 50 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustAddrLine3;

    // ACUP-OLD-CUST-ADDR-STATE-CD: PIC X(02), offset 341, 2 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustAddrStateCd;

    // ACUP-OLD-CUST-ADDR-COUNTRY-CD: PIC X(03), offset 343, 3 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustAddrCountryCd;

    // ACUP-OLD-CUST-ADDR-ZIP: PIC X(10), offset 346, 10 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustAddrZip;

    // ACUP-OLD-CUST-PHONE-NUM-1: PIC X(15), offset 356, 15 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustPhoneNum1;

    // ACUP-OLD-CUST-PHONE-NUM-2: PIC X(15), offset 371, 15 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustPhoneNum2;

    // ACUP-OLD-CUST-SSN-X: PIC X(09), offset 386, 9 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustSsnX;

    // ACUP-OLD-CUST-GOVT-ISSUED-ID: PIC X(20), offset 395, 20 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustGovtIssuedId;

    // ACUP-OLD-CUST-DOB-YYYY-MM-DD: PIC X(08), offset 415, 8 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustDobYyyyMmDd;

    // ACUP-OLD-CUST-EFT-ACCOUNT-ID: PIC X(10), offset 423, 10 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustEftAccountId;

    // ACUP-OLD-CUST-PRI-HOLDER-IND: PIC X(01), offset 433, 1 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustPriHolderInd;

    // ACUP-OLD-CUST-FICO-SCORE-X: PIC X(03), offset 434, 3 bytes (app/cbl/COACTUPC.cbl)
    private String acupOldCustFicoScoreX;

    // ACUP-NEW-ACCT-ID-X: PIC X(11), offset 437, 11 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewAcctIdX;

    // ACUP-NEW-ACTIVE-STATUS: PIC X(01), offset 448, 1 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewActiveStatus;

    // ACUP-NEW-CURR-BAL: PIC X(12), offset 449, 12 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCurrBal;

    // ACUP-NEW-CREDIT-LIMIT: PIC X(12), offset 461, 12 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCreditLimit;

    // ACUP-NEW-CASH-CREDIT-LIMIT: PIC X(12), offset 473, 12 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCashCreditLimit;

    // ACUP-NEW-OPEN-DATE: PIC X(08), offset 485, 8 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewOpenDate;

    // ACUP-NEW-EXPIRAION-DATE: PIC X(08), offset 493, 8 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewExpiraionDate;

    // ACUP-NEW-REISSUE-DATE: PIC X(08), offset 501, 8 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewReissueDate;

    // ACUP-NEW-CURR-CYC-CREDIT: PIC X(12), offset 509, 12 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCurrCycCredit;

    // ACUP-NEW-CURR-CYC-DEBIT: PIC X(12), offset 521, 12 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCurrCycDebit;

    // ACUP-NEW-GROUP-ID: PIC X(10), offset 533, 10 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewGroupId;

    // ACUP-NEW-CUST-ID-X: PIC X(09), offset 543, 9 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustIdX;

    // ACUP-NEW-CUST-FIRST-NAME: PIC X(25), offset 552, 25 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustFirstName;

    // ACUP-NEW-CUST-MIDDLE-NAME: PIC X(25), offset 577, 25 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustMiddleName;

    // ACUP-NEW-CUST-LAST-NAME: PIC X(25), offset 602, 25 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustLastName;

    // ACUP-NEW-CUST-ADDR-LINE-1: PIC X(50), offset 627, 50 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustAddrLine1;

    // ACUP-NEW-CUST-ADDR-LINE-2: PIC X(50), offset 677, 50 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustAddrLine2;

    // ACUP-NEW-CUST-ADDR-LINE-3: PIC X(50), offset 727, 50 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustAddrLine3;

    // ACUP-NEW-CUST-ADDR-STATE-CD: PIC X(02), offset 777, 2 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustAddrStateCd;

    // ACUP-NEW-CUST-ADDR-COUNTRY-CD: PIC X(03), offset 779, 3 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustAddrCountryCd;

    // ACUP-NEW-CUST-ADDR-ZIP: PIC X(10), offset 782, 10 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustAddrZip;

    // ACUP-NEW-CUST-PHONE-NUM-1: PIC X(15), offset 792, 15 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustPhoneNum1;

    // ACUP-NEW-CUST-PHONE-NUM-2: PIC X(15), offset 807, 15 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustPhoneNum2;

    // ACUP-NEW-CUST-SSN-1: PIC X(03), offset 822, 3 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustSsn1;

    // ACUP-NEW-CUST-SSN-2: PIC X(02), offset 825, 2 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustSsn2;

    // ACUP-NEW-CUST-SSN-3: PIC X(04), offset 827, 4 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustSsn3;

    // ACUP-NEW-CUST-GOVT-ISSUED-ID: PIC X(20), offset 831, 20 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustGovtIssuedId;

    // ACUP-NEW-CUST-DOB-YYYY-MM-DD: PIC X(08), offset 851, 8 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustDobYyyyMmDd;

    // ACUP-NEW-CUST-EFT-ACCOUNT-ID: PIC X(10), offset 859, 10 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustEftAccountId;

    // ACUP-NEW-CUST-PRI-HOLDER-IND: PIC X(01), offset 869, 1 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustPriHolderInd;

    // ACUP-NEW-CUST-FICO-SCORE-X: PIC X(03), offset 870, 3 bytes (app/cbl/COACTUPC.cbl)
    private String acupNewCustFicoScoreX;

}