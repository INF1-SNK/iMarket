package fr.pantheonsorbonne.ufr27.miage.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Map;

@XmlRootElement
public class CommandDTO {
    private ProductDTO productDTO;

    private Integer quantity;


    public CommandDTO(ProductDTO productDTO, Integer quantity) {
        this.productDTO = productDTO;
        this.quantity = quantity;
    }

    public CommandDTO() {
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
