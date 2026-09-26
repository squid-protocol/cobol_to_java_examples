package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file MELDREC (no IDCAMS DEFINE in the repository),
 * record MELD_IO (src/R0019E01.pli, 96 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamMeldIo")
@Table(name = "vsam_meldrec")
@Data
@NoArgsConstructor
public class MeldIo {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // ADRESSAT: CHAR(1), offset 0, 1 bytes
    @Column(name = "ADRESSAT", length = 1)
    private String adressat;

    // TKNR: PIC '(4)9', offset 1, 4 bytes
    @Column(name = "TKNR")
    private Integer tknr;

    // FNR: PIC '(11)9', offset 5, 11 bytes
    @Column(name = "FNR")
    private Long fnr;

    // KODE: CHAR(1), offset 16, 1 bytes
    @Column(name = "KODE", length = 1)
    private String kode;

    // FRANR: PIC '(11)9', offset 17, 11 bytes
    @Column(name = "FRANR")
    private Long franr;

    // SISTENR: PIC '(11)9', offset 28, 11 bytes
    @Column(name = "SISTENR")
    private Long sistenr;

    // ENDR_DATO_ÅMD: PIC '(8)9', offset 39, 8 bytes
    @Column(name = "ENDR_DATO_ÅMD")
    private Integer endrDatoÅmd;

    // LINKNR: PIC '(11)9', offset 47, 11 bytes
    @Column(name = "LINKNR")
    private Long linknr;

    // NAVN: CHAR(25), offset 58, 25 bytes
    @Column(name = "NAVN", length = 25)
    private String navn;

    // TKNR: PIC '(4)9', offset 83, 4 bytes
    @Column(name = "TKNR")
    private Integer tknr2;

    // VIRKDATO_ÅMD: PIC '(8)9', offset 87, 8 bytes
    @Column(name = "VIRKDATO_ÅMD")
    private Integer virkdatoÅmd;

    // PK1: CHAR(1), offset 95, 1 bytes
    @Column(name = "PK1", length = 1)
    private String pk1;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}