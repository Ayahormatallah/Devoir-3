/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.beans.Femme;

import ma.projet.util.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FemmeService implements IDao<Femme> {

    @Override
    public boolean create(Femme o) {
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

    

    @Override
    public Femme getById(int id) {
        Femme femme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femme = (Femme) session.get(Femme.class, id);
            tx.commit();
            return femme;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return femme;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

     @Override
    public List<Femme> getAll() {
        List<Femme> femme = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        femme = session.createQuery("from Femme").list();
        session.getTransaction().commit();
        return femme;
    }

}


