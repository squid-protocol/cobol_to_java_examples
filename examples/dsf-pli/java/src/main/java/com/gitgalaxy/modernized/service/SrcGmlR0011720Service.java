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
public class SrcGmlR0011720Service {

    private static final Logger log = LoggerFactory.getLogger(SrcGmlR0011720Service.class);

    private final ObjectProvider<SrcGmlR0013101Service> srcGmlR0013101Service;

    public void executeSrcGmlR0011720(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__GML__R0011720");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcGmlR0011720: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0013101) at src/GML/R0011720.pli:538.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0013101() {
        srcGmlR0013101Service.getObject().handleLink();
    }

}