package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.LikningKommnrRecl;

/**
 * LIKNING: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/R0010423.pli (READ,READPREV,STARTBR); src/R001I402.pli (READ); src/R001I501.pli (READ); src/R001I903.pli (READ).
 */
@Repository
public interface LikningKommnrReclRepository extends JpaRepository<LikningKommnrRecl, String> {

    // TODO: STARTBR / READNEXT / READPREV browse the key, which is not one field (TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey).

}