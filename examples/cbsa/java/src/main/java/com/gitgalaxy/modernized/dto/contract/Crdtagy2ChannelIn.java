package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The containers Crdtagy2 reads (CICS resources field testing: open (5 public / 0 private estates)).
 */
@Data
@NoArgsConstructor
public class Crdtagy2ChannelIn {

    // GET CONTAINER(CIPB) at line 193 on channel CIPCREDCHANN, INTO WS-CONT-IN
    private Crdtagy2WsContIn cipb;

}