/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app000.model;

import id.co.ahm.jxf.model.DefaultEntityImpl;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="DTLSIPBS")
public class AhmsdmusDtlsipbs extends DefaultEntityImpl implements Serializable{
    
    @EmbeddedId
    private AhmsdmusDtlsipbsPK ahmsdmusDtlsipbsPK;
        
    @Column(name = "IQTY")
    private BigDecimal iqty;
    
    @Column(name = "IQTYSHIP")
    private BigDecimal iqtyship;
    
    @Column(name = "VPACK")
    private String vpack;
    
    @Column(name = "IQTYORI")
    private BigDecimal iqtyori;
    
    @Column(name = "MORI")
    private BigDecimal mori;
    
    @Column(name = "MREV")
    private BigDecimal mrev;
    
    @Column(name = "MPPNORI")
    private BigDecimal mppnori;
    
    @Column(name = "MPPNREV")
    private BigDecimal mppnrev;
    
    @Column(name = "MPPHORI")
    private BigDecimal mpphori;
    
    @Column(name = "MPPHREV")
    private BigDecimal mpphrev;
    
    @Column(name = "IREVISE")
    private BigDecimal irevise;

    public AhmsdmusDtlsipbsPK getAhmsdmusDtlsipbsPK() {
        return ahmsdmusDtlsipbsPK;
    }

    public void setAhmsdmusDtlsipbsPK(AhmsdmusDtlsipbsPK ahmsdmusDtlsipbsPK) {
        this.ahmsdmusDtlsipbsPK = ahmsdmusDtlsipbsPK;
    }

    public BigDecimal getIqty() {
        return iqty;
    }

    public void setIqty(BigDecimal iqty) {
        this.iqty = iqty;
    }

    public BigDecimal getIqtyship() {
        return iqtyship;
    }

    public void setIqtyship(BigDecimal iqtyship) {
        this.iqtyship = iqtyship;
    }

    public String getVpack() {
        return vpack;
    }

    public void setVpack(String vpack) {
        this.vpack = vpack;
    }

    public BigDecimal getIqtyori() {
        return iqtyori;
    }

    public void setIqtyori(BigDecimal iqtyori) {
        this.iqtyori = iqtyori;
    }

    public BigDecimal getMori() {
        return mori;
    }

    public void setMori(BigDecimal mori) {
        this.mori = mori;
    }

    public BigDecimal getMrev() {
        return mrev;
    }

    public void setMrev(BigDecimal mrev) {
        this.mrev = mrev;
    }

    public BigDecimal getMppnori() {
        return mppnori;
    }

    public void setMppnori(BigDecimal mppnori) {
        this.mppnori = mppnori;
    }

    public BigDecimal getMppnrev() {
        return mppnrev;
    }

    public void setMppnrev(BigDecimal mppnrev) {
        this.mppnrev = mppnrev;
    }

    public BigDecimal getMpphori() {
        return mpphori;
    }

    public void setMpphori(BigDecimal mpphori) {
        this.mpphori = mpphori;
    }

    public BigDecimal getMpphrev() {
        return mpphrev;
    }

    public void setMpphrev(BigDecimal mpphrev) {
        this.mpphrev = mpphrev;
    }

    public BigDecimal getIrevise() {
        return irevise;
    }

    public void setIrevise(BigDecimal irevise) {
        this.irevise = irevise;
    }
    
}
