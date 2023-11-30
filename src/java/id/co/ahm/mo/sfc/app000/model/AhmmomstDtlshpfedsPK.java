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
public class AhmmomstDtlshpfedsPK implements Serializable {

    @Column(name = "RSHPFE_NSHIPNO", nullable = false)
    private BigDecimal rshpfeNshipno;
    @Column(name = "RSHPFE_NSHIPYEAR", nullable = false)
    private BigDecimal rshpfeNshipyear;
    @Column(name = "RSHPFE_MSTOR_VSLOCID", nullable = false)
    private String rshpfeMstorVslocid;
    @Column(name = "RSHPFE_MSTOR_MPLANT_VPLANTID", nullable = false)
    private String rshpfeMstorMplantVplantid;
    @Column(name = "MPART_VPARTNUM", nullable = false)
    private String mpartVpartnum;
    @Column(name="NSEQ",nullable=false)
    private BigDecimal nseq;

    public BigDecimal getRshpfeNshipno() {
        return rshpfeNshipno;
    }

    public void setRshpfeNshipno(BigDecimal rshpfeNshipno) {
        this.rshpfeNshipno = rshpfeNshipno;
    }

    public BigDecimal getRshpfeNshipyear() {
        return rshpfeNshipyear;
    }

    public void setRshpfeNshipyear(BigDecimal rshpfeNshipyear) {
        this.rshpfeNshipyear = rshpfeNshipyear;
    }

    public String getRshpfeMstorVslocid() {
        return rshpfeMstorVslocid;
    }

    public void setRshpfeMstorVslocid(String rshpfeMstorVslocid) {
        this.rshpfeMstorVslocid = rshpfeMstorVslocid;
    }

    public String getRshpfeMstorMplantVplantid() {
        return rshpfeMstorMplantVplantid;
    }

    public void setRshpfeMstorMplantVplantid(String rshpfeMstorMplantVplantid) {
        this.rshpfeMstorMplantVplantid = rshpfeMstorMplantVplantid;
    }

    public String getMpartVpartnum() {
        return mpartVpartnum;
    }

    public void setMpartVpartnum(String mpartVpartnum) {
        this.mpartVpartnum = mpartVpartnum;
    }

    public BigDecimal getNseq() {
        return nseq;
    }

    public void setNseq(BigDecimal nseq) {
        this.nseq = nseq;
    }
    
}
