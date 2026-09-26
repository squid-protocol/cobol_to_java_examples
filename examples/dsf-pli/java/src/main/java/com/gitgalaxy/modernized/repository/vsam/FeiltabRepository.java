package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.Feiltab;

/**
 * FEILTAB: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010202.pli (UNLOCK); src/GML/R0010425.pli (READ,READPREV,STARTBR); src/GML/R0019921.pli (READ); src/R0010202.pli (UNLOCK); src/R0010425.pli (READ,READPREV,STARTBR); src/R0019921.pli (READ); src/R0019998.pli (READ).
 */
@Repository
public interface FeiltabRepository extends JpaRepository<Feiltab, String> {

    // TODO: STARTBR / READNEXT / READPREV browse the key, which is not one field (TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey).

}