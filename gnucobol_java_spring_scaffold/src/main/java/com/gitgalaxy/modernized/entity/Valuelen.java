package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VALUELEN")
public class Valuelen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "CHAR_SET")
    private String charSet;

    @Column(name = "ARCHITECTURE")
    private String architecture;

    @Column(name = "ENDIAN_ORDER")
    private String endianOrder;

    @Column(name = "DOTS")
    private String dots;

    @Column(name = "DUMP_DOTS")
    private String dumpDots;

    @Column(name = "OFFSET")
    private BigDecimal offset;

    @Column(name = "HEX_LINE")
    private String hexLine;

    @Column(name = "HEX_DISP_VAL")
    private String hexDispVal;

    @Column(name = "SHOW")
    private String show;

    @Column(name = "EXTENDED_INFOS")
    private String extendedInfos;

    @Column(name = "LEN_DISPLAY")
    private BigDecimal lenDisplay;

    @Column(name = "BYTE")
    private String byteVal;

    @Column(name = "HEX_VALS")
    private String hexVals;

}