package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Product;

import java.util.Collection;

public interface ProductDAO {

    Product createNewProduct(String name, String type, double price);
    Product getProductByID(String id);

}
