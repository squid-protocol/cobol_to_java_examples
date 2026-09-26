package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file BRUKINFO (no IDCAMS DEFINE in the repository),
 * record BRUKERINFO_REC (src/GML/R0010450.pli, 50 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamBrukerinfoRec")
@Table(name = "vsam_brukinfo")
@Data
@NoArgsConstructor
public class BrukerinfoRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FNR: PIC '(11)9', offset 0, 11 bytes
    @Column(name = "FNR")
    private Long fnr;

    // BLANKET_TYPE: CHAR(2), offset 11, 2 bytes
    @Column(name = "BLANKET_TYPE", length = 2)
    private String blanketType;

    // TERMINAL_NR: CHAR(4), offset 13, 4 bytes
    @Column(name = "TERMINAL_NR", length = 4)
    private String terminalNr;

    // BRUKER_ID: CHAR(8), offset 17, 8 bytes
    @Column(name = "BRUKER_ID", length = 8)
    private String brukerId;

    // DATO: PIC '(6)9', offset 30, 6 bytes
    @Column(name = "DATO")
    private Integer dato;

    // TID: PIC '(7)9', offset 36, 7 bytes
    @Column(name = "TID")
    private Integer tid;

    // KJORINGS_TYPE: CHAR(1), offset 43, 1 bytes
    @Column(name = "KJORINGS_TYPE", length = 1)
    private String kjoringsType;

    // FIL1: CHAR(06), offset 44, 6 bytes
    @Column(name = "FIL1", length = 6)
    private String fil1;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}