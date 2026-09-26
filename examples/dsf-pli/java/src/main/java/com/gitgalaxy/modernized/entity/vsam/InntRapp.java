package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

/**
 * VSAM file INBRUDD (no IDCAMS DEFINE in the repository),
 * record INNT_RAPP (src/GML/R001I903.pli, None bytes).
 * Key: INNT_RAPP (offset None, None bytes, from IDCAMS KEYS).
 * Generated from GitGalaxy's verified skeleton; VSAM defines field testing: open (3 public / 0 private estates).
 */
@Entity(name = "VsamInntRapp")
@Table(name = "vsam_inbrudd")
@Data
@NoArgsConstructor
public class InntRapp {

    // INNT_RAPP: no PIC, offset None, None bytes
    @Id
    @Column(name = "INNT_RAPP")
    private String inntRapp;


    // #3624: no record codec: the record's width is not known.
}