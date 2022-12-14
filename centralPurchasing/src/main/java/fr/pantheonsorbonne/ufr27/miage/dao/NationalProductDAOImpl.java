package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.NationalProduct;
import fr.pantheonsorbonne.ufr27.miage.model.Quantity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class NationalProductDAOImpl implements NationalProductDAO {

    @Inject
    EntityManager em;

    @Transactional
    @Override
    public NationalProduct findByName(String name) {
        return (NationalProduct) em.createQuery("SELECT p FROM NationalProduct p WHERE p.name = ?1").setParameter(1, name).getResultList().get(0);
    }

    @Override
    public int checkProductQuantity(String name) {
        NationalProduct nationalProduct = findByName(name);
        Quantity q = nationalProduct.getQuantity();
        return q.getQuantity();
    }

    @Transactional
    @Override
    public void refreshQty(String name, int qty) {
        NationalProduct nationalProduct = findByName(name);
        Quantity q = nationalProduct.getQuantity();
        int base = q.getQuantity();
        q.setQuantity(base-qty);
        nationalProduct.setQuantity(q);
        em.persist(nationalProduct);
        em.flush();
    }
}
