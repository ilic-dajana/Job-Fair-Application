package beans;
// Generated Jan 29, 2019 2:48:52 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Administrator generated by hbm2java
 */
@Entity
@Table(name="administrator"
    ,catalog="job_fair"
)
public class Administrator  implements java.io.Serializable {


     private int id;
     private User user;
     private String ime;
     private String prezime;
     private String telefon;
     private String email;

    public Administrator() {
    }

    public Administrator(User user, String ime, String prezime, String telefon, String email) {
       this.user = user;
       this.ime = ime;
       this.prezime = prezime;
       this.telefon = telefon;
       this.email = email;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="user"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
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

    
    @Column(name="telefon", nullable=false, length=45)
    public String getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    
    @Column(name="email", nullable=false, length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}


