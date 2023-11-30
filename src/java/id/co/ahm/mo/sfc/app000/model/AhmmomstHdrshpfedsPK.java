/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app000.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author george
 */
@Embeddable
public class AhmmomstHdrshpfedsPK implements Serializable {

    @Column(name = "NSHIPNO", nullable = false)
    private BigDecimal nshipno;
    @Column(name = "NSHIPYEAR", nullable = false)
    private BigDecimal nshipyear;
    @Column(name = "MSTOR_VSLOCID", nullable = false)
    private String mstorVslocid;
    @Column(name = "MSTOR_MPLANT_VPLANTID", nullable = false)
    private String mstorMplantVplantid;

    public BigDecimal getNshipno() {
        return nshipno;
    }

    public void setNshipno(BigDecimal nshipno) {
        this.nshipno = nshipno;
    }

    public BigDecimal getNshipyear() {
        return nshipyear;
    }

    public void setNshipyear(BigDecimal nshipyear) {
        this.nshipyear = nshipyear;
    }

    public String getMstorVslocid() {
        return mstorVslocid;
    }

    public void setMstorVslocid(String mstorVslocid) {
        this.mstorVslocid = mstorVslocid;
    }

    public String getMstorMplantVplantid() {
        return mstorMplantVplantid;
    }

    public void setMstorMplantVplantid(String mstorMplantVplantid) {
        this.mstorMplantVplantid = mstorMplantVplantid;
    }
    
}
