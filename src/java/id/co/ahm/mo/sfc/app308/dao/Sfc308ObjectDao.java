/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app308.dao;

import id.co.ahm.jxf.dto.DtoParamPaging;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoCustomer;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoDataEngine;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoDeliveryOrder;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoDetailCase;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoPart;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoSloc;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoWct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author patria
 */
public interface Sfc308ObjectDao {

    public List<Sfc308VoSloc> getSloc(DtoParamPaging param);

    public int getCountSloc(DtoParamPaging param);

    public List<Sfc308VoWct> getWctId(DtoParamPaging param);

    public int getCountWctId(DtoParamPaging param);

    public List<Sfc308VoCustomer> getCustomer(DtoParamPaging param);

    public int getCountCustomer(DtoParamPaging param);

    public List<Sfc308VoDeliveryOrder> getDataDo(DtoParamPaging param);

    public int getCountDataDo(DtoParamPaging param);

    public String checkCaseId(Map<String, Object> param);

    public int sumCaseId(String caseId, Map<String, Object> param);

    public int sumCaseIdWithPart(String caseId, Map<String, Object> param);

    public int sumCaseIdWithoutPart(String caseId, Map<String, Object> param);

    public String getEngine(String caseId, Map<String, Object> param);

    public List<Sfc308VoDataEngine> getDataEngine(String engine);

    public List<Sfc308VoPart> getListPart(DtoParamPaging param);

    public int getCountListPart(DtoParamPaging param);

    public BigDecimal getRunnum(String vplant, String userid);

    public String getShift();

    public String getShift(Date dateNow);

    public List<Sfc308VoDetailCase> getDetailEngine(String caseid);

    public List<Sfc308VoDetailCase> getDataByCaseId(String caseid, String partno);

    public List<Sfc308VoDetailCase> getDataByCaseIdCheck(String caseid, String partno);

    public List<String> getPartNumberChild(String wctid, String type);

    public String getMvtType();

    public String getTempSloc(String plantId);

    public String getOperatorCode(String plantId);

    public String procAhmpsMovement(String txnType, String mvtType, String txnDate,
            String reffDoc, String sapEvent, String slocFr, String plantIdFr,
            String slocTo, String plantIdTo, String oprCode, Integer oprNrp,
            String slocAcc, String plantIdAcc, String wctAcc, String parentId,
            String parentType, Integer sumDataXml, String partNumQtyXml, String userId,
            String commit, String debug);

    public List<Sfc308VoDetailCase> getPartnumSPL(String type, String wctid);

    public String callProcGetShift();

    public String callProcGetPeriod();

    public String procSfcPlantWct(String txnType, String wctId, String typeId,
             String colorId, String partNum, Integer qty, String date,
             String shift, String periode, String bomId, String userId,
             String commit, String debug);

    public boolean checkJMS();

}
