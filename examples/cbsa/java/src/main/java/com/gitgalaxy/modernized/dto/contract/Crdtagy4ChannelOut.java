package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The containers Crdtagy4 writes (CICS resources field testing: open (5 public / 0 private estates)).
 */
@Data
@NoArgsConstructor
public class Crdtagy4ChannelOut {

    // PUT CONTAINER(CIPD) at line 227 on channel CIPCREDCHANN, FROM WS-CONT-IN
    private Crdtagy4WsContIn cipd;

}