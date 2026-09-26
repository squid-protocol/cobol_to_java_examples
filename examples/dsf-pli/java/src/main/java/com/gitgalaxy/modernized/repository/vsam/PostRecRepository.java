package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.PostRec;

/**
 * KDPOST: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010202.pli (UNLOCK); src/GML/R001TK07.pli (READ); src/GML/R001TK43.pli (READ); src/R0010202.pli (UNLOCK); src/R001TK07.pli (READ); src/R001TK43.pli (READ).
 */
@Repository
public interface PostRecRepository extends JpaRepository<PostRec, String> {

}