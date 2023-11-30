/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app308.rest;

import id.co.ahm.jxf.constant.CommonConstant;
import id.co.ahm.jxf.constant.StatusMsgEnum;
import id.co.ahm.jxf.dto.DtoParamPaging;
import id.co.ahm.jxf.dto.DtoResponse;
import id.co.ahm.jxf.security.TokenPstUtil;
import id.co.ahm.jxf.util.DtoHelper;
import id.co.ahm.jxf.vo.VoPstUserCred;
import id.co.ahm.mo.sfc.app308.service.Sfc308Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author patria
 */
@Controller
@RequestMapping("mo/sfc308")
public class Sfc308Rest {

    @Autowired
    @Qualifier(value = "tokenPstUtil")
    private TokenPstUtil tokenPstUtil;

    @Autowired
    @Qualifier(value = "sfc308Service")
    private Sfc308Service sfc308Service;

    @RequestMapping(value = "get-user", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getUser(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token) {
        VoPstUserCred vo = tokenPstUtil.getUserCred(token);
        Map<String, Object> data = new HashMap<>();
        data.put("userId", vo.getUserid());
        data.put("userName", vo.getUsername());
        List lst = new ArrayList<>();
        lst.add(data);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, lst);
    }

    @RequestMapping(value = "lov-storage-location", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getSlocData(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return sfc308Service.getSlocData(param);
    }

    @RequestMapping(value = "lov-wct-id", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getWctId(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return sfc308Service.getWctId(param);
    }

    @RequestMapping(value = "lov-customer", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getCustomer(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return sfc308Service.getCustomer(param);
    }

    @RequestMapping(value = "get-do", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getDo(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return sfc308Service.getDataDo(param);
    }

    @RequestMapping(value = "check-case-id", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse checkCaseId(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody Map<String,Object> param) {
        return sfc308Service.checkCaseId(param);
    }
    
    @RequestMapping(value = "get-list-partnum", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getListPart(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return sfc308Service.getListPart(param);
    }
    
    @RequestMapping(value = "submit-data", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse submitData(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @CookieValue(value = CommonConstant.JXID, defaultValue = "") String jxid,
            @CookieValue(value = CommonConstant.TKID, defaultValue = "") String tkid,
            @RequestBody Map<String,Object> param) {
        return sfc308Service.submitDataJms(param, tokenPstUtil.getUserCred(token), jxid, tkid, token);
    }

    @RequestMapping(value = "submit-data-jms", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse submitDataJms(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody Map<String,Object> param) {
        return sfc308Service.submitData(param, tokenPstUtil.getUserCred(token));
    }
}
