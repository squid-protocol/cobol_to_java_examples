package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file FNRTILG (no IDCAMS DEFINE in the repository),
 * record FNRREC (src/R0019E01.pli, 32 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamFnrtilgFnrrec")
@Table(name = "vsam_fnrtilg")
@Data
@NoArgsConstructor
public class FnrtilgFnrrec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // LINKNR: FIXED DEC(11), offset 0, 6 bytes
    @Column(name = "LINKNR")
    private Long linknr;

    // FRANR: FIXED DEC(11), offset 6, 6 bytes
    @Column(name = "FRANR")
    private Long franr;

    // TILNR: FIXED DEC(11), offset 12, 6 bytes
    @Column(name = "TILNR")
    private Long tilnr;

    // REKKEF: PIC '(2)9', offset 18, 2 bytes
    @Column(name = "REKKEF")
    private Integer rekkef;

    // DATO: FIXED DEC(9), offset 20, 5 bytes
    @Column(name = "DATO")
    private Integer dato;

    // KODE: CHAR(1), offset 25, 1 bytes
    @Column(name = "KODE", length = 1)
    private String kode;

    // SISTENR: FIXED DEC(11), offset 26, 6 bytes
    @Column(name = "SISTENR")
    private Long sistenr;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}