package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The key of FdDiscgrpRec: FD-DIS-ACCT-GROUP-ID, FD-DIS-TRAN-TYPE-CD, FD-DIS-TRAN-CAT-CD together (offset 0, 16 bytes, from IDCAMS KEYS): the @EmbeddedId FdDiscgrpRecKey.
 */
@Embeddable
@Data
@NoArgsConstructor
public class FdDiscgrpRecKey implements Serializable {

    // FD-DIS-ACCT-GROUP-ID: PIC X(10), offset 0, 10 bytes
    @Column(name = "FD_DIS_ACCT_GROUP_ID", length = 10)
    private String fdDisAcctGroupId;

    // FD-DIS-TRAN-TYPE-CD: PIC X(02), offset 10, 2 bytes
    @Column(name = "FD_DIS_TRAN_TYPE_CD", length = 2)
    private String fdDisTranTypeCd;

    // FD-DIS-TRAN-CAT-CD: PIC 9(04), offset 12, 4 bytes
    @Column(name = "FD_DIS_TRAN_CAT_CD")
    private Integer fdDisTranCatCd;

}