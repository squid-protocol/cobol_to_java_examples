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
public class SrcR0010620Service {

    private static final Logger log = LoggerFactory.getLogger(SrcR0010620Service.class);

    private final ObjectProvider<SrcR0019928Service> srcR0019928Service;

    public void executeSrcR0010620(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__R0010620");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcR0010620: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0019928) at src/R0010620.pli:576, src/R0010620.pli:690.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0019928() {
        srcR0019928Service.getObject().handleLink();
    }

}