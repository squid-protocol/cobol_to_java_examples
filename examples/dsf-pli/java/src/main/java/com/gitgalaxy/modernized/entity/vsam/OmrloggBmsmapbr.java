package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file OMRLOGG (no IDCAMS DEFINE in the repository),
 * record BMSMAPBR (src/GML/R0010427.pli, 4 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamOmrloggBmsmapbr")
@Table(name = "vsam_omrlogg")
@Data
@NoArgsConstructor
public class OmrloggBmsmapbr {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // BMSMAPBR: POINTER, offset 0, 4 bytes
    @Column(name = "BMSMAPBR")
    private Long bmsmapbr;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}