package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "G_S18")
public class GS18 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "X_1")
    private Integer x1;

    @Column(name = "X_2")
    private Integer x2;

    @Column(name = "X_3")
    private Integer x3;

    @Column(name = "X_4")
    private Integer x4;

    @Column(name = "X_5")
    private Integer x5;

    @Column(name = "X_6")
    private Integer x6;

    @Column(name = "X_7")
    private Integer x7;

    @Column(name = "X_8")
    private Integer x8;

    @Column(name = "X_9")
    private Integer x9;

    @Column(name = "X_10")
    private Integer x10;

    @Column(name = "X_11")
    private Integer x11;

    @Column(name = "X_12")
    private Integer x12;

    @Column(name = "X_13")
    private Integer x13;

    @Column(name = "X_14")
    private Integer x14;

    @Column(name = "X_15")
    private Integer x15;

    @Column(name = "X_16")
    private Integer x16;

    @Column(name = "X_17")
    private Integer x17;

    @Column(name = "X_18")
    private Integer x18;

    @Column(name = "X_S1")
    private Integer xS1;

    @Column(name = "X_S2")
    private Integer xS2;

    @Column(name = "X_S3")
    private Integer xS3;

    @Column(name = "X_S4")
    private Integer xS4;

    @Column(name = "X_S5")
    private Integer xS5;

    @Column(name = "X_S6")
    private Integer xS6;

    @Column(name = "X_S7")
    private Integer xS7;

    @Column(name = "X_S8")
    private Integer xS8;

    @Column(name = "X_S9")
    private Integer xS9;

    @Column(name = "X_S10")
    private Integer xS10;

    @Column(name = "X_S11")
    private Integer xS11;

    @Column(name = "X_S12")
    private Integer xS12;

    @Column(name = "X_S13")
    private Integer xS13;

    @Column(name = "X_S14")
    private Integer xS14;

    @Column(name = "X_S15")
    private Integer xS15;

    @Column(name = "X_S16")
    private Integer xS16;

    @Column(name = "X_S17")
    private Integer xS17;

    @Column(name = "X_S18")
    private Integer xS18;

}