/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app000.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author patria
 */
@Embeddable
public class AhmsdmusDtlsipbsPK implements Serializable {

    @Column(name = "VCOL")
    private String vcol;

    @Column(name = "VSIPBNO")
    private String vsipno;

    @Column(name = "VTYPE")
    private String vtype;

    public String getVcol() {
        return vcol;
    }

    public void setVcol(String vcol) {
        this.vcol = vcol;
    }

    public String getVsipno() {
        return vsipno;
    }

    public void setVsipno(String vsipno) {
        this.vsipno = vsipno;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

}
