/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

/**
 *
 * @author dajana
 */
public class Ocena {
    private String firma;
    private String rating;

    public Ocena(String firma, String rating) {
        this.firma = firma;
        this.rating = rating;
    }

    public Ocena() {
    }
    
    
    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
    
}
