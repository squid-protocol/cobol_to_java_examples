package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file DIAGNOS (no IDCAMS DEFINE in the repository),
 * record W01_DIA_RECL (src/GML/R0010603.pli, 6 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamW01DiaRecl")
@Table(name = "vsam_diagnos")
@Data
@NoArgsConstructor
public class W01DiaRecl {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // W01_DIA_RECL_KEY: CHAR(6), offset 0, 6 bytes
    @Column(name = "W01_DIA_RECL_KEY", length = 6)
    private String w01DiaReclKey;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}