package com.gitgalaxy.modernized.repository.vsam;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.gitgalaxy.modernized.entity.vsam.ExportInputRecord;

/**
 * AWS.M2.CARDDEMO.EXPORT.DATA: READ / WRITE / REWRITE / DELETE are JpaRepository's
 * findById / save / deleteById. Used by app/cbl/CBEXPORT.cbl (OUTPUT); app/cbl/CBIMPORT.cbl (INPUT).
 */
@Repository
public interface ExportInputRecordRepository extends JpaRepository<ExportInputRecord, String> {

}