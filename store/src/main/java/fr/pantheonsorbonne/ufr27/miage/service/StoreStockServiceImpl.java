package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.StoreStockDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class StoreStockServiceImpl implements StoreStockService {

    @Inject
    StoreStockDAO storeStock;
    @Inject
    ProductService productService;


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.storeId")
    Integer storeId;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.quantity")
    Integer quantity;


    @Override
    public StoreStockDTO getStockFromProductByID(int id) {
        return new StoreStockDTO(storeId, storeStock.getAmmountOfProducts(id));
    }

    @Override
    public void updateStockOfProduct(ProductDTO p) {
        storeStock.updateStockOfProduct(p.getName(), quantity);
    }

    @Override
    public void quantityScheduler() {
        storeStock.updateStockOfProduct("avocado", -5);
    }
}