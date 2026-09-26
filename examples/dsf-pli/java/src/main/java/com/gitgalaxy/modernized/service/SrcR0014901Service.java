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
public class SrcR0014901Service {

    private static final Logger log = LoggerFactory.getLogger(SrcR0014901Service.class);

    private final ObjectProvider<SrcR0014001Service> srcR0014001Service;
    private final ObjectProvider<SrcR0016001Service> srcR0016001Service;
    private final ObjectProvider<SrcR0017001Service> srcR0017001Service;

    public void executeSrcR0014901(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__R0014901");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcR0014901: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0014001) at src/R0014901.pli:429, src/R0014901.pli:440, src/R0014901.pli:448.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0014001() {
        srcR0014001Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0016001) at src/R0014901.pli:564, src/R0014901.pli:574.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0016001() {
        srcR0016001Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0017001) at src/R0014901.pli:495, src/R0014901.pli:516, src/R0014901.pli:539, src/R0014901.pli:2005.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcR0017001() {
        srcR0017001Service.getObject().handleLink();
    }

}