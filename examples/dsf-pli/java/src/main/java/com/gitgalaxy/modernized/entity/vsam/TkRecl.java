package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file TKNRTAB (no IDCAMS DEFINE in the repository),
 * record TK_RECL (src/GML/R0010503.pli, 101 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamTkRecl")
@Table(name = "vsam_tknrtab")
@Data
@NoArgsConstructor
public class TkRecl {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // TK_RECL: CHAR(101), offset 0, 101 bytes
    @Column(name = "TK_RECL", length = 101)
    private String tkRecl;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}