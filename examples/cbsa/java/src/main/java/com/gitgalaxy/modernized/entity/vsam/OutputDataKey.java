package com.gitgalaxy.modernized.entity.vsam;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The key of OutputData: CUSTOMER-SORTCODE, CUSTOMER-NUMBER together (offset 4, 16 bytes, from IDCAMS KEYS): the @EmbeddedId OutputDataKey.
 */
@Embeddable
@Data
@NoArgsConstructor
public class OutputDataKey implements Serializable {

    // CUSTOMER-SORTCODE: PIC 9(6), offset 4, 6 bytes
    @Column(name = "CUSTOMER_SORTCODE")
    private Integer customerSortcode;

    // CUSTOMER-NUMBER: PIC 9(10), offset 10, 10 bytes
    @Column(name = "CUSTOMER_NUMBER")
    private Long customerNumber;

}