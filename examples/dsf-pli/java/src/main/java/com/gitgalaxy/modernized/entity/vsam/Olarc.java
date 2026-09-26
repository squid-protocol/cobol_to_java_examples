package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file F0019F05 (no IDCAMS DEFINE in the repository),
 * record OLARC (src/GML/R0019F02.pli, 64 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamOlarc")
@Table(name = "vsam_f0019f05")
@Data
@NoArgsConstructor
public class Olarc {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FNR: PIC '(11)9', offset 0, 11 bytes
    @Column(name = "FNR")
    private Long fnr;

    // TKNR: PIC '(04)9', offset 11, 4 bytes
    @Column(name = "TKNR")
    private Integer tknr;

    // FIL1: CHAR(05), offset 15, 5 bytes
    @Column(name = "FIL1", length = 5)
    private String fil1;

    // TEXT: CHAR(44), offset 20, 44 bytes
    @Column(name = "TEXT", length = 44)
    private String text;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}