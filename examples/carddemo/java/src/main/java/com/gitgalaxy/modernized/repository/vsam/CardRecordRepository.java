package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.CardRecord;

/**
 * AWS.M2.CARDDEMO.CARDDATA.VSAM.KSDS: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by app/cbl/CBACT02C.cbl (INPUT); app/cbl/CBEXPORT.cbl (INPUT); app/cbl/COCRDLIC.cbl (ENDBR,READNEXT,READPREV,STARTBR); app/cbl/COCRDSLC.cbl (READ); app/cbl/COCRDUPC.cbl (READ,REWRITE).
 */
@Repository
public interface CardRecordRepository extends JpaRepository<CardRecord, String> {

    /** EXEC CICS STARTBR + READNEXT: records from a key onward, in key order. */
    List<CardRecord> findByCardNumGreaterThanEqualOrderByCardNumAsc(String cardNum, Pageable page);

    /** EXEC CICS READPREV: records from a key backward, in reverse key order. */
    List<CardRecord> findByCardNumLessThanEqualOrderByCardNumDesc(String cardNum, Pageable page);

    /** Alternate index AWS.M2.CARDDEMO.CARDDATA.VSAM.AIX (path AWS.M2.CARDDEMO.CARDDATA.VSAM.AIX.PATH) on CARD-ACCT-ID, non-unique. */
    List<CardRecord> findByCardAcctId(Long cardAcctId);

}