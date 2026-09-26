package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The containers Crdtagy2 writes (CICS resources field testing: open (5 public / 0 private estates)).
 */
@Data
@NoArgsConstructor
public class Crdtagy2ChannelOut {

    // PUT CONTAINER(CIPB) at line 225 on channel CIPCREDCHANN, FROM WS-CONT-IN
    private Crdtagy2WsContIn cipb;

}