package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;

public interface StoreStockService {

    StoreStockDTO getStockFromProductByID(int id);

    void updateStockOfProduct(ProductDTO p);

    void quantityScheduler();
}
