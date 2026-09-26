package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file F0019H01 (no IDCAMS DEFINE in the repository),
 * record MELD_XX (src/R0019H01.pli, 48 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamMeldXx")
@Table(name = "vsam_f0019h01")
@Data
@NoArgsConstructor
public class MeldXx {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // MELD_XX: CHAR(48), offset 0, 48 bytes
    @Column(name = "MELD_XX", length = 48)
    private String meldXx;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}