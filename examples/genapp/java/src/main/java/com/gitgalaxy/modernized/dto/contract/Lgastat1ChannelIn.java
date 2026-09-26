package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * The containers Lgastat1 reads (CICS resources field testing: open (5 public / 0 private estates)).
 */
@Data
@NoArgsConstructor
public class Lgastat1ChannelIn {

    // GET CONTAINER(DFHEP.DATA.00001) at line 79 on the current channel, INTO WS-DATA-REQ
    private Lgastat1WsDataReq dfhepData00001;

    // GET CONTAINER(DFHEP.DATA.00002) at line 84 on the current channel, INTO WS-DATA-RC
    private Lgastat1WsDataRc dfhepData00002;

}