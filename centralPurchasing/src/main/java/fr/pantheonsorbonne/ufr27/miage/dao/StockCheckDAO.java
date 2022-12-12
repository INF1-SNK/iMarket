package fr.pantheonsorbonne.ufr27.miage.dao;

import java.util.Collection;
import java.util.Map;

public interface StockCheckDAO {

    Map<Integer, Integer> getProductFromNationalStock(int id);
}
