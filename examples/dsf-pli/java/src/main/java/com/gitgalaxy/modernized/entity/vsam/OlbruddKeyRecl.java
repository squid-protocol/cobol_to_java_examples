package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file OLBRUDD (no IDCAMS DEFINE in the repository),
 * record KEY_RECL (src/GML/R001I903.pli, 97 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamOlbruddKeyRecl")
@Table(name = "vsam_olbrudd")
@Data
@NoArgsConstructor
public class OlbruddKeyRecl {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // KEY_RECL: CHAR(97), offset 0, 97 bytes
    @Column(name = "KEY_RECL", length = 97)
    private String keyRecl;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}