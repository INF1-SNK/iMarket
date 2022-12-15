package fr.pantheonsorbonne.ufr27.miage.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StockCheckDAOImpl implements StockCheckDAO {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public Map<Integer, Integer> getProductFromNationalStock(int id) {
        Map<Integer, Integer> productWithQuantity = new HashMap<>();
        List<Objects[]> objectsList = em.createNativeQuery("SELECT p.id, count(*) FROM NationalStock ns, Product p WHERE ns.id = p.nationalstock_id AND ns.id = ?1 GROUP BY p.id")
                .setParameter(1, id)
                .getResultList();

        for (Object[] o : objectsList) {
            productWithQuantity.put(Integer.valueOf(o[0].toString()), Integer.valueOf(o[1].toString()));
        }

        return productWithQuantity;
    }

    /**@Override
    @Transactional
    public void decreaseProduct(int idProduct){
        em.createQuery("UPDATE Product p SET p.quantity")
    }**/
}