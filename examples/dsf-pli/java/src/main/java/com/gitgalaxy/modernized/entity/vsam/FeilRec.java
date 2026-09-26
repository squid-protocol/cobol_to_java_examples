package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file NORFEIL (no IDCAMS DEFINE in the repository),
 * record FEIL_REC (src/GML/R001NO10.pli, 320 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamFeilRec")
@Table(name = "vsam_norfeil")
@Data
@NoArgsConstructor
public class FeilRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // HODE_TKNR: PIC '( 4)9', offset 0, 4 bytes
    @Column(name = "HODE_TKNR", length = 4)
    private String hodeTknr;

    // HODE_RECORD_TYPE: CHAR(2), offset 4, 2 bytes
    @Column(name = "HODE_RECORD_TYPE", length = 2)
    private String hodeRecordType;

    // HODE_TRANS_TYPE: CHAR(2), offset 6, 2 bytes
    @Column(name = "HODE_TRANS_TYPE", length = 2)
    private String hodeTransType;

    // HODE_TRANS_DATO_ÅMD: PIC '( 6)9', offset 8, 6 bytes
    @Column(name = "HODE_TRANS_DATO_ÅMD", length = 6)
    private String hodeTransDatoÅmd;

    // HODE_TRANS_TID: PIC '( 4)9', offset 14, 4 bytes
    @Column(name = "HODE_TRANS_TID", length = 4)
    private String hodeTransTid;

    // TKNR: PIC '( 4)9', offset 18, 4 bytes
    @Column(name = "TKNR", length = 4)
    private String tknr;

    // RECORD_TYPE: CHAR(2), offset 22, 2 bytes
    @Column(name = "RECORD_TYPE", length = 2)
    private String recordType;

    // TRANS_TYPE: CHAR(2), offset 24, 2 bytes
    @Column(name = "TRANS_TYPE", length = 2)
    private String transType;

    // TRANS_DATO_ÅMD: PIC '( 6)9', offset 26, 6 bytes
    @Column(name = "TRANS_DATO_ÅMD", length = 6)
    private String transDatoÅmd;

    // TRANS_TID: PIC '( 4)9', offset 32, 4 bytes
    @Column(name = "TRANS_TID", length = 4)
    private String transTid;

    // FNR: PIC '(11)9', offset 36, 11 bytes
    @Column(name = "FNR")
    private Long fnr;

    // BL_TYPE: CHAR(2), offset 47, 2 bytes
    @Column(name = "BL_TYPE", length = 2)
    private String blType;

    // NAVN: CHAR(25), offset 49, 25 bytes
    @Column(name = "NAVN", length = 25)
    private String navn;

    // VIRK_DATO_MÅ: PIC '( 4)9', offset 74, 4 bytes
    @Column(name = "VIRK_DATO_MÅ", length = 4)
    private String virkDatoMå;

    // FEIL_MELD: CHAR(78), offset 78, 234 bytes
    @ElementCollection
    @CollectionTable(name = "vsam_norfeil_feil_meld")
    private List<String> feilMeld;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}