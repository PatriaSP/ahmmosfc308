/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app000.model;

import id.co.ahm.jxf.model.DefaultEntityImpl;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author patria
 */
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name="MSTENGINES")
public class AhmmosfcMstengines extends DefaultEntityImpl implements Serializable{
    
    @EmbeddedId
    private AhmmosfcMstenginesPK ahmmosfcMstenginesPk;
    
    @Column(name = "RTYPE_VMCTYPEID")
    private String rtypevmctypeid;
    
    @Column(name = "MSTOR_MPLANT_VPLANTID")
    private String mstormplantvplantid;
    
    @Column(name = "MSTOR_VSLOCID")
    private String mstorvslocid;
    
    @Column(name = "DSET_RSET_VID_DSTENG")
    private String dsetrsetviddsteng;
    
    @Column(name = "DSET_VITEMCODE_DSTENG")
    private String dsetvitemcodedsteng;
    
    @Column(name = "DSET_RSET_VID")
    private String dsetrsetvid;
    
    @Column(name = "DSET_VITEMCODE")
    private String dsetvitemcode;
    
    @Column(name = "NENGID")
    private String nengid;
    
    @Column(name = "VFLAGSPASS")
    private String vflagspass;
    
    @Column(name = "VFLAGBLOCK")
    private String vflagblock;
    
    @Column(name = "VFLGSCRP")
    private String vflgscrp;
    
    @Column(name = "VFLGPRINT")
    private String vflgprint;
    
    @Column(name = "VMASKING")
    private String vmasking;

    public AhmmosfcMstenginesPK getaAhmmosfcMstenginesPk() {
        return ahmmosfcMstenginesPk;
    }

    public void setaAhmmosfcMstenginesPk(AhmmosfcMstenginesPK ahmmosfcMstenginesPk) {
        this.ahmmosfcMstenginesPk = ahmmosfcMstenginesPk;
    }

    public String getRtypevmctypeid() {
        return rtypevmctypeid;
    }

    public void setRtypevmctypeid(String rtypevmctypeid) {
        this.rtypevmctypeid = rtypevmctypeid;
    }

    public String getMstormplantvplantid() {
        return mstormplantvplantid;
    }

    public void setMstormplantvplantid(String mstormplantvplantid) {
        this.mstormplantvplantid = mstormplantvplantid;
    }

    public String getMstorvslocid() {
        return mstorvslocid;
    }

    public void setMstorvslocid(String mstorvslocid) {
        this.mstorvslocid = mstorvslocid;
    }

    public String getDsetrsetviddsteng() {
        return dsetrsetviddsteng;
    }

    public void setDsetrsetviddsteng(String dsetrsetviddsteng) {
        this.dsetrsetviddsteng = dsetrsetviddsteng;
    }

    public String getDsetvitemcodedsteng() {
        return dsetvitemcodedsteng;
    }

    public void setDsetvitemcodedsteng(String dsetvitemcodedsteng) {
        this.dsetvitemcodedsteng = dsetvitemcodedsteng;
    }

    public String getDsetrsetvid() {
        return dsetrsetvid;
    }

    public void setDsetrsetvid(String dsetrsetvid) {
        this.dsetrsetvid = dsetrsetvid;
    }

    public String getDsetvitemcode() {
        return dsetvitemcode;
    }

    public void setDsetvitemcode(String dsetvitemcode) {
        this.dsetvitemcode = dsetvitemcode;
    }

    public String getNengid() {
        return nengid;
    }

    public void setNengid(String nengid) {
        this.nengid = nengid;
    }

    public String getVflagspass() {
        return vflagspass;
    }

    public void setVflagspass(String vflagspass) {
        this.vflagspass = vflagspass;
    }

    public String getVflagblock() {
        return vflagblock;
    }

    public void setVflagblock(String vflagblock) {
        this.vflagblock = vflagblock;
    }

    public String getVflgscrp() {
        return vflgscrp;
    }

    public void setVflgscrp(String vflgscrp) {
        this.vflgscrp = vflgscrp;
    }

    public String getVflgprint() {
        return vflgprint;
    }

    public void setVflgprint(String vflgprint) {
        this.vflgprint = vflgprint;
    }

    public String getVmasking() {
        return vmasking;
    }

    public void setVmasking(String vmasking) {
        this.vmasking = vmasking;
    }
    
}
