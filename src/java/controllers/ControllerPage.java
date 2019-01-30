/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author dajana
 */
@ManagedBean(name = "ControllerPage")
@SessionScoped
public class ControllerPage {

    public ControllerPage() {
    }
    
    public String admin(){
        return "registracijaAdministrator?faces-redirect=true";
    }
    public String student(){
        return "registracijaStudent?faces-redirect=true";
    }
    public String kompanija(){
        return "registracijaKompanija?faces-redirect=true";
    }
}
