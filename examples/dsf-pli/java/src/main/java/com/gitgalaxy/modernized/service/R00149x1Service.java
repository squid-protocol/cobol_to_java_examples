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
public class R00149x1Service {

    private static final Logger log = LoggerFactory.getLogger(R00149x1Service.class);

    private final ObjectProvider<SrcGmlR0014001Service> srcGmlR0014001Service;
    private final ObjectProvider<SrcGmlR0016001Service> srcGmlR0016001Service;
    private final ObjectProvider<SrcGmlR0017001Service> srcGmlR0017001Service;

    public void executeR00149x1(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for R00149X1");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("R00149x1: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0014001) at src/GML/R00149X1.pli:342.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0014001() {
        srcGmlR0014001Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0016001) at src/GML/R00149X1.pli:410, src/GML/R00149X1.pli:417.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0016001() {
        srcGmlR0016001Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0017001) at src/GML/R00149X1.pli:360, src/GML/R00149X1.pli:388.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0017001() {
        srcGmlR0017001Service.getObject().handleLink();
    }

}