package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.W01DiaRecl;

/**
 * DIAGNOS: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010202.pli (UNLOCK); src/GML/R0010603.pli (READ); src/GML/R0010703.pli (ENDBR,READ,STARTBR); src/GML/R001B001.pli (READ); src/GML/R001N603.pli (READ); src/GML/R001U603.pli (READ); src/R0010603.pli (READ); src/R001B001.pli (READ); src/R001N603.pli (READ).
 */
@Repository
public interface W01DiaReclRepository extends JpaRepository<W01DiaRecl, String> {

    // TODO: STARTBR / READNEXT / READPREV browse the key, which is not one field (TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey).

}