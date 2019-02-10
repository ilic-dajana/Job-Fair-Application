/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Kompanija;
import helpers.KompanijaKonkurs;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.dao.DatumDao;
import util.dao.KompanijaDao;

/**
 *
 * @author dajana
 */
@ManagedBean(name = "student")
@SessionScoped
public class ControllerStudent {
    
    private String kompanija;
    private String pozicija;
    private String tipPretrageKonkursa;
    private List<Kompanija> kompanijeZaPretragu = new ArrayList<>();
    private List<KompanijaKonkurs> konkursiPretrage = new ArrayList<>();
    
    public String traziKonkurse(){
        konkursiPretrage = KompanijaDao.pretraziKonkurse(pozicija, tipPretrageKonkursa);
        return "studentPage?faces-redirect=true";
    }
    public String traziKompanije(){
        kompanijeZaPretragu = KompanijaDao.pretraziKompanijePoImenu(kompanija);
        return "studentPage?faces-redirect=true";
    }
     


    public List<Kompanija> getKompanijeZaPretragu() {
        return kompanijeZaPretragu;
    }

    public void setKompanijeZaPretragu(List<Kompanija> kompanijeZaPretragu) {
        this.kompanijeZaPretragu = kompanijeZaPretragu;
    }
        
    
    public boolean mozeCV(){
        Date danas = Calendar.getInstance().getTime();
        
        if(DatumDao.proveriDatumeCV(danas)){
           return true; 
        }
        return false;
    }

    public String getKompanija() {
        return kompanija;
    }

    public void setKompanija(String kompanija) {
        this.kompanija = kompanija;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public String getTipPretrageKonkursa() {
        return tipPretrageKonkursa;
    }

    public void setTipPretrageKonkursa(String tipPretrageKonkursa) {
        this.tipPretrageKonkursa = tipPretrageKonkursa;
    }

    public List<KompanijaKonkurs> getKonkursiPretrage() {
        return konkursiPretrage;
    }

    public void setKonkursiPretrage(List<KompanijaKonkurs> konkursiPretrage) {
        this.konkursiPretrage = konkursiPretrage;
    }
   
}
