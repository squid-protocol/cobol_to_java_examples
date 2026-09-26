package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The containers Crdtagy5 reads (CICS resources field testing: open (5 public / 0 private estates)).
 */
@Data
@NoArgsConstructor
public class Crdtagy5ChannelIn {

    // GET CONTAINER(CIPE) at line 192 on channel CIPCREDCHANN, INTO WS-CONT-IN
    private Crdtagy5WsContIn cipe;

}