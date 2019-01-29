package controllers;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import util.dao.UserDao;

/**
 *
 * @author dajana
 */

@ManagedBean(name = "RegistracijaStudent")
@SessionScoped
public class RegistracijaStudent implements Serializable {
    private String username;
    private String password;
    private String ponovljenPassword;
    private String ime, prezime, email;
    private String telefon;
    private int godinaStudija;
    private int diplomirao;
    private String greskaUsername ="";
    
    public String registracija(){
        try {
             if(UserDao.proveriUsername(username)){                
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, " Try another username", null));
                return  null;
            }
            if(!UserDao.unesiStudent(username, password, ime, prezime, telefon, email, godinaStudija, diplomirao)){
                return "error";
            }
        } catch (SQLException ex) {            
            return "error";
        }
        return "login?faces-redirect=true";
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

    public int getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(int godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public int getDiplomirao() {
        return diplomirao;
    }

    public void setDiplomirao(int diplomirao) {
        this.diplomirao = diplomirao;
    }

    public String getGreskaUsername() {
        return greskaUsername;
    }

    public void setGreskaUsername(String greskaUsername) {
        this.greskaUsername = greskaUsername;
    }

   
    
    
    
    
}
