/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

import beans.Kompanija;
import beans.Konkurs;
import beans.Prijavanasajam;
import helpers.KompanijaKonkurs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.SessionUtils;

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
    
    public static ArrayList<Konkurs> dodajKonkurse(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            ArrayList<Konkurs> konkursi = new ArrayList<>();

            String sqlquery="FROM Konkurs WHERE idkonkurs=:d0";           
            Query q = session.createQuery(sqlquery);
            q.setInteger("d0", id);

            konkursi = (ArrayList<Konkurs>) q.list();


            tx.commit();
            return konkursi;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
         }
    
    }
    public static boolean otvoriKonkurs(Kompanija k, String tip, String pozicija, String opis,Date datumIsteka){
 
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = null;
       try{           
           Konkurs konkurs = new Konkurs(k ,  pozicija, tip,  datumIsteka,  opis) ;   
           
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
    
    public static boolean prijaviSajam(String paket){
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = null;
       try{
           tx = session.beginTransaction();

           String upit = "SELECT user.id From User user WHERE user.username=:username";
           Query q = session.createQuery(upit);
           q.setString("username", SessionUtils.getUserName() );
           Integer id = (Integer) q.uniqueResult();
           
           if(id!= null){
              Prijavanasajam sajam = (Prijavanasajam) session.get(Prijavanasajam.class, id );
              sajam.setTipprijave(paket);
              sajam.setStatus("Cekanje");
              session.update(sajam);
              tx.commit();  
           }else
               return false;
           
           
               
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

    public static List<KompanijaKonkurs> pretraziKonkurse(String pozicija, String tipPretrageKonkursa) {
         Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = null;
       try{
           tx = session.beginTransaction();
           List<KompanijaKonkurs> konacnaLista = new ArrayList<>();
           String upit = "From Konkurs where pozicija  LIKE :p and tipKonkurs=:tip";
           Query q = session.createQuery(upit);
           q.setString("p", "%" + pozicija + "%");
           q.setString("tip", tipPretrageKonkursa);
                   
           List<Konkurs> konkursi = q.list();
           Konkurs k;
           for(int i = 0; i < konkursi.size(); i++){
               k = konkursi.get(i);
               Kompanija kompanija = (Kompanija) session.get(Kompanija.class, k.getKompanija().getId());
               KompanijaKonkurs o = new KompanijaKonkurs(kompanija, k);
               konacnaLista.add(o);
           }
           return konacnaLista;
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
