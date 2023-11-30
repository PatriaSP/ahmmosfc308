/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app308.dao.impl;

import id.co.ahm.jxf.dao.DefaultHibernateDao;
import id.co.ahm.jxf.dto.DtoParamPaging;
import id.co.ahm.mo.sfc.app308.constant.Sfc308Constant;
import id.co.ahm.mo.sfc.app308.dao.Sfc308ObjectDao;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoCustomer;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoDataEngine;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoDeliveryOrder;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoDetailCase;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoPart;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoSloc;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoWct;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author patria
 */
@Repository("sfc308ObjectDao")
public class Sfc308ObjectDaoImpl extends DefaultHibernateDao<Object, Serializable> implements Sfc308ObjectDao {

    @Override
    public List<Sfc308VoSloc> getSloc(DtoParamPaging param) {
        List<Sfc308VoSloc> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Lov_Storage_Loc);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("VPARAM", param.getSearch().get("VPARAM").toString());
        query.setFirstResult(param.getOffset());
        query.setMaxResults(param.getLimit());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Sfc308VoSloc vo = new Sfc308VoSloc();
                vo.setVitemcode((String) obj[i++]);
                vo.setVitemdesc((String) obj[i++]);
                vo.setVitemname((String) obj[i++]);
                vo.setVplantdesc((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public int getCountSloc(DtoParamPaging param) {
        int result;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(1) FROM (");
        sql.append(Sfc308Constant.Lov_Storage_Loc);
        sql.append("    )");

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("VPARAM", param.getSearch().get("VPARAM").toString());

        Number number = (Number) query.uniqueResult();
        result = number.intValue();

        return result;
    }

    @Override
    public List<Sfc308VoWct> getWctId(DtoParamPaging param) {
        List<Sfc308VoWct> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Lov_Wct_Id);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("VPLANT", param.getSearch().get("VPLANT").toString());
        query.setString("VPARAM", param.getSearch().get("VPARAM").toString());
        query.setFirstResult(param.getOffset());
        query.setMaxResults(param.getLimit());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Sfc308VoWct vo = new Sfc308VoWct();
                vo.setWctid((String) obj[i++]);
                vo.setWctdesc((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public int getCountWctId(DtoParamPaging param) {
        int result;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(1) FROM (");
        sql.append(Sfc308Constant.Lov_Wct_Id);
        sql.append("    )");

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("VPLANT", param.getSearch().get("VPLANT").toString());
        query.setString("VPARAM", param.getSearch().get("VPARAM").toString());

        Number number = (Number) query.uniqueResult();
        result = number.intValue();

        return result;
    }

    @Override
    public List<Sfc308VoCustomer> getCustomer(DtoParamPaging param) {
        List<Sfc308VoCustomer> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Lov_Customer);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("VPARAM", param.getSearch().get("VPARAM").toString());
        query.setFirstResult(param.getOffset());
        query.setMaxResults(param.getLimit());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Sfc308VoCustomer vo = new Sfc308VoCustomer();
                vo.setCustId((String) obj[i++]);
                vo.setCustDesc((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public int getCountCustomer(DtoParamPaging param) {
        int result;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(1) FROM (");
        sql.append(Sfc308Constant.Lov_Customer);
        sql.append("    )");

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("VPARAM", param.getSearch().get("VPARAM").toString());

        Number number = (Number) query.uniqueResult();
        result = number.intValue();

        return result;
    }

    @Override
    public List<Sfc308VoDeliveryOrder> getDataDo(DtoParamPaging param) {
        List<Sfc308VoDeliveryOrder> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Do);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("VPLANT", param.getSearch().get("VPLANT").toString());
        query.setString("VCUST", param.getSearch().get("VCUST").toString());
        query.setFirstResult(param.getOffset());
        query.setMaxResults(param.getLimit());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();
            int rowNum = param.getOffset();
            for (Object[] obj : list) {
                int i = 0;
                Sfc308VoDeliveryOrder vo = new Sfc308VoDeliveryOrder();
                rowNum = rowNum + 1;
                vo.setRownum(rowNum);
                vo.setNodo((String) obj[i++]);
                vo.setType((String) obj[i++]);
                vo.setQty(obj[i++].toString());
                vo.setPartnum((String) obj[i++]);
                vo.setColor((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public int getCountDataDo(DtoParamPaging param) {
        int result;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(1) FROM (");
        sql.append(Sfc308Constant.Get_Do);
        sql.append("    )");

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("VPLANT", param.getSearch().get("VPLANT").toString());
        query.setString("VCUST", param.getSearch().get("VCUST").toString());

        Number number = (Number) query.uniqueResult();
        result = number.intValue();

        return result;
    }

    @Override
    public String checkCaseId(Map<String, Object> param) {
        String result = "";
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Check_Case_Id);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("PARTNO", param.get("PARTNO").toString());
        query.setString("CASEID", param.get("CASEID").toString());

        result = query.uniqueResult() == null ? "" : query.uniqueResult().toString();

        return result;
    }

    @Override
    public int sumCaseId(String caseId, Map<String, Object> param) {
        int result;
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Sum_Case_Id);
        sql.append("    AND ((:PARTNO IS NOT NULL AND MPART_VPARTNUM = :PARTNO) \n"
                + "    OR (:PARTNO IS NULL AND MPART_VPARTNUM LIKE '%' AND MENG_VENGNO IS NOT NULL))");

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("CASEID", caseId);
        query.setString("PARTNO", param.get("PARTNO").toString());

        Number number = (Number) query.uniqueResult();
        result = number == null ? 0 : number.intValue();

        return result;
    }

    @Override
    public int sumCaseIdWithPart(String caseId, Map<String, Object> param) {
        int result;
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Sum_Case_Id);
        sql.append("    AND MPART_VPARTNUM = :PARTNO");

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("CASEID", caseId);
        query.setString("PARTNO", param.get("PARTNO").toString());

        Number number = (Number) query.uniqueResult();
        result = number == null ? 0 : number.intValue();

        return result;
    }

    @Override
    public int sumCaseIdWithoutPart(String caseId, Map<String, Object> param) {
        int result;
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Sum_Case_Id);
        sql.append("    AND MENG_VENGNO IS NOT NULL");

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("CASEID", caseId);

        Number number = (Number) query.uniqueResult();
        result = number.intValue();

        return result;
    }

    @Override
    public String getEngine(String caseId, Map<String, Object> param) {
        String result;
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Engine);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("TYPE", param.get("TYPE").toString());
        query.setString("CASEID", caseId);

        result = query.uniqueResult().toString();

        return result;
    }

    @Override
    public List<Sfc308VoDataEngine> getDataEngine(String engine) {
        List<Sfc308VoDataEngine> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Data_Engine);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("ENGINE", engine);

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Sfc308VoDataEngine vo = new Sfc308VoDataEngine();
                vo.setVitemcode((String) obj[i++]);
                vo.setVitemname((String) obj[i++]);
                vo.setType((String) obj[i++]);
                vo.setPlant((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Sfc308VoPart> getListPart(DtoParamPaging param) {
        List<Sfc308VoPart> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_List_Part);
        sql.append(" ORDER BY MENG_VENGNO ASC");
        
        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("PARTNO", param.getSearch().get("PARTNO").toString());
        query.setString("CASEID", param.getSearch().get("CASEID").toString());
        query.setFirstResult(param.getOffset());
        query.setMaxResults(param.getLimit());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Sfc308VoPart vo = new Sfc308VoPart();
                vo.setPartnum((String) obj[i++]);
                vo.setEngineno((String) obj[i++]);
                vo.setQty(obj[i++].toString());
                vo.setSeq(obj[i++].toString());
                vo.setType((String) obj[i++]);
                vo.setIdcasepos((String) obj[i++]);
                vo.setVitemcodecasepos((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public int getCountListPart(DtoParamPaging param) {
        int result;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(1) FROM (");
        sql.append(Sfc308Constant.Get_List_Part);
        sql.append("    )");

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("PARTNO", param.getSearch().get("PARTNO").toString());
        query.setString("CASEID", param.getSearch().get("CASEID").toString());

        Number number = (Number) query.uniqueResult();
        result = number.intValue();

        return result;
    }

    @Override
    public BigDecimal getRunnum(String vplant, String userid) {
        Object doReturningWork = getCurrentSession().doReturningWork((Connection connection) -> {
            CallableStatement call = connection.prepareCall("{ ? = call PACKAHMMOMSTSWOTHERS.FUNCAHMMOERPGETRUNNUM (?, '" + vplant + "'||TO_CHAR(SYSDATE,'YYYY'), '"
                    + userid + "', '0', '0') }");

            call.setString(2, "MSTFEDSHPLST");
            call.registerOutParameter(1, Types.NUMERIC);
            call.execute();

            return call.getBigDecimal(1);
        });
        return (BigDecimal) doReturningWork;
    }

    @Override
    public String getShift() {
        String result = "";
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Shift);

        Query query = getCurrentSession().createSQLQuery(sql.toString());

        result = query.uniqueResult() == null ? "" : query.uniqueResult().toString();

        return result;
    }

    @Override
    public String getShift(Date dateNow) {
        String query = "select FUNCAHMMOERPGETSHIFT(sysdate) from dual ";
        Query tempres = getCurrentSession().createSQLQuery(query);
        return (String) tempres.uniqueResult();
    }

    @Override
    public List<Sfc308VoDetailCase> getDetailEngine(String caseid) {
        List<Sfc308VoDetailCase> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Detail_Engine);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("CASEID", caseid);

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Sfc308VoDetailCase vo = new Sfc308VoDetailCase();
                vo.setPartNo((String) obj[i++]);
                vo.setEngineNo((String) obj[i++]);
                vo.setQty(new BigDecimal(obj[i++].toString()));
                vo.setMcType((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Sfc308VoDetailCase> getDataByCaseId(String caseid, String partno) {
        List<Sfc308VoDetailCase> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Data_By_Case);
        sql.append(" AND D.RCASE_VCASEID    = T.RCASE_VCASEID "
                + "AND T.MXCODE_VITEMCODE   = 'AFTER PACKING' "
                + "AND T.RCASE_VCASEID NOT IN "
                + "  (SELECT VCASEID FROM AHMMOMST_DTLSHPFEDS WHERE VCASEID IS NOT NULL   ) "
                + "AND ((:PARTNO       IS NOT NULL AND T.MPART_VPARTNUM = :PARTNO) "
                + "     OR (:PARTNO         IS NULL AND T.MPART_VPARTNUM LIKE '%')) "
                + "AND T.RCASE_VCASEID = :CASEID ");

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("PARTNO", partno == null ? "" : partno);
        query.setString("CASEID", caseid == null ? "" : caseid);

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Sfc308VoDetailCase vo = new Sfc308VoDetailCase();
                vo.setCaseId((String) obj[i++]);
                vo.setEngineNo((String) obj[i++]);
                vo.setQty(new BigDecimal(obj[i++].toString()));
                vo.setVlotId((String) obj[i++]);
                vo.setPartNo((String) obj[i++]);
                vo.setMcType((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Sfc308VoDetailCase> getDataByCaseIdCheck(String caseid, String partno) {
        List<Sfc308VoDetailCase> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Data_By_Case);
        sql.append(" AND  D.RCASE_VCASEID    = T.RCASE_VCASEID \n"
                + "                 AND T.MXCODE_VITEMCODE   = 'AFTER PACKING' \n"
                + "                 AND ((:PARTNO       IS NOT NULL AND T.MPART_VPARTNUM = :PARTNO) \n"
                + "                      OR (:PARTNO         IS NULL AND T.MPART_VPARTNUM LIKE '%' ))\n"
                + "                 AND T.RCASE_VCASEID = :CASEID  ");

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("PARTNO", partno == null ? "" : partno);
        query.setString("CASEID", caseid == null ? "" : caseid);

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Sfc308VoDetailCase vo = new Sfc308VoDetailCase();
                vo.setCaseId((String) obj[i++]);
                vo.setEngineNo((String) obj[i++]);
                vo.setQty(new BigDecimal(obj[i++].toString()));
                vo.setVlotId((String) obj[i++]);
                vo.setPartNo((String) obj[i++]);
                vo.setMcType((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<String> getPartNumberChild(String wctid, String type) {
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Part_Child);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("WCTID", wctid);
        query.setString("TYPE", type);

        return query.list();
    }

    @Override
    public String getMvtType() {
        String result = "";
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Mvt_Type);

        Query query = getCurrentSession().createSQLQuery(sql.toString());

        result = query.uniqueResult() == null ? "" : query.uniqueResult().toString();

        return result;
    }

    @Override
    public String getTempSloc(String plantId) {
        String result = "";
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Temp_Sloc);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("PLANT", plantId);

        result = query.uniqueResult() == null ? "" : query.uniqueResult().toString();

        return result;
    }

    @Override
    public String getOperatorCode(String plantId) {
        String result = "";
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Operator_Code);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("PLANT", plantId);

        result = query.uniqueResult() == null ? "" : query.uniqueResult().toString();

        return result;
    }

    @Override
    public String procAhmpsMovement(String txnType, String mvtType, String txnDate, String reffDoc, String sapEvent, String slocFr, String plantIdFr, String slocTo, String plantIdTo, String oprCode, Integer oprNrp, String slocAcc, String plantIdAcc, String wctAcc, String parentId, String parentType, Integer sumDataXml, String partNumQtyXml, String userId, String commit, String debug) {
        Object doReturningWork = getCurrentSession().doReturningWork((Connection connection) -> {
            CallableStatement call = connection.prepareCall("{call PROCAHMMOSFC230(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            call.setString(1, txnType);
            call.setString(2, mvtType);
            call.setString(3, txnDate);
            call.setString(4, reffDoc);
            call.setString(5, sapEvent);
            call.setString(6, slocFr);
            call.setString(7, plantIdFr);
            call.setString(8, slocTo);
            call.setString(9, plantIdTo);
            call.setString(10, oprCode);
            call.setInt(11, oprNrp);
            call.setString(12, slocAcc);
            call.setString(13, plantIdAcc);
            call.setString(14, wctAcc);
            call.setString(15, parentId);
            call.setString(16, parentType);
            call.setInt(17, sumDataXml);
            call.setString(18, partNumQtyXml);
            call.setString(19, userId);
            call.setString(20, commit);
            call.setString(21, debug);
            call.registerOutParameter(22, Types.VARCHAR); // Parameter OUT
            call.registerOutParameter(23, Types.VARCHAR); // Parameter OUT

            call.executeUpdate();

            return call.getString(22);
        });
        return (String) doReturningWork;
    }

    @Override
    public List<Sfc308VoDetailCase> getPartnumSPL(String type, String wctid) {
        List<Sfc308VoDetailCase> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Sfc308Constant.Get_Part_Spl);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("TYPE", type);
        query.setString("WCTID", wctid);

        if (query.list().size() > 0) {
            List<String> list = query.list();

            for (String partnum : list) {
                Sfc308VoDetailCase vo = new Sfc308VoDetailCase();
                vo.setPartNo(partnum);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public String callProcGetShift() {
        Timestamp sysdate = new Timestamp(new Date().getTime());
        Object doReturningWork = getCurrentSession().doReturningWork((Connection connection) -> {
            CallableStatement call = connection.prepareCall("{ ? = call FUNCAHMMOERPGETSHIFT(?) }");
            call.registerOutParameter(1, Types.VARCHAR);
            call.setTimestamp(2, sysdate);
            call.execute();

            return call.getString(1);
        });
        return (String) doReturningWork;
    }

    @Override
    public String callProcGetPeriod() {
        Timestamp sysdate = new Timestamp(new Date().getTime());
        Object doReturningWork = getCurrentSession().doReturningWork((Connection connection) -> {
            CallableStatement call = connection.prepareCall("{ ? = call FUNCAHMMOSFCGETPERIODE(?) }");
            call.registerOutParameter(1, Types.VARCHAR);
            call.setTimestamp(2, sysdate);
            call.execute();

            return call.getString(1);
        });
        return (String) doReturningWork;
    }

    @Override
    public String procSfcPlantWct(String txnType, String wctId, String typeId, String colorId, String partNum, Integer qty, String date, String shift, String periode, String bomId, String userId, String commit, String debug) {
        Object doReturningWork = getCurrentSession().doReturningWork((Connection connection) -> {
            CallableStatement call = connection.prepareCall("{call PROCAHMMOSFCPLANWCT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            call.setString(1, txnType);
            call.setString(2, wctId);
            call.setString(3, typeId);
            call.setString(4, colorId);
            call.setString(5, partNum);
            call.setInt(6, qty);
            call.setString(7, date);
            call.setString(8, shift);
            call.setString(9, periode);
            call.setString(10, bomId);
            call.setString(11, userId);
            call.setString(12, commit);
            call.setString(13, debug);
            call.registerOutParameter(14, Types.VARCHAR); // Parameter OUT

            // Execute PROCAHMMOSFCPLANWCT store procedure
            call.executeUpdate();
            return call.getString(14);
        });
        return (String) doReturningWork;
    }

    @Override
    public boolean checkJMS() {
        boolean result = false;
        String sql = Sfc308Constant.Check_Jms;

        Query query = getCurrentSession().createSQLQuery(sql);

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();
            for (Object[] obj : list) {
                if((obj[3] == null ? "" : obj[3].toString()).equalsIgnoreCase("_41_OK") || (obj[3] == null ? "" : obj[3].toString()).equalsIgnoreCase("_42_FAILED")){
                    result = false;
                    break;
                }else{
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

}
