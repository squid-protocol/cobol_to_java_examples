package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_RECORD")
public class CustomerRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "ACCT_NO_O")
    private String acctNoO;

    @Column(name = "ACCT_LASTN_O")
    private String acctLastnO;

    @Column(name = "ACCT_FIRSTN_O")
    private String acctFirstnO;

    @Column(name = "ACCT_COMMENT_O")
    private String acctCommentO;

    @Column(name = "LNAME")
    private String lname;

    @Column(name = "ERROR_TEXT")
    private String errorText;

    @Column(name = "ERROR_TEXT_LEN")
    private Integer errorTextLen;

    @Column(name = "ERROR_TEXT_HBOUND")
    private Integer errorTextHbound;

    @Column(name = "UD_ERROR_MESSAGE")
    private String udErrorMessage;

    @Column(name = "ACCT_NO")
    private String acctNo;

    @Column(name = "ACCT_LIMIT")
    private BigDecimal acctLimit;

    @Column(name = "ACCT_BALANCE")
    private BigDecimal acctBalance;

    @Column(name = "ACCT_LASTN")
    private String acctLastn;

    @Column(name = "ACCT_FIRSTN")
    private String acctFirstn;

    @Column(name = "ACCT_COMMENT")
    private String acctComment;

}