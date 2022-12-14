package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.ProductDTO;

public interface ProductService {

    ProductDTO getProductById(String id);

    ProductDTO getRandomProduct();

}
