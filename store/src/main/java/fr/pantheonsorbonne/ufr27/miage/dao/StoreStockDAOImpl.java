package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.StoreStock;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StoreStockDAOImpl implements StoreStockDAO {

    @PersistenceContext
    EntityManager em;

    public StoreStock get (int storeStockID) {
        return em.find(StoreStock.class, storeStockID);
    }
}