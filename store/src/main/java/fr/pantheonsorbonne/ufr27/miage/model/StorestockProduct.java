package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "StoreStock_Product")
public class StorestockProduct {
    @EmbeddedId
    private StorestockProductId id;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public StorestockProductId getId() {
        return id;
    }

    public void setId(StorestockProductId id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}