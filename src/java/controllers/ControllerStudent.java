/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Kompanija;
import beans.Konkurs;
import beans.Ocenjivanje;
import beans.Zaposlenje;
import helpers.KompanijaKonkurs;
import helpers.Ocena;
import helpers.PrijaveStudenti;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import util.dao.DatumDao;
import util.dao.KompanijaDao;
import util.dao.StudentDao;

/**
 * 
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
    private String coverletter;
    private List<PrijaveStudenti> lista;
    private Konkurs k; 
    private List<Ocena> ocenjivanje;
    private List<Ocena> ocenjeno;
    
    public String ocenjivanje(){
        ocenjivanje = StudentDao.ocenjivanje();
        return "ocenjivanje?faces-redirect=true";
    }
    
    public String unesiOcene(){
        StudentDao.unesiOcene(ocenjivanje); 
        ocenjivanje.clear();
        ocenjeno = StudentDao.dohOcenjeno();
        return "ocenjivanje?faces-redirect=true";
    }
    
    public String prijaviKonkurs(){
        if(StudentDao.prijaviKonkurs(k, coverletter)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Uspesna prijava na konkurs!"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Neuspesna prijava na konkurs!Probajte drugi konkurs!"));

        }
        return null;
    }
    public String traziKonkurse(){
        konkursiPretrage = KompanijaDao.pretraziKonkurse(pozicija, tipPretrageKonkursa);
        return "studentPage?faces-redirect=true";
    }
    public String traziKompanije(){
        kompanijeZaPretragu = KompanijaDao.pretraziKompanijePoImenu(kompanija);
        return "studentPage?faces-redirect=true";
    }
    
    public String postaviKonkurs(Konkurs k){
        this.k = k;
        return "prijavakonkurs?faces-redirect=true";
    }
   
    public void dohvatiMojePrijave(){
       lista = StudentDao.dohvatiPrijave();
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

    public Konkurs getK() {
        return k;
    }

    public void setK(Konkurs k) {
        this.k = k;
    }

    public void setKompanija(String kompanija) {
        this.kompanija = kompanija;
    }

    public String getPozicija() {
        return pozicija;
    }

    public List<PrijaveStudenti> getLista() {
        return lista;
    }

    public void setLista(List<PrijaveStudenti> lista) {
        this.lista = lista;
    }

    
    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public String getTipPretrageKonkursa() {
        return tipPretrageKonkursa;
    }

    public List<Ocena> getOcenjivanje() {
        return ocenjivanje;
    }

    public List<Ocena> getOcenjeno() {
        return ocenjeno;
    }

    public void setOcenjeno(List<Ocena> ocenjeno) {
        this.ocenjeno = ocenjeno;
    }
    
    public void setOcenjivanje(List<Ocena> ocenjivanje) {
        this.ocenjivanje = ocenjivanje;
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

    public String getCoverletter() {
        return coverletter;
    }

    public void setCoverletter(String coverletter) {
        this.coverletter = coverletter;
    }
    
    
   
}
