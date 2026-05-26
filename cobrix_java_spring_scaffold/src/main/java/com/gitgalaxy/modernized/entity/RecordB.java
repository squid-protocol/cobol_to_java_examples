package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "RECORD_B")
public class RecordB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "NAME_CHAR_1")
    private String nameChar1;

    @Column(name = "SHORT_NAME_REST")
    private String shortNameRest;

    @Column(name = "REST")
    private String rest;

    @Column(name = "FIRST_6")
    private BigDecimal first6;

    @Column(name = "ACCOUNT_MIDDLE")
    private BigDecimal accountMiddle;

    @Column(name = "LAST_4")
    private BigDecimal last4;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ACCOUNT_NO")
    private BigDecimal accountNo;

}