/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

import beans.Kompanija;
import beans.Prijavanasajam;
import beans.Standovi;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import helpers.KompanijaSajam;

/**
 *
 * @author dajana
 */
public class AdminDao {
    
    public static ArrayList<KompanijaSajam> dodajKompanijeZaSajam(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            ArrayList<Prijavanasajam> k = new ArrayList<>();
            String u = "Cekanje";
            String sqlquery="From Prijavanasajam  WHERE status=:d0";          
            Query q = session.createQuery(sqlquery);
            q.setString("d0", u);
            
            ArrayList<KompanijaSajam> kompanijaSajam = new ArrayList<>();
            k = (ArrayList<Prijavanasajam>) q.list();
            Prijavanasajam komp;
            KompanijaSajam sajam;
            for(int i = 0; i < k.size(); i++){
                komp = k.get(i);
                sqlquery = "From Kompanija WHERE id=:d0";
                q = session.createQuery(sqlquery);
                q.setInteger("d0", komp.getIdkompanije());
                sajam = new KompanijaSajam();
                Kompanija kompanija = (Kompanija) q.uniqueResult();
                sajam.setK(kompanija);                
                sajam.setTip(komp.getTipprijave());
                kompanijaSajam.add(sajam);
            }


            tx.commit();
            return kompanijaSajam;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
         }
        
    }
    
    public static void ukloni(KompanijaSajam k){
          Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Prijavanasajam p = (Prijavanasajam) session.get(Prijavanasajam.class, k.getK().getId());
            p.setStatus("Odbijen");
            p.setKomentar(k.getKomentar());
            session.update(p);
            tx.commit();            
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();            
        }finally{
            session.close();
         }
    }
    
    public static void prihvati(KompanijaSajam k){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Prijavanasajam p = (Prijavanasajam) session.get(Prijavanasajam.class, k.getK().getId());
            p.setStatus("Prihvacen");
            p.setKomentar(k.getKomentar());
            session.update(p);
            tx.commit();            
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();            
        }finally{
            session.close();
         }
    }

    public static ArrayList<KompanijaSajam> dodajKompanijePrihvacene() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            ArrayList<Prijavanasajam> k = new ArrayList<>();
            String u = "Prihvacen";
            String sqlquery="From Prijavanasajam  WHERE status=:d0";          
            Query q = session.createQuery(sqlquery);
            q.setString("d0", u);
            
            ArrayList<KompanijaSajam> kompanijaSajam = new ArrayList<>();
            k = (ArrayList<Prijavanasajam>) q.list();
            Prijavanasajam komp;
            KompanijaSajam sajam;
            for(int i = 0; i < k.size(); i++){
                komp = k.get(i);
                sqlquery = "From Kompanija WHERE id=:d0";
                q = session.createQuery(sqlquery);
                q.setInteger("d0", komp.getIdkompanije());
                sajam = new KompanijaSajam();
                Kompanija kompanija = (Kompanija) q.uniqueResult();
                sajam.setK(kompanija);                
                sajam.setTip(komp.getTipprijave());
                kompanijaSajam.add(sajam);
            }


            tx.commit();
            return kompanijaSajam;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
         }
    }

    public static void dodajStand(Kompanija k, int id, String naziv, KompanijaSajam izabranStand) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Standovi s = new Standovi();
            s.setKompanija(k);
            s.setIme(izabranStand.getStand());
            s.setVreme(izabranStand.getVreme());
            s.setKompanijaIme(naziv);
            session.save(s);
            tx.commit();            
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();            
        }finally{
            session.close();
         }
    }

    
}
