package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.ProductDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    @Inject
    ProductDAO productDAO;

    @Override
    public ProductDTO getProductById(String id) {
         Product p = productDAO.getProductByID(id);
         return new ProductDTO(p.getName(), p.getType(), p.getPrice());
    }
}
