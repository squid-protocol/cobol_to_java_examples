package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.Inntrec;

/**
 * INTEJKR: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R001TE01.pli (DELETE,READNEXT,STARTBR,WRITE); src/GML/R001TE02.pli (DELETE,READNEXT,STARTBR,WRITE).
 */
@Repository
public interface InntrecRepository extends JpaRepository<Inntrec, String> {

    // TODO: STARTBR / READNEXT / READPREV browse the key, which is not one field (TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey).

}