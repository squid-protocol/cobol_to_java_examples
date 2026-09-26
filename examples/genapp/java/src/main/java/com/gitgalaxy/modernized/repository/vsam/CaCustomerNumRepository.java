package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.CaCustomerNum;

/**
 * <USRHLQ>.GENAPP.KSDSCUST: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by base/src/lgacvs01.cbl (WRITE); base/src/lgicvs01.cbl (READ); base/src/lgucvs01.cbl (READ,REWRITE).
 */
@Repository
public interface CaCustomerNumRepository extends JpaRepository<CaCustomerNum, Long> {

}