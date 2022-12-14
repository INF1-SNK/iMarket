package fr.pantheonsorbonne.ufr27.miage.service;


import fr.pantheonsorbonne.ufr27.miage.dao.NationalProductDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.StockCheckDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;
import org.apache.camel.CamelContext;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.*;


@ApplicationScoped
public class StockServiceImpl implements StockService {

    @Inject
    CamelContext camelContext;

    @Inject
    NationalProductDAO productDAO;

    @Override
    public void verifyStock(StoreStockDTO storeStock) {
        Map<String, Integer> products = storeStock.getProducts();
        Collection<ProductDTO> productDTOCollection = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if(entry.getValue() < 100 ) {
                productDTOCollection.add(new ProductDTO(entry.getKey(),
                        productDAO.findByName(entry.getKey()).getType(),
                        productDAO.findByName(entry.getKey()).getPrice()));
            }
        }
        sendProducts(productDTOCollection);
    }

    @Override
    public void sendProducts(Collection<ProductDTO> product){
        if(!product.isEmpty()) {
            for (ProductDTO p :
                    product) {
                if (productDAO.checkProductQuantity(p.getName()) > 200) {
                    camelContext.createProducerTemplate().sendBody("direct:sendCommandToStore", p);
                    productDAO.refreshQty(p.getName(), 200);
                } else {
                    camelContext.createProducerTemplate().sendBody("direct:sendCommandToVendor", p);
                }
            }
        }
    }
}