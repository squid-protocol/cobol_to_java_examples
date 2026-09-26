package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file INTEJKR (no IDCAMS DEFINE in the repository),
 * record INNTREC (src/GML/R001TE01.pli, 12 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamInntrec")
@Table(name = "vsam_intejkr")
@Data
@NoArgsConstructor
public class Inntrec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FNR: FIXED DEC(11), offset 0, 6 bytes
    @Column(name = "FNR")
    private Long fnr;

    // TRANSTYPE: CHAR(2), offset 6, 2 bytes
    @Column(name = "TRANSTYPE", length = 2)
    private String transtype;

    // TKNR: PIC '9999', offset 8, 4 bytes
    @Column(name = "TKNR")
    private Integer tknr;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}