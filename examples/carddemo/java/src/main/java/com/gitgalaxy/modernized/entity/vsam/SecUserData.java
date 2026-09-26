package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM INDEXED AWS.M2.CARDDEMO.USRSEC.VSAM.KSDS (app/jcl/DUSRSECJ.jcl:64),
 * record SEC-USER-DATA (app/cpy/CSUSR01Y.cpy, 80 bytes, RECORDSIZE 80).
 * Key: SEC-USR-ID (offset 0, 8 bytes, from IDCAMS KEYS).
 * CICS files: USRSEC.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamSecUserData")
@Table(name = "vsam_usrsec")
@Data
@NoArgsConstructor
public class SecUserData {

    // SEC-USR-ID: PIC X(08), offset 0, 8 bytes
    @Id
    @Column(name = "SEC_USR_ID", length = 8)
    private String secUsrId;

    // SEC-USR-FNAME: PIC X(20), offset 8, 20 bytes
    @Column(name = "SEC_USR_FNAME", length = 20)
    private String secUsrFname;

    // SEC-USR-LNAME: PIC X(20), offset 28, 20 bytes
    @Column(name = "SEC_USR_LNAME", length = 20)
    private String secUsrLname;

    // SEC-USR-PWD: PIC X(08), offset 48, 8 bytes
    @Column(name = "SEC_USR_PWD", length = 8)
    private String secUsrPwd;

    // SEC-USR-TYPE: PIC X(01), offset 56, 1 bytes
    @Column(name = "SEC_USR_TYPE", length = 1)
    private String secUsrType;

    // SEC-USR-FILLER: PIC X(23), offset 57, 23 bytes
    @Column(name = "SEC_USR_FILLER", length = 23)
    private String secUsrFiller;


    /** #3624: this record from its fixed-width VSAM form (80 bytes, as REPRO unloads it), each
     *  field at its COBOL offset; `text` is the record's character set (ISO-8859-1 for an ASCII
     *  transfer, IBM037 on z/OS). FILLER bytes are not kept. */
    public static SecUserData fromRecord(byte[] rec, java.nio.charset.Charset text) {
        SecUserData r = new SecUserData();
        r.secUsrId = CobolRecords.text(rec, 0, 8, text);
        r.secUsrFname = CobolRecords.text(rec, 8, 20, text);
        r.secUsrLname = CobolRecords.text(rec, 28, 20, text);
        r.secUsrPwd = CobolRecords.text(rec, 48, 8, text);
        r.secUsrType = CobolRecords.text(rec, 56, 1, text);
        r.secUsrFiller = CobolRecords.text(rec, 57, 23, text);
        return r;
    }

    /** #3624: the fixed-width VSAM record of this entity (FILLER as spaces). */
    public byte[] toRecord(java.nio.charset.Charset text) {
        byte[] rec = CobolRecords.blank(80, text);
        CobolRecords.putText(rec, 0, 8, secUsrId, text);
        CobolRecords.putText(rec, 8, 20, secUsrFname, text);
        CobolRecords.putText(rec, 28, 20, secUsrLname, text);
        CobolRecords.putText(rec, 48, 8, secUsrPwd, text);
        CobolRecords.putText(rec, 56, 1, secUsrType, text);
        CobolRecords.putText(rec, 57, 23, secUsrFiller, text);
        return rec;
    }
}