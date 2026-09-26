package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file FNRKONT (no IDCAMS DEFINE in the repository),
 * record FNRKONT (src/GML/R0019H60.pli, 58 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamFnrkont")
@Table(name = "vsam_fnrkont")
@Data
@NoArgsConstructor
public class Fnrkont {

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

    // SIVILST: CHAR(1), offset 13, 1 bytes
    @Column(name = "SIVILST", length = 1)
    private String sivilst;

    // TP: FIXED DEC(5), offset 14, 3 bytes
    @Column(name = "TP")
    private Integer tp;

    // SPT: FIXED DEC(3,2), offset 17, 2 bytes
    @Column(name = "SPT")
    private BigDecimal spt;

    // OPT: FIXED DEC(3,2), offset 19, 2 bytes
    @Column(name = "OPT")
    private BigDecimal opt;

    // PÅ: FIXED DEC(3), offset 21, 2 bytes
    @Column(name = "PÅ")
    private Integer på;

    // TT: FIXED DEC(3), offset 23, 2 bytes
    @Column(name = "TT")
    private Integer tt;

    // TP_AVD: FIXED DEC(5), offset 25, 3 bytes
    @Column(name = "TP_AVD")
    private Integer tpAvd;

    // SPT_AVD: FIXED DEC(3,2), offset 28, 2 bytes
    @Column(name = "SPT_AVD")
    private BigDecimal sptAvd;

    // OPT_AVD: FIXED DEC(3,2), offset 30, 2 bytes
    @Column(name = "OPT_AVD")
    private BigDecimal optAvd;

    // PÅ_AVD: FIXED DEC(3), offset 32, 2 bytes
    @Column(name = "PÅ_AVD")
    private Integer påAvd;

    // TT_AVD: FIXED DEC(3), offset 34, 2 bytes
    @Column(name = "TT_AVD")
    private Integer ttAvd;

    // TP_RF: FIXED DEC(5), offset 36, 3 bytes
    @Column(name = "TP_RF")
    private Integer tpRf;

    // SPT_RF: FIXED DEC(3,2), offset 39, 2 bytes
    @Column(name = "SPT_RF")
    private BigDecimal sptRf;

    // OPT_RF: FIXED DEC(3,2), offset 41, 2 bytes
    @Column(name = "OPT_RF")
    private BigDecimal optRf;

    // PÅ_RF: FIXED DEC(3), offset 43, 2 bytes
    @Column(name = "PÅ_RF")
    private Integer påRf;

    // TT_RF: FIXED DEC(3), offset 45, 2 bytes
    @Column(name = "TT_RF")
    private Integer ttRf;

    // TP_AVD_RF: FIXED DEC(5), offset 47, 3 bytes
    @Column(name = "TP_AVD_RF")
    private Integer tpAvdRf;

    // SPT_AVD_RF: FIXED DEC(3,2), offset 50, 2 bytes
    @Column(name = "SPT_AVD_RF")
    private BigDecimal sptAvdRf;

    // OPT_AVD_RF: FIXED DEC(3,2), offset 52, 2 bytes
    @Column(name = "OPT_AVD_RF")
    private BigDecimal optAvdRf;

    // PÅ_AVD_RF: FIXED DEC(3), offset 54, 2 bytes
    @Column(name = "PÅ_AVD_RF")
    private Integer påAvdRf;

    // TT_AVD_RF: FIXED DEC(3), offset 56, 2 bytes
    @Column(name = "TT_AVD_RF")
    private Integer ttAvdRf;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}