/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Kompanija;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import helpers.KompanijaSajam;
import org.primefaces.event.FlowEvent;
import util.dao.AdminDao;
import util.dao.DatumDao;

/**
 *
 * @author dajana
 */
@SessionScoped
@ManagedBean(name = "ControllerAdmin")
public class ControllerAdmin {

    private Date datumOd;
    private Date datumDo;
    private Date datumOdSajam;
    private Date datumDoSajam;
    private ArrayList<KompanijaSajam> kompanijeZaSajam;
    private ArrayList<KompanijaSajam> kompanijePrihvacene;
    private Map<String, String> standovi;
    private String izabranStand;
    private Map<String, String> satnice;

    ///////sajam///////
    private String imesajma;
    private String imesale;
    private Date sajampocetak;
    private Date sajamkraj;
    private String jedanaest, dvanaest, trinaest, cetrnaest, petnaest;
    private boolean skip;

    public ControllerAdmin() {
        kompanijeZaSajam = AdminDao.dodajKompanijeZaSajam();
        kompanijePrihvacene = AdminDao.dodajKompanijePrihvacene();
        standovi = new HashMap<String, String>();
        standovi.put("Mali stand", "Mali stand");
        standovi.put("Sredni stand", "Srednji stand");
        standovi.put("Veliki stand", "Veliki stand");
        standovi.put("Glavni stand", "Glavni stand");

        satnice = new HashMap<String, String>();
        satnice.put("11", "11");
        satnice.put("12", "12");
        satnice.put("13", "13");
        satnice.put("14", "14");
        satnice.put("15", "15");
        satnice.put("16", "16");

    }

    public String izaberiStand(Kompanija k, KompanijaSajam komp) {
        AdminDao.dodajStand(k, k.getId(), k.getNaziv(), komp);
        kompanijePrihvacene.remove(komp);
        return "adminPage?faces-redirect=true";
    }

    public String azurirajCVdatum() {
        if (datumOd.after(datumDo)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datumi nisu pravino uneseni!"));
            return null;
        }
        if (DatumDao.unesiDatume(datumOd, datumDo)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Uspesno promenjen datum za CV!"));
            return null;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Neuspesno promenjen datum!"));
            return null;

        }
    }

    public String azurirajSajamDatum() {
        if (datumOdSajam.after(datumDoSajam)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datumi nisu pravino uneseni!"));
            return null;
        }
        if (DatumDao.unesiDatumeSajam(datumOdSajam, datumDoSajam)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Uspesno promenjen datum za sajam!"));
            return null;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Neuspesno promenjen datum!"));
            return null;

        }
    }

    public String odbij(int id) {
        for (int i = 0; i < kompanijeZaSajam.size(); i++) {
            if (kompanijeZaSajam.get(i).getK().getId() == id) {
                AdminDao.ukloni(kompanijeZaSajam.get(i));
                kompanijeZaSajam.remove(i);
            }
        }
        return "adminPage?faces-redirect=true";
    }

    public String prihvati(int id) {
        for (int i = 0; i < kompanijeZaSajam.size(); i++) {
            if (kompanijeZaSajam.get(i).getK().getId() == id) {
                kompanijePrihvacene.add(kompanijeZaSajam.get(i));
                AdminDao.prihvati(kompanijeZaSajam.get(i));
                kompanijeZaSajam.remove(i);
            }
        }
        return "adminPage?faces-redirect=true";
    }

    public String saveSajam() {
        if (AdminDao.saveSajam(imesajma, imesale, sajampocetak, sajamkraj, jedanaest, dvanaest, trinaest, cetrnaest, petnaest)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Uspesno dodat sajam!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Neuspesno dodat sajam!"));
        }
        return "adminPage?faces-redirect=true";
    }

    public boolean dozvoliSajam() {
        return DatumDao.proveriSajam();
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public Date getDatumOdSajam() {
        return datumOdSajam;
    }

    public void setDatumOdSajam(Date datumOdSajam) {
        this.datumOdSajam = datumOdSajam;
    }

    public Date getDatumDoSajam() {
        return datumDoSajam;
    }

    public void setDatumDoSajam(Date datumDoSajam) {
        this.datumDoSajam = datumDoSajam;
    }

    public ArrayList<KompanijaSajam> getKompanijeZaSajam() {
        return kompanijeZaSajam;
    }

    public void setKompanijeZaSajam(ArrayList<KompanijaSajam> kompanijeZaSajam) {
        this.kompanijeZaSajam = kompanijeZaSajam;
    }

    public ArrayList<KompanijaSajam> getKompanijePrihvacene() {
        return kompanijePrihvacene;
    }

    public void setKompanijePrihvacene(ArrayList<KompanijaSajam> kompanijePrihvacene) {
        this.kompanijePrihvacene = kompanijePrihvacene;
    }

    public Map<String, String> getStandovi() {
        return standovi;
    }

    public void setStandovi(Map<String, String> standovi) {
        this.standovi = standovi;
    }

    public String getIzabranStand() {
        return izabranStand;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public void setIzabranStand(String izabranStand) {
        this.izabranStand = izabranStand;
    }

    public Map<String, String> getSatnice() {
        return satnice;
    }

    public void setSatnice(Map<String, String> satnice) {
        this.satnice = satnice;
    }

    public String getImesajma() {
        return imesajma;
    }

    public void setImesajma(String imesajma) {
        this.imesajma = imesajma;
    }

    public String getImesale() {
        return imesale;
    }

    public void setImesale(String imesale) {
        this.imesale = imesale;
    }

    public Date getSajampocetak() {
        return sajampocetak;
    }

    public void setSajampocetak(Date sajampocetak) {
        this.sajampocetak = sajampocetak;
    }

    public Date getSajamkraj() {
        return sajamkraj;
    }

    public void setSajamkraj(Date sajamkraj) {
        this.sajamkraj = sajamkraj;
    }

    public String getJedanaest() {
        return jedanaest;
    }

    public void setJedanaest(String jedanaest) {
        this.jedanaest = jedanaest;
    }

    public String getDvanaest() {
        return dvanaest;
    }

    public void setDvanaest(String dvanaest) {
        this.dvanaest = dvanaest;
    }

    public String getTrinaest() {
        return trinaest;
    }

    public void setTrinaest(String trinaest) {
        this.trinaest = trinaest;
    }

    public String getCetrnaest() {
        return cetrnaest;
    }

    public void setCetrnaest(String cetrnaest) {
        this.cetrnaest = cetrnaest;
    }

    public String getPetnaest() {
        return petnaest;
    }

    public void setPetnaest(String petnaest) {
        this.petnaest = petnaest;
    }

}
