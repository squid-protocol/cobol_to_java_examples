package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file HISTOR (no IDCAMS DEFINE in the repository),
 * record IN_REC (src/GML/R001TK62.pli, 948 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamInRec")
@Table(name = "vsam_histor")
@Data
@NoArgsConstructor
public class InRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // IN_REC: CHAR(948), offset 0, 948 bytes
    @Column(name = "IN_REC", length = 948)
    private String inRec;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}