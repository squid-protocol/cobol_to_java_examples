package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "WS_CURRENT_DATE_DATA")
public class WsCurrentDateData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "ACCT_NO_O")
    private String acctNoO;

    @Column(name = "LAST_NAME_O")
    private String lastNameO;

    @Column(name = "ACCT_NO")
    private String acctNo;

    @Column(name = "ACCT_LIMIT")
    private BigDecimal acctLimit;

    @Column(name = "ACCT_BALANCE")
    private BigDecimal acctBalance;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "STREET_ADDR")
    private String streetAddr;

    @Column(name = "CITY_COUNTY")
    private String cityCounty;

    @Column(name = "USA_STATE")
    private String usaState;

    @Column(name = "LASTREC")
    private String lastrec;

    @Column(name = "DISP_SUB1")
    private BigDecimal dispSub1;

    @Column(name = "SUB1")
    private BigDecimal sub1;

    @Column(name = "OVERLIMIT_MAX")
    private Integer overlimitMax;

    @Column(name = "OL_ACCT_NO")
    private String olAcctNo;

    @Column(name = "OL_ACCT_LIMIT")
    private BigDecimal olAcctLimit;

    @Column(name = "OL_ACCT_BALANCE")
    private BigDecimal olAcctBalance;

    @Column(name = "OL_LASTNAME")
    private String olLastname;

    @Column(name = "OL_FIRSTNAME")
    private String olFirstname;

    @Column(name = "VIRGINIA_CLIENTS")
    private Integer virginiaClients;

    @Column(name = "OLS_STATUS")
    private String olsStatus;

    @Column(name = "OLS_ACCTNUM")
    private String olsAcctnum;

    @Column(name = "HDR_YR")
    private BigDecimal hdrYr;

    @Column(name = "HDR_MO")
    private String hdrMo;

    @Column(name = "HDR_DAY")
    private String hdrDay;

    @Column(name = "WS_CURRENT_YEAR")
    private BigDecimal wsCurrentYear;

    @Column(name = "WS_CURRENT_MONTH")
    private BigDecimal wsCurrentMonth;

    @Column(name = "WS_CURRENT_DAY")
    private BigDecimal wsCurrentDay;

    @Column(name = "WS_CURRENT_HOURS")
    private BigDecimal wsCurrentHours;

    @Column(name = "WS_CURRENT_MINUTE")
    private BigDecimal wsCurrentMinute;

    @Column(name = "WS_CURRENT_SECOND")
    private BigDecimal wsCurrentSecond;

    @Column(name = "WS_CURRENT_MILLISECONDS")
    private BigDecimal wsCurrentMilliseconds;

}