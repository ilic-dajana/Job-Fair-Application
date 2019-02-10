/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import beans.Biografija;
import java.util.Date;

/**
 *
 * @author dajana
 */
public class Education {
    
     private int id;
     private Biografija biografija;
     private Date dateOd;
     private Date dateDo;
     private int onGoing;
     private String stepen;
     private String fakultet;

    public Education(int id, Biografija biografija, Date dateOd, Date dateDo, int onGoing, String stepen, String fakultet) {
        this.id = id;
        this.biografija = biografija;
        this.dateOd = dateOd;
        this.dateDo = dateDo;
        this.onGoing = onGoing;
        this.stepen = stepen;
        this.fakultet = fakultet;
    }
     
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Biografija getBiografija() {
        return biografija;
    }

    public void setBiografija(Biografija biografija) {
        this.biografija = biografija;
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

    public int getOnGoing() {
        return onGoing;
    }

    public void setOnGoing(int onGoing) {
        this.onGoing = onGoing;
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
