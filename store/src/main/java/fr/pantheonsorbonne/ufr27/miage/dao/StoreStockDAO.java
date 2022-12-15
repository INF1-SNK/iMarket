package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.StoreStock;

import javax.transaction.Transactional;
import java.util.Map;

public interface StoreStockDAO {

    StoreStock get(int storeStockID);
    Map<String, Integer> getAmmountOfProducts(int storeStockID);
    @Transactional
    void updateStockOfProduct(String productName, int qty);

    int getStockOfProduct(String productName);
}