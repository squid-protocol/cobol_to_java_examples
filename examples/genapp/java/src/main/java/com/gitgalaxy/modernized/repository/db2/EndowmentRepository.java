package com.gitgalaxy.modernized.repository.db2;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DB2 table ENDOWMENT: the embedded SQL of LGAPDB01, LGIPDB01, LGUPDB01, one method per statement, as written.
 * Each returns what JDBC returns; mapping onto business types is the service's job.
 * TODO: this SQL is DB2's; the configured database is postgresql -- review each statement.
 */
@Repository
public class EndowmentRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public EndowmentRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /** EXEC SQL INSERT at base/src/lgapdb01.cbl:346 (LGAPDB01, insert access).
     *  Parameters: caEEquities = :CA-E-EQUITIES, caEFundName = :CA-E-FUND-NAME, caELifeAssured = :CA-E-LIFE-ASSURED, caEManagedFund = :CA-E-MANAGED-FUND, caEWithProfits = :CA-E-WITH-PROFITS, db2ESumassuredInt = :DB2-E-SUMASSURED-INT, db2ETermSint = :DB2-E-TERM-SINT, db2PolicynumInt = :DB2-POLICYNUM-INT, wsVaryField = :WS-VARY-FIELD.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int insertL346Lgapdb01(Map<String, ?> params) {
        return jdbc.update("""
            INSERT INTO ENDOWMENT ( POLICYNUMBER, WITHPROFITS, EQUITIES, MANAGEDFUND, FUNDNAME, TERM, SUMASSURED, LIFEASSURED, PADDINGDATA ) VALUES ( :db2PolicynumInt, :caEWithProfits, :caEEquities, :caEManagedFund, :caEFundName, :db2ETermSint, :db2ESumassuredInt, :caELifeAssured, :wsVaryField )
            """, params);
    }

    /** EXEC SQL INSERT at base/src/lgapdb01.cbl:368 (LGAPDB01, insert access).
     *  Parameters: caEEquities = :CA-E-EQUITIES, caEFundName = :CA-E-FUND-NAME, caELifeAssured = :CA-E-LIFE-ASSURED, caEManagedFund = :CA-E-MANAGED-FUND, caEWithProfits = :CA-E-WITH-PROFITS, db2ESumassuredInt = :DB2-E-SUMASSURED-INT, db2ETermSint = :DB2-E-TERM-SINT, db2PolicynumInt = :DB2-POLICYNUM-INT.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int insertL368Lgapdb01(Map<String, ?> params) {
        return jdbc.update("""
            INSERT INTO ENDOWMENT ( POLICYNUMBER, WITHPROFITS, EQUITIES, MANAGEDFUND, FUNDNAME, TERM, SUMASSURED, LIFEASSURED ) VALUES ( :db2PolicynumInt, :caEWithProfits, :caEEquities, :caEManagedFund, :caEFundName, :db2ETermSint, :db2ESumassuredInt, :caELifeAssured )
            """, params);
    }

    /** EXEC SQL SELECT at base/src/lgipdb01.cbl:330 (LGIPDB01, read access).
     *  Parameters: db2CustomernumInt = :DB2-CUSTOMERNUM-INT, db2PolicynumInt = :DB2-POLICYNUM-INT.
     *  The INTO host variables are the columns of the returned row.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public Map<String, Object> selectL330Lgipdb01(Map<String, ?> params) {
        return jdbc.queryForMap("""
            SELECT ISSUEDATE, EXPIRYDATE, LASTCHANGED, BROKERID, BROKERSREFERENCE, PAYMENT, WITHPROFITS, EQUITIES, MANAGEDFUND, FUNDNAME, TERM, SUMASSURED, LIFEASSURED, PADDINGDATA, LENGTH(PADDINGDATA) FROM POLICY,ENDOWMENT WHERE ( POLICY.POLICYNUMBER = ENDOWMENT.POLICYNUMBER AND POLICY.CUSTOMERNUMBER = :db2CustomernumInt AND POLICY.POLICYNUMBER = :db2PolicynumInt )
            """, params);
    }

    /** EXEC SQL UPDATE at base/src/lgupdb01.cbl:394 (LGUPDB01, update access).
     *  Parameters: caEEquities = :CA-E-EQUITIES, caEFundName = :CA-E-FUND-NAME, caELifeAssured = :CA-E-LIFE-ASSURED, caEManagedFund = :CA-E-MANAGED-FUND, caEWithProfits = :CA-E-WITH-PROFITS, db2ESumassuredInt = :DB2-E-SUMASSURED-INT, db2ETermSint = :DB2-E-TERM-SINT, db2PolicynumInt = :DB2-POLICYNUM-INT.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int updateL394Lgupdb01(Map<String, ?> params) {
        return jdbc.update("""
            UPDATE ENDOWMENT SET WITHPROFITS = :caEWithProfits, EQUITIES = :caEEquities, MANAGEDFUND = :caEManagedFund, FUNDNAME = :caEFundName, TERM = :db2ETermSint, SUMASSURED = :db2ESumassuredInt, LIFEASSURED = :caELifeAssured WHERE POLICYNUMBER = :db2PolicynumInt
            """, params);
    }

}