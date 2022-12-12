package fr.pantheonsorbonne.ufr27.miage.dto;

public class ProductDTO {
    String name;
    String type;
    double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductDTO() {
    }

    public ProductDTO(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
