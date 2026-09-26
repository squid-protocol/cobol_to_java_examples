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
public class SrcGmlR0013601Service {

    private static final Logger log = LoggerFactory.getLogger(SrcGmlR0013601Service.class);

    private final ObjectProvider<SrcGmlR0013301Service> srcGmlR0013301Service;
    private final ObjectProvider<SrcGmlR0013520Service> srcGmlR0013520Service;

    public void executeSrcGmlR0013601(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__GML__R0013601");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcGmlR0013601: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0013301) at src/GML/R0013601.pli:78.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0013301() {
        srcGmlR0013301Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0013520) at src/GML/R0013601.pli:61.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0013520() {
        srcGmlR0013520Service.getObject().handleLink();
    }

}