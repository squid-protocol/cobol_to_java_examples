package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ERR_RECORD")
public class ErrRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "DATE_CONT")
    private String dateCont;

    @Column(name = "INPUT_CONT")
    private String inputCont;

    @Column(name = "OUTPUT_CONT")
    private String outputCont;

    @Column(name = "RESP_CONT")
    private String respCont;

    @Column(name = "INPUTLENGTH")
    private Integer inputlength;

    @Column(name = "CURRENTTIME")
    private Integer currenttime;

    @Column(name = "ABENDCODE")
    private String abendcode;

    @Column(name = "CHANNELNAME")
    private String channelname;

    @Column(name = "INPUTSTRING")
    private String inputstring;

    @Column(name = "OUTPUTSTRING")
    private String outputstring;

    @Column(name = "RESPCODE")
    private Integer respcode;

    @Column(name = "RESPCODE2")
    private Integer respcode2;

    @Column(name = "DATESTRING")
    private String datestring;

    @Column(name = "TIMESTRING")
    private String timestring;

    @Column(name = "RC_RECORD")
    private Integer rcRecord;

}