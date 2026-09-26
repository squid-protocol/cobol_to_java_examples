package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file OVERFOR (no IDCAMS DEFINE in the repository),
 * record OVERFOR_REC (src/GML/R0015602.pli, 80 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamOverforRec")
@Table(name = "vsam_overfor")
@Data
@NoArgsConstructor
public class OverforRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FRST: CHAR(9), offset 0, 9 bytes
    @Column(name = "FRST", length = 9)
    private String frst;

    // FNR: PIC '(11)9', offset 9, 11 bytes
    @Column(name = "FNR")
    private Long fnr;

    // REST: CHAR(54), offset 20, 54 bytes
    @Column(name = "REST", length = 54)
    private String rest;

    // OVER_DATO: CHAR(06), offset 74, 6 bytes
    @Column(name = "OVER_DATO", length = 6)
    private String overDato;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}