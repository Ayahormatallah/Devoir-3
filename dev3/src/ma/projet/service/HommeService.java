/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;



/**
 *
 * @author ADMIN
 */


import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.beans.*;

import ma.projet.util.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HommeService implements IDao<Homme> {

    @Override
    public boolean create(Homme o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    

    

  public List<Homme> getAll(Homme o) {
        List<Homme> hommes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            hommes= session.createQuery("from Homme").list();
            tx.commit();
            return hommes;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return hommes;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public Homme getById(int id) {
        Homme homme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            homme = (Homme) session.get(Homme.class, id);
            tx.commit();
            return homme;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return homme;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

     @Override
    public List<Homme> getAll() {
        List<Homme> homme = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        homme = session.createQuery("from Homme").list();
        session.getTransaction().commit();
        return homme;
    }

}



