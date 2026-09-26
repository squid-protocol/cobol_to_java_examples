package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "LK_M03B_AREA")
public class Cbstm03bLkM03bArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "FD_TRNX_CARD")
    private String fdTrnxCard;

    @Column(name = "FD_TRNX_ID")
    private String fdTrnxId;

    @Column(name = "FD_CUST_ID")
    private String fdCustId;

    @Column(name = "FD_ACCT_ID")
    private Integer fdAcctId;

    @Column(name = "LK_M03B_DD")
    private String lkM03BDd;

    @Column(name = "LK_M03B_RC")
    private String lkM03BRc;

    @Column(name = "LK_M03B_KEY")
    private String lkM03BKey;

    @Column(name = "LK_M03B_KEY_LN")
    private Integer lkM03BKeyLn;

    @Column(name = "LK_M03B_FLDT")
    private String lkM03BFldt;

}