package com.gitgalaxy.modernized.repository.db2;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DB2 table HOUSE: the embedded SQL of LGAPDB01, LGIPDB01, LGUPDB01, one method per statement, as written.
 * Each returns what JDBC returns; mapping onto business types is the service's job.
 * TODO: this SQL is DB2's; the configured database is postgresql -- review each statement.
 */
@Repository
public class HouseRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public HouseRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /** EXEC SQL INSERT at base/src/lgapdb01.cbl:409 (LGAPDB01, insert access).
     *  Parameters: caHHouseName = :CA-H-HOUSE-NAME, caHHouseNumber = :CA-H-HOUSE-NUMBER, caHPostcode = :CA-H-POSTCODE, caHPropertyType = :CA-H-PROPERTY-TYPE, db2HBedroomsSint = :DB2-H-BEDROOMS-SINT, db2HValueInt = :DB2-H-VALUE-INT, db2PolicynumInt = :DB2-POLICYNUM-INT.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int insertL409Lgapdb01(Map<String, ?> params) {
        return jdbc.update("""
            INSERT INTO HOUSE ( POLICYNUMBER, PROPERTYTYPE, BEDROOMS, VALUE, HOUSENAME, HOUSENUMBER, POSTCODE ) VALUES ( :db2PolicynumInt, :caHPropertyType, :db2HBedroomsSint, :db2HValueInt, :caHHouseName, :caHHouseNumber, :caHPostcode )
            """, params);
    }

    /** EXEC SQL SELECT at base/src/lgipdb01.cbl:444 (LGIPDB01, read access).
     *  Parameters: db2CustomernumInt = :DB2-CUSTOMERNUM-INT, db2PolicynumInt = :DB2-POLICYNUM-INT.
     *  The INTO host variables are the columns of the returned row.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public Map<String, Object> selectL444Lgipdb01(Map<String, ?> params) {
        return jdbc.queryForMap("""
            SELECT ISSUEDATE, EXPIRYDATE, LASTCHANGED, BROKERID, BROKERSREFERENCE, PAYMENT, PROPERTYTYPE, BEDROOMS, VALUE, HOUSENAME, HOUSENUMBER, POSTCODE FROM POLICY,HOUSE WHERE ( POLICY.POLICYNUMBER = HOUSE.POLICYNUMBER AND POLICY.CUSTOMERNUMBER = :db2CustomernumInt AND POLICY.POLICYNUMBER = :db2PolicynumInt )
            """, params);
    }

    /** EXEC SQL UPDATE at base/src/lgupdb01.cbl:431 (LGUPDB01, update access).
     *  Parameters: caHHouseName = :CA-H-HOUSE-NAME, caHHouseNumber = :CA-H-HOUSE-NUMBER, caHPostcode = :CA-H-POSTCODE, caHPropertyType = :CA-H-PROPERTY-TYPE, db2HBedroomsSint = :DB2-H-BEDROOMS-SINT, db2HValueInt = :DB2-H-VALUE-INT, db2PolicynumInt = :DB2-POLICYNUM-INT.
     *  DB2 table access field testing: open (3 public / 0 private estates). */
    public int updateL431Lgupdb01(Map<String, ?> params) {
        return jdbc.update("""
            UPDATE HOUSE SET PROPERTYTYPE = :caHPropertyType, BEDROOMS = :db2HBedroomsSint, VALUE = :db2HValueInt, HOUSENAME = :caHHouseName, HOUSENUMBER = :caHHouseNumber, POSTCODE = :caHPostcode WHERE POLICYNUMBER = :db2PolicynumInt
            """, params);
    }

}