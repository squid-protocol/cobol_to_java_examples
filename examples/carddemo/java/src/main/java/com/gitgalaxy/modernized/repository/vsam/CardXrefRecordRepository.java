package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.CardXrefRecord;

/**
 * AWS.M2.CARDDEMO.CARDXREF.VSAM.KSDS: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by app/app-authorization-ims-db2-mq/cbl/COPAUA0C.cbl (READ); app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl (READ); app/cbl/CBACT03C.cbl (INPUT); app/cbl/CBACT04C.cbl (INPUT); app/cbl/CBEXPORT.cbl (INPUT); app/cbl/CBTRN02C.cbl (INPUT); app/cbl/CBTRN03C.cbl (INPUT); app/cbl/COACTUPC.cbl (READ); app/cbl/COACTVWC.cbl (READ); app/cbl/COBIL00C.cbl (READ); app/cbl/COTRN02C.cbl (READ).
 */
@Repository
public interface CardXrefRecordRepository extends JpaRepository<CardXrefRecord, String> {

    /** Alternate index AWS.M2.CARDDEMO.CARDXREF.VSAM.AIX (path AWS.M2.CARDDEMO.CARDXREF.VSAM.AIX.PATH) on XREF-ACCT-ID, non-unique. */
    List<CardXrefRecord> findByXrefAcctId(Long xrefAcctId);

}