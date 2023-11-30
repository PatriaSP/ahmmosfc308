/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app308.exception;

import java.util.List;

/**
 *
 * @author patria
 */
public class Sfc308Exception extends RuntimeException {
    private String errMsg;
    private List<String> listErr;
    
    public Sfc308Exception(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public Sfc308Exception(String errMsg, List<String> listErr) {
        super(errMsg);
        this.errMsg = errMsg;
        this.listErr = listErr;
    }
    
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List<String> getListErr() {
        return listErr;
    }

    public void setListErr(List<String> listErr) {
        this.listErr = listErr;
    }
}
