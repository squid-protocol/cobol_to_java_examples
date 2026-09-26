package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.F0019h31Text;

/**
 * F0019H31: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/R0019H31.pli (WRITE); src/R0019H3A.pli (WRITE).
 */
@Repository
public interface F0019h31TextRepository extends JpaRepository<F0019h31Text, String> {

}