package com.gitgalaxy.modernized.repository.db2;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DB2 table MOTOR: the embedded SQL of LGAPDB01, LGIPDB01, LGUPDB01, one method per statement, as written.
 * Each returns what JDBC returns; mapping onto business types is the service's job.
 * TODO: this SQL is DB2's; the configured database is postgresql -- review each statement.
 */
@Repository
public class MotorRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public MotorRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /** EXEC SQL INSERT at base/src/lgapdb01.cbl:449 (LGAPDB01, insert access).
     *  Parameters: caMColour = :CA-M-COLOUR, caMMake = :CA-M-MAKE, caMManufactured = :CA-M-MANUFACTURED, caMModel = :CA-M-MODEL, caMRegnumber = :CA-M-REGNUMBER, db2MAccidentsInt = :DB2-M-ACCIDENTS-INT, db2MCcSint = :DB2-M-CC-SINT, db2MPremiumInt = :DB2-M-PREMIUM-INT, db2MValueInt = :DB2-M-VALUE-INT, db2PolicynumInt = :DB2-POLICYNUM-INT.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int insertL449Lgapdb01(Map<String, ?> params) {
        return jdbc.update("""
            INSERT INTO MOTOR ( POLICYNUMBER, MAKE, MODEL, VALUE, REGNUMBER, COLOUR, CC, YEAROFMANUFACTURE, PREMIUM, ACCIDENTS ) VALUES ( :db2PolicynumInt, :caMMake, :caMModel, :db2MValueInt, :caMRegnumber, :caMColour, :db2MCcSint, :caMManufactured, :db2MPremiumInt, :db2MAccidentsInt )
            """, params);
    }

    /** EXEC SQL SELECT at base/src/lgipdb01.cbl:532 (LGIPDB01, read access).
     *  Parameters: db2CustomernumInt = :DB2-CUSTOMERNUM-INT, db2PolicynumInt = :DB2-POLICYNUM-INT.
     *  The INTO host variables are the columns of the returned row.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public Map<String, Object> selectL532Lgipdb01(Map<String, ?> params) {
        return jdbc.queryForMap("""
            SELECT ISSUEDATE, EXPIRYDATE, LASTCHANGED, BROKERID, BROKERSREFERENCE, PAYMENT, MAKE, MODEL, VALUE, REGNUMBER, COLOUR, CC, YEAROFMANUFACTURE, PREMIUM, ACCIDENTS FROM POLICY,MOTOR WHERE ( POLICY.POLICYNUMBER = MOTOR.POLICYNUMBER AND POLICY.CUSTOMERNUMBER = :db2CustomernumInt AND POLICY.POLICYNUMBER = :db2PolicynumInt )
            """, params);
    }

    /** EXEC SQL UPDATE at base/src/lgupdb01.cbl:469 (LGUPDB01, update access).
     *  Parameters: caMColour = :CA-M-COLOUR, caMMake = :CA-M-MAKE, caMManufactured = :CA-M-MANUFACTURED, caMModel = :CA-M-MODEL, caMRegnumber = :CA-M-REGNUMBER, db2MAccidentsInt = :DB2-M-ACCIDENTS-INT, db2MCcSint = :DB2-M-CC-SINT, db2MPremiumInt = :DB2-M-PREMIUM-INT, db2MValueInt = :DB2-M-VALUE-INT, db2PolicynumInt = :DB2-POLICYNUM-INT.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int updateL469Lgupdb01(Map<String, ?> params) {
        return jdbc.update("""
            UPDATE MOTOR SET MAKE = :caMMake, MODEL = :caMModel, VALUE = :db2MValueInt, REGNUMBER = :caMRegnumber, COLOUR = :caMColour, CC = :db2MCcSint, YEAROFMANUFACTURE = :caMManufactured, PREMIUM = :db2MPremiumInt, ACCIDENTS = :db2MAccidentsInt WHERE POLICYNUMBER = :db2PolicynumInt
            """, params);
    }

}