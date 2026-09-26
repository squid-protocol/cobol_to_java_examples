package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The key of FdTranCatRecord: FD-TRAN-TYPE-CD, FD-TRAN-CAT-CD together (offset 0, 6 bytes, from IDCAMS KEYS): the @EmbeddedId FdTranCatRecordKey.
 */
@Embeddable
@Data
@NoArgsConstructor
public class FdTranCatRecordKey implements Serializable {

    // FD-TRAN-TYPE-CD: PIC X(02), offset 0, 2 bytes
    @Column(name = "FD_TRAN_TYPE_CD", length = 2)
    private String fdTranTypeCd;

    // FD-TRAN-CAT-CD: PIC 9(04), offset 2, 4 bytes
    @Column(name = "FD_TRAN_CAT_CD")
    private Integer fdTranCatCd;

}