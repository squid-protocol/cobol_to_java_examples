package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.OliRec;

/**
 * OLINNTE: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010202.pli (UNLOCK); src/GML/R001I201.pli (WRITE); src/GML/R001I301.pli (WRITE); src/GML/R001I501.pli (WRITE); src/GML/R001O301.pli (WRITE); src/R0010202.pli (UNLOCK); src/R001I201.pli (WRITE); src/R001I301.pli (WRITE); src/R001I501.pli (WRITE).
 */
@Repository
public interface OliRecRepository extends JpaRepository<OliRec, String> {

}