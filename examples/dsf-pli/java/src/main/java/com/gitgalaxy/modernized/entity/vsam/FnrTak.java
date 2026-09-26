package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file FNRTAK (no IDCAMS DEFINE in the repository),
 * record FNR_TAK (src/R0019F01.pli, 90 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamFnrTak")
@Table(name = "vsam_fnrtak")
@Data
@NoArgsConstructor
public class FnrTak {

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

    // INFOTRANSTYPE: CHAR(01), offset 15, 1 bytes
    @Column(name = "INFOTRANSTYPE", length = 1)
    private String infotranstype;

    // FTRYGD_FOM: PIC '(06)9', offset 16, 6 bytes
    @Column(name = "FTRYGD_FOM")
    private Integer ftrygdFom;

    // HIGH_VALUES1: CHAR(08), offset 22, 8 bytes
    @Column(name = "HIGH_VALUES1", length = 8)
    private String highValues1;

    // BS20_ART_RTV: CHAR(01), offset 30, 1 bytes
    @Column(name = "BS20_ART_RTV", length = 1)
    private String bs20ArtRtv;

    // HIGH_VALUES2: CHAR(39), offset 31, 39 bytes
    @Column(name = "HIGH_VALUES2", length = 39)
    private String highValues2;

    // INNT_GRENSE: PIC '(07)9', offset 70, 7 bytes
    @Column(name = "INNT_GRENSE")
    private Integer inntGrense;

    // INNTEKSTKODE1: CHAR(01), offset 77, 1 bytes
    @Column(name = "INNTEKSTKODE1", length = 1)
    private String inntekstkode1;

    // HIGH_VALUES3: CHAR(05), offset 78, 5 bytes
    @Column(name = "HIGH_VALUES3", length = 5)
    private String highValues3;

    // INNTEKTSKODE2: CHAR(01), offset 83, 1 bytes
    @Column(name = "INNTEKTSKODE2", length = 1)
    private String inntektskode2;

    // FRIINNT_ÅÅMMDD: PIC '(06)9', offset 84, 6 bytes
    @Column(name = "FRIINNT_ÅÅMMDD")
    private Integer friinntÅåmmdd;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}