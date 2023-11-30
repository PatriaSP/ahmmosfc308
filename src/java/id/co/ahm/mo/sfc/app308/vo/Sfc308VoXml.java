/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app308.vo;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author patria
 */
@XmlRootElement(name = "dataReq")
public class Sfc308VoXml {
    private List<Sfc308VoDtlXml> detailList;

    public List<Sfc308VoDtlXml> getDetailList() {
        return detailList;
    }

    // Override the name for the XML element
    @XmlElement(name = "row")
    public void setDetailList(List<Sfc308VoDtlXml> detailList) {
        this.detailList = detailList;
    }
    
}
