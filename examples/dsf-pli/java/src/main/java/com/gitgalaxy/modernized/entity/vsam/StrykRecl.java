package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file STRYK (no IDCAMS DEFINE in the repository),
 * record STRYK_RECL (src/GML/R001I402.pli, 19 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamStrykRecl")
@Table(name = "vsam_stryk")
@Data
@NoArgsConstructor
public class StrykRecl {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // STRYK_RECL: CHAR(19), offset 0, 19 bytes
    @Column(name = "STRYK_RECL", length = 19)
    private String strykRecl;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}