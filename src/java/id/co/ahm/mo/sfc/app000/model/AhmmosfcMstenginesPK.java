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
public class AhmmosfcMstenginesPK implements Serializable{
    @Column(name = "VENGNO")
    private String vengno;

    public String getVengno() {
        return vengno;
    }

    public void setVengno(String vengno) {
        this.vengno = vengno;
    }
    
}
