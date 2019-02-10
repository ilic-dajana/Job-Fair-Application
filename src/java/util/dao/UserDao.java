package util.dao;

import beans.Administrator;
import beans.Kompanija;
import beans.Prijavanasajam;
import beans.Student;
import beans.User;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author dajana
 */

@ManagedBean(name = "UserDao")
@SessionScoped
public class UserDao {
   
    public static boolean proveriUsername(String username) throws SQLException{
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = null;
       try{
           tx = session.beginTransaction();
           String sqlquery="FROM User WHERE username =:username";
           Query q = session.createQuery(sqlquery);
           q.setString("username", username);
           boolean exists = (q.uniqueResult() != null);
           tx.commit();
           return exists;
       }catch(Exception e){
           if(tx!= null)
               tx.rollback();
           e.printStackTrace();
           return true;
       }finally{
           session.close();
       }     
       
    } 
    
    public static User dohUser(String username){
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String query = "FROM User user WHERE user.username=:username";
            Query q = session.createQuery(query);
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            tx.commit();
            return user;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
}
    }
    
   
    public static String unesiStudent(String username, String password, String ime, String prezime, 
                                     String telefon, String email, int godStudija, int diplomirao) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String message = proveriPassword(password);        
        if(message ==""){
            String pass = hasheFunc(password);
            User user = new User(username, pass);
            Student student = new Student(user, ime, prezime, telefon, email, godStudija, diplomirao);
            user.setStudent(student);
            try{
                tx = session.beginTransaction();
                session.save(student);
                tx.commit();
            }catch(Exception e){
                if(tx != null){
                    tx.rollback();
                }
                e.printStackTrace();
                
            }finally{
                session.close();
            }
        }
        return message;
    }
    
    public static String unesiAdministrator(String username, String password, String ime, String prezime, 
                                     String telefon, String email) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String message = proveriPassword(password);        
        if(message ==""){
            String pass = hasheFunc(password);
            User user = new User(username, pass);
            Administrator admin = new Administrator(user, ime, prezime, telefon, email);
            user.setAdministrator(admin);
            try{
                tx = session.beginTransaction();
                session.save(admin);
                tx.commit();
            }catch(Exception e){
                if(tx != null){
                    tx.rollback();
                }
                e.printStackTrace();
            }finally{
                session.close();
            }
        }
        return message;
        
    }
    
    public static String unesiKompaniju(String username, String password, String kompanija,String grad, String adresa, String ime, String prezime, 
                                     int PIB, int broj_zaposlenih, String email, String sajt, String delatnost, String specijalnost) throws SQLException{
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String message = proveriPassword(password);        
        if(message ==""){
            String pass = hasheFunc(password);
            User user = new User(username, pass);
            Kompanija kompan = new Kompanija(user, kompanija, adresa,ime, prezime, 
                                    PIB, broj_zaposlenih, email, sajt, delatnost, specijalnost,grad);
            Prijavanasajam sajam = new Prijavanasajam(kompan,"bbb", "Neaktivan");
             user.setKompanija(kompan);
             kompan.setPrijavanasajam(sajam);
            try{
                tx = session.beginTransaction();
                session.save(sajam);
                tx.commit();
            }catch(Exception e){
                if(tx != null){
                    tx.rollback();
                }
                e.printStackTrace();
            }finally{
                session.close();
            }
        }
        return message;
        } 
    
    public static boolean promeniPassword(String username, String oldPass, String newPass){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String pass = hasheFunc(newPass);
        
        try{
           tx = session.beginTransaction();
           String sqlquery="SELECT u.id FROM User u WHERE username =:username";
           Query q = session.createQuery(sqlquery);
           q.setString("username", username);
           Object result = q.uniqueResult();
           int id = (int) result;
           User user = (User) session.get(User.class, id);          
           user.setPassword(pass);
           session.update(user); 
         tx.commit();
         return true;
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        } 
    }
    
    
   
    private static String hasheFunc(String password){
        try {
            MessageDigest msg = MessageDigest.getInstance("SHA-256");
            byte[] bytes = msg.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hash = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xff & bytes[i]);
                if (hex.length() == 1)
                    hash.append('0');
                hash.append(hex);
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }    
    }
    
    public static boolean proveriKorisnika(String username, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String pass = hasheFunc(password);
       
        try{
           String sqlquery="FROM User WHERE username =:username";
           Query q = session.createQuery(sqlquery);
           q.setString("username", username);           
           tx = session.beginTransaction();
           if(q.uniqueResult() == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Username nije tacan!"));
              return false;
           }
           sqlquery="FROM User WHERE username =:username AND password =:password";
           q = session.createQuery(sqlquery);
           q.setString("username", username);
           q.setString("password", pass);
           boolean exists = (q.uniqueResult() != null);
           if(exists == false){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Pogresan password!"));
           }
          
           tx.commit();
           return exists;
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        } 
    }
    public static int[] brojacSlovaIBrojeva(String password){
        int counter[] = { 0, 0, 0, 0};
        for(int i = 0; i < password.length(); i++){
            if(Character.isLowerCase(password.charAt(i))){
                counter[0]++;
            }
            if(Character.isUpperCase(password.charAt(i))){
                counter[1]++;
            }
            if(Character.isDigit(password.charAt(i))){
                counter[2]++;
            }
            if(password.charAt(i) == '#' || password.charAt(i) == '*' || password.charAt(i) == '!'
                 ||   password.charAt(i) == '?' || password.charAt(i) == '$' || password.charAt(i) == '.'){
                counter[3]++;
            }
        }
        
        return counter;
    }
    
    public static String proveriPassword(String password){
        int counter []= new int[4];
        counter = brojacSlovaIBrojeva(password);
        
        if(12 >= password.length() && password.length() >= 8){
            if(counter[0] >= 3){
                if(counter[1] >= 1){
                    if(counter[2] >= 1){
                        if(counter[3] >= 1){
                           if(Character.isLetter(password.charAt(0))){
                               return "";
                           }
                           else
                               return "Password mora poceti slovnim karakterom!";
                        }
                        else
                            return "Password mora imati bar jedan specijalni karakter iz skupa {#,!,*,.,?,$}";
                    }
                    else
                       return "Password mora imati bar 1 numerik!";
                }
                else
                    return "Password mora imati bar 1 veliko slovo!";
            }else
                return "Password mora imati bar 3 mala slova!";
        }else
            return "Duzina passworda mora biti izmedju 8 i 12 karaktera!";
       
    }
    
    
    }

