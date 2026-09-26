package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file KEYFIL (no IDCAMS DEFINE in the repository),
 * record KEYFIL_RECL (src/GML/R001I501.pli, 21 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamKeyfilRecl")
@Table(name = "vsam_keyfil")
@Data
@NoArgsConstructor
public class KeyfilRecl {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // KEYFIL_RECL: CHAR(21), offset 0, 21 bytes
    @Column(name = "KEYFIL_RECL", length = 21)
    private String keyfilRecl;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}