/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import util.dao.UserDao;

/**
 *
 * @author dajana
 */
@ManagedBean(name = "RegistracijaAdministrator")
@SessionScoped
public class RegistracijaAdministrator implements Serializable {
    private String username;
    private String password;
    private String ponovljenPassword;
    private String ime, prezime, email;
    private String telefon;
    
    public String registracija(){
        try {
            if(UserDao.proveriUsername(username)){                
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, " Try another username", null));
                return null;
            }
            
            if(!UserDao.unesiAdministrator(username, password, ime, prezime, telefon, email)){
                return "error";
            }
             return "login?faces-redirect=true";
        } catch (SQLException ex) {            
            return "error";
        }
       
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPonovljenPassword() {
        return ponovljenPassword;
    }

    public void setPonovljenPassword(String ponovljenPassword) {
        this.ponovljenPassword = ponovljenPassword;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    } 
    
    
    
}
