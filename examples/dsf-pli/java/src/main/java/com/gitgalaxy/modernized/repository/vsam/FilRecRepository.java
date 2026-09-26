package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.FilRec;

/**
 * CMSDIV: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R001TK83.pli (READ,REWRITE,WRITE); src/R001TK83.pli (READ,REWRITE,WRITE).
 */
@Repository
public interface FilRecRepository extends JpaRepository<FilRec, String> {

}