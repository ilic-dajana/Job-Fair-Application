package beans;
// Generated Feb 10, 2019 3:24:42 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="User"
    ,catalog="job_fair"
    , uniqueConstraints = @UniqueConstraint(columnNames="username") 
)
public class User  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String password;
     private Administrator administrator;
     private Student student;
     private Kompanija kompanija;

    public User() {
    }

	
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, Administrator administrator, Student student, Kompanija kompanija) {
       this.username = username;
       this.password = password;
       this.administrator = administrator;
       this.student = student;
       this.kompanija = kompanija;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="username", unique=true, nullable=false, length=32)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=64)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="user")
    public Administrator getAdministrator() {
        return this.administrator;
    }
    
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="user")
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="user")
    public Kompanija getKompanija() {
        return this.kompanija;
    }
    
    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }




}


