package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.YrkekodeYkodeRec;

/**
 * YRKEKODE: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R001S003.pli (WRITE).
 */
@Repository
public interface YrkekodeYkodeRecRepository extends JpaRepository<YrkekodeYkodeRec, String> {

}