/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Kompanija;
import beans.Konkurs;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import util.SessionUtils;
import util.dao.DatumDao;
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
    private String paket;
    private ArrayList<Konkurs> konkursi;
    private Kompanija k;
    private int id;
    
    public ControllerKompanija(){
        k = SessionUtils.getUser().getKompanija();
        id = k.getId();
        konkursi = KompanijaDao.dodajKonkurse(id);
    }
    
    public String otvoriKonkurs(){
        
       boolean flag= KompanijaDao.otvoriKonkurs(k, tip, pozicija, opis, datumIsteka);
       
       if(flag){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Uspesno ste obajavili konkurs!"));
            konkursi = KompanijaDao.dodajKonkurse(id);
            return "kompanijaPage?faces-redirect=true";
       }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Neuspesna prijava! Pokusajte ponovo"));
                
       }
       return null;
    }   
    public String prijaviSeNaSajam(){
        if(KompanijaDao.prijaviSajam(paket)){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Uspesno ste se prijavili na sajam!"));

        }else{
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Pokusajte ponovo!"));
        }
        
        return null;
    }
    
    public boolean sajamUToku(){
        Date danas = Calendar.getInstance().getTime();
        
        if(DatumDao.proveriDatumeSajam(danas)){
           return true; 
        }
        return false;
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

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public ArrayList<Konkurs> getKonkursi() {
        return konkursi;
    }

    public void setKonkursi(ArrayList<Konkurs> konkursi) {
        this.konkursi = konkursi;
    }

    public Kompanija getK() {
        return k;
    }

    public void setK(Kompanija k) {
        this.k = k;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
