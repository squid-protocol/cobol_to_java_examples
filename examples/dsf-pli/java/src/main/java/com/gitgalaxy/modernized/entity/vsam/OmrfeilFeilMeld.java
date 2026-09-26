package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file OMRFEIL (no IDCAMS DEFINE in the repository),
 * record FEIL_MELD (src/R0011801.pli, 61 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamOmrfeilFeilMeld")
@Table(name = "vsam_omrfeil")
@Data
@NoArgsConstructor
public class OmrfeilFeilMeld {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FEIL: CHAR(61), offset 0, 61 bytes
    @Column(name = "FEIL", length = 61)
    private String feil;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}