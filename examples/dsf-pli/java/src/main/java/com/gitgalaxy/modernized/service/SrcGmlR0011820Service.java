package com.gitgalaxy.modernized.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gitgalaxy.modernized.dto.contract.FeilStruc;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SrcGmlR0011820Service {

    private static final Logger log = LoggerFactory.getLogger(SrcGmlR0011820Service.class);

    private final ObjectProvider<SrcGmlR0013101Service> srcGmlR0013101Service;
    private final ObjectProvider<SrcGmlR0014001Service> srcGmlR0014001Service;
    private final ObjectProvider<SrcGmlR0014901Service> srcGmlR0014901Service;
    private final ObjectProvider<SrcGmlR0015401Service> srcGmlR0015401Service;
    private final ObjectProvider<SrcGmlR0017001Service> srcGmlR0017001Service;
    private final ObjectProvider<SrcGmlR0017101Service> srcGmlR0017101Service;
    private final ObjectProvider<SrcGmlR0019921Service> srcGmlR0019921Service;

    public void executeSrcGmlR0011820(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for src__GML__R0011820");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public void handleLink() {
        log.info("SrcGmlR0011820: handleLink");
    }

    /** EXEC CICS LINK PROGRAM(R0013101) at src/GML/R0011820.pli:180.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0013101() {
        srcGmlR0013101Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0014001) at src/GML/R0011820.pli:357.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0014001() {
        srcGmlR0014001Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0014901) at src/GML/R0011820.pli:377.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0014901() {
        srcGmlR0014901Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0015401) at src/GML/R0011820.pli:391.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0015401() {
        srcGmlR0015401Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0017001) at src/GML/R0011820.pli:367.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0017001() {
        srcGmlR0017001Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0017101) at src/GML/R0011820.pli:404.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public void linkSrcGmlR0017101() {
        srcGmlR0017101Service.getObject().handleLink();
    }

    /** EXEC CICS LINK PROGRAM(R0019921) at src/GML/R0011820.pli:440.
     *  Call targets field testing: open (6 public / 0 private estates). */
    public FeilStruc linkSrcGmlR0019921(FeilStruc request) {
        return srcGmlR0019921Service.getObject().handleLink(request);
    }

}