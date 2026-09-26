package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM INDEXED AWS.M2.CARDDEMO.CUSTDATA.VSAM.KSDS (app/jcl/CUSTFILE.jcl:46),
 * record CUSTOMER-RECORD (app/cpy/CVCUS01Y.cpy, 500 bytes, RECORDSIZE 500).
 * Key: CUST-ID (offset 0, 9 bytes, from IDCAMS KEYS).
 * CICS files: CUSTDAT.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamCustomerRecord")
@Table(name = "vsam_custdata")
@Data
@NoArgsConstructor
public class CustomerRecord {

    // CUST-ID: PIC 9(09), offset 0, 9 bytes
    @Id
    @Column(name = "CUST_ID")
    private Integer custId;

    // CUST-FIRST-NAME: PIC X(25), offset 9, 25 bytes
    @Column(name = "CUST_FIRST_NAME", length = 25)
    private String custFirstName;

    // CUST-MIDDLE-NAME: PIC X(25), offset 34, 25 bytes
    @Column(name = "CUST_MIDDLE_NAME", length = 25)
    private String custMiddleName;

    // CUST-LAST-NAME: PIC X(25), offset 59, 25 bytes
    @Column(name = "CUST_LAST_NAME", length = 25)
    private String custLastName;

    // CUST-ADDR-LINE-1: PIC X(50), offset 84, 50 bytes
    @Column(name = "CUST_ADDR_LINE_1", length = 50)
    private String custAddrLine1;

    // CUST-ADDR-LINE-2: PIC X(50), offset 134, 50 bytes
    @Column(name = "CUST_ADDR_LINE_2", length = 50)
    private String custAddrLine2;

    // CUST-ADDR-LINE-3: PIC X(50), offset 184, 50 bytes
    @Column(name = "CUST_ADDR_LINE_3", length = 50)
    private String custAddrLine3;

    // CUST-ADDR-STATE-CD: PIC X(02), offset 234, 2 bytes
    @Column(name = "CUST_ADDR_STATE_CD", length = 2)
    private String custAddrStateCd;

    // CUST-ADDR-COUNTRY-CD: PIC X(03), offset 236, 3 bytes
    @Column(name = "CUST_ADDR_COUNTRY_CD", length = 3)
    private String custAddrCountryCd;

    // CUST-ADDR-ZIP: PIC X(10), offset 239, 10 bytes
    @Column(name = "CUST_ADDR_ZIP", length = 10)
    private String custAddrZip;

    // CUST-PHONE-NUM-1: PIC X(15), offset 249, 15 bytes
    @Column(name = "CUST_PHONE_NUM_1", length = 15)
    private String custPhoneNum1;

    // CUST-PHONE-NUM-2: PIC X(15), offset 264, 15 bytes
    @Column(name = "CUST_PHONE_NUM_2", length = 15)
    private String custPhoneNum2;

    // CUST-SSN: PIC 9(09), offset 279, 9 bytes
    @Column(name = "CUST_SSN")
    private Integer custSsn;

    // CUST-GOVT-ISSUED-ID: PIC X(20), offset 288, 20 bytes
    @Column(name = "CUST_GOVT_ISSUED_ID", length = 20)
    private String custGovtIssuedId;

    // CUST-DOB-YYYY-MM-DD: PIC X(10), offset 308, 10 bytes
    @Column(name = "CUST_DOB_YYYY_MM_DD", length = 10)
    private String custDobYyyyMmDd;

    // CUST-EFT-ACCOUNT-ID: PIC X(10), offset 318, 10 bytes
    @Column(name = "CUST_EFT_ACCOUNT_ID", length = 10)
    private String custEftAccountId;

    // CUST-PRI-CARD-HOLDER-IND: PIC X(01), offset 328, 1 bytes
    @Column(name = "CUST_PRI_CARD_HOLDER_IND", length = 1)
    private String custPriCardHolderInd;

    // CUST-FICO-CREDIT-SCORE: PIC 9(03), offset 329, 3 bytes
    @Column(name = "CUST_FICO_CREDIT_SCORE")
    private Integer custFicoCreditScore;


    /** #3624: this record from its fixed-width VSAM form (500 bytes, as REPRO unloads it), each
     *  field at its COBOL offset; `text` is the record's character set (ISO-8859-1 for an ASCII
     *  transfer, IBM037 on z/OS). FILLER bytes are not kept. */
    public static CustomerRecord fromRecord(byte[] rec, java.nio.charset.Charset text) {
        CustomerRecord r = new CustomerRecord();
        r.custId = CobolRecords.toInteger(CobolRecords.zoned(rec, 0, 9, 0, text));
        r.custFirstName = CobolRecords.text(rec, 9, 25, text);
        r.custMiddleName = CobolRecords.text(rec, 34, 25, text);
        r.custLastName = CobolRecords.text(rec, 59, 25, text);
        r.custAddrLine1 = CobolRecords.text(rec, 84, 50, text);
        r.custAddrLine2 = CobolRecords.text(rec, 134, 50, text);
        r.custAddrLine3 = CobolRecords.text(rec, 184, 50, text);
        r.custAddrStateCd = CobolRecords.text(rec, 234, 2, text);
        r.custAddrCountryCd = CobolRecords.text(rec, 236, 3, text);
        r.custAddrZip = CobolRecords.text(rec, 239, 10, text);
        r.custPhoneNum1 = CobolRecords.text(rec, 249, 15, text);
        r.custPhoneNum2 = CobolRecords.text(rec, 264, 15, text);
        r.custSsn = CobolRecords.toInteger(CobolRecords.zoned(rec, 279, 9, 0, text));
        r.custGovtIssuedId = CobolRecords.text(rec, 288, 20, text);
        r.custDobYyyyMmDd = CobolRecords.text(rec, 308, 10, text);
        r.custEftAccountId = CobolRecords.text(rec, 318, 10, text);
        r.custPriCardHolderInd = CobolRecords.text(rec, 328, 1, text);
        r.custFicoCreditScore = CobolRecords.toInteger(CobolRecords.zoned(rec, 329, 3, 0, text));
        return r;
    }

    /** #3624: the fixed-width VSAM record of this entity (FILLER as spaces). */
    public byte[] toRecord(java.nio.charset.Charset text) {
        byte[] rec = CobolRecords.blank(500, text);
        CobolRecords.putZoned(rec, 0, 9, 0, false, CobolRecords.decimal(custId), text);
        CobolRecords.putText(rec, 9, 25, custFirstName, text);
        CobolRecords.putText(rec, 34, 25, custMiddleName, text);
        CobolRecords.putText(rec, 59, 25, custLastName, text);
        CobolRecords.putText(rec, 84, 50, custAddrLine1, text);
        CobolRecords.putText(rec, 134, 50, custAddrLine2, text);
        CobolRecords.putText(rec, 184, 50, custAddrLine3, text);
        CobolRecords.putText(rec, 234, 2, custAddrStateCd, text);
        CobolRecords.putText(rec, 236, 3, custAddrCountryCd, text);
        CobolRecords.putText(rec, 239, 10, custAddrZip, text);
        CobolRecords.putText(rec, 249, 15, custPhoneNum1, text);
        CobolRecords.putText(rec, 264, 15, custPhoneNum2, text);
        CobolRecords.putZoned(rec, 279, 9, 0, false, CobolRecords.decimal(custSsn), text);
        CobolRecords.putText(rec, 288, 20, custGovtIssuedId, text);
        CobolRecords.putText(rec, 308, 10, custDobYyyyMmDd, text);
        CobolRecords.putText(rec, 318, 10, custEftAccountId, text);
        CobolRecords.putText(rec, 328, 1, custPriCardHolderInd, text);
        CobolRecords.putZoned(rec, 329, 3, 0, false, CobolRecords.decimal(custFicoCreditScore), text);
        return rec;
    }
}