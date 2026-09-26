package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.SekrpathFilRec;

/**
 * SEKRPATH: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R001TK82.pli (ENDBR,READNEXT,STARTBR); src/R001TK82.pli (ENDBR,READNEXT,STARTBR).
 */
@Repository
public interface SekrpathFilRecRepository extends JpaRepository<SekrpathFilRec, String> {

    // TODO: STARTBR / READNEXT / READPREV browse the key, which is not one field (TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey).

}