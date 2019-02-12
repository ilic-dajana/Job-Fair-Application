/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import beans.Kompanija;

/**
 *
 * @author dajana
 */
public class KompanijaSajam {
    private Kompanija k;
    private String tip;
    private String stand;
    private Integer vreme;
    private String komentar;
    
    public Kompanija getK() {
        return k;
    }

    public void setK(Kompanija k) {
        this.k = k;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public Integer getVreme() {
        return vreme;
    }

    public void setVreme(Integer vreme) {
        this.vreme = vreme;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
    
    
}
