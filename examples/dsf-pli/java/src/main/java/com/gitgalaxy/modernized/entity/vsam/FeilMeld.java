package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file FNRFEIL (no IDCAMS DEFINE in the repository),
 * record FEIL_MELD (src/R0019E01.pli, 61 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamFeilMeld")
@Table(name = "vsam_fnrfeil")
@Data
@NoArgsConstructor
public class FeilMeld {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FEIL_MELD: CHAR(61), offset 0, 61 bytes
    @Column(name = "FEIL_MELD", length = 61)
    private String feilMeld;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}