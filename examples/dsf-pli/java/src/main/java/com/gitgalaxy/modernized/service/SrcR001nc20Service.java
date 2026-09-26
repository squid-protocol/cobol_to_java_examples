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
public class SrcR001nc20Service {

    private static final Logger log = LoggerFactory.getLogger(SrcR001nc20Service.class);

    private final ObjectProvider<SrcR0019928Service> srcR0019928Service;

    public void executeSrcR001nc20(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__R001NC20");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcR001nc20: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0019928) at src/R001NC20.pli:439.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0019928() {
        srcR0019928Service.getObject().handleLink();
    }

}