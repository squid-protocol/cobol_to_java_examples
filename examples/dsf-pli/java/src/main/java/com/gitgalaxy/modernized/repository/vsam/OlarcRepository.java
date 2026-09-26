package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.Olarc;

/**
 * F0019F05: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0019F02.pli (WRITE); src/GML/R0019F05.pli (WRITE).
 */
@Repository
public interface OlarcRepository extends JpaRepository<Olarc, String> {

}