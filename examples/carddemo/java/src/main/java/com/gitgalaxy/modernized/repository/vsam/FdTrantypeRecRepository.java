package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.FdTrantypeRec;

/**
 * AWS.M2.CARDDEMO.TRANTYPE.VSAM.KSDS: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by app/cbl/CBTRN03C.cbl (INPUT).
 */
@Repository
public interface FdTrantypeRecRepository extends JpaRepository<FdTrantypeRec, String> {

}