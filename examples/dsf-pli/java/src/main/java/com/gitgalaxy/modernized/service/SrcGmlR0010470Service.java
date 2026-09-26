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
public class SrcGmlR0010470Service {

    private static final Logger log = LoggerFactory.getLogger(SrcGmlR0010470Service.class);

    private final ObjectProvider<SrcGmlR001a470Service> srcGmlR001a470Service;
    private final ObjectProvider<SrcGmlR001b470Service> srcGmlR001b470Service;
    private final ObjectProvider<SrcGmlR001c470Service> srcGmlR001c470Service;

    public void executeSrcGmlR0010470(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__GML__R0010470");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcGmlR0010470: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R001A470) at src/GML/R0010470.pli:120.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR001a470() {
        srcGmlR001a470Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R001B470) at src/GML/R0010470.pli:123.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR001b470() {
        srcGmlR001b470Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R001C470) at src/GML/R0010470.pli:127.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR001c470() {
        srcGmlR001c470Service.getObject().handleLink();
    }

}