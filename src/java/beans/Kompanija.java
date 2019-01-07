package beans;

/**
 *
 * @author dajana
 */
public class Kompanija {
    private String username;
    private int password;
    private String email, sajt, specijalnost,kompanija, ime, prezime;
    private int broj_zaposlenih,PIB;
    private int delatnost;

    public Kompanija(String username, int password, String email, String sajt, String specijalnost, String kompanija, String ime, String prezime, int broj_zaposlenih, int PIB, int delatnost) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.sajt = sajt;
        this.specijalnost = specijalnost;
        this.kompanija = kompanija;
        this.ime = ime;
        this.prezime = prezime;
        this.broj_zaposlenih = broj_zaposlenih;
        this.PIB = PIB;
        this.delatnost = delatnost;
    }

    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSajt() {
        return sajt;
    }

    public void setSajt(String sajt) {
        this.sajt = sajt;
    }

    public String getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(String specijalnost) {
        this.specijalnost = specijalnost;
    }

    public String getKompanija() {
        return kompanija;
    }

    public void setKompanija(String kompanija) {
        this.kompanija = kompanija;
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

    public int getBroj_zaposlenih() {
        return broj_zaposlenih;
    }

    public void setBroj_zaposlenih(int broj_zaposlenih) {
        this.broj_zaposlenih = broj_zaposlenih;
    }

    public int getPIB() {
        return PIB;
    }

    public void setPIB(int PIB) {
        this.PIB = PIB;
    }

    public int getDelatnost() {
        return delatnost;
    }

    public void setDelatnost(int delatnost) {
        this.delatnost = delatnost;
    }
    
    
    
    
    
}
