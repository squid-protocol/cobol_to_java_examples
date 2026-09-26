package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.W021Ykode;

/**
 * YRKEKOD: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R001B001.pli (READ); src/R001B001.pli (READ).
 */
@Repository
public interface W021YkodeRepository extends JpaRepository<W021Ykode, String> {

}