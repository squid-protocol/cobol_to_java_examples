package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.InRec;

/**
 * HISTOR: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R001TK60.pli (WRITE); src/GML/R001TK61.pli (WRITE); src/GML/R001TK62.pli (ENDBR,READNEXT,STARTBR); src/R001TK60.pli (WRITE); src/R001TK61.pli (WRITE); src/R001TK62.pli (ENDBR,READNEXT,STARTBR).
 */
@Repository
public interface InRecRepository extends JpaRepository<InRec, String> {

    // TODO: STARTBR / READNEXT / READPREV browse the key, which is not one field (TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey).

}