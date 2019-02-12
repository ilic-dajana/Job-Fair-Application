/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Konkurs;
import beans.User;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.Return;
import util.SessionUtils;

/**
 *
 * @author dajana
 */
@ManagedBean(name = "ControllerPage")
@SessionScoped
public class ControllerPage {
    private String message;

    public static String admin(){
        return "registracijaAdministrator?faces-redirect=true";
    }
    public static String student(){
        return "registracijaStudent?faces-redirect=true";
    }
    public static String studentPage(){
        return "studentPage?faces-redirect=true";
    }
    public static String kompanija(){
        return "registracijaKompanija?faces-redirect=true";
    }
    public static String home(){
        return "index?faces-redirect=true";
    }
     public static String kompanijaPage(){
        return "kompanijaPage?faces-redirect=true";
    }
    public static String login(){
         return "login?faces-redirect=true";
    }
    public static String rezultatikonkursa(){
         return "rezultatikonkursa?faces-redirect=true";
    }
    public static String prijavanakonkurs(){        
         return "prijavakonkurs?faces-redirect=true";
    }
    public static String prijaveStudenata(){
         return "prijaveStudenata?faces-redirect=true";
    }
    public static String CV(){
        return "studentCVUpload?faces-redirect=true";
    }
    public static String CVdata(){
        return "pregledCV?faces-redirect=true";
    }
    public static String checkAdmin(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
           tx = session.beginTransaction();
           String sqlquery="FROM User WHERE username=:username ";
           Query q = session.createQuery(sqlquery);
           q.setString("username", username);
           List<User> users= q.list();
           
           sqlquery="FROM Administrator WHERE id=:id";
           Query q1 = session.createQuery(sqlquery);
           q1.setInteger("id", users.get(0).getId());
           boolean bool = (q1.uniqueResult() != null);
           if(bool)
               return "adminPage?faces-redirect=true";
          
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        } 
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Administrator ne postoji u bazi", null));
        return  null;
    }
    public static String checkStudent(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
           tx = session.beginTransaction();
           String sqlquery="FROM User WHERE username=:username ";
           Query q = session.createQuery(sqlquery);
           q.setString("username", username); 
           List<User> users= q.list();
         
           sqlquery="FROM Student WHERE id=:id";
           Query q1 = session.createQuery(sqlquery);
           q1.setInteger("id", users.get(0).getId());
           boolean bool = (q1.uniqueResult() != null);
           if(bool)
               return "studentPage?faces-redirect=true";
          
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        } 
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Student ne postoji u bazi", null));
        return  null;
    }
     public static String checkKompanija(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
           tx = session.beginTransaction();
           String sqlquery="FROM User WHERE username =:username ";
           Query q = session.createQuery(sqlquery);
           q.setString("username", username);      
           List<User> users= q.list();
         
           sqlquery="FROM Kompanija WHERE id=:id";
           Query q1 = session.createQuery(sqlquery);
           q1.setInteger("id", users.get(0).getId());
           boolean bool = (q1.uniqueResult() != null);
           if(bool)
               return "kompanijaPage?faces-redirect=true";
          
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        } 
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kompanija ne postoji u bazi", null));
        return  null;
    }
     
      private static void pageError() {
        String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/faces/login.xhtml");
       } catch (IOException e) {
            e.printStackTrace();
        }
}
     
     public static void authAdmin(){
         User user = SessionUtils.getUser();
         if(user == null || user.getAdministrator() == null)
             pageError();
     }
     public static void authStudent(){
         User user = SessionUtils.getUser();
         if(user == null || user.getStudent()== null)
             pageError();
     }
     public static void authKompanija(){
         User user = SessionUtils.getUser();
         if(user == null || user.getKompanija() == null)
             pageError();
     }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
     
     
}
