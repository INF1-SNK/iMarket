package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;

import java.util.Collection;

public interface StockService {

     void verifyStock(StoreStockDTO storeStockDTO);
     void sendProducts(Collection<ProductDTO> product);

    void sendFromVendor(ProductDTO p, int qty);

    void sendFromStock(ProductDTO p);
}