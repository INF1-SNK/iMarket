package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "StoreStock_Product")
public class StorestockProduct {
    @EmbeddedId
    private StorestockProductId id;

    @MapsId("storestockId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "storestock_id", nullable = false)
    private StoreStock storestock;

    @MapsId("productId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public StorestockProductId getId() {
        return id;
    }

    public void setId(StorestockProductId id) {
        this.id = id;
    }

    public StoreStock getStorestock() {
        return storestock;
    }

    public void setStorestock(StoreStock storestock) {
        this.storestock = storestock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}