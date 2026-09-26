package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.Ptr;

/**
 * TRKLIST: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0019H01.pli (WRITE); src/GML/R001TE01.pli (READNEXT,STARTBR); src/GML/R001TE02.pli (READNEXT,STARTBR); src/R0019H01.pli (WRITE).
 */
@Repository
public interface PtrRepository extends JpaRepository<Ptr, String> {

    // TODO: STARTBR / READNEXT / READPREV browse the key, which is not one field (TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey).

}