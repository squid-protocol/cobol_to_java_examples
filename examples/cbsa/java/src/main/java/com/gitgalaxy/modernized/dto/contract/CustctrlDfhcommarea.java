package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record DFHCOMMAREA (src/base/cobol_src/CUSTCTRL.cbl), 259 bytes, from GitGalaxy's verified skeleton.
 * The DFHCOMMAREA Custctrl declares in its LINKAGE SECTION.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CustctrlDfhcommarea {

    // CUSTOMER-CONTROL-EYECATCHER: PIC X(4), offset 0, 4 bytes (src/base/cobol_copy/CUSTCTRL.cpy)
    private String customerControlEyecatcher;

    // CUSTOMER-CONTROL-SORTCODE: PIC 9(6) DISPLAY, offset 4, 6 bytes (src/base/cobol_copy/CUSTCTRL.cpy)
    private Integer customerControlSortcode;

    // CUSTOMER-CONTROL-NUMBER: PIC 9(10) DISPLAY, offset 10, 10 bytes (src/base/cobol_copy/CUSTCTRL.cpy)
    private Long customerControlNumber;

    // NUMBER-OF-CUSTOMERS: PIC 9(10) DISPLAY, offset 20, 10 bytes (src/base/cobol_copy/CUSTCTRL.cpy)
    private Long numberOfCustomers;

    // LAST-CUSTOMER-NUMBER: PIC 9(10) DISPLAY, offset 30, 10 bytes (src/base/cobol_copy/CUSTCTRL.cpy)
    private Long lastCustomerNumber;

    // CUSTOMER-CONTROL-SUCCESS-FLAG: PIC X, offset 40, 1 bytes (src/base/cobol_copy/CUSTCTRL.cpy)
    private String customerControlSuccessFlag;

    // CUSTOMER-CONTROL-FAIL-CODE: PIC X, offset 41, 1 bytes (src/base/cobol_copy/CUSTCTRL.cpy)
    private String customerControlFailCode;

}