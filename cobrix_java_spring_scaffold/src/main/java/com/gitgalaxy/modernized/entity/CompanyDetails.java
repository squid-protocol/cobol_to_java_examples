package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "COMPANY_DETAILS")
public class CompanyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "SEGMENT_ID")
    private String segmentId;

    @Column(name = "COMPANY_ID")
    private String companyId;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TAXPAYER_TYPE")
    private String taxpayerType;

    @Column(name = "TAXPAYER_STR")
    private String taxpayerStr;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "CONTACT_PERSON")
    private String contactPerson;

}