package com.gitgalaxy.modernized.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gitgalaxy.modernized.dto.contract.SrcR001i501KomOmr;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SrcR0013601Service {

    private static final Logger log = LoggerFactory.getLogger(SrcR0013601Service.class);

    private final ObjectProvider<SrcR0013301Service> srcR0013301Service;
    private final ObjectProvider<SrcR0013520Service> srcR0013520Service;

    public void executeSrcR0013601(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__R0013601");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcR0013601: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0013301) at src/R0013601.pli:73.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public SrcR001i501KomOmr linkSrcR0013301(SrcR001i501KomOmr request) {
        return srcR0013301Service.getObject().handleLink(request);
    }

    /** EXEC CICS LINK PROGRAM(R0013520) at src/R0013601.pli:56.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0013520() {
        srcR0013520Service.getObject().handleLink();
    }

}