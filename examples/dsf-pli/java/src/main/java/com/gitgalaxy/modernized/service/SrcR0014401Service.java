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
public class SrcR0014401Service {

    private static final Logger log = LoggerFactory.getLogger(SrcR0014401Service.class);

    private final ObjectProvider<SrcR0014141Service> srcR0014141Service;

    public void executeSrcR0014401(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__R0014401");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcR0014401: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0014141) at src/R0014401.pli:533.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0014141() {
        srcR0014141Service.getObject().handleLink();
    }

}