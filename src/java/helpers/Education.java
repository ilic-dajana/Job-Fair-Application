/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;
 
import java.util.Date;

/**
 *
 * @author dajana
 */
public class Education {
         
     private Date dateOd;
     private Date dateDo;
     private String onGoing;
     private String stepen;
     private String fakultet;
     private String pozicija;
     
    public Education(Date dateOd, Date dateDo, String onGoing, String stepen, String fakultet) {
        this.dateOd = dateOd;
        this.dateDo = dateDo;
        this.onGoing = onGoing;
        this.stepen = stepen;
        this.fakultet = fakultet;
    }

    public Education(Date dateOd, Date dateDo, String onGoing, String stepen, String fakultet, String pozicija) {
        this.dateOd = dateOd;
        this.dateDo = dateDo;
        this.onGoing = onGoing;
        this.stepen = stepen;
        this.fakultet = fakultet;
        this.pozicija = pozicija;
    }
    
    

    public Education() {
    }

     
    public Date getDateOd() {
        return dateOd;
    }

    public void setDateOd(Date dateOd) {
        this.dateOd = dateOd;
    }

    public Date getDateDo() {
        return dateDo;
    }

    public void setDateDo(Date dateDo) {
        this.dateDo = dateDo;
    }

    public String getOnGoing() {
        return onGoing;
    }

    public void setOnGoing(String onGoing) {
        this.onGoing = onGoing;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public String getStepen() {
        return stepen;
    }

    public void setStepen(String stepen) {
        this.stepen = stepen;
    }

    public String getFakultet() {
        return fakultet;
    }

    public void setFakultet(String fakultet) {
        this.fakultet = fakultet;
    }

    
     
     
     
}
