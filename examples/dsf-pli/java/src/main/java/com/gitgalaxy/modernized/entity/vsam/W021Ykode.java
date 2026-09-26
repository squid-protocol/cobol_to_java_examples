package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file YRKEKOD (no IDCAMS DEFINE in the repository),
 * record W021_YKODE (src/GML/R001B001.pli, 3 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamW021Ykode")
@Table(name = "vsam_yrkekod")
@Data
@NoArgsConstructor
public class W021Ykode {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // W021_YKODE: CHAR(3), offset 0, 3 bytes
    @Column(name = "W021_YKODE", length = 3)
    private String w021Ykode;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}