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
    public String imeKompanije, grad, delatnost;
    public List<Kompanija> kompanije;
    
    
    public void pretraziIme(){      
        kompanije = KompanijaDao.pretraziKompanijePoImenu(imeKompanije);     
    }
    
    public void pretraziGrad(){
        kompanije = KompanijaDao.pretraziKompanijePoGradu(grad);
    }
    
    public void pretraziDelatnost(){
        kompanije = KompanijaDao.pretraziKompanijePoDelatnosti(delatnost);
    }

    public String getDelatnost() {
        return delatnost;
    }

    public void setDelatnost(String delatnost) {
        this.delatnost = delatnost;
    }

    
    
    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
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
