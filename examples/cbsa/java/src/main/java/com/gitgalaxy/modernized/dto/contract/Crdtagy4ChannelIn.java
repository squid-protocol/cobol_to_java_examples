package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The containers Crdtagy4 reads (CICS resources field testing: open (5 public / 0 private estates)).
 */
@Data
@NoArgsConstructor
public class Crdtagy4ChannelIn {

    // GET CONTAINER(CIPD) at line 194 on channel CIPCREDCHANN, INTO WS-CONT-IN
    private Crdtagy4WsContIn cipd;

}