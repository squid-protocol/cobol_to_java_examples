package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file STATTAB (no IDCAMS DEFINE in the repository),
 * record ST_RECL (src/GML/R0010505.pli, 35 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamStRecl")
@Table(name = "vsam_stattab")
@Data
@NoArgsConstructor
public class StRecl {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // ST_RECL: CHAR(35), offset 0, 35 bytes
    @Column(name = "ST_RECL", length = 35)
    private String stRecl;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}