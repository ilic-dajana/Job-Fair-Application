/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Kompanija;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.dao.KompanijaDao;

/**
 *
 * @author dajana
 */

@ManagedBean(name = "RegistracijaGost")
@SessionScoped
public class RegistracijaGost implements Serializable {
    public String imeKompanije;
    public List<Kompanija> kompanije;
    
    
    public String pretrazi(){      
        kompanije = KompanijaDao.pretraziKompanije(imeKompanije);
        
        return "proba";
    }
    
    
    public RegistracijaGost(String ime){
        imeKompanije=ime;
    }

    public RegistracijaGost() {
    }

    public String getImeKompanije() {
        return imeKompanije;
    }

    public void setImeKompanije(String imeKompanije) {
        this.imeKompanije = imeKompanije;
    }

    public List<Kompanija> getKompanije() {
        return kompanije;
    }

    public void setKompanije(List<Kompanija> kompanije) {
        this.kompanije = kompanije;
    }
    
    
}
