package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file OLINNTE (no IDCAMS DEFINE in the repository),
 * record OLI_REC (src/R001I201.pli, 103 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamOliRec")
@Table(name = "vsam_olinnte")
@Data
@NoArgsConstructor
public class OliRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // OLI_REC: CHAR(103), offset 0, 103 bytes
    @Column(name = "OLI_REC", length = 103)
    private String oliRec;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}