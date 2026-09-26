package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.Ettepmeld;

/**
 * OMRNULL: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010202.pli (UNLOCK); src/GML/R0019H01.pli (WRITE); src/R0010202.pli (UNLOCK); src/R0019H01.pli (WRITE).
 */
@Repository
public interface EttepmeldRepository extends JpaRepository<Ettepmeld, String> {

}