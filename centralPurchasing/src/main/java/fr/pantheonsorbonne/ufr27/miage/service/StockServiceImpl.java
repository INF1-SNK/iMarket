package fr.pantheonsorbonne.ufr27.miage.service;


import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;


@ApplicationScoped
public class StockServiceImpl implements StockService {

    @Inject
    StoreStockDTO storeStock;

    @Override
    public Map<String, Integer> verifyStock(StoreStockDTO storeStock) {
        Map<String, Integer> products = storeStock.getProducts();
        Map<String, Integer> productWithGoodQuantity = null;

        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if(entry.getValue() > 100 ) {
                productWithGoodQuantity.put(entry.getKey(), entry.getValue());
            }
            else {
                //TODO : implémenter lorsque la quantité est infèrieure à 100
            }
        }
        return productWithGoodQuantity;
    }
}