package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.SysRec;

/**
 * SYSREG: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010202.pli (UNLOCK); src/GML/R001NO10.pli (WRITE); src/R0010202.pli (UNLOCK).
 */
@Repository
public interface SysRecRepository extends JpaRepository<SysRec, String> {

}