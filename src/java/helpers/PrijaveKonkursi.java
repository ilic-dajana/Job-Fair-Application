/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import beans.Biografija;
import beans.Konkurs;
import beans.Prijavanakonkurs;

/**
 *
 * @author dajana
 */
public class PrijaveKonkursi {
    Konkurs konkurs;
    Prijavanakonkurs prijava;
    Biografija b;
    
    public Konkurs getKonkurs() {
        return konkurs;
    }

    public void setKonkurs(Konkurs konkurs) {
        this.konkurs = konkurs;
    }

    public Prijavanakonkurs getPrijava() {
        return prijava;
    }

    public void setPrijava(Prijavanakonkurs prijava) {
        this.prijava = prijava;
    }

    public Biografija getB() {
        return b;
    }

    public void setB(Biografija b) {
        this.b = b;
    }
    
    
}
