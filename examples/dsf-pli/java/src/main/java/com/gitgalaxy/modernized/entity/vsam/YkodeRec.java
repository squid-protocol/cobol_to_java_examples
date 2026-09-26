package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file DSFYKODE (no IDCAMS DEFINE in the repository),
 * record YKODE_REC (src/R0012101.pli, 8 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamYkodeRec")
@Table(name = "vsam_dsfykode")
@Data
@NoArgsConstructor
public class YkodeRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FNR: FIXED DEC(11), offset 0, 6 bytes
    @Column(name = "FNR")
    private Long fnr;

    // YKODE: PIC '99', offset 6, 2 bytes
    @Column(name = "YKODE")
    private Integer ykode;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}