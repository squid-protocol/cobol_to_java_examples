package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file TKLISTE (no IDCAMS DEFINE in the repository),
 * record TKLISTE_REC (src/GML/R001TK07.pli, 125 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamTklisteRec")
@Table(name = "vsam_tkliste")
@Data
@NoArgsConstructor
public class TklisteRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // TKNR: PIC '( 4)9', offset 0, 4 bytes
    @Column(name = "TKNR", length = 4)
    private String tknr;

    // TKNAVN: CHAR(23), offset 4, 23 bytes
    @Column(name = "TKNAVN", length = 23)
    private String tknavn;

    // ADR1: CHAR(20), offset 27, 20 bytes
    @Column(name = "ADR1", length = 20)
    private String adr1;

    // POSTNR: PIC '( 4)9', offset 47, 4 bytes
    @Column(name = "POSTNR", length = 4)
    private String postnr;

    // POSTNAVN: CHAR(17), offset 51, 17 bytes
    @Column(name = "POSTNAVN", length = 17)
    private String postnavn;

    // TK_SJEF: CHAR(25), offset 68, 25 bytes
    @Column(name = "TK_SJEF", length = 25)
    private String tkSjef;

    // TLF: CHAR(12), offset 93, 12 bytes
    @Column(name = "TLF", length = 12)
    private String tlf;

    // TELEFAX: CHAR(13), offset 105, 13 bytes
    @Column(name = "TELEFAX", length = 13)
    private String telefax;

    // INNBYGG: PIC '( 6)9', offset 118, 6 bytes
    @Column(name = "INNBYGG", length = 6)
    private String innbygg;

    // MÅLFORM: CHAR(1), offset 124, 1 bytes
    @Column(name = "MÅLFORM", length = 1)
    private String målform;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}