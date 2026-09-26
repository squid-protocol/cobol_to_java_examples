package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.SecUserData;

/**
 * AWS.M2.CARDDEMO.USRSEC.VSAM.KSDS: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by app/cbl/COSGN00C.cbl (READ); app/cbl/COUSR00C.cbl (ENDBR,READNEXT,READPREV,STARTBR); app/cbl/COUSR01C.cbl (WRITE); app/cbl/COUSR02C.cbl (READ,REWRITE); app/cbl/COUSR03C.cbl (DELETE,READ).
 */
@Repository
public interface SecUserDataRepository extends JpaRepository<SecUserData, String> {

    /** EXEC CICS STARTBR + READNEXT: records from a key onward, in key order. */
    List<SecUserData> findBySecUsrIdGreaterThanEqualOrderBySecUsrIdAsc(String secUsrId, Pageable page);

    /** EXEC CICS READPREV: records from a key backward, in reverse key order. */
    List<SecUserData> findBySecUsrIdLessThanEqualOrderBySecUsrIdDesc(String secUsrId, Pageable page);

}