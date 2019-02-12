/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

import beans.Biografija;
import beans.Jezici;
import beans.Kompanija;
import beans.Konkurs;
import beans.Obrazovanje;
import beans.Ocenjivanje;
import helpers.Ocena;
import beans.Prijavanakonkurs;
import beans.WebSites;
import beans.Zaposlenje;
import helpers.Education;
import helpers.PrijaveStudenti;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.SessionUtils;
/**
 *
 * @author dajana
 */
public class StudentDao {
   
    public static boolean unesiCV(String ime, String prezime, String communication, String organisation, String skills, List<Education> obrazovanja,
            List<Education> poslovi, String adresa, Integer postanskiBr, String grad, String drzava, String telefon, List<String> webSites, List<String> maternjiJezik, List<String> straniJezik) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
            Biografija bio = (Biografija) session.get(Biografija.class, SessionUtils.getUser().getStudent().getId());
            
            if(bio == null)
                bio = new Biografija();
            
            bio.setStudent(SessionUtils.getUser().getStudent());
            bio.setAdresa(adresa);
            bio.setCommunicationSkills(communication);
            bio.setDrzava(drzava);
            bio.setGrad(grad);
            bio.setIme(ime);
            bio.setPostanskiBr(postanskiBr);
            bio.setTelefon(telefon);
            bio.setJobrelatedSkills(skills);
            bio.setPrezime(prezime);
            bio.setOrganisationalSkills(organisation);
            
            List<Zaposlenje> zaposlenje = new ArrayList<Zaposlenje>();
            Education p ;
            for(int i = 0; i < poslovi.size(); i++){
               p=poslovi.get(i);
               zaposlenje.add(new Zaposlenje(bio,p.getDateOd(), p.getDateDo(),p.getOnGoing() ,p.getPozicija(), p.getFakultet()));
            }
            List<Obrazovanje> skole = new ArrayList<>();
            for(int i = 0; i < obrazovanja.size(); i++){
               p=obrazovanja.get(i);
               skole.add(new Obrazovanje(bio,p.getDateOd(), p.getDateDo(), p.getOnGoing(), p.getStepen(), p.getFakultet()));
            }
            List<WebSites> sajt = new ArrayList<>();
            for(int i = 0; i< webSites.size(); i++){
                sajt.add(new WebSites(bio, webSites.get(i)));
            }
            List<Jezici> jezik = new ArrayList<>();
            for(int i = 0; i < maternjiJezik.size(); i++){
                jezik.add(new Jezici(bio, maternjiJezik.get(i), "maternji"));
            }
            for(int i = 0; i < straniJezik.size(); i++){
                jezik.add(new Jezici(bio, straniJezik.get(i), "strani"));
            }            
            session.saveOrUpdate(bio);
            for(Zaposlenje z: zaposlenje)
                session.saveOrUpdate(z);
            for(Jezici j: jezik)
                session.saveOrUpdate(j);
            for(Obrazovanje o: skole)
                session.saveOrUpdate(o);
            for(WebSites wb: sajt)
                session.saveOrUpdate(wb);
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

    public static boolean proveriCV() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String upit = "from Biografija where idstudent=:s";
            Query q = session.createQuery(upit);
            q.setInteger("s", SessionUtils.getUser().getId());
            boolean b = (q.uniqueResult() != null);
            tx.commit();
            return b;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return false;
        }finally{
            session.close();
         }
        
    }


    public static Biografija dohBiografiju() {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String upit = "from Biografija where idstudent=:s";
            Query q = session.createQuery(upit);
            q.setInteger("s", SessionUtils.getUser().getId());
            Biografija b = (Biografija) q.uniqueResult();
            tx.commit();
            return b;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
         }
    }

    public static List<String> dohSajtove(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String upit = "from WebSites where idcv=:s";
            Query q = session.createQuery(upit);
            q.setInteger("s", id);
            List<String> b =new ArrayList<>();
            List<WebSites> web  = q.list();
            for(WebSites w: web)
                b.add(w.getWeb());
            tx.commit();
            return b;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
         }
    }

    public static List<Education> dohObrazovanja(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String upit = "from Obrazovanje where idBio=:s";
            Query q = session.createQuery(upit);
            q.setInteger("s", id);
            List<Education> b =new ArrayList<>();
            List<Obrazovanje> web  = q.list();
            for(Obrazovanje w: web)
                b.add(new Education(w.getDateod(), w.getDatedo(), w.getOnGoing(), w.getStepen(), w.getFakultet()));
            tx.commit();
            return b;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
         }
    }

    public static List<Education> dohPoslovi(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String upit = "from Zaposlenje where idbio=:s";
            Query q = session.createQuery(upit);
            q.setInteger("s", id);
            List<Education> b =new ArrayList<>();
            List<Zaposlenje> web  = q.list();
            for(Zaposlenje w: web)
                b.add(new Education(w.getDateOd(), w.getDateDo(), w.getOnGoing(), w.getPozicija(), w.getFirma()));
            tx.commit();
            return b;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
         }    }

    public static List<String> dohStrani(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String upit = "from Jezici where idCV=:s and tip=:t";
            Query q = session.createQuery(upit);
            q.setInteger("s", id);
            q.setString("t", "strani");
            List<String> b =new ArrayList<>();
            List<Jezici> web  = q.list();
            for(Jezici w: web)
                b.add(w.getJezik());
            tx.commit();
            return b;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
         }
    }

    public static List<String> dohMaternji(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String upit = "from Jezici where idCV=:s and tip=:t";
            Query q = session.createQuery(upit);
            q.setInteger("s", id);
            q.setString("t", "maternji");
            List<String> b =new ArrayList<>();
            List<Jezici> web  = q.list();
            for(Jezici w: web)
                b.add(w.getJezik());
            tx.commit();
            return b;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
         }   
    }

    public static boolean prijaviKonkurs(Konkurs k, String c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Date d1 = k.getRok();
            Date danas = Calendar.getInstance().getTime();
            if(danas.after(d1))
                return false;
            String upit = "from Prijavanakonkurs where idcv=:st and idkonkurs=:k";
            Query q = session.createQuery(upit);
            q.setInteger("k", k.getId());
            q.setInteger("st", SessionUtils.getUser().getId());            
            if((q.uniqueResult()!=null))
                return false;
            
            Biografija b = dohBiografiju();            
            Prijavanakonkurs prijava = new Prijavanakonkurs(b,k,"cekanje",c);   
            session.save(prijava);
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

    public static List<PrijaveStudenti> dohvatiPrijave() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List<PrijaveStudenti> prijavemoje = new ArrayList<>();
           
            String upit = "FROM Prijavanakonkurs WHERE idcv=:d";
            Query q = session.createQuery(upit);
            q.setInteger("d", SessionUtils.getUser().getId());
            List<Prijavanakonkurs> mojikonkursi = q.list();                      
            Date danas = new Date();
            List<Prijavanakonkurs> rezultat = new ArrayList<>();
            
            for(Prijavanakonkurs p:mojikonkursi){
                Hibernate.initialize(p.getKonkurs());
                if(danas.after(p.getKonkurs().getRok()))
                    rezultat.add(p);
            }
            
            for(Prijavanakonkurs k: rezultat){
                Hibernate.initialize(k.getKonkurs());
                Hibernate.initialize(k.getBiografija());
                
                upit = "From Prijavanakonkurs where idkonkurs=:konk";
                q = session.createQuery(upit);
                q.setInteger("konk", k.getKonkurs().getId());                
                List<Prijavanakonkurs> studentKonkurs = q.list();               
                for(Prijavanakonkurs s: studentKonkurs){
                   PrijaveStudenti p = new PrijaveStudenti();
                   p.setKonkurs(k.getKonkurs().getPozicija());
                   p.setIme(s.getBiografija().getIme() +" " + s.getBiografija().getPrezime());
                   p.setStatus(s.getStatus());
                   p.setKonkurs(k.getKonkurs().getPozicija());
                   prijavemoje.add(p);
                }
            }
            tx.commit();
            return prijavemoje;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
            session.close();
         }
    }

    public static List<Ocena> ocenjivanje() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List<Zaposlenje> ocenjivanje ;   
            List<Ocena> rezultat = new ArrayList<>();
            String upit = "From Zaposlenje where idbio=:d and on_going=:g";
            Query q = session.createQuery(upit);
            q.setInteger("d", SessionUtils.getUser().getId());
            q.setString("g", "da");
            ocenjivanje = q.list();
            tx.commit();
            for(Zaposlenje z:ocenjivanje){
                Hibernate.initialize(z.getFirma());
                rezultat.add(new Ocena(z.getFirma(), ""));
            }
            return rezultat;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
           session.close();
         }   
    }

    public static List<Ocena> dohOcenjeno() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
           tx = session.beginTransaction();
           List<Ocenjivanje> izbaze;
           String upit ="From Ocenjivanje where idstudent=:d";
           Query q = session.createQuery(upit);
           q.setInteger("d", SessionUtils.getUser().getId());
           izbaze = q.list();
           List<Ocena> rezultat = new ArrayList<>();
           
           for(Ocenjivanje o: izbaze){
              Ocena oc = new Ocena(o.getNaziv(), o.getOcena());
              rezultat.add(oc);
           }           
           tx.commit();
           return rezultat;
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return null;
        }finally{
           session.close();
         }   
    }
    

    public static void unesiOcene(List<Ocena> ocenjivanje) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
           tx = session.beginTransaction();
           
           for(Ocena o: ocenjivanje){
               Ocenjivanje oc = new Ocenjivanje(o.getFirma(), SessionUtils.getUser().getId(), o.getRating());
               session.save(oc);
           }           
           tx.commit();
        }catch(Exception e){
            if(tx!= null)
                tx.rollback();
            e.printStackTrace();
            return ;
        }finally{
           session.close();
         }   
    }
}
