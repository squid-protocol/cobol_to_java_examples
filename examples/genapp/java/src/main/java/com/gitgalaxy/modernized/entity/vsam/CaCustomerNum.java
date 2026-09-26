package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM INDEXED <USRHLQ>.GENAPP.KSDSCUST (base/cntl/adef121.jcl:15),
 * record CA-CUSTOMER-NUM (base/src/lgcmarea.cpy, 10 bytes).
 * Key: CA-CUSTOMER-NUM (offset 0, 10 bytes, from the programs' RIDFLD / RECORD KEY).
 * CICS files: KSDSCUST.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamCaCustomerNum")
@Table(name = "vsam_ksdscust")
@Data
@NoArgsConstructor
public class CaCustomerNum {

    // CA-CUSTOMER-NUM: PIC 9(10), offset 0, 10 bytes
    @Id
    @Column(name = "CA_CUSTOMER_NUM")
    private Long caCustomerNum;


    /** #3624: this record from its fixed-width VSAM form (10 bytes, as REPRO unloads it), each
     *  field at its COBOL offset; `text` is the record's character set (ISO-8859-1 for an ASCII
     *  transfer, IBM037 on z/OS). FILLER bytes are not kept. */
    public static CaCustomerNum fromRecord(byte[] rec, java.nio.charset.Charset text) {
        CaCustomerNum r = new CaCustomerNum();
        r.caCustomerNum = CobolRecords.toLong(CobolRecords.zoned(rec, 0, 10, 0, text));
        return r;
    }

    /** #3624: the fixed-width VSAM record of this entity (FILLER as spaces). */
    public byte[] toRecord(java.nio.charset.Charset text) {
        byte[] rec = CobolRecords.blank(10, text);
        CobolRecords.putZoned(rec, 0, 10, 0, false, CobolRecords.decimal(caCustomerNum), text);
        return rec;
    }
}