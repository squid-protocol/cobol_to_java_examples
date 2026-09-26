package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.AccountRecord;

/**
 * AWS.M2.CARDDEMO.ACCTDATA.VSAM.KSDS: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl (READ); app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl (READ); app/app-vsam-mq/cbl/COACCT01.cbl (READ); app/cbl/CBACT01C.cbl (INPUT); app/cbl/CBACT04C.cbl (I-O); app/cbl/CBEXPORT.cbl (INPUT); app/cbl/CBTRN02C.cbl (I-O); app/cbl/COACTUPC.cbl (READ,REWRITE); app/cbl/COACTVWC.cbl (READ); app/cbl/COBIL00C.cbl (READ,REWRITE).
 */
@Repository
public interface AccountRecordRepository extends JpaRepository<AccountRecord, Long> {

}