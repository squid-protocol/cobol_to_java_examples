package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.FdTranCatBalRecord;
import com.gitgalaxy.modernized.entity.vsam.FdTranCatBalRecordKey;

/**
 * AWS.M2.CARDDEMO.TCATBALF.VSAM.KSDS: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by app/cbl/CBACT04C.cbl (INPUT); app/cbl/CBTRN02C.cbl (I-O).
 */
@Repository
public interface FdTranCatBalRecordRepository extends JpaRepository<FdTranCatBalRecord, FdTranCatBalRecordKey> {

}