package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The key of FdTranCatBalRecord: FD-TRANCAT-ACCT-ID, FD-TRANCAT-TYPE-CD, FD-TRANCAT-CD together (offset 0, 17 bytes, from IDCAMS KEYS): the @EmbeddedId FdTranCatBalRecordKey.
 */
@Embeddable
@Data
@NoArgsConstructor
public class FdTranCatBalRecordKey implements Serializable {

    // FD-TRANCAT-ACCT-ID: PIC 9(11), offset 0, 11 bytes
    @Column(name = "FD_TRANCAT_ACCT_ID")
    private Long fdTrancatAcctId;

    // FD-TRANCAT-TYPE-CD: PIC X(02), offset 11, 2 bytes
    @Column(name = "FD_TRANCAT_TYPE_CD", length = 2)
    private String fdTrancatTypeCd;

    // FD-TRANCAT-CD: PIC 9(04), offset 13, 4 bytes
    @Column(name = "FD_TRANCAT_CD")
    private Integer fdTrancatCd;

}