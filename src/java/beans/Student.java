package beans;

/**
 *
 * @author dajana
 */
public class Student {
    private String username;
    private int password;
    private int ponovljenPassword;
    private String ime, prezime, email;
    private int telefon;
    private int godinaStudija;
    private int diplomirao;

    public Student(String username, int password, int ponovljenPassword, String ime, String prezime, String email, int telefon, int godinaStudija, int diplomirao) {
        this.username = username;
        this.password = password;
        this.ponovljenPassword = ponovljenPassword;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
        this.godinaStudija = godinaStudija;
        this.diplomirao = diplomirao;
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
    
    
    
    
}
