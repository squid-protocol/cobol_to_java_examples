package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file INTENDR (no IDCAMS DEFINE in the repository),
 * record VSAM_RECORD (src/GML/R0019D70.pli, 12 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamVsamRecord")
@Table(name = "vsam_intendr")
@Data
@NoArgsConstructor
public class VsamRecord {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FNR: FIXED DEC(11), offset 0, 6 bytes
    @Column(name = "FNR")
    private Long fnr;

    // PENSJONSTYPE1: CHAR(1), offset 6, 1 bytes
    @Column(name = "PENSJONSTYPE1", length = 1)
    private String pensjonstype1;

    // TRANSTYPE: PIC '99', offset 7, 2 bytes
    @Column(name = "TRANSTYPE")
    private Integer transtype;

    // VIRKDATO_ÅM: FIXED DEC(5), offset 9, 3 bytes
    @Column(name = "VIRKDATO_ÅM")
    private Integer virkdatoÅm;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}