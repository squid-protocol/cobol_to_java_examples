package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "NUMERIC_DISPLAY")
public class NumericDisplay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "X_P1")
    private Integer xP1;

    @Column(name = "X_P2")
    private Integer xP2;

    @Column(name = "X_P3")
    private Integer xP3;

    @Column(name = "X_P4")
    private Integer xP4;

    @Column(name = "X_P5")
    private Integer xP5;

    @Column(name = "X_P6")
    private Integer xP6;

    @Column(name = "X_P7")
    private Integer xP7;

    @Column(name = "X_P8")
    private Integer xP8;

    @Column(name = "X_P9")
    private Integer xP9;

    @Column(name = "X_P10")
    private Integer xP10;

    @Column(name = "X_P11")
    private Integer xP11;

    @Column(name = "X_P12")
    private Integer xP12;

    @Column(name = "X_P13")
    private Integer xP13;

    @Column(name = "X_P14")
    private Integer xP14;

    @Column(name = "X_P15")
    private Integer xP15;

    @Column(name = "X_P16")
    private Integer xP16;

    @Column(name = "X_P17")
    private Integer xP17;

    @Column(name = "X_P18")
    private Integer xP18;

    @Column(name = "X_N1")
    private Integer xN1;

    @Column(name = "X_N2")
    private Integer xN2;

    @Column(name = "X_N3")
    private Integer xN3;

    @Column(name = "X_N4")
    private Integer xN4;

    @Column(name = "X_N5")
    private Integer xN5;

    @Column(name = "X_N6")
    private Integer xN6;

    @Column(name = "X_N7")
    private Integer xN7;

    @Column(name = "X_N8")
    private Integer xN8;

    @Column(name = "X_N9")
    private Integer xN9;

    @Column(name = "X_N10")
    private Integer xN10;

    @Column(name = "X_N11")
    private Integer xN11;

    @Column(name = "X_N12")
    private Integer xN12;

    @Column(name = "X_N13")
    private Integer xN13;

    @Column(name = "X_N14")
    private Integer xN14;

    @Column(name = "X_N15")
    private Integer xN15;

    @Column(name = "X_N16")
    private Integer xN16;

    @Column(name = "X_N17")
    private Integer xN17;

    @Column(name = "X_N18")
    private Integer xN18;

}