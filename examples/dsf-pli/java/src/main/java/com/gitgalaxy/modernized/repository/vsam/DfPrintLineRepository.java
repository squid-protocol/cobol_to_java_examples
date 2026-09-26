package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.DfPrintLine;

/**
 * PRINTRX: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010430.pli (WRITE); src/R0010430.pli (WRITE).
 */
@Repository
public interface DfPrintLineRepository extends JpaRepository<DfPrintLine, String> {

}