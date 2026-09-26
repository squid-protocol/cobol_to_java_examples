package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The containers Crdtagy3 writes (CICS resources field testing: open (5 public / 0 private estates)).
 */
@Data
@NoArgsConstructor
public class Crdtagy3ChannelOut {

    // PUT CONTAINER(CIPC) at line 224 on channel CIPCREDCHANN, FROM WS-CONT-IN
    private Crdtagy3WsContIn cipc;

}