package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.TkRecl;

/**
 * TKNRTAB: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R0010202.pli (UNLOCK); src/GML/R0010422.pli (READ,READPREV,STARTBR); src/GML/R0010430.pli (READ); src/GML/R0010503.pli (READ); src/GML/R0010603.pli (READ); src/GML/R0010703.pli (READ); src/GML/R0010803.pli (READ); src/GML/R0010903.pli (READ); src/GML/R0011003.pli (READ); src/GML/R0011103.pli (READ); src/GML/R0011203.pli (READ); src/GML/R0011303.pli (READ); src/GML/R0011403.pli (READ); src/GML/R0011503.pli (READ); src/GML/R0011603.pli (READ); src/GML/R0011703.pli (READ); src/GML/R0011903.pli (READ); src/GML/R0012004.pli (READ); src/GML/R001N503.pli (READ); src/GML/R001N603.pli (READ); src/GML/R001N803.pli (READ); src/GML/R001N903.pli (READ); src/GML/R001NB03.pli (READ); src/GML/R001NC03.pli (READ); src/GML/R001NO10.pli (READ); src/GML/R001TK07.pli (READ,REWRITE,WRITE); src/GML/R001U603.pli (READ); src/GML/R001U803.pli (READ); src/GML/R001UC03.pli (READ); src/GML/R001UE03.pli (READ); src/GML/R001UJ03.pli (READ); src/R0010202.pli (UNLOCK); src/R0010422.pli (READ,READPREV,STARTBR); src/R0010430.pli (READ); src/R0010503.pli (READ); src/R0010603.pli (READ); src/R0010803.pli (READ); src/R0011003.pli (READ); src/R0011103.pli (READ); src/R0011203.pli (READ); src/R0011303.pli (READ); src/R0011403.pli (READ); src/R0011503.pli (READ); src/R0011603.pli (READ); src/R0011703.pli (READ); src/R0011903.pli (READ); src/R0019A02.pli (READ); src/R001N503.pli (READ); src/R001N603.pli (READ); src/R001N803.pli (READ); src/R001N903.pli (READ); src/R001NB03.pli (READ); src/R001NC03.pli (READ); src/R001NO10.pli (READ); src/R001TK07.pli (READ,REWRITE,WRITE); src/R001U603.pli (READ); src/R001U803.pli (READ); src/R001UC03.pli (READ); src/R001UE03.pli (READ); src/R001UJ03.pli (READ).
 */
@Repository
public interface TkReclRepository extends JpaRepository<TkRecl, String> {

    // TODO: STARTBR / READNEXT / READPREV browse the key, which is not one field (TODO: no key is known (no IDCAMS DEFINE, RIDFLD or RECORD KEY): carried as the String vsamKey).

}