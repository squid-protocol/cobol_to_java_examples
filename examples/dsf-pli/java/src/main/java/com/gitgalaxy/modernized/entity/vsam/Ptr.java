package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file TRKLIST (no IDCAMS DEFINE in the repository),
 * record PTR (src/GML/R001TE01.pli, 4 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamPtr")
@Table(name = "vsam_trklist")
@Data
@NoArgsConstructor
public class Ptr {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // PTR: POINTER, offset 0, 4 bytes
    @Column(name = "PTR")
    private Long ptr;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}