package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DFHCOMMAREA")
public class Dfhcommarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "WS_RESP")
    private Integer wsResp;

    @Column(name = "WS_RESP2")
    private Integer wsResp2;

    @Column(name = "WS_COMMAREA_LEN")
    private Integer wsCommareaLen;

    @Column(name = "WF_REQUEST_ID")
    private String wfRequestId;

    @Column(name = "WF_CUSTOMER_NUM")
    private String wfCustomerNum;

    @Column(name = "WF_POLICY_NUM")
    private String wfPolicyNum;

    @Column(name = "WS_ABSTIME")
    private Integer wsAbstime;

    @Column(name = "WS_TIME")
    private String wsTime;

    @Column(name = "WS_DATE")
    private String wsDate;

    @Column(name = "EM_DATE")
    private String emDate;

    @Column(name = "EM_TIME")
    private String emTime;

    @Column(name = "EM_POLNUM")
    private String emPolnum;

    @Column(name = "EM_CUSNUM")
    private String emCusnum;

    @Column(name = "CA_DATA")
    private String caData;

}