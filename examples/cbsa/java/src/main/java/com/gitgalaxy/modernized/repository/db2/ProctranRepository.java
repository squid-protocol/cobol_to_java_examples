package com.gitgalaxy.modernized.repository.db2;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DB2 table PROCTRAN: the embedded SQL of CREACC, CRECUST, DBCRFUN, DELACC, DELCUS, XFRFUN, one method per statement, as written.
 * Each returns what JDBC returns; mapping onto business types is the service's job.
 * Columns: com.gitgalaxy.modernized.dto.db2.ProctranRow.
 * TODO: this SQL is DB2's; the configured database is postgresql -- review each statement.
 */
@Repository
public class ProctranRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public ProctranRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /** EXEC SQL INSERT at src/base/cobol_src/CREACC.cbl:969 (CREACC, insert access).
     *  Parameters: hvProctranAccNumber = :HV-PROCTRAN-ACC-NUMBER, hvProctranAmount = :HV-PROCTRAN-AMOUNT, hvProctranDate = :HV-PROCTRAN-DATE, hvProctranDesc = :HV-PROCTRAN-DESC, hvProctranEyecatcher = :HV-PROCTRAN-EYECATCHER, hvProctranRef = :HV-PROCTRAN-REF, hvProctranSortCode = :HV-PROCTRAN-SORT-CODE, hvProctranTime = :HV-PROCTRAN-TIME, hvProctranType = :HV-PROCTRAN-TYPE.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int insertL969Creacc(Map<String, ?> params) {
        return jdbc.update("""
            INSERT INTO PROCTRAN ( PROCTRAN_EYECATCHER, PROCTRAN_SORTCODE, PROCTRAN_NUMBER, PROCTRAN_DATE, PROCTRAN_TIME, PROCTRAN_REF, PROCTRAN_TYPE, PROCTRAN_DESC, PROCTRAN_AMOUNT ) VALUES ( :hvProctranEyecatcher, :hvProctranSortCode, :hvProctranAccNumber, :hvProctranDate, :hvProctranTime, :hvProctranRef, :hvProctranType, :hvProctranDesc, :hvProctranAmount )
            """, params);
    }

    /** EXEC SQL INSERT at src/base/cobol_src/CRECUST.cbl:1168 (CRECUST, insert access).
     *  Parameters: hvProctranAccNumber = :HV-PROCTRAN-ACC-NUMBER, hvProctranAmount = :HV-PROCTRAN-AMOUNT, hvProctranDate = :HV-PROCTRAN-DATE, hvProctranDesc = :HV-PROCTRAN-DESC, hvProctranEyecatcher = :HV-PROCTRAN-EYECATCHER, hvProctranRef = :HV-PROCTRAN-REF, hvProctranSortCode = :HV-PROCTRAN-SORT-CODE, hvProctranTime = :HV-PROCTRAN-TIME, hvProctranType = :HV-PROCTRAN-TYPE.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int insertL1168Crecust(Map<String, ?> params) {
        return jdbc.update("""
            INSERT INTO PROCTRAN ( PROCTRAN_EYECATCHER, PROCTRAN_SORTCODE, PROCTRAN_NUMBER, PROCTRAN_DATE, PROCTRAN_TIME, PROCTRAN_REF, PROCTRAN_TYPE, PROCTRAN_DESC, PROCTRAN_AMOUNT ) VALUES ( :hvProctranEyecatcher, :hvProctranSortCode, :hvProctranAccNumber, :hvProctranDate, :hvProctranTime, :hvProctranRef, :hvProctranType, :hvProctranDesc, :hvProctranAmount )
            """, params);
    }

    /** EXEC SQL INSERT at src/base/cobol_src/DBCRFUN.cbl:524 (DBCRFUN, insert access).
     *  Parameters: hvProctranAccNumber = :HV-PROCTRAN-ACC-NUMBER, hvProctranAmount = :HV-PROCTRAN-AMOUNT, hvProctranDate = :HV-PROCTRAN-DATE, hvProctranDesc = :HV-PROCTRAN-DESC, hvProctranEyecatcher = :HV-PROCTRAN-EYECATCHER, hvProctranRef = :HV-PROCTRAN-REF, hvProctranSortCode = :HV-PROCTRAN-SORT-CODE, hvProctranTime = :HV-PROCTRAN-TIME, hvProctranType = :HV-PROCTRAN-TYPE.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int insertL524Dbcrfun(Map<String, ?> params) {
        return jdbc.update("""
            INSERT INTO PROCTRAN ( PROCTRAN_EYECATCHER, PROCTRAN_SORTCODE, PROCTRAN_NUMBER, PROCTRAN_DATE, PROCTRAN_TIME, PROCTRAN_REF, PROCTRAN_TYPE, PROCTRAN_DESC, PROCTRAN_AMOUNT ) VALUES ( :hvProctranEyecatcher, :hvProctranSortCode, :hvProctranAccNumber, :hvProctranDate, :hvProctranTime, :hvProctranRef, :hvProctranType, :hvProctranDesc, :hvProctranAmount )
            """, params);
    }

    /** EXEC SQL INSERT at src/base/cobol_src/DELACC.cbl:521 (DELACC, insert access).
     *  Parameters: hvProctranAccNumber = :HV-PROCTRAN-ACC-NUMBER, hvProctranAmount = :HV-PROCTRAN-AMOUNT, hvProctranDate = :HV-PROCTRAN-DATE, hvProctranDesc = :HV-PROCTRAN-DESC, hvProctranEyecatcher = :HV-PROCTRAN-EYECATCHER, hvProctranRef = :HV-PROCTRAN-REF, hvProctranSortCode = :HV-PROCTRAN-SORT-CODE, hvProctranTime = :HV-PROCTRAN-TIME, hvProctranType = :HV-PROCTRAN-TYPE.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int insertL521Delacc(Map<String, ?> params) {
        return jdbc.update("""
            INSERT INTO PROCTRAN ( PROCTRAN_EYECATCHER, PROCTRAN_SORTCODE, PROCTRAN_NUMBER, PROCTRAN_DATE, PROCTRAN_TIME, PROCTRAN_REF, PROCTRAN_TYPE, PROCTRAN_DESC, PROCTRAN_AMOUNT ) VALUES ( :hvProctranEyecatcher, :hvProctranSortCode, :hvProctranAccNumber, :hvProctranDate, :hvProctranTime, :hvProctranRef, :hvProctranType, :hvProctranDesc, :hvProctranAmount )
            """, params);
    }

    /** EXEC SQL INSERT at src/base/cobol_src/DELCUS.cbl:636 (DELCUS, insert access).
     *  Parameters: hvProctranAccNumber = :HV-PROCTRAN-ACC-NUMBER, hvProctranAmount = :HV-PROCTRAN-AMOUNT, hvProctranDate = :HV-PROCTRAN-DATE, hvProctranDesc = :HV-PROCTRAN-DESC, hvProctranEyecatcher = :HV-PROCTRAN-EYECATCHER, hvProctranRef = :HV-PROCTRAN-REF, hvProctranSortCode = :HV-PROCTRAN-SORT-CODE, hvProctranTime = :HV-PROCTRAN-TIME, hvProctranType = :HV-PROCTRAN-TYPE.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int insertL636Delcus(Map<String, ?> params) {
        return jdbc.update("""
            INSERT INTO PROCTRAN ( PROCTRAN_EYECATCHER, PROCTRAN_SORTCODE, PROCTRAN_NUMBER, PROCTRAN_DATE, PROCTRAN_TIME, PROCTRAN_REF, PROCTRAN_TYPE, PROCTRAN_DESC, PROCTRAN_AMOUNT ) VALUES ( :hvProctranEyecatcher, :hvProctranSortCode, :hvProctranAccNumber, :hvProctranDate, :hvProctranTime, :hvProctranRef, :hvProctranType, :hvProctranDesc, :hvProctranAmount )
            """, params);
    }

    /** EXEC SQL INSERT at src/base/cobol_src/XFRFUN.cbl:1616 (XFRFUN, insert access).
     *  Parameters: hvProctranAccNumber = :HV-PROCTRAN-ACC-NUMBER, hvProctranAmount = :HV-PROCTRAN-AMOUNT, hvProctranDate = :HV-PROCTRAN-DATE, hvProctranDesc = :HV-PROCTRAN-DESC, hvProctranEyecatcher = :HV-PROCTRAN-EYECATCHER, hvProctranRef = :HV-PROCTRAN-REF, hvProctranSortCode = :HV-PROCTRAN-SORT-CODE, hvProctranTime = :HV-PROCTRAN-TIME, hvProctranType = :HV-PROCTRAN-TYPE.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int insertL1616Xfrfun(Map<String, ?> params) {
        return jdbc.update("""
            INSERT INTO PROCTRAN ( PROCTRAN_EYECATCHER, PROCTRAN_SORTCODE, PROCTRAN_NUMBER, PROCTRAN_DATE, PROCTRAN_TIME, PROCTRAN_REF, PROCTRAN_TYPE, PROCTRAN_DESC, PROCTRAN_AMOUNT ) VALUES ( :hvProctranEyecatcher, :hvProctranSortCode, :hvProctranAccNumber, :hvProctranDate, :hvProctranTime, :hvProctranRef, :hvProctranType, :hvProctranDesc, :hvProctranAmount )
            """, params);
    }

}