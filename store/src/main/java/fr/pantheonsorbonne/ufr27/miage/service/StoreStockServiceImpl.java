package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.StoreStockDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

<<<<<<< HEAD
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
=======
import javax.inject.Inject;
import java.util.Collection;

>>>>>>> ceb28d335ee739c36373c50ec8dc073ed6c4aed2
public class StoreStockServiceImpl implements StoreStockService {

    @Inject
    StoreStockDAO storeStock;


    @Override
    public StoreStockDTO getStockFromProductByID(int id) {
<<<<<<< HEAD

        return new StoreStockDTO(1, storeStock.getAmmountOfProducts(id));
=======
        Collection<Product> productCollection = (Collection<Product>) storeStock.get(id).getProducts();
        return (StoreStockDTO) productCollection;   
>>>>>>> ceb28d335ee739c36373c50ec8dc073ed6c4aed2
    }
}