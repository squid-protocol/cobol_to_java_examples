package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file FORANDRE (no IDCAMS DEFINE in the repository),
 * record FORANDRE_REC (src/GML/R001TK07.pli, 12 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamForandreRec")
@Table(name = "vsam_forandre")
@Data
@NoArgsConstructor
public class ForandreRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // DATO: CHAR(6), offset 0, 6 bytes
    @Column(name = "DATO", length = 6)
    private String dato;

    // BL: CHAR(2), offset 6, 2 bytes
    @Column(name = "BL", length = 2)
    private String bl;

    // TKNR: CHAR(4), offset 8, 4 bytes
    @Column(name = "TKNR", length = 4)
    private String tknr;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}