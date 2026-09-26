package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy), 160 bytes, from GitGalaxy's verified skeleton.
 * Bytes 0-159 of the COMMAREA Coactupc reads: MOVE DFHCOMMAREA(1:LENGTH OF CARDDEMO-COMMAREA) at app/cbl/COACTUPC.cbl:888.
 * Bytes 0-159 of the COMMAREA Coactvwc reads: MOVE DFHCOMMAREA(1:LENGTH OF CARDDEMO-COMMAREA) at app/cbl/COACTVWC.cbl:288.
 * Bytes 0-159 of the COMMAREA Coadm01c reads: MOVE DFHCOMMAREA(1:EIBCALEN) at app/cbl/COADM01C.cbl:90.
 * Bytes 0-159 of the COMMAREA Cocrdlic reads: MOVE DFHCOMMAREA(1:LENGTH OF CARDDEMO-COMMAREA) at app/cbl/COCRDLIC.cbl:327.
 * Bytes 0-159 of the COMMAREA Cocrdslc reads: MOVE DFHCOMMAREA(1:LENGTH OF CARDDEMO-COMMAREA) at app/cbl/COCRDSLC.cbl:274.
 * Bytes 0-159 of the COMMAREA Cocrdupc reads: MOVE DFHCOMMAREA(1:LENGTH OF CARDDEMO-COMMAREA) at app/cbl/COCRDUPC.cbl:396.
 * Bytes 0-159 of the COMMAREA Comen01c reads: MOVE DFHCOMMAREA(1:EIBCALEN) at app/cbl/COMEN01C.cbl:86.
 * Bytes 0-159 of the COMMAREA Copaus0c reads: MOVE DFHCOMMAREA(1:EIBCALEN) at app/app-authorization-ims-db2-mq/cbl/COPAUS0C.cbl:200.
 * Bytes 0-159 of the COMMAREA Corpt00c reads: MOVE DFHCOMMAREA(1:EIBCALEN) at app/cbl/CORPT00C.cbl:176.
 * Bytes 0-159 of the COMMAREA Cotrn02c reads: MOVE DFHCOMMAREA(1:EIBCALEN) at app/cbl/COTRN02C.cbl:119.
 * Bytes 0-159 of the COMMAREA Cotrtlic reads: MOVE DFHCOMMAREA(1:LENGTH OF CARDDEMO-COMMAREA) at app/app-transaction-type-db2/cbl/COTRTLIC.cbl:527.
 * Bytes 0-159 of the COMMAREA Cotrtupc reads: MOVE DFHCOMMAREA(1:LENGTH OF CARDDEMO-COMMAREA) at app/app-transaction-type-db2/cbl/COTRTUPC.cbl:376.
 * Bytes 0-159 of the COMMAREA Cousr01c reads: MOVE DFHCOMMAREA(1:EIBCALEN) at app/cbl/COUSR01C.cbl:82.
 * Bytes 0-159 of the COMMAREA Cousr02c reads: MOVE DFHCOMMAREA(1:EIBCALEN) at app/cbl/COUSR02C.cbl:94.
 * Bytes 0-159 of the COMMAREA Cousr03c reads: MOVE DFHCOMMAREA(1:EIBCALEN) at app/cbl/COUSR03C.cbl:94.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CarddemoCommarea {

    // CDEMO-FROM-TRANID: PIC X(04), offset 0, 4 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoFromTranid;

    // CDEMO-FROM-PROGRAM: PIC X(08), offset 4, 8 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoFromProgram;

    // CDEMO-TO-TRANID: PIC X(04), offset 12, 4 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoToTranid;

    // CDEMO-TO-PROGRAM: PIC X(08), offset 16, 8 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoToProgram;

    // CDEMO-USER-ID: PIC X(08), offset 24, 8 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoUserId;

    // CDEMO-USER-TYPE: PIC X(01), offset 32, 1 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoUserType;

    // CDEMO-PGM-CONTEXT: PIC 9(01), offset 33, 1 bytes (app/cpy/COCOM01Y.cpy)
    private Integer cdemoPgmContext;

    // CDEMO-CUST-ID: PIC 9(09), offset 34, 9 bytes (app/cpy/COCOM01Y.cpy)
    private Integer cdemoCustId;

    // CDEMO-CUST-FNAME: PIC X(25), offset 43, 25 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoCustFname;

    // CDEMO-CUST-MNAME: PIC X(25), offset 68, 25 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoCustMname;

    // CDEMO-CUST-LNAME: PIC X(25), offset 93, 25 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoCustLname;

    // CDEMO-ACCT-ID: PIC 9(11), offset 118, 11 bytes (app/cpy/COCOM01Y.cpy)
    private Long cdemoAcctId;

    // CDEMO-ACCT-STATUS: PIC X(01), offset 129, 1 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoAcctStatus;

    // CDEMO-CARD-NUM: PIC 9(16), offset 130, 16 bytes (app/cpy/COCOM01Y.cpy)
    private Long cdemoCardNum;

    // CDEMO-LAST-MAP: PIC X(7), offset 146, 7 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoLastMap;

    // CDEMO-LAST-MAPSET: PIC X(7), offset 153, 7 bytes (app/cpy/COCOM01Y.cpy)
    private String cdemoLastMapset;

}