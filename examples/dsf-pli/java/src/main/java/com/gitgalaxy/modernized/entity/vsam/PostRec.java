package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file KDPOST (no IDCAMS DEFINE in the repository),
 * record POST_REC (src/GML/R001TK07.pli, 46 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamPostRec")
@Table(name = "vsam_kdpost")
@Data
@NoArgsConstructor
public class PostRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // BL1: CHAR(1), offset 0, 1 bytes
    @Column(name = "BL1", length = 1)
    private String bl1;

    // POSTNR: FIXED BIN(15), offset 1, 2 bytes
    @Column(name = "POSTNR")
    private Integer postnr;

    // BL2: CHAR(4), offset 3, 4 bytes
    @Column(name = "BL2", length = 4)
    private String bl2;

    // POSTSTED_KORT: CHAR(11), offset 7, 11 bytes
    @Column(name = "POSTSTED_KORT", length = 11)
    private String poststedKort;

    // POSTSTED_LANG: CHAR(26), offset 18, 26 bytes
    @Column(name = "POSTSTED_LANG", length = 26)
    private String poststedLang;

    // BL3: CHAR(2), offset 44, 2 bytes
    @Column(name = "BL3", length = 2)
    private String bl3;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}