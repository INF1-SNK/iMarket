package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;

import java.util.Map;

public interface StockService {

    public Map<String, Integer> verifyStock(StoreStockDTO storeStockDTO);

}