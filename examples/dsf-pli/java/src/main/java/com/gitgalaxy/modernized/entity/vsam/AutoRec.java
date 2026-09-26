package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file F001E41 (no IDCAMS DEFINE in the repository),
 * record AUTO_REC (src/GML/R0011801.pli, 15 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamAutoRec")
@Table(name = "vsam_f001e41")
@Data
@NoArgsConstructor
public class AutoRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FNR: PIC '(11)9', offset 0, 11 bytes
    @Column(name = "FNR")
    private Long fnr;

    // FIL: CHAR(4), offset 11, 4 bytes
    @Column(name = "FIL", length = 4)
    private String fil;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}