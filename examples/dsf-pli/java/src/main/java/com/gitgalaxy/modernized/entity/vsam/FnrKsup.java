package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file FNRKSUP (no IDCAMS DEFINE in the repository),
 * record FNR_KSUP (src/R0019F01.pli, 51 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamFnrKsup")
@Table(name = "vsam_fnrksup")
@Data
@NoArgsConstructor
public class FnrKsup {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // TKNR: PIC '(04)9', offset 0, 4 bytes
    @Column(name = "TKNR")
    private Integer tknr;

    // FNR: PIC '(11)9', offset 4, 11 bytes
    @Column(name = "FNR")
    private Long fnr;

    // NAVN: CHAR(25), offset 15, 25 bytes
    @Column(name = "NAVN", length = 25)
    private String navn;

    // FILL: CHAR(11), offset 40, 11 bytes
    @Column(name = "FILL", length = 11)
    private String fill;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}