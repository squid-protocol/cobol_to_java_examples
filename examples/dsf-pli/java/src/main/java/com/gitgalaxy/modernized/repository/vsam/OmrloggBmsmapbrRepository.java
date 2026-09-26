package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.OmrloggBmsmapbr;

/**
 * OMRLOGG: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010202.pli (UNLOCK); src/GML/R0010427.pli (READNEXT,STARTBR); src/GML/R0019H01.pli (READNEXT,STARTBR,WRITE); src/GML/R0019H60.pli (READNEXT,STARTBR,WRITE); src/R0010202.pli (UNLOCK); src/R0010427.pli (READNEXT,STARTBR); src/R0019H01.pli (READNEXT,STARTBR,WRITE); src/R0019H21.pli (READNEXT,STARTBR,WRITE); src/R0019H31.pli (READNEXT,STARTBR,WRITE); src/R0019H3A.pli (READNEXT,STARTBR,WRITE); src/R0019H41.pli (READNEXT,STARTBR,WRITE); src/R0019H60.pli (READNEXT,STARTBR,WRITE); src/R001HL21.pli (READNEXT,STARTBR,WRITE).
 */
@Repository
public interface OmrloggBmsmapbrRepository extends JpaRepository<OmrloggBmsmapbr, String> {

    // TODO: STARTBR / READNEXT / READPREV browse the key, which is not one field (TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey).

}