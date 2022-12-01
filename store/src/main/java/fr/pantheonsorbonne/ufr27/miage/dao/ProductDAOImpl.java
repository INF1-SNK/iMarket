package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Product;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@RequestScoped
public class ProductDAOImpl implements ProductDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;


    @Override
    public Product createNewProduct(String name, String type, double price) {
        Product p = new Product(name,type,price);
        em.persist(p);
        return p;
    }

    @Override
    public Collection<Product> getAllProducts(String id) {
            Product products = em.find(Product.class, id);
        return (Collection<Product>) products;
    }

}