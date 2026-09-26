package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM INDEXED AWS.M2.CARDDEMO.DISCGRP.VSAM.KSDS (app/jcl/DISCGRP.jcl:36),
 * record FD-DISCGRP-REC (app/cbl/CBACT04C.cbl, 50 bytes, RECORDSIZE 50).
 * Key: FD-DIS-ACCT-GROUP-ID, FD-DIS-TRAN-TYPE-CD, FD-DIS-TRAN-CAT-CD together (offset 0, 16 bytes, from IDCAMS KEYS): the @EmbeddedId FdDiscgrpRecKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamFdDiscgrpRec")
@Table(name = "vsam_discgrp")
@Data
@NoArgsConstructor
public class FdDiscgrpRec {

    // FD-DIS-ACCT-GROUP-ID, FD-DIS-TRAN-TYPE-CD, FD-DIS-TRAN-CAT-CD together (offset 0, 16 bytes, from IDCAMS KEYS): the @EmbeddedId FdDiscgrpRecKey
    @EmbeddedId
    private FdDiscgrpRecKey id;

    // FD-DISCGRP-DATA: PIC X(34), offset 16, 34 bytes
    @Column(name = "FD_DISCGRP_DATA", length = 34)
    private String fdDiscgrpData;


    /** #3624: this record from its fixed-width VSAM form (50 bytes, as REPRO unloads it), each
     *  field at its COBOL offset; `text` is the record's character set (ISO-8859-1 for an ASCII
     *  transfer, IBM037 on z/OS). FILLER bytes are not kept. */
    public static FdDiscgrpRec fromRecord(byte[] rec, java.nio.charset.Charset text) {
        FdDiscgrpRec r = new FdDiscgrpRec();
        r.id = new FdDiscgrpRecKey();
        r.id.setFdDisAcctGroupId(CobolRecords.text(rec, 0, 10, text));
        r.id.setFdDisTranTypeCd(CobolRecords.text(rec, 10, 2, text));
        r.id.setFdDisTranCatCd(CobolRecords.toInteger(CobolRecords.zoned(rec, 12, 4, 0, text)));
        r.fdDiscgrpData = CobolRecords.text(rec, 16, 34, text);
        return r;
    }

    /** #3624: the fixed-width VSAM record of this entity (FILLER as spaces). */
    public byte[] toRecord(java.nio.charset.Charset text) {
        byte[] rec = CobolRecords.blank(50, text);
        CobolRecords.putText(rec, 0, 10, id.getFdDisAcctGroupId(), text);
        CobolRecords.putText(rec, 10, 2, id.getFdDisTranTypeCd(), text);
        CobolRecords.putZoned(rec, 12, 4, 0, false, CobolRecords.decimal(id.getFdDisTranCatCd()), text);
        CobolRecords.putText(rec, 16, 34, fdDiscgrpData, text);
        return rec;
    }
}