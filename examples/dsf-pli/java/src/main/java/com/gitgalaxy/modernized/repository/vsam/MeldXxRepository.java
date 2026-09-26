package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.MeldXx;

/**
 * F0019H01: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/R0019H01.pli (WRITE); src/R0019H21.pli (WRITE); src/R0019H31.pli (WRITE); src/R0019H3A.pli (WRITE); src/R0019H41.pli (WRITE); src/R001HL21.pli (WRITE).
 */
@Repository
public interface MeldXxRepository extends JpaRepository<MeldXx, String> {

}