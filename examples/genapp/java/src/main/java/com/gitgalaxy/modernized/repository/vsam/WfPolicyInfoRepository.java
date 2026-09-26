package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.WfPolicyInfo;
import com.gitgalaxy.modernized.entity.vsam.WfPolicyInfoKey;

/**
 * <USRHLQ>.GENAPP.KSDSPOLY: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by base/src/lgapvs01.cbl (WRITE); base/src/lgdpvs01.cbl (DELETE); base/src/lgipvs01.cbl (READ); base/src/lgupvs01.cbl (READ,REWRITE).
 */
@Repository
public interface WfPolicyInfoRepository extends JpaRepository<WfPolicyInfo, WfPolicyInfoKey> {

}