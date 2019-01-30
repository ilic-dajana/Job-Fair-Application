package util.dao;

import beans.Administrator;
import beans.Kompanija;
import beans.Student;
import beans.User;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

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
   
    public static boolean unesiStudent(String username, String password, String ime, String prezime, 
                                     String telefon, String email, int godStudija, int diplomirao) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String pass = hasheFunc(password);
        User user = new User(username, pass);
        Student student = new Student(user, ime, prezime, telefon, email, godStudija, diplomirao);
        user.setStudent(student);
        try{
            tx = session.beginTransaction();
            session.save(student);
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
    
    public static boolean unesiAdministrator(String username, String password, String ime, String prezime, 
                                     String telefon, String email) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String pass = hasheFunc(password);
        User user = new User(username, pass);
        Administrator admin = new Administrator(user, ime, prezime, telefon, email);
        user.setAdministrator(admin);
        try{
            tx = session.beginTransaction();
            session.save(admin);
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
    
    public static boolean unesiKompaniju(String username, String password, String kompanija,String grad, String adresa, String ime, String prezime, 
                                     int PIB, int broj_zaposlenih, String email, String sajt, String delatnost, String specijalnost) throws SQLException{
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String pass = hasheFunc(password);
        User user = new User(username, pass);
        Kompanija kompan = new Kompanija(user, kompanija, adresa,ime, prezime, 
                                PIB, broj_zaposlenih, email, sajt, delatnost, specijalnost,grad);
       
         user.setKompanija(kompan);
        try{
            tx = session.beginTransaction();
            session.save(kompan);
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
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }
    
    public static boolean proveriKorisnika(String username, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String pass = hasheFunc(password);
        try{
           tx = session.beginTransaction();
           String sqlquery="FROM User WHERE username =:username AND password =:password";
           Query q = session.createQuery(sqlquery);
           q.setString("username", username);
           q.setString("password", pass);
           boolean exists = (q.uniqueResult() != null);
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
    
    
    }

