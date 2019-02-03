/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import util.dao.KompanijaDao;

/**
 *
 * @author dajana
 */
@ManagedBean(name = "kompanija")
@SessionScoped
public class ControllerKompanija {
    private String tip;
    private String pozicija;
    private String opis;
    private Date datumIsteka;

    public String otvoriKonkurs(){
       boolean flag= KompanijaDao.otvoriKonkurs(tip, pozicija, opis, datumIsteka);
       if(flag){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Uspesno ste obajavili konkurs!"));
                
       }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Neuspesna prijava! Pokusajte ponovo", null));
                
       }
       return null;
}   
    
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(Date datumIsteka) {
        this.datumIsteka = datumIsteka;
    }
    
    
    
}
