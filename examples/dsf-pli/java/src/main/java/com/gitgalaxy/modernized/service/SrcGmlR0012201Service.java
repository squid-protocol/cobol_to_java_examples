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
public class SrcGmlR0012201Service {

    private static final Logger log = LoggerFactory.getLogger(SrcGmlR0012201Service.class);

    private final ObjectProvider<SrcGmlR0013001Service> srcGmlR0013001Service;

    public void executeSrcGmlR0012201(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__GML__R0012201");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcGmlR0012201: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0013001) at src/GML/R0012201.pli:284, src/GML/R0012201.pli:319, src/GML/R0012201.pli:335.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0013001() {
        srcGmlR0013001Service.getObject().handleLink();
    }

}