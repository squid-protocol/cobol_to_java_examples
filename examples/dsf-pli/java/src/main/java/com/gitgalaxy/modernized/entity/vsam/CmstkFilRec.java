package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file CMSTK (no IDCAMS DEFINE in the repository),
 * record FIL_REC (src/GML/R001TK81.pli, 80 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamCmstkFilRec")
@Table(name = "vsam_cmstk")
@Data
@NoArgsConstructor
public class CmstkFilRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // TKNR: PIC '( 5)9', offset 0, 5 bytes
    @Column(name = "TKNR", length = 5)
    private String tknr;

    // ADR1: CHAR(34), offset 5, 34 bytes
    @Column(name = "ADR1", length = 34)
    private String adr1;

    // ADR2: CHAR(27), offset 39, 27 bytes
    @Column(name = "ADR2", length = 27)
    private String adr2;

    // IN: CHAR(2), offset 66, 2 bytes
    @Column(name = "IN", length = 2)
    private String in;

    // PH: CHAR(2), offset 68, 2 bytes
    @Column(name = "PH", length = 2)
    private String ph;

    // FT: CHAR(2), offset 70, 2 bytes
    @Column(name = "FT", length = 2)
    private String ft;

    // AD: CHAR(2), offset 72, 2 bytes
    @Column(name = "AD", length = 2)
    private String ad;

    // KJ: CHAR(2), offset 74, 2 bytes
    @Column(name = "KJ", length = 2)
    private String kj;

    // FOK: CHAR(2), offset 76, 2 bytes
    @Column(name = "FOK", length = 2)
    private String fok;

    // SS: CHAR(2), offset 78, 2 bytes
    @Column(name = "SS", length = 2)
    private String ss;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}