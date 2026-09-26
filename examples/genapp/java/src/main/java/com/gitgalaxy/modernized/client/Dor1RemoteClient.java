package com.gitgalaxy.modernized.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.gitgalaxy.modernized.dto.contract.Lgacdb01Cdb2area;
import com.gitgalaxy.modernized.dto.contract.Lgacus01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgacvs01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgapol01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgapvs01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgdpol01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgdpvs01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgicus01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgipol01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgucus01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgucvs01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgupol01Dfhcommarea;
import com.gitgalaxy.modernized.dto.contract.Lgupvs01Dfhcommarea;

/**
 * CICS region DOR1: the programs the CSD routes there (distributed program link), called
 * over HTTP. Point gitgalaxy.remote.dor1.url at the service that hosts them.
 */
@Component
public class Dor1RemoteClient {

    private final RestTemplate rest = new RestTemplate();
    private final String baseUrl;

    public Dor1RemoteClient(@Value("${gitgalaxy.remote.dor1.url:http://localhost:8080}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /** LINK to LGACDB01 on DOR1 (CSD base/cntl/cdef122.jcl:137 group GENAAORP). */
    public Lgacus01Dfhcommarea linkLgacdb01(Lgacus01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgacdb01/link", request, Lgacus01Dfhcommarea.class);
    }

    /** LINK to LGACDB02 on DOR1 (CSD base/cntl/cdef122.jcl:140 group GENAAORP). */
    public Lgacdb01Cdb2area linkLgacdb02(Lgacdb01Cdb2area request) {
        return rest.postForObject(baseUrl + "/api/v1/lgacdb02/link", request, Lgacdb01Cdb2area.class);
    }

    /** LINK to LGACVS01 on DOR1 (CSD base/cntl/cdef122.jcl:161 group GENAAORP). */
    public Lgacvs01Dfhcommarea linkLgacvs01(Lgacvs01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgacvs01/link", request, Lgacvs01Dfhcommarea.class);
    }

    /** LINK to LGAPDB01 on DOR1 (CSD base/cntl/cdef122.jcl:143 group GENAAORP). */
    public Lgapol01Dfhcommarea linkLgapdb01(Lgapol01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgapdb01/link", request, Lgapol01Dfhcommarea.class);
    }

    /** LINK to LGAPVS01 on DOR1 (CSD base/cntl/cdef122.jcl:164 group GENAAORP). */
    public Lgapvs01Dfhcommarea linkLgapvs01(Lgapvs01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgapvs01/link", request, Lgapvs01Dfhcommarea.class);
    }

    /** LINK to LGDPDB01 on DOR1 (CSD base/cntl/cdef122.jcl:146 group GENAAORP). */
    public Lgdpol01Dfhcommarea linkLgdpdb01(Lgdpol01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgdpdb01/link", request, Lgdpol01Dfhcommarea.class);
    }

    /** LINK to LGDPVS01 on DOR1 (CSD base/cntl/cdef122.jcl:167 group GENAAORP). */
    public Lgdpvs01Dfhcommarea linkLgdpvs01(Lgdpvs01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgdpvs01/link", request, Lgdpvs01Dfhcommarea.class);
    }

    /** LINK to LGICDB01 on DOR1 (CSD base/cntl/cdef122.jcl:149 group GENAAORP). */
    public Lgicus01Dfhcommarea linkLgicdb01(Lgicus01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgicdb01/link", request, Lgicus01Dfhcommarea.class);
    }

    /** LINK to LGIPDB01 on DOR1 (CSD base/cntl/cdef122.jcl:152 group GENAAORP). */
    public Lgipol01Dfhcommarea linkLgipdb01(Lgipol01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgipdb01/link", request, Lgipol01Dfhcommarea.class);
    }

    /** LINK to LGUCDB01 on DOR1 (CSD base/cntl/cdef122.jcl:155 group GENAAORP). */
    public Lgucus01Dfhcommarea linkLgucdb01(Lgucus01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgucdb01/link", request, Lgucus01Dfhcommarea.class);
    }

    /** LINK to LGUCVS01 on DOR1 (CSD base/cntl/cdef122.jcl:176 group GENAAORP). */
    public Lgucvs01Dfhcommarea linkLgucvs01(Lgucvs01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgucvs01/link", request, Lgucvs01Dfhcommarea.class);
    }

    /** LINK to LGUPDB01 on DOR1 (CSD base/cntl/cdef122.jcl:158 group GENAAORP). */
    public Lgupol01Dfhcommarea linkLgupdb01(Lgupol01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgupdb01/link", request, Lgupol01Dfhcommarea.class);
    }

    /** LINK to LGUPVS01 on DOR1 (CSD base/cntl/cdef122.jcl:179 group GENAAORP). */
    public Lgupvs01Dfhcommarea linkLgupvs01(Lgupvs01Dfhcommarea request) {
        return rest.postForObject(baseUrl + "/api/v1/lgupvs01/link", request, Lgupvs01Dfhcommarea.class);
    }

}