/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app308.constant;

/**
 *
 * @author patria
 */
public class Sfc308Constant {

    public static final String Lov_Storage_Loc = "SELECT VITEMCODE , VITEMDESC , VITEMNAME , VPLANTDESC\n"
            + "From Ahmmoerp_Dtlsettings d, ahmmomsc_mstplants p\n"
            + "Where Rset_Vid = 'MSTSLOCPACKINGENG'\n"
            + "and BVALID = 'T'\n"
            + "and p.vplantid = d.VITEMNAME\n"
            + "and (UPPER(VITEMCODE) LIKE '%'||UPPER(:VPARAM)||'%'\n"
            + "             OR UPPER(VITEMDESC) LIKE '%'||UPPER(:VPARAM)||'%'"
            + "             OR UPPER(VITEMNAME) LIKE '%'||UPPER(:VPARAM)||'%'"
            + "             OR UPPER(VPLANTDESC) LIKE '%'||UPPER(:VPARAM)||'%')";

    public static final String Lov_Wct_Id = "SELECT VWCTID, VWCTDESC\n"
            + "FROM AHMMOMSC_MSTWCTS\n"
            + "WHERE MPLANT_VPLANTID = :VPLANT\n"
            + "AND TRUNC(SYSDATE) BETWEEN TRUNC(DBEGINEFF) AND TRUNC(DENDEFF)\n"
            + "AND (UPPER(VWCTID) LIKE '%'||UPPER(:VPARAM)||'%'\n"
            + "            OR UPPER(VWCTDESC) LIKE '%'||UPPER(:VPARAM)||'%')";

    public static final String Lov_Customer = "SELECT ID_CSAREA, CSAREA\n"
            + "FROM FMMKT_UN00_CSAREAS\n"
            + "WHERE (UPPER(ID_CSAREA) LIKE '%'||UPPER(:VPARAM)||'%'\n"
            + "            OR UPPER(CSAREA) LIKE '%'||UPPER(:VPARAM)||'%')";

    public static final String Get_Do = "SELECT DISTINCT H.VSIPBNO DO_NO, D.VTYPE TYPM_MC_TYPE, NVL(D.IQTY,0) - NVL(D.IQTYSHIP,0) QTY, D.VPARTNO, D.VCOL\n"
            + "FROM AHMSDMUS_HDRSIPBS H, AHMSDMUS_DTLSIPBS D\n"
            + "WHERE H.VSIPBNO = D.VSIPBNO\n"
            + "AND H.VCODE = 'O'\n"
            + "AND H.VYEAR = TO_CHAR(sysdate,'YYYY')\n"
            + "AND H.VSTATUS = 'O'\n"
            + "AND H.VPLNT = :VPLANT\n"
            + "AND H.VCSAREA = :VCUST\n"
            + "AND NVL(D.IQTY,0) - NVL(D.IQTYSHIP,0) > 0\n"
            + "ORDER BY DO_NO ASC";

    public static final String Check_Case_Id = "SELECT DISTINCT RCASE_VCASEID\n"
            + "FROM AHMMOMST_TXNSCANFEIS\n"
            + "WHERE MXCODE_VITEMCODE = 'AFTER PACKING' \n"
            + "  AND RCASE_VCASEID NOT IN (SELECT VCASEID FROM AHMMOMST_DTLSHPFEDS WHERE VCASEID IS NOT NULL) \n"
            + "  AND ((:PARTNO IS NOT NULL AND MPART_VPARTNUM = :PARTNO) \n"
            + "    OR (:PARTNO IS NULL AND MPART_VPARTNUM LIKE '%' \n"
            + "        AND MENG_VENGNO IN (SELECT VENGNO\n"
            + "          FROM AHMMOSFC_MSTENGINES WHERE DSET_VITEMCODE_DSTENG = '7')))\n"
            + "  AND RCASE_VCASEID = :CASEID";

    public static final String Sum_Case_Id = "SELECT SUM(NQTY)\n"
            + "FROM AHMMOSFC_DTLCASES\n"
            + "WHERE RCASE_VCASEID = :CASEID \n";

    public static final String Get_Engine = "SELECT DISTINCT MENG_VENGNO\n"
            + "FROM AHMMOMST_TXNSCANFEIS\n"
            + "WHERE mxcode_rset_vid = 'MSTCATSHPFEI' AND mxcode_vitemcode = 'AFTER PACKING' AND rtype_vmctypeid = :TYPE AND rcase_vcaseid = :CASEID\n"
            + "AND meng_vengno IN \n"
            + "(SELECT vengno\n"
            + "FROM ahmmosfc_mstengines\n"
            + "WHERE DSET_VITEMCODE_DSTENG = '7')";

    public static final String Get_Data_Engine = "SELECT DSET_VITEMCODE_DSTENG, D.VITEMNAME, RTYPE_VMCTYPEID, MSTOR_MPLANT_VPLANTID\n"
            + "FROM AHMMOSFC_MSTENGINES E, AHMMOERP_DTLSETTINGS D\n"
            + "WHERE VENGNO = :ENGINE\n"
            + "AND D.BVALID = 'T'\n"
            + "AND D.RSET_VID = E.DSET_RSET_VID_DSTENG\n"
            + "AND D.VITEMCODE = E.DSET_VITEMCODE_DSTENG";

    public static final String Get_List_Part = "SELECT DISTINCT D.MPART_VPARTNUM,\n"
            + "  NVL(D.MENG_VENGNO, '-') MENG_VENGNO,\n"
            + "  D.NQTY,\n"
            + "  D.NSEQ,\n"
            + "  X.RTYPE_VMCTYPEID,\n"
            + "  X.DSET_RSET_VID_CASEPOS,\n"
            + "  X.DSET_VITEMCODE_CASEPOS\n"
            + "FROM AHMMOSFC_DTLCASES D,\n"
            + "  AHMMOMST_TXNSCANFEIS X\n"
            + "WHERE D.RCASE_VCASEID = X.RCASE_VCASEID\n"
            + "AND ((D.MENG_VENGNO  IS NOT NULL\n"
            + "AND D.MENG_VENGNO     = X.MENG_VENGNO)\n"
            + "OR (D.MENG_VENGNO    IS NULL\n"
            + "AND D.MPART_VPARTNUM  = X.MPART_VPARTNUM\n"
            + "AND D.MPART_VPARTNUM  = :PARTNO) )\n"
            + "AND D.RCASE_VCASEID   = :CASEID";

    public static final String Get_Shift = " select FUNCAHMMOERPGETSHIFT(sysdate) from dual";

    public static final String Get_Detail_Engine = "SELECT DISTINCT D.MPART_VPARTNUM,\n"
            + "                  NVL(D.MENG_VENGNO, '-') MENG_VENGNO,\n"
            + "                  D.NQTY,\n"
            + "                  X.RTYPE_VMCTYPEID,\n"
            + "                  X.DSET_RSET_VID_CASEPOS,\n"
            + "                  X.DSET_VITEMCODE_CASEPOS, \n"
            + "                  D.NSEQ \n"
            + "                FROM AHMMOSFC_DTLCASES D,\n"
            + "                  AHMMOMST_TXNSCANFEIS X \n"
            + "                WHERE D.RCASE_VCASEID = X.RCASE_VCASEID \n"
            + "                AND ((D.MENG_VENGNO  IS NOT NULL \n"
            + "                AND D.MENG_VENGNO     = X.MENG_VENGNO) \n"
            + "                OR (D.MENG_VENGNO    IS NULL \n"
            + "                AND D.MPART_VPARTNUM  = X.MPART_VPARTNUM) ) \n"
            + "                AND D.RCASE_VCASEID   = :CASEID";

    public static final String Get_Data_By_Case = "SELECT DISTINCT T.RCASE_VCASEID,   T.MENG_VENGNO,  D.NQTY,"
            + "T.VLOTID, T.MPART_VPARTNUM, T.RTYPE_VMCTYPEID, "
            + "CASE "
            + "    WHEN :PARTNO IS NOT NULL THEN cast(D.NSEQ as varchar(10))"
            + "    ELSE '-'"
            + "  END NSEQ "
            + "FROM AHMMOMST_TXNSCANFEIS T,  AHMMOSFC_DTLCASES D "
            + "WHERE 1=1";

    public static final String Get_Part_Child = "SELECT DISTINCT DC.MPART_VPARTNUM_C "
            + "FROM AHMMOMSC_HDRPBOMPRODS HP, AHMMOMSC_HDRCBOMPRODS HC, AHMMOMSC_DTLBOMPRODS DC "
            + "WHERE HP.MPLANT_VPLANTID_P = HC.HPBOM_MPLANT_VPLANTID_P "
            + "AND HP.MPART_VPARTNUM_P = HC.HPBOM_MPART_VPARTNUM_P "
            + "AND HP.VBOMUSAGE = HC.HPBOM_VBOMUSAGE "
            + "AND HP.NSEQID = HC.HPBOM_NSEQID "
            + "AND SYSDATE BETWEEN HP.DBEGINEFF AND HP.DENDEFF "
            + "AND HP.VBOMUSAGE = '1' "
            + "AND DC.HCBOM_HPBOM_MPLANT_VPLANTID_P = HC.HPBOM_MPLANT_VPLANTID_P "
            + "AND DC.HCBOM_HPBOM_MPART_VPARTNUM_P = HC.HPBOM_MPART_VPARTNUM_P "
            + "AND DC.HCBOM_HPBOM_VBOMUSAGE = HC.HPBOM_VBOMUSAGE "
            + "AND DC.HCBOM_HPBOM_NSEQID = HC.HPBOM_NSEQID "
            + "AND DC.HCBOM_MWCT_VWCTID_P = HC.MWCT_VWCTID_P "
            + "AND DC.HCBOM_VROUTEID = HC.VROUTEID "
            + "AND DC.HCBOM_VMLAYOUTID = HC.VMLAYOUTID "
            + "AND HC.MWCT_VWCTID_P = :WCTID "
            + "AND HC.VMCTYPE = :TYPE";

    public static final String Get_Mvt_Type = "SELECT A.VDATA2 "
            + "FROM AHMMOMST_DTLCNFAMVTS A "
            + "WHERE A.RCAMVT_VCONFIGID = 'TXNTYPE_SAPEVENT_MVTYPE' "
            + "AND A.VITEMCODE = '19' "
            + "AND A.BVALID = 1";

    public static final String Get_Temp_Sloc = "SELECT VITEMNAME "
            + "FROM AHMMOERP_DTLSETTINGS "
            + "WHERE RSET_VID = 'MOSFC_WCT_CSL' "
            + "AND BVALID = 'T' "
            + "AND VITEMCODE = :PLANT";

    public static final String Get_Operator_Code = "SELECT VITEMCODE "
            + "FROM AHMMOERP_DTLSETTINGS "
            + "WHERE BVALID = 'T' "
            + "AND RSET_VID = 'SFCPLANTSCAN' "
            + "AND VITEMCODE LIKE '9999%' "
            + "AND VITEMNAME = :PLANT "
            + "AND ROWNUM = 1 ";

    public static final String Get_Part_Spl = "SELECT DISTINCT HP.MPART_VPARTNUM_P "
            + "FROM AHMMOMSC_HDRPBOMPRODS HP, AHMMOMSC_HDRCBOMPRODS HC "
            + "WHERE HP.MPLANT_VPLANTID_P = HC.HPBOM_MPLANT_VPLANTID_P "
            + "AND HP.MPART_VPARTNUM_P = HC.HPBOM_MPART_VPARTNUM_P "
            + "AND HP.VBOMUSAGE = HC.HPBOM_VBOMUSAGE "
            + "AND HP.NSEQID = HC.HPBOM_NSEQID "
            + "AND SYSDATE BETWEEN HP.DBEGINEFF AND HP.DENDEFF "
            + "AND HP.VBOMUSAGE = '1' "
            + "AND HC.VMCTYPE = :TYPE "
            + "AND HC.MWCT_VWCTID_P = :WCTID";

    public static final String Check_Jms = "SELECT A.VEVENTID, A.VAPPID, B.IEVENTSEQ, B.VSTATUS, B.VERRMSG FROM AHMITSYS_MSTEVENTS A,AHMITSYS_LOGEVENTS B \n"
            + "WHERE A.VAPPID = 'ahmmomsc432' AND A.VEVENTID = B.MEVENT_VEVENTID AND \n"
            + "(B.VSTATUS = (SELECT VITEMNAME FROM AHMMOERP_DTLSETTINGS WHERE RSET_VID = 'MSTLOGEVENTSSTATUS' AND VITEMCODE = '10')\n"
            + "OR B.VSTATUS = (SELECT VITEMNAME FROM AHMMOERP_DTLSETTINGS WHERE RSET_VID = 'MSTLOGEVENTSSTATUS' AND VITEMCODE = '20')\n"
            + "OR B.VSTATUS = (SELECT VITEMNAME FROM AHMMOERP_DTLSETTINGS WHERE RSET_VID = 'MSTLOGEVENTSSTATUS' AND VITEMCODE = '25')\n"
            + "OR B.VSTATUS = (SELECT VITEMNAME FROM AHMMOERP_DTLSETTINGS WHERE RSET_VID = 'MSTLOGEVENTSSTATUS' AND VITEMCODE = '30')\n"
            + "OR B.VSTATUS = (SELECT VITEMNAME FROM AHMMOERP_DTLSETTINGS WHERE RSET_VID = 'MSTLOGEVENTSSTATUS' AND VITEMCODE = '41')\n"
            + "OR B.VSTATUS = (SELECT VITEMNAME FROM AHMMOERP_DTLSETTINGS WHERE RSET_VID = 'MSTLOGEVENTSSTATUS' AND VITEMCODE = '42'))\n"
            + "ORDER BY IEVENTSEQ DESC";

}
