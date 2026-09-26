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
public class SrcGmlR0011120Service {

    private static final Logger log = LoggerFactory.getLogger(SrcGmlR0011120Service.class);

    private final ObjectProvider<SrcGmlR0019928Service> srcGmlR0019928Service;

    public void executeSrcGmlR0011120(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__GML__R0011120");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcGmlR0011120: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0019928) at src/GML/R0011120.pli:116, src/GML/R0011120.pli:553.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0019928() {
        srcGmlR0019928Service.getObject().handleLink();
    }

}