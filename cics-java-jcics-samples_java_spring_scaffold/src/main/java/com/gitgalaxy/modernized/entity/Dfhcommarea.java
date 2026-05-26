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

    @Column(name = "WS_RAWTIME")
    private Integer wsRawtime;

    @Column(name = "WS_DATE_DEBUG_AREA")
    private String wsDateDebugArea;

    @Column(name = "WS_TIME_DEBUG_AREA")
    private String wsTimeDebugArea;

    @Column(name = "LK_DATE_OUT")
    private String lkDateOut;

    @Column(name = "LK_TIME_OUT")
    private String lkTimeOut;

    @Column(name = "LK_LOWVAL_OUT")
    private String lkLowvalOut;

}