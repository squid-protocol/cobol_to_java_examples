package com.gitgalaxy.modernized.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DIRTY02")
public class Dirty02 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sys_id")
    private Long sysId;

    @Column(name = "IN_REC")
    private String inRec;

    @Column(name = "OUT_REC")
    private String outRec;

    @Column(name = "WS_ACTIVE_VAR")
    private String wsActiveVar;

}