package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM INDEXED <USRHLQ>.GENAPP.KSDSPOLY (base/cntl/adef121.jcl:40),
 * record WF-POLICY-INFO (base/src/lgapvs01.cbl, 64 bytes).
 * Key: WF-REQUEST-ID, WF-CUSTOMER-NUM, WF-POLICY-NUM together (offset 0, 21 bytes, from the programs' RIDFLD / RECORD KEY): the @EmbeddedId WfPolicyInfoKey.
 * CICS files: KSDSPOLY.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamWfPolicyInfo")
@Table(name = "vsam_ksdspoly")
@Data
@NoArgsConstructor
public class WfPolicyInfo {

    // WF-REQUEST-ID, WF-CUSTOMER-NUM, WF-POLICY-NUM together (offset 0, 21 bytes, from the programs' RIDFLD / RECORD KEY): the @EmbeddedId WfPolicyInfoKey
    @EmbeddedId
    private WfPolicyInfoKey id;

    // WF-POLICY-DATA: PIC X(43), offset 21, 43 bytes
    @Column(name = "WF_POLICY_DATA", length = 43)
    private String wfPolicyData;


    /** #3624: this record from its fixed-width VSAM form (64 bytes, as REPRO unloads it), each
     *  field at its COBOL offset; `text` is the record's character set (ISO-8859-1 for an ASCII
     *  transfer, IBM037 on z/OS). FILLER bytes are not kept. */
    public static WfPolicyInfo fromRecord(byte[] rec, java.nio.charset.Charset text) {
        WfPolicyInfo r = new WfPolicyInfo();
        r.id = new WfPolicyInfoKey();
        r.id.setWfRequestId(CobolRecords.text(rec, 0, 1, text));
        r.id.setWfCustomerNum(CobolRecords.text(rec, 1, 10, text));
        r.id.setWfPolicyNum(CobolRecords.text(rec, 11, 10, text));
        r.wfPolicyData = CobolRecords.text(rec, 21, 43, text);
        return r;
    }

    /** #3624: the fixed-width VSAM record of this entity (FILLER as spaces). */
    public byte[] toRecord(java.nio.charset.Charset text) {
        byte[] rec = CobolRecords.blank(64, text);
        CobolRecords.putText(rec, 0, 1, id.getWfRequestId(), text);
        CobolRecords.putText(rec, 1, 10, id.getWfCustomerNum(), text);
        CobolRecords.putText(rec, 11, 10, id.getWfPolicyNum(), text);
        CobolRecords.putText(rec, 21, 43, wfPolicyData, text);
        return rec;
    }
}