package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The key of WfPolicyInfo: WF-REQUEST-ID, WF-CUSTOMER-NUM, WF-POLICY-NUM together (offset 0, 21 bytes, from the programs' RIDFLD / RECORD KEY): the @EmbeddedId WfPolicyInfoKey.
 */
@Embeddable
@Data
@NoArgsConstructor
public class WfPolicyInfoKey implements Serializable {

    // WF-REQUEST-ID: PIC X, offset 0, 1 bytes
    @Column(name = "WF_REQUEST_ID", length = 1)
    private String wfRequestId;

    // WF-CUSTOMER-NUM: PIC X(10), offset 1, 10 bytes
    @Column(name = "WF_CUSTOMER_NUM", length = 10)
    private String wfCustomerNum;

    // WF-POLICY-NUM: PIC X(10), offset 11, 10 bytes
    @Column(name = "WF_POLICY_NUM", length = 10)
    private String wfPolicyNum;

}