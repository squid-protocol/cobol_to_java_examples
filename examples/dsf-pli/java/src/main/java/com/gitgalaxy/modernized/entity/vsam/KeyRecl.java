package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file KOMP (no IDCAMS DEFINE in the repository),
 * record KEY_RECL (src/GML/R001I501.pli, 61 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamKeyRecl")
@Table(name = "vsam_komp")
@Data
@NoArgsConstructor
public class KeyRecl {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // KEY_RECL: CHAR(61), offset 0, 61 bytes
    @Column(name = "KEY_RECL", length = 61)
    private String keyRecl;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}