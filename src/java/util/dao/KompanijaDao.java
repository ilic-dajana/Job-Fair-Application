/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

import beans.Kompanija;
import beans.Konkurs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author dajana
 */
public class KompanijaDao {
    
    public static List<Kompanija> pretraziKompanijePoImenu(String name){
         Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = null;
       try{
           tx = session.beginTransaction();
           String sqlquery="FROM Kompanija WHERE naziv LIKE :pattern";
           Query q = session.createQuery(sqlquery);
           q.setString("pattern", "%" + name + "%");
           List<Kompanija> kompanije = q.list() ;
           tx.commit();
           return kompanije;
       }catch(Exception e){
           if(tx!= null)
               tx.rollback();
           e.printStackTrace();
           return null;
       }finally{
           session.close();
       }    
    }
    
      public static List<Kompanija> pretraziKompanijePoGradu(String name){
         Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = null;
       try{
           tx = session.beginTransaction();
           String sqlquery="FROM Kompanija WHERE grad LIKE :pattern";
           Query q = session.createQuery(sqlquery);
           q.setString("pattern", "%" + name + "%");
           List<Kompanija> kompanije = q.list() ;
           tx.commit();
           return kompanije;
       }catch(Exception e){
           if(tx!= null)
               tx.rollback();
           e.printStackTrace();
           return null;
       }finally{
           session.close();
       }    
    }
      
    public static List<Kompanija> pretraziKompanijePoDelatnosti(String[] delatnosti){
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = null;
       try{
          List<Kompanija> kompanije = new ArrayList<>();
           
          tx = session.beginTransaction();
          for(int i =0; i<delatnosti.length; i++){
           String sqlquery="FROM Kompanija WHERE delatnost= :d0";
           Query q = session.createQuery(sqlquery);
           q.setString("d0", delatnosti[i]);
           kompanije.addAll(q.list());
          }        
                         
           tx.commit();
           return kompanije;
       }catch(Exception e){
           if(tx!= null)
               tx.rollback();
           e.printStackTrace();
           return null;
       }finally{
           session.close();
       }    
    }
    
    public static boolean otvoriKonkurs(String tip, String pozicija, String opis,Date datumIsteka){
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = null;
       try{
           Konkurs konkurs = new Konkurs( tip,  pozicija,  datumIsteka,  opis) ;
        
           tx = session.beginTransaction();
           session.save(konkurs);
                                             
           tx.commit();
           return true;
       }catch(Exception e){
           if(tx!= null)
               tx.rollback();
           e.printStackTrace();
           return false;
       }finally{
           session.close();
       }    
    }
}
