package fr.pantheonsorbonne.ufr27.miage.dto;

import java.util.Collection;
import java.util.Map;

public class CommandDTO {
    private Map<ProductDTO, Integer> products;

    public CommandDTO(Map<ProductDTO, Integer> products) {
        this.products = products;
    }

    public CommandDTO() {
    }

    public Map<ProductDTO, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDTO, Integer> products) {
        this.products = products;
    }
}
