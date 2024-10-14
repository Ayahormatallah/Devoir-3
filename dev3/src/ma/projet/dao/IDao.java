package ma.projet.dao;

import java.util.List;

public interface IDao<T> {
    boolean create(T t);     // Créer une entité
    T getById(int id);       // Récupérer une entité par son ID
    List<T> getAll();        // Récupérer toutes les entités
}
