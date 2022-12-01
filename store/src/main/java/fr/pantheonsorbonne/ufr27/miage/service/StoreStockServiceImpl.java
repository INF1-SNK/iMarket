package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.StoreStockDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import javax.inject.Inject;
import java.util.Collection;

public class StoreStockServiceImpl implements StoreStockService {

    @Inject
    StoreStockDAO storeStock;


    @Override
    public StoreStockDTO getStockFromProductByID(int id) {
        Collection<Product> productCollection = (Collection<Product>) storeStock.get(id).getProducts();
        return (StoreStockDTO) productCollection;   
    }
}