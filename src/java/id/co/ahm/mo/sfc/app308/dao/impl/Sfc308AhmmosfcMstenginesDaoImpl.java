/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.sfc.app308.dao.impl;

import id.co.ahm.jxf.dao.DefaultHibernateDao;
import id.co.ahm.mo.sfc.app000.model.AhmmosfcMstengines;
import id.co.ahm.mo.sfc.app000.model.AhmmosfcMstenginesPK;
import id.co.ahm.mo.sfc.app308.dao.Sfc308AhmmosfcMstenginesDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author patria
 */
@Repository("sfc308AhmmosfcMstenginesDao")
public class Sfc308AhmmosfcMstenginesDaoImpl extends DefaultHibernateDao<AhmmosfcMstengines, AhmmosfcMstenginesPK> implements Sfc308AhmmosfcMstenginesDao {
    
}
