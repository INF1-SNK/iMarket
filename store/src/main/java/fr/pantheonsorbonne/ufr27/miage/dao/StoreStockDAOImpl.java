package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.StoreStock;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@ApplicationScoped
public class StoreStockDAOImpl implements StoreStockDAO {

    @PersistenceContext
    EntityManager em;

    public StoreStock get (int storeStockID) {
        return em.find(StoreStock.class, storeStockID);
    }

    @Transactional
    @Override
    public Map<String, Integer> getAmmountOfProducts(int storeStockID) {
        Map<String, Integer> result = new HashMap<>();
        List<Objects[]> objectsList = em.createNativeQuery("SELECT p.name, COUNT(*) AS number FROM StoreStock s, Product p, StoreStock_Product sp WHERE s.id = sp.storestock_id and p.id = sp.product_id and s.id = ?1 GROUP BY p.id")
                .setParameter(1, storeStockID)
                .getResultList();

        for (Object[] o : objectsList) {
            result.put(o[0].toString(), Integer.valueOf(o[1].toString()));
        }

        return result;
    }
}