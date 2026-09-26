package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.StrykRecl;

/**
 * STRYK: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010202.pli (UNLOCK); src/GML/R0019958.pli (DELETE,READ,WRITE); src/GML/R001I402.pli (READ); src/GML/R001I903.pli (READ); src/R0010202.pli (UNLOCK); src/R0019958.pli (DELETE,READ,WRITE); src/R001I402.pli (READ); src/R001I903.pli (READ).
 */
@Repository
public interface StrykReclRepository extends JpaRepository<StrykRecl, String> {

}