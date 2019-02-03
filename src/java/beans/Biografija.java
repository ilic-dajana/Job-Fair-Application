package beans;
// Generated Feb 3, 2019 8:02:34 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Biografija generated by hbm2java
 */
@Entity
@Table(name="biografija"
    ,catalog="job_fair"
)
public class Biografija  implements java.io.Serializable {


     private int id;
     private String ime;
     private String prezime;
     private String adresa;
     private int postanskiBr;
     private String drzava;
     private String grad;
     private String tipAplikacije;
     private String maternjiJezik;
     private String straniJezik;
     private String communicationSkills;
     private String organisationalSkills;
     private String jobrelatedSkills;
     private Obrazovanje obrazovanje;
     private Email email;
     private Zaposlenje zaposlenje;
     private Telefon telefon;

    public Biografija() {
    }

	
    public Biografija(int id, String ime, String prezime, String adresa, int postanskiBr, String drzava, String grad, String tipAplikacije, String maternjiJezik, String straniJezik, String communicationSkills, String organisationalSkills, String jobrelatedSkills) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.postanskiBr = postanskiBr;
        this.drzava = drzava;
        this.grad = grad;
        this.tipAplikacije = tipAplikacije;
        this.maternjiJezik = maternjiJezik;
        this.straniJezik = straniJezik;
        this.communicationSkills = communicationSkills;
        this.organisationalSkills = organisationalSkills;
        this.jobrelatedSkills = jobrelatedSkills;
    }
    public Biografija(int id, String ime, String prezime, String adresa, int postanskiBr, String drzava, String grad, String tipAplikacije, String maternjiJezik, String straniJezik, String communicationSkills, String organisationalSkills, String jobrelatedSkills, Obrazovanje obrazovanje, Email email, Zaposlenje zaposlenje, Telefon telefon) {
       this.id = id;
       this.ime = ime;
       this.prezime = prezime;
       this.adresa = adresa;
       this.postanskiBr = postanskiBr;
       this.drzava = drzava;
       this.grad = grad;
       this.tipAplikacije = tipAplikacije;
       this.maternjiJezik = maternjiJezik;
       this.straniJezik = straniJezik;
       this.communicationSkills = communicationSkills;
       this.organisationalSkills = organisationalSkills;
       this.jobrelatedSkills = jobrelatedSkills;
       this.obrazovanje = obrazovanje;
       this.email = email;
       this.zaposlenje = zaposlenje;
       this.telefon = telefon;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="ime", nullable=false, length=45)
    public String getIme() {
        return this.ime;
    }
    
    public void setIme(String ime) {
        this.ime = ime;
    }

    
    @Column(name="prezime", nullable=false, length=45)
    public String getPrezime() {
        return this.prezime;
    }
    
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    
    @Column(name="adresa", nullable=false, length=45)
    public String getAdresa() {
        return this.adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    
    @Column(name="postanski_br", nullable=false)
    public int getPostanskiBr() {
        return this.postanskiBr;
    }
    
    public void setPostanskiBr(int postanskiBr) {
        this.postanskiBr = postanskiBr;
    }

    
    @Column(name="drzava", nullable=false, length=45)
    public String getDrzava() {
        return this.drzava;
    }
    
    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    
    @Column(name="grad", nullable=false, length=45)
    public String getGrad() {
        return this.grad;
    }
    
    public void setGrad(String grad) {
        this.grad = grad;
    }

    
    @Column(name="tip_aplikacije", nullable=false, length=45)
    public String getTipAplikacije() {
        return this.tipAplikacije;
    }
    
    public void setTipAplikacije(String tipAplikacije) {
        this.tipAplikacije = tipAplikacije;
    }

    
    @Column(name="maternji_jezik", nullable=false, length=45)
    public String getMaternjiJezik() {
        return this.maternjiJezik;
    }
    
    public void setMaternjiJezik(String maternjiJezik) {
        this.maternjiJezik = maternjiJezik;
    }

    
    @Column(name="strani_jezik", nullable=false, length=45)
    public String getStraniJezik() {
        return this.straniJezik;
    }
    
    public void setStraniJezik(String straniJezik) {
        this.straniJezik = straniJezik;
    }

    
    @Column(name="communication_skills", nullable=false, length=200)
    public String getCommunicationSkills() {
        return this.communicationSkills;
    }
    
    public void setCommunicationSkills(String communicationSkills) {
        this.communicationSkills = communicationSkills;
    }

    
    @Column(name="organisational_skills", nullable=false, length=200)
    public String getOrganisationalSkills() {
        return this.organisationalSkills;
    }
    
    public void setOrganisationalSkills(String organisationalSkills) {
        this.organisationalSkills = organisationalSkills;
    }

    
    @Column(name="jobrelated_skills", nullable=false, length=200)
    public String getJobrelatedSkills() {
        return this.jobrelatedSkills;
    }
    
    public void setJobrelatedSkills(String jobrelatedSkills) {
        this.jobrelatedSkills = jobrelatedSkills;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="biografija")
    public Obrazovanje getObrazovanje() {
        return this.obrazovanje;
    }
    
    public void setObrazovanje(Obrazovanje obrazovanje) {
        this.obrazovanje = obrazovanje;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="biografija")
    public Email getEmail() {
        return this.email;
    }
    
    public void setEmail(Email email) {
        this.email = email;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="biografija")
    public Zaposlenje getZaposlenje() {
        return this.zaposlenje;
    }
    
    public void setZaposlenje(Zaposlenje zaposlenje) {
        this.zaposlenje = zaposlenje;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="biografija")
    public Telefon getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }




}

