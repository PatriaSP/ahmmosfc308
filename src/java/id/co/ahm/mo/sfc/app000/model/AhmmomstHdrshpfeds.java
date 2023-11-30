/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app000.model;

import id.co.ahm.jxf.model.DefaultEntityImpl;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author george
 */
@Table(name = "HDRSHPFEDS")
@Entity
public class AhmmomstHdrshpfeds extends DefaultEntityImpl implements Serializable {

    @EmbeddedId
    private AhmmomstHdrshpfedsPK ahmmomstHdrshpfedsPK;
    @Column(name = "DSHIPACT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dshipact;
    @Column(name = "DSHIPPOST", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dshippost;
    @Column(name = "VNODO", nullable = false)
    private String vnodo;
    @Column(name = "NSHIPQTY", nullable = false)
    private BigDecimal nshipqty;
    @Column(name = "VPOLICENO", nullable = false)
    private String vpoliceno;
    @Column(name = "NNETT", nullable = false)
    private BigDecimal nnet;
    @Column(name = "NGROSS", nullable = false)
    private BigDecimal ngross;
    @Column(name = "VMEASUREMENT", nullable = false)
    private String vmeasurement;
    @Column(name = "DETD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date detd;
    @Column(name = "DETA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deta;
    @Column(name = "ID_CSAREA")
    private String idCsarea;
    @Column(name = "CSAREA")
    private String csarea;
    @Column(name = "DSHIPPROC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dshipproc;
    @Column(name = "DSET_RSET_VID", nullable = false)
    private String dsetRsetVid;
    @Column(name = "DSET_VITEMCODE", nullable = false)
    private String dsetVitemcode;
    @Column(name = "MCATEG_DSET_RSET_VID")
    private String mcategDsetRsetVid;
    @Column(name = "MCATEG_DSET_VITEMCODE")
    private String mcategDsetVitemcode;
    @Column(name = "MPACK_RSET_VID")
    private String mpackRsetVid;
    @Column(name = "MPACK_VITEMCODE")
    private String mpackVitemcode;
    @Column(name = "DSET_RSET_VID_BFLINV")
    private String dsetRsetVidBflinv;
    @Column(name = "DSET_VITEMCODE_BFLINV")
    private String dsetVitemcodeBflinv;
    @OneToMany(mappedBy="ahmmomstHdrshpfeds",orphanRemoval=true,cascade= CascadeType.ALL)
    List<AhmmomstDtlshpfeds> ahmmomstDtlshpfedses;

    public AhmmomstHdrshpfedsPK getAhmmomstHdrshpfedsPK() {
        return ahmmomstHdrshpfedsPK;
    }

    public void setAhmmomstHdrshpfedsPK(AhmmomstHdrshpfedsPK ahmmomstHdrshpfedsPK) {
        this.ahmmomstHdrshpfedsPK = ahmmomstHdrshpfedsPK;
    }

    public Date getDshipact() {
        return dshipact;
    }

    public void setDshipact(Date dshipact) {
        this.dshipact = dshipact;
    }

    public Date getDshippost() {
        return dshippost;
    }

    public void setDshippost(Date dshippost) {
        this.dshippost = dshippost;
    }

    public String getVnodo() {
        return vnodo;
    }

    public void setVnodo(String vnodo) {
        this.vnodo = vnodo;
    }

    public BigDecimal getNshipqty() {
        return nshipqty;
    }

    public void setNshipqty(BigDecimal nshipqty) {
        this.nshipqty = nshipqty;
    }

    public String getVpoliceno() {
        return vpoliceno;
    }

    public void setVpoliceno(String vpoliceno) {
        this.vpoliceno = vpoliceno;
    }

    public BigDecimal getNnet() {
        return nnet;
    }

    public void setNnet(BigDecimal nnet) {
        this.nnet = nnet;
    }

    public BigDecimal getNgross() {
        return ngross;
    }

    public void setNgross(BigDecimal ngross) {
        this.ngross = ngross;
    }

    public String getVmeasurement() {
        return vmeasurement;
    }

    public void setVmeasurement(String vmeasurement) {
        this.vmeasurement = vmeasurement;
    }

    public Date getDetd() {
        return detd;
    }

    public void setDetd(Date detd) {
        this.detd = detd;
    }

    public Date getDeta() {
        return deta;
    }

    public void setDeta(Date deta) {
        this.deta = deta;
    }

    public String getIdCsarea() {
        return idCsarea;
    }

    public void setIdCsarea(String idCsarea) {
        this.idCsarea = idCsarea;
    }

    public String getCsarea() {
        return csarea;
    }

    public void setCsarea(String csarea) {
        this.csarea = csarea;
    }

    public Date getDshipproc() {
        return dshipproc;
    }

    public void setDshipproc(Date dshipproc) {
        this.dshipproc = dshipproc;
    }

    public String getDsetRsetVid() {
        return dsetRsetVid;
    }

    public void setDsetRsetVid(String dsetRsetVid) {
        this.dsetRsetVid = dsetRsetVid;
    }

    public String getDsetVitemcode() {
        return dsetVitemcode;
    }

    public void setDsetVitemcode(String dsetVitemcode) {
        this.dsetVitemcode = dsetVitemcode;
    }

    public String getMcategDsetRsetVid() {
        return mcategDsetRsetVid;
    }

    public void setMcategDsetRsetVid(String mcategDsetRsetVid) {
        this.mcategDsetRsetVid = mcategDsetRsetVid;
    }

    public String getMcategDsetVitemcode() {
        return mcategDsetVitemcode;
    }

    public void setMcategDsetVitemcode(String mcategDsetVitemcode) {
        this.mcategDsetVitemcode = mcategDsetVitemcode;
    }

    public String getMpackRsetVid() {
        return mpackRsetVid;
    }

    public void setMpackRsetVid(String mpackRsetVid) {
        this.mpackRsetVid = mpackRsetVid;
    }

    public String getMpackVitemcode() {
        return mpackVitemcode;
    }

    public void setMpackVitemcode(String mpackVitemcode) {
        this.mpackVitemcode = mpackVitemcode;
    }

    public String getDsetRsetVidBflinv() {
        return dsetRsetVidBflinv;
    }

    public void setDsetRsetVidBflinv(String dsetRsetVidBflinv) {
        this.dsetRsetVidBflinv = dsetRsetVidBflinv;
    }

    public String getDsetVitemcodeBflinv() {
        return dsetVitemcodeBflinv;
    }

    public void setDsetVitemcodeBflinv(String dsetVitemcodeBflinv) {
        this.dsetVitemcodeBflinv = dsetVitemcodeBflinv;
    }

    public List<AhmmomstDtlshpfeds> getAhmmomstDtlshpfedses() {
        return ahmmomstDtlshpfedses;
    }

    public void setAhmmomstDtlshpfedses(List<AhmmomstDtlshpfeds> ahmmomstDtlshpfedses) {
        this.ahmmomstDtlshpfedses = ahmmomstDtlshpfedses;
    }
    
}
