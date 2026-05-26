package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "RECORD")
public class LegacyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "ID")
    private Integer id;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @Column(name = "COMPANY_ID_NUM")
    private Integer companyIdNum;

    @Column(name = "CLIENTID")
    private String clientid;

    @Column(name = "REGISTRATION_NUM")
    private String registrationNum;

    @Column(name = "NUMBER_OF_ACCTS")
    private Integer numberOfAccts;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "ACCOUNT_TYPE_N")
    private Integer accountTypeN;

}