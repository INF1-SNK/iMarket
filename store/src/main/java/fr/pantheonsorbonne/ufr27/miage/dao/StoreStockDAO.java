package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.StoreStock;

import java.util.Map;

public interface StoreStockDAO {

    StoreStock get(int storeStockID);
    Map<String, Integer> getAmmountOfProducts(int storeStockID);
}