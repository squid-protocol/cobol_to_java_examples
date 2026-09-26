package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.WsAbndArea;
import com.gitgalaxy.modernized.entity.vsam.WsAbndAreaKey;

/**
 * CBSA.CICSBSA.ABNDFILE: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/base/cobol_src/ABNDPROC.cbl (WRITE).
 */
@Repository
public interface WsAbndAreaRepository extends JpaRepository<WsAbndArea, WsAbndAreaKey> {

}