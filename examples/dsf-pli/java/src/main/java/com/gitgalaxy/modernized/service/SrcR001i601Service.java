package com.gitgalaxy.modernized.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gitgalaxy.modernized.dto.contract.SrcR001i501KomOmr;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SrcR001i601Service {

    private static final Logger log = LoggerFactory.getLogger(SrcR001i601Service.class);

    private final ObjectProvider<SrcR0013101Service> srcR0013101Service;
    private final ObjectProvider<SrcR0013110Service> srcR0013110Service;
    private final ObjectProvider<SrcR0015101Service> srcR0015101Service;

    public void executeSrcR001i601(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__R001I601");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public SrcR001i501KomOmr handleLink(SrcR001i501KomOmr request) {
        log.info("SrcR001i601: handleLink");
        return request;
    }

    /** EXEC CICS LINK PROGRAM(R0013101) at src/R001I601.pli:363, src/R001I601.pli:407.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0013101() {
        srcR0013101Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0013110) at src/R001I601.pli:293.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0013110() {
        srcR0013110Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0015101) at src/R001I601.pli:307.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0015101() {
        srcR0015101Service.getObject().handleLink();
    }

}