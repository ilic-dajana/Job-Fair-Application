/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import beans.DatumZaCv;
import beans.DatumZaSajam;
/**
 *
 * @author dajana
 */
public class DatumDao {
    
    public static boolean unesiDatum(Date date){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();            
            
            tx.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }

    public static boolean unesiDatume(Date datumOd, Date datumDo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            DatumZaCv cv = (DatumZaCv) session.get(DatumZaCv.class, 0);
            cv.setDatumKraj(datumDo);
            cv.setDatumPocetak(datumOd);
            session.update(cv);
            tx.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }
    
    public static boolean unesiDatumeSajam(Date datumOd, Date datumDo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            DatumZaSajam cv = (DatumZaSajam) session.get(DatumZaSajam.class, 0);
            cv.setDatumKraj(datumDo);
            cv.setDatumPocetak(datumOd);
            session.update(cv);
            tx.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }
    public static boolean proveriDatumeSajam(Date datum) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            DatumZaSajam cv = (DatumZaSajam) session.get(DatumZaSajam.class, 0);
            Date begin = cv.getDatumPocetak();
            Date end = cv.getDatumKraj();
            if(!datum.before(begin) && !datum.after(end)){
                return true;
            }
           
            tx.commit();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }
    
    public static boolean proveriDatumeCV(Date datum) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            DatumZaCv cv = (DatumZaCv) session.get(DatumZaCv.class, 0);
            Date begin =cv.getDatumPocetak();
            Date end = cv.getDatumKraj();
            if(!datum.before(begin) && !datum.after(end)){
                return true;
            }
           
            tx.commit();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }
    
}
