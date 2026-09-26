package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The key of WsAbndArea: ABND-UTIME-KEY, ABND-TASKNO-KEY together (offset 0, 12 bytes, from IDCAMS KEYS): the @EmbeddedId WsAbndAreaKey.
 */
@Embeddable
@Data
@NoArgsConstructor
public class WsAbndAreaKey implements Serializable {

    // ABND-UTIME-KEY: PIC S9(15), offset 0, 8 bytes
    @Column(name = "ABND_UTIME_KEY")
    private Long abndUtimeKey;

    // ABND-TASKNO-KEY: PIC 9(4), offset 8, 4 bytes
    @Column(name = "ABND_TASKNO_KEY")
    private Integer abndTasknoKey;

}