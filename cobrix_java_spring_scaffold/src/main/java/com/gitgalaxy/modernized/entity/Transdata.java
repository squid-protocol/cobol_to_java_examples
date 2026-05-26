package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TRANSDATA")
public class Transdata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "SIGNATURE")
    private String signature;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "COMPANY_ID")
    private String companyId;

    @Column(name = "WEALTH_QFY")
    private BigDecimal wealthQfy;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

}