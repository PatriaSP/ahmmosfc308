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
@Table(name="HDRXCRLFGS")
public class AhmmotrcHdrxcrlfgs extends DefaultEntityImpl implements Serializable{
    
    @EmbeddedId
    private AhmmotrcHdrxcrlfgsPK ahmmotrcHdrxcrlfgsPk;
    
    @Column(name = "MWCT_VWCTID")
    private String mwctvwct;
    
    @Column(name = "MPART_VPARTNUM")
    private String mpartvpartnum;
    
    @Column(name = "DTXN")
    private String dtxn;
    
    @Column(name = "NQTYLOT")
    private String nqtylot;
    
    @Column(name = "VLOTIDBEF")
    private String vlotidbef;
    
    @Column(name = "VEXPDLVSTAT")
    private String vexpdlvstat;

    public String getVexpdlvstat() {
        return vexpdlvstat;
    }

    public void setVexpdlvstat(String vexpdlvstat) {
        this.vexpdlvstat = vexpdlvstat;
    }

    public AhmmotrcHdrxcrlfgsPK getAhmmotrcHdrxcrlfgsPk() {
        return ahmmotrcHdrxcrlfgsPk;
    }

    public void setAhmmotrcHdrxcrlfgsPk(AhmmotrcHdrxcrlfgsPK ahmmotrcHdrxcrlfgsPk) {
        this.ahmmotrcHdrxcrlfgsPk = ahmmotrcHdrxcrlfgsPk;
    }

    public String getMwctvwct() {
        return mwctvwct;
    }

    public void setMwctvwct(String mwctvwct) {
        this.mwctvwct = mwctvwct;
    }

    public String getMpartvpartnum() {
        return mpartvpartnum;
    }

    public void setMpartvpartnum(String mpartvpartnum) {
        this.mpartvpartnum = mpartvpartnum;
    }

    public String getDtxn() {
        return dtxn;
    }

    public void setDtxn(String dtxn) {
        this.dtxn = dtxn;
    }

    public String getNqtylot() {
        return nqtylot;
    }

    public void setNqtylot(String nqtylot) {
        this.nqtylot = nqtylot;
    }

    public String getVlotidbef() {
        return vlotidbef;
    }

    public void setVlotidbef(String vlotidbef) {
        this.vlotidbef = vlotidbef;
    }
    
}
