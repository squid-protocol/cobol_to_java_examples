package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.FdTranCatRecord;
import com.gitgalaxy.modernized.entity.vsam.FdTranCatRecordKey;

/**
 * AWS.M2.CARDDEMO.TRANCATG.VSAM.KSDS: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by app/cbl/CBTRN03C.cbl (INPUT).
 */
@Repository
public interface FdTranCatRecordRepository extends JpaRepository<FdTranCatRecord, FdTranCatRecordKey> {

}