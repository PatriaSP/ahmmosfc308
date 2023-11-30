package id.co.ahm.mo.sfc.app308.service;

import id.co.ahm.jxf.dto.DtoParamPaging;
import id.co.ahm.jxf.dto.DtoResponse;
import id.co.ahm.jxf.vo.VoPstUserCred;
import java.util.Map;

public interface Sfc308Service {

    public DtoResponse getSlocData(DtoParamPaging param);

    public DtoResponse getWctId(DtoParamPaging param);

    public DtoResponse getCustomer(DtoParamPaging param);

    public DtoResponse getDataDo(DtoParamPaging param);

    public DtoResponse checkCaseId(Map<String,Object> param);

    public DtoResponse getListPart(DtoParamPaging param);

    public DtoResponse submitData(Map<String,Object> param, VoPstUserCred userCred);

    public DtoResponse submitDataJms(Map<String, Object> param, VoPstUserCred userCred, String jxid, String tkid, String token);

}
