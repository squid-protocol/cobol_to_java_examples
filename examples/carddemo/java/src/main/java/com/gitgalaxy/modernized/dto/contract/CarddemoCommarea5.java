package com.gitgalaxy.modernized.dto.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * COBOL record CARDDEMO-COMMAREA (app/cpy/COCOM01Y.cpy), 218 bytes, from GitGalaxy's verified skeleton.
 * Bytes 0-217 of the COMMAREA Cotrn01c reads: MOVE DFHCOMMAREA(1:EIBCALEN) at app/cbl/COTRN01C.cbl:98.
 * Record fields field testing: field-tested (6 public / 0 private estates).
 */
@Data
@NoArgsConstructor
public class CarddemoCommarea5 {

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

    // CDEMO-CT01-TRNID-FIRST: PIC X(16), offset 160, 16 bytes (app/cbl/COTRN01C.cbl)
    private String cdemoCt01TrnidFirst;

    // CDEMO-CT01-TRNID-LAST: PIC X(16), offset 176, 16 bytes (app/cbl/COTRN01C.cbl)
    private String cdemoCt01TrnidLast;

    // CDEMO-CT01-PAGE-NUM: PIC 9(08), offset 192, 8 bytes (app/cbl/COTRN01C.cbl)
    private Integer cdemoCt01PageNum;

    // CDEMO-CT01-NEXT-PAGE-FLG: PIC X(01), offset 200, 1 bytes (app/cbl/COTRN01C.cbl)
    private String cdemoCt01NextPageFlg;

    // CDEMO-CT01-TRN-SEL-FLG: PIC X(01), offset 201, 1 bytes (app/cbl/COTRN01C.cbl)
    private String cdemoCt01TrnSelFlg;

    // CDEMO-CT01-TRN-SELECTED: PIC X(16), offset 202, 16 bytes (app/cbl/COTRN01C.cbl)
    private String cdemoCt01TrnSelected;

}