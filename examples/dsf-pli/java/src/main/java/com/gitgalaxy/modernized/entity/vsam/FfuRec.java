package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file FFUDATA (no IDCAMS DEFINE in the repository),
 * record FFU_REC (src/R001I501.pli, 74 bytes).
 * Key: TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey.
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamFfuRec")
@Table(name = "vsam_ffudata")
@Data
@NoArgsConstructor
public class FfuRec {

    // TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey
    @Id
    @Column(name = "VSAM_KEY")
    private String vsamKey;

    // FFU_REC: CHAR(74), offset 0, 74 bytes
    @Column(name = "FFU_REC", length = 74)
    private String ffuRec;


    // #3624: no record codec: a PL/I record (its types are not COBOL PICTUREs).
}