package com.gitgalaxy.modernized.repository.db2;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DB2 table CUSTOMER_SECURE: the embedded SQL of LGACDB02, one method per statement, as written.
 * Each returns what JDBC returns; mapping onto business types is the service's job.
 * TODO: this SQL is DB2's; the configured database is postgresql -- review each statement.
 */
@Repository
public class CustomerSecureRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public CustomerSecureRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /** EXEC SQL INSERT at base/src/lgacdb02.cbl:166 (LGACDB02, insert access).
     *  Parameters: d2CustsecrPass = :D2-CUSTSECR-PASS, d2CustsecrState = :D2-CUSTSECR-STATE, db2CustomercntInt = :DB2-CUSTOMERCNT-INT, db2CustomernumInt = :DB2-CUSTOMERNUM-INT.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int insertL166Lgacdb02(Map<String, ?> params) {
        return jdbc.update("""
            INSERT INTO CUSTOMER_SECURE ( customerNumber, customerPass, state_indicator, pass_changes ) VALUES ( :db2CustomernumInt, :d2CustsecrPass, :d2CustsecrState, :db2CustomercntInt)
            """, params);
    }

}