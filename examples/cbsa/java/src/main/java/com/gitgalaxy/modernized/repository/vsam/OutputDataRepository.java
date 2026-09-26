package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.OutputData;
import com.gitgalaxy.modernized.entity.vsam.OutputDataKey;

/**
 * CBSA.CICSBSA.CUSTOMER: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/base/cobol_src/CRECUST.cbl (READ,REWRITE,WRITE); src/base/cobol_src/CUSTCTRL.cbl (READ); src/base/cobol_src/DELCUS.cbl (DELETE,READ); src/base/cobol_src/INQCUST.cbl (ENDBR,READ,READPREV,STARTBR); src/base/cobol_src/UPDCUST.cbl (READ,REWRITE); src/webui/src/main/java/com/ibm/cics/cip/bankliberty/web/vsam/Customer.java (delete,read,readForUpdate,rewrite,startBrowse,write).
 */
@Repository
public interface OutputDataRepository extends JpaRepository<OutputData, OutputDataKey> {

    /** EXEC CICS STARTBR / READNEXT over a group key: every record in key order. TODO: start
     *  from a key -- a range over an @EmbeddedId is not a derived query. */
    List<OutputData> findAllByOrderByIdCustomerSortcodeAscIdCustomerNumberAsc(Pageable page);

}