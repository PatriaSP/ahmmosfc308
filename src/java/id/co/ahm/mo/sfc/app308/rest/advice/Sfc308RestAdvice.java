/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app308.rest.advice;

import id.co.ahm.jxf.constant.StatusMsgEnum;
import id.co.ahm.jxf.dto.DtoResponse;
import id.co.ahm.jxf.util.DtoHelper;
import id.co.ahm.mo.sfc.app308.exception.Sfc308Exception;
import id.co.ahm.mo.sfc.app308.rest.Sfc308Rest;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author patria
 */
@ControllerAdvice(basePackageClasses = Sfc308Rest.class)
public class Sfc308RestAdvice {
    private static final String ERROR = "error";
    private static final String SERVER_PROCESSING_ERROR = "Server Processing Error";

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public DtoResponse handleException(Exception e, HttpServletResponse response) {
        e.printStackTrace();
        Map<String, Object> mapMsg = new HashMap<>();
        mapMsg.put(ERROR, SERVER_PROCESSING_ERROR);
        return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, mapMsg, null);
    }

    @ExceptionHandler(Sfc308Exception.class)
    @ResponseBody
    public DtoResponse handleException(Sfc308Exception e, HttpServletResponse response) {
        Map<String, Object> mapMsg = new HashMap<>();
        e.printStackTrace();
        if (e.getListErr().isEmpty()) {
            mapMsg.put(ERROR, e.getMessage());
            return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, mapMsg, null);
        } else {
            return DtoHelper.constructResponse(StatusMsgEnum.GAGAL, null, e.getListErr());
        }
    }
}
