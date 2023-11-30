/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app000.model;

import id.co.ahm.jxf.model.DefaultEntityImpl;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author patria
 */
@Entity
@Table(name = "DTLSHPFEDS")
public class AhmmomstDtlshpfeds extends DefaultEntityImpl implements Serializable {

    @EmbeddedId
    private AhmmomstDtlshpfedsPK ahmmomstDtlshpfedsPK;
    @Column(name = "MENG_VENGNO")
    private String mengVengno;
    @Column(name = "RTYPE_VMCTYPEID")
    private String rtypeVmctypeid;
    @Column(name = "NQTY", nullable = false)
    private BigDecimal nqty;
    @Column(name = "MCOL_VCOLORID")
    private String mcolVcolorid;
    @JoinColumns({
        @JoinColumn(name = "RSHPFE_NSHIPNO", referencedColumnName = "NSHIPNO",
        insertable = false, updatable = false),
        @JoinColumn(name = "RSHPFE_NSHIPYEAR", referencedColumnName = "NSHIPYEAR",
        insertable = false, updatable = false),
        @JoinColumn(name = "RSHPFE_MSTOR_VSLOCID", referencedColumnName = "MSTOR_VSLOCID",
        insertable = false, updatable = false),
        @JoinColumn(name = "RSHPFE_MSTOR_MPLANT_VPLANTID", referencedColumnName = "MSTOR_MPLANT_VPLANTID",
        insertable = false, updatable = false)
    })
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AhmmomstHdrshpfeds.class)
    private AhmmomstHdrshpfeds ahmmomstHdrshpfeds;
    
    @Column(name = "VCASEID")
    private String vcaseid;

    public String getVcaseid() {
        return vcaseid;
    }

    public void setVcaseid(String vcaseid) {
        this.vcaseid = vcaseid;
    }

    public AhmmomstDtlshpfedsPK getAhmmomstDtlshpfedsPK() {
        return ahmmomstDtlshpfedsPK;
    }

    public void setAhmmomstDtlshpfedsPK(AhmmomstDtlshpfedsPK ahmmomstDtlshpfedsPK) {
        this.ahmmomstDtlshpfedsPK = ahmmomstDtlshpfedsPK;
    }

    public String getMengVengno() {
        return mengVengno;
    }

    public void setMengVengno(String mengVengno) {
        this.mengVengno = mengVengno;
    }

    public String getRtypeVmctypeid() {
        return rtypeVmctypeid;
    }

    public void setRtypeVmctypeid(String rtypeVmctypeid) {
        this.rtypeVmctypeid = rtypeVmctypeid;
    }

    public BigDecimal getNqty() {
        return nqty;
    }

    public void setNqty(BigDecimal nqty) {
        this.nqty = nqty;
    }

    public AhmmomstHdrshpfeds getAhmmomstHdrshpfeds() {
        return ahmmomstHdrshpfeds;
    }

    public void setAhmmomstHdrshpfeds(AhmmomstHdrshpfeds ahmmomstHdrshpfeds) {
        this.ahmmomstHdrshpfeds = ahmmomstHdrshpfeds;
    }

    public String getMcolVcolorid() {
        return mcolVcolorid;
    }

    public void setMcolVcolorid(String mcolVcolorid) {
        this.mcolVcolorid = mcolVcolorid;
    }
}
