package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The containers Crdtagy5 writes (CICS resources field testing: open (5 public / 0 private estates)).
 */
@Data
@NoArgsConstructor
public class Crdtagy5ChannelOut {

    // PUT CONTAINER(CIPE) at line 227 on channel CIPCREDCHANN, FROM WS-CONT-IN
    private Crdtagy5WsContIn cipe;

}