/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Biografija;
import helpers.Education;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import util.dao.StudentDao;

/**
 *
 * @author dajana
 */
@ManagedBean(name = "cv")
@SessionScoped
public class ControllerCV {

    private String telefon;
    private List<String> webSites = new ArrayList<>();
    private String adresa, grad, drzava;
    private List<String> maternjiJezik = new ArrayList<String>();
    private List<String> straniJezik = new ArrayList<String>();
    private String communication;
    private String organisation;
    private String skills;
    private String ime, prezime;
    private Integer postanskiBr;
    private Map<String, String> moguciJezici;
    private List<Education> obrazovanja = new ArrayList<Education>();
    private List<Education> poslovi = new ArrayList<Education>();
    
    public ControllerCV() {
        moguciJezici = new HashMap<String, String>();
        moguciJezici.put("Srpski jezik", "Srpski jezik");
        moguciJezici.put("Engleski jezik", "Engleski jezik");
        moguciJezici.put("Francuski jezik", "Francuski jezik");
        moguciJezici.put("Nemacki jezik", "Nemacki jezik");
        moguciJezici.put("Spanski jezik", "Spanski jezik");
        moguciJezici.put("Finski jezik", "Finski jezik");
        moguciJezici.put("Ruski jezik", "Ruski jezik");
        moguciJezici.put("Norveski jezik", "Norveski jezik");
    }
    
    public String unesi(){
        if(StudentDao.unesiCV(ime,prezime,communication, organisation,skills,obrazovanja,poslovi,adresa, 
               postanskiBr,grad, drzava, telefon,webSites, maternjiJezik, straniJezik ))
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Uspesno ste uneli CV"));
        return null;
    }
    
    public String dopuniCV(){
        if(StudentDao.proveriCV()){
             Biografija b = StudentDao.dohBiografiju();
             telefon = b.getTelefon();
             ime = b.getIme();
             prezime = b.getPrezime();
             communication = b.getCommunicationSkills();
             organisation = b.getOrganisationalSkills();
             skills = b.getJobrelatedSkills();
             postanskiBr = b.getPostanskiBr();
             adresa = b.getAdresa();
             grad = b.getGrad();
             drzava = b.getDrzava();
             webSites = StudentDao.dohSajtove(b.getIdstudent());
             obrazovanja = StudentDao.dohObrazovanja(b.getIdstudent());
             poslovi = StudentDao.dohPoslovi(b.getIdstudent());
             maternjiJezik = StudentDao.dohMaternji(b.getIdstudent());
             straniJezik = StudentDao.dohStrani(b.getIdstudent());
        }
        return null;
    }
    public String addJob() {
        poslovi.add(new Education());
        return null;
    }

    public String ukloniJob(int i) {
        poslovi.remove(i);
        return null;
    }
    public String addEd() {
        obrazovanja.add(new Education());
        return null;
    }

    public String ukloniEd(int i) {
        obrazovanja.remove(i);
        return null;
    }

    public String addmatJez() {
        maternjiJezik.add("");
        return null;
    }

    public String addstrJez() {
        straniJezik.add("");
        return null;
    }

    public String ukloniStr(int i) {
        straniJezik.remove(i);
        return null;
    }

    public String ukloniMat(int i) {
        maternjiJezik.remove(i);
        return null;
    }

    public String addWeb() {
        webSites.add("");
        return null;
    }

    public String ukloniWeb(int e) {
        webSites.remove(e);
        return null;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<String> getWebSites() {
        return webSites;
    }

    public void setWebSites(List<String> webSites) {
        this.webSites = webSites;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Education> getPoslovi() {
        return poslovi;
    }

    public void setPoslovi(List<Education> poslovi) {
        this.poslovi = poslovi;
    }
    

    public Integer getPostanskiBr() {
        return postanskiBr;
    }

    public void setPostanskiBr(Integer postanskiBr) {
        this.postanskiBr = postanskiBr;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public List<String> getMaternjiJezik() {
        return maternjiJezik;
    }

    public void setMaternjiJezik(List<String> maternjiJezik) {
        this.maternjiJezik = maternjiJezik;
    }

    public List<String> getStraniJezik() {
        return straniJezik;
    }

    public void setStraniJezik(List<String> straniJezik) {
        this.straniJezik = straniJezik;
    }

    public String getCommunication() {
        return communication;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Map<String, String> getMoguciJezici() {
        return moguciJezici;
    }

    public void setMoguciJezici(Map<String, String> moguciJezici) {
        this.moguciJezici = moguciJezici;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    
    public List<Education> getObrazovanja() {
        return obrazovanja;
    }

    public void setObrazovanja(List<Education> obrazovanja) {
        this.obrazovanja = obrazovanja;
    }

}
