/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author dajana
 */
@ManagedBean(name = "student")
@SessionScoped
public class ControllerStudent {
    private List<String> telefoni = new ArrayList<>();
    private List<String> webSites = new ArrayList<>();
    private String tipApp;
    private List<String> educations = new ArrayList<>();
    private List<String> jobs = new ArrayList<>();
    private String maternjiJezik;
    private String straniJezik;
    private String communication;
    private String organisation;
    private String skills;
    public String addJob(){
        jobs.add("");
        return null;
    }
    
    public String removeJob(int n){
        jobs.remove(n);
        return null;
    }
    public String addEducation(){
        educations.add("");
        return null;
    }
    
    public String removeEducation(int n){
        educations.remove(n);
        return null;
    }
    
    public String addTelephone(){
        telefoni.add("");
        return null;
    }

     
    public String addWeb(){
        webSites.add("");
        return null;
    }
    
    public String removeTelephone(int n){
        telefoni.remove(n);
        return null;
    }
    
    public String removeWeb(int n){
        webSites.remove(n);
        return null;
    }

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }

    public List<String> getEducations() {
        return educations;
    }

    public void setEducations(List<String> educations) {
        this.educations = educations;
    }

    public List<String> getWebSites() {
        return webSites;
    }

    public void setWebSites(List<String> webSites) {
        this.webSites = webSites;
    }
    
     public List<String> getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(List<String> telefoni) {
        this.telefoni = telefoni;
    }

    public String getTipApp() {
        return tipApp;
    }

    public void setTipApp(String tipApp) {
        this.tipApp = tipApp;
    }

    public String getMaternjiJezik() {
        return maternjiJezik;
    }

    public void setMaternjiJezik(String maternjiJezik) {
        this.maternjiJezik = maternjiJezik;
    }

    public String getStraniJezik() {
        return straniJezik;
    }

    public void setStraniJezik(String straniJezik) {
        this.straniJezik = straniJezik;
    }

    public String getCommunication() {
        return communication;
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
    
    
   
}
