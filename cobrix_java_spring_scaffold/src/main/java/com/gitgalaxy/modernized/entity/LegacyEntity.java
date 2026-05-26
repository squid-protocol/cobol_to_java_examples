package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ENTITY")
public class LegacyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "SEGMENT_ID")
    private BigDecimal segmentId;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TAXPAYER")
    private Integer taxpayer;

    @Column(name = "DEPT_NAME")
    private String deptName;

    @Column(name = "EXTENSION")
    private BigDecimal extension;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "HOME_ADDRESS")
    private String homeAddress;

    @Column(name = "PHONE_NUM")
    private String phoneNum;

    @Column(name = "FLOOR")
    private BigDecimal floor;

    @Column(name = "ROOM_NUMBER")
    private BigDecimal roomNumber;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "POSTAL_ADDRESS")
    private String postalAddress;

    @Column(name = "ZIP")
    private String zip;

    @Column(name = "CONTRACT_NUMBER")
    private String contractNumber;

    @Column(name = "STATE")
    private String state;

    @Column(name = "DUE_DATE")
    private String dueDate;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

}