package com.gitgalaxy.modernized.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gitgalaxy.modernized.client.Dor1RemoteClient;
import com.gitgalaxy.modernized.dto.contract.Lgacdb01CaErrorMsg;
import com.gitgalaxy.modernized.dto.contract.Lgapol01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgtestp1CommArea;
import com.gitgalaxy.modernized.exception.*;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class Lgapol01Service {

    private static final Logger log = LoggerFactory.getLogger(Lgapol01Service.class);

    private final Dor1RemoteClient dor1RemoteClient;
    private final ObjectProvider<LgstsqService> lgstsqService;
    private final ObjectProvider<Lgapdb01Service> lgapdb01Service;

    public void executeLgapol01(/* Parameters mapped from Controller */) {
        log.info("Executing modernized business logic for lgapol01");
        // TODO: [AI AGENT] Implement extracted business rules here.
    }

    /** Another program LINKed / XCTLed to this one. TODO: [AI AGENT] implement from the program's business rules. */
    public Lgtestp1CommArea handleLink(Lgtestp1CommArea request) {
        log.info("Lgapol01: handleLink");
        return request;
    }

    /** EXEC CICS LINK PROGRAM(LGAPDB01) at 121: the CSD routes it to region DOR1 (distributed program link).
     *  Remote calls field testing: open (5 public / 0 private estates). */
    public Lgapol01Dfhcommarea remoteLgapdb01L121(Lgapol01Dfhcommarea request) {
        return dor1RemoteClient.linkLgapdb01(request);
    }

    /** EXEC CICS LINK PROGRAM(LGSTSQ) at base/src/lgapol01.cbl:149, base/src/lgapol01.cbl:157, base/src/lgapol01.cbl:163.
     *  Call targets field testing: open (6 public / 0 private estates). */
    // TODO: this site passes ERROR-MSG; LGSTSQ receives CA-ERROR-MSG (base/src/lgacdb01.cbl) -- map one layout onto the other
    public Lgacdb01CaErrorMsg linkLgstsq(Lgacdb01CaErrorMsg request) {
        return lgstsqService.getObject().handleLink(request);
    }

    /** LINK PROGRAM(LGAPDB01) at base/src/lgapol01.cbl:121: the target is data-driven. Candidates: LGAPDB01 (value).
     *  Dynamic call targets field testing: open (5 public / 0 private estates). */
    public Object dispatchLgapdb01L121(String program, Object request) {
        switch (program.trim().toUpperCase()) {
            case "LGAPDB01":
                return lgapdb01Service.getObject().handleLink((Lgapol01Dfhcommarea) request);
            default:
                throw new IllegalArgumentException("LINK PROGRAM(LGAPDB01) at base/src/lgapol01.cbl:121: no known target " + program);
        }
    }

    /**
     * EXEC CICS ABEND ABCODE(LGCA) at base/src/lgapol01.cbl:101 (paragraph paragraph).
     * Units of work and handlers field testing: field-tested (6 public / 0 private estates).
     * Note: resolved at run time if an identifier.
     */
    public void abendLgcaL101() {
        throw new CicsAbendException("LGCA", "LGAPOL01", "base/src/lgapol01.cbl:101");
    }

}