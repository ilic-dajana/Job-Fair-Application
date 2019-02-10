/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import beans.Kompanija;
import beans.Konkurs;

/**
 *
 * @author dajana
 */
public class KompanijaKonkurs {
    private Kompanija kompanija;
    private Konkurs konkurs;

    public KompanijaKonkurs() {
    }

    public KompanijaKonkurs(Kompanija kompanija, Konkurs konkurs) {
        this.kompanija = kompanija;
        this.konkurs = konkurs;
    }
    
    
    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }

    public Konkurs getKonkurs() {
        return konkurs;
    }

    public void setKonkurs(Konkurs konkurs) {
        this.konkurs = konkurs;
    }
    
    
}
