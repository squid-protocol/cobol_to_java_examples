package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "WS_INPUT_RECORD")
public class WsInputRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "WS_DATE_NUM")
    private BigDecimal wsDateNum;

    @Column(name = "WS_DATE_ALPHA")
    private String wsDateAlpha;

    @Column(name = "WS_ACCT_ALPHA")
    private String wsAcctAlpha;

    @Column(name = "WS_AMOUNT_NUMERIC")
    private BigDecimal wsAmountNumeric;

    @Column(name = "WS_AMOUNT_FRACTION")
    private BigDecimal wsAmountFraction;

    @Column(name = "WS_NAME_ALPHABET")
    private String wsNameAlphabet;

    @Column(name = "WS_AMOUNT_FRACTION2")
    private BigDecimal wsAmountFraction2;

}