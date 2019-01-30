/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

import beans.Kompanija;
import java.util.ArrayList;
import java.util.Collection;
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
      
         public static List<Kompanija> pretraziKompanijePoDelatnosti(String name){
         Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = null;
       try{
           tx = session.beginTransaction();
           String sqlquery="FROM Kompanija WHERE delatnost LIKE :pattern";
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
}
