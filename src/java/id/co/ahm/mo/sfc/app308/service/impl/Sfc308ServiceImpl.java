/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app308.service.impl;

import id.co.ahm.jx.jms.service.JMSService;
import id.co.ahm.jx.jms.service.VoInputParamJMS;
import id.co.ahm.jxf.constant.StatusMsgEnum;
import id.co.ahm.jxf.dto.DtoParamPaging;
import id.co.ahm.jxf.dto.DtoResponse;
import id.co.ahm.jxf.util.DtoHelper;
import id.co.ahm.jxf.vo.VoPstUserCred;
import id.co.ahm.mo.sfc.app000.model.AhmmomstDtlshpfeds;
import id.co.ahm.mo.sfc.app000.model.AhmmomstDtlshpfedsPK;
import id.co.ahm.mo.sfc.app000.model.AhmmomstHdrshpfeds;
import id.co.ahm.mo.sfc.app000.model.AhmmomstHdrshpfedsPK;
import id.co.ahm.mo.sfc.app000.model.AhmmosfcMstengines;
import id.co.ahm.mo.sfc.app000.model.AhmmosfcMstenginesPK;
import id.co.ahm.mo.sfc.app000.model.AhmmotrcHdrxcrlfgs;
import id.co.ahm.mo.sfc.app000.model.AhmmotrcHdrxcrlfgsPK;
import id.co.ahm.mo.sfc.app000.model.AhmsdmusDtlsipbs;
import id.co.ahm.mo.sfc.app000.model.AhmsdmusDtlsipbsPK;
import id.co.ahm.mo.sfc.app308.dao.Sfc308AhmmomstDtlshpfedsDao;
import id.co.ahm.mo.sfc.app308.dao.Sfc308AhmmomstHdrshpfedsDao;
import id.co.ahm.mo.sfc.app308.dao.Sfc308AhmmosfcMstenginesDao;
import id.co.ahm.mo.sfc.app308.dao.Sfc308AhmmotrcHdrxcrlfgsDao;
import id.co.ahm.mo.sfc.app308.dao.Sfc308AhmsdmusDtlsipbsDao;
import id.co.ahm.mo.sfc.app308.dao.Sfc308ObjectDao;
import id.co.ahm.mo.sfc.app308.service.Sfc308Service;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoCustomer;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoDataEngine;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoDeliveryOrder;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoDetailCase;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoDtlXml;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoOS;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoPart;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoSloc;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoWct;
import id.co.ahm.mo.sfc.app308.vo.Sfc308VoXml;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author patria
 */
@Service("sfc308Service")
@Transactional(readOnly = true)
public class Sfc308ServiceImpl implements Sfc308Service {

    @Autowired
    @Qualifier("sfc308ObjectDao")
    private Sfc308ObjectDao mst351ObjectDao;

    @Autowired
    @Qualifier("sfc308AhmmosfcMstenginesDao")
    private Sfc308AhmmosfcMstenginesDao sfc308AhmmosfcMstenginesDao;

    @Autowired
    @Qualifier("sfc308AhmmotrcHdrxcrlfgsDao")
    private Sfc308AhmmotrcHdrxcrlfgsDao sfc308AhmmotrcHdrxcrlfgsDao;

    @Autowired
    @Qualifier("sfc308AhmsdmusDtlsipbsDao")
    private Sfc308AhmsdmusDtlsipbsDao sfc308AhmsdmusDtlsipbsDao;

    @Autowired
    @Qualifier("sfc308AhmmomstDtlshpfedsDao")
    private Sfc308AhmmomstDtlshpfedsDao sfc308AhmmomstDtlshpfedsDao;

    @Autowired
    @Qualifier("sfc308AhmmomstHdrshpfedsDao")
    private Sfc308AhmmomstHdrshpfedsDao sfc308AhmmomstHdrshpfedsDao;

    @Autowired
    @Qualifier(value = "jmsService")
    JMSService jmsService;

    @Override
    public DtoResponse getSlocData(DtoParamPaging param) {
        List<Sfc308VoSloc> data = mst351ObjectDao.getSloc(param);
        int count = mst351ObjectDao.getCountSloc(param);
        return DtoHelper.constructResponsePaging(StatusMsgEnum.SUKSES, null, data, count);
    }

    @Override
    public DtoResponse getWctId(DtoParamPaging param) {
        List<Sfc308VoWct> data = mst351ObjectDao.getWctId(param);
        int count = mst351ObjectDao.getCountWctId(param);
        return DtoHelper.constructResponsePaging(StatusMsgEnum.SUKSES, null, data, count);
    }

    @Override
    public DtoResponse getCustomer(DtoParamPaging param) {
        List<Sfc308VoCustomer> data = mst351ObjectDao.getCustomer(param);
        int count = mst351ObjectDao.getCountCustomer(param);
        return DtoHelper.constructResponsePaging(StatusMsgEnum.SUKSES, null, data, count);
    }

    @Override
    public DtoResponse getDataDo(DtoParamPaging param) {
        List<Sfc308VoDeliveryOrder> data = mst351ObjectDao.getDataDo(param);
        int count = mst351ObjectDao.getCountDataDo(param);
        return DtoHelper.constructResponsePaging(StatusMsgEnum.SUKSES, null, data, count);
    }

    @Override
    public DtoResponse checkCaseId(Map<String, Object> param) {
        Map<String, Object> msg = new HashMap<>();
        boolean status = false;
        String caseId = mst351ObjectDao.checkCaseId(param);
        int sumCaseId;
        if (!caseId.isEmpty()) {
            sumCaseId = mst351ObjectDao.sumCaseId(caseId, param);
            status = true;
        } else {
            msg.put("m", "Case ID Tidak Valid");
            return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, msg, null);
        }

        if (!param.get("PARTNO").toString().isEmpty()) {         
            sumCaseId = mst351ObjectDao.sumCaseIdWithPart(caseId, param);
            
        } else if (param.get("PARTNO").toString().isEmpty() && status) {
            sumCaseId = mst351ObjectDao.sumCaseIdWithoutPart(caseId, param);
        } else {
            String engine = mst351ObjectDao.getEngine(caseId, param);
            List<Sfc308VoDataEngine> data = mst351ObjectDao.getDataEngine(engine);
            if (data.size() > 0) {
                if (!data.get(0).getPlant().equalsIgnoreCase(param.get("VPLANT").toString())) {
                    msg.put("m", "Engine Plant [" + data.get(0).getPlant() + "] Has Not Match Plant Scan [" + param.get("VPLANT").toString() + "] !");
                    return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, msg, null);
                }
                if (!data.get(0).getVitemcode().equalsIgnoreCase("7")) {
                    msg.put("m", "Engine  [" + engine + "] with Status [" + data.get(0).getVitemname() + "] Can’t Be Create Shipping List !");
                    return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, msg, null);
                }
            }
        }
        List<Sfc308VoDetailCase> data = new ArrayList<Sfc308VoDetailCase>();
        Sfc308VoDetailCase vo = new Sfc308VoDetailCase();
        vo.setCaseId(caseId);
        vo.setQty(new BigDecimal(sumCaseId));
        data.add(vo);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getListPart(DtoParamPaging param) {
        List<Sfc308VoPart> data = mst351ObjectDao.getListPart(param);
        int count = mst351ObjectDao.getCountListPart(param);
        return DtoHelper.constructResponsePaging(StatusMsgEnum.SUKSES, null, data, count);
    }

    @Override
    @Transactional(readOnly = false)
    public DtoResponse submitData(Map<String, Object> param, VoPstUserCred userCred) {
        Map<String, Object> msg = new HashMap<>();
        try {
            ArrayList<Object> listCase = (ArrayList<Object>) param.get("DATACASE");
            ArrayList<Object> listDo = (ArrayList<Object>) param.get("DATADO");

            int totalQty = 0;
            for (Object data : listCase) {
                Map<String, Object> dataMap = (Map<String, Object>) data;
                totalQty += Integer.parseInt(dataMap.get("qty").toString().replace(".0", ""));
            }

            Map<String, Object> dataDo = null;
            for (Object data : listDo) {
                dataDo = (Map<String, Object>) data;
            }

            if (totalQty > Integer.parseInt(dataDo.get("qty").toString().replace(".0", ""))) {
                msg.put("message", "Total Qty Caseid tidak boleh lebih dari Qty Delivery Order!");
                return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, msg, null);
            }

            AhmmomstHdrshpfedsPK pkHeader = new AhmmomstHdrshpfedsPK();
            AhmmomstHdrshpfeds ahmmomstHdrshpfeds = new AhmmomstHdrshpfeds();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfTimestamp = new SimpleDateFormat("dd-MMM-yyyy");

            pkHeader.setMstorMplantVplantid(param.get("VPLANT").toString());
            pkHeader.setMstorVslocid(param.get("SLOC").toString());

            BigDecimal shipNo = mst351ObjectDao.getRunnum(param.get("VPLANT").toString(), userCred.getUserid());
            BigDecimal shipYear = new BigDecimal(sdf.format(new Date()));
            pkHeader.setNshipno(shipNo);
            pkHeader.setNshipyear(shipYear);
            ahmmomstHdrshpfeds.setAhmmomstHdrshpfedsPK(pkHeader);
            ahmmomstHdrshpfeds.setDshipact(new Date());
            Date dateNow = new Date();
            Date dateShift;
            String vshift = mst351ObjectDao.getShift(dateNow);
            Calendar cal = Calendar.getInstance();
            if (vshift.equals("3")) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
                dateShift = cal.getTime();
            } else {
                dateShift = cal.getTime();
            }
            ahmmomstHdrshpfeds.setDshippost(dateShift);
            ahmmomstHdrshpfeds.setVnodo(dataDo.get("nodo").toString());
            ahmmomstHdrshpfeds.setNshipqty(new BigDecimal(totalQty));
            ahmmomstHdrshpfeds.setVpoliceno(param.get("NOPOL").toString());
            ahmmomstHdrshpfeds.setMcategDsetVitemcode("CONTAINER");
            ahmmomstHdrshpfeds.setMcategDsetRsetVid("MSTCATTRUCK");
            ahmmomstHdrshpfeds.setMpackVitemcode("I");
            ahmmomstHdrshpfeds.setMpackRsetVid("MSTPACKDELV");
            ahmmomstHdrshpfeds.setDsetRsetVid("MSTSTATSHPLIST");
            ahmmomstHdrshpfeds.setDsetVitemcode("2");
            ahmmomstHdrshpfeds.setDsetRsetVidBflinv("MSTSTATPRINV");
            ahmmomstHdrshpfeds.setDsetVitemcodeBflinv("0");
            ahmmomstHdrshpfeds.setNnet(new BigDecimal(param.get("NETTO").toString()));
            ahmmomstHdrshpfeds.setNgross(new BigDecimal(param.get("BRUTO").toString()));
            ahmmomstHdrshpfeds.setVmeasurement(param.get("MEASUREMENT").toString());
            ahmmomstHdrshpfeds.setDeta(sdfTimestamp.parse(param.get("ETA").toString()));
            ahmmomstHdrshpfeds.setDetd(sdfTimestamp.parse(param.get("ETD").toString()));
            ahmmomstHdrshpfeds.setIdCsarea(param.get("VCUST").toString());
            ahmmomstHdrshpfeds.setCsarea(param.get("VCUSTADDR").toString());

            List<AhmmomstDtlshpfeds> listDetail = new ArrayList<AhmmomstDtlshpfeds>();
            BigDecimal detSeq = BigDecimal.ZERO;
            String mctype = "";
            String retVal = "";

            for (Object vo : listCase) {
                Map<String, Object> dataVoCase = (Map<String, Object>) vo;
                // update DSETITEMCODE jika ENGINE != null
                List<Sfc308VoDetailCase> listVo = mst351ObjectDao.getDetailEngine(dataVoCase.get("caseId").toString());
                AhmmosfcMstenginesPK ahmmosfcMstenginesPK = new AhmmosfcMstenginesPK();
                for (int i = 0; i < listVo.size(); i++) {
                    if (listVo.get(i).getEngineNo() != null) {
                        ahmmosfcMstenginesPK.setVengno(listVo.get(i).getEngineNo());
                        AhmmosfcMstengines AhmmosfcMstenginesData = sfc308AhmmosfcMstenginesDao.findOne(ahmmosfcMstenginesPK);
                        if (AhmmosfcMstenginesData != null) {
                            AhmmosfcMstenginesData.setDsetvitemcodedsteng("D");
                            sfc308AhmmosfcMstenginesDao.update(AhmmosfcMstenginesData);
                            sfc308AhmmosfcMstenginesDao.flush();
                        }
                    }
                }

                // Update qty shiping jadi tambah sesuai dengan scan\
                AhmsdmusDtlsipbsPK ahmsdmusDtlsipbsPK = new AhmsdmusDtlsipbsPK();
                ahmsdmusDtlsipbsPK.setVsipno(dataDo.get("nodo").toString());
                ahmsdmusDtlsipbsPK.setVtype(dataDo.get("type").toString());
                ahmsdmusDtlsipbsPK.setVcol(dataDo.get("color").toString());
                AhmsdmusDtlsipbs AhmsdmusDtlsipbsData = sfc308AhmsdmusDtlsipbsDao.findOne(ahmsdmusDtlsipbsPK);
                if (AhmsdmusDtlsipbsData != null) {
                    if (dataVoCase.get("qty") == null) {
                        AhmsdmusDtlsipbsData.setIqtyship(new BigDecimal(0));
                    } else {
                        AhmsdmusDtlsipbsData.setIqtyship(new BigDecimal(dataVoCase.get("qty").toString()).add(AhmsdmusDtlsipbsData.getIqtyship()));
                    }
                    sfc308AhmsdmusDtlsipbsDao.update(AhmsdmusDtlsipbsData);
                    sfc308AhmsdmusDtlsipbsDao.flush();
                } else {
                    msg.put("message", "Data Delivery Order: " + dataDo.get("nodo").toString() + ", Col: " + dataDo.get("color").toString() + ", dan Tipe: " + dataDo.get("type").toString());
                    return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, msg, null);
                }

                // ambil nilai partnum, enginenum, mctype berdasarkan CASE ID (dari datamodel -> vo)
                List<Sfc308VoDetailCase> listVoGetData = mst351ObjectDao.getDataByCaseId(dataVoCase.get("caseId") == null ? "" : dataVoCase.get("caseId").toString(),
                        dataDo.get("partnum") == null ? "" : dataDo.get("partnum").toString());
                for (int x = 0; x < listVoGetData.size(); x++) {
                    // AHMMOTRC_HDRXCRLFGS  update statusnya jadi 5 = SHIPPED
                    if (listVoGetData.get(x).getVlotId() != null && !listVoGetData.get(x).getVlotId().equals("")) {
                        AhmmotrcHdrxcrlfgsPK AhmmotrcHdrxcrlfgsPK = new AhmmotrcHdrxcrlfgsPK();
                        AhmmotrcHdrxcrlfgsPK.setVlotid(listVoGetData.get(x).getVlotId());
                        AhmmotrcHdrxcrlfgs AhmmotrcHdrxcrlfgsData = sfc308AhmmotrcHdrxcrlfgsDao.findOne(AhmmotrcHdrxcrlfgsPK);
                        if (AhmmotrcHdrxcrlfgsData != null) {
                            AhmmotrcHdrxcrlfgsData.setVexpdlvstat("5");
                            sfc308AhmmotrcHdrxcrlfgsDao.update(AhmmotrcHdrxcrlfgsData);
                            sfc308AhmmotrcHdrxcrlfgsDao.flush();
                        }
                    }

                    // set nilai detail 
                    AhmmomstDtlshpfedsPK AhmmomstDtlshpfedsPK = new AhmmomstDtlshpfedsPK();
                    AhmmomstDtlshpfedsPK.setRshpfeNshipno(shipNo);
                    AhmmomstDtlshpfedsPK.setRshpfeNshipyear(shipYear);
                    AhmmomstDtlshpfedsPK.setRshpfeMstorMplantVplantid(param.get("VPLANT").toString());
                    AhmmomstDtlshpfedsPK.setRshpfeMstorVslocid(param.get("SLOC").toString());
                    AhmmomstDtlshpfeds AhmmomstDtlshpfeds = sfc308AhmmomstDtlshpfedsDao.findOne(AhmmomstDtlshpfedsPK);
                    if (AhmmomstDtlshpfeds == null) {
                        detSeq = detSeq.add(BigDecimal.ONE);
                        AhmmomstDtlshpfeds = new AhmmomstDtlshpfeds();
                        AhmmomstDtlshpfedsPK pk = new AhmmomstDtlshpfedsPK();
                        if (listVoGetData.get(x).getPartNo() == null) {
                            pk.setMpartVpartnum("");
                        } else {
                            pk.setMpartVpartnum(listVoGetData.get(x).getPartNo());
                        }
                        pk.setRshpfeMstorMplantVplantid(param.get("VPLANT").toString());
                        pk.setRshpfeMstorVslocid(param.get("SLOC").toString());
                        pk.setRshpfeNshipno(shipNo);
                        pk.setRshpfeNshipyear(shipYear);
                        pk.setNseq(detSeq);
                        AhmmomstDtlshpfeds.setAhmmomstDtlshpfedsPK(pk);
                        AhmmomstDtlshpfeds.setMengVengno(listVoGetData.get(x).getEngineNo());
                        AhmmomstDtlshpfeds.setNqty(new BigDecimal(listVoGetData.get(x).getQty().toString()));
                        AhmmomstDtlshpfeds.setRtypeVmctypeid(listVoGetData.get(x).getMcType());
                        AhmmomstDtlshpfeds.setVcaseid(dataVoCase.get("caseId").toString()); // added by okky.ms 15092016
                        AhmmomstDtlshpfeds.setMcolVcolorid(dataDo.get("color").toString());
                        listDetail.add(AhmmomstDtlshpfeds);
                    } else {
                        AhmmomstDtlshpfeds.setNqty(AhmmomstDtlshpfeds.getNqty().add(BigDecimal.ONE));
                        sfc308AhmmomstDtlshpfedsDao.update(AhmmomstDtlshpfeds);
                        sfc308AhmmomstDtlshpfedsDao.flush();
                    }
                    if (mctype.equals("")) {
                        mctype = AhmmomstDtlshpfeds.getRtypeVmctypeid();
                    }
                }
            }

            // save header - detail
            ahmmomstHdrshpfeds.setAhmmomstDtlshpfedses(listDetail);
            sfc308AhmmomstHdrshpfedsDao.save(ahmmomstHdrshpfeds);
            sfc308AhmmomstHdrshpfedsDao.flush();

            // cek validasi untuk masuk ke prosedur
            /*
            * EPP ga kepanggil case id NULL
             */
            for (Object vo : listCase) {
                Map<String, Object> dataVoCase = (Map<String, Object>) vo;
                List<Sfc308VoDetailCase> listVoGetData1 = mst351ObjectDao.getDataByCaseIdCheck(dataVoCase.get("caseId") == null ? "" : dataVoCase.get("caseId").toString(),
                        dataDo.get("partnum") == null ? "" : dataDo.get("partnum").toString());
                for (int x = 0; x < listVoGetData1.size(); x++) {
                    // Call Procedure
                    List<String> listPartChild = mst351ObjectDao.getPartNumberChild(param.get("WCTID").toString(), dataDo.get("type").toString()); // ("P3CWA0", "FW0"); // hardcode
                    String partNumQtyXML = null;
                    try {
                        partNumQtyXML = generateXMLParams(listPartChild);
                    } catch (IOException ex) {
                        Logger.getLogger(Sfc308ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    // mengambil dari tabel DELIVERY NO
                    // jika NODO NOT NULL dan TYPE NOT NULL dan PARTNO NOT NULL // ketiga datanya ada
                    if (dataDo.get("nodo") != null && dataDo.get("type") != null && dataDo.get("partnum") != null) {
                        if (dataDo.get("partnum").toString() != null) { // jika PART != null di tabel delivery
                            if (listVoGetData1.get(x).getEngineNo() == null) {
                                retVal = procAhmpsMovement("-",
                                        param.get("VPLANT").toString(), param.get("SLOC").toString(), param.get("WCTID").toString(),
                                        listPartChild.size(), partNumQtyXML, userCred.getUserid());

                            } else {
                                retVal = procAhmpsMovement(listVoGetData1.get(x).getEngineNo(),
                                        param.get("VPLANT").toString(), param.get("SLOC").toString(), param.get("WCTID").toString(),
                                        listPartChild.size(), partNumQtyXML, userCred.getUserid());

                            }
                            if (retVal != null && !retVal.equals("")) {
                                msg.put("message", retVal);
                                return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, msg, null);
                            }
                        } else { // jika PART == null di tabel delivery
                            retVal = procAhmpsMovement("-",
                                    param.get("VPLANT").toString(), param.get("SLOC").toString(), param.get("WCTID").toString(),
                                    listPartChild.size(), partNumQtyXML, userCred.getUserid());
                            if (retVal != null && !retVal.equals("")) {
                                msg.put("message", retVal);
                                return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, msg, null);
                            }
                        }
                    } else { // JIKA ENGINE (PARTNO DI DELIV NO KOSONG)
                        retVal = procAhmpsMovement("-",
                                param.get("VPLANT").toString(), param.get("SLOC").toString(), param.get("WCTID").toString(),
                                listPartChild.size(), partNumQtyXML, userCred.getUserid());
                        if (retVal != null && !retVal.equals("")) {
                            msg.put("message", retVal);
                            return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, msg, null);
                        }
                        List<Sfc308VoDetailCase> listGetPartnumSPL = mst351ObjectDao.getPartnumSPL(dataDo.get("type").toString(), param.get("WCTID").toString());
                        for (int i = 0; i < listGetPartnumSPL.size(); i++) {
                            retVal = procSfcPlantWct(param.get("WCTID").toString(), dataDo.get("type").toString(),
                                    listGetPartnumSPL.get(i).getPartNo(), 1, userCred.getUserid(), dataDo.get("color").toString());
                            if (retVal != null && !retVal.equals("")) {
                                msg.put("message", retVal);
                                return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, msg, null);
                            }
                        }
                    }

                }
            }

        } catch (ParseException ex) {
            msg.put("message", ex);
            return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, msg, null);
        }

        msg.put("message", "Data Berhasil Disimpan!");
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, msg, null);
    }

    private String generateXMLParams(List<String> listPartChild) throws IOException {
        List<Sfc308VoDtlXml> listDetail = new ArrayList<Sfc308VoDtlXml>();
        Sfc308VoDtlXml detail;

        for (String partNum : listPartChild) {
            detail = new Sfc308VoDtlXml();
            detail.setVPARTNUM(partNum);
            detail.setVQTY(1 + "");

            listDetail.add(detail);
        }

        Sfc308VoXml voAhmsdmsp130Jaxb = new Sfc308VoXml();
        voAhmsdmsp130Jaxb.setDetailList(listDetail);

        return (jaxbObjectToXML(voAhmsdmsp130Jaxb));
    }

    private String jaxbObjectToXML(Sfc308VoXml voAhmsdmsp130Jaxb) {
        try {
            JAXBContext context = JAXBContext.newInstance(Sfc308VoXml.class);
            Marshaller m = context.createMarshaller();
            // for pretty-print XML in JAXB

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            OutputStream os = new Sfc308VoOS();
            m.marshal(voAhmsdmsp130Jaxb, os);

            return (os.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String procAhmpsMovement(String engineNo, String plantId, String slocId, String wctId, int sizeDataXml, String partNumQtyXML, String userId) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String mvtType = mst351ObjectDao.getMvtType();
        String tempSloc = mst351ObjectDao.getTempSloc(plantId);
        String oprCode = mst351ObjectDao.getOperatorCode(plantId);

        String result = mst351ObjectDao.procAhmpsMovement("19", mvtType,
                sdf.format(new Date()), engineNo, "04", tempSloc, plantId, slocId,
                plantId, "OSL", Integer.parseInt(oprCode), tempSloc, plantId,
                wctId, null, null, sizeDataXml, partNumQtyXML, userId, "0", "0");

        return result;
    }

    public String procSfcPlantWct(String wctId, String typeId, String partNum, int partQty, String userId, String color) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String colorId = color;

        String shift = mst351ObjectDao.callProcGetShift();
        String period = mst351ObjectDao.callProcGetPeriod();
        String result = mst351ObjectDao.procSfcPlantWct("SC_SHPEXPENG", wctId,
                typeId, colorId, partNum, partQty, sdf.format(new Date()),
                shift, period, null, userId, "0", "0");

        return result;

    }

    @Override
    @Transactional(readOnly = false)
    public DtoResponse submitDataJms(Map<String, Object> param, VoPstUserCred userCred, String jxid, String tkid, String token) {
        Map<String, Object> msg = new HashMap<String, Object>();

        boolean checkJMS = mst351ObjectDao.checkJMS();
        if (checkJMS) {
            msg.put("m", "Proses Submit Shipping List sedang berlangsung !");
            return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, msg, null);
        }

        List<String> key = new ArrayList<>();
        key.add("AHMMOSFC308");
        
        param.put("manageServer","jx09");
        VoInputParamJMS inputparam = new VoInputParamJMS();
        inputparam.setAppId("AHMMOSFC308");
        inputparam.setParam(param);
        inputparam.setUrl("/ahmmosfc308-pst/rest/mo/sfc308/submit-data-jms");
        inputparam.setKey(key);
        inputparam.setHdr(token);
        inputparam.setTkid(tkid);
        inputparam.setJxid(jxid);
        DtoResponse dto = jmsService.sendToJms(inputparam);
        return dto;
    }

}
