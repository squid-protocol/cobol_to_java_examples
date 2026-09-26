package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file F0019H02 (no IDCAMS DEFINE in the repository),
 * record GP_REC (src/R0019H01.pli, 22 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamGpRec")
@Table(name = "vsam_f0019h02")
@Data
@NoArgsConstructor
public class GpRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FNR: PIC '(11)9', offset 0, 11 bytes
    @Column(name = "FNR")
    private Long fnr;

    // TKNR: PIC '9999', offset 11, 4 bytes
    @Column(name = "TKNR")
    private Integer tknr;

    // GP_RED_KODE: CHAR(1), offset 15, 1 bytes
    @Column(name = "GP_RED_KODE", length = 1)
    private String gpRedKode;

    // REST: CHAR(6), offset 16, 6 bytes
    @Column(name = "REST", length = 6)
    private String rest;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}