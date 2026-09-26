package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file FNREOS (no IDCAMS DEFINE in the repository),
 * record FNR_EOS (src/R0019F01.pli, 51 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamFnrEos")
@Table(name = "vsam_fnreos")
@Data
@NoArgsConstructor
public class FnrEos {

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

    // ALDER: PIC '(5)9', offset 40, 5 bytes
    @Column(name = "ALDER")
    private Integer alder;

    // TT_ANV: PIC '(2)9', offset 45, 2 bytes
    @Column(name = "TT_ANV")
    private Integer ttAnv;

    // ANTALL_NORSKE_PÅ: PIC '(2)9', offset 47, 2 bytes
    @Column(name = "ANTALL_NORSKE_PÅ")
    private Integer antallNorskePå;

    // PÅ_EØS: PIC '(2)9', offset 49, 2 bytes
    @Column(name = "PÅ_EØS")
    private Integer påEøs;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}