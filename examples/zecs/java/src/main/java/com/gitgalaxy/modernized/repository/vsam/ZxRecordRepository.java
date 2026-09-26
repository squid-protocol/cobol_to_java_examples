package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.ZxRecord;

/**
 * @ECS_HLQ@.ZCEXPIRE.@ENVIRONMENT@: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by Source/ZECS000.cbl (READ,REWRITE,WRITE).
 */
@Repository
public interface ZxRecordRepository extends JpaRepository<ZxRecord, String> {

}