package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file PRINTRX (no IDCAMS DEFINE in the repository),
 * record DF_PRINT_LINE (src/GML/R0010430.pli, 81 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamDfPrintLine")
@Table(name = "vsam_printrx")
@Data
@NoArgsConstructor
public class DfPrintLine {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // DF_PCC: CHAR(1), offset 0, 1 bytes
    @Column(name = "DF_PCC", length = 1)
    private String dfPcc;

    // DF_FIL1: CHAR(1), offset 1, 1 bytes
    @Column(name = "DF_FIL1", length = 1)
    private String dfFil1;

    // DF_CC: CHAR(1), offset 2, 1 bytes
    @Column(name = "DF_CC", length = 1)
    private String dfCc;

    // DF_FIL: CHAR(6), offset 3, 6 bytes
    @Column(name = "DF_FIL", length = 6)
    private String dfFil;

    // DF_TEKST: CHAR(72), offset 9, 72 bytes
    @Column(name = "DF_TEKST", length = 72)
    private String dfTekst;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}