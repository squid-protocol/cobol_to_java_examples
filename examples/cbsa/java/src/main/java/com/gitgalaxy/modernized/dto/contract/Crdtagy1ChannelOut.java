package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The containers Crdtagy1 writes (CICS resources field testing: open (5 public / 0 private estates)).
 */
@Data
@NoArgsConstructor
public class Crdtagy1ChannelOut {

    // PUT CONTAINER(CIPA) at line 225 on channel CIPCREDCHANN, FROM WS-CONT-IN
    private Crdtagy1WsContIn cipa;

}