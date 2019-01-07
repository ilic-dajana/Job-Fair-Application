/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.dao.UserDao;

/**
 *
 * @author dajana
 */
@ManagedBean(name = "RegistracijaAdministrator")
@SessionScoped
public class RegistracijaAdministrator {
    private String username;
    private String password;
    private int ponovljenPassword;
    private String ime, prezime, email;
    private int telefon;
    
    public String registracija(){
        try {
            if(!UserDao.proveriUsername(username)){                
                return "registracijaStudent";
            }
            
            if(!UserDao.unesiAdministrator(username, password, ime, prezime, telefon, email)){
                return "error";
            }
        } catch (SQLException ex) {            
            return "error";
        }
        return "index";
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

    public int getPonovljenPassword() {
        return ponovljenPassword;
    }

    public void setPonovljenPassword(int ponovljenPassword) {
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

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    } 
    
    
    
}
