package ma.projet.service;

import ma.projet.beans.Mariage;
import ma.projet.dao.IDao;
import ma.projet.util.NewHibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class MariageService implements IDao<Mariage> {

    @Override
    public boolean create(Mariage mariage) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(mariage); // Sauvegarder l'objet Mariagedans la base de données
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Mariage getById(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Mariage mariage = (Mariage) session.get(Mariage.class, id); // Récupérer une Mariagepar son ID
        session.close();
        return mariage;
    }

     @Override
    public List<Mariage> getAll() {
        List<Mariage> mariage = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        mariage = session.createQuery("from Mariage").list();
        session.getTransaction().commit();
        return mariage;
    }}