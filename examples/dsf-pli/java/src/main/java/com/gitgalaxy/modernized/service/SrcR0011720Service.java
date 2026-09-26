package com.gitgalaxy.modernized.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SrcR0011720Service {

    private static final Logger log = LoggerFactory.getLogger(SrcR0011720Service.class);

    private final ObjectProvider<SrcR0013101Service> srcR0013101Service;

    public void executeSrcR0011720(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__R0011720");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcR0011720: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0013101) at src/R0011720.pli:647.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0013101() {
        srcR0013101Service.getObject().handleLink();
    }

}