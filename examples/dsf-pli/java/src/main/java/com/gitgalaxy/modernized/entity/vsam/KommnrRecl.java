package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file KOMTAB (no IDCAMS DEFINE in the repository),
 * record KOMMNR_RECL (src/GML/R001I402.pli, 100 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamKommnrRecl")
@Table(name = "vsam_komtab")
@Data
@NoArgsConstructor
public class KommnrRecl {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // KOMMNR_RECL: CHAR(100), offset 0, 100 bytes
    @Column(name = "KOMMNR_RECL", length = 100)
    private String kommnrRecl;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}