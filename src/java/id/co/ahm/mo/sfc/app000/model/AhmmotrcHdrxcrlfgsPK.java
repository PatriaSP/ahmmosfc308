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
public class AhmmotrcHdrxcrlfgsPK implements Serializable{
    @Column(name = "VLOTID")
    private String vlotid;

    public String getVlotid() {
        return vlotid;
    }

    public void setVlotid(String vlotid) {
        this.vlotid = vlotid;
    }
    
}
