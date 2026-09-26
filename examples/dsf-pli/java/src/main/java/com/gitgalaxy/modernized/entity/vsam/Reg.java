package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file VSKJEDE (no IDCAMS DEFINE in the repository),
 * record REG (src/GML/R0019906.pli, 13 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamReg")
@Table(name = "vsam_vskjede")
@Data
@NoArgsConstructor
public class Reg {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // KODE: CHAR(1), offset 0, 1 bytes
    @Column(name = "KODE", length = 1)
    private String kode;

    // FNR_1: FIXED DEC(11), offset 1, 6 bytes
    @Column(name = "FNR_1")
    private Long fnr1;

    // FNR_2: FIXED DEC(11), offset 7, 6 bytes
    @Column(name = "FNR_2")
    private Long fnr2;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}