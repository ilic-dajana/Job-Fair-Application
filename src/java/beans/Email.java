package beans;
// Generated Feb 3, 2019 8:02:34 PM by Hibernate Tools 4.3.1


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
 * Email generated by hbm2java
 */
@Entity
@Table(name="email"
    ,catalog="job_fair"
)
public class Email  implements java.io.Serializable {


     private int idEmail;
     private Biografija biografija;
     private String email;

    public Email() {
    }

    public Email(Biografija biografija, String email) {
       this.biografija = biografija;
       this.email = email;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="biografija"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="id_email", unique=true, nullable=false)
    public int getIdEmail() {
        return this.idEmail;
    }
    
    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Biografija getBiografija() {
        return this.biografija;
    }
    
    public void setBiografija(Biografija biografija) {
        this.biografija = biografija;
    }

    
    @Column(name="email", nullable=false, length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}

