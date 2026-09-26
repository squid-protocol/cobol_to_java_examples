package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.StRecl;

/**
 * STATTAB: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010424.pli (READ,READPREV,STARTBR); src/GML/R0010430.pli (READ); src/GML/R0010505.pli (READ); src/GML/R0010605.pli (READ); src/GML/R0010703.pli (READ); src/GML/R0010805.pli (READ); src/GML/R0010905.pli (READ); src/GML/R0011905.pli (READ); src/GML/R001N503.pli (READ); src/GML/R001N605.pli (READ); src/GML/R001N805.pli (READ); src/GML/R001N905.pli (READ); src/GML/R001U605.pli (READ); src/GML/R001U805.pli (READ); src/GML/R001UE05.pli (READ); src/GML/R001UJ05.pli (READ); src/R0010424.pli (READ,READPREV,STARTBR); src/R0010430.pli (READ); src/R0010505.pli (READ); src/R0010605.pli (READ); src/R0010805.pli (READ); src/R0011905.pli (READ); src/R001N503.pli (READ); src/R001N605.pli (READ); src/R001N805.pli (READ); src/R001N905.pli (READ); src/R001U605.pli (READ); src/R001U805.pli (READ); src/R001UE05.pli (READ); src/R001UJ03.pli (READ).
 */
@Repository
public interface StReclRepository extends JpaRepository<StRecl, String> {

    // TODO: STARTBR / READNEXT / READPREV browse the key, which is not one field (TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey).

}