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
public class SrcGmlR001nc20Service {

    private static final Logger log = LoggerFactory.getLogger(SrcGmlR001nc20Service.class);

    private final ObjectProvider<SrcGmlR0019928Service> srcGmlR0019928Service;

    public void executeSrcGmlR001nc20(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__GML__R001NC20");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcGmlR001nc20: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0019928) at src/GML/R001NC20.pli:449.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0019928() {
        srcGmlR0019928Service.getObject().handleLink();
    }

}