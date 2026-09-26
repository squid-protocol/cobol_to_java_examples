package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.InntRapp;

/**
 * INBRUDD: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by src/GML/R001I903.pli (WRITE); src/GML/R001I904.pli (ENDBR,READ,READNEXT,READPREV,RESETBR,REWRITE,STARTBR,UNLOCK); src/R001I903.pli (WRITE); src/R001I904.pli (ENDBR,READ,READNEXT,READPREV,RESETBR,REWRITE,STARTBR,UNLOCK).
 */
@Repository
public interface InntRappRepository extends JpaRepository<InntRapp, String> {

    /** EXEC CICS STARTBR + READNEXT: records from a key onward, in key order. */
    List<InntRapp> findByInntRappGreaterThanEqualOrderByInntRappAsc(String inntRapp, Pageable page);

    /** EXEC CICS READPREV: records from a key backward, in reverse key order. */
    List<InntRapp> findByInntRappLessThanEqualOrderByInntRappDesc(String inntRapp, Pageable page);

}