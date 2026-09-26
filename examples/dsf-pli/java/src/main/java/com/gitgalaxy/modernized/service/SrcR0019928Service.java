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
public class SrcR0019928Service {

    private static final Logger log = LoggerFactory.getLogger(SrcR0019928Service.class);

    private final ObjectProvider<SrcR0013110Service> srcR0013110Service;

    public void executeSrcR0019928(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__R0019928");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcR0019928: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0013110) at src/R0019928.pli:81, src/R0019928.pli:134, src/R0019928.pli:250.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0013110() {
        srcR0013110Service.getObject().handleLink();
    }

}