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
    private int[] counter;
    private boolean flagRegister = true;
    private String messageRegister;
    
    public String registracija(){
        try {
             if(UserDao.proveriUsername(username)){                
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username vec postoji!", null));
                return  null;
            }
             counter = UserDao.brojacSlovaIBrojeva(password);
             
            try {
                messageRegister = UserDao.unesiStudent(username, password, ime, prezime, telefon, email, godinaStudija, diplomirao);
            } catch (SQLException ex) {
                Logger.getLogger(RegistracijaStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(messageRegister == ""){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(username, username);
                return "login?faces-redirect=true";
            }
            else{
                 FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, messageRegister, null));
                return  null;
            }
             
         
            
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

    public int[] getCounter() {
        return counter;
    }

    public void setCounter(int[] counter) {
        this.counter = counter;
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

    public boolean isFlagRegister() {
        return flagRegister;
    }

    public void setFlagRegister(boolean flagRegister) {
        this.flagRegister = flagRegister;
    }

    public String getMessageRegister() {
        return messageRegister;
    }

    public void setMessageRegister(String messageRegister) {
        this.messageRegister = messageRegister;
    }

    
    
    
    
}
