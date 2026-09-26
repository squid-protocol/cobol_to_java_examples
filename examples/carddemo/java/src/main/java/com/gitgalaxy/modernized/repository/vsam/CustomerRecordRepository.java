package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.CustomerRecord;

/**
 * AWS.M2.CARDDEMO.CUSTDATA.VSAM.KSDS: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl (READ); app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl (READ); app/cbl/CBCUS01C.cbl (INPUT); app/cbl/CBEXPORT.cbl (INPUT); app/cbl/COACTUPC.cbl (READ,REWRITE); app/cbl/COACTVWC.cbl (READ).
 */
@Repository
public interface CustomerRecordRepository extends JpaRepository<CustomerRecord, Integer> {

}