package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The containers Crdtagy3 reads (CICS resources field testing: open (5 public / 0 private estates)).
 */
@Data
@NoArgsConstructor
public class Crdtagy3ChannelIn {

    // GET CONTAINER(CIPC) at line 191 on channel CIPCREDCHANN, INTO WS-CONT-IN
    private Crdtagy3WsContIn cipc;

}