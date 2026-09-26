package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.OmrfeilFeilMeld;

/**
 * OMRFEIL: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010202.pli (UNLOCK); src/GML/R0011801.pli (WRITE); src/GML/R0019D70.pli (WRITE); src/GML/R0019E04.pli (WRITE); src/GML/R0019F02.pli (WRITE); src/GML/R0019F03.pli (WRITE); src/GML/R0019F05.pli (WRITE); src/GML/R0019H01.pli (WRITE); src/GML/R0019H60.pli (WRITE); src/GML/R001TE01.pli (READNEXT,STARTBR); src/GML/R001TE02.pli (READNEXT,STARTBR); src/R0010202.pli (UNLOCK); src/R0011801.pli (WRITE); src/R0019A01.pli (WRITE); src/R0019A03.pli (WRITE); src/R0019D70.pli (WRITE); src/R0019E04.pli (WRITE); src/R0019H01.pli (WRITE); src/R0019H21.pli (WRITE); src/R0019H31.pli (WRITE); src/R0019H3A.pli (WRITE); src/R0019H41.pli (WRITE); src/R0019H60.pli (WRITE); src/R001HL21.pli (WRITE).
 */
@Repository
public interface OmrfeilFeilMeldRepository extends JpaRepository<OmrfeilFeilMeld, String> {

    // TODO: STARTBR / READNEXT / READPREV browse the key, which is not one field (TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey).

}