package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file FNRSTYR (no IDCAMS DEFINE in the repository),
 * record FNRREC (src/GML/R0019H60.pli, 51 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamFnrrec")
@Table(name = "vsam_fnrstyr")
@Data
@NoArgsConstructor
public class Fnrrec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FNR: FIXED DEC(11), offset 0, 6 bytes
    @Column(name = "FNR")
    private Long fnr;

    // TKNR: FIXED DEC(4), offset 6, 3 bytes
    @Column(name = "TKNR")
    private Integer tknr;

    // VTP: FIXED DEC(4), offset 9, 3 bytes
    @Column(name = "VTP")
    private Integer vtp;

    // PT1: CHAR(1), offset 12, 1 bytes
    @Column(name = "PT1", length = 1)
    private String pt1;

    // TP: FIXED DEC(5), offset 13, 3 bytes
    @Column(name = "TP")
    private Integer tp;

    // SPT: FIXED DEC(3,2), offset 16, 2 bytes
    @Column(name = "SPT")
    private BigDecimal spt;

    // OPT: FIXED DEC(3,2), offset 18, 2 bytes
    @Column(name = "OPT")
    private BigDecimal opt;

    // PÅ: FIXED DEC(3), offset 20, 2 bytes
    @Column(name = "PÅ")
    private Integer på;

    // TT: FIXED DEC(3), offset 22, 2 bytes
    @Column(name = "TT")
    private Integer tt;

    // SPT_AVD: FIXED DEC(3,2), offset 24, 2 bytes
    @Column(name = "SPT_AVD")
    private BigDecimal sptAvd;

    // OPT_AVD: FIXED DEC(3,2), offset 26, 2 bytes
    @Column(name = "OPT_AVD")
    private BigDecimal optAvd;

    // PÅ_AVD: FIXED DEC(3), offset 28, 2 bytes
    @Column(name = "PÅ_AVD")
    private Integer påAvd;

    // TT_AVD: FIXED DEC(3), offset 30, 2 bytes
    @Column(name = "TT_AVD")
    private Integer ttAvd;

    // FILLER1: CHAR(19), offset 32, 19 bytes
    @Column(name = "FILLER1", length = 19)
    private String filler1;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}